package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class g implements t {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public boolean a(AppRuntime appRuntime, Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, activity, str)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public boolean c(Activity activity, int i3, String str, Bundle bundle, x xVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 7, this, activity, Integer.valueOf(i3), str, bundle, xVar)).booleanValue();
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public boolean d(Activity activity, String str, x xVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, activity, str, xVar)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public void e(Activity activity, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity, (Object) appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public boolean f(Activity activity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) str)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.loginregister.t
    public void k(Activity activity, AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, activity, appRuntime, str);
        }
    }
}
