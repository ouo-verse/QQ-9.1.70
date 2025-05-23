package com.tencent.mobileqq.imcore.proxy.db;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class SQLiteFTSUtilsProxy {
    static IPatchRedirector $redirector_;
    private static Proxy proxy;

    /* loaded from: classes15.dex */
    public interface Proxy {
        int getFTSNotifyFlag();
    }

    public SQLiteFTSUtilsProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getFTSNotifyFlag() {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            return proxy2.getFTSNotifyFlag();
        }
        return 0;
    }

    public static void registerProxy(Proxy proxy2) {
        proxy = proxy2;
    }
}
