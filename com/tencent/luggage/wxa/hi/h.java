package com.tencent.luggage.wxa.hi;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h implements e {

    /* renamed from: a, reason: collision with root package name */
    public final int f127204a;

    /* renamed from: b, reason: collision with root package name */
    public final int f127205b;

    /* renamed from: c, reason: collision with root package name */
    public final int f127206c;

    /* renamed from: d, reason: collision with root package name */
    public final String f127207d;

    public h(int i3, int i16, int i17, String str) {
        this.f127204a = i3;
        this.f127205b = i16;
        this.f127206c = i17;
        this.f127207d = str;
    }

    @Override // com.tencent.luggage.wxa.hi.e
    public String a() {
        return this.f127207d;
    }

    @Override // com.tencent.luggage.wxa.hi.e
    public int c() {
        return this.f127205b;
    }

    @Override // com.tencent.luggage.wxa.hi.e
    public int e() {
        return this.f127206c;
    }

    @Override // com.tencent.luggage.wxa.hi.e
    public int getType() {
        return this.f127204a;
    }
}
