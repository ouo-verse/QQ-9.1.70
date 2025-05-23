package com.tencent.av.video.effect.core.qqavimage;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QQAVImageGrayscaleFilter extends QQAVImageFilter {
    public QQAVImageGrayscaleFilter() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(22));
    }
}
