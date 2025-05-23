package com.tencent.map.sdk.utilities.visualization;

import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider;

/* loaded from: classes9.dex */
public abstract class BaseOverlayProvider implements VectorOverlayProvider {
    private static final float DEFAULT_MAX_OPACITY = 1.0f;
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final float DEFAULT_MIN_OPACITY = 0.0f;
    private static final int DEFAULT_MIN_ZOOM = 3;
    private static final float DEFAULT_OPACITY = 1.0f;
    private static final int DEFAULT_ZINDEX = 0;
    protected float mOpacity = 1.0f;
    protected boolean mVisibility = true;
    protected int mMinZoom = 4;
    protected int mMaxZoom = 22;
    protected int mDisplayLevel = 1;
    protected int mZIndex = 0;
    protected boolean mClickEnabled = false;
    protected VectorOverlay.OnVectorOverlayLoadListener onVectorOverlayLoadlistener = null;
    protected VectorOverlay.OnVectorOverlayClickListener onVectorOverlayClickListener = null;

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public void enableClick(boolean z16) {
        this.mClickEnabled = z16;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getDisplayLevel() {
        return this.mDisplayLevel;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMaxZoom() {
        return this.mMaxZoom;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getMinZoom() {
        return this.mMinZoom;
    }

    public VectorOverlay.OnVectorOverlayClickListener getOnVectorOverlayClickListener() {
        return this.onVectorOverlayClickListener;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public float getOpacity() {
        return this.mOpacity;
    }

    public VectorOverlay.OnVectorOverlayLoadListener getVectorOverlayLoadedListener() {
        return this.onVectorOverlayLoadlistener;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public int getZIndex() {
        return this.mZIndex;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public boolean isClickEnabled() {
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public boolean isVisibility() {
        return this.mVisibility;
    }

    public BaseOverlayProvider setVectorOverlayClickListener(VectorOverlay.OnVectorOverlayClickListener onVectorOverlayClickListener) {
        this.onVectorOverlayClickListener = onVectorOverlayClickListener;
        return this;
    }

    public String toString() {
        return "BaseOverlayProvider{mOpacity=" + this.mOpacity + ", mVisibility=" + this.mVisibility + ", mMinZoom=" + this.mMinZoom + ", mMaxZoom=" + this.mMaxZoom + ", mDisplayLevel=" + this.mDisplayLevel + ", mZIndex=" + this.mZIndex + '}';
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider displayLevel(int i3) {
        if (i3 == 1 || i3 == 2) {
            this.mDisplayLevel = i3;
        }
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider maxZoom(int i3) {
        if (i3 <= 22) {
            this.mMaxZoom = i3;
        } else {
            this.mMaxZoom = 22;
        }
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider minZoom(int i3) {
        if (i3 >= 3) {
            this.mMinZoom = i3;
        } else {
            this.mMinZoom = 3;
        }
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider opacity(float f16) {
        if (f16 > 1.0f) {
            this.mOpacity = 1.0f;
        } else if (f16 < 0.0f) {
            this.mOpacity = 0.0f;
        } else {
            this.mOpacity = f16;
        }
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider setVectorOverlayLoadedListener(VectorOverlay.OnVectorOverlayLoadListener onVectorOverlayLoadListener) {
        this.onVectorOverlayLoadlistener = onVectorOverlayLoadListener;
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider visibility(boolean z16) {
        this.mVisibility = z16;
        return this;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.VectorOverlayProvider
    public BaseOverlayProvider zIndex(int i3) {
        this.mZIndex = i3;
        return this;
    }
}
