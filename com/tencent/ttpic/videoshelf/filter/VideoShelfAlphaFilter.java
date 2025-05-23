package com.tencent.ttpic.videoshelf.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;

/* compiled from: P */
/* loaded from: classes27.dex */
public class VideoShelfAlphaFilter extends VideoFilterBase {
    private static final String FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\nuniform int videoTemplateType;\nuniform sampler2D inputImageTexture;\nvoid main()\n{\n    highp vec2 scaleOffset = vec2(0.5, 1);\n    if (videoTemplateType != 0) {\n        scaleOffset = vec2(1, 0.5);\n    }\n    highp vec2 textureCoordinateReal = vec2(textureCoordinate);\n    //textureCoordinateReal.x = textureCoordinate.x * 0.5;\n    textureCoordinateReal = textureCoordinate * scaleOffset;\n    highp vec4 sourceColor = texture2D(inputImageTexture, textureCoordinateReal);\n    scaleOffset = vec2(0.5, 0);\n    if (videoTemplateType != 0) {\n        scaleOffset = vec2(0, 0.5);\n    }\n    highp vec2 textureCoordinateMask = vec2(textureCoordinateReal);\n    textureCoordinateMask = textureCoordinateMask + scaleOffset;\n    //textureCoordinateMask.x += 0.5;\n    highp vec4 maskColor = texture2D(inputImageTexture, textureCoordinateMask);\n    highp float a = maskColor.r;\n    highp vec4 outputColor = vec4(sourceColor);\n    outputColor.a = a;\n    if (a == 1.0) {\n        //    outputColor = vec4(1.0, 0, 0, 1.0); //test\n    }\n    gl_FragColor = outputColor;\n}\n";
    private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}\n";

    public VideoShelfAlphaFilter() {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        initParams();
    }

    @Override // com.tencent.aekit.openrender.internal.VideoFilterBase
    public void initParams() {
        addParam(new UniformParam.IntParam("videoTemplateType", 0));
    }

    public void updateVideoTemplateType(int i3) {
        int i16;
        if (i3 == 0) {
            i16 = 0;
        } else {
            i16 = 1;
        }
        addParam(new UniformParam.IntParam("videoTemplateType", i16));
    }
}
