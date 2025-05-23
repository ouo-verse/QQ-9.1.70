package com.tencent.thumbplayer.api.capability;

/* loaded from: classes26.dex */
public class TPVideoCapabilityQueryParams {
    private int mCodecType;
    private int mDecoderType;
    private float mFrameRate;
    private int mHeight;
    private int mProfile;
    private int mWidth;

    /* loaded from: classes26.dex */
    public static class Builder {
        private int mCodecType;
        private float mFrameRate;
        private int mHeight;
        private int mWidth;
        private int mProfile = -99;
        private int mDecoderType = -1;

        public Builder(int i3, int i16, int i17, float f16) {
            this.mCodecType = i3;
            this.mWidth = i16;
            this.mHeight = i17;
            this.mFrameRate = f16;
        }

        public TPVideoCapabilityQueryParams build() {
            return new TPVideoCapabilityQueryParams(this);
        }

        public Builder setDecoderType(int i3) {
            this.mDecoderType = i3;
            return this;
        }

        public Builder setProfile(int i3) {
            this.mProfile = i3;
            return this;
        }
    }

    public TPVideoCapabilityQueryParams(Builder builder) {
        this.mCodecType = -1;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mFrameRate = 0.0f;
        this.mDecoderType = -1;
        this.mProfile = -99;
        this.mCodecType = builder.mCodecType;
        this.mWidth = builder.mWidth;
        this.mHeight = builder.mHeight;
        this.mFrameRate = builder.mFrameRate;
        this.mProfile = builder.mProfile;
        this.mDecoderType = builder.mDecoderType;
    }

    public int getCodecType() {
        return this.mCodecType;
    }

    public int getDecoderType() {
        return this.mDecoderType;
    }

    public float getFrameRate() {
        return this.mFrameRate;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getProfile() {
        return this.mProfile;
    }

    public int getWidth() {
        return this.mWidth;
    }
}
