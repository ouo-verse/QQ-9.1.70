package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.api.ITRTCIPCApi;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule;

/* loaded from: classes17.dex */
public class TRTCIPCApiImpl implements ITRTCIPCApi {
    static IPatchRedirector $redirector_;

    public TRTCIPCApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ITRTCIPCApi
    public QIPCModule getServerIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return TRTCServerIPCModule.h();
    }
}
