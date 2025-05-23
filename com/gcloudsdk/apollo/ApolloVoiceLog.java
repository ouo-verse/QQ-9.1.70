package com.gcloudsdk.apollo;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ApolloVoiceLog {
    private static final int DEBUG = 1;
    private static final int DISABLE = 0;
    private static final int ERROR = 5;
    private static final int INFO = 2;
    private static String LOGTAG = "GVoiceAndroidLog";
    private static final int TRACE = 3;
    private static final int WARNING = 4;
    private static boolean enableLog = true;
    private static int logLevel = 2;

    public static void EnableLog(boolean z16) {
        enableLog = z16;
    }

    public static void LogD(String str) {
        if (enableLog && logLevel == 1) {
            Log.d(LOGTAG, str);
        }
    }

    public static void LogE(String str) {
        if (enableLog) {
            Log.e(LOGTAG, str);
        }
    }

    public static void LogI(String str) {
        if (enableLog && logLevel <= 2) {
            Log.i(LOGTAG, str);
        }
    }

    public static void LogW(String str) {
        if (enableLog && logLevel <= 4) {
            Log.w(LOGTAG, str);
        }
    }

    public static void SetLogLevel(int i3) {
        if (i3 > 0 && i3 <= 5) {
            logLevel = i3;
        }
    }
}
