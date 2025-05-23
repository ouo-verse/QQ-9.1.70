package com.tencent.luggage.wxa.y8;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h extends Number {

    /* renamed from: a, reason: collision with root package name */
    public int f145482a;

    public h(int i3) {
        this.f145482a = i3;
    }

    public int a() {
        return this.f145482a;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return (this.f145482a | 0) + 0.0d;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) ((this.f145482a | 0) + 0.0d);
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.f145482a;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.f145482a & 4294967295L;
    }

    public String toString() {
        return "" + (this.f145482a & 4294967295L);
    }

    public static int a(String str) {
        try {
            return new h(Long.valueOf(str).longValue()).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public h(long j3) {
        this.f145482a = (int) (j3 & (-1));
    }

    public static String a(int i3) {
        return new h(i3).toString();
    }
}
