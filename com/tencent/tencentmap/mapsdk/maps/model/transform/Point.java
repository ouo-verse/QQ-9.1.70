package com.tencent.tencentmap.mapsdk.maps.model.transform;

/* loaded from: classes26.dex */
public class Point {

    /* renamed from: x, reason: collision with root package name */
    public final double f375392x;

    /* renamed from: y, reason: collision with root package name */
    public final double f375393y;

    public Point(double d16, double d17) {
        this.f375392x = d16;
        this.f375393y = d17;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (this.f375392x != point.f375392x || this.f375393y != point.f375393y) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "Point{x=" + this.f375392x + ", y=" + this.f375393y + '}';
    }
}
