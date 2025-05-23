package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.ParamHelper;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AlphaAdjustFilter extends BaseFilter {
    private static String FRAGMENT = "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform float filterAdjustParam;\n void main()\n {\n     vec4 c2 = texture2D(inputImageTexture2, textureCoordinate.xy);\n     vec4 c1 = texture2D(inputImageTexture, textureCoordinate.xy);\n     gl_FragColor = mix(c1,c2,filterAdjustParam);\n}\n";

    public AlphaAdjustFilter() {
        super(FRAGMENT);
        initParams();
        this.mParamHelper = new ParamHelper(this).addParam("strength", "filterAdjustParam", ParamHelper.ParamType.Float);
    }

    private void initParams() {
        addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
        addParam(new UniformParam.FloatParam("filterAdjustParam", 1.0f));
    }

    @Override // com.tencent.filter.BaseFilter
    public void setAdjustParam(float f16) {
        addParam(new UniformParam.FloatParam("filterAdjustParam", f16));
    }

    public void setFilterTexture(int i3) {
        addParam(new UniformParam.TextureParam("inputImageTexture2", i3, 33986));
    }
}
