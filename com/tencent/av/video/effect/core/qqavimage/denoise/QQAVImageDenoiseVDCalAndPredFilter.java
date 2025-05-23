package com.tencent.av.video.effect.core.qqavimage.denoise;

import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFourInputFilter;

/* loaded from: classes3.dex */
public class QQAVImageDenoiseVDCalAndPredFilter extends QQAVImageFourInputFilter {
    private float mUpdateRateGlobal;
    private int mUpdateRateGlobalLocation;
    private float mUpdateRateLocal;
    private int mUpdateRateLocalLocation;

    public QQAVImageDenoiseVDCalAndPredFilter() {
        this(0.02f, 15.0f);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFourInputFilter, com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mUpdateRateGlobalLocation = GLES20.glGetUniformLocation(getProgram(), "updaterateglobal");
        this.mUpdateRateLocalLocation = GLES20.glGetUniformLocation(getProgram(), "updateratelocal");
    }

    public void setUpdateRateGlobal(float f16) {
        this.mUpdateRateGlobal = f16;
        setFloat(this.mUpdateRateGlobalLocation, f16);
    }

    public void setUpdateRateLocal(float f16) {
        float f17 = f16 / 100.0f;
        this.mUpdateRateLocal = f17;
        setFloat(this.mUpdateRateLocalLocation, f17);
    }

    public QQAVImageDenoiseVDCalAndPredFilter(float f16, float f17) {
        super(String.valueOf(27));
        setUpdateRateGlobal(f16);
        setUpdateRateLocal(f17);
    }
}
