package com.tencent.mobileqq.shortvideo.mtveffects;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DistortionFilter extends BaseFragmentFilter {
    public static final String BOTTOM_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!\u7578\u53d8\u56fe\u7247\nuniform vec2 inputImageTextureSize;\nuniform vec4 distortionParam; //!\u7578\u53d8\u53c2\u6570\uff1ax < 0 is pincushion distortion,  >=0 is barrel distortion \u4f8b\u5982\uff1a(1.2,0.5, 1.0) z: scale factor\nuniform vec2 distortionCenter; //!\u7578\u53d8\u4e2d\u5fc3\n\n \n\n\nvoid main() \n{\n    vec2 dstPos;  \n    float fDistance = sqrt((vTextureCoord.x - distortionCenter.x) * (vTextureCoord.x - distortionCenter.x) + (vTextureCoord.y - distortionCenter.y) * (vTextureCoord.y - distortionCenter.y));\n    float fDistanceNew = fDistance * (1.0 + distortionParam.x * (fDistance * fDistance) + distortionParam.y * (fDistance * fDistance * fDistance * fDistance));\n    float fTheta = atan(vTextureCoord.x - distortionCenter.x, vTextureCoord.y - distortionCenter.y);\n    float fDistortionX = sin(fTheta) * fDistanceNew * distortionParam.z;\n    float fDistortionY = cos(fTheta) * fDistanceNew * distortionParam.z;\n    dstPos.x = fDistortionX + distortionCenter.x;\n\tdstPos.y = fDistortionY + distortionCenter.y;\n       \n    gl_FragColor = texture2D(inputImageTexture, dstPos);\n\t\n}\n";
    private static final String TAG = "DistortionFilter";
    private int mUniDistortionCenter;
    private int mUniDistortionParam;
    private int mUniInputTexture;
    private int mUniInputTextureSize;

    public DistortionFilter() {
        super(BOTTOM_FRAGMENT_SHADER);
        this.mUniInputTexture = -1;
        this.mUniInputTextureSize = -1;
        this.mUniDistortionParam = -1;
        this.mUniDistortionCenter = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.shortvideo.mtveffects.BaseFragmentFilter, com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onInitialized() {
        super.onInitialized();
        int program = getProgram();
        if (program <= 0) {
            return;
        }
        this.mUniInputTexture = GLES20.glGetUniformLocation(program, "inputImageTexture");
        this.mUniInputTextureSize = GLES20.glGetUniformLocation(program, "inputImageTextureSize");
        this.mUniDistortionParam = GLES20.glGetUniformLocation(program, "distortionParam");
        this.mUniDistortionCenter = GLES20.glGetUniformLocation(program, "distortionCenter");
    }

    public boolean process(int i3, float f16, float f17, float f18, float f19, float f26, float[] fArr, float[] fArr2) {
        if (i3 < 0 || !processBegin(fArr, fArr2)) {
            return false;
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glUniform1i(this.mUniInputTexture, 0);
        GLES20.glUniform2f(this.mUniInputTextureSize, this.mOutputWidth, this.mOutputHeight);
        GLES20.glUniform4f(this.mUniDistortionParam, f16, f17, f18, 0.0f);
        GLES20.glUniform2f(this.mUniDistortionCenter, f19, f26);
        processEnd(true, 33984);
        return true;
    }
}
