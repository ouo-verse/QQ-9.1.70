package com.tencent.map.sdk.utilities.visualization.aggregation;

import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatAggregationUnit;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;

/* compiled from: P */
/* loaded from: classes9.dex */
public interface AggregationOverlay extends VectorOverlay {
    VectorHeatAggregationUnit getUnit(LatLng latLng);
}
