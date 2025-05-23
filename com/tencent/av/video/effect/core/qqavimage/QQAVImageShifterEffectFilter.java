package com.tencent.av.video.effect.core.qqavimage;

import android.content.Context;
import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageShifterEffectFilter extends QQAVImageColorFilter {
    private int mHeightLocation;
    private int mWidthLocation;

    public QQAVImageShifterEffectFilter(Context context) {
        super(String.valueOf(35), 1);
        super.setQQAVEffectType(12);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageColorFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mWidthLocation = GLES20.glGetUniformLocation(getProgram(), "imageWidth");
        this.mHeightLocation = GLES20.glGetUniformLocation(getProgram(), "imageHeight");
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onOutputSizeChanged(int i3, int i16) {
        super.onOutputSizeChanged(i3, i16);
        setFloat(this.mWidthLocation, i3);
        setFloat(this.mHeightLocation, i16);
    }

    public QQAVImageShifterEffectFilter() {
        super(String.valueOf(35), 1);
        super.setQQAVEffectType(12);
    }

    public QQAVImageShifterEffectFilter(Context context, int i3) {
        super(String.valueOf(35), i3);
        super.setQQAVEffectType(12);
    }

    public QQAVImageShifterEffectFilter(int i3) {
        super(String.valueOf(35), i3);
        super.setQQAVEffectType(12);
    }
}
