package com.tencent.luggage.wxa.p3;

import com.tencent.luggage.wxa.n3.ai;
import com.tencent.luggage.wxa.n3.aj;
import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.n3.y;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f extends com.tencent.luggage.wxa.o3.c {

    /* renamed from: e, reason: collision with root package name */
    public static final a f137151e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public boolean f137152b;

    /* renamed from: c, reason: collision with root package name */
    public volatile com.tencent.luggage.wxa.o3.j f137153c;

    /* renamed from: d, reason: collision with root package name */
    public b f137154d = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements t.a {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, int i16, com.tencent.luggage.wxa.n3.a aVar) {
            ai.a(this, i3, i16, aVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void onLoginComplete(int i3) {
            ai.g(this, i3);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void onLogoutComplete(int i3) {
            ai.h(this, i3);
        }

        @Override // com.tencent.luggage.wxa.n3.u.a
        public /* synthetic */ void a(int i3, int i16, byte[] bArr) {
            aj.a(this, i3, i16, bArr);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, com.tencent.luggage.wxa.n3.c cVar) {
            ai.b(this, i3, cVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, com.tencent.luggage.wxa.n3.d dVar) {
            ai.c(this, i3, dVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, com.tencent.luggage.wxa.n3.l lVar) {
            ai.d(this, i3, lVar);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public /* synthetic */ void a(int i3, com.tencent.luggage.wxa.n3.o oVar) {
            ai.e(this, i3, oVar);
        }

        @Override // com.tencent.luggage.wxa.n3.u.a
        public /* synthetic */ void a(byte[] bArr) {
            aj.b(this, bArr);
        }

        @Override // com.tencent.luggage.wxa.n3.t.a
        public void a(y cmd) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            if (z.m()) {
                f.this.a(cmd);
            }
        }
    }

    public void a(y yVar) {
    }

    @Override // com.tencent.luggage.wxa.o3.c, com.tencent.luggage.wxa.o3.e
    public synchronized void b() {
        w.d("ILink.TdiAccountManager", "logout");
        if (this.f137152b) {
            com.tencent.luggage.wxa.o3.k.f136136k.l();
        } else {
            this.f137153c = null;
        }
        ((d) com.tencent.luggage.wxa.h1.e.a(d.class)).z();
        super.b();
    }

    public void c(com.tencent.luggage.wxa.o3.j sessionInfo) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        if (this.f137152b) {
            com.tencent.luggage.wxa.o3.k kVar = com.tencent.luggage.wxa.o3.k.f136136k;
            kVar.f(sessionInfo.g());
            kVar.b(sessionInfo.h());
            kVar.d(sessionInfo.e());
            kVar.c(sessionInfo.d());
            kVar.e(sessionInfo.f());
            kVar.a(sessionInfo.b());
            kVar.c(sessionInfo.i());
            kVar.a(sessionInfo.a());
            kVar.b(sessionInfo.c());
            return;
        }
        this.f137153c = sessionInfo;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public boolean d() {
        return this.f137152b;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public String e() {
        String g16;
        com.tencent.luggage.wxa.o3.j a16 = a();
        if (a16 == null || (g16 = a16.g()) == null) {
            return "";
        }
        return g16;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public boolean f() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public void a(boolean z16) {
        this.f137152b = z16;
        w.d("ILink.TdiAccountManager", "init share=" + this.f137152b);
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public synchronized void a(com.tencent.luggage.wxa.o3.j jVar) {
        if (jVar == null) {
            w.b("ILink.TdiAccountManager", "loginSessionInfo err: sessionInfo is null");
            return;
        }
        w.d("ILink.TdiAccountManager", "login success: isShare: " + this.f137152b);
        c(jVar);
        com.tencent.luggage.wxa.er.a.b(((com.tencent.luggage.wxa.s3.c) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.s3.c.class)).a(this.f137154d));
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public com.tencent.luggage.wxa.o3.j a() {
        if (this.f137152b) {
            return com.tencent.luggage.wxa.o3.k.f136136k;
        }
        return this.f137153c;
    }

    @Override // com.tencent.luggage.wxa.o3.e
    public synchronized boolean c() {
        return !w0.c(e());
    }
}
