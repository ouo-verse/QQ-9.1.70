package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface VectorHeatOverlay {
    VectorHeatAggregationUnit getUnit(LatLng latLng);

    void remove();

    void setOpacity(float f16);

    void setVisibility(boolean z16);
}
