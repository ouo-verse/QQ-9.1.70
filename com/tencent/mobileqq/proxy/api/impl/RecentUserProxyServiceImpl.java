package com.tencent.mobileqq.proxy.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache;
import com.tencent.mobileqq.app.asyncdb.cache.RecentForwardUserCache;
import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class RecentUserProxyServiceImpl implements IRecentUserProxyService {
    static IPatchRedirector $redirector_;
    IRecentForwardUserProxy recentForwardUserProxy;
    RecentUserProxy recentUserProxy;

    public RecentUserProxyServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.recentUserProxy = null;
        }
    }

    @Override // com.tencent.mobileqq.proxy.api.IRecentUserProxyService
    public IRecentForwardUserProxy getRecentForwardCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IRecentForwardUserProxy) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.recentForwardUserProxy;
    }

    @Override // com.tencent.mobileqq.proxy.api.IRecentUserProxyService
    public RecentUserProxy getRecentUserCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecentUserProxy) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.recentUserProxy;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
            return;
        }
        if (this.recentUserProxy == null) {
            synchronized (this) {
                if (this.recentUserProxy == null) {
                    this.recentUserProxy = new BaseRecentUserCache((BaseQQAppInterface) appRuntime, appRuntime.getCacheManagerInner().getDBDelayManager());
                }
            }
        }
        if (this.recentForwardUserProxy == null) {
            synchronized (this) {
                if (this.recentForwardUserProxy == null) {
                    this.recentForwardUserProxy = new RecentForwardUserCache((BaseQQAppInterface) appRuntime, appRuntime.getCacheManagerInner().getDBDelayManager());
                }
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }
}
