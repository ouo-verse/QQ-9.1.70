package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class SnowFilter extends BaseFilter {
    public static final String shader = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float param;\n void main(void)\n {\n     vec4 color  = texture2D(inputImageTexture, textureCoordinate);\n     vec4 color2 = texture2D(inputImageTexture2, textureCoordinate);\n     vec3 ret=color.rgb+color2.rgb*param;\n     gl_FragColor = vec4(ret.rgb,1.0);\n }\n";

    public SnowFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/snow_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter2.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{-0.09411765f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{-0.09803922f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{-0.05882353f, 0.0f, 0.0f}));
        baseFilter2.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(55));
        baseFilter3.addParam(new UniformParam.FloatParam("scaleC", -0.354f));
        baseFilter3.addParam(new UniformParam.FloatParam("scaleT", 0.0f));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(108));
        baseFilter4.addParam(new UniformParam.FloatParam("inputH", 1.0f));
        baseFilter4.addParam(new UniformParam.FloatParam("inputS", 1.0f));
        baseFilter4.addParam(new UniformParam.FloatParam("inputV", 1.05f));
        baseFilter3.setNextFilter(baseFilter4, null);
        BaseFilter baseFilter5 = new BaseFilter(shader);
        baseFilter5.addParam(new TextureResParam("inputImageTexture2", "sh/snow.png", 33986, f16 / f17));
        baseFilter5.addParam(new UniformParam.FloatParam("param", 0.35f));
        baseFilter4.setNextFilter(baseFilter5, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
