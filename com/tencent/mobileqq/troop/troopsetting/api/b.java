package com.tencent.mobileqq.troop.troopsetting.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int C;

    /* renamed from: d, reason: collision with root package name */
    private static int f301064d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f301065e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f301066f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f301067h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f301068i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f301069m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29572);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        int i3 = 0 + 1;
        f301065e = 0;
        int i16 = i3 + 1;
        f301066f = i3;
        int i17 = i16 + 1;
        f301067h = i16;
        int i18 = i17 + 1;
        f301068i = i17;
        int i19 = i18 + 1;
        f301069m = i18;
        f301064d = i19 + 1;
        C = i19;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void g(int i3, boolean z16, Object obj) {
        if (i3 != f301069m) {
            return;
        }
        a(z16, ((Boolean) ((Object[]) obj)[0]).booleanValue());
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 == f301065e && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof Integer) {
                        b(z16, (String) obj2, ((Integer) obj3).intValue());
                        f((String) objArr[0]);
                    }
                }
            }
        }
    }

    private void i(int i3, boolean z16, Object obj) {
        if (i3 != f301067h) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        c(z16, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
    }

    private void j(int i3, boolean z16, Object obj) {
        if (i3 != f301068i) {
            return;
        }
        d(z16, ((Boolean) ((Object[]) obj)[0]).booleanValue());
    }

    private void k(int i3, boolean z16, Object obj) {
        if (i3 == C && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            e((String) objArr[0], (String) objArr[1], (String) objArr[2]);
        }
    }

    protected void a(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void b(boolean z16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
        }
    }

    protected void c(boolean z16, String str, String str2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void d(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
    }

    protected void e(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3);
        }
    }

    protected void f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        h(i3, z16, obj);
        i(i3, z16, obj);
        j(i3, z16, obj);
        g(i3, z16, obj);
        k(i3, z16, obj);
    }
}
