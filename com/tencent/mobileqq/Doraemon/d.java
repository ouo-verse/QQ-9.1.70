package com.tencent.mobileqq.Doraemon;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class d {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(Bundle bundle) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        Bundle bundle2 = bundle.getBundle("key_result");
        if (bundle2 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        b(z16, bundle2);
    }

    protected abstract void b(boolean z16, Bundle bundle);
}
