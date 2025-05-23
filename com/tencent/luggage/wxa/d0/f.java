package com.tencent.luggage.wxa.d0;

import android.net.Uri;
import android.os.Handler;
import com.tencent.luggage.wxa.d0.e;
import com.tencent.luggage.wxa.d0.h;
import com.tencent.luggage.wxa.l0.g;
import com.tencent.luggage.wxa.m.u;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements h, e.f {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f123982a;

    /* renamed from: b, reason: collision with root package name */
    public final g.a f123983b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.q.g f123984c;

    /* renamed from: d, reason: collision with root package name */
    public final int f123985d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f123986e;

    /* renamed from: f, reason: collision with root package name */
    public final a f123987f;

    /* renamed from: g, reason: collision with root package name */
    public final u.b f123988g;

    /* renamed from: h, reason: collision with root package name */
    public final String f123989h;

    /* renamed from: i, reason: collision with root package name */
    public final int f123990i;

    /* renamed from: j, reason: collision with root package name */
    public h.a f123991j;

    /* renamed from: k, reason: collision with root package name */
    public long f123992k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f123993l;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void onLoadError(IOException iOException);
    }

    public f(Uri uri, g.a aVar, com.tencent.luggage.wxa.q.g gVar, Handler handler, a aVar2) {
        this(uri, aVar, gVar, handler, aVar2, null);
    }

    @Override // com.tencent.luggage.wxa.d0.h
    public void a() {
    }

    @Override // com.tencent.luggage.wxa.d0.h
    public void b() {
        this.f123991j = null;
    }

    public f(Uri uri, g.a aVar, com.tencent.luggage.wxa.q.g gVar, Handler handler, a aVar2, String str) {
        this(uri, aVar, gVar, -1, handler, aVar2, str, 1048576);
    }

    @Override // com.tencent.luggage.wxa.d0.h
    public void a(com.tencent.luggage.wxa.m.e eVar, boolean z16, h.a aVar) {
        this.f123991j = aVar;
        b(-9223372036854775807L, false);
    }

    public final void b(long j3, boolean z16) {
        this.f123992k = j3;
        this.f123993l = z16;
        this.f123991j.a(new m(this.f123992k, this.f123993l), null);
    }

    public f(Uri uri, g.a aVar, com.tencent.luggage.wxa.q.g gVar, int i3, Handler handler, a aVar2, String str, int i16) {
        this.f123982a = uri;
        this.f123983b = aVar;
        this.f123984c = gVar;
        this.f123985d = i3;
        this.f123986e = handler;
        this.f123987f = aVar2;
        this.f123989h = str;
        this.f123990i = i16;
        this.f123988g = new u.b();
    }

    @Override // com.tencent.luggage.wxa.d0.h
    public g a(h.b bVar, com.tencent.luggage.wxa.l0.b bVar2) {
        com.tencent.luggage.wxa.n0.a.a(bVar.f123995a == 0);
        return new e(this.f123982a, this.f123983b.createDataSource(), this.f123984c.a(), this.f123985d, this.f123986e, this.f123987f, this, bVar2, this.f123989h, this.f123990i);
    }

    @Override // com.tencent.luggage.wxa.d0.h
    public void a(g gVar) {
        ((e) gVar).m();
    }

    @Override // com.tencent.luggage.wxa.d0.e.f
    public void a(long j3, boolean z16) {
        if (j3 == -9223372036854775807L) {
            j3 = this.f123992k;
        }
        long j16 = this.f123992k;
        if (j16 == j3 && this.f123993l == z16) {
            return;
        }
        if (j16 == -9223372036854775807L || j3 != -9223372036854775807L) {
            b(j3, z16);
        }
    }
}
