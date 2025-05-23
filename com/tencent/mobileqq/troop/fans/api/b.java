package com.tencent.mobileqq.troop.fans.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f295399d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f295400e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f295401f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f295402h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28565);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        int i3 = 0 + 1;
        f295400e = 0;
        int i16 = i3 + 1;
        f295401f = i3;
        f295399d = i16 + 1;
        f295402h = i16;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(int i3, boolean z16, Object obj) {
        if (i3 != f295402h) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                a(z16, (String) objArr[0], objArr[1], ((Integer) objArr[2]).intValue());
                return;
            } else {
                a(false, "", null, -1);
                return;
            }
        }
        a(false, "", null, -1);
    }

    protected void a(boolean z16, String str, Object obj, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, obj, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            b(i3, z16, obj);
        }
    }
}
