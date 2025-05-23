package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.qqmini.sdk.report.MiniReportManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class HorizontialGlitchFilter extends BaseFragmentFilter {
    private static final String HORIZONTIALGLITCH_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!\u7d20\u6750\u56fe\u7247\nuniform sampler2D inputImageTexture2;//!glitch\u56fe\u7247\nuniform vec2 inputImageTextureSize;\nuniform vec2 inputImageTexture2Size;\nuniform vec4 srcRect; //!\u7d20\u6750\u56fe\u7247\u7684\u7eb9\u7406\u4f4d\u7f6e 0-1\u5750\u6807\u7cfb\nuniform vec4 dstRect; //!\u7d20\u6750\u56fe\u7247\u7684\u76ee\u6807\u4f4d\u7f6e 0-1 \u5750\u6807\u7cfb\nuniform vec4 dstColor; //!\u7d20\u6750\u56fe\u7247\u989c\u8272\u66ff\u6362 x \u662f\u5426\u542f\u7528 y z w \u989c\u8272\u503c alpha\u4e0d\u6539\u53d8\n\n\n//!\u83b7\u5f97\u7ecf\u8fc7glitch\u540e\u7684\u5750\u6807 0 - 1\u5750\u6807\u7cfb\nvec2 getGlitchCoord(sampler2D s2DGlitch, vec2 v2TextureCoord)\n{\n\tvec4 v4GlitchColor = texture2D(s2DGlitch, v2TextureCoord);\n\tvec2 v2Pos = vec2(-1.0, -1.0);\n\tfloat fDelta = (v4GlitchColor.r * 65536.0 + v4GlitchColor.g * 256.0 + v4GlitchColor.b) / 61680.94117647059;\n\t\n\tif(fDelta > 1.0)\n\t{\n\t    //!\u8fd9\u4e2a\u70b9\u6ca1\u6620\u5c04\u5230 \u4fdd\u6301\u539f\u5750\u6807\n\t}\n\telse\n\t{\n\t\tv2Pos.x = v2TextureCoord.x - fDelta;\n\t\tv2Pos.y = v2TextureCoord.y;\n\t}\n\t\n\treturn v2Pos;\n}\n\n//!\u70b9\u662f\u5426\u5728\u77e9\u5f62\u533a\u57df\u5185 v4Rect\u7b26\u5408Rect\u7684\u7ed3\u6784\u6807\u51c6(top \u6bd4 bottom \u8981\u5927)\nbool isPointInRect(vec2 v2Point, vec4 v4Rect)\n{\n\tif (v2Point.x >= v4Rect.x && v2Point.x <= v4Rect.z && v2Point.y <= v4Rect.y && v2Point.y >= v4Rect.w)\n\t{\n\t\treturn true;\n\t}\n\telse\n\t{\n\t    return false;\n\t}\n}\n//!\u8f6c\u6362\u4e3a\u7eb9\u7406\u8303\u56f4\nvec2 toTexturePosition(vec2 v2Pos, vec2 v2Size)\n{\n    return vec2(float(v2Pos.x / v2Size.x), float(v2Pos.y / v2Size.y));\n}\n//!\u83b7\u5f97\u989c\u8272\u503c \u989c\u8272\u662fmarterial\u7684v4src\u90e8\u5206 \u7ed8\u5236\u5230 v4dst\u540e v2DstCoord\u5904\u7684\u989c\u8272\u503c\nvec4 getMaterialColor(sampler2D s2DMaterial, vec4 v4Src, vec4 v4Dst, vec2 v2DstCoord, vec2 materialSize)\n{\n\tvec4 v4Color = vec4(0.0, 0.0, 0.0, 0.0);\n\tif (!isPointInRect(v2DstCoord, v4Dst))\n\t{\n\t\treturn v4Color;\n\t}\n\t\n\tvec2 v2Tmp = v2DstCoord - vec2(v4Dst.x, v4Dst.w);\n\tv2Tmp = v2Tmp / vec2(v4Dst.z - v4Dst.x, v4Dst.y - v4Dst.w);\n\tv2Tmp = v2Tmp * vec2(v4Src.z - v4Src.x, v4Src.y - v4Src.w);\n\tv2Tmp = v2Tmp + vec2(v4Src.x, v4Src.w);\n\t//return texture2D(s2DMaterial, v2Tmp);\n\t//!\u53cc\u7ebf\u6027\u63d2\u503c\n\tv2Tmp = v2Tmp * materialSize;\n\tfloat _x = floor(v2Tmp.x);\n\tfloat _y = floor(v2Tmp.y);\n\tfloat u = v2Tmp.x - _x ;\n\tfloat v = v2Tmp.y - _y ;\n\t\n\tvec4 data_00 = texture2D(s2DMaterial, toTexturePosition(vec2(_x , _y), materialSize));\n\tvec4 data_01 = texture2D(s2DMaterial, toTexturePosition(vec2(_x, _y + 1.0), materialSize));\n\tvec4 data_10 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y), materialSize));\n\tvec4 data_11 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y + 1.0), materialSize));\n\treturn (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;\n}\n\n\nvoid main()\n{\n\t//gl_FragColor = getMaterialColor(inputImageTexture, srcRect, dstRect, vTextureCoord, inputImageTextureSize);\n\t\n\tif (inputImageTexture2Size.x <= 0.0 || inputImageTexture2Size.y <= 0.0)\n\t{\n\t\t//!\u65e0\u7f6e\u4f4d\u6548\u679c\n\t\tgl_FragColor = getMaterialColor(inputImageTexture, srcRect, dstRect, vTextureCoord, inputImageTextureSize);\n\t\treturn;\n\t}\n\t\n\tvec2 v2NewCoord = getGlitchCoord(inputImageTexture2, vTextureCoord);\n\t\n\tvec4 v4DstColor = getMaterialColor(inputImageTexture, srcRect, dstRect, v2NewCoord, inputImageTextureSize);\n\tif (dstColor.x > 0.0 && v4DstColor.a > 0.1)\n\t{\n\t\t//!\u9700\u8981\u989c\u8272\u66ff\u6362\n\t\tgl_FragColor = vec4(dstColor.y, dstColor.z, dstColor.w, v4DstColor.a);\n\t}\n\telse\n\t{\n\t\tgl_FragColor = v4DstColor;\n\t}\n\t\n}\n\n";
    private static final String TAG = "HorizontialGlitchFilter";
    private int mUniDstColor;
    private int mUniDstRect;
    private int mUniInputTexture;
    private int mUniInputTexture2;
    private int mUniInputTexture2Size;
    private int mUniInputTextureSize;
    private int mUniSrcRect;

    public HorizontialGlitchFilter() {
        super(HORIZONTIALGLITCH_FRAGMENT_SHADER);
        this.mUniInputTexture = -1;
        this.mUniInputTexture2 = -1;
        this.mUniInputTextureSize = -1;
        this.mUniInputTexture2Size = -1;
        this.mUniDstRect = -1;
        this.mUniSrcRect = -1;
        this.mUniDstColor = -1;
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
        this.mUniInputTextureSize = GLES20.glGetUniformLocation(program, "inputImageTextureSize");
        this.mUniInputTexture2Size = GLES20.glGetUniformLocation(program, "inputImageTexture2Size");
        this.mUniDstRect = GLES20.glGetUniformLocation(program, "dstRect");
        this.mUniSrcRect = GLES20.glGetUniformLocation(program, "srcRect");
        this.mUniDstColor = GLES20.glGetUniformLocation(program, "dstColor");
    }

    public boolean process(int i3, int i16, RectF rectF, RectF rectF2, boolean z16, int i17, float[] fArr, float[] fArr2) {
        float f16;
        if (i16 < 0 || !processBegin(fArr, fArr2)) {
            return false;
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i16);
        GLES20.glUniform1i(this.mUniInputTexture, 0);
        GLES20.glUniform2f(this.mUniInputTextureSize, this.mOutputWidth, this.mOutputHeight);
        if (i3 >= 0) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(this.mTextureType, i3);
            GLES20.glUniform1i(this.mUniInputTexture2, 1);
            GLES20.glUniform2f(this.mUniInputTexture2Size, this.mOutputWidth, this.mOutputHeight);
        } else {
            GLES20.glUniform2f(this.mUniInputTexture2Size, -1.0f, -1.0f);
        }
        GLES20.glUniform4f(this.mUniDstRect, rectF2.left, rectF2.top, rectF2.right, rectF2.bottom);
        GLES20.glUniform4f(this.mUniSrcRect, rectF.left, rectF.top, rectF.right, rectF.bottom);
        int i18 = this.mUniDstColor;
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        GLES20.glUniform4f(i18, f16, LayerRenderBase.getRed(i17), LayerRenderBase.getGreen(i17), LayerRenderBase.getBlue(i17));
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, MiniReportManager.EventId.SDK_EMBEDDED_LIVE_PLAYER);
        if (i3 >= 0) {
            processEnd(false, 33984, 33985);
        } else {
            processEnd(false, 33984);
        }
        GLES20.glDisable(3042);
        return true;
    }
}
