package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.io.ByteArrayOutputStream;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Tile {
    public static Tile EMPTY_TILE = new Tile(-1, -1, getNoTileData());
    public final byte[] mData;
    public final int mHeight;
    public final int mWidth;

    public Tile(int i3, int i16, byte[] bArr) {
        this.mWidth = i3;
        this.mHeight = i16;
        this.mData = bArr;
    }

    private static byte[] getNoTileData() {
        Bitmap createBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawARGB(0, 255, 255, 255);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public final byte[] getData() {
        return this.mData;
    }
}
