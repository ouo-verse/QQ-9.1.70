package com.tencent.mobileqq.minigame.utils;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GameLog {
    public static final String MINIAPP_TAG = "[miniapp] ";
    public static final String MINIGAME_DEBUGGER_TAG = "[debugger].";
    public static final String MINIGAME_TAG = "[minigame] ";
    public static final String MINIGAME_TAG_START = "[minigame][start] ";
    public static final String MINIGAME_TIMECOST = "[minigame][timecost] ";
    public static final String MINIGAME_VCONSOLE_TAG = "[minigame] jsconsole";
    public static final String MINIHTTP_TAG = "[mini] http.";
    public static final String MINI_TAG = "[mini] ";
    public static final int VCONSOLE_LOG_DEBUG = 100;
    private static GameLog sInstance;
    private static final String[] VCONSOLE_LOG_ARRAY = {"log", "info", "warn", "error"};
    private static long mRepeatLogInfoNumber = 0;
    private static String mPreLogInfo = "init log";

    GameLog() {
    }

    public static String cutString(String str) {
        return (!TextUtils.isEmpty(str) && str.length() >= 1024 && str.length() >= 1024) ? str.substring(0, 1023) : str;
    }

    private boolean enableLog() {
        return GameWnsUtils.gameEnableLog();
    }

    public static GameLog getInstance() {
        if (sInstance == null) {
            synchronized (GameLog.class) {
                sInstance = new GameLog();
            }
        }
        return sInstance;
    }

    public static void vconsoleLog(String str) {
        VConsoleLogManager logManager = VConsoleManager.getInstance().getLogManager(Process.myPid());
        if (logManager != null) {
            logManager.injectLog("error", str);
        }
    }

    public int d(String str, String str2) {
        if (!enableLog()) {
            return 0;
        }
        QLog.i("[minigame] " + str, 1, str2);
        return 0;
    }

    public int e(String str, String str2) {
        if (!enableLog()) {
            return 0;
        }
        QLog.e("[minigame] " + str, 1, str2);
        return 0;
    }

    public String getLogMessage(String str) {
        if (TextUtils.isEmpty(mPreLogInfo)) {
            return str;
        }
        if (mPreLogInfo.equals(str)) {
            long j3 = mRepeatLogInfoNumber + 1;
            mRepeatLogInfoNumber = j3;
            if (j3 >= Long.MAX_VALUE) {
                mRepeatLogInfoNumber = 0L;
            }
        } else {
            mRepeatLogInfoNumber = 0L;
            mPreLogInfo = str;
        }
        long j16 = mRepeatLogInfoNumber;
        if (j16 <= 10) {
            return str;
        }
        if (j16 % 10 != 0) {
            return null;
        }
        return str + "[ repeat " + mRepeatLogInfoNumber + "]";
    }

    public int i(String str, String str2) {
        if (!enableLog()) {
            return 0;
        }
        QLog.i("[minigame] " + str, 1, str2);
        return 0;
    }

    public int w(String str, String str2) {
        if (!enableLog()) {
            return 0;
        }
        QLog.w("[minigame] " + str, 1, str2);
        return 0;
    }

    public int d(String str, String str2, Throwable th5) {
        if (!enableLog()) {
            return 0;
        }
        QLog.i("[minigame] " + str, 1, str2, th5);
        return 0;
    }

    public int e(String str, String str2, Throwable th5) {
        if (!enableLog()) {
            return 0;
        }
        QLog.e("[minigame] " + str, 1, str2, th5);
        return 0;
    }

    public int i(String str, String str2, Throwable th5) {
        if (!enableLog()) {
            return 0;
        }
        QLog.i("[minigame] " + str, 1, str2, th5);
        return 0;
    }

    public int w(String str, String str2, Throwable th5) {
        if (!enableLog()) {
            return 0;
        }
        QLog.w("[minigame] " + str, 1, str2, th5);
        return 0;
    }
}
