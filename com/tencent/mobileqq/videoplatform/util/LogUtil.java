package com.tencent.mobileqq.videoplatform.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.videoplatform.api.ILog;
import com.tencent.mobileqq.videoplatform.imp.LogImp;

/* compiled from: P */
/* loaded from: classes20.dex */
public class LogUtil {
    static IPatchRedirector $redirector_ = null;
    public static final int CLR = 2;
    public static final int DEV = 4;
    public static final int USR = 1;
    static volatile ILog sLog;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14781);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sLog = new LogImp();
        }
    }

    public LogUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, int i3, String str2) {
        sLog.d(str, i3, str2);
    }

    public static void e(String str, int i3, String str2) {
        sLog.e(str, i3, str2);
    }

    public static void i(String str, int i3, String str2) {
        sLog.i(str, i3, str2);
    }

    public static boolean isColorLevel() {
        return sLog.isColorLevel();
    }

    public static void setLogImp(ILog iLog) {
        sLog = iLog;
    }

    public static void v(String str, int i3, String str2) {
        sLog.v(str, i3, str2);
    }

    public static void w(String str, int i3, String str2) {
        sLog.w(str, i3, str2);
    }

    public static void e(String str, int i3, String str2, Throwable th5) {
        sLog.e(str, i3, str2, th5);
    }
}
