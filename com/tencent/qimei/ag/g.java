package com.tencent.qimei.ag;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class g implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f342979a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f342980b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f342981c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f342982d;

    public g(h hVar, e eVar, String str, String str2) {
        this.f342982d = hVar;
        this.f342979a = eVar;
        this.f342980b = str;
        this.f342981c = str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, hVar, eVar, str, str2);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (this.f342982d) {
            h.a(this.f342982d, this.f342979a, this.f342980b, this.f342981c);
        }
    }
}
