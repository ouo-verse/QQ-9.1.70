package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.api.IQRToolProcStartApi;
import com.tencent.mobileqq.qrscan.g;
import com.tencent.mobileqq.qrscan.ipc.a;
import com.tencent.qphone.base.util.BaseApplication;

/* loaded from: classes17.dex */
public class QRToolProcStartApiImpl implements IQRToolProcStartApi {
    static IPatchRedirector $redirector_;

    public QRToolProcStartApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRToolProcStartApi
    public g get() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (g) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a(BaseApplication.getContext());
    }
}
