package com.tencent.luggage.wxa.m0;

import com.tencent.luggage.wxa.m0.a;
import java.util.Comparator;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k implements f, Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final long f134003a;

    /* renamed from: b, reason: collision with root package name */
    public final TreeSet f134004b = new TreeSet(this);

    /* renamed from: c, reason: collision with root package name */
    public long f134005c;

    public k(long j3) {
        this.f134003a = j3;
    }

    @Override // com.tencent.luggage.wxa.m0.f
    public void a() {
    }

    @Override // com.tencent.luggage.wxa.m0.a.b
    public void b(a aVar, g gVar) {
        this.f134004b.remove(gVar);
        this.f134005c -= gVar.f133987c;
    }

    @Override // com.tencent.luggage.wxa.m0.f
    public void a(a aVar, String str, long j3, long j16) {
        a(aVar, j16);
    }

    @Override // com.tencent.luggage.wxa.m0.a.b
    public void a(a aVar, g gVar) {
        this.f134004b.add(gVar);
        this.f134005c += gVar.f133987c;
        a(aVar, 0L);
    }

    @Override // com.tencent.luggage.wxa.m0.a.b
    public void a(a aVar, g gVar, g gVar2) {
        b(aVar, gVar);
        a(aVar, gVar2);
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(g gVar, g gVar2) {
        long j3 = gVar.f133990f;
        long j16 = gVar2.f133990f;
        if (j3 - j16 == 0) {
            return gVar.compareTo(gVar2);
        }
        return j3 < j16 ? -1 : 1;
    }

    public final void a(a aVar, long j3) {
        while (this.f134005c + j3 > this.f134003a && !this.f134004b.isEmpty()) {
            try {
                aVar.b((g) this.f134004b.first());
            } catch (a.C6454a unused) {
            }
        }
    }
}
