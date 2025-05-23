package com.tencent.mobileqq.microapp.appbrand;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class g implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f245999a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f246000b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar, int i3) {
        this.f246000b = aVar;
        this.f245999a = i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, i3);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f246000b.f245902g.navigateBack(this.f245999a, false);
        }
    }
}
