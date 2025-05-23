package com.tencent.mobileqq.gateway.localphone.ecdh.api.impl;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.gateway.localphone.ecdh.api.ILocalPhoneIPCApi;
import com.tencent.mobileqq.gateway.localphone.ecdh.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;

/* loaded from: classes12.dex */
public class LocalPhoneIPCApiImpl implements ILocalPhoneIPCApi {
    static IPatchRedirector $redirector_;

    public LocalPhoneIPCApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.gateway.localphone.ecdh.api.ILocalPhoneIPCApi
    @NonNull
    public QIPCModule getLocalPhoneIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new h();
    }
}
