package com.tencent.mobileqq.mini;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05115;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.Thread;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniCrashHandler extends CrashHandler {
    public static final String FOLDER = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini/";
    private static final String TAG = "MiniCrashHandler";
    public Thread.UncaughtExceptionHandler defaultHandler;
    private MiniAppConfig miniAppConfig;

    public MiniCrashHandler() {
        this.defaultHandler = null;
        this.defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    public static void cleanCrashInfo() {
        try {
            String crashFilePath = getCrashFilePath(BaseApplicationImpl.getApplication().getQQProcessName());
            if (TextUtils.isEmpty(crashFilePath)) {
                return;
            }
            File file = new File(crashFilePath);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            QLog.e(TAG, 1, "cleanCrashInfo");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "cleanCrashInfo exception!", th5);
        }
    }

    public static String getCrashFilePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!str.contains(":")) {
                return null;
            }
            return FOLDER + str.substring(str.indexOf(":") + 1) + "_crash";
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getFilePath exception! processName:" + str, th5);
            return null;
        }
    }

    public void saveCrashInfo() {
        String crashFilePath;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                crashFilePath = getCrashFilePath(BaseApplicationImpl.getApplication().getQQProcessName());
            } catch (Throwable th5) {
                th = th5;
            }
            if (TextUtils.isEmpty(crashFilePath)) {
                return;
            }
            File file = new File(crashFilePath);
            File file2 = new File(FOLDER);
            if (!file2.exists() || !file2.isDirectory()) {
                file2.mkdirs();
            }
            if (!file.exists() || !file.isFile()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
            try {
                fileOutputStream2.write(("" + System.currentTimeMillis()).getBytes());
                fileOutputStream2.flush();
                QLog.i(TAG, 1, "save crash info completed:" + crashFilePath + " time:" + System.currentTimeMillis());
                fileOutputStream2.close();
            } catch (Throwable th6) {
                th = th6;
                fileOutputStream = fileOutputStream2;
                try {
                    QLog.e(TAG, 1, "save crash info exception!", th);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th7) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th8) {
                            QLog.e(TAG, 1, "save crash info exception!", th8);
                        }
                    }
                    throw th7;
                }
            }
        } catch (Throwable th9) {
            QLog.e(TAG, 1, "save crash info exception!", th9);
        }
    }

    public void setMiniAppConfig(MiniAppConfig miniAppConfig) {
        this.miniAppConfig = miniAppConfig;
    }

    @Override // mqq.app.CrashHandler, java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th5) {
        QLog.e(TAG, 1, "uncaughtException ", th5);
        saveCrashInfo();
        MiniProgramLpReportDC05115.reportCrash(this.miniAppConfig, th5);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th5);
        }
        super.uncaughtException(thread, th5);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        mobileQQ.crashed();
        mobileQQ.otherProcessExit(false);
    }

    public static long getLastCrashTime(String str) {
        try {
            String crashFilePath = getCrashFilePath(str);
            if (TextUtils.isEmpty(crashFilePath)) {
                return -1L;
            }
            File file = new File(crashFilePath);
            if (file.exists() && file.isFile()) {
                return file.lastModified();
            }
            return -1L;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "get crash info exception!", th5);
            return -1L;
        }
    }
}
