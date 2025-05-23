package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(boolean z16, Object obj) {
        String str;
        boolean z17 = false;
        if (z16 && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 8) {
                e(true, (String) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2], ((Integer) objArr[3]).intValue(), (String) objArr[4], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Boolean) objArr[7]).booleanValue());
                return;
            }
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr2 = (Object[]) obj;
            if (objArr2.length >= 2) {
                str = (String) objArr2[0];
                z17 = ((Boolean) objArr2[1]).booleanValue();
                e(false, str, 0, null, 0, null, 60, 1200, z17);
            }
        }
        str = null;
        e(false, str, 0, null, 0, null, 60, 1200, z17);
    }

    private void b(boolean z16, Object obj) {
        String str;
        if (z16 && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 3) {
                f(true, (String) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2]);
                return;
            }
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr2 = (Object[]) obj;
            if (objArr2.length > 0) {
                str = (String) objArr2[0];
                f(false, str, 0, null);
            }
        }
        str = null;
        f(false, str, 0, null);
    }

    private void c(boolean z16, Object obj) {
        String str;
        if (z16 && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 4) {
                g(true, (String) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2], (List) objArr[3]);
                return;
            }
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr2 = (Object[]) obj;
            if (objArr2.length > 0) {
                str = (String) objArr2[0];
                g(false, str, 0, null, null);
            }
        }
        str = null;
        g(false, str, 0, null, null);
    }

    private void d(boolean z16, Object obj) {
        if (z16 && obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 3) {
                h((String) objArr[0], (String) objArr[1], (List) objArr[2]);
            }
        }
    }

    public void e(boolean z16, String str, int i3, String str2, int i16, String str3, int i17, int i18, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), str3, Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z17));
        }
    }

    public void f(boolean z16, String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2);
        }
    }

    public void g(boolean z16, String str, int i3, String str2, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, list);
        }
    }

    public void h(String str, String str2, List<d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, list);
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
                    if (i3 == 4) {
                        d(z16, obj);
                        return;
                    }
                    return;
                }
                c(z16, obj);
                return;
            }
            b(z16, obj);
            return;
        }
        a(z16, obj);
    }
}
