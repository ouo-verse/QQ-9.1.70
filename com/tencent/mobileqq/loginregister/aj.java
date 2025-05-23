package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.OpenSdkIMBlockFragment;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class aj extends f {
    static IPatchRedirector $redirector_;

    public aj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.f, com.tencent.mobileqq.loginregister.s
    public void h(QBaseActivity qBaseActivity, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qBaseActivity, str, Boolean.valueOf(z16));
        } else {
            OpenProxy.c().b(str);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.f, com.tencent.mobileqq.loginregister.s
    public void j(Activity activity, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) bundle);
            return;
        }
        boolean n3 = com.tencent.open.agent.util.c.n(bundle);
        QLog.i("OpenSdkLoginAction", 1, "onLoginActivityCreate isFromOpenSdk: " + n3);
        if (!n3) {
            OpenSdkIMBlockFragment.th(activity, up3.b.i(), true);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.f, com.tencent.mobileqq.loginregister.s
    public void l(QBaseActivity qBaseActivity, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qBaseActivity, (Object) str);
        } else {
            OpenProxy.c().b(str);
        }
    }
}
