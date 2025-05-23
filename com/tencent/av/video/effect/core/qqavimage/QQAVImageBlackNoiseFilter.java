package com.tencent.av.video.effect.core.qqavimage;

import android.content.Context;
import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageBlackNoiseFilter extends QQAVImageColorFilter {
    private float fRandomIndex;
    private int mRandomIndex;

    public QQAVImageBlackNoiseFilter(Context context) {
        super(String.valueOf(36), 1);
        this.fRandomIndex = 0.0f;
        super.setQQAVEffectType(13);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onDraw2(int i3, int i16) {
        super.onDraw2(i3, i16);
        float f16 = this.fRandomIndex + 1.0f;
        this.fRandomIndex = f16;
        if (f16 > 10000.0f) {
            this.fRandomIndex = 0.0f;
        }
        setFloat(this.mRandomIndex, this.fRandomIndex);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageColorFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mRandomIndex = GLES20.glGetUniformLocation(getProgram(), "u_time");
    }

    public QQAVImageBlackNoiseFilter() {
        super(String.valueOf(36), 1);
        this.fRandomIndex = 0.0f;
        super.setQQAVEffectType(13);
    }

    public QQAVImageBlackNoiseFilter(Context context, int i3) {
        super(String.valueOf(36), i3);
        this.fRandomIndex = 0.0f;
        super.setQQAVEffectType(13);
    }

    public QQAVImageBlackNoiseFilter(int i3) {
        super(String.valueOf(36), i3);
        this.fRandomIndex = 0.0f;
        super.setQQAVEffectType(13);
    }
}
