package com.tencent.msdk.dns;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
class MSDKDnsResolver$a implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f336165d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f336166e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ c f336167f;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f336167f.c(this.f336165d);
        c.b();
        com.tencent.msdk.dns.base.jni.a.b(this.f336166e);
    }
}
