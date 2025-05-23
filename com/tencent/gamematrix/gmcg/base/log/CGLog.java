package com.tencent.gamematrix.gmcg.base.log;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGLog {
    private static Logger DEFAULT_LOGGER = new Logger() { // from class: com.tencent.gamematrix.gmcg.base.log.CGLog.1
        @Override // com.tencent.gamematrix.gmcg.base.log.CGLog.Logger
        public void d(String str, String str2) {
            Log.d(str, str2);
        }

        @Override // com.tencent.gamematrix.gmcg.base.log.CGLog.Logger
        public void e(String str, String str2) {
            Log.e(str, str2);
        }

        @Override // com.tencent.gamematrix.gmcg.base.log.CGLog.Logger
        public void i(String str, String str2) {
            Log.i(str, str2);
        }

        @Override // com.tencent.gamematrix.gmcg.base.log.CGLog.Logger
        public void v(String str, String str2) {
            Log.v(str, str2);
        }

        @Override // com.tencent.gamematrix.gmcg.base.log.CGLog.Logger
        public void w(String str, String str2) {
            Log.w(str, str2);
        }
    };
    private static final String TAG = "gmcg";
    private static boolean sEnableLog = false;
    private static Logger sExtLogger;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface Logger {
        void d(String str, String str2);

        void e(String str, String str2);

        void i(String str, String str2);

        void v(String str, String str2);

        void w(String str, String str2);
    }

    public static void d(String str, String str2) {
        if (sEnableLog) {
            Logger logger = sExtLogger;
            if (logger != null) {
                logger.d(str, str2);
            } else {
                DEFAULT_LOGGER.d(str, str2);
            }
        }
    }

    public static void e(String str, String str2) {
        if (sEnableLog) {
            Logger logger = sExtLogger;
            if (logger != null) {
                logger.e(str, str2);
            } else {
                DEFAULT_LOGGER.e(str, str2);
            }
        }
    }

    public static void enable(boolean z16) {
        sEnableLog = z16;
    }

    public static void i(String str, String str2) {
        if (sEnableLog) {
            Logger logger = sExtLogger;
            if (logger != null) {
                logger.i(str, str2);
            } else {
                DEFAULT_LOGGER.i(str, str2);
            }
        }
    }

    public static void setLogger(Logger logger) {
        sExtLogger = logger;
    }

    public static void v(String str, String str2) {
        if (sEnableLog) {
            Logger logger = sExtLogger;
            if (logger != null) {
                logger.v(str, str2);
            } else {
                DEFAULT_LOGGER.v(str, str2);
            }
        }
    }

    public static void w(String str, String str2) {
        if (sEnableLog) {
            Logger logger = sExtLogger;
            if (logger != null) {
                logger.w(str, str2);
            } else {
                DEFAULT_LOGGER.w(str, str2);
            }
        }
    }

    public static void d(String str) {
        d(TAG, str);
    }

    public static void e(String str) {
        e(TAG, str);
    }

    public static void i(String str) {
        i(TAG, str);
    }

    public static void v(String str) {
        v(TAG, str);
    }

    public static void w(String str) {
        w(TAG, str);
    }
}
