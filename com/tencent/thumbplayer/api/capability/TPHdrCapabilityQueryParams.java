package com.tencent.thumbplayer.api.capability;

/* loaded from: classes26.dex */
public class TPHdrCapabilityQueryParams {
    private float mFrameRate;
    private int mHdrType;
    private int mHeight;
    private int mVideoCodecType;
    private int mWidth;

    /* loaded from: classes26.dex */
    public static class Builder {
        private int mHdrType = -1;
        private int mVideoCodecType = -1;
        private int mWidth = 0;
        private int mHeight = 0;
        private float mFrameRate = 0.0f;

        public TPHdrCapabilityQueryParams build() {
            return new TPHdrCapabilityQueryParams(this);
        }

        public Builder setFrameRate(float f16) {
            this.mFrameRate = f16;
            return this;
        }

        public Builder setHdrType(int i3) {
            this.mHdrType = i3;
            return this;
        }

        public Builder setHeight(int i3) {
            this.mHeight = i3;
            return this;
        }

        public Builder setVideoCodecType(int i3) {
            this.mVideoCodecType = i3;
            return this;
        }

        public Builder setWidth(int i3) {
            this.mWidth = i3;
            return this;
        }
    }

    public TPHdrCapabilityQueryParams(Builder builder) {
        this.mHdrType = -1;
        this.mVideoCodecType = -1;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mFrameRate = 0.0f;
        this.mHdrType = builder.mHdrType;
        this.mVideoCodecType = builder.mVideoCodecType;
        this.mWidth = builder.mWidth;
        this.mHeight = builder.mHeight;
        this.mFrameRate = builder.mFrameRate;
    }

    public float getFrameRate() {
        return this.mFrameRate;
    }

    public int getHdrType() {
        return this.mHdrType;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getVideoCodecType() {
        return this.mVideoCodecType;
    }

    public int getWidth() {
        return this.mWidth;
    }
}
