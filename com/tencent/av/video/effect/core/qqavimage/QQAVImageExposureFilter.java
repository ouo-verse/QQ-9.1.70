package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;
import cooperation.qzone.report.QZonePushReporter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageExposureFilter extends QQAVImageFilter {
    private float mExposure;
    private int mExposureLocation;

    public QQAVImageExposureFilter() {
        this(1.0f);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInit() {
        super.onInit();
        this.mExposureLocation = GLES20.glGetUniformLocation(getProgram(), QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE);
    }

    @Override // com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter
    public void onInitialized() {
        super.onInitialized();
        setExposure(this.mExposure);
    }

    public void setExposure(float f16) {
        this.mExposure = f16;
        setFloat(this.mExposureLocation, f16);
    }

    public QQAVImageExposureFilter(float f16) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(17));
        this.mExposure = f16;
    }
}
