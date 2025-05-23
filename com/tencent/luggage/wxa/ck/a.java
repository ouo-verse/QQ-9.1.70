package com.tencent.luggage.wxa.ck;

import android.content.Intent;
import com.tencent.luggage.wxa.kj.k1;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements e {

    /* renamed from: b, reason: collision with root package name */
    public final String f123572b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.c5.e f123573c;

    /* renamed from: d, reason: collision with root package name */
    public Intent f123574d;

    /* renamed from: k, reason: collision with root package name */
    public l f123581k;

    /* renamed from: e, reason: collision with root package name */
    public boolean f123575e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f123576f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f123577g = false;

    /* renamed from: h, reason: collision with root package name */
    public h f123578h = null;

    /* renamed from: i, reason: collision with root package name */
    public i f123579i = null;

    /* renamed from: j, reason: collision with root package name */
    public k f123580j = null;

    /* renamed from: l, reason: collision with root package name */
    public volatile g f123582l = null;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ck.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class C6116a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f123583a;

        static {
            int[] iArr = new int[k1.values().length];
            f123583a = iArr;
            try {
                iArr[k1.APP_LAUNCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f123583a[k1.REDIRECT_TO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f123583a[k1.REWRITE_ROUTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f123583a[k1.RE_LAUNCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f123583a[k1.AUTO_RE_LAUNCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public a(com.tencent.luggage.wxa.c5.e eVar) {
        this.f123581k = null;
        this.f123572b = eVar.getAppId();
        this.f123573c = eVar;
        this.f123581k = l.a(eVar);
        e();
    }

    @Override // com.tencent.luggage.wxa.ck.e
    public g a() {
        return this.f123582l;
    }

    @Override // com.tencent.luggage.wxa.ck.e
    public l b() {
        return this.f123581k;
    }

    @Override // com.tencent.luggage.wxa.ck.e
    public Intent c() {
        return this.f123574d;
    }

    @Override // com.tencent.luggage.wxa.ck.e
    public k d() {
        return this.f123580j;
    }

    public void e() {
        String O;
        if (w0.c(this.f123572b)) {
            w.b("MicroMsg.AppBrandPageContainerReporter", "resetSession with dummy model, stack %s", w0.a(new Throwable()));
            this.f123582l = g.f123598a;
            this.f123579i = i.a();
            this.f123578h = h.a();
            this.f123580j = k.a();
            return;
        }
        String j3 = this.f123573c.S().j();
        String a16 = d.a(this.f123573c.S().N);
        if (this.f123582l != null && this.f123582l.peek() != null) {
            O = this.f123582l.peek().f123600b;
        } else {
            O = this.f123573c.O();
        }
        this.f123582l = new c(a16, O);
        this.f123578h = h.a(this.f123573c, j3, this.f123582l);
        LinkedList linkedList = new LinkedList();
        linkedList.push(w0.d(a16));
        this.f123580j = k.a(this.f123573c, j3, linkedList);
        this.f123579i = i.a(this.f123573c, j3, this.f123582l);
    }

    @Override // com.tencent.luggage.wxa.ck.e
    public void a(Intent intent) {
        this.f123574d = intent;
    }

    @Override // com.tencent.luggage.wxa.ck.e
    public void b(com.tencent.luggage.wxa.m4.b bVar) {
        if (bVar == null || this.f123575e) {
            return;
        }
        d(bVar);
    }

    @Override // com.tencent.luggage.wxa.ck.f
    public void c(com.tencent.luggage.wxa.m4.b bVar) {
        this.f123574d = null;
        if (this.f123576f) {
            this.f123576f = false;
        } else {
            this.f123582l.c(bVar);
            this.f123579i.a(bVar);
        }
    }

    @Override // com.tencent.luggage.wxa.ck.f
    public void d(com.tencent.luggage.wxa.m4.b bVar) {
        this.f123575e = true;
        this.f123582l.d(bVar);
        bVar.u1().g();
        this.f123578h.a(this.f123573c, bVar);
        this.f123580j.a(bVar);
    }

    @Override // com.tencent.luggage.wxa.ck.f
    public void a(com.tencent.luggage.wxa.m4.b bVar, com.tencent.luggage.wxa.m4.b bVar2, k1 k1Var) {
        k1 k1Var2 = k1.AUTO_RE_LAUNCH;
        if (k1Var2 == k1Var && this.f123577g) {
            this.f123577g = false;
            e();
        } else {
            this.f123577g = false;
        }
        boolean z16 = k1Var2 == k1Var || bVar2 == null || w0.c(bVar2.B0()) || bVar2 == bVar;
        this.f123582l.a(bVar, z16 ? null : bVar2, k1Var);
        if (!z16) {
            bVar2.u1().g();
            a(bVar, bVar2);
        } else {
            a(bVar, (com.tencent.luggage.wxa.m4.b) null);
        }
    }

    public final void a(com.tencent.luggage.wxa.m4.b bVar, com.tencent.luggage.wxa.m4.b bVar2) {
        if (bVar2 != null) {
            this.f123578h.a(this.f123573c, bVar2, bVar.B0());
            this.f123580j.a(bVar2, bVar.B0());
        }
        this.f123579i.b(bVar);
    }

    @Override // com.tencent.luggage.wxa.ck.e
    public void a(long j3) {
        a(j3, 4);
    }

    @Override // com.tencent.luggage.wxa.ck.e
    public void a(long j3, k1 k1Var) {
        a aVar;
        int i3;
        int i16 = C6116a.f123583a[k1Var.ordinal()];
        int i17 = 5;
        if (i16 == 1) {
            aVar = this;
            i3 = 1;
        } else if (i16 == 2 || i16 == 3 || i16 == 4 || i16 == 5) {
            aVar = this;
            i3 = 3;
        } else {
            aVar = this;
            i3 = 2;
        }
        aVar.a(j3, i3);
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(390L, 0L, 1L, false);
        switch (((int) j3) / 250) {
            case 0:
                i17 = 1;
                break;
            case 1:
                i17 = 2;
                break;
            case 2:
                i17 = 3;
                break;
            case 3:
                i17 = 4;
                break;
            case 4:
            case 5:
                break;
            case 6:
            case 7:
                i17 = 6;
                break;
            default:
                i17 = 7;
                break;
        }
        ((com.tencent.luggage.wxa.zj.b) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.b.class)).a(390L, i17, 1L, false);
    }

    public final void a(long j3, int i3) {
        com.tencent.luggage.wxa.j4.g j06 = this.f123573c.j0();
        if (j06 == null) {
            return;
        }
        ((com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)).a(13543, this.f123572b, Integer.valueOf(j06.f125966l.pkgVersion), Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(this.f123573c.S().I + 1000));
    }
}
