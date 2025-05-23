package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class HeatmapInfo extends OverlayListenerInfo {
    private static final float DEFAULT_MAX_OPACITY = 1.0f;
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final float DEFAULT_MIN_OPACITY = 0.0f;
    private static final int DEFAULT_MIN_ZOOM = 3;
    protected int colorMapSize;
    protected float[] colorPoints;
    protected int[] colors;
    protected int maxZoom;
    protected int minZoom;
    protected float opacity;
    protected int radius;
    protected boolean visible;
    protected int activeIndex = 0;
    protected int level = 1;
    protected int zIndex = 0;
    protected int sample = 4;
    protected float maxHeight = 1000.0f;
    protected boolean draw3D = false;
    protected boolean intensityFlag = false;
    protected float maxIntensity = 0.0f;
    protected float minIntensity = 0.0f;
    protected boolean mAnimate = false;
    protected int mAnimateDuration = 5000;
    protected WeightedLatLng[] notes = new WeightedLatLng[0];
    protected int[] nodeIndexes = new int[0];

    public boolean isAnimate() {
        return this.mAnimate;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setActiveIndex(int i3) {
        this.activeIndex = i3;
    }

    public void setAnimate(boolean z16) {
        this.mAnimate = z16;
    }

    public void setAnimateTime(int i3) {
        this.mAnimateDuration = i3;
    }

    public void setColorPoints(float[] fArr) {
        this.colorPoints = fArr;
    }

    public void setColors(int[] iArr) {
        this.colors = iArr;
    }

    public void setDataList(List<Collection<WeightedLatLng>> list) {
        if (list == null) {
            this.notes = new WeightedLatLng[0];
            this.nodeIndexes = new int[0];
            return;
        }
        this.nodeIndexes = new int[list.size()];
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            Collection<WeightedLatLng> collection = list.get(i3);
            this.nodeIndexes[i3] = collection.size();
            arrayList.addAll(collection);
        }
        this.notes = (WeightedLatLng[]) arrayList.toArray(new WeightedLatLng[0]);
    }

    public void setDraw3D(boolean z16) {
        this.draw3D = z16;
    }

    public void setLevel(int i3) {
        if (i3 == 1 || i3 == 2) {
            this.level = i3;
        }
    }

    public void setMaxHeight(float f16) {
        this.maxHeight = f16;
    }

    public void setMaxZoom(int i3) {
        if (i3 <= 22) {
            this.maxZoom = i3;
        } else {
            this.maxZoom = 22;
        }
    }

    public void setMinZoom(int i3) {
        if (i3 >= 3) {
            this.minZoom = i3;
        } else {
            this.minZoom = 3;
        }
    }

    public void setOpacity(float f16) {
        if (f16 > 1.0f) {
            this.opacity = 1.0f;
        } else if (f16 < 0.0f) {
            this.opacity = 0.0f;
        } else {
            this.opacity = f16;
        }
    }

    public void setRadius(int i3) {
        this.radius = i3;
    }

    public void setSample(int i3) {
        this.sample = i3;
    }

    public void setVisible(boolean z16) {
        this.visible = z16;
    }

    public void setZoomLevelRange(int i3, int i16) {
        if (i3 <= i16) {
            setMinZoom(i3);
            setMaxZoom(i16);
        }
    }

    public void setzIndex(int i3) {
        this.zIndex = i3;
    }
}
