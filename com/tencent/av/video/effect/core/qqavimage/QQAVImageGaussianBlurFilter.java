package com.tencent.av.video.effect.core.qqavimage;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageGaussianBlurFilter extends QQAVImageTwoPassTextureSamplingFilter {
    protected float mBlurSize;

    public QQAVImageGaussianBlurFilter() {
        this(1.0f);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter
    public float getHorizontalTexelOffsetRatio() {
        return this.mBlurSize;
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoPassTextureSamplingFilter
    public float getVerticalTexelOffsetRatio() {
        return this.mBlurSize;
    }

    public void setBlurSize(float f16) {
        this.mBlurSize = f16;
        runOnDraw(new Runnable() { // from class: com.tencent.av.video.effect.core.qqavimage.QQAVImageGaussianBlurFilter.1
            @Override // java.lang.Runnable
            public void run() {
                QQAVImageGaussianBlurFilter.this.initTexelOffsets();
            }
        });
    }

    public QQAVImageGaussianBlurFilter(float f16) {
        super(String.valueOf(20), String.valueOf(21), String.valueOf(20), String.valueOf(21));
        this.mBlurSize = f16;
    }
}
