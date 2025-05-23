package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class fw implements Coordinate {

    /* renamed from: a, reason: collision with root package name */
    public double f148383a;

    /* renamed from: b, reason: collision with root package name */
    public double f148384b;

    public fw() {
    }

    private fw b(double d16, double d17) {
        return new fw(this.f148383a + d16, this.f148384b + d17);
    }

    private fw c(double d16, double d17) {
        return new fw(this.f148383a - d16, this.f148384b - d17);
    }

    private fw d(double d16, double d17) {
        return new fw(this.f148383a * d16, this.f148384b * d17);
    }

    private static boolean e(double d16, double d17) {
        if (Double.compare(d16, d17) == 0 || Math.abs(d16 - d17) <= 1.0E-6d) {
            return false;
        }
        return true;
    }

    public final void a(double d16, double d17) {
        this.f148383a = d16;
        this.f148384b = d17;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof fw) {
            fw fwVar = (fw) obj;
            if (!e(this.f148383a, fwVar.f148383a) && !e(this.f148384b, fwVar.f148384b)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final void setX(double d16) {
        this.f148383a = d16;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final void setY(double d16) {
        this.f148384b = d16;
    }

    public final String toString() {
        return this.f148383a + "," + this.f148384b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final double x() {
        return this.f148383a;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final double y() {
        return this.f148384b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final double z() {
        return 0.0d;
    }

    public fw(double d16, double d17) {
        this.f148383a = d16;
        this.f148384b = d17;
    }

    private fw b(fw fwVar) {
        return new fw(this.f148383a - fwVar.f148383a, this.f148384b - fwVar.f148384b);
    }

    private float c(fw fwVar) {
        return fwVar.b(this).b();
    }

    private fw d() {
        double b16 = 1.0d / b();
        return new fw(this.f148383a * b16, this.f148384b * b16);
    }

    private boolean a() {
        double d16 = this.f148383a;
        if (d16 < 0.0d || d16 > 1.0d) {
            return false;
        }
        double d17 = this.f148384b;
        return d17 >= 0.0d && d17 <= 1.0d;
    }

    private fw c() {
        double b16 = 1.0d / b();
        return new fw(this.f148383a * b16, this.f148384b * b16);
    }

    private fw a(fw fwVar) {
        return new fw(this.f148383a + fwVar.f148383a, this.f148384b + fwVar.f148384b);
    }

    private float b() {
        return (float) Math.hypot(this.f148383a, this.f148384b);
    }

    private fw a(double d16) {
        return new fw(this.f148383a * d16, this.f148384b * d16);
    }

    private fw a(int i3) {
        double d16 = this.f148383a;
        double d17 = this.f148384b;
        int i16 = 0;
        while (i16 < i3) {
            double d18 = -d16;
            i16++;
            d16 = d17;
            d17 = d18;
        }
        return new fw(d16, d17);
    }

    private fw a(float f16) {
        double d16 = f16;
        return new fw((float) ((Math.cos(d16) * this.f148383a) - (Math.sin(d16) * this.f148384b)), (float) ((Math.sin(d16) * this.f148383a) + (Math.cos(d16) * this.f148384b)));
    }

    private fw a(fw fwVar, float f16) {
        fw b16 = b(fwVar);
        double d16 = f16;
        fw fwVar2 = new fw((float) ((Math.cos(d16) * b16.f148383a) - (Math.sin(d16) * b16.f148384b)), (float) ((Math.sin(d16) * b16.f148383a) + (Math.cos(d16) * b16.f148384b)));
        return new fw(fwVar2.f148383a + fwVar.f148383a, fwVar2.f148384b + fwVar.f148384b);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final void setZ(double d16) {
    }
}
