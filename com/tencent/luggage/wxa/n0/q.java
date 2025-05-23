package com.tencent.luggage.wxa.n0;

import android.os.SystemClock;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q implements h {

    /* renamed from: a, reason: collision with root package name */
    public boolean f135096a;

    /* renamed from: b, reason: collision with root package name */
    public long f135097b;

    /* renamed from: c, reason: collision with root package name */
    public long f135098c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.m.p f135099d = com.tencent.luggage.wxa.m.p.f133919d;

    public void a() {
        if (this.f135096a) {
            return;
        }
        this.f135098c = SystemClock.elapsedRealtime();
        this.f135096a = true;
    }

    public void b() {
        if (this.f135096a) {
            a(j());
            this.f135096a = false;
        }
    }

    @Override // com.tencent.luggage.wxa.n0.h
    public com.tencent.luggage.wxa.m.p h() {
        return this.f135099d;
    }

    @Override // com.tencent.luggage.wxa.n0.h
    public long j() {
        long a16;
        long j3 = this.f135097b;
        if (this.f135096a) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f135098c;
            com.tencent.luggage.wxa.m.p pVar = this.f135099d;
            if (pVar.f133920a == 1.0f) {
                a16 = com.tencent.luggage.wxa.m.b.a(elapsedRealtime);
            } else {
                a16 = pVar.a(elapsedRealtime);
            }
            return j3 + a16;
        }
        return j3;
    }

    public void a(long j3) {
        this.f135097b = j3;
        if (this.f135096a) {
            this.f135098c = SystemClock.elapsedRealtime();
        }
    }

    public void a(h hVar) {
        a(hVar.j());
        this.f135099d = hVar.h();
    }

    @Override // com.tencent.luggage.wxa.n0.h
    public com.tencent.luggage.wxa.m.p a(com.tencent.luggage.wxa.m.p pVar) {
        if (this.f135096a) {
            a(j());
        }
        this.f135099d = pVar;
        return pVar;
    }
}
