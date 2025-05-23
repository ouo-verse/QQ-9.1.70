package com.tencent.rfix.loader.so;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes25.dex */
public class SoConfigParser {
    public static final String SO_META_TXT = "so_meta.txt";
    private static final String TAG = "SoConfigParser";

    public static List<SoConfig> parseSoMeta(File file) {
        long nanoTime = System.nanoTime();
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split(",");
                SoConfig soConfig = new SoConfig();
                soConfig.oldSo = split[0].replace("\\", "/");
                soConfig.oldSoMD5 = split[1];
                soConfig.oldSoCRC = split[2];
                soConfig.diff = split[3].replace("\\", "/");
                soConfig.diffMD5 = split[4];
                soConfig.diffCRC = split[5];
                soConfig.newSoMD5 = split[6];
                arrayList.add(soConfig);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        Log.d(TAG, "parseSoMeta: cost time " + nanoTime2 + "ns(" + TimeUnit.NANOSECONDS.toMillis(nanoTime2) + "ms)");
        return arrayList;
    }
}
