package com.tencent.thumbplayer.api.snapshot;

import androidx.annotation.NonNull;

/* loaded from: classes26.dex */
public class TPSnapshotParams {
    private int mWidth = 0;
    private int mHeight = 0;
    private long mRequestedPositionMsToleranceBefore = 0;
    private long mRequestedPositionMsToleranceAfter = 0;
    private int mPixelFormat = 37;

    public int getHeight() {
        return this.mHeight;
    }

    public int getPixelFormat() {
        return this.mPixelFormat;
    }

    public long getRequestedPositionMsToleranceAfter() {
        return this.mRequestedPositionMsToleranceAfter;
    }

    public long getRequestedPositionMsToleranceBefore() {
        return this.mRequestedPositionMsToleranceBefore;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setHeight(int i3) {
        this.mHeight = i3;
    }

    public void setPixelFormat(int i3) {
        this.mPixelFormat = i3;
    }

    public void setRequestedPositionMsToleranceAfter(long j3) {
        this.mRequestedPositionMsToleranceAfter = j3;
    }

    public void setRequestedPositionMsToleranceBefore(long j3) {
        this.mRequestedPositionMsToleranceBefore = j3;
    }

    public void setWidth(int i3) {
        this.mWidth = i3;
    }

    @NonNull
    public String toString() {
        return "width=" + this.mWidth + ", height=" + this.mHeight + ", format=" + this.mPixelFormat + ", toleranceBefore=" + this.mRequestedPositionMsToleranceBefore + ", toleranceAfter=" + this.mRequestedPositionMsToleranceAfter;
    }
}
