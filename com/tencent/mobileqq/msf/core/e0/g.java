package com.tencent.mobileqq.msf.core.e0;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g extends c<e> implements e {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.core.e0.e
    public void a(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
            return;
        }
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                ((e) obj).a(toServiceMsg);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.e0.e
    public void b(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg);
            return;
        }
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                ((e) obj).b(toServiceMsg);
            }
        }
    }

    @Override // com.tencent.mobileqq.msf.core.e0.e
    public void c(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg);
            return;
        }
        Object[] a16 = a();
        if (a16 != null) {
            for (Object obj : a16) {
                ((e) obj).c(toServiceMsg);
            }
        }
    }
}
