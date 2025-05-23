package com.tencent.av.video.effect.core.qqavimage;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageThresholdSketchFilter extends QQAVImageFilterGroup {
    public QQAVImageThresholdSketchFilter() {
        addFilter(new QQAVImageGrayscaleFilter());
        addFilter(new QQAVImageSobelThresholdNewFilter());
    }

    public void setEdgeStrength(float f16) {
        ((QQAVImageSobelThresholdNewFilter) getFilters().get(1)).setEdgeStrength(f16);
    }

    public void setLineSize(float f16) {
        ((QQAVImage3x3TextureSamplingFilter) getFilters().get(1)).setLineSize(f16);
    }

    public void setThreshold(float f16) {
        ((QQAVImageSobelThresholdNewFilter) getFilters().get(1)).setThreshold(f16);
    }
}
