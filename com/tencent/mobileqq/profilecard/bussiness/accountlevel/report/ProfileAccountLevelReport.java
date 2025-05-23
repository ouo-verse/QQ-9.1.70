package com.tencent.mobileqq.profilecard.bussiness.accountlevel.report;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;

/* loaded from: classes16.dex */
public class ProfileAccountLevelReport {
    static IPatchRedirector $redirector_;

    public ProfileAccountLevelReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void reportAccountDarenClick(QQAppInterface qQAppInterface, int i3) {
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B1C9", "0X800B1C9", i3, 0, "", "", "", "");
    }

    public static void reportAccountLevelClick(QQAppInterface qQAppInterface, int i3) {
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800B1C8", "0X800B1C8", i3, 0, "", "", "", "");
    }

    public static void reportAccountLevelVisible(QQAppInterface qQAppInterface, ProfileCardInfo profileCardInfo) {
        int J2 = VipInfoHandler.J2(qQAppInterface, qQAppInterface.getCurrentUin(), false);
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A8C6", "0X800A8C6", J2, 0, String.valueOf(J2), "", "", "");
        if (profileCardInfo.allInOne.f260789pa != 0) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X800A8C7", "0X800A8C7", J2, 0, String.valueOf(J2), "", "", "");
        }
    }
}
