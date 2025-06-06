package com.tencent.mobileqq.shortvideo.dancemachine.tempDir;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ShaderListFile {
    public static final String GL_LINE_FRAGMENT_CODE = "precision mediump float;uniform vec4 color;\nvoid main()\n{\ngl_FragColor = color;\n}\n";
    public static final String GL_LINE_VERTEX_CODE = "precision highp float;\nattribute vec4 position;\nvoid main()\n{\ngl_Position = vec4(position.xy,0,1);\n}\n";
    public static final String GL_PIC_FRAGMENT_CODE = "precision mediump float;uniform sampler2D SamplerOne;\nvarying vec2 textureOneOut;\nvoid main()\n{\ngl_FragColor = texture2D(SamplerOne, textureOneOut);\n}\n";
    public static final String GL_PIC_VERTEX_CODE = "precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateOne;\nvarying   vec2 textureOneOut;\nvoid main()\n{\ntextureOneOut = textureCoordinateOne;\ngl_Position = position;\n}\n";
}
