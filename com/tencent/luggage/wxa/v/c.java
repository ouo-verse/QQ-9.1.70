package com.tencent.luggage.wxa.v;

import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements com.tencent.luggage.wxa.q.d {

    /* renamed from: d, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.q.g f142863d = new a();

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.f f142864a;

    /* renamed from: b, reason: collision with root package name */
    public h f142865b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f142866c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements com.tencent.luggage.wxa.q.g {
        @Override // com.tencent.luggage.wxa.q.g
        public com.tencent.luggage.wxa.q.d[] a() {
            return new com.tencent.luggage.wxa.q.d[]{new c()};
        }
    }

    @Override // com.tencent.luggage.wxa.q.d
    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        try {
            return b(eVar);
        } catch (o unused) {
            return false;
        }
    }

    public final boolean b(com.tencent.luggage.wxa.q.e eVar) {
        e eVar2 = new e();
        if (eVar2.a(eVar, true) && (eVar2.f142874b & 2) == 2) {
            int min = Math.min(eVar2.f142881i, 8);
            l lVar = new l(min);
            eVar.b(lVar.f135088a, 0, min);
            if (b.c(a(lVar))) {
                this.f142865b = new b();
            } else if (j.c(a(lVar))) {
                this.f142865b = new j();
            } else if (g.b(a(lVar))) {
                this.f142865b = new g();
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(com.tencent.luggage.wxa.q.f fVar) {
        this.f142864a = fVar;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        h hVar = this.f142865b;
        if (hVar != null) {
            hVar.a(j3, j16);
        }
    }

    @Override // com.tencent.luggage.wxa.q.d
    public int a(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        if (this.f142865b == null) {
            if (b(eVar)) {
                eVar.a();
            } else {
                throw new o("Failed to determine bitstream type");
            }
        }
        if (!this.f142866c) {
            com.tencent.luggage.wxa.q.l a16 = this.f142864a.a(0, 1);
            this.f142864a.e();
            this.f142865b.a(this.f142864a, a16);
            this.f142866c = true;
        }
        return this.f142865b.a(eVar, jVar);
    }

    public static l a(l lVar) {
        lVar.e(0);
        return lVar;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }
}
