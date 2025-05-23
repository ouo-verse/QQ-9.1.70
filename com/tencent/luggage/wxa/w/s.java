package com.tencent.luggage.wxa.w;

import com.tencent.luggage.wxa.w.v;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final List f143944a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.q.l[] f143945b;

    public s(List list) {
        this.f143944a = list;
        this.f143945b = new com.tencent.luggage.wxa.q.l[list.size()];
    }

    public void a(com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        for (int i3 = 0; i3 < this.f143945b.length; i3++) {
            dVar.a();
            com.tencent.luggage.wxa.q.l a16 = fVar.a(dVar.c(), 3);
            com.tencent.luggage.wxa.m.j jVar = (com.tencent.luggage.wxa.m.j) this.f143944a.get(i3);
            String str = jVar.f133896f;
            com.tencent.luggage.wxa.n0.a.a("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            String str2 = jVar.f133891a;
            if (str2 == null) {
                str2 = dVar.b();
            }
            a16.a(com.tencent.luggage.wxa.m.j.a(str2, str, (String) null, -1, jVar.M, jVar.N, jVar.O, (com.tencent.luggage.wxa.p.a) null));
            this.f143945b[i3] = a16;
        }
    }

    public void a(long j3, com.tencent.luggage.wxa.n0.l lVar) {
        com.tencent.luggage.wxa.i0.a.a(j3, lVar, this.f143945b);
    }
}
