package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VectorHeatAggregationUnit {
    private LatLng mCenter;
    private double mIntensity;
    private WeightedLatLng[] mNodes;

    VectorHeatAggregationUnit() {
    }

    public LatLng getCenter() {
        return this.mCenter;
    }

    public double getIntensity() {
        return this.mIntensity;
    }

    public WeightedLatLng[] getNodes() {
        return this.mNodes;
    }

    VectorHeatAggregationUnit(LatLng latLng, double d16, WeightedLatLng[] weightedLatLngArr) {
        this.mCenter = latLng;
        this.mIntensity = d16;
        this.mNodes = weightedLatLngArr;
    }
}
