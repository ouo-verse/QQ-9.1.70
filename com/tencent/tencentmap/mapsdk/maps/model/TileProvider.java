package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: classes26.dex */
public interface TileProvider {
    public static final Tile NO_TILE = Tile.EMPTY_TILE;

    Tile getTile(int i3, int i16, int i17);
}
