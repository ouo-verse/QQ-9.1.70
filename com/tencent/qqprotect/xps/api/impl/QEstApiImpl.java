package com.tencent.qqprotect.xps.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqprotect.xps.api.IQEstApi;
import com.tencent.qqprotect.xps.core.AntEst;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QEstApiImpl implements IQEstApi {
    static IPatchRedirector $redirector_;

    public QEstApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqprotect.xps.api.IQEstApi
    public void delayReportSecInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            AntEst.e().b();
        }
    }

    @Override // com.tencent.qqprotect.xps.api.IQEstApi
    public String getSecInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return AntEst.e().d();
    }

    @Override // com.tencent.qqprotect.xps.api.IQEstApi
    public void rtReportSecInfo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            AntEst.e().f(i3);
        }
    }
}
