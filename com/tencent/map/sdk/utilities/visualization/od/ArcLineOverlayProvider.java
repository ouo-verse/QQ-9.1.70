package com.tencent.map.sdk.utilities.visualization.od;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.FromToLatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes9.dex */
public final class ArcLineOverlayProvider extends BaseOverlayProvider {
    private static final int DEFAULT_COLOR_MAP_SIZE = 200;
    private static final int[] DEFAULT_GRADIENT_COLORS = {Color.argb(255, 0, 128, 255), Color.argb(51, 0, 170, 255), Color.argb(255, 0, 128, 255)};
    private static final float[] DEFAULT_GRADIENT_START_POINTS = {0.0f, 0.5f, 1.0f};
    private List<FromToLatLng> dataList = new ArrayList();
    private float mWidth = 6.0f;
    private float mRadian = 45.0f;
    private boolean mDraw3D = false;
    private boolean mAnimate = true;
    private int mHighLightDuration = 200;
    private int mAnimationDuration = 2000;
    private int mAnimateColor = -10046465;
    private int[] mColors = DEFAULT_GRADIENT_COLORS;
    private float[] mColorPoints = DEFAULT_GRADIENT_START_POINTS;
    protected int mColorMapSize = 200;

    public final ArcLineOverlayProvider animateColor(int i3) {
        this.mAnimateColor = i3;
        return this;
    }

    public final ArcLineOverlayProvider data(List<FromToLatLng> list) {
        if (list != null) {
            this.dataList = list;
        }
        return this;
    }

    public final ArcLineOverlayProvider enable3D(boolean z16) {
        this.mDraw3D = z16;
        return this;
    }

    public final int getAnimateColor() {
        return this.mAnimateColor;
    }

    public final int getAnimateDuration() {
        return this.mAnimationDuration;
    }

    public final int getColorMapSize() {
        return this.mColorMapSize;
    }

    public final float[] getColorPoints() {
        return this.mColorPoints;
    }

    public final int[] getColors() {
        return this.mColors;
    }

    public final List<FromToLatLng> getData() {
        return this.dataList;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getDisplayLevel() {
        return super.getDisplayLevel();
    }

    public final int getHighLightDuration() {
        return this.mHighLightDuration;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getMaxZoom() {
        return super.getMaxZoom();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getMinZoom() {
        return super.getMinZoom();
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final float getOpacity() {
        return super.getOpacity();
    }

    public final float getRadian() {
        return this.mRadian;
    }

    public final float getWidth() {
        return this.mWidth;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getZIndex() {
        return super.getZIndex();
    }

    public final ArcLineOverlayProvider gradient(int[] iArr) {
        if (iArr != null) {
            if (iArr.length == 1) {
                int i3 = iArr[0];
                this.mColors = new int[]{iArr[0], i3, i3};
                this.mColorPoints = new float[]{0.0f, 0.5f, 1.0f};
            } else if (iArr.length == 2) {
                this.mColors = iArr;
                this.mColorPoints = new float[]{0.0f, 1.0f};
            } else if (iArr.length == 3) {
                this.mColors = iArr;
                this.mColorPoints = new float[]{0.0f, 0.5f, 1.0f};
            }
        }
        return this;
    }

    public final boolean isAnimate() {
        return this.mAnimate;
    }

    public final boolean isEnable3D() {
        return this.mDraw3D;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final boolean isVisibility() {
        return super.isVisibility();
    }

    public final ArcLineOverlayProvider radian(float f16) {
        if (f16 > 0.0f && f16 <= 90.0f) {
            this.mRadian = f16;
            Iterator<FromToLatLng> it = this.dataList.iterator();
            while (it.hasNext()) {
                it.next().setArc(this.mRadian);
            }
        }
        return this;
    }

    public final ArcLineOverlayProvider setAnimateDuration(int i3) {
        if (i3 == 0) {
            this.mAnimate = false;
            this.mAnimationDuration = 0;
        } else if (i3 > 0) {
            this.mAnimationDuration = i3;
            this.mAnimate = true;
        }
        return this;
    }

    public final ArcLineOverlayProvider setHighlightDuration(int i3) {
        if (i3 >= 0) {
            this.mHighLightDuration = i3;
        }
        return this;
    }

    public final ArcLineOverlayProvider width(float f16) {
        if (f16 > 0.0f) {
            this.mWidth = f16;
        }
        return this;
    }

    public final ArcLineOverlayProvider zoomRange(int i3, int i16) {
        if (i3 <= i16) {
            super.minZoom(i3);
            super.maxZoom(i16);
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final ArcLineOverlayProvider displayLevel(int i3) {
        super.displayLevel(i3);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final ArcLineOverlayProvider opacity(float f16) {
        super.opacity(f16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final ArcLineOverlayProvider visibility(boolean z16) {
        super.visibility(z16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final ArcLineOverlayProvider zIndex(int i3) {
        super.zIndex(i3);
        return this;
    }
}
