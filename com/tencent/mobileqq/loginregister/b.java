package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import mqq.app.AutoLoginUtil;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends g {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.g, com.tencent.mobileqq.loginregister.t
    public void k(Activity activity, AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, appRuntime, str);
        } else if (!str.equalsIgnoreCase(appRuntime.getAccount())) {
            AutoLoginUtil.setAutoLogin(str, true);
        }
    }
}
