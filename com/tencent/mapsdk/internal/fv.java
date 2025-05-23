package com.tencent.mapsdk.internal;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class fv {

    /* renamed from: a, reason: collision with root package name */
    public final double f148377a;

    /* renamed from: b, reason: collision with root package name */
    public final double f148378b;

    /* renamed from: c, reason: collision with root package name */
    public final double f148379c;

    /* renamed from: d, reason: collision with root package name */
    public final double f148380d;

    /* renamed from: e, reason: collision with root package name */
    public final double f148381e;

    /* renamed from: f, reason: collision with root package name */
    public final double f148382f;

    public fv(double d16, double d17, double d18, double d19) {
        this.f148377a = d16;
        this.f148378b = d18;
        this.f148379c = d17;
        this.f148380d = d19;
        this.f148381e = (d16 + d17) / 2.0d;
        this.f148382f = (d18 + d19) / 2.0d;
    }

    private boolean b(fv fvVar) {
        if (fvVar.f148377a >= this.f148377a && fvVar.f148379c <= this.f148379c && fvVar.f148378b >= this.f148378b && fvVar.f148380d <= this.f148380d) {
            return true;
        }
        return false;
    }

    public final boolean a(double d16, double d17) {
        return this.f148377a <= d16 && d16 <= this.f148379c && this.f148378b <= d17 && d17 <= this.f148380d;
    }

    public final String toString() {
        return "Bounds{minX=" + this.f148377a + ", minY=" + this.f148378b + ", maxX=" + this.f148379c + ", maxY=" + this.f148380d + '}';
    }

    private boolean a(fw fwVar) {
        return a(fwVar.f148383a, fwVar.f148384b);
    }

    private boolean a(double d16, double d17, double d18, double d19) {
        return d16 < this.f148379c && this.f148377a < d17 && d18 < this.f148380d && this.f148378b < d19;
    }

    public final boolean a(fv fvVar) {
        return a(fvVar.f148377a, fvVar.f148379c, fvVar.f148378b, fvVar.f148380d);
    }
}
