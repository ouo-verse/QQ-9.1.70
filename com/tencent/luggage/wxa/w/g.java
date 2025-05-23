package com.tencent.luggage.wxa.w;

import com.tencent.luggage.wxa.w.v;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g implements h {

    /* renamed from: a, reason: collision with root package name */
    public final List f143787a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.q.l[] f143788b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f143789c;

    /* renamed from: d, reason: collision with root package name */
    public int f143790d;

    /* renamed from: e, reason: collision with root package name */
    public int f143791e;

    /* renamed from: f, reason: collision with root package name */
    public long f143792f;

    public g(List list) {
        this.f143787a = list;
        this.f143788b = new com.tencent.luggage.wxa.q.l[list.size()];
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a() {
        this.f143789c = false;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void b() {
        if (this.f143789c) {
            for (com.tencent.luggage.wxa.q.l lVar : this.f143788b) {
                lVar.a(this.f143792f, 1, this.f143791e, 0, null);
            }
            this.f143789c = false;
        }
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        for (int i3 = 0; i3 < this.f143788b.length; i3++) {
            v.a aVar = (v.a) this.f143787a.get(i3);
            dVar.a();
            com.tencent.luggage.wxa.q.l a16 = fVar.a(dVar.c(), 3);
            a16.a(com.tencent.luggage.wxa.m.j.a(dVar.b(), "application/dvbsubs", (String) null, -1, Collections.singletonList(aVar.f143973c), aVar.f143971a, (com.tencent.luggage.wxa.p.a) null));
            this.f143788b[i3] = a16;
        }
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(long j3, boolean z16) {
        if (z16) {
            this.f143789c = true;
            this.f143792f = j3;
            this.f143791e = 0;
            this.f143790d = 2;
        }
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.n0.l lVar) {
        if (this.f143789c) {
            if (this.f143790d != 2 || a(lVar, 32)) {
                if (this.f143790d != 1 || a(lVar, 0)) {
                    int c16 = lVar.c();
                    int a16 = lVar.a();
                    for (com.tencent.luggage.wxa.q.l lVar2 : this.f143788b) {
                        lVar.e(c16);
                        lVar2.a(lVar, a16);
                    }
                    this.f143791e += a16;
                }
            }
        }
    }

    public final boolean a(com.tencent.luggage.wxa.n0.l lVar, int i3) {
        if (lVar.a() == 0) {
            return false;
        }
        if (lVar.q() != i3) {
            this.f143789c = false;
        }
        this.f143790d--;
        return this.f143789c;
    }
}
