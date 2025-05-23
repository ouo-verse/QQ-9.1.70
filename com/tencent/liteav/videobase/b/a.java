package com.tencent.liteav.videobase.b;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends com.tencent.liteav.videobase.a.a {
    public a() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 textureTransform;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying highp vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main()\n{\n   gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    @Override // com.tencent.liteav.videobase.a.a
    public final int b() {
        return 36197;
    }
}
