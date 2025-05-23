package com.tencent.hippykotlin.demo.pages.nearby.main.base;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import kotlin.math.MathKt__MathJVMKt;

/* loaded from: classes31.dex */
public final class NBPMapUtil {
    public static final NBPMapUtil INSTANCE = new NBPMapUtil();

    public final double distanceBetween(NBPLatLng nBPLatLng, NBPLatLng nBPLatLng2) {
        return distanceBetween(nBPLatLng.latitude, nBPLatLng.longitude, nBPLatLng2.latitude, nBPLatLng2.longitude);
    }

    public final double distanceBetween(double d16, double d17, double d18, double d19) {
        int roundToInt;
        double d26 = (d16 * 3.141592653589793d) / 180.0d;
        double d27 = (d18 * 3.141592653589793d) / 180.0d;
        roundToInt = MathKt__MathJVMKt.roundToInt(Math.asin(Math.sqrt((Math.pow(Math.sin((((d17 * 3.141592653589793d) / 180.0d) - ((d19 * 3.141592653589793d) / 180.0d)) / 2.0d), 2.0d) * Math.cos(d27) * Math.cos(d26)) + Math.pow(Math.sin((d26 - d27) / 2.0d), 2.0d))) * 2.0d * 6378.137d * 10000.0d);
        return (roundToInt / 10000.0d) * 1000.0d;
    }
}
