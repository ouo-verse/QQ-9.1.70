package com.tencent.filter.ttpic;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

/* loaded from: classes6.dex */
public class DarkCornerPtuFilter extends BaseFilter {
    private static String DC_FILTER_GPULEVELS_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform int maskType;\n\nuniform vec3 levelMinimum;\nuniform vec3 levelMiddle;\nuniform vec3 levelMaximum;\nuniform vec3 minOutput;\nuniform vec3 maxOutput;\n\nuniform float filterAdjustParam;\n\nvec3 levelscontrolinput(vec3 color,vec3 minInput,vec3 gamma,vec3 maxInput )\n{\n    vec3 temp =  min(max(color - minInput, vec3(0.0)) / (maxInput - minInput), vec3(1.0));\n    return pow(temp, 1.0 / gamma);\n}\n\nvec3 levelscontrol(vec3 color,vec3 minInput,vec3 gamma,vec3 maxInput,vec3 minOutput,vec3 maxOutput )\n{\n    return mix(minOutput, maxOutput, levelscontrolinput(color, minInput, gamma, maxInput));\n}\n\nvoid main()\n{\n    vec4 original, tempColor;\n    vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n    original = textureColor;\n    vec3 temp =  levelscontrol(textureColor.rgb, levelMinimum, levelMiddle, levelMaximum, minOutput, maxOutput);\n    vec4 newcolor = vec4(temp, textureColor.a);\n\n    float alpha = 1.0;\n    if(maskType == 0) {\n        alpha = texture2D(inputImageTexture2, textureCoordinate).r;\n    } else { \n        alpha = texture2D(inputImageTexture3, textureCoordinate).r;\n    }\n    tempColor = mix(textureColor, newcolor, alpha);\n\n    gl_FragColor = mix(original,tempColor,filterAdjustParam);\n}";
    private float adjust;
    private int maskType;
    private BaseFilter nextFilter;

    public DarkCornerPtuFilter() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.maskType = 0;
        this.nextFilter = null;
        this.adjust = 0.0f;
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        BaseFilter baseFilter = new BaseFilter(DC_FILTER_GPULEVELS_SHADER);
        this.nextFilter = baseFilter;
        baseFilter.addParam(new TextureResParam("inputImageTexture2", "sh/darkcornermask_s.png", 33986));
        this.nextFilter.addParam(new TextureResParam("inputImageTexture3", "sh/darkcornermask_l.png", 33987));
        this.nextFilter.addParam(new UniformParam.FloatsParam("levelMinimum", new float[]{0.0f, 0.0f, 0.0f}));
        this.nextFilter.addParam(new UniformParam.FloatsParam("levelMiddle", new float[]{0.3f, 0.3f, 0.3f}));
        this.nextFilter.addParam(new UniformParam.FloatsParam("levelMaximum", new float[]{1.0f, 1.0f, 1.0f}));
        this.nextFilter.addParam(new UniformParam.FloatsParam("minOutput", new float[]{0.0f, 0.0f, 0.0f}));
        this.nextFilter.addParam(new UniformParam.FloatsParam("maxOutput", new float[]{1.0f, 1.0f, 1.0f}));
        this.nextFilter.addParam(new UniformParam.IntParam("maskType", this.maskType));
        this.nextFilter.addParam(new UniformParam.FloatParam("filterAdjustParam", this.adjust));
        setNextFilter(this.nextFilter, null);
        super.applyFilterChain(z16, f16, f17);
    }

    public boolean needRender() {
        if (Math.abs(this.adjust) > 0.01f) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.filter.BaseFilter
    public void setAdjustParam(float f16) {
        this.adjust = f16;
        this.nextFilter.addParam(new UniformParam.FloatParam("filterAdjustParam", f16));
    }

    public void setMaskType(int i3) {
        this.maskType = i3;
        BaseFilter baseFilter = this.nextFilter;
        if (baseFilter != null) {
            baseFilter.addParam(new UniformParam.IntParam("maskType", i3));
        }
    }
}
