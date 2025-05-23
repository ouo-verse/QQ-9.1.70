package com.tencent.mobileqq.troop.announcement.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f293930d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f293931e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f293932f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f293933h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28015);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        int i3 = 0 + 1;
        f293931e = 0;
        int i16 = i3 + 1;
        f293932f = i3;
        f293930d = i16 + 1;
        f293933h = i16;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(int i3, boolean z16, Object obj) {
        if (i3 == f293931e && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            a(z16, (String) objArr[0], (String) objArr[1]);
        }
    }

    private void e(int i3, boolean z16, Object obj) {
        if (i3 != f293932f) {
            return;
        }
        b(z16, obj);
    }

    private void f(int i3, boolean z16, Object obj) {
        if (i3 == f293933h && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    c(z16, (String) obj2, objArr[1]);
                }
            }
        }
    }

    protected void a(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2);
        }
    }

    protected void b(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void c(boolean z16, String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, obj);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        d(i3, z16, obj);
        e(i3, z16, obj);
        f(i3, z16, obj);
    }
}
