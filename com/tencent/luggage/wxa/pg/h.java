package com.tencent.luggage.wxa.pg;

import java.util.Comparator;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h implements d, Comparator {

    /* renamed from: a, reason: collision with root package name */
    public volatile long f137561a;

    /* renamed from: b, reason: collision with root package name */
    public final TreeSet f137562b = new TreeSet(this);

    /* renamed from: c, reason: collision with root package name */
    public long f137563c;

    public h(long j3) {
        this.f137561a = j3;
    }

    @Override // com.tencent.luggage.wxa.pg.d
    public void a(a aVar, String str, long j3, long j16) {
        a(aVar, j16);
    }

    @Override // com.tencent.luggage.wxa.pg.a.InterfaceC6600a
    public void b(a aVar, f fVar) {
        this.f137562b.remove(fVar);
        this.f137563c -= fVar.f137555c;
    }

    @Override // com.tencent.luggage.wxa.pg.a.InterfaceC6600a
    public void a(a aVar, f fVar) {
        this.f137562b.add(fVar);
        this.f137563c += fVar.f137555c;
        a(aVar, 0L);
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(f fVar, f fVar2) {
        long j3 = fVar.f137560h;
        long j16 = fVar2.f137560h;
        if (j3 - j16 == 0) {
            return fVar.compareTo(fVar2);
        }
        return j3 < j16 ? -1 : 1;
    }

    public final void a(a aVar, long j3) {
        while (this.f137563c + j3 > this.f137561a && !this.f137562b.isEmpty()) {
            aVar.a((f) this.f137562b.first());
        }
    }

    public void a(long j3) {
        this.f137561a = j3;
    }
}
