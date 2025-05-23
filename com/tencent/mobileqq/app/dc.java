package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dc implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public dc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), aVar);
        }
    }

    protected void b(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), aVar);
        }
    }

    protected void c(boolean z16, com.tencent.mobileqq.subaccount.logic.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), aVar);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    b(z16, (com.tencent.mobileqq.subaccount.logic.a) obj);
                    return;
                }
                return;
            }
            c(z16, (com.tencent.mobileqq.subaccount.logic.a) obj);
            return;
        }
        a(z16, (com.tencent.mobileqq.subaccount.logic.a) obj);
    }
}
