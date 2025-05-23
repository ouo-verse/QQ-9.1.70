package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.MarkerInfo;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public class oe extends MarkerInfo implements ni {
    public oe(LatLng latLng, String str) {
        super(latLng.getLatitude(), latLng.getLongitude(), str);
    }

    public oe(double d16, double d17, String str) {
        super(d16, d17, str);
    }
}
