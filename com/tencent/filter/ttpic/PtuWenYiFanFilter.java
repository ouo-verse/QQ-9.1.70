package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* loaded from: classes6.dex */
public class PtuWenYiFanFilter extends BaseFilter {
    public PtuWenYiFanFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/wenyifan_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(115));
        baseFilter2.addParam(new UniformParam.FloatsParam("color2", new float[]{0.9764706f, 0.29803923f, 0.29803923f, 1.0f}));
        baseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.17f));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter3.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{-0.050980393f, 0.0f, 0.0f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{-0.047058824f, -0.039215688f, 0.0f}));
        baseFilter3.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(59));
        baseFilter4.addParam(new UniformParam.FloatsParam("color2", new float[]{0.7882353f, 0.9019608f, 0.8862745f, 1.0f}));
        baseFilter4.addParam(new UniformParam.FloatParam("transparency", 1.0f));
        baseFilter3.setNextFilter(baseFilter4, null);
        BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(13));
        baseFilter5.addParam(new UniformParam.FloatParam("contrast", 1.0f));
        baseFilter5.addParam(new UniformParam.FloatParam("saturation", 1.1f));
        baseFilter5.addParam(new UniformParam.FloatParam("brightness", 1.0f));
        baseFilter4.setNextFilter(baseFilter5, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
