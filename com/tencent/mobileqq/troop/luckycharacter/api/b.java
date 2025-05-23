package com.tencent.mobileqq.troop.luckycharacter.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f297771d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f297772e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28651);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f297771d = 0 + 1;
            f297772e = 0;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(int i3, boolean z16, Object obj) {
        if (i3 == f297772e && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof String) {
                        a(z16, (String) obj2, (String) obj3);
                    }
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

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            b(i3, z16, obj);
        }
    }
}
