package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.exception.NetErrorException;
import java.net.URL;

/* loaded from: classes26.dex */
public abstract class UrlTileProvider implements TileProvider {
    private static final boolean DEBUG = false;
    private static final String TAG = "UrlTileProvider";
    private final int mHeight;
    private final int mWidth;

    public UrlTileProvider() {
        this(256, 256);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TileProvider
    public final Tile getTile(int i3, int i16, int i17) {
        byte[] bArr;
        Tile tile;
        URL tileUrl = getTileUrl(i3, i16, i17);
        Tile tile2 = TileProvider.NO_TILE;
        if (tileUrl == null) {
            return tile2;
        }
        NetResponse requestTileData = requestTileData(tileUrl.toString());
        if (requestTileData != null) {
            if (requestTileData.available()) {
                bArr = requestTileData.data;
            } else {
                if (requestTileData.exception instanceof NetErrorException) {
                    if (requestTileData.statusCode == 404) {
                        return tile2;
                    }
                    return new Tile(this.mWidth, this.mHeight, null);
                }
                if (requestTileData.statusCode == 404) {
                    return tile2;
                }
                return new Tile(this.mWidth, this.mHeight, null);
            }
        } else {
            bArr = null;
        }
        if (bArr != null && bArr.length != 0) {
            tile = new Tile(this.mWidth, this.mHeight, bArr);
        } else {
            tile = tile2;
        }
        if (tile.equals(tile2)) {
            return new Tile(this.mWidth, this.mHeight, null);
        }
        return tile;
    }

    public abstract URL getTileUrl(int i3, int i16, int i17);

    protected NetResponse requestTileData(String str) {
        try {
            return NetManager.getInstance().builder().url(str).doGet();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public UrlTileProvider(int i3, int i16) {
        this.mWidth = i3;
        this.mHeight = i16;
    }
}
