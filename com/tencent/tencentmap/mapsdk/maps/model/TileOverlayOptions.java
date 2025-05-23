package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class TileOverlayOptions {
    private volatile String mDiskCacheDir;
    private int mMaxMemoryCacheSize;
    private TileProvider mTileProvider;
    private volatile String mVersionInfo;
    private int mZIndex = 1;
    private boolean mBetterQuality = true;
    private boolean mReuseTile = false;

    public final TileOverlayOptions betterQuality(boolean z16) {
        this.mBetterQuality = z16;
        return this;
    }

    public final TileOverlayOptions diskCacheDir(String str) {
        this.mDiskCacheDir = str;
        return this;
    }

    public final String getDiskCacheDir() {
        return this.mDiskCacheDir;
    }

    public final int getMaxMemoryCacheSize(TencentMapContext tencentMapContext) {
        int i3 = this.mMaxMemoryCacheSize;
        if (i3 == 0) {
            return tencentMapContext.getScreenPixels() * 4;
        }
        return i3;
    }

    public final TileProvider getTileProvider() {
        return this.mTileProvider;
    }

    public final String getVersionInfo() {
        return this.mVersionInfo;
    }

    public final int getZIndex() {
        return this.mZIndex;
    }

    public final boolean isBetterQuality() {
        return this.mBetterQuality;
    }

    public final boolean isReuseTile() {
        return this.mReuseTile;
    }

    public final TileOverlayOptions maxMemoryCacheSize(int i3) {
        this.mMaxMemoryCacheSize = i3;
        return this;
    }

    public final TileOverlayOptions reuseTile(boolean z16) {
        this.mReuseTile = z16;
        return this;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.mTileProvider = tileProvider;
        return this;
    }

    public final String toString() {
        return "{mDiskCacheDir='" + this.mDiskCacheDir + "', mVersionInfo='" + this.mVersionInfo + "', mZIndex=" + this.mZIndex + ", mBetterQuality=" + this.mBetterQuality + ", mMaxMemoryCacheSize=" + this.mMaxMemoryCacheSize + '}';
    }

    public final TileOverlayOptions versionInfo(String str) {
        this.mVersionInfo = str;
        return this;
    }

    public final TileOverlayOptions zIndex(int i3) {
        this.mZIndex = i3;
        return this;
    }
}
