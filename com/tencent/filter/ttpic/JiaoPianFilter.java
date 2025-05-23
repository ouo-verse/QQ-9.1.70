package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* loaded from: classes6.dex */
public class JiaoPianFilter extends BaseFilter {
    public JiaoPianFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(57));
        baseFilter.addParam(new UniformParam.FloatsParam("shadowsShift", new float[]{-0.05882353f, 0.03529412f, -0.023529412f}));
        baseFilter.addParam(new UniformParam.FloatsParam("midtonesShift", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter.addParam(new UniformParam.FloatsParam("highlightsShift", new float[]{0.07450981f, 0.0f, -0.015686275f}));
        baseFilter.addParam(new UniformParam.IntParam("preserveLuminosity", 1));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(106));
        baseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/jiaopian.png", 33986));
        baseFilter2.addParam(new UniformParam.FloatsParam("channelvec", new float[]{0.0f, 1.0f, 0.0f}));
        baseFilter.setNextFilter(baseFilter2, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
