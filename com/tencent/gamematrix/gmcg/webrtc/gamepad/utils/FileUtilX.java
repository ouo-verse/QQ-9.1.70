package com.tencent.gamematrix.gmcg.webrtc.gamepad.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FileUtilX {
    public static boolean isFilesDirFile(Context context, String str) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + str).isFile();
    }

    public static String readAssetFile(Context context, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            String str2 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str2 = str2 + readLine;
                } else {
                    return str2;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static String readFilesDirFile(Context context, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(context.getFilesDir().getAbsolutePath() + File.separator + str)));
            String str2 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    str2 = str2 + readLine;
                } else {
                    return str2;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }
}
