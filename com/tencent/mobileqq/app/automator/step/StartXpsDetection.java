package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqprotect.xps.api.IQEstApi;
import com.tencent.qqprotect.xps.api.IQccApi;

/* compiled from: P */
/* loaded from: classes11.dex */
public class StartXpsDetection extends AsyncStep<Automator> {
    static IPatchRedirector $redirector_;

    public StartXpsDetection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.automator.AsyncStep
    public int doStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        ((IQccApi) QRoute.api(IQccApi.class)).delayReportSecInfo();
        ((IQEstApi) QRoute.api(IQEstApi.class)).delayReportSecInfo();
        return 7;
    }
}
