package com.tencent.mobileqq.profilecard.bussiness.accountinfo.report;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;

/* loaded from: classes16.dex */
public class ProfileAccountInfoReport {
    static IPatchRedirector $redirector_;

    public ProfileAccountInfoReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void reportAccountInfoClick(AppInterface appInterface, int i3) {
        ReportController.o(appInterface, "dc00898", "", "", "0X800B1CA", "0X800B1CA", i3, 0, "", "", "", "");
    }
}
