package com.tencent.ams.fusion.widget.utils;

import android.util.Log;
import com.tencent.ams.fusion.service.b;
import com.tencent.ams.fusion.widget.animatorview.AnimatorConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import jt.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Logger {
    static IPatchRedirector $redirector_ = null;
    private static final String AD_TAG = "FusionAdWidget_";
    private static boolean enableLog;
    private static Boolean isFusionCoreSupport;
    private static Boolean isOutLogSupport;
    private static a logService;
    private static AnimatorConfig.LogSupport outLogSupport;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39128);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            enableLog = true;
        }
    }

    public Logger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str) {
        if (supportFusionCoreLog()) {
            logService.b(AD_TAG, str);
        } else if (supportOutLog()) {
            outLogSupport.d(AD_TAG, str);
        } else if (enableLog) {
            Log.d(AD_TAG, String.valueOf(str));
        }
    }

    public static void e(String str) {
        if (supportFusionCoreLog()) {
            logService.e(AD_TAG, str);
        } else if (supportOutLog()) {
            outLogSupport.e(AD_TAG, str, null);
        } else if (enableLog) {
            Log.e(AD_TAG, String.valueOf(str));
        }
    }

    public static void i(String str, String str2) {
        if (supportFusionCoreLog()) {
            logService.c(AD_TAG + str, str2);
            return;
        }
        if (supportOutLog()) {
            outLogSupport.i(AD_TAG + str, str2);
            return;
        }
        if (enableLog) {
            Log.i(AD_TAG + str, String.valueOf(str2));
        }
    }

    public static void setDebug(boolean z16) {
        enableLog = z16;
    }

    private static boolean supportFusionCoreLog() {
        if (isFusionCoreSupport == null) {
            try {
                a l3 = b.b().l();
                logService = l3;
                if (l3 != null) {
                    isFusionCoreSupport = Boolean.TRUE;
                } else {
                    throw new IllegalArgumentException("support fusion core but can't find log service!");
                }
            } catch (Throwable unused) {
                isFusionCoreSupport = Boolean.FALSE;
                Log.w(AD_TAG, "not support fusion core!");
            }
        }
        return isFusionCoreSupport.booleanValue();
    }

    private static boolean supportOutLog() {
        boolean z16;
        if (isOutLogSupport == null) {
            AnimatorConfig.LogSupport logSupport = AnimatorConfig.getLogSupport();
            outLogSupport = logSupport;
            if (logSupport != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            isOutLogSupport = Boolean.valueOf(z16);
        }
        return isOutLogSupport.booleanValue();
    }

    public static void v(String str, String str2) {
        if (supportFusionCoreLog()) {
            logService.a(AD_TAG + str, str2);
            return;
        }
        if (supportOutLog()) {
            outLogSupport.v(AD_TAG + str, str2);
            return;
        }
        if (enableLog) {
            Log.v(AD_TAG + str, String.valueOf(str2));
        }
    }

    public static void w(String str, String str2) {
        if (supportFusionCoreLog()) {
            logService.d(AD_TAG + str, str2);
            return;
        }
        if (supportOutLog()) {
            outLogSupport.w(AD_TAG + str, str2);
            return;
        }
        if (enableLog) {
            Log.w(AD_TAG + str, String.valueOf(str2));
        }
    }

    public static void d(String str, String str2) {
        if (supportFusionCoreLog()) {
            logService.b(AD_TAG + str, str2);
            return;
        }
        if (supportOutLog()) {
            outLogSupport.d(AD_TAG + str, str2);
            return;
        }
        if (enableLog) {
            Log.d(AD_TAG + str, String.valueOf(str2));
        }
    }

    public static void e(String str, String str2) {
        if (supportFusionCoreLog()) {
            logService.e(AD_TAG + str, str2);
            return;
        }
        if (supportOutLog()) {
            outLogSupport.e(AD_TAG + str, str2, null);
            return;
        }
        if (enableLog) {
            Log.e(AD_TAG + str, String.valueOf(str2));
        }
    }

    public static void i(String str) {
        if (supportFusionCoreLog()) {
            logService.c(AD_TAG, str);
        } else if (supportOutLog()) {
            outLogSupport.i(AD_TAG, str);
        } else if (enableLog) {
            Log.i(AD_TAG, String.valueOf(str));
        }
    }

    public static void v(String str) {
        if (supportFusionCoreLog()) {
            logService.a(AD_TAG, str);
        } else if (supportOutLog()) {
            outLogSupport.v(AD_TAG, str);
        } else if (enableLog) {
            Log.v(AD_TAG, String.valueOf(str));
        }
    }

    public static void w(String str) {
        if (supportFusionCoreLog()) {
            logService.d(AD_TAG, str);
        } else if (supportOutLog()) {
            outLogSupport.w(AD_TAG, str);
        } else if (enableLog) {
            Log.w(AD_TAG, String.valueOf(str));
        }
    }

    public static void e(String str, Throwable th5) {
        if (supportFusionCoreLog()) {
            logService.a(AD_TAG, str, th5);
        } else if (supportOutLog()) {
            outLogSupport.e(AD_TAG, str, th5);
        } else if (enableLog) {
            Log.e(AD_TAG, String.valueOf(str), th5);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        if (supportFusionCoreLog()) {
            logService.a(AD_TAG + str, str2, th5);
            return;
        }
        if (supportOutLog()) {
            outLogSupport.e(AD_TAG + str, str2, th5);
            return;
        }
        if (enableLog) {
            Log.e(AD_TAG + str, String.valueOf(str2), th5);
        }
    }
}
