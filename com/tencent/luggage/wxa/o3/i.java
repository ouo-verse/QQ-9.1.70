package com.tencent.luggage.wxa.o3;

import com.tencent.luggage.wxa.o3.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends c {

    /* renamed from: e, reason: collision with root package name */
    public static final a f136119e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final j f136120b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f136121c;

    /* renamed from: d, reason: collision with root package name */
    public j f136122d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public i() {
        j jVar = new j();
        jVar.f("");
        jVar.c(-1);
        jVar.b(0);
        jVar.c("");
        jVar.e("");
        jVar.a(-1);
        jVar.d("");
        this.f136120b = jVar;
        this.f136121c = true;
        this.f136122d = jVar;
    }

    @Override // com.tencent.luggage.wxa.o3.c, com.tencent.luggage.wxa.o3.e
    public void b() {
        c(this.f136120b);
        super.b();
    }

    public final void c(j jVar) {
        if (this.f136121c) {
            k kVar = k.f136136k;
            kVar.f(jVar.g());
            kVar.b(jVar.h());
            kVar.c(jVar.d());
            kVar.e(jVar.f());
            kVar.a(jVar.b());
            kVar.c(jVar.i());
            kVar.d(jVar.e());
            kVar.a(jVar.a());
            kVar.b(jVar.c());
            this.f136122d = kVar;
            return;
        }
        this.f136122d = new j(jVar.f(), jVar.h(), jVar.g(), jVar.d(), jVar.b(), jVar.e(), jVar.a(), jVar.c());
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public boolean d() {
        return this.f136121c;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public String e() {
        return this.f136122d.g();
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public boolean f() {
        if (!c()) {
            return false;
        }
        j a16 = a();
        if (a16.k() <= 0) {
            return true;
        }
        j b16 = f.f136098a.b(a16);
        if (b16 == null) {
            return false;
        }
        c(b16);
        return true;
    }

    public com.tencent.luggage.wxa.xo.d h() {
        com.tencent.luggage.wxa.xo.d c16 = com.tencent.luggage.wxa.xo.h.c().c(new b());
        Intrinsics.checkNotNullExpressionValue(c16, "override fun refreshSess\u2026ionInfo()\n        }\n    }");
        return c16;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.uo.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j call(Void r56) {
            if (!i.this.c()) {
                return null;
            }
            j a16 = i.this.a();
            if (a16.k() <= 0) {
                return a16;
            }
            f.f136098a.a(i.this.a(), new a(i.this, com.tencent.luggage.wxa.xo.h.b()));
            return new j();
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements e.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f136124a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f136125b;

            public a(i iVar, com.tencent.luggage.wxa.xo.b bVar) {
                this.f136124a = iVar;
                this.f136125b = bVar;
            }

            @Override // com.tencent.luggage.wxa.o3.e.c
            public void a(g err) {
                Intrinsics.checkNotNullParameter(err, "err");
                w.b("Luggage.WxaAccountManager", "refreshSessionInfo fail, err:" + err);
                this.f136124a.b();
                this.f136125b.a(err);
            }

            @Override // com.tencent.luggage.wxa.o3.e.c
            public void a(j jVar) {
                if (jVar != null) {
                    this.f136124a.c(jVar);
                    this.f136125b.a(this.f136124a.f136122d);
                } else {
                    w.b("Luggage.WxaAccountManager", "refreshSessionInfo fail, sessionInfo is null");
                    this.f136124a.b();
                    this.f136125b.a("sessionInfo is null");
                }
            }
        }
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void a(boolean z16) {
        this.f136121c = z16;
        if (z16) {
            c(k.f136136k);
            if (z.m()) {
                h();
                return;
            }
            return;
        }
        c(this.f136120b);
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void a(j jVar) {
        if (jVar == null) {
            jVar = this.f136120b;
        }
        c(jVar);
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public j a() {
        return this.f136122d;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public boolean c() {
        return !w0.c(e());
    }
}
