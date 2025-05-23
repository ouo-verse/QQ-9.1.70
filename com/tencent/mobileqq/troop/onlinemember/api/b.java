package com.tencent.mobileqq.troop.onlinemember.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a$UserInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int C;
    public static final int D;

    /* renamed from: d, reason: collision with root package name */
    private static int f298031d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f298032e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f298033f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f298034h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f298035i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f298036m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28804);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        int i3 = 0 + 1;
        f298032e = 0;
        int i16 = i3 + 1;
        f298033f = i3;
        int i17 = i16 + 1;
        f298034h = i16;
        int i18 = i17 + 1;
        f298035i = i17;
        int i19 = i18 + 1;
        f298036m = i18;
        int i26 = i19 + 1;
        C = i19;
        f298031d = i26 + 1;
        D = i26;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 != f298033f) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        a(z16, (String) objArr[0], ((Boolean) objArr[1]).booleanValue());
    }

    private void i(int i3, boolean z16, Object obj) {
        if (i3 != f298035i) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        c(z16, (String) objArr[0], (List) objArr[1]);
    }

    private void j(int i3, boolean z16, Object obj) {
        if (i3 != f298036m) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        b(z16, (String) objArr[0], (List) objArr[1]);
    }

    private void k(int i3, boolean z16, Object obj) {
        if (i3 != f298032e) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        f(z16, (String) objArr[0], (String) objArr[1]);
    }

    private void l(int i3, boolean z16, Object obj) {
        if (i3 != C) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        g(z16, (String) objArr[0], (String) objArr[1]);
    }

    private void m(int i3, boolean z16, Object obj) {
        if (i3 != D) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        d(z16, (String) objArr[0], (List) objArr[1]);
    }

    private void n(int i3, boolean z16, Object obj) {
        if (i3 != f298034h) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        e(z16, (String) objArr[0], ((Boolean) objArr[1]).booleanValue());
    }

    protected void a(boolean z16, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
        }
    }

    protected void b(boolean z16, String str, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, list);
        }
    }

    protected void c(boolean z16, String str, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, list);
        }
    }

    protected void d(boolean z16, String str, List<oidb_0xa2a$UserInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str, list);
        }
    }

    protected void e(boolean z16, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
        }
    }

    protected void f(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2);
        }
    }

    protected void g(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str, str2);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        k(i3, z16, obj);
        h(i3, z16, obj);
        i(i3, z16, obj);
        j(i3, z16, obj);
        l(i3, z16, obj);
        m(i3, z16, obj);
        n(i3, z16, obj);
    }
}
