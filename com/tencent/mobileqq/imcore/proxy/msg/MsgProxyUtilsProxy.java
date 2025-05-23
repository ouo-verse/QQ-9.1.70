package com.tencent.mobileqq.imcore.proxy.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class MsgProxyUtilsProxy {
    static IPatchRedirector $redirector_;
    private static Proxy proxy;

    /* loaded from: classes15.dex */
    public interface Proxy {
        boolean isSaveConversation(String str, String str2, int i3, int i16);
    }

    public MsgProxyUtilsProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isSaveConversation(String str, String str2, int i3, int i16) {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            return proxy2.isSaveConversation(str, str2, i3, i16);
        }
        return true;
    }

    public static void registerProxy(Proxy proxy2) {
        proxy = proxy2;
    }
}
