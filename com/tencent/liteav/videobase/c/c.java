package com.tencent.liteav.videobase.c;

import com.tencent.qfsmonet.api.data.MonetPacketDescriptor;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c extends e {
    public c() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nuniform mat4 textureTransform;\nvarying highp vec2 textureCoordinate;\nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "varying highp vec2 textureCoordinate;\n\nuniform sampler2D yTexture;\nuniform sampler2D uvTexture;\nmediump mat3 colorConversionMatrix = mat3(       1.164,  1.164, 1.164,\n       1.596, -0.813,   0.0,\n         0.0, -0.392, 2.017\n);\nvoid main()\n{\n    mediump vec3 yuv;\n    lowp vec3 rgb;\n\n    yuv.x = texture2D(yTexture, textureCoordinate).r - (16.0/255.0);\n    yuv.y = texture2D(uvTexture, textureCoordinate).a - 0.5;\n    yuv.z = texture2D(uvTexture, textureCoordinate).r - 0.5;\n    rgb = colorConversionMatrix * yuv;\n\n    gl_FragColor = vec4(rgb, 1.0);\n}");
    }

    @Override // com.tencent.liteav.videobase.c.e
    protected final int e() {
        return MonetPacketDescriptor.MonetDataFormat.RG8;
    }
}
