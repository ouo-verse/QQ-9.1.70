package com.tencent.qqmusic.mediaplayer.util;

import android.util.Log;
import com.tencent.qqmusic.mediaplayer.ILog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Logger {
    private static ILog mILog = new ILog() { // from class: com.tencent.qqmusic.mediaplayer.util.Logger.1
        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void d(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void e(String str, String str2) {
            Log.e(str, str2);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void i(String str, String str2) {
            Log.i(str, str2);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void w(String str, String str2) {
            Log.w(str, str2);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void e(String str, Throwable th5) {
            Log.e(str, "an error occurred", th5);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void i(String str, String str2, Throwable th5) {
            Log.i(str, str2, th5);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void e(String str, String str2, Throwable th5) {
            Log.e(str, str2, th5);
        }

        @Override // com.tencent.qqmusic.mediaplayer.ILog
        public void e(String str, String str2, Object... objArr) {
            Log.e(str, String.format(str2, objArr));
        }
    };

    public static void d(String str, String str2) {
        ILog iLog = mILog;
        if (iLog != null) {
            iLog.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        ILog iLog = mILog;
        if (iLog != null) {
            iLog.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        ILog iLog = mILog;
        if (iLog != null) {
            iLog.i(str, str2);
        }
    }

    public static void setLog(ILog iLog) {
        mILog = iLog;
    }

    public static void w(String str, String str2) {
        ILog iLog = mILog;
        if (iLog != null) {
            iLog.w(str, str2);
        }
    }

    public static void e(String str, Throwable th5) {
        ILog iLog = mILog;
        if (iLog != null) {
            iLog.e(str, th5);
        }
    }

    public static void i(String str, String str2, Throwable th5) {
        ILog iLog = mILog;
        if (iLog != null) {
            iLog.i(str, str2, th5);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        ILog iLog = mILog;
        if (iLog != null) {
            iLog.e(str, str2, th5);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        ILog iLog = mILog;
        if (iLog != null) {
            iLog.e(str, str2, objArr);
        }
    }
}
