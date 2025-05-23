package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class AggregationOverlayInfo extends OverlayListenerInfo {
    private static final float DEFAULT_MAX_OPACITY = 1.0f;
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final float DEFAULT_MIN_OPACITY = 0.0f;
    private static final int DEFAULT_MIN_ZOOM = 3;
    protected LatLng mGeoReferencePoint;
    protected int mType = 0;
    protected float mSize = 2000.0f;
    protected float mGap = 0.0f;
    protected float mOpacity = 1.0f;
    protected boolean mVisibility = true;
    protected int mMinZoom = 3;
    protected int mMaxZoom = 22;
    protected int mDisplayLevel = 1;
    protected int mZIndex = 0;
    protected double mMinHeight = 0.0d;
    protected double mMaxHeight = 1000.0d;
    protected double mMinIntensity = 0.0d;
    protected double mMaxIntensity = 2000.0d;
    protected boolean mRangeFlag = false;
    protected int[] mColors = {1174031124, -1711650028, -637908204};
    protected double[] mStartPoints = {0.0d, 0.6d, 0.8d};
    protected boolean mDraw3D = false;
    protected boolean mAnimate = false;
    protected int mAnimateDuration = 5000;
    protected WeightedLatLng[] mNodes = new WeightedLatLng[0];

    public boolean isAnimate() {
        return this.mAnimate;
    }

    public boolean isVisible() {
        return this.mVisibility;
    }

    public void setAnimate(boolean z16) {
        this.mAnimate = z16;
    }

    public void setAnimateTime(int i3) {
        this.mAnimateDuration = i3;
    }

    public void setColors(int[] iArr) {
        this.mColors = iArr;
    }

    public void setDisplayLevel(int i3) {
        if (i3 == 1 || i3 == 2) {
            this.mDisplayLevel = i3;
        }
    }

    public void setDraw3D(boolean z16) {
        this.mDraw3D = z16;
    }

    public void setGap(float f16) {
        this.mGap = f16;
    }

    public void setHeightRange(double d16, double d17) {
        if (d16 <= d17 && d16 >= 0.0d) {
            this.mMaxHeight = d17;
            this.mMinHeight = d16;
        } else {
            this.mMinHeight = 0.0d;
            this.mMaxHeight = 1000.0d;
        }
    }

    public void setMaxZoom(int i3) {
        if (i3 <= 22) {
            this.mMaxZoom = i3;
        } else {
            this.mMaxZoom = 22;
        }
    }

    public void setMinZoom(int i3) {
        if (i3 >= 3) {
            this.mMinZoom = i3;
        } else {
            this.mMinZoom = 3;
        }
    }

    public void setNodes(WeightedLatLng[] weightedLatLngArr) {
        this.mNodes = weightedLatLngArr;
    }

    public void setOpacity(float f16) {
        if (f16 > 1.0f) {
            this.mOpacity = 1.0f;
        } else if (f16 < 0.0f) {
            this.mOpacity = 0.0f;
        } else {
            this.mOpacity = f16;
        }
    }

    public void setShowRange(double d16, double d17) {
        if (d16 <= d17 && d16 >= 0.0d) {
            this.mMinIntensity = d16;
            this.mMaxIntensity = d17;
            this.mRangeFlag = true;
        } else {
            this.mMinIntensity = 0.0d;
            this.mMaxIntensity = 2000.0d;
            this.mRangeFlag = false;
        }
    }

    public void setSize(float f16) {
        this.mSize = f16;
    }

    public void setStartPoints(double[] dArr) {
        this.mStartPoints = dArr;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public void setVisibility(boolean z16) {
        this.mVisibility = z16;
    }

    public void setZIndex(int i3) {
        this.mZIndex = i3;
    }

    public void setZoomLevelRange(int i3, int i16) {
        if (i3 <= i16) {
            setMinZoom(i3);
            setMaxZoom(i16);
        }
    }
}
