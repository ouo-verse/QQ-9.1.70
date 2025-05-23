package com.qq.e.comm.util;

import android.text.TextUtils;
import android.util.Log;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.pi.POFactory;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GDTLogger {
    public static final boolean DEBUG_ENABLE = false;
    public static final String KEY_ENABLE_CONSOLE_LOG = "enable_console_log";
    private static final String KEY_ENABLE_REPORT = "enable_report";
    private static final String KEY_ENABLE_REPORT_LOG = "rle";
    private static final String TAG = "tg_ad_mob";

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isEnableConsoleLog() || isEnableReportLog()) {
            if (str.length() < 4000) {
                logD(str);
                return;
            }
            int length = (str.length() / 4000) + 1;
            logD("msg length is " + str.length() + ", split to " + length + " parts");
            int i3 = 0;
            while (i3 < length) {
                StringBuilder sb5 = new StringBuilder("part ");
                sb5.append(i3);
                sb5.append(", ");
                int i16 = i3 * 4000;
                i3++;
                sb5.append(str.substring(i16, Math.min(i3 * 4000, str.length())));
                logD(sb5.toString());
            }
        }
    }

    public static void e(String str) {
        logD(str);
    }

    public static void i(String str) {
        logD(str);
    }

    private static boolean isDebugMode() {
        return false;
    }

    public static boolean isEnableConsoleLog() {
        if (isDebugMode()) {
            return true;
        }
        try {
            if (GDTADManager.getInstance().getSM() != null) {
                if (GDTADManager.getInstance().getSM().getInteger(KEY_ENABLE_CONSOLE_LOG, 0) == 1) {
                    return true;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return false;
    }

    public static boolean isEnableReportLog() {
        try {
            if (GDTADManager.getInstance().isInitialized() && GDTADManager.getInstance().getSM() != null) {
                if (GDTADManager.getInstance().getSM().getInteger(KEY_ENABLE_REPORT_LOG, 0) == 1) {
                    return true;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return false;
    }

    private static void logD(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isEnableReportLog()) {
            reportToServer(str, null, false);
        }
        if (GlobalSetting.getTangramAdLogger() != null) {
            GlobalSetting.getTangramAdLogger().logD(TAG, str);
        } else {
            Log.d(TAG, str);
        }
    }

    private static void logE(String str, Throwable th5) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isEnableReportLog()) {
            reportToServer(str, th5, false);
        }
        if (GlobalSetting.getTangramAdLogger() != null) {
            GlobalSetting.getTangramAdLogger().logE(TAG, str, th5);
        } else {
            Log.e(TAG, str, th5);
        }
    }

    public static void report(String str) {
        report(str, null);
    }

    private static void reportToServer(String str, Throwable th5, boolean z16) {
        POFactory pOFactory;
        Object obj;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (GDTADManager.getInstance().getPM() != null && (pOFactory = GDTADManager.getInstance().getPM().getPOFactory()) != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                if (th5 != null) {
                    obj = th5.getStackTrace();
                } else {
                    obj = "";
                }
                sb5.append(obj);
                pOFactory.reportLog(sb5.toString());
            }
        } catch (a e16) {
            e16.printStackTrace();
        }
    }

    public static void w(String str) {
        logD(str);
    }

    public static void e(String str, Throwable th5) {
        logE(str, th5);
    }

    public static void report(String str, Throwable th5) {
        if (GDTADManager.getInstance().getSM() == null || GDTADManager.getInstance().getSM().getInteger(KEY_ENABLE_REPORT, 0) != 1) {
            reportToServer(str, th5, true);
        }
    }

    public static void w(String str, Throwable th5) {
        if (th5 == null) {
            logD(str);
        } else {
            logE(str, th5);
        }
    }
}
