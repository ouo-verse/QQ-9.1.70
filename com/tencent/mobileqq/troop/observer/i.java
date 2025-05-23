package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i implements BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int C;
    public static final int D;

    /* renamed from: d, reason: collision with root package name */
    private static int f298023d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f298024e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f298025f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f298026h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f298027i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f298028m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28786);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        int i3 = 0 + 1;
        f298024e = 0;
        int i16 = i3 + 1;
        f298025f = i3;
        int i17 = i16 + 1;
        f298026h = i16;
        int i18 = i17 + 1;
        f298027i = i17;
        int i19 = i18 + 1;
        f298028m = i18;
        int i26 = i19 + 1;
        C = i19;
        f298023d = i26 + 1;
        D = i26;
    }

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void g(int i3, boolean z16, Object obj) {
        if (i3 != f298024e) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        b(z16, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue());
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 == f298025f && (obj instanceof Object[])) {
            a(z16, (String) ((Object[]) obj)[0]);
        }
    }

    private void i(int i3, boolean z16, Object obj) {
        if (i3 == D && (obj instanceof Object[])) {
            c(z16, (String) ((Object[]) obj)[0]);
        }
    }

    private void j(int i3, boolean z16, Object obj) {
        if (i3 == f298026h && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                e((String) objArr[0], ((Boolean) objArr[1]).booleanValue());
            }
        }
    }

    private void k(int i3, boolean z16, Object obj) {
        if (i3 == C && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            d(z16, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
        }
    }

    private void l(int i3, boolean z16, Object obj) {
        if (i3 == f298028m && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            f(z16, ((Boolean) objArr[0]).booleanValue(), (List) objArr[1], ((Integer) objArr[2]).intValue());
        }
    }

    protected void a(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
        }
    }

    protected void b(boolean z16, String str, String str2, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2, Boolean.valueOf(z17));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str);
        }
    }

    protected void d(boolean z16, String str, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
    }

    protected void e(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16));
        }
    }

    protected void f(boolean z16, boolean z17, List<com.tencent.mobileqq.troop.unreadmsg.a> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        h(i3, z16, obj);
        g(i3, z16, obj);
        j(i3, z16, obj);
        l(i3, z16, obj);
        k(i3, z16, obj);
        i(i3, z16, obj);
    }
}
