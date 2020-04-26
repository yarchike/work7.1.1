package com.example.work711;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button bnt_synchronization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnt_synchronization = findViewById(R.id.bnt_synchronization);
        bnt_synchronization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SYNC);
                Date today = new Date();
                int hours = today.getHours();
                String i = String.valueOf(hours);

                if (hours >= 6 && hours < 14) {
                    Log.d("MyLog", "Утро");
                    intent.setData(Uri.parse("http://morning"));
                } else if (hours == 14) {
                    Log.d("MyLog", "Обед");
                    intent.setData(Uri.parse("http://afternoon"));
                } else {
                    Log.d("MyLog", "Вечер");
                    intent.setData(Uri.parse("http://evening"));
                }
                startActivity(intent);
            }
        });

    }
}
