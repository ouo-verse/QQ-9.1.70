package com.tencent.msdk.dns;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
class MSDKDnsResolver$b implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f336168d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f336169e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ c f336170f;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f336170f.e(this.f336168d);
        c.b();
        com.tencent.msdk.dns.base.jni.a.b(this.f336169e);
    }
}
