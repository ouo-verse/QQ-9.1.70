package com.tencent.luggage.wxa.xp;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.wxa.kp.a;
import com.tencent.luggage.wxa.wp.a;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import java.security.SignatureException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class i extends com.tencent.luggage.wxa.xp.d implements com.tencent.luggage.wxa.xp.a {

    /* renamed from: c, reason: collision with root package name */
    public int f145308c;

    /* renamed from: e, reason: collision with root package name */
    public String f145310e;

    /* renamed from: f, reason: collision with root package name */
    public int f145311f;

    /* renamed from: g, reason: collision with root package name */
    public WeakReference f145312g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.rp.a f145313h;

    /* renamed from: i, reason: collision with root package name */
    public String f145314i;

    /* renamed from: j, reason: collision with root package name */
    public String f145315j;

    /* renamed from: k, reason: collision with root package name */
    public String f145316k;

    /* renamed from: l, reason: collision with root package name */
    public String f145317l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f145318m;

    /* renamed from: d, reason: collision with root package name */
    public String f145309d = null;

    /* renamed from: n, reason: collision with root package name */
    public com.tencent.luggage.wxa.np.l f145319n = null;

    /* renamed from: o, reason: collision with root package name */
    public d f145320o = null;

    /* renamed from: p, reason: collision with root package name */
    public boolean f145321p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f145322q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f145323r = false;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a {
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.g(i.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.g(i.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d extends a.AbstractC6403a {

        /* renamed from: a, reason: collision with root package name */
        public Signature f145326a;

        /* renamed from: b, reason: collision with root package name */
        public long f145327b;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f145329a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CharSequence f145330b;

            public a(int i3, CharSequence charSequence) {
                this.f145329a = i3;
                this.f145330b = charSequence;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.g(i.this);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f145332a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CharSequence f145333b;

            public b(int i3, CharSequence charSequence) {
                this.f145332a = i3;
                this.f145333b = charSequence;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.g(i.this);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.g(i.this);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.xp.i$d$d, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC6928d implements Runnable {
            public RunnableC6928d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!com.tencent.luggage.wxa.np.i.a(i.this.f145310e)) {
                    if (com.tencent.luggage.wxa.jp.a.e() == 1) {
                        d dVar = d.this;
                        i.this.a(dVar.f145326a, d.this.f145327b);
                        return;
                    }
                    try {
                        d.this.f145326a.update(i.this.f145310e.getBytes(Charset.forName("UTF-8")));
                    } catch (Exception e16) {
                        com.tencent.luggage.wxa.np.e.b("Soter.TaskBiometricAuthentication", "soter: exception in update", new Object[0]);
                        com.tencent.luggage.wxa.np.e.a("Soter.TaskBiometricAuthentication", e16, "soter: exception in update");
                        com.tencent.luggage.wxa.np.f.a(200, "TaskBiometric, update signature failed: onAuthenticationSucceeded().", e16);
                        com.tencent.luggage.wxa.np.e.b("Soter.TaskBiometricAuthentication", "soter: remove the auth key: %s", i.this.f145309d);
                        com.tencent.luggage.wxa.jp.a.b(i.this.f145309d, false);
                        i.this.a(new com.tencent.luggage.wxa.sp.a(1027, "update signature failed. authkey removed after this failure, please check"));
                    }
                    try {
                        d dVar2 = d.this;
                        i.this.a(dVar2.f145326a);
                        return;
                    } catch (Exception e17) {
                        com.tencent.luggage.wxa.np.e.b("Soter.TaskBiometricAuthentication", "soter: exception in executeWhenAuthenticated method", new Object[0]);
                        com.tencent.luggage.wxa.np.e.a("Soter.TaskBiometricAuthentication", e17, "soter: exception when execute");
                        d.this.a(-1000, "execute failed");
                        return;
                    }
                }
                com.tencent.luggage.wxa.np.e.b("Soter.TaskBiometricAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                d.this.a(-1000, "challenge is null");
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.g(i.this);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class f implements Runnable {
            public f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.g(i.this);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class g implements Runnable {
            public g() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.f145313h.d();
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class h implements Runnable {
            public h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                i.this.b(dVar.f145326a);
            }
        }

        public /* synthetic */ d(i iVar, Signature signature, a aVar) {
            this(signature);
        }

        public final void c() {
            if (i.this.f145321p) {
                com.tencent.luggage.wxa.np.e.c("Soter.TaskBiometricAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                i.this.f145313h.a(false);
                com.tencent.luggage.wxa.xp.g.a().b(new g());
                com.tencent.luggage.wxa.xp.g.a().a(new h(), 1000L);
            }
            if (i.this.f145311f == 2) {
                com.tencent.luggage.wxa.np.e.c("Soter.TaskBiometricAuthentication", "soter: should compat faceid logic.", new Object[0]);
                i.this.a(new com.tencent.luggage.wxa.sp.a(1017, "faceid not match"));
            }
        }

        public final void d() {
            if (i.this.f145322q || i.this.f145311f == 2) {
                i.this.f145313h.a(false);
                i.this.f145323r = true;
            }
        }

        public d(Signature signature) {
            this.f145326a = signature;
        }

        @Override // com.tencent.luggage.wxa.kp.a.AbstractC6403a
        public void b(int i3, CharSequence charSequence) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i3), charSequence);
            com.tencent.luggage.wxa.xp.g.a().a(new b(i3, charSequence));
        }

        public final String a(CharSequence charSequence) {
            return charSequence == null ? "unknown error" : charSequence.toString();
        }

        @Override // com.tencent.luggage.wxa.kp.a.AbstractC6403a
        public void a(int i3, CharSequence charSequence) {
            com.tencent.luggage.wxa.np.e.b("Soter.TaskBiometricAuthentication", "soter: on authentication fatal error: %d, %s", Integer.valueOf(i3), charSequence);
            com.tencent.luggage.wxa.xp.g.a().a(new a(i3, charSequence));
            if (i3 == 10308) {
                i.this.a(new com.tencent.luggage.wxa.sp.a(1022, a(charSequence)));
            } else if (i3 == 10309) {
                i.this.a(new com.tencent.luggage.wxa.sp.a(1022, a(charSequence)));
            } else if (i3 == 10310) {
                i.this.a(new com.tencent.luggage.wxa.sp.a(1029, a(charSequence)));
            } else {
                i.this.a(new com.tencent.luggage.wxa.sp.a(1017, a(charSequence)));
            }
            d();
            com.tencent.luggage.wxa.np.f.a(401, "on authentication fatal error: " + i3 + " " + ((Object) charSequence));
        }

        @Override // com.tencent.luggage.wxa.kp.a.AbstractC6403a
        public void b() {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: authentication failed once", new Object[0]);
            com.tencent.luggage.wxa.xp.g.a().a(new e());
            c();
        }

        @Override // com.tencent.luggage.wxa.kp.a.AbstractC6403a
        public void a(a.b bVar) {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskBiometricAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            com.tencent.luggage.wxa.xp.g.a().a(new c());
            com.tencent.luggage.wxa.xp.g.a().b(new RunnableC6928d());
            d();
        }

        @Override // com.tencent.luggage.wxa.kp.a.AbstractC6403a
        public void a() {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskBiometricAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (i.this.f145323r) {
                com.tencent.luggage.wxa.np.e.d("Soter.TaskBiometricAuthentication", "soter: during ignore cancel period", new Object[0]);
                return;
            }
            com.tencent.luggage.wxa.xp.g.a().a(new f());
            i.this.a(new com.tencent.luggage.wxa.sp.a(1020, "user cancelled authentication"));
            d();
        }
    }

    public i(com.tencent.luggage.wxa.xp.b bVar) {
        this.f145308c = -1;
        this.f145310e = null;
        this.f145312g = null;
        this.f145313h = null;
        if (bVar != null) {
            this.f145308c = bVar.k();
            bVar.e();
            bVar.f();
            this.f145312g = new WeakReference(bVar.c());
            bVar.m();
            this.f145313h = bVar.l();
            this.f145311f = bVar.a();
            this.f145310e = bVar.b();
            this.f145314i = bVar.j();
            this.f145315j = bVar.i();
            this.f145316k = bVar.h();
            this.f145317l = bVar.g();
            this.f145318m = bVar.o();
            return;
        }
        throw new IllegalArgumentException("param is null!");
    }

    public static /* synthetic */ com.tencent.luggage.wxa.rp.b g(i iVar) {
        iVar.getClass();
        return null;
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public boolean d() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xp.a
    public boolean isCancelled() {
        return this.f145323r;
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void c(com.tencent.luggage.wxa.sp.e eVar) {
        if ((eVar.a() == 1018 || eVar.a() == 1007 || eVar.a() == 1015) && com.tencent.luggage.wxa.tp.a.a(getClass(), eVar)) {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskBiometricAuthentication", "soter: same error happen too much, delete ask", new Object[0]);
            com.tencent.luggage.wxa.qp.a.a();
        }
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void e() {
        com.tencent.luggage.wxa.rp.a aVar = this.f145313h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public boolean f() {
        if (!com.tencent.luggage.wxa.tp.b.c().e()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: not initialized yet", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1008));
            return true;
        }
        if (!com.tencent.luggage.wxa.tp.b.c().f()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: not support soter", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(2));
            return true;
        }
        String str = (String) com.tencent.luggage.wxa.tp.b.c().b().get(this.f145308c, "");
        this.f145309d = str;
        if (com.tencent.luggage.wxa.np.i.a(str)) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1009, String.format("auth scene %d not initialized in map", Integer.valueOf(this.f145308c))));
            return true;
        }
        if (!com.tencent.luggage.wxa.jp.a.d(this.f145309d)) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: auth key %s not exists. need re-generate", this.f145309d);
            a(new com.tencent.luggage.wxa.sp.a(1006, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", Integer.valueOf(this.f145308c))));
            return true;
        }
        if (com.tencent.luggage.wxa.np.i.a(this.f145310e)) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: challenge wrapper is null!", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1010, "neither get challenge wrapper nor challenge str is found in request parameter"));
            return true;
        }
        Context context = (Context) this.f145312g.get();
        if (context == null) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: context instance released in preExecute", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1011));
            return true;
        }
        if (!com.tencent.luggage.wxa.kp.a.a(context, Integer.valueOf(this.f145311f)).a()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: user has not enrolled any biometric in system.", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1013));
            return true;
        }
        if (com.tencent.luggage.wxa.jp.a.a(context, this.f145311f)) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: biometric sensor frozen", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1021, "Too many failed times"));
            return true;
        }
        if (this.f145313h == null) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
            this.f145313h = new com.tencent.luggage.wxa.rp.a();
            return false;
        }
        com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
        return false;
    }

    public final void g() {
        Signature signature = null;
        byte b16 = 0;
        byte b17 = 0;
        if (com.tencent.luggage.wxa.jp.a.e() == 1) {
            com.tencent.luggage.wxa.pp.c a16 = com.tencent.luggage.wxa.jp.a.a(this.f145309d, this.f145310e);
            if (a16 == null) {
                com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
                a(new com.tencent.luggage.wxa.sp.a(1007));
                return;
            } else {
                if (a16.f137732b != 0) {
                    com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
                    a(new com.tencent.luggage.wxa.sp.a(1007));
                    return;
                }
                com.tencent.luggage.wxa.np.e.a("Soter.TaskBiometricAuthentication", "soter: session is %d", Long.valueOf(a16.f137731a));
                d dVar = new d(this, signature, b17 == true ? 1 : 0);
                this.f145320o = dVar;
                dVar.f145327b = a16.f137731a;
                b((Signature) null);
                g.a().a(new b());
                return;
            }
        }
        Signature b18 = com.tencent.luggage.wxa.jp.a.b(this.f145309d);
        if (b18 == null) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: error occurred when init sign", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1007));
        } else {
            this.f145320o = new d(this, b18, b16 == true ? 1 : 0);
            b(b18);
            g.a().a(new c());
        }
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void b() {
        if (!com.tencent.luggage.wxa.np.i.a(this.f145310e)) {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskBiometricAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
            g();
        } else {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskBiometricAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            new a.C6892a();
            throw null;
        }
    }

    public final void a(Signature signature, long j3) {
        try {
            this.f145319n = com.tencent.luggage.wxa.jp.a.a(com.tencent.luggage.wxa.jp.a.a(j3));
            com.tencent.luggage.wxa.np.e.c("Soter.TaskBiometricAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(0, this.f145319n));
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.b("Soter.TaskBiometricAuthentication", "soter: finish sign failed due to exception: %s", e16.getMessage());
            com.tencent.luggage.wxa.np.e.a("Soter.TaskBiometricAuthentication", e16, "soter: sign failed due to exception");
            com.tencent.luggage.wxa.np.f.a(200, "TaskBiometric, sign failed: executeWhenAuthenticatedWithSession().", e16);
            a(new com.tencent.luggage.wxa.sp.a(1018, "sign failed even after user authenticated the key."));
        }
    }

    public final void b(Signature signature) {
        if (c()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            return;
        }
        Context context = (Context) this.f145312g.get();
        if (context == null) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskBiometricAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1011));
            return;
        }
        try {
            com.tencent.luggage.wxa.np.e.d("Soter.TaskBiometricAuthentication", "soter: performing start", new Object[0]);
            Bundle bundle = new Bundle();
            bundle.putString("prompt_title", this.f145314i);
            bundle.putString("prompt_subtitle", this.f145315j);
            bundle.putString("prompt_description", this.f145316k);
            bundle.putString("prompt_button", this.f145317l);
            bundle.putBoolean("use_biometric_prompt", this.f145318m);
            com.tencent.luggage.wxa.kp.a a16 = com.tencent.luggage.wxa.kp.a.a(context, Integer.valueOf(this.f145311f));
            a.c cVar = new a.c(signature);
            com.tencent.luggage.wxa.rp.a aVar = this.f145313h;
            a16.a(cVar, 0, aVar != null ? aVar.b() : null, this.f145320o, null, bundle);
        } catch (Exception e16) {
            String message = e16.getMessage();
            com.tencent.luggage.wxa.np.e.b("Soter.TaskBiometricAuthentication", "soter: caused exception when authenticating: %s", message);
            com.tencent.luggage.wxa.np.e.a("Soter.TaskBiometricAuthentication", e16, "soter: caused exception when authenticating");
            com.tencent.luggage.wxa.np.f.a(200, "TaskBiometric, start authentication failed: performStartBiometricLogic().", e16);
            a(new com.tencent.luggage.wxa.sp.a(1015, String.format("start authentication failed due to %s", message)));
        }
    }

    public final void a(Signature signature) {
        try {
            this.f145319n = com.tencent.luggage.wxa.jp.a.a(signature.sign());
            com.tencent.luggage.wxa.np.e.c("Soter.TaskBiometricAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(0, this.f145319n));
        } catch (SignatureException e16) {
            com.tencent.luggage.wxa.np.e.b("Soter.TaskBiometricAuthentication", "soter: sign failed due to exception: %s", e16.getMessage());
            com.tencent.luggage.wxa.np.e.a("Soter.TaskBiometricAuthentication", e16, "soter: sign failed due to exception");
            com.tencent.luggage.wxa.np.f.a(200, "TaskBiometric, sign failed: executeWhenAuthenticated().", e16);
            a(new com.tencent.luggage.wxa.sp.a(1018, "sign failed even after user authenticated the key."));
        }
    }

    @Override // com.tencent.luggage.wxa.xp.a
    public void a() {
        com.tencent.luggage.wxa.np.e.c("Soter.TaskBiometricAuthentication", "soter: called from cancellation signal", new Object[0]);
        d dVar = this.f145320o;
        if (dVar != null) {
            dVar.a();
        }
    }
}
