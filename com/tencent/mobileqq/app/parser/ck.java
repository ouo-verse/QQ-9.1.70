package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ck extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public ck(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    private boolean F() {
        ReportController.o(this.f307436a, "CliOper", "", "", "0X80077DE", "0X80077DE", 0, 0, this.f307441f.get("appid"), "", "", "");
        QBaseActivity qBaseActivity = (QBaseActivity) this.f307437b;
        if (qBaseActivity == null) {
            return false;
        }
        ((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).doRegister(qBaseActivity, 7);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        try {
            return F();
        } catch (Exception e16) {
            QLog.e("QQRegisterAction", 1, "doAction error: " + e16.getMessage());
            i("QQRegisterAction");
            return false;
        }
    }
}
