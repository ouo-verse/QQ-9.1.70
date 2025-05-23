package com.tencent.qqprotect.xps.api.impl;

import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqprotect.report.a;
import com.tencent.qqprotect.xps.api.IQccApi;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QccApiImpl implements IQccApi {
    static IPatchRedirector $redirector_;

    public QccApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqprotect.xps.api.IQccApi
    public void delayReportSecInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            GuardManagerCallbackDispatcher.registerCallBack(new a());
        }
    }

    @Override // com.tencent.qqprotect.xps.api.IQccApi
    public byte[] getSecInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "".getBytes(StandardCharsets.UTF_8);
    }

    @Override // com.tencent.qqprotect.xps.api.IQccApi
    public void rtReportSecInfo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }
}
