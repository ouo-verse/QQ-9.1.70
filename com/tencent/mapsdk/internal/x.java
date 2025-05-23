package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.fa;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class x implements fa {
    @Override // com.tencent.mapsdk.internal.fa
    public final double a(Point point, Point point2) {
        return 0.0d;
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final ge b(LatLng latLng) {
        return new ge(0.0d, 0.0d);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final LatLng fromScreenLocation(Point point) {
        return new LatLng();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final VisibleRegion getVisibleRegion() {
        return new VisibleRegion(new LatLng(0.0d, 0.0d), new LatLng(0.0d, 0.0d), new LatLng(0.0d, 0.0d), new LatLng(0.0d, 0.0d), new LatLngBounds(new LatLng(0.0d, 0.0d), new LatLng(0.0d, 0.0d)));
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final float[] glModelMatrix(PointF pointF, float f16) {
        return new float[16];
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final float glPixelRatio() {
        return 0.0f;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final float[] glProjectionMatrix() {
        return new float[16];
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final PointF glVertexForCoordinate(LatLng latLng) {
        return new PointF();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final float[] glViewMatrix() {
        return new float[16];
    }

    @Override // com.tencent.mapsdk.internal.fa, com.tencent.tencentmap.mapsdk.maps.Projection
    public final double metersPerPixel(double d16) {
        return 0.0d;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.Projection
    public final Point toScreenLocation(LatLng latLng) {
        return new Point();
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final float a(LatLng latLng, LatLng latLng2, int i3, int i16, int i17, int i18, LatLng latLng3) {
        return 0.0f;
    }

    @Override // com.tencent.mapsdk.internal.fa, com.tencent.tencentmap.mapsdk.maps.Projection
    public final double metersPerPixel(double d16, double d17) {
        return 0.0d;
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final void a(List<? extends Boundable> list, List<GeoPoint> list2, Rect rect, fa.a aVar) {
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final LatLng[] a() {
        return new LatLng[4];
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final GeoPoint a(fw fwVar) {
        return new GeoPoint();
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final fw a(GeoPoint geoPoint) {
        return new fw();
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final PointF a(LatLng latLng) {
        return new PointF();
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final LatLng a(PointF pointF) {
        return new LatLng();
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final fw a(Context context, LatLng latLng) {
        return new fw();
    }

    @Override // com.tencent.mapsdk.internal.fa
    public final LatLng a(ge geVar) {
        return new LatLng();
    }
}
