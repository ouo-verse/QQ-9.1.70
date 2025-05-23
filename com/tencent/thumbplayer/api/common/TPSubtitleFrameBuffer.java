package com.tencent.thumbplayer.api.common;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* loaded from: classes26.dex */
public class TPSubtitleFrameBuffer extends TPSubtitleData {
    private byte[][] mData;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private int mFormat;
    private int mHeight;
    private int[] mLineSize;
    private int mRotation;
    private int[] mTrackIDs;
    private int mWidth;

    public byte[][] getData() {
        return this.mData;
    }

    @Override // com.tencent.thumbplayer.api.common.TPSubtitleData
    public int getDataType() {
        return 1;
    }

    public int getDisplayHeight() {
        return this.mDisplayHeight;
    }

    public int getDisplayWidth() {
        return this.mDisplayWidth;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int[] getLineSize() {
        return this.mLineSize;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int[] getTrackIDs() {
        return this.mTrackIDs;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setData(byte[][] bArr) {
        this.mData = bArr;
    }

    public void setDisplayHeight(int i3) {
        this.mDisplayHeight = i3;
    }

    public void setDisplayWidth(int i3) {
        this.mDisplayWidth = i3;
    }

    public void setFormat(int i3) {
        this.mFormat = i3;
    }

    public void setHeight(int i3) {
        this.mHeight = i3;
    }

    public void setLineSize(int[] iArr) {
        this.mLineSize = iArr;
    }

    public void setRotation(int i3) {
        this.mRotation = i3;
    }

    public void setTrackIDs(int[] iArr) {
        this.mTrackIDs = iArr;
    }

    public void setWidth(int i3) {
        this.mWidth = i3;
    }

    @NonNull
    public Bitmap toBitmap() throws UnsupportedOperationException {
        Bitmap.Config config;
        byte[][] bArr = this.mData;
        if (bArr != null && bArr.length != 0 && this.mWidth > 0 && this.mHeight > 0) {
            int i3 = this.mFormat;
            if (i3 != 26) {
                if (i3 == 37) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    throw new UnsupportedOperationException("Cannot generate Bitmap with pixel format: " + this.mFormat);
                }
            } else {
                config = Bitmap.Config.ARGB_8888;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(this.mDisplayWidth, this.mDisplayHeight, config);
                createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(this.mData[0]));
                return createBitmap;
            } catch (Exception e16) {
                throw new UnsupportedOperationException(e16);
            }
        }
        throw new UnsupportedOperationException("Invalid data");
    }
}
