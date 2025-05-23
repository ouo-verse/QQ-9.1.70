package com.tencent.upgrade.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayDeque;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC10036b f383813a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayDeque<com.tencent.upgrade.request.a> f383814b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f383815c;

    /* renamed from: d, reason: collision with root package name */
    private c f383816d;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a implements c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.upgrade.core.b.c
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.this.c();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.upgrade.core.b$b, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public interface InterfaceC10036b {
        void a(com.tencent.upgrade.request.a aVar, c cVar);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface c {
        void a(boolean z16);
    }

    public b(InterfaceC10036b interfaceC10036b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) interfaceC10036b);
            return;
        }
        this.f383814b = new ArrayDeque<>();
        this.f383815c = false;
        this.f383816d = new a();
        this.f383813a = interfaceC10036b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.tencent.upgrade.util.d.a("CheckRequestDispatcher", "onRequestFinish");
        this.f383815c = false;
        d();
    }

    public void b(com.tencent.upgrade.request.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            if (aVar == null) {
                return;
            }
            synchronized (this.f383814b) {
                this.f383814b.addLast(aVar);
            }
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this.f383814b) {
            com.tencent.upgrade.util.d.a("CheckRequestDispatcher", "triggerRequest hasRunningRequest = " + this.f383815c);
            if (this.f383815c) {
                return;
            }
            com.tencent.upgrade.request.a pollFirst = this.f383814b.pollFirst();
            if (pollFirst == null) {
                return;
            }
            this.f383815c = true;
            InterfaceC10036b interfaceC10036b = this.f383813a;
            if (interfaceC10036b != null) {
                interfaceC10036b.a(pollFirst, this.f383816d);
            }
        }
    }
}
