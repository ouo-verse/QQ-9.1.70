package com.tencent.mobileqq.uftransfer.proto;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    static g f305312c;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.mobileqq.uftransfer.depend.proto.c f305313a;

    /* renamed from: b, reason: collision with root package name */
    private final com.tencent.mobileqq.uftransfer.depend.proto.d f305314b;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(boolean z16, com.tencent.mobileqq.uftransfer.proto.d dVar);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(boolean z16, int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        void a(boolean z16, f fVar);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface d {
        void a(boolean z16, j jVar);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27424);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f305312c = null;
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f305313a = new com.tencent.mobileqq.uftransfer.depend.proto.c();
            this.f305314b = new com.tencent.mobileqq.uftransfer.depend.proto.d();
        }
    }

    public static synchronized g b() {
        g gVar;
        synchronized (g.class) {
            if (f305312c == null) {
                f305312c = new g();
            }
            gVar = f305312c;
        }
        return gVar;
    }

    public static boolean c(int i3) {
        if (i3 != -100002 && i3 != -100001 && i3 != -100003 && i3 != -1 && i3 != 9043 && i3 != 9045 && i3 != 9001) {
            return false;
        }
        return true;
    }

    public void a(AppRuntime appRuntime, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime, obj);
        } else {
            this.f305314b.a(appRuntime, obj);
        }
    }

    public boolean d(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.proto.c cVar, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, cVar, aVar)).booleanValue();
        }
        return this.f305313a.e(appRuntime, cVar, aVar);
    }

    public boolean e(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.proto.c cVar, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, appRuntime, cVar, aVar)).booleanValue();
        }
        return this.f305313a.f(appRuntime, cVar, aVar);
    }

    public boolean f(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.proto.c cVar, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, appRuntime, cVar, aVar)).booleanValue();
        }
        return this.f305313a.g(appRuntime, cVar, aVar);
    }

    public boolean g(AppRuntime appRuntime, e eVar, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, appRuntime, eVar, cVar)).booleanValue();
        }
        return this.f305313a.h(appRuntime, eVar, cVar);
    }

    public Object h(AppRuntime appRuntime, h hVar, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return iPatchRedirector.redirect((short) 9, this, appRuntime, hVar, dVar);
        }
        return this.f305314b.b(appRuntime, hVar, dVar);
    }

    public Object i(AppRuntime appRuntime, i iVar, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, this, appRuntime, iVar, dVar);
        }
        return this.f305314b.c(appRuntime, iVar, dVar);
    }

    public boolean j(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.proto.a aVar, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, appRuntime, aVar, bVar)).booleanValue();
        }
        return this.f305313a.k(appRuntime, aVar, bVar);
    }
}
