package com.tencent.mobileqq.troopmanage.base;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.List;
import tencent.im.oidb.cmd0x6f6.oidb_cmd0x6f6$RspInfo;
import tencent.im.oidb.cmd0xb69.oidb_0xb69$AppInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<Integer, com.tencent.mobileqq.troopmanage.base.handler.b> f303035d;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f303035d = new HashMap<>();
            i();
        }
    }

    private void a(int i3, boolean z16, Object obj) {
        Object obj2;
        if (i3 != 26) {
            return;
        }
        if (z16 && obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 1 && (obj2 = objArr[0]) != null) {
                k(true, (List) obj2);
                return;
            } else {
                k(false, null);
                return;
            }
        }
        k(false, null);
    }

    private void b(int i3, boolean z16, Object obj) {
        if (i3 != 18) {
            return;
        }
        l((List) obj);
    }

    private void c(int i3, boolean z16, Object obj) {
        long longValue;
        if (i3 != 13) {
            return;
        }
        Object obj2 = ((Object[]) obj)[0];
        if (obj2 == null) {
            longValue = 0;
        } else {
            longValue = ((Long) obj2).longValue();
        }
        m(z16, longValue);
    }

    private void d(int i3, boolean z16, Object obj) {
        if (i3 != 16) {
            return;
        }
        n(z16);
    }

    private void e(int i3, boolean z16, Object obj) {
        if (i3 != 10) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        if (z16 && objArr != null) {
            j(z16, (List) objArr[0]);
        } else {
            j(false, null);
        }
    }

    private void f(int i3, boolean z16, Object obj) {
        if (i3 == 27 && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                Object obj2 = objArr[0];
                if ((obj2 instanceof Integer) && (objArr[1] instanceof String) && (objArr[2] instanceof Boolean)) {
                    p(z16, ((Integer) obj2).intValue(), (String) objArr[1], ((Boolean) objArr[2]).booleanValue());
                }
            }
        }
    }

    private void g(int i3, boolean z16, Object obj) {
        if (i3 != 30) {
            return;
        }
        q(z16, ((Boolean) obj).booleanValue());
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 != 29) {
            return;
        }
        r(z16, ((Boolean) obj).booleanValue());
    }

    private void i() {
        this.f303035d.put(28, new com.tencent.mobileqq.troopmanage.base.handler.a(this));
    }

    public void j(boolean z16, List<oidb_cmd0x6f6$RspInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), list);
        }
    }

    public void k(boolean z16, List<com.tencent.mobileqq.troopmanage.model.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), list);
        }
    }

    public void l(List<oidb_0xb69$AppInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        }
    }

    public void m(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Long.valueOf(j3));
        }
    }

    public void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
    }

    public void o(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        com.tencent.mobileqq.troopmanage.base.handler.b bVar = this.f303035d.get(Integer.valueOf(i3));
        if (bVar != null) {
            bVar.onUpdate(i3, z16, obj);
        }
        e(i3, z16, obj);
        c(i3, z16, obj);
        f(i3, z16, obj);
        a(i3, z16, obj);
        b(i3, z16, obj);
        d(i3, z16, obj);
        h(i3, z16, obj);
        g(i3, z16, obj);
    }

    public void p(boolean z16, int i3, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, Boolean.valueOf(z17));
        }
    }

    public void q(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    public void r(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }
}
