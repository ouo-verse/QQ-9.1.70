package com.tencent.map.sdk.utilities.visualization.trails;

import android.graphics.Color;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.TrailLatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public final class TrailOverlayProvider extends BaseOverlayProvider {
    private static final int DEFAULT_COLOR_MAP_SIZE = 200;
    private static final int[] DEFAULT_GRADIENT_COLORS = {Color.argb(255, 0, 128, 255), Color.argb(0, 0, 128, 255)};
    private static final float[] DEFAULT_GRADIENT_START_POINTS = {0.0f, 1.0f};
    private int mType = 0;
    private List<TrailLatLng> dataList = new ArrayList();
    private final float DEFAULT_WIDTH = 6.0f;
    private float mWidth = 6.0f;
    private final int DEFAULT_HIGHLIGHT_DURATION = 1000;
    private final int DEFAULT_ANIMATE_START_TIME = 0;
    private final int DEFAULT_ANIMATE_END_TIME = 2000;
    private int mHighLightDuration = 1000;
    private int mAnimationStartTime = 0;
    private int mAnimatationEndTime = 2000;
    private final float DEFAULT_PLAY_RATIO = 1.0f;
    private float mPlayRatio = 1.0f;
    private int[] mColors = DEFAULT_GRADIENT_COLORS;
    private float[] mColorPoints = DEFAULT_GRADIENT_START_POINTS;
    protected int mColorMapSize = 200;

    /* loaded from: classes9.dex */
    public enum TrailOverlayType {
        Trail
    }

    public final TrailOverlayProvider data(List<TrailLatLng> list) {
        if (list != null) {
            this.dataList = list;
        }
        return this;
    }

    public final int getAnimateEndTime() {
        return this.mAnimatationEndTime;
    }

    public final int getAnimateStartTime() {
        return this.mAnimationStartTime;
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

    public final List<TrailLatLng> getData() {
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

    final TrailOverlayType getOverlayType() {
        return TrailOverlayType.values()[this.mType];
    }

    public final float getPlayRatio() {
        return this.mPlayRatio;
    }

    public final int getType() {
        return getOverlayType().ordinal();
    }

    public final float getWidth() {
        return this.mWidth;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final int getZIndex() {
        return super.getZIndex();
    }

    public final TrailOverlayProvider gradient(int[] iArr) {
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

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final boolean isVisibility() {
        return super.isVisibility();
    }

    public final TrailOverlayProvider setAnimateStartTime(int i3, int i16) {
        if (i3 < i16 && i3 >= 0) {
            this.mAnimationStartTime = i3;
            this.mAnimatationEndTime = i16;
        }
        return this;
    }

    public final TrailOverlayProvider setHighlightDuration(int i3) {
        if (i3 > 0) {
            this.mHighLightDuration = i3;
        }
        return this;
    }

    public final TrailOverlayProvider setPlayRatio(float f16) {
        if (f16 > 0.0f) {
            this.mPlayRatio = f16;
        }
        return this;
    }

    public final TrailOverlayProvider type(TrailOverlayType trailOverlayType) {
        this.mType = trailOverlayType.ordinal();
        return this;
    }

    public final TrailOverlayProvider width(float f16) {
        if (f16 > 0.0f) {
            this.mWidth = f16;
        }
        return this;
    }

    public final TrailOverlayProvider zoomRange(int i3, int i16) {
        if (i3 <= i16) {
            super.minZoom(i3);
            super.maxZoom(i16);
        }
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final TrailOverlayProvider displayLevel(int i3) {
        super.displayLevel(i3);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final TrailOverlayProvider opacity(float f16) {
        super.opacity(f16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final TrailOverlayProvider visibility(boolean z16) {
        super.visibility(z16);
        return this;
    }

    @Override // com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider, com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public final TrailOverlayProvider zIndex(int i3) {
        super.zIndex(i3);
        return this;
    }
}
