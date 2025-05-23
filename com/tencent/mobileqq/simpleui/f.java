package com.tencent.mobileqq.simpleui;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(int i3, int i16, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void b(boolean z16, boolean z17, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), str);
        }
    }

    protected void c(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void d(boolean z16, boolean z17, int i3, boolean z18, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Boolean.valueOf(z18), str, Long.valueOf(j3));
        }
    }

    protected void e(boolean z16, boolean z17, boolean z18, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        Object[] objArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5 && (objArr = (Object[]) obj) != null && objArr.length == 4) {
                            a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue());
                            return;
                        }
                        return;
                    }
                    Object[] objArr2 = (Object[]) obj;
                    if (objArr2 != null && objArr2.length == 3) {
                        b(z16, ((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        return;
                    }
                    return;
                }
                Object[] objArr3 = (Object[]) obj;
                if (objArr3 != null && objArr3.length == 3) {
                    e(z16, ((Boolean) objArr3[0]).booleanValue(), ((Boolean) objArr3[1]).booleanValue(), ((Integer) objArr3[2]).intValue());
                    return;
                }
                return;
            }
            Object[] objArr4 = (Object[]) obj;
            if (objArr4 != null && objArr4.length == 5) {
                d(z16, ((Boolean) objArr4[0]).booleanValue(), ((Integer) objArr4[1]).intValue(), ((Boolean) objArr4[2]).booleanValue(), (String) objArr4[3], ((Long) objArr4[4]).longValue());
                return;
            }
            return;
        }
        if (obj != null) {
            c(z16, obj);
        }
    }
}
