package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import android.opengl.GLES20;
import com.tencent.mobileqq.shortvideo.mtveffects.FilmFilter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FilmNoiseFilter extends BaseFragmentFilter {
    public static final int MAX_NOISE_COUNT = 4;
    public static final String NOISE_FRAGMENT_SHADER = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;//!\u7d20\u6750\u56fe\u7247\nuniform vec2 noiseSize;//!\u566a\u70b9\u5927\u5c0f\nuniform vec4 noise1; //!x \u7ed8\u5236\u957f\u5ea6 y \u8d77\u59cb\u4f4d\u7f6e z \u76ee\u6807x w \u76ee\u6807y\nuniform vec4 noise2; //!x \u7ed8\u5236\u957f\u5ea6 y \u8d77\u59cb\u4f4d\u7f6e z \u76ee\u6807x w \u76ee\u6807y\nuniform vec4 noise3; //!x \u7ed8\u5236\u957f\u5ea6 y \u8d77\u59cb\u4f4d\u7f6e z \u76ee\u6807x w \u76ee\u6807y\nuniform vec4 noise4; //!x \u7ed8\u5236\u957f\u5ea6 y \u8d77\u59cb\u4f4d\u7f6e z \u76ee\u6807x w \u76ee\u6807y\n\n \n//!\u70b9\u662f\u5426\u5728\u77e9\u5f62\u533a\u57df\u5185 v4Rect\u7b26\u5408Rect\u7684\u7ed3\u6784\u6807\u51c6(top \u6bd4 bottom \u8981\u5927)\nbool isPointInRect(vec2 v2Point, vec4 v4Rect)\n{\n\tif (v2Point.x >= v4Rect.x && v2Point.x <= v4Rect.z && v2Point.y <= v4Rect.y && v2Point.y >= v4Rect.w)\n\t{\n\t\treturn true;\n\t}\n\telse\n\t{\n\t    return false;\n\t}\n}\n//!\u8f6c\u6362\u4e3a\u7eb9\u7406\u8303\u56f4  \nvec2 toTexturePosition(vec2 v2Pos, vec2 v2Size)  \n{  \n    return vec2(float(v2Pos.x / v2Size.x), float(v2Pos.y / v2Size.y));  \n} \n//!\u83b7\u5f97\u989c\u8272\u503c \u989c\u8272\u662fmarterial\u7684v4src\u90e8\u5206 \u7ed8\u5236\u5230 v4dst\u540e v2DstCoord\u5904\u7684\u989c\u8272\u503c \nvec4 getMaterialColor(sampler2D s2DMaterial, vec4 v4Src, vec4 v4Dst, vec2 v2DstCoord)\n{\t\n\tvec2 v2Tmp = v2DstCoord - vec2(v4Dst.x, v4Dst.w);\n\tv2Tmp = v2Tmp / vec2(v4Dst.z - v4Dst.x, v4Dst.y - v4Dst.w);\n\tv2Tmp = v2Tmp * vec2(v4Src.z - v4Src.x, v4Src.y - v4Src.w);\n\tv2Tmp = v2Tmp + vec2(v4Src.x, v4Src.w);\n\treturn texture2D(s2DMaterial, v2Tmp);\n\t//!\u53cc\u7ebf\u6027\u63d2\u503c\n\t/*v2Tmp = v2Tmp * materialSize;\n\tfloat _x = floor(v2Tmp.x);\n\tfloat _y = floor(v2Tmp.y);\n\tfloat u = v2Tmp.x - _x ;\n\tfloat v = v2Tmp.y - _y ;\n\t\n\tvec4 data_00 = texture2D(s2DMaterial, toTexturePosition(vec2(_x , _y), materialSize));\n\tvec4 data_01 = texture2D(s2DMaterial, toTexturePosition(vec2(_x, _y + 1.0), materialSize));\n\tvec4 data_10 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y), materialSize));\n\tvec4 data_11 = texture2D(s2DMaterial, toTexturePosition(vec2(_x + 1.0, _y + 1.0), materialSize));\n\treturn (1.0 - u) * (1.0 - v) * data_00 + (1.0 - u) * v * data_01 + u * (1.0 - v) * data_10 + u * v * data_11;*/\n}\n\nbool noiseColor(sampler2D s2DMaterial, out vec4 v4OutColor, vec2 v2TexCoord, float fSrcX, float fLength, float fDstX, float fDstY, float fWidth, float fHeight)\n{\n\tif (!isPointInRect(v2TexCoord, vec4(fDstX, fDstY, fDstX + fWidth, fDstY - fHeight)))\n\t{\n\t\treturn false;\n\t}\n\t\n\tv4OutColor = getMaterialColor(s2DMaterial, vec4(fSrcX, 1, fSrcX + fLength, 0), vec4(fDstX, fDstY, fDstX + fWidth, fDstY - fHeight), v2TexCoord);\n\treturn true;\n}\n\nvoid main() \n{\n\tvec4 v4Color = vec4(0.0, 0.0, 0.0, 0.0);\n\tbool bRet = false;\n\t\n\tif (noise1.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise1.y, noise1.x, noise1.z, noise1.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\tif (noise2.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise2.y, noise2.x, noise2.z, noise2.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\tif (noise3.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise3.y, noise3.x, noise3.z, noise3.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\tif (noise4.x > 0.0)\n\t{\n\t\tbRet = noiseColor(inputImageTexture, v4Color, vTextureCoord, noise4.y, noise4.x, noise4.z, noise4.w, noiseSize.x, noiseSize.y);\n\t\tif (bRet)\n\t\t{\n\t\t\tgl_FragColor = v4Color;\n\t\t\treturn;\n\t\t}\n\t}\n\t\n\tgl_FragColor = v4Color;\n}\n\n";
    private static final String TAG = "FilmFilter";
    private ArrayList<FilmFilter.NoiseItem> mListItems;
    private int mUniInputTexture;
    private int mUniNoise1;
    private int mUniNoise2;
    private int mUniNoise3;
    private int mUniNoise4;
    private int mUniNoiseSize;

    public FilmNoiseFilter() {
        super(NOISE_FRAGMENT_SHADER);
        this.mUniInputTexture = -1;
        this.mUniNoiseSize = -1;
        this.mUniNoise1 = -1;
        this.mUniNoise2 = -1;
        this.mUniNoise3 = -1;
        this.mUniNoise4 = -1;
    }

    @Override // com.tencent.ttpic.openapi.filter.GPUBaseFilter
    public void onDestroy() {
        super.onDestroy();
        this.mListItems = null;
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
        this.mUniNoiseSize = GLES20.glGetUniformLocation(program, "noiseSize");
        this.mUniNoise1 = GLES20.glGetUniformLocation(program, "noise1");
        this.mUniNoise2 = GLES20.glGetUniformLocation(program, "noise2");
        this.mUniNoise3 = GLES20.glGetUniformLocation(program, "noise3");
        this.mUniNoise4 = GLES20.glGetUniformLocation(program, "noise4");
    }

    public boolean process(int i3, float[] fArr, float[] fArr2) {
        ArrayList<FilmFilter.NoiseItem> arrayList;
        if (i3 < 0 || (arrayList = this.mListItems) == null || arrayList.size() == 0 || !processBegin(fArr, fArr2)) {
            return false;
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glUniform1i(this.mUniInputTexture, 0);
        GLES20.glUniform2f(this.mUniNoiseSize, this.mListItems.get(0).mDstRect.width(), Math.abs(this.mListItems.get(0).mDstRect.height()));
        for (int i16 = 0; i16 < this.mListItems.size(); i16++) {
            FilmFilter.NoiseItem noiseItem = this.mListItems.get(i16);
            if (i16 == 0) {
                int i17 = this.mUniNoise1;
                float f16 = noiseItem.mSrcLength;
                float f17 = noiseItem.mSrcX;
                RectF rectF = noiseItem.mDstRect;
                GLES20.glUniform4f(i17, f16, f17, rectF.left, rectF.top);
            } else if (i16 == 1) {
                int i18 = this.mUniNoise2;
                float f18 = noiseItem.mSrcLength;
                float f19 = noiseItem.mSrcX;
                RectF rectF2 = noiseItem.mDstRect;
                GLES20.glUniform4f(i18, f18, f19, rectF2.left, rectF2.top);
            } else if (i16 == 2) {
                int i19 = this.mUniNoise3;
                float f26 = noiseItem.mSrcLength;
                float f27 = noiseItem.mSrcX;
                RectF rectF3 = noiseItem.mDstRect;
                GLES20.glUniform4f(i19, f26, f27, rectF3.left, rectF3.top);
            } else if (i16 == 3) {
                int i26 = this.mUniNoise4;
                float f28 = noiseItem.mSrcLength;
                float f29 = noiseItem.mSrcX;
                RectF rectF4 = noiseItem.mDstRect;
                GLES20.glUniform4f(i26, f28, f29, rectF4.left, rectF4.top);
            }
        }
        processEnd(true, 33984);
        return true;
    }

    public void updateData(ArrayList<FilmFilter.NoiseItem> arrayList) {
        this.mListItems = arrayList;
        if (arrayList != null && arrayList.size() < 4) {
            int size = 4 - this.mListItems.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mListItems.add(new FilmFilter.NoiseItem());
            }
        }
    }
}
