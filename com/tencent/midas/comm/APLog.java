package com.tencent.midas.comm;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.internal.APCallbackLogger;
import com.tencent.midas.comm.log.internal.APLogger;
import com.tencent.midas.comm.log.util.APLogFileUtil;

/* loaded from: classes9.dex */
public class APLog {
    private static APLogger logger;

    @SuppressLint({"StaticFieldLeak"})
    private static APLogInfo logInfo = new APLogInfo();
    private static boolean shouldWriteLog = false;
    private static boolean shouldPrintLog = true;
    private static boolean hasLogCallback = false;

    APLog() {
    }

    public static void closeLog() {
        flush();
    }

    private static String composeLogMsg(String str, String str2) {
        return str + APLogFileUtil.SEPARATOR_LOG + Thread.currentThread().getName() + APLogFileUtil.SEPARATOR_LOG + str2 + "\r\n";
    }

    public static void d(String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (hasLogCallback) {
            APCallbackLogger.log(2, logInfo.getLogTag(), composeLogMsg);
            return;
        }
        if (shouldPrintLog) {
            APLogger.log(2, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    public static void e(String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (hasLogCallback) {
            APCallbackLogger.log(5, logInfo.getLogTag(), composeLogMsg);
            return;
        }
        if (shouldPrintLog) {
            APLogger.log(5, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    public static void flush() {
        try {
            APLogger aPLogger = logger;
            if (aPLogger != null) {
                aPLogger.flush();
                Log.d(APLogInfo.LOG_TAG, "Log flushing...!!!");
            }
        } catch (Throwable th5) {
            Log.i(APLogInfo.LOG_TAG, "flush log error: " + th5.toString());
        }
    }

    public static APLogInfo getLogInfo() {
        return logInfo;
    }

    public static void i(String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (hasLogCallback) {
            APCallbackLogger.log(3, logInfo.getLogTag(), composeLogMsg);
            return;
        }
        if (shouldPrintLog) {
            APLogger.log(3, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    public static void init(APLogInfo aPLogInfo) {
        try {
            Log.d(APLogInfo.LOG_TAG, "Log init");
            if (aPLogInfo == null) {
                Log.e(APLogInfo.LOG_TAG, "Log init failed: info null");
                return;
            }
            logInfo = aPLogInfo;
            if (!TextUtils.isEmpty(aPLogInfo.getLogCallbackClassName())) {
                Log.d(APLogInfo.LOG_TAG, "Log Callback:");
                if (APCallbackLogger.init(aPLogInfo.getLogCallbackClassName())) {
                    hasLogCallback = true;
                    return;
                }
            } else {
                hasLogCallback = false;
                APCallbackLogger.release();
            }
            logInfo.init();
            APLogFileInfo.create();
            APLogFileUtil.readLogKeepConf(logInfo.getContext());
            shouldPrintLog = logInfo.shouldPrintLog();
            if (APLogFileUtil.initLogDir(APLogFileInfo.dirName)) {
                shouldWriteLog = logInfo.isWriteLog();
                if (logger == null) {
                    logger = APLogger.open();
                }
            }
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, "Log init failed: " + th5.toString());
        }
    }

    public static void s(boolean z16, String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (hasLogCallback) {
            APCallbackLogger.log(6, logInfo.getLogTag(), composeLogMsg);
            return;
        }
        if (shouldPrintLog && !z16) {
            APLogger.log(6, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    public static void v(String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (hasLogCallback) {
            APCallbackLogger.log(1, logInfo.getLogTag(), composeLogMsg);
            return;
        }
        if (shouldPrintLog) {
            APLogger.log(1, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    public static void w(String str, String str2) {
        String composeLogMsg = composeLogMsg(str, str2);
        if (hasLogCallback) {
            APCallbackLogger.log(4, logInfo.getLogTag(), composeLogMsg);
            return;
        }
        if (shouldPrintLog) {
            APLogger.log(4, logInfo.getLogTag(), composeLogMsg);
        }
        writeLog(composeLogMsg);
    }

    private static void write(String str) {
        try {
            APLogger aPLogger = logger;
            if (aPLogger != null) {
                aPLogger.write(str);
            }
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, "Log write error: " + th5.toString());
        }
    }

    private static void writeLog(String str) {
        if (shouldWriteLog) {
            write(str);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        d(str, String.format(str2, objArr));
    }

    public static void e(String str, String str2, Object... objArr) {
        e(str, String.format(str2, objArr));
    }

    public static void i(String str, String str2, Object... objArr) {
        i(str, String.format(str2, objArr));
    }

    public static void s(boolean z16, String str, String str2, Object... objArr) {
        s(z16, str, String.format(str2, objArr));
    }

    public static void v(String str, String str2, Object... objArr) {
        v(str, String.format(str2, objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        w(str, String.format(str2, objArr));
    }

    public static void s(String str, String str2) {
        writeLog(composeLogMsg(str, str2));
    }

    public static void s(String str, String str2, Object... objArr) {
        s(str, String.format(str2, objArr));
    }
}
