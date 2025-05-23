package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class it extends ic {

    /* renamed from: g, reason: collision with root package name */
    private GeoPoint f148822g;

    /* renamed from: h, reason: collision with root package name */
    private GeoPoint f148823h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f148824i = false;

    it(GeoPoint geoPoint, GeoPoint geoPoint2) {
        this.f148822g = null;
        this.f148823h = null;
        if (geoPoint != null) {
            this.f148822g = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        }
        if (geoPoint2 != null) {
            this.f148823h = new GeoPoint(geoPoint2.getLatitudeE6(), geoPoint2.getLongitudeE6());
        }
    }

    @Override // com.tencent.mapsdk.internal.ic
    protected final void a(float f16) {
        GeoPoint geoPoint = this.f148823h;
        if (geoPoint != null && this.f148822g != null) {
            int latitudeE6 = geoPoint.getLatitudeE6() - this.f148822g.getLatitudeE6();
            int longitudeE6 = this.f148823h.getLongitudeE6() - this.f148822g.getLongitudeE6();
            int latitudeE62 = this.f148822g.getLatitudeE6() + ((int) (latitudeE6 * f16));
            int longitudeE62 = this.f148822g.getLongitudeE6() + ((int) (longitudeE6 * f16));
            if (this.f148770f != null) {
                new GeoPoint(latitudeE62, longitudeE62);
            }
        }
    }
}
