package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes11.dex */
public class av implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f195391d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f195392e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f195393f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f195394h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f195395i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69753);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        int i3 = 0 + 1;
        f195392e = 0;
        int i16 = i3 + 1;
        f195393f = i3;
        int i17 = i16 + 1;
        f195394h = i16;
        f195391d = i17 + 1;
        f195395i = i17;
    }

    public av() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void e(int i3, boolean z16, Object obj) {
        if (i3 != f195395i) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        a(z16, (String) objArr[0], ((Boolean) objArr[1]).booleanValue());
    }

    private void f(int i3, boolean z16, Object obj) {
        if (i3 != f195392e) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        b(z16, (String) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2], ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), (String) objArr[5], (String) objArr[6], ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue(), ((Long) objArr[9]).longValue());
    }

    private void g(int i3, boolean z16, Object obj) {
        if (i3 != f195393f) {
            return;
        }
        d(obj);
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 != f195394h) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length > 3) {
            c(z16, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue());
        } else {
            c(z16, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue(), false, 0, 0);
        }
    }

    protected void a(boolean z16, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
        }
    }

    protected void b(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18, int i19, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17), str3, str4, Integer.valueOf(i18), Integer.valueOf(i19), Long.valueOf(j3));
        }
    }

    protected void c(boolean z16, String str, int i3, boolean z17, boolean z18, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    protected void d(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        f(i3, z16, obj);
        g(i3, z16, obj);
        h(i3, z16, obj);
        e(i3, z16, obj);
    }
}
