package com.tencent.mobileqq.shortvideo.mtveffects;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ScaleFilter extends BaseFragmentFilter {
    public static final String SCALE_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!\u7d20\u6750\u56fe\u7247\nuniform vec2 inputImageTextureSize;//!\u7a97\u53e3\u5927\u5c0f\nuniform vec2 scaleCenter;//!\u653e\u5927\u7684\u4e2d\u5fc3\u70b9\nuniform float scaleRate; //!\u653e\u5927\u7387 > 1 \u653e\u5927 \uff0c < 1 \u7f29\u5c0f\n\n\n//!\u8f6c\u6362\u4e3a\u7eb9\u7406\u8303\u56f4  \nvec2 toTexturePosition(vec2 v2Pos, vec2 v2Size)  \n{  \n    return vec2(float(v2Pos.x / v2Size.x), float(v2Pos.y / v2Size.y));  \n} \n\nvec4 scaleTransition(sampler2D s2DMaterial, vec2 v2Size, vec2 v2TextureCoord, vec2 v2Center, float fRate)\n{\t\n\tif (fRate != 1.0)\n\t{\n\t\tvec2 v2Tmp = v2TextureCoord;\n\t\tv2Tmp.x = (v2TextureCoord.x - v2Center.x) / fRate + v2Center.x;\n\t\tv2Tmp.y = (v2TextureCoord.y - v2Center.y) / fRate + v2Center.y;\n\t\t\n\t\t//!\u53cc\u7ebf\u6027\u63d2\u503c\n\t\tv2Tmp = v2Tmp * v2Size;\n\t\tfloat _x = floor(v2Tmp.x);\n\t\tfloat _y = floor(v2Tmp.y);\n\t\tfloat u = v2Tmp.x - _x ;\n\t\tfloat v = v2Tmp.y - _y ;\n\t\t\n\t\tvec4 data_00 = texture2D(s2DMaterial, toTexturePosition(vec2(_x , _y), v2Size));\n\t\tvec4 data_01 = texture2D(s2DMaterial, toTexturePosition(vec2(_x, _y + 1.0), v2Size));\n\t\tvec4 data_10 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y), v2Size));\n\t\tvec4 data_11 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y + 1.0), v2Size));\n\t\treturn (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n\t}\n\telse\n\t{\n\t\treturn texture2D(s2DMaterial, v2TextureCoord);\n\t} \n}\n\nvoid main() \n{\n\tgl_FragColor = scaleTransition(inputImageTexture, inputImageTextureSize, vTextureCoord, scaleCenter, scaleRate);\n}\n";
    private static final String TAG = "ScaleFilter";
    private int mUniInputTexture;
    private int mUniInputTextureSize;
    private int mUniScaleCenter;
    private int mUniScaleRate;

    public ScaleFilter() {
        super(SCALE_FRAGMENT_SHADER);
        this.mUniInputTexture = -1;
        this.mUniInputTextureSize = -1;
        this.mUniScaleCenter = -1;
        this.mUniScaleRate = -1;
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onDestroy() {
        super.onDestroy();
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
        this.mUniScaleCenter = GLES20.glGetUniformLocation(program, "scaleCenter");
        this.mUniScaleRate = GLES20.glGetUniformLocation(program, "scaleRate");
    }

    public boolean process(int i3, float f16, float f17, float f18, float[] fArr, float[] fArr2) {
        if (i3 < 0 || f18 == 1.0f || !processBegin(fArr, fArr2)) {
            return false;
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glUniform1i(this.mUniInputTexture, 0);
        GLES20.glUniform2f(this.mUniInputTextureSize, this.mOutputWidth, this.mOutputHeight);
        GLES20.glUniform2f(this.mUniScaleCenter, f16, f17);
        GLES20.glUniform1f(this.mUniScaleRate, f18);
        processEnd(false, 33984);
        return true;
    }
}
