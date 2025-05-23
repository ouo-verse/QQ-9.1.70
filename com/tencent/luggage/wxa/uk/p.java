package com.tencent.luggage.wxa.uk;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public long f142773a;

    /* renamed from: b, reason: collision with root package name */
    public long f142774b;

    /* renamed from: c, reason: collision with root package name */
    public a f142775c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        boolean a(Object... objArr);
    }

    public p(long j3, a aVar) {
        this.f142773a = j3;
        this.f142775c = aVar;
    }

    public boolean a() {
        return System.currentTimeMillis() - this.f142774b < this.f142773a;
    }

    public void b() {
        this.f142774b = System.currentTimeMillis();
    }

    public boolean a(Object... objArr) {
        a aVar;
        if (a() || (aVar = this.f142775c) == null) {
            return false;
        }
        boolean a16 = aVar.a(objArr);
        if (a16) {
            b();
        }
        return a16;
    }
}
