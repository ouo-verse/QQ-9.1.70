package com.tencent.qqlive.tvkplayer.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKVideoFrameBuffer {
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

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    public @interface TVKPixelFormat {
        public static final int TVK_PIXEL_FORMAT_MEDIACODEC = 167;
        public static final int TVK_PIXEL_FORMAT_RGB565 = 37;
        public static final int TVK_PIXEL_FORMAT_RGBA = 26;
        public static final int TVK_PIXEL_FORMAT_UNKNOWN = -1;
        public static final int TVK_PIXEL_FORMAT_YUV420P = 0;
        public static final int TVK_PIXEL_FORMAT_YUVJ420P = 12;
    }

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
}
