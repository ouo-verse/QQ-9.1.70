package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class VectorHeatOverlayOptions extends BaseOverlayProvider {
    private int[] mColors;
    private float mGap;
    private WeightedLatLng[] mNodes;
    private double[] mStartPoints;
    private int mType = 0;
    private float mSize = 2000.0f;
    private float mOpacity = 1.0f;
    private boolean mVisibility = true;
    private int mMinZoom = 3;
    private int mMaxZoom = 22;
    private double mMinIntensity = 0.0d;
    private double mMaxIntensity = 2000.0d;
    private double mMaxHeight = 2000.0d;
    private double mMinHeight = 0.0d;
    private boolean mDraw3D = false;
    private boolean mRangeFlag = false;
    private int mAnimateDuration = 5000;
    private boolean mAnimate = false;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum VectorHeatOverlayType {
        HoneyComb,
        Square
    }

    public final VectorHeatOverlayOptions animate(boolean z16) {
        this.mAnimate = z16;
        return this;
    }

    public final VectorHeatOverlayOptions colors(int[] iArr) {
        this.mColors = iArr;
        return this;
    }

    public final VectorHeatOverlayOptions draw3D(boolean z16) {
        this.mDraw3D = z16;
        return this;
    }

    public final VectorHeatOverlayOptions gap(float f16) {
        this.mGap = f16;
        return this;
    }

    public final int getAnimateTime() {
        return this.mAnimateDuration;
    }

    public final int[] getColors() {
        return this.mColors;
    }

    public final float getGap() {
        return this.mGap;
    }

    public final double getMaxHeight() {
        return this.mMaxHeight;
    }

    public final double getMaxIntensity() {
        return this.mMaxIntensity;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getMaxZoom() {
        return this.mMaxZoom;
    }

    public final double getMinHeight() {
        return this.mMinHeight;
    }

    public final double getMinIntensity() {
        return this.mMinIntensity;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getMinZoom() {
        return this.mMinZoom;
    }

    public final WeightedLatLng[] getNodes() {
        return this.mNodes;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final float getOpacity() {
        return this.mOpacity;
    }

    public final boolean getRangeFlag() {
        return this.mRangeFlag;
    }

    public final float getSize() {
        return this.mSize;
    }

    public final double[] getStartPoints() {
        return this.mStartPoints;
    }

    public final VectorHeatOverlayType getType() {
        return VectorHeatOverlayType.values()[this.mType];
    }

    public final VectorHeatOverlayOptions heightRange(double d16, double d17) {
        if (d16 <= d17 && d16 >= 0.0d) {
            this.mMaxHeight = d17;
            this.mMinHeight = d16;
        } else {
            this.mMinHeight = 0.0d;
            this.mMaxHeight = 2000.0d;
        }
        return this;
    }

    public final boolean isAnimate() {
        return this.mAnimate;
    }

    public final boolean isDraw3D() {
        return this.mDraw3D;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final boolean isVisibility() {
        return this.mVisibility;
    }

    public final VectorHeatOverlayOptions nodes(WeightedLatLng[] weightedLatLngArr) {
        this.mNodes = weightedLatLngArr;
        return this;
    }

    public final VectorHeatOverlayOptions setAnimateTime(int i3) {
        this.mAnimateDuration = i3;
        return this;
    }

    public final VectorHeatOverlayOptions showRange(double d16, double d17) {
        if (d16 <= d17 && d16 >= 0.0d) {
            this.mMaxIntensity = d17;
            this.mMinIntensity = d16;
            this.mRangeFlag = true;
        } else {
            this.mMinIntensity = 0.0d;
            this.mMaxIntensity = 2000.0d;
            this.mRangeFlag = false;
        }
        return this;
    }

    public final VectorHeatOverlayOptions size(float f16) {
        this.mSize = f16;
        return this;
    }

    public final VectorHeatOverlayOptions startPoints(double[] dArr) {
        this.mStartPoints = dArr;
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider
    public final String toString() {
        return "VectorHeatOverlayOptions{mOpacity=" + this.mOpacity + ", mVisibility=" + this.mVisibility + ", mMinZoom=" + this.mMinZoom + ", mMaxZoom=" + this.mMaxZoom + ", mDisplayLevel=" + this.mDisplayLevel + ", mZIndex=" + this.mZIndex + ", mClickEnabled=" + this.mClickEnabled + ", onVectorOverlayLoadlistener=" + this.onVectorOverlayLoadlistener + ", onVectorOverlayClickListener=" + this.onVectorOverlayClickListener + ", mType=" + this.mType + ", mNodes=" + Arrays.toString(this.mNodes) + ", mSize=" + this.mSize + ", mGap=" + this.mGap + ", mOpacity=" + this.mOpacity + ", mVisibility=" + this.mVisibility + ", mMinZoom=" + this.mMinZoom + ", mMaxZoom=" + this.mMaxZoom + ", mColors=" + Arrays.toString(this.mColors) + ", mStartPoints=" + Arrays.toString(this.mStartPoints) + ", mMinIntensity=" + this.mMinIntensity + ", mMaxIntensity=" + this.mMaxIntensity + ", mMaxHeight=" + this.mMaxHeight + ", mMinHeight=" + this.mMinHeight + ", mDraw3D=" + this.mDraw3D + ", mRangeFlag=" + this.mRangeFlag + ", mAnimateDuration=" + this.mAnimateDuration + ", mAnimate=" + this.mAnimate + '}';
    }

    public final VectorHeatOverlayOptions type(VectorHeatOverlayType vectorHeatOverlayType) {
        this.mType = vectorHeatOverlayType.ordinal();
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final VectorHeatOverlayOptions maxZoom(int i3) {
        this.mMaxZoom = i3;
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final VectorHeatOverlayOptions minZoom(int i3) {
        this.mMinZoom = i3;
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final VectorHeatOverlayOptions opacity(float f16) {
        this.mOpacity = f16;
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final VectorHeatOverlayOptions visibility(boolean z16) {
        this.mVisibility = z16;
        return this;
    }
}
