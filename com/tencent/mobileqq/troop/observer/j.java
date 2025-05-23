package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f298029d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f298030e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28792);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f298029d = 0 + 1;
            f298030e = 0;
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(int i3, boolean z16, Object obj) {
        if (i3 != f298030e) {
            return;
        }
        a(z16, (String) ((Object[]) obj)[0]);
    }

    protected void a(boolean z16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
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
