package com.tencent.qq.effect.utils;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LogUtil {
    static IPatchRedirector $redirector_ = null;
    private static boolean SHOW_ERR_WNR_LOG = false;
    private static boolean SHOW_INFO_DEBUG_LOG = false;
    private static final String TAG = "QEffectLog";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13591);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            SHOW_ERR_WNR_LOG = true;
            SHOW_INFO_DEBUG_LOG = true;
        }
    }

    LogUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean canLogDebug() {
        return Log.isLoggable(TAG, 3);
    }

    private static boolean canLogError() {
        return Log.isLoggable(TAG, 6);
    }

    private static boolean canLogInfo() {
        return Log.isLoggable(TAG, 4);
    }

    private static boolean canLogVerbose() {
        return Log.isLoggable(TAG, 2);
    }

    private static boolean canLogWarn() {
        return Log.isLoggable(TAG, 5);
    }

    public static void closeLog() {
        SHOW_INFO_DEBUG_LOG = false;
        SHOW_ERR_WNR_LOG = false;
    }

    public static void d(String str) {
        if (SHOW_INFO_DEBUG_LOG && canLogDebug()) {
            Log.d(TAG, str);
        }
    }

    public static void e(String str) {
        if (SHOW_ERR_WNR_LOG && canLogError()) {
            Log.e(TAG, str);
        }
    }

    public static void enableInfoLog(boolean z16) {
        SHOW_INFO_DEBUG_LOG = z16;
    }

    public static void i(String str) {
        if (SHOW_INFO_DEBUG_LOG && canLogInfo()) {
            Log.i(TAG, str);
        }
    }

    public static void v(String str) {
        if (SHOW_INFO_DEBUG_LOG && canLogVerbose()) {
            Log.v(TAG, str);
        }
    }

    public static void w(String str) {
        if (SHOW_ERR_WNR_LOG && canLogWarn()) {
            Log.w(TAG, str);
        }
    }

    public static void d(String str, String str2) {
        if (SHOW_INFO_DEBUG_LOG && canLogDebug()) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (SHOW_ERR_WNR_LOG && canLogError()) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (SHOW_INFO_DEBUG_LOG && canLogInfo()) {
            Log.i(str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (SHOW_INFO_DEBUG_LOG && canLogVerbose()) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (SHOW_ERR_WNR_LOG && canLogWarn()) {
            Log.w(str, str2);
        }
    }

    public static void w(Exception exc) {
        if (SHOW_ERR_WNR_LOG) {
            exc.printStackTrace();
        }
    }
}
