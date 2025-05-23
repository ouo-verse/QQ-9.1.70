package com.tencent.mobileqq.injector;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqperf.tools.PerformanceReportUtils;

/* compiled from: P */
/* loaded from: classes15.dex */
public class y implements com.tencent.mobileqq.inject.n {
    static IPatchRedirector $redirector_;

    public y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.inject.n
    public void a(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Long.valueOf(j3));
        } else {
            PerformanceReportUtils.k(str, j3);
        }
    }
}
