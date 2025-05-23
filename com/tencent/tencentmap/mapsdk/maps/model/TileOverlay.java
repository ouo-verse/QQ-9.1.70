package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface TileOverlay extends IOverlay {
    void clearTileCache();

    @Override // com.tencent.tencentmap.mapsdk.maps.model.IOverlay
    String getId();

    void reload();

    void remove();

    void setDiskCacheDir(String str);

    void setZindex(int i3);
}
