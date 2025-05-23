package com.tencent.mobileqq.flashtransfer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class j implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), str, str2);
        }
    }

    protected void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    protected void c(int i3, int i16, int i17, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str, str2, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    b();
                    return;
                }
                return;
            } else {
                Object[] objArr = (Object[]) obj;
                a(((Integer) objArr[0]).intValue(), (String) objArr[1], (String) objArr[2]);
                return;
            }
        }
        Object[] objArr2 = (Object[]) obj;
        c(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (String) objArr2[3], (String) objArr2[4], ((Boolean) objArr2[5]).booleanValue());
    }
}
