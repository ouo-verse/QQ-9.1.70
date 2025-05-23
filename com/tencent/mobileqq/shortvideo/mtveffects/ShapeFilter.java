package com.tencent.mobileqq.shortvideo.mtveffects;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShapeFilter extends BaseFragmentFilter {
    private static final String SHAPE_FRAGMENT_SHADER = "precision highp float;\n\nvarying highp vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;\nuniform sampler2D maskTexture;\n\nvoid main() {\n    if(all(equal(texture2D(maskTexture, vTextureCoord), vec4(0,0,0,0))))\n    {\n       gl_FragColor = vec4(0,0,0,0);\n    }\n    else{\n       gl_FragColor = texture2D(inputImageTexture, vTextureCoord);\n   }\n}\n";
    private static final String TAG = "ShapeFilter";
    private int mUniInputTexture;
    private int mUniMaskTexture;

    public ShapeFilter() {
        super(SHAPE_FRAGMENT_SHADER);
        this.mUniInputTexture = -1;
        this.mUniMaskTexture = -1;
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
        this.mUniMaskTexture = GLES20.glGetUniformLocation(program, "maskTexture");
    }

    public boolean process(int i3, int i16, float[] fArr, float[] fArr2) {
        if (i3 < 0 || !processBegin(fArr2, fArr)) {
            return false;
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glUniform1i(this.mUniInputTexture, 0);
        if (i16 >= 0) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(this.mTextureType, i16);
            GLES20.glUniform1i(this.mUniMaskTexture, 1);
        }
        if (i16 >= 0) {
            processEnd(true, 33984, 33985);
        } else {
            processEnd(true, 33984);
        }
        return true;
    }
}
