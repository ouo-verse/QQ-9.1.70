package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ah extends g {
    static IPatchRedirector $redirector_;

    public ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.g, com.tencent.mobileqq.loginregister.t
    public boolean a(AppRuntime appRuntime, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, activity, str)).booleanValue();
        }
        MiniAppSecurityUtil.doClearAfterLoginSuccess(false);
        return true;
    }
}
