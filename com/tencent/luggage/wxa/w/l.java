package com.tencent.luggage.wxa.w;

import android.util.Log;
import com.tencent.luggage.wxa.w.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements h {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143887a = new com.tencent.luggage.wxa.n0.l(10);

    /* renamed from: b, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f143888b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f143889c;

    /* renamed from: d, reason: collision with root package name */
    public long f143890d;

    /* renamed from: e, reason: collision with root package name */
    public int f143891e;

    /* renamed from: f, reason: collision with root package name */
    public int f143892f;

    @Override // com.tencent.luggage.wxa.w.h
    public void a() {
        this.f143889c = false;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void b() {
        int i3;
        if (this.f143889c && (i3 = this.f143891e) != 0 && this.f143892f == i3) {
            this.f143888b.a(this.f143890d, 1, i3, 0, null);
            this.f143889c = false;
        }
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        dVar.a();
        com.tencent.luggage.wxa.q.l a16 = fVar.a(dVar.c(), 4);
        this.f143888b = a16;
        a16.a(com.tencent.luggage.wxa.m.j.a(dVar.b(), "application/id3", (String) null, -1, (com.tencent.luggage.wxa.p.a) null));
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(long j3, boolean z16) {
        if (z16) {
            this.f143889c = true;
            this.f143890d = j3;
            this.f143891e = 0;
            this.f143892f = 0;
        }
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.n0.l lVar) {
        if (this.f143889c) {
            int a16 = lVar.a();
            int i3 = this.f143892f;
            if (i3 < 10) {
                int min = Math.min(a16, 10 - i3);
                System.arraycopy(lVar.f135088a, lVar.c(), this.f143887a.f135088a, this.f143892f, min);
                if (this.f143892f + min == 10) {
                    this.f143887a.e(0);
                    if (73 == this.f143887a.q() && 68 == this.f143887a.q() && 51 == this.f143887a.q()) {
                        this.f143887a.f(3);
                        this.f143891e = this.f143887a.p() + 10;
                    } else {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.f143889c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a16, this.f143891e - this.f143892f);
            this.f143888b.a(lVar, min2);
            this.f143892f += min2;
        }
    }
}
