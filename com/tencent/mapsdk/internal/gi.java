package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public class gi {

    /* renamed from: d, reason: collision with root package name */
    final double f148494d;

    public gi(double d16) {
        this.f148494d = d16;
    }

    public final LatLng b(fw fwVar) {
        double d16 = fwVar.f148383a;
        double d17 = this.f148494d;
        double d18 = ((d16 / d17) - 0.5d) * 360.0d;
        double degrees = 90.0d - Math.toDegrees(Math.atan(Math.exp(((-(0.5d - (fwVar.f148384b / d17))) * 2.0d) * 3.141592653589793d)) * 2.0d);
        if (Double.isNaN(degrees)) {
            degrees = 0.0d;
        }
        if (Double.isNaN(d18)) {
            d18 = 0.0d;
        }
        return new LatLng(degrees, d18);
    }

    public final fw d(LatLng latLng) {
        double d16 = (latLng.longitude / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        double log = ((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d;
        double d17 = this.f148494d;
        return new fw(d16 * d17, log * d17);
    }
}
