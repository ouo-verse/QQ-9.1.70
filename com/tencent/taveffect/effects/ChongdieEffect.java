package com.tencent.taveffect.effects;

import com.tencent.taveffect.core.TAVTextureInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ChongdieEffect extends BaseEffect {
    private static String FRAGMENT_SHADER_CODE = "sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nfloat shadowOffset = 0.2;\nfloat alphaGrad = 1.6;\nvoid main()\n{\n    vec2 originTexCoord = vTextureCoord;\n    vec2 lOffsetTexCoord = vTextureCoord;\n    vec2 rOffsetTexCoord = vTextureCoord;\n\n    float repeatDis = shadowOffset / 2.0;\n\n    float begin = 0.0;\n    float end = 0.5 + repeatDis;\n    float diff1 = clamp(originTexCoord.x - begin, 0.0, 1.0);\n    float diff2 = clamp(end - originTexCoord.x, 0.0, 1.0);\n    float flag = clamp(diff1 * diff2 * 1e08, 0.0, 1.0);\n\n    float offset = flag * shadowOffset;\n    lOffsetTexCoord.x = originTexCoord.x + offset;\n\n    float lAlpha = (end - originTexCoord.x) * flag / shadowOffset;\n    lAlpha = lAlpha * pow((1.0 - lOffsetTexCoord.y), alphaGrad);\n    lAlpha = clamp(lAlpha, 0.0, 1.0);\n\n    begin = 0.5 - repeatDis;\n    end = 1.0;\n    diff1 = clamp(originTexCoord.x - begin, 0.0, 1.0);\n    diff2 = clamp(end - originTexCoord.x, 0.0, 1.0);\n    flag = clamp(diff1 * diff2 * 1e08, 0.0, 1.0);\n\n    offset = flag * shadowOffset;\n    rOffsetTexCoord.x = originTexCoord.x - offset;\n\n    float rAlpha = (originTexCoord.x - begin) * flag / shadowOffset;\n    rAlpha = rAlpha * pow((1.0 - rOffsetTexCoord.y), alphaGrad);\n    rAlpha = clamp(rAlpha, 0.0, 1.0);\n\n    vec4 lColorOffset = texture2D(sTexture, lOffsetTexCoord);\n    vec4 rColorOffset = texture2D(sTexture, rOffsetTexCoord);\n    vec4 videoColor = texture2D(sTexture, originTexCoord);\n\n    gl_FragColor = videoColor * (1.0 - lAlpha - rAlpha) + lAlpha * lColorOffset + rAlpha * rColorOffset;\n}";

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES " + FRAGMENT_SHADER_CODE;
        }
        return "uniform sampler2D " + FRAGMENT_SHADER_CODE;
    }

    @Override // com.tencent.taveffect.core.TAVBaseFilter
    /* renamed from: clone */
    public ChongdieEffect mo93clone() {
        return (ChongdieEffect) cloneFilter(new ChongdieEffect());
    }
}
