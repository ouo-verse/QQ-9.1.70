package com.tencent.qqmini.sdk.launcher;

import com.tencent.qqmini.sdk.launcher.dynamic.MiniAppDexLoader;
import com.tencent.qqmini.sdk.launcher.dynamic.MiniDexConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.Thread;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniCrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "MiniCrashHandler";
    public Thread.UncaughtExceptionHandler defaultHandler;

    public MiniCrashHandler() {
        this.defaultHandler = null;
        this.defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    public void saveCrashInfo() {
        try {
            MiniDexConfig dexConfig = MiniAppDexLoader.g().getDexConfig();
            if (dexConfig == null) {
                return;
            }
            dexConfig.addCrashInfo();
            QMLog.i(TAG, "save crash info completed.");
        } catch (Throwable th5) {
            QMLog.e(TAG, "save crash info exception!", th5);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        QMLog.e(TAG, "uncaughtException ", th5);
        saveCrashInfo();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th5);
        }
    }
}
