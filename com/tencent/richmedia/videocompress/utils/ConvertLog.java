package com.tencent.richmedia.videocompress.utils;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ConvertLog {
    public static final int CLR = 2;
    public static final int DEV = 3;
    private static int LOG_LEVEL = 2;
    public static final int USR = 1;
    private static Logger logger = new DefaultLogger();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class DefaultLogger implements Logger {
        DefaultLogger() {
        }

        @Override // com.tencent.richmedia.videocompress.utils.Logger
        public void d(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.tencent.richmedia.videocompress.utils.Logger
        public void e(String str, String str2) {
            Log.e(str, str2);
        }

        @Override // com.tencent.richmedia.videocompress.utils.Logger
        public void i(String str, String str2) {
            Log.i(str, str2);
        }

        @Override // com.tencent.richmedia.videocompress.utils.Logger
        public void w(String str, String str2) {
            Log.w(str, str2);
        }

        @Override // com.tencent.richmedia.videocompress.utils.Logger
        public void e(String str, String str2, Throwable th5) {
            Log.e(str, str2, th5);
        }
    }

    public static void d(String str, int i3, Object... objArr) {
        if (LOG_LEVEL >= i3) {
            StringBuilder sb5 = new StringBuilder(objArr.length * 30);
            for (Object obj : objArr) {
                if (obj != null) {
                    sb5.append(obj);
                }
            }
            logger.d(str, sb5.toString());
        }
    }

    public static void e(String str, int i3, Object... objArr) {
        e(str, i3, (Throwable) null, objArr);
    }

    public static int getLogLevel() {
        return LOG_LEVEL;
    }

    public static void i(String str, int i3, Object... objArr) {
        if (LOG_LEVEL >= i3) {
            StringBuilder sb5 = new StringBuilder(objArr.length * 30);
            for (Object obj : objArr) {
                if (obj != null) {
                    sb5.append(obj);
                }
            }
            logger.i(str, sb5.toString());
        }
    }

    public static boolean isColorLevel() {
        if (LOG_LEVEL > 1) {
            return true;
        }
        return false;
    }

    public static boolean isDevLevel() {
        if (LOG_LEVEL == 3) {
            return true;
        }
        return false;
    }

    public static void setLogLevel(int i3) {
        LOG_LEVEL = i3;
    }

    public static void setLogger(Logger logger2) {
        if (logger2 != null) {
            logger = logger2;
        }
    }

    public static void w(String str, int i3, Object... objArr) {
        if (LOG_LEVEL >= i3) {
            StringBuilder sb5 = new StringBuilder(objArr.length * 30);
            for (Object obj : objArr) {
                if (obj != null) {
                    sb5.append(obj);
                }
            }
            logger.w(str, sb5.toString());
        }
    }

    public static void e(String str, int i3, Throwable th5, Object... objArr) {
        StringBuilder sb5 = new StringBuilder((objArr.length * 30) + (th5 == null ? 0 : 128));
        for (Object obj : objArr) {
            if (obj != null) {
                sb5.append(obj);
            }
        }
        e(str, i3, sb5.toString(), th5);
    }

    public static void e(String str, int i3, String str2, Throwable th5) {
        if (LOG_LEVEL >= i3) {
            if (str2 == null) {
                str2 = "";
            }
            if (th5 == null) {
                logger.e(str, str2);
            } else {
                logger.e(str, str2, th5);
            }
        }
    }
}
