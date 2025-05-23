package com.tencent.hippykotlin.demo.pages.nearby.main.map.heatmap;

import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPLatLng;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CameraSpeedTrackerKt {
    public static final double getDistanceToLeftTop(float f16, float f17, double d16, double d17, CameraPosition cameraPosition) {
        double d18 = f16 * 1.0d;
        double d19 = cameraPosition.topRightPosition.longitude;
        NBPLatLng nBPLatLng = cameraPosition.topLeftPosition;
        double d26 = nBPLatLng.longitude;
        double d27 = cameraPosition.bottomLeftPosition.latitude;
        double d28 = nBPLatLng.latitude;
        double d29 = (d17 - d26) * (d18 / (d19 - d26));
        double d36 = (d16 - d28) * ((f17 * 1.0d) / (d27 - d28));
        return Math.sqrt((d36 * d36) + (d29 * d29));
    }
}
