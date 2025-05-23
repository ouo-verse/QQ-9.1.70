package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void i(int i3, boolean z16, Object obj) {
        if (i3 != 20) {
            return;
        }
        a(obj);
    }

    private void j(int i3, boolean z16, Object[] objArr) {
        if (i3 == 41 && objArr != null) {
            b((com.tencent.mobileqq.troop.data.t) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), (String) objArr[3], (String) objArr[4], (Bundle) objArr[5]);
        }
    }

    private void k(int i3, boolean z16, Object[] objArr) {
        if (i3 == 31 && objArr != null) {
            c(z16, ((Boolean) objArr[1]).booleanValue());
        }
    }

    private void l(int i3, boolean z16, Object obj) {
        if (i3 != 2) {
            return;
        }
        h(z16, obj);
    }

    private void m(int i3, boolean z16, Object obj) {
        if (i3 != 39) {
            return;
        }
        d(z16, obj);
    }

    private void n(int i3, boolean z16, Object obj) {
        if (i3 != 13) {
            return;
        }
        e(obj);
    }

    private void o(int i3, boolean z16, Object obj) {
        if (i3 != 40) {
            return;
        }
        f(z16, obj);
    }

    private void p(int i3, boolean z16, Object obj) {
        if (i3 != 9) {
            return;
        }
        g(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
        }
    }

    protected void b(com.tencent.mobileqq.troop.data.t tVar, int i3, int i16, String str, String str2, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, tVar, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, bundle);
        }
    }

    protected void c(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void d(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void e(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
    }

    protected void f(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void g(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, obj);
        }
    }

    protected void h(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), obj);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public final void onUpdate(int i3, boolean z16, Object obj) {
        Object[] objArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (obj instanceof Object[]) {
            objArr = (Object[]) obj;
        } else {
            objArr = null;
        }
        l(i3, z16, obj);
        p(i3, z16, obj);
        n(i3, z16, obj);
        i(i3, z16, obj);
        k(i3, z16, objArr);
        m(i3, z16, obj);
        o(i3, z16, obj);
        j(i3, z16, objArr);
    }
}
