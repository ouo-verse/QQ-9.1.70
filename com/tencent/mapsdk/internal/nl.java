package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.AggregationOverlayInfo;
import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider;
import com.tencent.tencentmap.mapsdk.maps.model.VectorHeatOverlayOptions;

/* compiled from: P */
/* loaded from: classes9.dex */
public class nl extends AggregationOverlayInfo implements ni {

    /* renamed from: a, reason: collision with root package name */
    AggregationOverlayProvider f149467a;

    public nl(VectorHeatOverlayOptions vectorHeatOverlayOptions) {
        this.mNodes = vectorHeatOverlayOptions.getNodes();
        this.mType = vectorHeatOverlayOptions.getType().ordinal();
        this.mColors = vectorHeatOverlayOptions.getColors();
        this.mSize = vectorHeatOverlayOptions.getSize();
        this.mGap = vectorHeatOverlayOptions.getGap();
        this.mOpacity = vectorHeatOverlayOptions.getOpacity();
        this.mVisibility = vectorHeatOverlayOptions.isVisibility();
        this.mMinZoom = vectorHeatOverlayOptions.getMinZoom();
        this.mMaxZoom = vectorHeatOverlayOptions.getMaxZoom();
        this.mColors = vectorHeatOverlayOptions.getColors();
        this.mStartPoints = vectorHeatOverlayOptions.getStartPoints();
        this.mDraw3D = vectorHeatOverlayOptions.isDraw3D();
        this.mMaxHeight = vectorHeatOverlayOptions.getMaxHeight();
        this.mMinHeight = vectorHeatOverlayOptions.getMinHeight();
        this.mMaxIntensity = vectorHeatOverlayOptions.getMaxIntensity();
        this.mMinIntensity = vectorHeatOverlayOptions.getMinIntensity();
        this.mRangeFlag = vectorHeatOverlayOptions.getRangeFlag();
        this.mAnimate = vectorHeatOverlayOptions.isAnimate();
        this.mAnimateDuration = vectorHeatOverlayOptions.getAnimateTime();
        this.mDisplayLevel = vectorHeatOverlayOptions.getDisplayLevel();
        this.mZIndex = vectorHeatOverlayOptions.getZIndex();
    }

    private AggregationOverlayProvider a() {
        return this.f149467a;
    }

    public nl(AggregationOverlayProvider aggregationOverlayProvider) {
        this.f149467a = aggregationOverlayProvider;
        this.mNodes = aggregationOverlayProvider.getNodes();
        this.mType = aggregationOverlayProvider.getType();
        this.mColors = aggregationOverlayProvider.getColors();
        this.mSize = aggregationOverlayProvider.getSize();
        this.mGap = aggregationOverlayProvider.getGap();
        this.mOpacity = aggregationOverlayProvider.getOpacity();
        this.mVisibility = aggregationOverlayProvider.isVisibility();
        this.mMinZoom = aggregationOverlayProvider.getMinZoom();
        this.mMaxZoom = aggregationOverlayProvider.getMaxZoom();
        this.mColors = aggregationOverlayProvider.getColors();
        this.mStartPoints = aggregationOverlayProvider.getStartPoints();
        this.mDraw3D = aggregationOverlayProvider.isEnable3D();
        this.mMaxHeight = aggregationOverlayProvider.getMaxHeight();
        this.mMinHeight = aggregationOverlayProvider.getMinHeight();
        this.mMaxIntensity = aggregationOverlayProvider.getMaxIntensity();
        this.mMinIntensity = aggregationOverlayProvider.getMinIntensity();
        this.mRangeFlag = aggregationOverlayProvider.getRangeFlag();
        this.mAnimate = aggregationOverlayProvider.isAnimate();
        this.mAnimateDuration = aggregationOverlayProvider.getAnimateDuration();
        this.mDisplayLevel = aggregationOverlayProvider.getDisplayLevel();
        this.mZIndex = aggregationOverlayProvider.getZIndex();
        this.mGeoReferencePoint = aggregationOverlayProvider.getGeoReferencePoint();
        this.outterVectorOverlayLoadListener = aggregationOverlayProvider.getVectorOverlayLoadedListener();
    }
}
