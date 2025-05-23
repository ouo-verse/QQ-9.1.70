package com.tencent.map.lib.models;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.tencent.map.sdk.utilities.visualization.datamodels.ScatterLatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Keep
/* loaded from: classes9.dex */
public class ScatterPlotInfo extends OverlayListenerInfo {
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final int DEFAULT_MIN_ZOOM = 3;
    protected double[] circleStartPoints;
    protected int[] colors;
    protected float[] colorsPoints;
    protected int mBitmapHeight;
    protected int mBitmapWidth;
    protected float maxIntensity;
    protected int maxZoom;
    protected float minIntensity;
    protected int minZoom;
    protected float opacity;
    protected int radius;
    protected boolean visible;
    protected int activeIndex = 0;
    protected int mType = 0;
    protected int level = 1;
    protected int zIndex = 0;
    protected boolean draw3D = false;
    protected int colorMapSize = 200;
    protected boolean mAnimate = false;
    protected boolean intensityFlag = false;
    protected int mMinRadius = 0;
    protected int mMaxRadius = 30;
    protected int mStrokeColor = -1;
    protected int mStrokeWidth = 4;
    protected ScatterLatLng[] notes = new ScatterLatLng[0];
    protected int[] nodeIndexes = new int[0];
    protected Bitmap[] mBitmaps = new Bitmap[0];

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

    public void setColors(int[] iArr) {
        this.colors = iArr;
    }

    public void setColorsPoints(float[] fArr) {
        this.colorsPoints = fArr;
    }

    public void setDataList(List<Collection<ScatterLatLng>> list) {
        if (list == null) {
            this.notes = new ScatterLatLng[0];
            this.nodeIndexes = new int[0];
            return;
        }
        this.nodeIndexes = new int[list.size()];
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            Collection<ScatterLatLng> collection = list.get(i3);
            this.nodeIndexes[i3] = collection.size();
            arrayList.addAll(collection);
        }
        this.notes = (ScatterLatLng[]) arrayList.toArray(new ScatterLatLng[0]);
    }

    public void setDraw3D(boolean z16) {
        this.draw3D = z16;
    }

    public void setLevel(int i3) {
        this.level = i3;
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
        this.opacity = f16;
    }

    public void setRadius(int i3) {
        this.radius = i3;
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

    public void setColorsPoints(double[] dArr) {
        this.circleStartPoints = dArr;
    }
}
