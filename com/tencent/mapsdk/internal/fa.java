package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface fa extends Projection {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(float f16, GeoPoint geoPoint);
    }

    double a(Point point, Point point2);

    float a(LatLng latLng, LatLng latLng2, int i3, int i16, int i17, int i18, LatLng latLng3);

    PointF a(LatLng latLng);

    GeoPoint a(fw fwVar);

    fw a(Context context, LatLng latLng);

    fw a(GeoPoint geoPoint);

    LatLng a(PointF pointF);

    LatLng a(ge geVar);

    void a(List<? extends Boundable> list, List<GeoPoint> list2, Rect rect, a aVar);

    LatLng[] a();

    ge b(LatLng latLng);

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    double metersPerPixel(double d16);

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    double metersPerPixel(double d16, double d17);
}
