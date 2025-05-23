package com.tencent.qcircle.weseevideo.composition.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MotionBlurFilter extends BaseFilter {
    private static final String FRAGMENT_SHADER = "precision highp float;\n \n uniform sampler2D inputImageTexture;\n uniform vec2 directionalTexelStep;\n uniform vec2 motionBlurEllipseCenter;\n uniform float motionBlurEllipseA;\n uniform float motionBlurEllipseB;\n uniform int directionalTexelNumSamples;\n uniform float motionBlurEllipseGradientRatio;\n \n varying vec2 textureCoordinate;\n \n void main()\n {\n    // \u5224\u65ad\u5728\u692d\u5706\u5916\u90e8\u6b63\u5e38\u6a21\u7cca\uff0c\u4e24\u4e2a\u692d\u5706\u4e4b\u95f4\u6e10\u53d8\u6a21\u7cca\uff0c\u5185\u692d\u5706\u91cc\u9762\u4e0d\u6a21\u7cca\n    float x0 = textureCoordinate.x - motionBlurEllipseCenter.x;\n    float y0 = textureCoordinate.y - motionBlurEllipseCenter.y;\n    \n    float motionBlurInnerEllipseA = motionBlurEllipseGradientRatio * motionBlurEllipseA;\n    float motionBlurInnerEllipseB = motionBlurEllipseGradientRatio * motionBlurEllipseB;\n    \n    float x = x0 / motionBlurInnerEllipseA;\n    float y = y0 / motionBlurInnerEllipseB;\n    \n    vec2 step = directionalTexelStep;\n    int numSamples = directionalTexelNumSamples;\n    \n    if (x*x + y*y < 1.0)\n    {\n        // no blur\n        gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n    }\n    else\n    {\n        x = x0 / motionBlurEllipseA;\n        y = y0 / motionBlurEllipseB;\n        float d2 = x*x + y*y;\n        \n        float r2 = motionBlurEllipseGradientRatio * motionBlurEllipseGradientRatio;\n        float factor = min(r2 >= 1.0 ? 1.0 : (d2 - r2) / (1.0 - r2), 1.0);\n        step *= factor;\n        \n        lowp vec4 tot = vec4(0.0);\n        vec2 offset = textureCoordinate - float(numSamples) * step;\n        for (int i = -numSamples; i <= numSamples; i++)\n        {\n            offset += step;\n            tot += texture2D(inputImageTexture, offset);\n        }\n\n        gl_FragColor = tot / (float(numSamples * 2) + 1.0);\n    }\n }";
    private static final String VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}";
    private int mMotionBlurAngle;
    private float mMotionBlurSize;

    public MotionBlurFilter() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", FRAGMENT_SHADER);
        this.mMotionBlurSize = 2.0f;
        this.mMotionBlurAngle = 0;
        resetParameters();
    }

    @Override // com.tencent.filter.BaseFilter, com.tencent.aekit.openrender.internal.AEChainI
    public Frame render(Frame frame) {
        if (frame != null) {
            addParam(new UniformParam.Float2fParam("directionalTexelStep", (float) (((this.mMotionBlurSize * Math.cos((this.mMotionBlurAngle * 3.141592653589793d) / 180.0d)) * ((frame.height * 1.0f) / frame.width)) / 1024.0d), (float) ((this.mMotionBlurSize * Math.sin((this.mMotionBlurAngle * 3.141592653589793d) / 180.0d)) / 1024.0d)));
        }
        return super.render(frame);
    }

    public void resetParameters() {
        addParam(new UniformParam.Float2fParam("directionalTexelStep", 0.0f, 0.0f));
        addParam(new UniformParam.Float2fParam("motionBlurEllipseCenter", 0.0f, 0.0f));
        addParam(new UniformParam.FloatParam("motionBlurEllipseA", 0.0f));
        addParam(new UniformParam.FloatParam("motionBlurEllipseB", 0.0f));
        addParam(new UniformParam.IntParam("directionalTexelNumSamples", 5));
        addParam(new UniformParam.FloatParam("motionBlurEllipseGradientRatio", 0.1f));
    }

    public void setParameters(float f16, float f17, float f18, float f19, float f26, int i3, float f27, int i16) {
        this.mMotionBlurSize = f16;
        if (f17 >= 0.0f && f18 >= 0.0f) {
            addParam(new UniformParam.Float2fParam("motionBlurEllipseCenter", f17, f18));
        }
        if (f19 >= 0.0f) {
            addParam(new UniformParam.FloatParam("motionBlurEllipseA", f19));
        }
        if (f26 >= 0.0f) {
            addParam(new UniformParam.FloatParam("motionBlurEllipseB", f26));
        }
        if (i3 > 0) {
            addParam(new UniformParam.IntParam("directionalTexelNumSamples", i3));
        }
        float f28 = 1.0f - f27;
        if (f28 >= 0.0f && f28 <= 1.0f) {
            addParam(new UniformParam.FloatParam("motionBlurEllipseGradientRatio", f28));
        }
        if (i16 >= 0 && i16 <= 360) {
            this.mMotionBlurAngle = i16;
        }
    }
}
