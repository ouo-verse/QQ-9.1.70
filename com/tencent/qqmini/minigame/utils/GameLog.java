package com.tencent.qqmini.minigame.utils;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;

/* compiled from: P */
@Deprecated
/* loaded from: classes23.dex */
public class GameLog {
    public static final String MINIGAME_DEBUGGER_TAG = "[debugger].";
    public static final String MINIGAME_TAG = "[minigame] ";
    public static final String MINIGAME_TAG_START = "[minigame][start] ";
    public static final String MINIGAME_TIMECOST = "[minigame][timecost] ";
    public static final int VCONSOLE_LOG_DEBUG = 100;
    private static GameLog sInstance;

    GameLog() {
    }

    private static boolean enableLog() {
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

    public int d(String str, String str2) {
        if (!enableLog()) {
            return 0;
        }
        QMLog.i("[minigame] " + str, str2);
        return 0;
    }

    public int e(String str, String str2) {
        if (!enableLog()) {
            return 0;
        }
        QMLog.e("[minigame] " + str, str2);
        return 0;
    }

    public int i(String str, String str2) {
        if (!enableLog()) {
            return 0;
        }
        QMLog.i("[minigame] " + str, str2);
        return 0;
    }

    public int w(String str, String str2) {
        if (!enableLog()) {
            return 0;
        }
        QMLog.w("[minigame] " + str, str2);
        return 0;
    }

    public int d(String str, String str2, Throwable th5) {
        if (!enableLog()) {
            return 0;
        }
        QMLog.i("[minigame] " + str, str2, th5);
        return 0;
    }

    public int e(String str, String str2, Throwable th5) {
        if (!enableLog()) {
            return 0;
        }
        QMLog.e("[minigame] " + str, str2, th5);
        return 0;
    }

    public int i(String str, String str2, Throwable th5) {
        if (!enableLog()) {
            return 0;
        }
        QMLog.i("[minigame] " + str, str2, th5);
        return 0;
    }

    public int w(String str, String str2, Throwable th5) {
        if (!enableLog()) {
            return 0;
        }
        QMLog.w("[minigame] " + str, str2, th5);
        return 0;
    }
}
