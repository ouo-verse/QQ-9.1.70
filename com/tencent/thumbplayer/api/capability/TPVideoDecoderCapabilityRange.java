package com.tencent.thumbplayer.api.capability;

/* loaded from: classes26.dex */
public class TPVideoDecoderCapabilityRange {
    private int mUpperWidth = Integer.MAX_VALUE;
    private int mUpperHeight = Integer.MAX_VALUE;
    private float mUpperFrameRate = Float.MAX_VALUE;
    private int mLowerWidth = 0;
    private int mLowerHeight = 0;
    private float mLowerFrameRate = 0.0f;

    public float getLowerFrameRate() {
        return this.mLowerFrameRate;
    }

    public int getLowerHeight() {
        return this.mLowerHeight;
    }

    public int getLowerWidth() {
        return this.mLowerWidth;
    }

    public float getUpperFrameRate() {
        return this.mUpperFrameRate;
    }

    public int getUpperHeight() {
        return this.mUpperHeight;
    }

    public int getUpperWidth() {
        return this.mUpperWidth;
    }

    public void setLower(int i3, int i16, int i17) {
        this.mLowerWidth = i3;
        this.mLowerHeight = i16;
        this.mLowerFrameRate = i17;
    }

    public void setUpper(int i3, int i16, int i17) {
        this.mUpperWidth = i3;
        this.mUpperHeight = i16;
        this.mUpperFrameRate = i17;
    }
}
