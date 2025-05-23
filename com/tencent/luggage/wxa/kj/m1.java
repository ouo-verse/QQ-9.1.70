package com.tencent.luggage.wxa.kj;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m1 {

    /* renamed from: a, reason: collision with root package name */
    public final String f132246a;

    /* renamed from: b, reason: collision with root package name */
    public final String f132247b;

    /* renamed from: c, reason: collision with root package name */
    public final int f132248c;

    /* renamed from: d, reason: collision with root package name */
    public final long f132249d;

    public m1(String str, int i3, long j3) {
        this.f132246a = str;
        this.f132247b = com.tencent.luggage.wxa.h6.o.b(str);
        this.f132248c = i3;
        this.f132249d = j3;
    }

    public int a() {
        return this.f132248c;
    }

    public long b() {
        return this.f132249d;
    }

    public String c() {
        return this.f132247b;
    }

    public String d() {
        return this.f132246a;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof m1) && ((m1) obj).f132248c == this.f132248c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f132248c;
    }
}
