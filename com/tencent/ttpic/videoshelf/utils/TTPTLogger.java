package com.tencent.ttpic.videoshelf.utils;

import android.util.Log;

/* loaded from: classes27.dex */
public class TTPTLogger {
    private static boolean sNotShowAndroidLog = true;
    private static ITTPTLogger sTTPTLogger;

    public static void e(String str, String str2) {
        ITTPTLogger iTTPTLogger = sTTPTLogger;
        if (iTTPTLogger != null) {
            iTTPTLogger.e(str, str2);
        }
        if (sNotShowAndroidLog) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        ITTPTLogger iTTPTLogger = sTTPTLogger;
        if (iTTPTLogger != null) {
            iTTPTLogger.i(str, str2);
        }
        if (sNotShowAndroidLog) {
            Log.i(str, str2);
        }
    }

    public static void setLogger(ITTPTLogger iTTPTLogger) {
        sTTPTLogger = iTTPTLogger;
    }

    public static void setShowAndroidLog(boolean z16) {
        sNotShowAndroidLog = z16;
    }

    public static void w(String str, String str2) {
        ITTPTLogger iTTPTLogger = sTTPTLogger;
        if (iTTPTLogger != null) {
            iTTPTLogger.w(str, str2);
        }
        if (sNotShowAndroidLog) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, Throwable th5) {
        ITTPTLogger iTTPTLogger = sTTPTLogger;
        if (iTTPTLogger != null) {
            iTTPTLogger.e(str, th5);
        }
        if (th5 == null || !sNotShowAndroidLog) {
            return;
        }
        Log.e(str, th5.getMessage());
    }

    public static void e(String str, String str2, Throwable th5) {
        ITTPTLogger iTTPTLogger = sTTPTLogger;
        if (iTTPTLogger != null) {
            iTTPTLogger.e(str, str2, th5);
        }
        if (sNotShowAndroidLog) {
            Log.e(str, str2, th5);
        }
    }
}
