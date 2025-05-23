package com.tencent.mobileqq.pskey.api.impl;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pskey.api.IPskeyIPCApi;
import com.tencent.mobileqq.pskey.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCModule;

/* loaded from: classes16.dex */
public class PskeyIPCApiImpl implements IPskeyIPCApi {
    static IPatchRedirector $redirector_;

    public PskeyIPCApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pskey.api.IPskeyIPCApi
    @NonNull
    public QIPCModule getPskeyIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return e.INSTANCE.a();
    }
}
