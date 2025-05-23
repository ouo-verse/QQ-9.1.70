package com.tencent.tencentmap.mapsdk.maps.utils;

import android.graphics.Point;
import com.tencent.mapsdk.internal.lg;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TencentMapUtils {
    public static double calculateArea(List<LatLng> list) {
        return lg.a(list);
    }

    public static boolean hitTestPolyline(List<LatLng> list, LatLng latLng, double d16) {
        return lg.a(latLng, list, d16);
    }

    public static double meterToMercator(double d16, double d17) {
        return lg.a(d16, d17);
    }

    public static double pixelToMercator(TencentMap tencentMap, double d16) {
        LatLng center = tencentMap.getProjection().getVisibleRegion().latLngBounds.getCenter();
        return tencentMap.getProjection().fromScreenLocation(new Point((int) (r1.x + d16), tencentMap.getProjection().toScreenLocation(center).y)).longitude - center.longitude;
    }
}
