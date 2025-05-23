package com.tencent.thumbplayer.api.common;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* loaded from: classes26.dex */
public class TPVideoFrameBuffer {
    public static final int EVENT_FLAG_EOS = 1;
    public static final int EVENT_FLAG_FLUSH = 2;
    private byte[][] mData;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private int mEventFlag;
    private int mFormat;
    private int mHeight;
    private int[] mLineSize;
    private long mPtsMs;
    private int mRotation;
    private int mTrackID = -1;
    private int mWidth;

    public byte[][] getData() {
        return this.mData;
    }

    public int getDisplayHeight() {
        return this.mDisplayHeight;
    }

    public int getDisplayWidth() {
        return this.mDisplayWidth;
    }

    public int getEventFlag() {
        return this.mEventFlag;
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

    public long getPtsMs() {
        return this.mPtsMs;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public int getTrackID() {
        return this.mTrackID;
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

    public void setEventFlag(int i3) {
        this.mEventFlag = i3;
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

    public void setPtsMs(long j3) {
        this.mPtsMs = j3;
    }

    public void setRotation(int i3) {
        this.mRotation = i3;
    }

    public void setTrackID(int i3) {
        this.mTrackID = i3;
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
            ByteBuffer wrap = ByteBuffer.wrap(bArr[0]);
            Bitmap createBitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, config);
            createBitmap.copyPixelsFromBuffer(wrap);
            if (this.mRotation != 0) {
                Matrix matrix = new Matrix();
                matrix.postRotate(this.mRotation);
                Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, this.mWidth, this.mHeight, matrix, true);
                createBitmap.recycle();
                return createBitmap2;
            }
            return createBitmap;
        }
        throw new UnsupportedOperationException("Invalid data");
    }
}
