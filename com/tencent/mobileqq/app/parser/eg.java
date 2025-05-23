package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class eg extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public eg(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private void F() {
        String f16 = f("buddyuin");
        if (!f16.isEmpty()) {
            long parseLong = Long.parseLong(f16);
            if (QLog.isColorLevel()) {
                QLog.d("TroopOneWayAction", 2, "grayTip,openTroopWithCommonFriendsFragment:" + parseLong);
            }
            TroopWithCommonFriendsFragment.Ih(f16);
            TroopWithCommonFriendsFragment.zh(this.f307437b, 1);
            ReportController.o(null, "dc00898", "", "", "0X800AD20", "0X800AD20", 0, 0, "0", "0", "", "");
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        try {
            F();
            return true;
        } catch (Exception e16) {
            QLog.e("TroopOneWayAction", 1, "doAction error: " + e16.getMessage());
            i("TroopOneWayAction");
            return false;
        }
    }
}
