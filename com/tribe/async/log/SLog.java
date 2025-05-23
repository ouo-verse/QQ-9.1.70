package com.tribe.async.log;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SLog {
    public static final String LOG_TAG = "async";
    public static final String LOG_TAG_BOSS = "async.boss";
    public static final String LOG_TAG_DISPATCH = "async.dispatch";
    private static IQLog mIQLog;

    SLog() {
    }

    public static void a(String str, String str2) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.a(str, str2);
        }
    }

    public static void d(String str, String str2) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.i(str, str2);
        }
    }

    public static void init(IQLog iQLog) {
        mIQLog = iQLog;
    }

    public static void v(String str, String str2) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.v(str, str2);
        }
    }

    public static void w(String str, Throwable th5) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.w(str, th5);
        }
    }

    public static void a(String str, String str2, Throwable th5) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.a(str, str2, th5);
        }
    }

    public static void d(String str, String str2, Throwable th5) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.d(str, str2, th5);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.e(str, str2, th5);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.i(str, str2, objArr);
        }
    }

    public static void v(String str, String str2, Throwable th5) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.v(str, str2, th5);
        }
    }

    public static void w(String str, String str2) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.w(str, str2);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.d(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Throwable th5) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.i(str, str2, th5);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.w(str, str2, th5);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        IQLog iQLog = mIQLog;
        if (iQLog != null) {
            iQLog.w(str, str2, objArr);
        }
    }
}
