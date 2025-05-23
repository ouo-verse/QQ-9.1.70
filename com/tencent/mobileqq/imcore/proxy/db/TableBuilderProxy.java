package com.tencent.mobileqq.imcore.proxy.db;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes15.dex */
public class TableBuilderProxy {
    static IPatchRedirector $redirector_;
    private static Proxy proxy;

    /* loaded from: classes15.dex */
    public interface Proxy {
        String createIndexSQLStatement(Entity entity);

        Class[] getNeedPrivateFieldsClass();
    }

    public TableBuilderProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String createIndexSQLStatement(Entity entity) {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            return proxy2.createIndexSQLStatement(entity);
        }
        return null;
    }

    public static Class[] getNeedPrivateFieldsClass() {
        Proxy proxy2 = proxy;
        if (proxy2 != null) {
            return proxy2.getNeedPrivateFieldsClass();
        }
        return new Class[0];
    }

    public static void registerProxy(Proxy proxy2) {
        proxy = proxy2;
    }
}
