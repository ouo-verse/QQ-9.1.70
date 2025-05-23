package com.tencent.luggage.wxa.m;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p {

    /* renamed from: d, reason: collision with root package name */
    public static final p f133919d = new p(1.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final float f133920a;

    /* renamed from: b, reason: collision with root package name */
    public final float f133921b;

    /* renamed from: c, reason: collision with root package name */
    public final int f133922c;

    public p(float f16, float f17) {
        this.f133920a = f16;
        this.f133921b = f17;
        this.f133922c = Math.round(f16 * 1000.0f);
    }

    public long a(long j3) {
        return j3 * this.f133922c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f133920a == pVar.f133920a && this.f133921b == pVar.f133921b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((Float.floatToRawIntBits(this.f133920a) + 527) * 31) + Float.floatToRawIntBits(this.f133921b);
    }
}
