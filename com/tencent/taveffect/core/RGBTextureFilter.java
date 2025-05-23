package com.tencent.taveffect.core;

import com.tencent.taveffect.effects.BaseEffect;

/* compiled from: P */
/* loaded from: classes26.dex */
public class RGBTextureFilter extends BaseEffect {
    private static final String FRAGMENT_SHADER_CODE = "sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";

    @Override // com.tencent.taveffect.effects.BaseEffect
    protected String getFragmentShaderCode(TAVTextureInfo tAVTextureInfo) {
        if (tAVTextureInfo.textureType == 36197) {
            return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
        }
        return "uniform sampler2D sTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    }
}
