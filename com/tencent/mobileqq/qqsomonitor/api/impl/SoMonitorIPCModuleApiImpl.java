package com.tencent.mobileqq.qqsomonitor.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorIPCModuleApi;
import com.tencent.mobileqq.qqsomonitor.c;

/* loaded from: classes17.dex */
public class SoMonitorIPCModuleApiImpl implements ISoMonitorIPCModuleApi {
    static IPatchRedirector $redirector_;

    public SoMonitorIPCModuleApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqsomonitor.api.ISoMonitorIPCModuleApi
    public QIPCModule getQIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return c.b();
    }
}
