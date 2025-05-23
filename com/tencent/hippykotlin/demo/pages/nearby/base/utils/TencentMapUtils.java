package com.tencent.hippykotlin.demo.pages.nearby.base.utils;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TencentMapUtils {
    public static final TencentMapUtils INSTANCE = new TencentMapUtils();

    public final double meterDistanceBetween(NBPLatLng nBPLatLng, NBPLatLng nBPLatLng2) {
        double d16 = nBPLatLng.longitude * 0.017453292519943295d;
        double d17 = nBPLatLng.latitude * 0.017453292519943295d;
        double d18 = nBPLatLng2.longitude * 0.017453292519943295d;
        double d19 = nBPLatLng2.latitude * 0.017453292519943295d;
        double sin = Math.sin(d16);
        double sin2 = Math.sin(d17);
        double cos = Math.cos(d16);
        double cos2 = Math.cos(d17);
        double sin3 = Math.sin(d18);
        double sin4 = Math.sin(d19);
        double cos3 = Math.cos(d18);
        double cos4 = Math.cos(d19);
        double[] dArr = {cos * cos2, cos2 * sin, sin2};
        double d26 = cos3 * cos4;
        double d27 = cos4 * sin3;
        double d28 = dArr[0];
        double d29 = (d28 - d26) * (d28 - d26);
        double d36 = dArr[1];
        double d37 = ((d36 - d27) * (d36 - d27)) + d29;
        double d38 = dArr[2];
        return ((Math.asin(Math.sqrt(((d38 - sin4) * (d38 - sin4)) + d37) / 2.0d) * 4.007501668557849E7d) * 3.141592653589793d) / 10;
    }
}
