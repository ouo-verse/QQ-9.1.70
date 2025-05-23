package com.tencent.xweb;

import android.content.SharedPreferences;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.ar.y0;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FileReaderCrashDetector {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f384895a = new Object();

    public static boolean isRecentCrashed(String str) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase();
            synchronized (f384895a) {
                SharedPreferences l3 = y0.l();
                if (l3 == null) {
                    x0.c("FileReaderCrashDetector", "isRecentCrashed sp is null");
                    return false;
                }
                long j3 = l3.getLong(lowerCase + "_count", 0L);
                long j16 = l3.getLong(lowerCase + "_time", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (j3 < 3 || currentTimeMillis - j16 >= 86400000) {
                    return false;
                }
                return true;
            }
        }
        x0.c("FileReaderCrashDetector", "isRecentCrashed fileExt is empty");
        return false;
    }

    public static void onFinish(String str) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase();
            synchronized (f384895a) {
                SharedPreferences l3 = y0.l();
                if (l3 == null) {
                    x0.c("FileReaderCrashDetector", "onFinish sp is null");
                    return;
                }
                SharedPreferences.Editor edit = l3.edit();
                if (edit == null) {
                    x0.c("FileReaderCrashDetector", "onFinish editor is null");
                    return;
                }
                edit.putLong(lowerCase + "_count", 0L);
                edit.putLong(lowerCase + "_time", System.currentTimeMillis());
                edit.commit();
                return;
            }
        }
        x0.c("FileReaderCrashDetector", "onFinish param is empty");
    }

    public static void onStart(String str) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase();
            synchronized (f384895a) {
                SharedPreferences l3 = y0.l();
                if (l3 == null) {
                    x0.c("FileReaderCrashDetector", "onStart sp is null");
                    return;
                }
                long j3 = l3.getLong(lowerCase + "_count", 0L);
                SharedPreferences.Editor edit = l3.edit();
                if (edit == null) {
                    x0.c("FileReaderCrashDetector", "onStart editor is null");
                    return;
                }
                edit.putLong(lowerCase + "_count", j3 + 1);
                edit.putLong(lowerCase + "_time", System.currentTimeMillis());
                edit.commit();
                return;
            }
        }
        x0.c("FileReaderCrashDetector", "onStart param is empty");
    }

    public static void resetCrashInfo(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            synchronized (f384895a) {
                SharedPreferences l3 = y0.l();
                if (l3 == null) {
                    x0.c("FileReaderCrashDetector", "resetCrashInfo sp is null");
                    return;
                }
                SharedPreferences.Editor edit = l3.edit();
                if (edit == null) {
                    x0.c("FileReaderCrashDetector", "resetCrashInfo editor is null");
                    return;
                }
                for (String str : strArr) {
                    if (str != null && !str.isEmpty()) {
                        String lowerCase = str.toLowerCase();
                        edit.remove(lowerCase + "_count");
                        edit.remove(lowerCase + "_time");
                    }
                }
                edit.commit();
            }
        }
    }
}
