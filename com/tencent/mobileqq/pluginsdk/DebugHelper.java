package com.tencent.mobileqq.pluginsdk;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class DebugHelper {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "plugin_tag";
    public static boolean sDebug;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12163);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sDebug = true;
        }
    }

    public DebugHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void debug(String str, String str2, Throwable th5) {
        if (sDebug && QLog.isColorLevel()) {
            if (th5 == null) {
                QLog.d(str, 2, str2);
            } else {
                QLog.d(str, 2, str2, th5);
            }
        }
    }

    public static void log(String str, String str2, Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2, th5);
        }
    }

    public static void log(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    public static void debug(String str, String str2) {
        debug(str, str2, null);
    }

    public static void debug(String str) {
        debug("plugin_tag", str);
    }

    public static void log(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("plugin_tag", 2, str);
        }
    }
}
