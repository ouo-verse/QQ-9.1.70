package com.tencent.aio.dispatcher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private b f69244a;

    /* renamed from: b, reason: collision with root package name */
    private b f69245b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(b bVar) {
        try {
            if (bVar != null) {
                b bVar2 = this.f69245b;
                if (bVar2 != null) {
                    bVar2.f69243b = bVar;
                    this.f69245b = bVar;
                } else if (this.f69244a == null) {
                    this.f69245b = bVar;
                    this.f69244a = bVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th5) {
            throw th5;
        }
    }

    public synchronized boolean b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f69244a == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized b c() {
        b bVar;
        bVar = this.f69244a;
        if (bVar != null) {
            b bVar2 = bVar.f69243b;
            this.f69244a = bVar2;
            if (bVar2 == null) {
                this.f69245b = null;
            }
        }
        return bVar;
    }
}
