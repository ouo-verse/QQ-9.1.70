package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* compiled from: P */
/* loaded from: classes6.dex */
public class MenghuanFilter extends BaseFilter {
    public MenghuanFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(54));
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/menghuan_curve.png", 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(118));
        baseFilter2.addParam(new TextureResParam("inputImageTexture2", "sh/menghuan_blend.png", 33986, this.needFlipBlend ? 1 : 0));
        baseFilter.setNextFilter(baseFilter2, null);
        BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(122));
        baseFilter3.addParam(new UniformParam.FloatsParam("levelMinimum", new float[]{0.16078432f, 0.16078432f, 0.16078432f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("levelMiddle", new float[]{1.0f, 1.0f, 1.0f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("levelMaximum", new float[]{1.0f, 1.0f, 1.0f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("minOutput", new float[]{0.0f, 0.0f, 0.0f}));
        baseFilter3.addParam(new UniformParam.FloatsParam("maxOutput", new float[]{1.0f, 1.0f, 1.0f}));
        baseFilter2.setNextFilter(baseFilter3, null);
        super.applyFilterChain(z16, f16, f17);
    }
}
