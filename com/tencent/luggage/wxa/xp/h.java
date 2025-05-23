package com.tencent.luggage.wxa.xp;

import android.content.Context;
import com.tencent.luggage.wxa.lp.a;
import com.tencent.luggage.wxa.wp.a;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.security.Signature;
import java.security.SignatureException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h extends com.tencent.luggage.wxa.xp.d implements com.tencent.luggage.wxa.xp.a {

    /* renamed from: c, reason: collision with root package name */
    public int f145280c;

    /* renamed from: e, reason: collision with root package name */
    public String f145282e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f145283f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.up.a f145284g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.up.b f145285h;

    /* renamed from: d, reason: collision with root package name */
    public String f145281d = null;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.np.l f145286i = null;

    /* renamed from: j, reason: collision with root package name */
    public d f145287j = null;

    /* renamed from: k, reason: collision with root package name */
    public boolean f145288k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f145289l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f145290m = false;

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
            if (h.this.f145285h != null) {
                h.this.f145285h.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f145285h != null) {
                h.this.f145285h.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d extends a.b {

        /* renamed from: a, reason: collision with root package name */
        public Signature f145293a;

        /* renamed from: b, reason: collision with root package name */
        public long f145294b;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f145296a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CharSequence f145297b;

            public a(int i3, CharSequence charSequence) {
                this.f145296a = i3;
                this.f145297b = charSequence;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f145285h != null) {
                    h.this.f145285h.a(this.f145296a, this.f145297b);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f145299a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CharSequence f145300b;

            public b(int i3, CharSequence charSequence) {
                this.f145299a = i3;
                this.f145300b = charSequence;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f145285h != null) {
                    h.this.f145285h.b(this.f145299a, d.this.a(this.f145300b));
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!com.tencent.luggage.wxa.np.i.a(h.this.f145282e)) {
                    if (com.tencent.luggage.wxa.jp.a.e() == 1) {
                        d dVar = d.this;
                        h.this.a(dVar.f145293a, d.this.f145294b);
                        return;
                    }
                    try {
                        d.this.f145293a.update(h.this.f145282e.getBytes(Charset.forName("UTF-8")));
                    } catch (SignatureException e16) {
                        com.tencent.luggage.wxa.np.e.b("Soter.TaskAuthentication", "soter: exception in update", new Object[0]);
                        com.tencent.luggage.wxa.np.e.a("Soter.TaskAuthentication", e16, "soter: exception in update");
                        com.tencent.luggage.wxa.np.f.a(200, "TaskAuthentication, update signature fail: onAuthenticationSucceeded().", e16);
                        com.tencent.luggage.wxa.np.e.b("Soter.TaskAuthentication", "soter: remove the auth key: %s", h.this.f145281d);
                        com.tencent.luggage.wxa.jp.a.b(h.this.f145281d, false);
                        h.this.a(new com.tencent.luggage.wxa.sp.a(1027, "update signature failed. authkey removed after this failure, please check"));
                    }
                    try {
                        d dVar2 = d.this;
                        h.this.a(dVar2.f145293a);
                        return;
                    } catch (Exception e17) {
                        com.tencent.luggage.wxa.np.e.b("Soter.TaskAuthentication", "soter: exception in executeWhenAuthenticated method", new Object[0]);
                        com.tencent.luggage.wxa.np.e.a("Soter.TaskAuthentication", e17, "soter: exception when execute");
                        d.this.a(-1000, "execute failed");
                        return;
                    }
                }
                com.tencent.luggage.wxa.np.e.b("Soter.TaskAuthentication", "soter: challenge is null. should not happen here", new Object[0]);
                d.this.a(-1000, "challenge is null");
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.xp.h$d$d, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC6926d implements Runnable {
            public RunnableC6926d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f145285h != null) {
                    h.this.f145285h.a();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f145285h != null) {
                    h.this.f145285h.c();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class f implements Runnable {
            public f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f145285h != null) {
                    h.this.f145285h.d();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class g implements Runnable {
            public g() {
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.f145284g.d();
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.xp.h$d$h, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC6927h implements Runnable {
            public RunnableC6927h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = d.this;
                h.this.b(dVar.f145293a);
            }
        }

        public /* synthetic */ d(h hVar, Signature signature, a aVar) {
            this(signature);
        }

        public final void c() {
            if (h.this.f145289l) {
                h.this.f145284g.a(false);
                h.this.f145290m = true;
            }
        }

        public final void d() {
            if (h.this.f145288k) {
                com.tencent.luggage.wxa.np.e.c("Soter.TaskAuthentication", "soter: should compat lower android version logic.", new Object[0]);
                h.this.f145284g.a(false);
                com.tencent.luggage.wxa.xp.g.a().b(new g());
                com.tencent.luggage.wxa.xp.g.a().a(new RunnableC6927h(), 1000L);
            }
        }

        public d(Signature signature) {
            this.f145293a = signature;
        }

        @Override // com.tencent.luggage.wxa.lp.a.b
        public void b(int i3, CharSequence charSequence) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: on authentication help. you do not need to cancel the authentication: %d, %s", Integer.valueOf(i3), charSequence);
            com.tencent.luggage.wxa.xp.g.a().a(new b(i3, charSequence));
        }

        public final String a(CharSequence charSequence) {
            return charSequence == null ? "unknown error" : charSequence.toString();
        }

        @Override // com.tencent.luggage.wxa.lp.a.b
        public void b() {
            super.b();
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: authentication failed once", new Object[0]);
            com.tencent.luggage.wxa.xp.g.a().a(new e());
            d();
        }

        @Override // com.tencent.luggage.wxa.lp.a.b
        public void a(int i3, CharSequence charSequence) {
            com.tencent.luggage.wxa.np.e.b("Soter.TaskAuthentication", "soter: on authentication fatal error: %d, %s", Integer.valueOf(i3), charSequence);
            if (i3 != 10308) {
                com.tencent.luggage.wxa.xp.g.a().a(new a(i3, charSequence));
                h.this.a(new com.tencent.luggage.wxa.sp.a(1016, a(charSequence)));
            } else {
                h.this.a(new com.tencent.luggage.wxa.sp.a(1021, a(charSequence)));
            }
            c();
            com.tencent.luggage.wxa.np.f.a(401, "on authentication fatal error: " + i3 + " " + ((Object) charSequence));
        }

        @Override // com.tencent.luggage.wxa.lp.a.b
        public void a(a.c cVar) {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskAuthentication", "soter: authentication succeed. start sign and upload upload signature", new Object[0]);
            com.tencent.luggage.wxa.xp.g.a().b(new c());
            com.tencent.luggage.wxa.xp.g.a().a(new RunnableC6926d());
            c();
        }

        @Override // com.tencent.luggage.wxa.lp.a.b
        public void a() {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskAuthentication", "soter: called onAuthenticationCancelled", new Object[0]);
            if (h.this.f145290m) {
                com.tencent.luggage.wxa.np.e.d("Soter.TaskAuthentication", "soter: during ignore cancel period", new Object[0]);
                return;
            }
            super.a();
            com.tencent.luggage.wxa.xp.g.a().a(new f());
            h.this.a(new com.tencent.luggage.wxa.sp.a(1020, "user cancelled authentication"));
            c();
        }
    }

    public h(com.tencent.luggage.wxa.xp.b bVar) {
        this.f145280c = -1;
        this.f145282e = null;
        this.f145283f = null;
        this.f145284g = null;
        this.f145285h = null;
        if (bVar != null) {
            this.f145280c = bVar.k();
            bVar.e();
            bVar.f();
            this.f145283f = new WeakReference(bVar.c());
            this.f145285h = bVar.n();
            this.f145284g = bVar.d();
            this.f145282e = bVar.b();
            return;
        }
        throw new IllegalArgumentException("param is null!");
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public boolean d() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xp.a
    public boolean isCancelled() {
        return this.f145290m;
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void c(com.tencent.luggage.wxa.sp.e eVar) {
        if ((eVar.a() == 1018 || eVar.a() == 1007 || eVar.a() == 1015) && com.tencent.luggage.wxa.tp.a.a(getClass(), eVar)) {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskAuthentication", "soter: same error happen too much, delete ask", new Object[0]);
            com.tencent.luggage.wxa.qp.a.a();
        }
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void e() {
        com.tencent.luggage.wxa.up.a aVar = this.f145284g;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public boolean f() {
        if (!com.tencent.luggage.wxa.tp.b.c().e()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: not initialized yet", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1008));
            return true;
        }
        if (!com.tencent.luggage.wxa.tp.b.c().f()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: not support soter", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(2));
            return true;
        }
        String str = (String) com.tencent.luggage.wxa.tp.b.c().b().get(this.f145280c, "");
        this.f145281d = str;
        if (com.tencent.luggage.wxa.np.i.a(str)) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1009, String.format("auth scene %d not initialized in map", Integer.valueOf(this.f145280c))));
            return true;
        }
        if (!com.tencent.luggage.wxa.jp.a.d(this.f145281d)) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: auth key %s not exists. need re-generate", this.f145281d);
            a(new com.tencent.luggage.wxa.sp.a(1006, String.format("the auth key to scene %d not exists. it may because you haven't prepare it, or user removed them already in system settings. please prepare the key again", Integer.valueOf(this.f145280c))));
            return true;
        }
        if (com.tencent.luggage.wxa.np.i.a(this.f145282e)) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: challenge wrapper is null!", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1010, "neither get challenge wrapper nor challenge str is found in request parameter"));
            return true;
        }
        Context context = (Context) this.f145283f.get();
        if (context == null) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: context instance released in preExecute", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1011));
            return true;
        }
        if (!com.tencent.luggage.wxa.lp.a.a(context).a()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: user has not enrolled any fingerprint in system.", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1012));
            return true;
        }
        if (com.tencent.luggage.wxa.jp.a.a(context)) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: fingerprint sensor frozen", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1021, "Too many failed times"));
            return true;
        }
        if (this.f145284g == null) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: did not pass cancellation obj. We suggest you pass one", new Object[0]);
            this.f145284g = new com.tencent.luggage.wxa.up.a();
            return false;
        }
        com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "hy: we strongly recommend you to check the final authentication data in server! Please make sure you upload and check later", new Object[0]);
        return false;
    }

    public final void g() {
        Signature signature = null;
        byte b16 = 0;
        byte b17 = 0;
        if (com.tencent.luggage.wxa.jp.a.e() == 1) {
            com.tencent.luggage.wxa.pp.c a16 = com.tencent.luggage.wxa.jp.a.a(this.f145281d, this.f145282e);
            if (a16 == null) {
                com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: error occurred when init sign soterSessionResult is null", new Object[0]);
                a(new com.tencent.luggage.wxa.sp.a(1007));
                return;
            } else {
                if (a16.f137732b != 0) {
                    com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: error occurred when init sign resultCode error", new Object[0]);
                    a(new com.tencent.luggage.wxa.sp.a(1007));
                    return;
                }
                com.tencent.luggage.wxa.np.e.a("Soter.TaskAuthentication", "soter: session is %d", Long.valueOf(a16.f137731a));
                d dVar = new d(this, signature, b17 == true ? 1 : 0);
                this.f145287j = dVar;
                dVar.f145294b = a16.f137731a;
                b((Signature) null);
                g.a().a(new b());
                return;
            }
        }
        Signature b18 = com.tencent.luggage.wxa.jp.a.b(this.f145281d);
        if (b18 == null) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: error occurred when init sign", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1007));
        } else {
            this.f145287j = new d(this, b18, b16 == true ? 1 : 0);
            b(b18);
            g.a().a(new c());
        }
    }

    @Override // com.tencent.luggage.wxa.xp.d
    public void b() {
        if (!com.tencent.luggage.wxa.np.i.a(this.f145282e)) {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskAuthentication", "soter: already provided the challenge. directly authenticate", new Object[0]);
            g();
        } else {
            com.tencent.luggage.wxa.np.e.c("Soter.TaskAuthentication", "soter: not provide the challenge. we will do the job", new Object[0]);
            new a.C6892a();
            throw null;
        }
    }

    public final void a(Signature signature, long j3) {
        try {
            this.f145286i = com.tencent.luggage.wxa.jp.a.a(com.tencent.luggage.wxa.jp.a.a(j3));
            com.tencent.luggage.wxa.np.e.c("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(0, this.f145286i));
        } catch (Exception e16) {
            com.tencent.luggage.wxa.np.e.b("Soter.TaskAuthentication", "soter: finish sign failed due to exception: %s", e16.getMessage());
            com.tencent.luggage.wxa.np.e.a("Soter.TaskAuthentication", e16, "soter: sign failed due to exception");
            com.tencent.luggage.wxa.np.f.a(200, "TaskAuthentication, sign fail: executeWhenAuthenticatedWithSession().", e16);
            a(new com.tencent.luggage.wxa.sp.a(1018, "sign failed even after user authenticated the key."));
        }
    }

    public final void b(Signature signature) {
        if (c()) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: already finished. can not authenticate", new Object[0]);
            return;
        }
        Context context = (Context) this.f145283f.get();
        if (context == null) {
            com.tencent.luggage.wxa.np.e.e("Soter.TaskAuthentication", "soter: context instance released in startAuthenticate", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(1011));
            return;
        }
        try {
            com.tencent.luggage.wxa.np.e.d("Soter.TaskAuthentication", "soter: performing start", new Object[0]);
            com.tencent.luggage.wxa.lp.a a16 = com.tencent.luggage.wxa.lp.a.a(context);
            a.d dVar = new a.d(signature);
            com.tencent.luggage.wxa.up.a aVar = this.f145284g;
            a16.a(dVar, 0, aVar != null ? aVar.b() : null, this.f145287j, null);
        } catch (Exception e16) {
            String message = e16.getMessage();
            com.tencent.luggage.wxa.np.e.b("Soter.TaskAuthentication", "soter: caused exception when authenticating: %s", message);
            com.tencent.luggage.wxa.np.e.a("Soter.TaskAuthentication", e16, "soter: caused exception when authenticating");
            com.tencent.luggage.wxa.np.f.a(200, "TaskAuthentication, start authentication fail: performStartFingerprintLogic().", e16);
            a(new com.tencent.luggage.wxa.sp.a(1015, String.format("start authentication failed due to %s", message)));
        }
    }

    public final void a(Signature signature) {
        try {
            this.f145286i = com.tencent.luggage.wxa.jp.a.a(signature.sign());
            com.tencent.luggage.wxa.np.e.c("Soter.TaskAuthentication", "soter: no upload wrapper, return directly", new Object[0]);
            a(new com.tencent.luggage.wxa.sp.a(0, this.f145286i));
        } catch (SignatureException e16) {
            com.tencent.luggage.wxa.np.e.b("Soter.TaskAuthentication", "soter: sign failed due to exception: %s", e16.getMessage());
            com.tencent.luggage.wxa.np.e.a("Soter.TaskAuthentication", e16, "soter: sign failed due to exception");
            com.tencent.luggage.wxa.np.f.a(200, "TaskAuthentication, sign fail: executeWhenAuthenticated().", e16);
            a(new com.tencent.luggage.wxa.sp.a(1018, "sign failed even after user authenticated the key."));
        }
    }

    @Override // com.tencent.luggage.wxa.xp.a
    public void a() {
        com.tencent.luggage.wxa.np.e.c("Soter.TaskAuthentication", "soter: called from cancellation signal", new Object[0]);
        d dVar = this.f145287j;
        if (dVar != null) {
            dVar.a();
        }
    }
}
