package com.tencent.mobileqq.imcore.proxy.db;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class ThreadRegulatorProxy {
    static IPatchRedirector $redirector_;
    private static Proxy proxy;

    /* loaded from: classes15.dex */
    public interface Proxy {
        void checkInNextBusiness();
    }

    public ThreadRegulatorProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void checkInNextBusiness() {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            proxy2.checkInNextBusiness();
        }
    }

    public static void registerProxy(Proxy proxy2) {
        proxy = proxy2;
    }
}
