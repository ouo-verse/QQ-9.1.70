package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ColoramaFilter extends BaseFragmentFilter {
    public static final String COLORAMA_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!\u89c6\u9891\u56fe\u7247\nuniform sampler2D inputImageTexture2;//!\u7d20\u6750\u56fe\u7247\nuniform vec4 paletteRect; //!\u8c03\u8272\u677f\u4f4d\u7f6e\nuniform vec4 coloramaParam;//!\u8272\u5149\u53c2\u6570 \uff1a \u8d77\u59cb\u4f4d\u7f6e\uff08\u8d77\u59cb\u76f8\u4f4d\uff09 \u957f\u5ea6 \u5faa\u73af\u6b21\u6570\n\nvec4 toGrayValue(vec4 v4Src)\n{\n\tfloat fGray = 0.299 * v4Src.r + 0.587 * v4Src.g + 0.114 * v4Src.b;\n\t\n\treturn vec4(fGray, fGray, fGray, v4Src.a);\n}\n\nvoid main() \n{\n\tvec4 v4Gray = toGrayValue(texture2D(inputImageTexture, vTextureCoord));\n\t//!\u8d77\u59cb\u4f4d\u7f6e \u53bb\u4e2d\u95f4\u503c\n\tvec2 v2Pos = vec2(paletteRect.x, (paletteRect.y + paletteRect.w) / 2.0);\n\tfloat fTmp = v4Gray.r * coloramaParam.y * coloramaParam.z;\n\t\n\tfTmp = mod(fTmp, coloramaParam.y);\n\tif (fTmp == 0.0)\n\t{\n\t\t//!\u8fb9\u754c\n\t\tif (v2Pos.x > 0.5 * coloramaParam.y)\n\t\t{\t\n\t\t\tv2Pos.x = coloramaParam.y;\n\t\t}else\n\t\t{\n\t\t\tv2Pos.x = 0.0;\n\t\t}\n\t}\n\telse\n\t{\n\t\tv2Pos.x = fTmp;\n\t}\n\n\tv2Pos.x = v2Pos.x + coloramaParam.x;\n\t\n\tvec4 v4PaletteColor = texture2D(inputImageTexture2, v2Pos);\n\tv4PaletteColor.a = v4Gray.a;\n\tgl_FragColor = v4PaletteColor;\n}\n\n";
    private static final String TAG = "ColoramaFilter";
    private int mUniInputTexture;
    private int mUniInputTexture2;
    private int mUniPaletteRect;
    private int mUniParam;

    public ColoramaFilter() {
        super(COLORAMA_FRAGMENT_SHADER);
        this.mUniInputTexture = -1;
        this.mUniInputTexture2 = -1;
        this.mUniPaletteRect = -1;
        this.mUniParam = -1;
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
        this.mUniInputTexture2 = GLES20.glGetUniformLocation(program, "inputImageTexture2");
        this.mUniPaletteRect = GLES20.glGetUniformLocation(program, "paletteRect");
        this.mUniParam = GLES20.glGetUniformLocation(program, "coloramaParam");
    }

    public boolean process(int i3, int i16, RectF rectF, float f16, float f17, float f18, float[] fArr, float[] fArr2) {
        if (i3 <= 0 || i16 <= 0 || rectF == null || !processBegin(fArr, fArr2)) {
            return false;
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glUniform1i(this.mUniInputTexture, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(this.mTextureType, i16);
        GLES20.glUniform1i(this.mUniInputTexture2, 1);
        GLES20.glUniform4f(this.mUniPaletteRect, rectF.left, rectF.top, rectF.right, rectF.bottom);
        GLES20.glUniform4f(this.mUniParam, f16, f17, f18, 0.0f);
        processEnd(false, 33984, 33985);
        return true;
    }
}
