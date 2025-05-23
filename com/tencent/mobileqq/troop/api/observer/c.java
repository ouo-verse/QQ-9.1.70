package com.tencent.mobileqq.troop.api.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f294312d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f294313e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f294314f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f294315h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f294316i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        int i3 = 0 + 1;
        f294313e = 0;
        int i16 = i3 + 1;
        f294314f = i3;
        int i17 = i16 + 1;
        f294315h = i16;
        f294312d = i17 + 1;
        f294316i = i17;
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void e(int i3, boolean z16, Object obj) {
        if (i3 != f294316i) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        a(z16, (String) objArr[0], ((Long) objArr[1]).longValue(), ((Long) objArr[2]).longValue());
    }

    private void f(int i3, boolean z16, Object obj) {
        Object[] objArr;
        int i16;
        if (i3 == f294314f && (obj instanceof Object[]) && (objArr = (Object[]) obj) != null) {
            if (objArr.length >= 4) {
                i16 = ((Integer) objArr[3]).intValue();
            } else {
                i16 = 0;
            }
            b(z16, (String) objArr[0], (String) objArr[1], (String) objArr[2], i16);
        }
    }

    private void g(int i3, boolean z16, Object obj) {
        if (i3 != f294315h || !(obj instanceof Object[])) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length == 0) {
            c(false, -1L, "");
        } else {
            c(z16, ((Long) objArr[0]).longValue(), (String) objArr[1]);
        }
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 == f294313e && (obj instanceof String)) {
            d(z16, (String) obj);
        }
    }

    protected void a(boolean z16, String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    public void b(boolean z16, String str, String str2, String str3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, str3, Integer.valueOf(i3));
        }
    }

    protected void c(boolean z16, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3), str);
        }
    }

    protected void d(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        h(i3, z16, obj);
        f(i3, z16, obj);
        g(i3, z16, obj);
        e(i3, z16, obj);
    }
}
