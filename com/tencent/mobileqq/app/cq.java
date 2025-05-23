package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cq implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public cq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        }
    }

    protected void b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
    }

    protected void c(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4 && obj != null) {
                        Object[] objArr = (Object[]) obj;
                        if (objArr.length >= 1) {
                            Object obj2 = objArr[0];
                            if (obj2 instanceof Boolean) {
                                a(((Boolean) obj2).booleanValue());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (obj != null) {
                    Object[] objArr2 = (Object[]) obj;
                    if (objArr2.length >= 1) {
                        d(((Integer) objArr2[0]).intValue());
                        return;
                    }
                    return;
                }
                return;
            }
            if (obj != null) {
                Object[] objArr3 = (Object[]) obj;
                if (objArr3.length == 1) {
                    b(((Integer) objArr3[0]).intValue());
                    return;
                }
                return;
            }
            return;
        }
        if (obj != null) {
            Object[] objArr4 = (Object[]) obj;
            c(((Integer) objArr4[0]).intValue(), ((Integer) objArr4[1]).intValue());
        }
    }
}
