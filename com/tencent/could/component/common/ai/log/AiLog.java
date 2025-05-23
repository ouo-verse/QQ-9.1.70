package com.tencent.could.component.common.ai.log;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AiLog {
    static IPatchRedirector $redirector_ = null;
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String TAG = "AiLog";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static boolean isInit = false;
    private static AiLogger logger;

    public AiLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean assertInitLogger() {
        if (!isInit) {
            Log.e(TAG, "aiLogger is not init!");
            return false;
        }
        return true;
    }

    public static void asset(String str, String str2) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.asset(str, str2);
    }

    public static void debug(String str, String str2) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.debug(str, str2);
    }

    public static void error(String str, String str2) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.error(str, str2);
    }

    public static void info(String str, String str2) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.info(str, str2);
    }

    public static void init(AiLogger aiLogger) {
        if (aiLogger != null) {
            logger = aiLogger;
            isInit = true;
        } else {
            Log.e(TAG, "init AiLogger is null!");
            throw new IllegalStateException("init AiLogger is null!");
        }
    }

    public static void release() {
        AiLogger aiLogger = logger;
        if (aiLogger != null) {
            aiLogger.release();
        }
    }

    public static void verbose(String str, String str2) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.verbose(str, str2);
    }

    public static void warn(String str, String str2) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.warn(str, str2);
    }

    public static void asset(String str) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.asset(str);
    }

    public static void debug(String str) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.debug(str);
    }

    public static void error(String str) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.error(str);
    }

    public static void info(String str) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.info(str);
    }

    public static void verbose(String str) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.verbose(str);
    }

    public static void warn(String str) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.warn(str);
    }

    public static void asset(String str, String str2, Object... objArr) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.asset(str, str2, objArr);
    }

    public static void debug(String str, String str2, Object... objArr) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.debug(str, str2, objArr);
    }

    public static void error(String str, String str2, Object... objArr) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.error(str, str2, objArr);
    }

    public static void info(String str, String str2, Object... objArr) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.info(str, str2, objArr);
    }

    public static void verbose(String str, String str2, Object... objArr) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.verbose(str, str2, objArr);
    }

    public static void warn(String str, String str2, Object... objArr) {
        if (logger == null || !assertInitLogger()) {
            return;
        }
        logger.warn(str, str2, objArr);
    }
}
