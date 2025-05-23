package com.tencent.qimei.ae;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.tencent.qimei.u.d f342950a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f342951b;

    public e(a aVar, com.tencent.qimei.u.d dVar) {
        this.f342951b = aVar;
        this.f342950a = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) dVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.qimei.u.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (this.f342951b.f342946b) {
            if (!this.f342951b.f342947c) {
                synchronized (com.tencent.qimei.u.c.class) {
                    cVar = com.tencent.qimei.u.c.f343390p;
                }
                cVar.f343393c = 10L;
                this.f342950a.a(4);
                this.f342951b.f342947c = true;
            }
        }
    }
}
