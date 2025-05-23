package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes20.dex */
public class k {
    public static String a(Context context, String str) {
        return b(context.getAssets(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.io.InputStream] */
    public static String b(AssetManager assetManager, String str) {
        BufferedReader bufferedReader;
        Throwable th5;
        BufferedReader bufferedReader2;
        String str2 = null;
        try {
            try {
                assetManager = assetManager.open(str);
            } catch (IOException e16) {
                e = e16;
                assetManager = 0;
                bufferedReader2 = null;
            } catch (Throwable th6) {
                bufferedReader = null;
                th5 = th6;
                assetManager = 0;
            }
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(assetManager));
            } catch (IOException e17) {
                e = e17;
                bufferedReader2 = null;
            } catch (Throwable th7) {
                bufferedReader = null;
                th5 = th7;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e18) {
                        QLog.e("AssetsUtil", 1, "getContentFromAssets close input stream error, fileName:", str, e18);
                    }
                }
                if (assetManager != 0) {
                    try {
                        assetManager.close();
                        throw th5;
                    } catch (IOException e19) {
                        QLog.e("AssetsUtil", 1, "getContentFromAssets close content reader error, fileName:", str, e19);
                        throw th5;
                    }
                }
                throw th5;
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                }
                str2 = sb5.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException e26) {
                    QLog.e("AssetsUtil", 1, "getContentFromAssets close input stream error, fileName:", str, e26);
                }
                if (assetManager != 0) {
                    try {
                        assetManager.close();
                    } catch (IOException e27) {
                        QLog.e("AssetsUtil", 1, "getContentFromAssets close content reader error, fileName:", str, e27);
                    }
                }
            } catch (IOException e28) {
                e = e28;
                QLog.e("AssetsUtil", 1, "getContentFromAssets error, fileName:", str, e);
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e29) {
                        QLog.e("AssetsUtil", 1, "getContentFromAssets close input stream error, fileName:", str, e29);
                    }
                }
                if (assetManager != 0) {
                    try {
                        assetManager.close();
                    } catch (IOException e36) {
                        QLog.e("AssetsUtil", 1, "getContentFromAssets close content reader error, fileName:", str, e36);
                    }
                }
                return str2;
            }
            return str2;
        } catch (Throwable th8) {
            th5 = th8;
        }
    }
}
