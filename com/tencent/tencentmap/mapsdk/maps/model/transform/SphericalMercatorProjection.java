package com.tencent.tencentmap.mapsdk.maps.model.transform;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: classes26.dex */
public class SphericalMercatorProjection {
    public static double EARTH_RADIUS = 6378137.0d;
    final double mWorldWidth;

    public SphericalMercatorProjection() {
        this.mWorldWidth = EARTH_RADIUS * 6.283185307179586d;
    }

    public double distanceBetween(LatLng latLng, LatLng latLng2) {
        double d16 = latLng.longitude;
        double d17 = d16 * 0.01745329251994329d;
        double d18 = latLng.latitude * 0.01745329251994329d;
        double d19 = latLng2.longitude * 0.01745329251994329d;
        double d26 = latLng2.latitude * 0.01745329251994329d;
        double sin = Math.sin(d17);
        double sin2 = Math.sin(d18);
        double cos = Math.cos(d17);
        double cos2 = Math.cos(d18);
        double sin3 = Math.sin(d19);
        double sin4 = Math.sin(d26);
        double cos3 = Math.cos(d19);
        double cos4 = Math.cos(d26);
        double[] dArr = {cos * cos2, cos2 * sin, sin2};
        double d27 = cos3 * cos4;
        double d28 = cos4 * sin3;
        double d29 = dArr[0];
        double d36 = (d29 - d27) * (d29 - d27);
        double d37 = dArr[1];
        double d38 = d36 + ((d37 - d28) * (d37 - d28));
        double d39 = dArr[2];
        return Math.asin(Math.sqrt(d38 + ((d39 - sin4) * (d39 - sin4))) / 2.0d) * this.mWorldWidth * 3.141592653589793d;
    }

    public LatLng toLatLng(Point point) {
        double d16 = point.f375392x;
        double d17 = this.mWorldWidth;
        return new LatLng(90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (point.f375393y / d17))) * 2.0d) * 3.141592653589793d)) * 2.0d), ((d16 / d17) - 0.5d) * 360.0d);
    }

    public Point toPoint(LatLng latLng) {
        double d16 = (latLng.longitude / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        double log = ((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d;
        double d17 = this.mWorldWidth;
        return new Point(d16 * d17, log * d17);
    }

    public SphericalMercatorProjection(double d16) {
        this.mWorldWidth = d16;
    }
}
