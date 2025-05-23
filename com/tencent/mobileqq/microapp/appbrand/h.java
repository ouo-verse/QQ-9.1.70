package com.tencent.mobileqq.microapp.appbrand;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class h implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f246001a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a f246002b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str) {
        this.f246002b = aVar;
        this.f246001a = str;
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
            this.f246002b.f245902g.swichTab(this.f246001a);
        }
    }
}
