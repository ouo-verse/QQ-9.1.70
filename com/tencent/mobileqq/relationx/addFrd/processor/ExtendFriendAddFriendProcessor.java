package com.tencent.mobileqq.relationx.addFrd.processor;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.addfriend.processor.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

@KeepClassConstructor
/* loaded from: classes17.dex */
public class ExtendFriendAddFriendProcessor extends a {
    static IPatchRedirector $redirector_;

    public ExtendFriendAddFriendProcessor(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    @Override // com.tencent.mobileqq.addfriend.processor.a
    public void a(Intent intent, Activity activity, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, activity, str, Integer.valueOf(i3));
            return;
        }
        if (activity == null) {
            return;
        }
        int intExtra = activity.getIntent().getIntExtra("sub_source_id", 8);
        if (AppSetting.t(activity) && !activity.getIntent().hasExtra("sub_source_id")) {
            if (QLog.isColorLevel()) {
                QLog.i("ExtendFriendAddFriendProcessor", 1, "PadSplitMode, has no subsourceid from activity intent");
                return;
            }
            return;
        }
        intent.putExtra("sub_source_id", intExtra);
    }

    @Override // com.tencent.mobileqq.addfriend.processor.a
    public void b(String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        AppInterface appInterface = this.f187364a.get();
        if (i3 == 3094) {
            if (i16 == 1) {
                ReportController.r(appInterface, "dc00898", "", str, "0X80092E3", "0X80092E3", 0, 0, "", ExtendFriendReport.c(), ExtendFriendReport.g((QQAppInterface) appInterface), ExtendFriendReport.d());
                return;
            }
            if (i16 == 2) {
                ReportController.r(appInterface, "dc00898", "", str, "0X80092CC", "0X80092CC", 0, 0, "", "", ExtendFriendReport.g((QQAppInterface) appInterface), "");
            } else if (i16 == 8) {
                ReportController.r(appInterface, "dc00898", "", str, "0X800A69D", "0X800A69D", i17, 0, "", "", "", "");
            } else if (i16 == 9) {
                ReportController.r(appInterface, "dc00898", "", str, "0X800A69D", "0X800A69D", i17, 0, "", "", "", "");
            }
        }
    }
}
