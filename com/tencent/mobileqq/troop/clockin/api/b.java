package com.tencent.mobileqq.troop.clockin.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f294682d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f294683e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f294684f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28431);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        int i3 = 0 + 1;
        f294683e = 0;
        f294682d = i3 + 1;
        f294684f = i3;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(int i3, boolean z16, Object obj) {
        if (i3 != f294683e) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 4) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof String) {
                        Object obj4 = objArr[3];
                        if (obj4 instanceof Integer) {
                            a(z16, (String) obj2, (String) obj3, objArr[2], ((Integer) obj4).intValue());
                            return;
                        }
                    }
                }
            }
            a(false, "", "", null, -1);
            return;
        }
        a(false, "", "", null, -1);
    }

    private void d(int i3, boolean z16, Object obj) {
        if (i3 != f294684f) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof String) {
                        b(z16, (String) obj2, (String) obj3, objArr[2]);
                        return;
                    }
                }
            }
            b(false, "", "", null);
            return;
        }
        b(false, "", "", null);
    }

    protected void a(boolean z16, String str, String str2, Object obj, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, obj, Integer.valueOf(i3));
        }
    }

    protected void b(boolean z16, String str, String str2, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2, obj);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            c(i3, z16, obj);
            d(i3, z16, obj);
        }
    }
}
