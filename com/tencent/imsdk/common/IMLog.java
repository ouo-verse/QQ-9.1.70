package com.tencent.imsdk.common;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes7.dex */
public class IMLog {
    public static final int LOG_LEVEL_DEBUG = 3;
    public static final int LOG_LEVEL_ERROR = 6;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_OFF = 0;
    public static final int LOG_LEVEL_VERBOSE = 2;
    public static final int LOG_LEVEL_WARN = 5;
    private static final String TAG = "IMLog";

    public static void d(String str, String str2) {
        log(3, str, str2);
    }

    public static void e(String str, String str2) {
        log(6, str, str2);
    }

    public static void i(String str, String str2) {
        log(4, str, str2);
    }

    private static void log(int i3, String str, String str2) {
        if (!SystemUtil.loadIMLibrary()) {
            Log.e(TAG, "libimsdk.so is not loaded");
            return;
        }
        if (i3 >= 0 && i3 <= 6) {
            if (TextUtils.isEmpty(str)) {
                e(TAG, "empty logTag");
                return;
            } else if (TextUtils.isEmpty(str2)) {
                e(TAG, "empty logContent");
                return;
            } else {
                nativeWriteLog(i3, str, "", 0, str2);
                return;
            }
        }
        e(TAG, "invalid logLevel\uff1a " + i3);
    }

    protected static native void nativeWriteLog(int i3, String str, String str2, int i16, String str3);

    public static void v(String str, String str2) {
        log(2, str, str2);
    }

    public static void w(String str, String str2) {
        log(5, str, str2);
    }

    public static void writeException(String str, String str2, Throwable th5) {
        if (!SystemUtil.loadIMLibrary()) {
            Log.e(TAG, "libimsdk.so is not loaded");
            return;
        }
        Log.e(str, str2 + " exception : " + Log.getStackTraceString(th5));
    }
}
