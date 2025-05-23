package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b implements ManagerFactory {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private <T extends Manager> T b(AppRuntime appRuntime, int i3) {
        try {
            return (T) appRuntime.getManager(i3);
        } catch (Throwable th5) {
            QLog.e("ProxyManagerFactoryImpl", 1, "Wrong type cast, confirm the return proxy type", th5);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.ManagerFactory
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.app.asyncdb.a getCacheManager(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.app.asyncdb.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
        }
        return (com.tencent.mobileqq.app.asyncdb.a) b(appRuntime, QQManagerFactory.CACHE_MANAGER);
    }

    @Override // com.tencent.mobileqq.app.proxy.ManagerFactory
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ProxyManager getProxyManager(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ProxyManager) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        }
        return (ProxyManager) b(appRuntime, QQManagerFactory.PROXY_MANAGER);
    }
}
