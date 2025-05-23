package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GradientGlareFondDreamFilter extends BaseFilter {
    public GradientGlareFondDreamFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/glarefonddream_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(135));
        baseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/glarefonddream_screen0.png", 33986));
        baseFilter2.addParam(new UniformParam.FloatParam("transparency", 0.6f));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(135));
        baseFilter3.addParam(new TextureResParam("inputImageTexture2", "sh/glarefonddream_screen1.png", 33986));
        baseFilter3.addParam(new UniformParam.FloatParam("transparency", 0.7f));
        baseFilter2.setNextFilter(baseFilter3, null);
        BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(135));
        baseFilter4.addParam(new TextureResParam("inputImageTexture2", "sh/glarefonddream_screen2.png", 33986));
        baseFilter4.addParam(new UniformParam.FloatParam("transparency", 0.4f));
        baseFilter3.setNextFilter(baseFilter4, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
