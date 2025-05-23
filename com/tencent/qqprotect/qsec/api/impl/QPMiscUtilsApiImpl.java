package com.tencent.qqprotect.qsec.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqprotect.common.a;
import com.tencent.qqprotect.qsec.api.IQPMiscUtilsApi;

/* loaded from: classes25.dex */
public class QPMiscUtilsApiImpl implements IQPMiscUtilsApi {
    static IPatchRedirector $redirector_;

    public QPMiscUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqprotect.qsec.api.IQPMiscUtilsApi
    public String getAppPackageName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return a.a();
    }
}
