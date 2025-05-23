package com.tencent.state.decode;

import android.graphics.Bitmap;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\u000bH\u00c6\u0003J\t\u0010\"\u001a\u00020\rH\u00c6\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010'\u001a\u00020\u0006H\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/decode/RegionConfig;", "", "assetFileName", "", "url", "mapWidth", "", "mapHeight", "tileWidth", "tileHeight", "initRect", "Landroid/graphics/Rect;", "bitmapConfig", "Landroid/graphics/Bitmap$Config;", "(Ljava/lang/String;Ljava/lang/String;IIIILandroid/graphics/Rect;Landroid/graphics/Bitmap$Config;)V", "getAssetFileName", "()Ljava/lang/String;", "getBitmapConfig", "()Landroid/graphics/Bitmap$Config;", "getInitRect", "()Landroid/graphics/Rect;", "getMapHeight", "()I", "getMapWidth", "getTileHeight", "getTileWidth", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final /* data */ class RegionConfig {
    private final String assetFileName;
    private final Bitmap.Config bitmapConfig;
    private final Rect initRect;
    private final int mapHeight;
    private final int mapWidth;
    private final int tileHeight;
    private final int tileWidth;
    private final String url;

    public RegionConfig(String assetFileName, String url, int i3, int i16, int i17, int i18, Rect initRect, Bitmap.Config bitmapConfig) {
        Intrinsics.checkNotNullParameter(assetFileName, "assetFileName");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(initRect, "initRect");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        this.assetFileName = assetFileName;
        this.url = url;
        this.mapWidth = i3;
        this.mapHeight = i16;
        this.tileWidth = i17;
        this.tileHeight = i18;
        this.initRect = initRect;
        this.bitmapConfig = bitmapConfig;
    }

    /* renamed from: component1, reason: from getter */
    public final String getAssetFileName() {
        return this.assetFileName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMapWidth() {
        return this.mapWidth;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMapHeight() {
        return this.mapHeight;
    }

    /* renamed from: component5, reason: from getter */
    public final int getTileWidth() {
        return this.tileWidth;
    }

    /* renamed from: component6, reason: from getter */
    public final int getTileHeight() {
        return this.tileHeight;
    }

    /* renamed from: component7, reason: from getter */
    public final Rect getInitRect() {
        return this.initRect;
    }

    /* renamed from: component8, reason: from getter */
    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public final RegionConfig copy(String assetFileName, String url, int mapWidth, int mapHeight, int tileWidth, int tileHeight, Rect initRect, Bitmap.Config bitmapConfig) {
        Intrinsics.checkNotNullParameter(assetFileName, "assetFileName");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(initRect, "initRect");
        Intrinsics.checkNotNullParameter(bitmapConfig, "bitmapConfig");
        return new RegionConfig(assetFileName, url, mapWidth, mapHeight, tileWidth, tileHeight, initRect, bitmapConfig);
    }

    public final String getAssetFileName() {
        return this.assetFileName;
    }

    public final Bitmap.Config getBitmapConfig() {
        return this.bitmapConfig;
    }

    public final Rect getInitRect() {
        return this.initRect;
    }

    public final int getMapHeight() {
        return this.mapHeight;
    }

    public final int getMapWidth() {
        return this.mapWidth;
    }

    public final int getTileHeight() {
        return this.tileHeight;
    }

    public final int getTileWidth() {
        return this.tileWidth;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.assetFileName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        int hashCode2 = (((((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.mapWidth) * 31) + this.mapHeight) * 31) + this.tileWidth) * 31) + this.tileHeight) * 31;
        Rect rect = this.initRect;
        int hashCode3 = (hashCode2 + (rect != null ? rect.hashCode() : 0)) * 31;
        Bitmap.Config config = this.bitmapConfig;
        return hashCode3 + (config != null ? config.hashCode() : 0);
    }

    public String toString() {
        return "RegionConfig(assetFileName=" + this.assetFileName + ", url=" + this.url + ", mapWidth=" + this.mapWidth + ", mapHeight=" + this.mapHeight + ", tileWidth=" + this.tileWidth + ", tileHeight=" + this.tileHeight + ", initRect=" + this.initRect + ", bitmapConfig=" + this.bitmapConfig + ")";
    }

    public /* synthetic */ RegionConfig(String str, String str2, int i3, int i16, int i17, int i18, Rect rect, Bitmap.Config config, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i19 & 2) != 0 ? "" : str2, i3, i16, i17, i18, rect, (i19 & 128) != 0 ? Bitmap.Config.ARGB_8888 : config);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegionConfig)) {
            return false;
        }
        RegionConfig regionConfig = (RegionConfig) other;
        return Intrinsics.areEqual(this.assetFileName, regionConfig.assetFileName) && Intrinsics.areEqual(this.url, regionConfig.url) && this.mapWidth == regionConfig.mapWidth && this.mapHeight == regionConfig.mapHeight && this.tileWidth == regionConfig.tileWidth && this.tileHeight == regionConfig.tileHeight && Intrinsics.areEqual(this.initRect, regionConfig.initRect) && Intrinsics.areEqual(this.bitmapConfig, regionConfig.bitmapConfig);
    }
}
