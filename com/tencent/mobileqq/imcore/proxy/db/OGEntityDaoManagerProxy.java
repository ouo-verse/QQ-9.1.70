package com.tencent.mobileqq.imcore.proxy.db;

import com.tencent.mobileqq.persistence.OGAbstractDao;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class OGEntityDaoManagerProxy {
    static IPatchRedirector $redirector_;
    private static Proxy proxy;

    /* loaded from: classes15.dex */
    public interface Proxy {
        OGAbstractDao getEntityDao(Class cls);
    }

    public OGEntityDaoManagerProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static OGAbstractDao getEntityDao(Class cls) {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            return proxy2.getEntityDao(cls);
        }
        return null;
    }

    public static void registerProxy(Proxy proxy2) {
        proxy = proxy2;
    }
}
