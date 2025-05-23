package com.tencent.qav;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qav.channel.d;
import com.tencent.qav.controller.multi.MultiOperatorImpl;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static volatile b f342352f;

    /* renamed from: a, reason: collision with root package name */
    private Context f342353a;

    /* renamed from: b, reason: collision with root package name */
    private long f342354b;

    /* renamed from: c, reason: collision with root package name */
    private d f342355c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.qav.controller.a f342356d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f342357e;

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f342357e = false;
        }
    }

    public static b b() {
        if (f342352f == null) {
            synchronized (b.class) {
                if (f342352f == null) {
                    f342352f = new b();
                }
            }
        }
        return f342352f;
    }

    public void a(com.tencent.qav.observer.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else {
            com.tencent.qav.observer.b.f().a(aVar, true);
        }
    }

    public com.tencent.qav.controller.multi.a c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qav.controller.multi.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.qav.controller.a aVar = this.f342356d;
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public synchronized void d(Context context, long j3, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Long.valueOf(j3), dVar);
            return;
        }
        com.tencent.qav.log.a.a("QavSDK", String.format("initSDK context=%s selfUin=%s videoChannel=%s", context, Long.valueOf(j3), dVar));
        if (this.f342357e) {
            com.tencent.qav.log.a.g("QavSDK", "initSDK has init before");
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            this.f342353a = applicationContext;
            this.f342354b = j3;
            this.f342355c = dVar;
            if (this.f342356d == null) {
                this.f342356d = new com.tencent.qav.controller.a(this.f342353a, new MultiOperatorImpl(applicationContext, j3, dVar));
            }
            this.f342357e = true;
        } catch (Throwable th5) {
            com.tencent.qav.log.a.c("QavSDK", "initSDK fail.", th5);
            this.f342356d = null;
            this.f342357e = false;
        }
    }

    public void e(com.tencent.qav.observer.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        com.tencent.qav.observer.b f16 = com.tencent.qav.observer.b.f();
        if (f16 != null) {
            f16.e(aVar);
        }
    }

    public void f(com.tencent.qav.controller.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            this.f342356d = aVar;
        }
    }

    public synchronized void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.qav.observer.b.f().b();
        com.tencent.qav.controller.a aVar = this.f342356d;
        if (aVar != null) {
            aVar.a();
            this.f342356d = null;
        }
        this.f342353a = null;
        this.f342354b = 0L;
        this.f342355c = null;
        this.f342357e = false;
        f342352f = null;
    }
}
