package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.QQSettingUtil;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ag extends g {
    static IPatchRedirector $redirector_;

    public ag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.g, com.tencent.mobileqq.loginregister.t
    public void e(Activity activity, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) appRuntime);
            return;
        }
        com.tencent.qqconnect.wtlogin.c.b(activity);
        QQSettingUtil.i(activity, appRuntime.getCurrentAccountUin(), QQSettingUtil.d(activity, appRuntime.getCurrentAccountUin()) + 1);
    }
}
