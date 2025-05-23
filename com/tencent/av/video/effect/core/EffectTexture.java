package com.tencent.av.video.effect.core;

/* compiled from: P */
/* loaded from: classes3.dex */
public class EffectTexture {
    public static final int NO_FBO = -1;
    public static final int NO_TEXTURE = -1;
    int mFbo;
    int mHeight;
    int mTextureId;
    int mWidth;

    public EffectTexture() {
        this.mTextureId = -1;
        this.mFbo = -1;
    }

    public int getFbo() {
        return this.mFbo;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getTextureId() {
        return this.mTextureId;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setFbo(int i3) {
        this.mFbo = i3;
    }

    public void setHeight(int i3) {
        this.mHeight = i3;
    }

    public void setTextureId(int i3) {
        this.mTextureId = i3;
    }

    public void setWidth(int i3) {
        this.mWidth = i3;
    }

    public EffectTexture(int i3, int i16, int i17, int i18) {
        this.mTextureId = i3;
        this.mFbo = i16;
        this.mWidth = i17;
        this.mHeight = i18;
    }
}
