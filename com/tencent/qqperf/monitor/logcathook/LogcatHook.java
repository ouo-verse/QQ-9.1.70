package com.tencent.qqperf.monitor.logcathook;

import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class LogcatHook {
    public static final int ENABEL_HOOK_IN_ALL_SO = 8;
    public static final int ENABEL_IN_APPLICATION_INT_VALUE = 1;
    public static final int ENABEL_IN_PEAK_PROCESS_INT_VALUE = 4;
    public static final int ENABEL_IN_RDM_INT_VALUE = 2;
    public static boolean ENABEL_SYSLOG_IN_ALL_SO = false;
    public static boolean ENABEL_SYSLOG_IN_APPLICATION = false;
    public static boolean ENABEL_SYSLOG_IN_PEAK_PROCESS = false;
    public static boolean ENABEL_SYSLOG_IN_RDM = false;
    public static final String LOGCAT_HOOK_SO_NAME = "logcathook";
    public static final String LOGCAT_HOOK_SP_ENABLE_KEY = "enable_syslog_key";
    public static final String LOGCAT_HOOK_SP_FILE = "suspend_thread_pref_file";
    public static final String LOGCAT_HOOK_SP_IGNORE_LIST_KEY = "ignore_list_key";
    public static final String TAG = "LogcatHook";
    public static AtomicBoolean sLogcatHooked = new AtomicBoolean(false);
    public static List<String> IGNORE_SO_LIST = new ArrayList<String>() { // from class: com.tencent.qqperf.monitor.logcathook.LogcatHook.1
        {
            add(".*/liblogcathook.so$");
            add(".*/libnatmem_monitor.so$");
            add(".*/libBugly-rqd.so$");
            add(".*/libqq_fd.so$");
        }
    };
    public static String[] REGISTER_SO_LIST = {".*\\libart.so$", ".*\\libhwui.so$", ".*\\libandroid_runtime.so$", ".*\\liblog.so$"};
    public static String[] ALL_SO_LIST = {".*\\.so$"};

    static {
        ENABEL_SYSLOG_IN_APPLICATION = false;
        ENABEL_SYSLOG_IN_RDM = false;
        ENABEL_SYSLOG_IN_PEAK_PROCESS = false;
        ENABEL_SYSLOG_IN_ALL_SO = false;
        try {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(LOGCAT_HOOK_SP_FILE, 0);
            int i3 = sharedPreferences.getInt(LOGCAT_HOOK_SP_ENABLE_KEY, 0);
            if ((i3 & 1) == 1) {
                ENABEL_SYSLOG_IN_APPLICATION = true;
            }
            if ((i3 & 2) == 2) {
                ENABEL_SYSLOG_IN_RDM = true;
            }
            if ((i3 & 4) == 4) {
                ENABEL_SYSLOG_IN_PEAK_PROCESS = true;
            }
            if ((i3 & 8) == 8) {
                ENABEL_SYSLOG_IN_ALL_SO = true;
            }
            String string = sharedPreferences.getString(LOGCAT_HOOK_SP_IGNORE_LIST_KEY, "");
            if (!string.equalsIgnoreCase("")) {
                for (String str : string.split("\\|")) {
                    IGNORE_SO_LIST.add(str);
                }
            }
            Log.i(TAG, "LogcatHook static init enableHook = " + i3);
            Log.i(TAG, "LogcatHook static init ENABEL_SYSLOG_IN_RDM = " + ENABEL_SYSLOG_IN_RDM);
            Log.i(TAG, "LogcatHook static init ENABEL_SYSLOG_IN_APPLICATION = " + ENABEL_SYSLOG_IN_APPLICATION);
            Log.i(TAG, "LogcatHook static init ENABEL_SYSLOG_IN_PEAK_PROCESS = " + ENABEL_SYSLOG_IN_PEAK_PROCESS);
            Log.i(TAG, "LogcatHook static init ENABEL_SYSLOG_IN_ALL_SO = " + ENABEL_SYSLOG_IN_ALL_SO);
        } catch (Throwable unused) {
            ENABEL_SYSLOG_IN_APPLICATION = false;
            ENABEL_SYSLOG_IN_RDM = false;
            ENABEL_SYSLOG_IN_PEAK_PROCESS = false;
            ENABEL_SYSLOG_IN_ALL_SO = false;
        }
    }

    public static void checkAndStartHookLogcat() {
        try {
            if (!sLogcatHooked.get() && ENABEL_SYSLOG_IN_RDM) {
                startHookLogcat();
            } else {
                Log.w(TAG, "checkAndStartHookLogcat false :" + sLogcatHooked.get() + "|" + ENABEL_SYSLOG_IN_RDM);
            }
        } catch (Throwable th5) {
            Log.e(TAG, "LogcatHook start failed !!", th5);
        }
    }

    public static void delayDisableHookLogcat() {
        Log.i(TAG, "delayDisableHookLogcat");
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqperf.monitor.logcathook.LogcatHook.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (LogcatHook.sLogcatHooked.compareAndSet(true, false)) {
                        LogcatHook.disableHook();
                        Log.w(LogcatHook.TAG, "disableHook invoke");
                    }
                } catch (Throwable th5) {
                    QLog.e(LogcatHook.TAG, 1, "delayDisableHookLogcat failed", th5);
                }
            }
        }, 16, null, false, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void disableHook();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void enableHook();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void init(boolean z16);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void registerHookSo(String str);

    public static void saveToQLog(String str) {
        QLog.d(TAG, 1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void setIgnoreHookSo(String str);

    public static void startHookLogcat() {
        Log.e(TAG, "startHookLogcat");
        if (MobileQQ.sProcessId == 9 && !ENABEL_SYSLOG_IN_PEAK_PROCESS) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqperf.monitor.logcathook.LogcatHook.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                try {
                    if (!LogcatHook.sLogcatHooked.get()) {
                        System.loadLibrary(LogcatHook.LOGCAT_HOOK_SO_NAME);
                        a.d(MobileQQ.PACKAGE_NAME, MobileQQ.processName, AppSetting.getAppSubVersionName(), 0L);
                        if (!AppSetting.isPublicVersion()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        LogcatHook.init(z16);
                        LogcatHook.updateLogPath(a.b());
                        if (LogcatHook.ENABEL_SYSLOG_IN_ALL_SO) {
                            for (String str : LogcatHook.ALL_SO_LIST) {
                                LogcatHook.registerHookSo(str);
                            }
                        } else {
                            for (String str2 : LogcatHook.REGISTER_SO_LIST) {
                                LogcatHook.registerHookSo(str2);
                            }
                        }
                        Iterator<String> it = LogcatHook.IGNORE_SO_LIST.iterator();
                        while (it.hasNext()) {
                            LogcatHook.setIgnoreHookSo(it.next());
                        }
                        LogcatHook.enableHook();
                        LogcatHook.sLogcatHooked.compareAndSet(false, true);
                    }
                } catch (Throwable th5) {
                    LogcatHook.sLogcatHooked.compareAndSet(true, false);
                    QLog.e(LogcatHook.TAG, 1, "logcat hook failed", th5);
                }
            }
        }, 64, null, false);
    }

    public static native void updateLogPath(String str);
}
