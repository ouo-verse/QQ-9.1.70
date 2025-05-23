package com.tencent.raft.raftframework.log;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class RLog {
    static IPatchRedirector $redirector_;
    private static ILogDelegate sLogDelegate;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13325);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sLogDelegate = new DefaultLogDelegate();
        }
    }

    public RLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void d(String str, Object... objArr) {
        sLogDelegate.debug(str, getLogMsg(objArr).toString());
    }

    public static void e(String str, Object... objArr) {
        sLogDelegate.error(str, getLogMsg(objArr).toString());
    }

    private static StringBuilder getLogMsg(Object... objArr) {
        StringBuilder sb5 = new StringBuilder();
        for (Object obj : objArr) {
            sb5.append(obj);
        }
        return sb5;
    }

    public static void i(String str, Object... objArr) {
        sLogDelegate.info(str, getLogMsg(objArr).toString());
    }

    public static void setLogDelegate(ILogDelegate iLogDelegate) {
        if (iLogDelegate != null) {
            sLogDelegate = iLogDelegate;
        } else {
            sLogDelegate = new DefaultLogDelegate();
        }
    }

    public static void w(String str, Object... objArr) {
        sLogDelegate.warn(str, getLogMsg(objArr).toString());
    }

    public static void d(String str, String str2, Throwable th5) {
        sLogDelegate.debug(str, str2, th5);
    }

    public static void e(String str, String str2, Throwable th5) {
        sLogDelegate.error(str, str2, th5);
    }

    public static void i(String str, String str2, Throwable th5) {
        sLogDelegate.info(str, str2, th5);
    }

    public static void w(String str, String str2, Throwable th5) {
        sLogDelegate.warn(str, str2, th5);
    }
}
