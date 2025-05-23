package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageMixBlendFilter extends QQAVImageTwoInputFilter {
    private float mMix;
    private int mMixLocation;

    public QQAVImageMixBlendFilter(String str) {
        this(str, 0.5f);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mMixLocation = GLES20.glGetUniformLocation(getProgram(), "mixturePercent");
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        setMix(this.mMix);
    }

    public void setMix(float f16) {
        this.mMix = f16;
        setFloat(this.mMixLocation, f16);
    }

    public QQAVImageMixBlendFilter(String str, float f16) {
        super(str);
        this.mMix = f16;
    }
}
