package com.epicgames.ue4;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RecordFrameBuffer {
    private int mHeight;
    private byte[] mPixels;
    private int mPortraitId;
    private int mWidth;

    public RecordFrameBuffer(byte[] bArr, int i3, int i16, int i17) {
        this.mPixels = bArr;
        this.mWidth = i3;
        this.mHeight = i16;
        this.mPortraitId = i17;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public byte[] getPixels() {
        return this.mPixels;
    }

    public int getPortraitId() {
        return this.mPortraitId;
    }

    public int getWidth() {
        return this.mWidth;
    }
}
