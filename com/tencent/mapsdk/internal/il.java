package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class il implements jl<GeoPoint> {
    @Override // com.tencent.mapsdk.internal.jl
    public final /* synthetic */ GeoPoint a(float f16, GeoPoint geoPoint, GeoPoint geoPoint2) {
        GeoPoint geoPoint3 = geoPoint;
        GeoPoint geoPoint4 = geoPoint2;
        return new GeoPoint(geoPoint3.getLatitudeE6() + ((int) ((geoPoint4.getLatitudeE6() - geoPoint3.getLatitudeE6()) * f16)), geoPoint3.getLongitudeE6() + ((int) (f16 * (geoPoint4.getLongitudeE6() - geoPoint3.getLongitudeE6()))));
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private static GeoPoint a2(float f16, GeoPoint geoPoint, GeoPoint geoPoint2) {
        return new GeoPoint(geoPoint.getLatitudeE6() + ((int) ((geoPoint2.getLatitudeE6() - geoPoint.getLatitudeE6()) * f16)), geoPoint.getLongitudeE6() + ((int) (f16 * (geoPoint2.getLongitudeE6() - geoPoint.getLongitudeE6()))));
    }
}
