package com.tencent.mobileqq.shortvideo.mtveffects;

import android.opengl.GLES20;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FilmColorFilter extends BaseFragmentFilter {
    public static final String FILM_FRAGMENT_SHADER = "precision highp float;\n\nvarying highp vec2 vTextureCoord;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\n\nuniform float  u_time;\n\nconst float intensity = 0.06;\n\n// \u6742\u70b9\u51fd\u6570\nfloat randColorFun(vec2 co)\n{\n   return fract(sin(dot(co.xy, vec2(12.9898,78.233))) * 43758.5453);\n}\n\nvec2 getRandCoordinate( vec2 vTextureCoord)\n{\n   vec2 uv = vTextureCoord.xy;\n   float waveu = sin((uv.y + u_time/150.0) * 20.0) * 0.009;\n   return uv + vec2(waveu, 0);\n}\n\nvoid main()\n{\n   highp vec4 textureColor = texture2D(inputImageTexture, vTextureCoord);\n   highp vec2 randCoordinate = getRandCoordinate(vTextureCoord);\n   float randColor = randColorFun(randCoordinate)*intensity;\n    \n   // \u5168\u8272\u56fe\u5148\u5904\u7406\u4e0b\n   float blueColor = textureColor.b * 63.0;\n   \n   highp vec2 quad1;\n   quad1.y = floor(floor(blueColor) / 8.0);\n   quad1.x = floor(blueColor) - (quad1.y * 8.0);\n   \n   highp vec2 quad2;\n   quad2.y = floor(ceil(blueColor) / 8.0);\n   quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n   \n   highp vec2 texPos1;\n   texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n   texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n   \n   highp vec2 texPos2;\n   texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n   texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n   \n   lowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\n   lowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\n   \n   lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    \n   // \u5355\u8272\u6742\u70b9\uff0c\u7edf\u4e00\u52a0randColor\n   newColor.r = max(0.0, min(1.0, (newColor.r + randColor)));\n   newColor.g = max(0.0, min(1.0, (newColor.g + randColor)));\n   newColor.b = max(0.0, min(1.0, (newColor.b + randColor)));\n    \n   gl_FragColor = vec4(newColor.rgb, textureColor.w);\n   \n}";
    private static final String TAG = "FilmFilter";
    private int mUniInputTexture;
    private int mUniInputTexture2;

    public FilmColorFilter() {
        super(FILM_FRAGMENT_SHADER);
        this.mUniInputTexture = -1;
        this.mUniInputTexture2 = -1;
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
    }

    public boolean process(int i3, int i16, float[] fArr, float[] fArr2) {
        if (i3 < 0 || i16 < 0 || !processBegin(fArr, fArr2)) {
            return false;
        }
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mTextureType, i3);
        GLES20.glUniform1i(this.mUniInputTexture, 0);
        if (i16 >= 0) {
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(this.mTextureType, i16);
            GLES20.glUniform1i(this.mUniInputTexture2, 1);
        }
        if (i16 >= 0) {
            processEnd(false, 33984, 33985);
        } else {
            processEnd(false, 33984);
        }
        return true;
    }
}
