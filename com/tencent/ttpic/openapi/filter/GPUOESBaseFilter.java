package com.tencent.ttpic.openapi.filter;

/* loaded from: classes27.dex */
public class GPUOESBaseFilter extends GPUBaseFilter {
    public static final String OES_FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";

    public GPUOESBaseFilter() {
        this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", OES_FRAGMENT_SHADER);
    }

    public GPUOESBaseFilter(String str, String str2) {
        super(str, str2);
        this.mTextureType = 36197;
        this.mFilterType = 102;
    }
}
