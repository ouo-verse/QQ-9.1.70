package com.tencent.mobileqq.injector;

import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ah implements com.tencent.mobileqq.inject.t {
    static IPatchRedirector $redirector_;

    public ah() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.inject.t
    public void a(Window window) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) window);
        } else {
            com.tencent.mobileqq.theme.a.d(window);
        }
    }
}
