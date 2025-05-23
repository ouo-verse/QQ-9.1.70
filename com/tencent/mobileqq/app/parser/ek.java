package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.together.clockin.ClockMsgIntent;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ek extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public ek(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private void F() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            com.tencent.qqnt.aio.utils.c.f352293a.b(qBaseActivity, "", new ClockMsgIntent.ShowTroopClockDialogMsgIntent(2));
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
