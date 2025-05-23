package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.in;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class is extends in {

    /* renamed from: i, reason: collision with root package name */
    private GeoPoint f148819i = null;

    /* renamed from: j, reason: collision with root package name */
    private GeoPoint f148820j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f148821k;

    public is(GeoPoint geoPoint) {
        this.f148820j = null;
        this.f148821k = false;
        if (geoPoint != null) {
            this.f148820j = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
            this.f148821k = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mapsdk.internal.in
    public final void a(float f16, Interpolator interpolator) {
        GeoPoint geoPoint = this.f148820j;
        if (geoPoint == null || this.f148819i == null) {
            return;
        }
        int latitudeE6 = geoPoint.getLatitudeE6() - this.f148819i.getLatitudeE6();
        int longitudeE6 = this.f148820j.getLongitudeE6() - this.f148819i.getLongitudeE6();
        float interpolation = interpolator.getInterpolation(f16);
        int latitudeE62 = this.f148819i.getLatitudeE6() + ((int) (latitudeE6 * interpolation));
        int longitudeE62 = this.f148819i.getLongitudeE6() + ((int) (longitudeE6 * interpolation));
        if (1.0f - f16 < 1.0E-4d) {
            latitudeE62 = this.f148820j.getLatitudeE6();
            longitudeE62 = this.f148820j.getLongitudeE6();
        }
        in.b bVar = this.f148806h;
        if (bVar != null) {
            bVar.a(latitudeE62, longitudeE62);
        }
    }

    @Override // com.tencent.mapsdk.internal.in
    public final boolean a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (!super.a((GeoPoint) null, (GeoPoint) null)) {
            return false;
        }
        if (geoPoint != null) {
            this.f148819i = new GeoPoint(geoPoint.getLatitudeE6(), geoPoint.getLongitudeE6());
        }
        if (this.f148821k || geoPoint2 == null) {
            return true;
        }
        this.f148820j = new GeoPoint(geoPoint2.getLatitudeE6(), geoPoint2.getLongitudeE6());
        return true;
    }
}
