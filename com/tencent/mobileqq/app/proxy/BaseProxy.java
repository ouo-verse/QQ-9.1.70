package com.tencent.mobileqq.app.proxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* loaded from: classes11.dex */
public abstract class BaseProxy {
    static IPatchRedirector $redirector_;
    protected AppRuntime app;
    protected BaseProxyManager proxyManager;

    public BaseProxy(AppRuntime appRuntime, BaseProxyManager baseProxyManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) baseProxyManager);
        } else {
            this.app = appRuntime;
            this.proxyManager = baseProxyManager;
        }
    }

    public abstract void destroy();

    public abstract void init();
}
