package com.tencent.mobileqq.imcore.proxy.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class AIOUtilsProxy {
    static IPatchRedirector $redirector_;
    private static Proxy proxy;

    /* loaded from: classes15.dex */
    public interface Proxy {
        boolean getLogcatDBOperation();
    }

    public AIOUtilsProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean getLogcatDBOperation() {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            return proxy2.getLogcatDBOperation();
        }
        return false;
    }

    public static void registerProxy(Proxy proxy2) {
        proxy = proxy2;
    }
}
