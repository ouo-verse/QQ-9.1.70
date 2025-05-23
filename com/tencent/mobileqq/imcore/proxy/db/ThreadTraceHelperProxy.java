package com.tencent.mobileqq.imcore.proxy.db;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class ThreadTraceHelperProxy {
    static IPatchRedirector $redirector_;
    private static Proxy proxy;

    /* loaded from: classes15.dex */
    public interface Proxy {
        void addWaitingTransThread(long j3, String str);

        void removeWaitingTransThread(long j3);

        void setCurrentTransThread(long j3, String str);
    }

    public ThreadTraceHelperProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void addWaitingTransThread(long j3, String str) {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            proxy2.addWaitingTransThread(j3, str);
        }
    }

    public static void registerProxy(Proxy proxy2) {
        proxy = proxy2;
    }

    public static void removeWaitingTransThread(long j3) {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            proxy2.removeWaitingTransThread(j3);
        }
    }

    public static void setCurrentTransThread(long j3, String str) {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            proxy2.setCurrentTransThread(j3, str);
        }
    }
}
