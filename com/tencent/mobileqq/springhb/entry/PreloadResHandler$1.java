package com.tencent.mobileqq.springhb.entry;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes18.dex */
class PreloadResHandler$1 implements Runnable {
    static IPatchRedirector $redirector_;
    final /* synthetic */ e this$0;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            e.b(null);
        } catch (Throwable th5) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(101, th5, new String[0]);
            }
            th5.printStackTrace();
        }
    }
}
