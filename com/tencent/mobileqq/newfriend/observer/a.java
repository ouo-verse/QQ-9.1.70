package com.tencent.mobileqq.newfriend.observer;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements com.tencent.mobileqq.friend.observer.b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(boolean z16, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), objArr);
        } else if (z16 && objArr != null && objArr.length == 1) {
            c((String) objArr[0]);
        }
    }

    protected void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
    }

    public void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
    }

    protected void d(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), str);
        }
    }

    public void e(boolean z16, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    protected void f(boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), bundle);
        }
    }

    protected void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
    }

    protected void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        }
    }

    protected void i(boolean z16, String str, String str2, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, Byte.valueOf(b16));
        }
    }

    public void j(boolean z16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void k(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void l(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 == 27) {
            if (!(obj instanceof Object[])) {
                return;
            }
            Object[] objArr = (Object[]) obj;
            i(z16, (String) objArr[0], (String) objArr[1], ((Byte) objArr[2]).byteValue());
            return;
        }
        if (i3 == 3) {
            l((String) obj, z16);
            return;
        }
        if (i3 == 59) {
            if (z16 && (obj instanceof String)) {
                b((String) obj);
                return;
            }
            return;
        }
        if (i3 == 115) {
            if (!(obj instanceof Object[])) {
                return;
            }
            Object[] objArr2 = (Object[]) obj;
            if (objArr2.length > 1) {
                j(z16, ((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                return;
            }
            return;
        }
        if (i3 == 15) {
            k(z16, obj);
            return;
        }
        if (i3 == 104) {
            g(z16);
            return;
        }
        if (i3 == 103) {
            h(z16);
            return;
        }
        if (i3 == 89) {
            d(z16, (String) obj);
            return;
        }
        if (i3 == 88) {
            if (obj instanceof Bundle) {
                f(z16, (Bundle) obj);
                return;
            } else {
                f(z16, null);
                return;
            }
        }
        if (i3 == 123) {
            if (!(obj instanceof Object[])) {
                return;
            }
            Object[] objArr3 = (Object[]) obj;
            if (objArr3.length > 2) {
                e(z16, ((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue(), ((Integer) objArr3[2]).intValue());
                return;
            }
            return;
        }
        if (i3 != 124 || !(obj instanceof Object[])) {
            return;
        }
        a(z16, (Object[]) obj);
    }
}
