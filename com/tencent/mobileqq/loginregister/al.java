package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qwallet.plugin.PatternLockUtils;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class al extends g {
    static IPatchRedirector $redirector_;

    public al() {
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
        PatternLockUtils.setFirstEnterAfterLoginState(activity, appRuntime.getAccount(), true);
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.g, com.tencent.mobileqq.loginregister.t
    public void k(Activity activity, AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, appRuntime, str);
        } else {
            PatternLockUtils.setFirstEnterAfterLoginState(activity, str, true);
        }
    }
}
