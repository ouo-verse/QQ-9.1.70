package com.tencent.mobileqq.app.lifecycle;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.theme.DarkModeManager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends DefaultBaseActivityLifecycleCallback {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnConfigurationChanged(Activity activity, Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) configuration);
            return;
        }
        if (!DarkModeManager.m()) {
            return;
        }
        int i3 = configuration.uiMode & 48;
        if (i3 == 16 || i3 == 32) {
            DarkModeManager.u(null);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void onRestoreInstanceState(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) bundle);
        } else {
            if (!DarkModeManager.m()) {
                return;
            }
            DarkModeManager.u(null);
        }
    }
}
