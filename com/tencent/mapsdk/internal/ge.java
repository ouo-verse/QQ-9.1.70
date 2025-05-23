package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ge implements Coordinate, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public static final double f148478a = 2.003750834E7d;

    /* renamed from: b, reason: collision with root package name */
    public double f148479b = Double.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public double f148480c = Double.MIN_VALUE;

    public ge(double d16, double d17) {
        setX(d16);
        setY(d17);
    }

    private double a() {
        return this.f148479b;
    }

    private double b() {
        return this.f148480c;
    }

    private ge c() {
        return new ge(this.f148480c, this.f148479b);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new ge(this.f148480c, this.f148479b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj.hashCode() != hashCode() || !(obj instanceof ge)) {
            return false;
        }
        ge geVar = (ge) obj;
        if (Double.doubleToLongBits(geVar.f148480c) == Double.doubleToLongBits(this.f148480c) && Double.doubleToLongBits(geVar.f148479b) == Double.doubleToLongBits(this.f148479b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f148480c);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f148479b);
        return ((((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32))) + 31) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final void setX(double d16) {
        this.f148480c = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d16));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final void setY(double d16) {
        this.f148479b = Math.max(-2.003750834E7d, Math.min(2.003750834E7d, d16));
    }

    public final String toString() {
        return "x=" + this.f148480c + ",y=" + this.f148479b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final double x() {
        return this.f148480c;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final double y() {
        return this.f148479b;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final double z() {
        return 0.0d;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate
    public final void setZ(double d16) {
    }
}
