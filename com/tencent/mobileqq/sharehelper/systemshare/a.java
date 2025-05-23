package com.tencent.mobileqq.sharehelper.systemshare;

import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements ForwardBaseOption.q {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption.q
    public void a(ForwardBaseOption forwardBaseOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) forwardBaseOption);
        } else {
            ReportController.y(forwardBaseOption.getApp(), "0X800BA87");
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption.q
    public void b(ForwardBaseOption forwardBaseOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) forwardBaseOption);
        } else {
            ReportController.y(forwardBaseOption.getApp(), "0X800BA86");
        }
    }
}
