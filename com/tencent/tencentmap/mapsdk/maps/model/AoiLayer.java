package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface AoiLayer extends IOverlay {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface OnAoiLayerLoadListener {
        void onAoiLayerLoaded(boolean z16, AoiLayer aoiLayer);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    String getId();

    LatLng location();

    String name();

    boolean remove();

    void showSubPois(boolean z16);
}
