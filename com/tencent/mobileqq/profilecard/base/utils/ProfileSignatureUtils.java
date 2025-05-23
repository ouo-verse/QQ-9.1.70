package com.tencent.mobileqq.profilecard.base.utils;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.k;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.statistics.ReportController;

/* loaded from: classes16.dex */
public class ProfileSignatureUtils {
    static IPatchRedirector $redirector_;

    public ProfileSignatureUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void handleSignatureClick(ProfileCardInfo profileCardInfo, QBaseActivity qBaseActivity, QQAppInterface qQAppInterface) {
        if (profileCardInfo.allInOne.f260789pa == 0) {
            a33.b.h(qBaseActivity, qQAppInterface, 0, "signature_ziliaoka", 48);
        } else {
            Intent intent = new Intent(qBaseActivity, (Class<?>) PublicFragmentActivity.class);
            intent.putExtra("key_uin", profileCardInfo.allInOne.uin);
            intent.putExtra("key_uin_name", profileCardInfo.profileName.f305805a.f305804b);
            intent.putExtra("key_open_via", "history-kerentaiziliaoka");
            PublicFragmentActivity.b.a(qBaseActivity, intent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
        }
        if (profileCardInfo.allInOne.f260789pa == 0) {
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006A79", "0X8006A79", 0, 0, "", "", "", "");
        } else {
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006A8D", "0X8006A8D", 0, 0, "", "", "", "");
        }
    }

    public static void handleSignatureCommonClick(View view, int i3, String str, QBaseActivity qBaseActivity, QQAppInterface qQAppInterface) {
        com.tencent.mobileqq.richstatus.topic.c.d(qBaseActivity, com.tencent.mobileqq.richstatus.topic.c.b(i3, str), -1);
        view.setVisibility(8);
        k.d().q(qQAppInterface);
        ReportController.o(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "1", "0", "", "");
    }
}
