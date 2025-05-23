package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class kr {
    private static double a(LatLng latLng, LatLng latLng2) {
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
        return Math.asin(Math.sqrt(d38 + ((d39 - sin4) * (d39 - sin4))) / 2.0d) * 1.27420015798544E7d;
    }

    private static LatLng b(LatLng latLng, LatLng latLng2) {
        return new LatLng((latLng.latitude * 2.0d) - latLng2.latitude, (latLng.longitude * 2.0d) - latLng2.longitude);
    }
}
