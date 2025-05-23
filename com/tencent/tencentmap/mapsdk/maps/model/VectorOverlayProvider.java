package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.tencentmap.mapsdk.maps.model.VectorOverlay;

/* loaded from: classes26.dex */
public interface VectorOverlayProvider {
    VectorOverlayProvider displayLevel(int i3);

    void enableClick(boolean z16);

    int getDisplayLevel();

    int getMaxZoom();

    int getMinZoom();

    float getOpacity();

    int getZIndex();

    boolean isClickEnabled();

    boolean isVisibility();

    VectorOverlayProvider maxZoom(int i3);

    VectorOverlayProvider minZoom(int i3);

    VectorOverlayProvider opacity(float f16);

    VectorOverlayProvider setVectorOverlayLoadedListener(VectorOverlay.OnVectorOverlayLoadListener onVectorOverlayLoadListener);

    VectorOverlayProvider visibility(boolean z16);

    VectorOverlayProvider zIndex(int i3);
}
