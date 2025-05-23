package com.tencent.mobileqq.microapp.appbrand;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class i implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f246003a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f246004b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, String str) {
        this.f246004b = aVar;
        this.f246003a = str;
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
            this.f246004b.a(this.f246003a);
        }
    }
}
