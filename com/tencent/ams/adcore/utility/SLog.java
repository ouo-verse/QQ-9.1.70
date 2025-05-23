package com.tencent.ams.adcore.utility;

import android.util.Log;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SLog {
    static IPatchRedirector $redirector_ = null;
    private static final String AD_TAG = "TENCENT_AMS_";

    public SLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str) {
        if (GDTLogger.isEnableConsoleLog()) {
            Log.d(AD_TAG, str);
        }
    }

    public static void e(String str) {
        Log.e(AD_TAG, str);
    }

    public static void e(String str, String str2, Throwable th5) {
        Log.e(AD_TAG + str, str2, th5);
    }
}
