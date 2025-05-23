package com.tencent.map.lib.models;

import android.graphics.Color;
import android.support.annotation.Keep;
import com.tencent.map.sdk.utilities.visualization.datamodels.FromToLatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class ArcLineOverlayInfo extends OverlayListenerInfo {
    private static final float DEFAULT_MAX_OPACITY = 1.0f;
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final float DEFAULT_MIN_OPACITY = 0.0f;
    private static final int DEFAULT_MIN_ZOOM = 3;
    protected int mType = 0;
    protected int mZIndex = 0;
    protected int activeIndex = 0;
    protected float mOpacity = 1.0f;
    protected boolean mVisibility = true;
    protected int mMinZoom = 3;
    protected int mMaxZoom = 22;
    protected int mDisplayLevel = 1;
    protected float mWidth = 4.0f;
    protected int[] mColors = {Color.argb(255, 0, 255, 170), Color.argb(255, 0, 255, 170), Color.argb(255, 0, 255, 170)};
    protected float[] mColorPoints = {0.0f, 0.5f, 1.0f};
    protected int mColorMapSize = 200;
    protected boolean mDraw3D = false;
    protected boolean mAnimate = false;
    protected int mHighLightDuration = 5000;
    protected int mAnimateDuration = 5000;
    protected int mAnimateColor = -16776961;
    protected FromToLatLng[] notes = new FromToLatLng[0];
    protected int[] nodeIndexes = new int[0];

    public int getAnimateColor() {
        return this.mAnimateColor;
    }

    public boolean getIsAnimate() {
        return this.mAnimate;
    }

    public boolean isVisible() {
        return this.mVisibility;
    }

    public void setActiveDataIndex(int i3) {
        this.activeIndex = i3;
    }

    public void setAnimate(boolean z16) {
        this.mAnimate = z16;
    }

    public void setAnimateColor(int i3) {
        this.mAnimateColor = i3;
    }

    public void setAnimateDuration(int i3) {
        this.mAnimateDuration = i3;
    }

    public void setDataList(List<Collection<FromToLatLng>> list) {
        if (list != null && list.size() != 0) {
            this.nodeIndexes = new int[list.size()];
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                Collection<FromToLatLng> collection = list.get(i3);
                this.nodeIndexes[i3] = collection.size();
                arrayList.addAll(collection);
            }
            this.notes = (FromToLatLng[]) arrayList.toArray(new FromToLatLng[0]);
            return;
        }
        this.notes = new FromToLatLng[0];
        this.nodeIndexes = new int[0];
    }

    public void setDisplayLevel(int i3) {
        if (i3 == 1 || i3 == 2) {
            this.mDisplayLevel = i3;
        }
    }

    public void setDraw3D(boolean z16) {
        this.mDraw3D = z16;
    }

    public void setHighLightDuration(int i3) {
        this.mHighLightDuration = i3;
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

    public void setNodes(FromToLatLng[] fromToLatLngArr) {
        this.notes = fromToLatLngArr;
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

    public void setType(int i3) {
        this.mType = i3;
    }

    public void setVisibility(boolean z16) {
        this.mVisibility = z16;
    }

    public void setWidth(float f16) {
        this.mWidth = f16;
    }

    public void setZoomLevelRange(int i3, int i16) {
        if (i3 <= i16) {
            setMinZoom(i3);
            setMaxZoom(i16);
        }
    }

    public void setzIndex(int i3) {
        this.mZIndex = i3;
    }
}
