package com.tencent.mobileqq.microapp.appbrand;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class f implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f245997a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f245998b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, String str) {
        this.f245998b = aVar;
        this.f245997a = str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) str);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f245998b.f245902g.navigateTo(this.f245997a);
        }
    }
}
