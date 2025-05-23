package com.tencent.luggage.wxa.f0;

import android.net.Uri;
import android.os.Handler;
import com.tencent.luggage.wxa.d0.a;
import com.tencent.luggage.wxa.d0.h;
import com.tencent.luggage.wxa.d0.m;
import com.tencent.luggage.wxa.g0.b;
import com.tencent.luggage.wxa.g0.e;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.l0.s;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h implements com.tencent.luggage.wxa.d0.h, e.f {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f125157a;

    /* renamed from: b, reason: collision with root package name */
    public final d f125158b;

    /* renamed from: c, reason: collision with root package name */
    public final int f125159c;

    /* renamed from: d, reason: collision with root package name */
    public final a.C6124a f125160d;

    /* renamed from: e, reason: collision with root package name */
    public final s.a f125161e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.g0.e f125162f;

    /* renamed from: g, reason: collision with root package name */
    public h.a f125163g;

    static {
        com.tencent.luggage.wxa.m.i.a("goog.exo.hls");
    }

    public h(Uri uri, g.a aVar, Handler handler, com.tencent.luggage.wxa.d0.a aVar2) {
        this(uri, aVar, 3, handler, aVar2);
    }

    @Override // com.tencent.luggage.wxa.d0.h
    public void a(com.tencent.luggage.wxa.m.e eVar, boolean z16, h.a aVar) {
        com.tencent.luggage.wxa.n0.a.b(this.f125162f == null);
        com.tencent.luggage.wxa.g0.e eVar2 = new com.tencent.luggage.wxa.g0.e(this.f125157a, this.f125158b, this.f125160d, this.f125159c, this, this.f125161e);
        this.f125162f = eVar2;
        this.f125163g = aVar;
        eVar2.f();
    }

    @Override // com.tencent.luggage.wxa.d0.h
    public void b() {
        com.tencent.luggage.wxa.g0.e eVar = this.f125162f;
        if (eVar != null) {
            eVar.e();
            this.f125162f = null;
        }
        this.f125163g = null;
    }

    public h(Uri uri, g.a aVar, int i3, Handler handler, com.tencent.luggage.wxa.d0.a aVar2) {
        this(uri, new b(aVar), i3, handler, aVar2);
    }

    public h(Uri uri, d dVar, int i3, Handler handler, com.tencent.luggage.wxa.d0.a aVar) {
        this(uri, dVar, i3, handler, aVar, new com.tencent.luggage.wxa.g0.d());
    }

    public h(Uri uri, d dVar, int i3, Handler handler, com.tencent.luggage.wxa.d0.a aVar, s.a aVar2) {
        this.f125157a = uri;
        this.f125158b = dVar;
        this.f125159c = i3;
        this.f125161e = aVar2;
        this.f125160d = new a.C6124a(handler, aVar);
    }

    @Override // com.tencent.luggage.wxa.d0.h
    public void a() {
        this.f125162f.d();
    }

    @Override // com.tencent.luggage.wxa.d0.h
    public com.tencent.luggage.wxa.d0.g a(h.b bVar, com.tencent.luggage.wxa.l0.b bVar2) {
        com.tencent.luggage.wxa.n0.a.a(bVar.f123995a == 0);
        return new g(this.f125162f, this.f125158b, this.f125159c, this.f125160d, bVar2);
    }

    @Override // com.tencent.luggage.wxa.d0.h
    public void a(com.tencent.luggage.wxa.d0.g gVar) {
        ((g) gVar).i();
    }

    @Override // com.tencent.luggage.wxa.g0.e.f
    public void a(com.tencent.luggage.wxa.g0.b bVar) {
        m mVar;
        long j3;
        boolean z16 = bVar.f126328m;
        long j16 = z16 ? 0L : -9223372036854775807L;
        long b16 = z16 ? com.tencent.luggage.wxa.m.b.b(bVar.f126320e) : -9223372036854775807L;
        long j17 = bVar.f126319d;
        if (this.f125162f.b()) {
            long j18 = bVar.f126327l ? bVar.f126320e + bVar.f126331p : -9223372036854775807L;
            List list = bVar.f126330o;
            if (j17 == -9223372036854775807L) {
                j3 = list.isEmpty() ? 0L : ((b.a) list.get(Math.max(0, list.size() - 3))).f126335d;
            } else {
                j3 = j17;
            }
            mVar = new m(j16, b16, j18, bVar.f126331p, bVar.f126320e, j3, true, !bVar.f126327l);
        } else {
            long j19 = j17 == -9223372036854775807L ? 0L : j17;
            long j26 = bVar.f126320e;
            long j27 = bVar.f126331p;
            mVar = new m(j16, b16, j26 + j27, j27, j26, j19, true, false);
        }
        this.f125163g.a(mVar, new e(this.f125162f.a(), bVar));
    }
}
