package com.tencent.mobileqq.qqgift.api.ipc.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqgift.api.ipc.IQQGiftIPCApi;
import com.tencent.mobileqq.qqgift.ipc.a;

/* loaded from: classes16.dex */
public class QQGiftIPCApiImpl implements IQQGiftIPCApi {
    static IPatchRedirector $redirector_;

    public QQGiftIPCApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqgift.api.ipc.IQQGiftIPCApi
    public QIPCModule getServerIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return a.b();
    }
}
