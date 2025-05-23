package com.tencent.filter.art;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class BaibianFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private float blurSize;
    private int fragmentShaderId;
    private float inputH;
    private float inputS;
    private float inputV;
    private float intensity;
    private String resName;

    public BaibianFilter(int i3, String str, float f16, float f17, float f18, float f19, float f26) {
        super(BaseFilter.getFragmentShader(i3));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26));
            return;
        }
        this.resName = str;
        this.fragmentShaderId = i3;
        this.blurSize = f16;
        this.intensity = f17;
        this.inputH = f18;
        this.inputS = f19;
        this.inputV = f26;
        if (str != null || i3 != 0) {
            addParam(new TextureResParam("inputImageTexture2", str, 33986));
            addParam(new UniformParam.FloatParam("inputH", f18));
            addParam(new UniformParam.FloatParam("inputS", f19));
            addParam(new UniformParam.FloatParam("inputV", f26));
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        if (isValid()) {
            super.applyFilterChain(z16, f16, f17);
            return;
        }
        if (z16) {
            if (this.resName != null || this.fragmentShaderId != 0) {
                this.glslProgramShader = BaseFilter.getFragmentShader(this.fragmentShaderId);
                addParam(new TextureResParam("inputImageTexture2", this.resName, 33986));
                addParam(new UniformParam.FloatParam("inputH", this.inputH));
                addParam(new UniformParam.FloatParam("inputS", this.inputS));
                addParam(new UniformParam.FloatParam("inputV", this.inputV));
            }
        } else {
            this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
            BaseFilter baseFilter = getmNextFilter();
            BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(68));
            baseFilter2.addParam(new UniformParam.FloatParam("blurSize", this.blurSize));
            setNextFilter(baseFilter2, null);
            BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(69));
            baseFilter3.addParam(new UniformParam.FloatParam("blurSize", this.blurSize));
            baseFilter3.addParam(new UniformParam.FloatParam("intensity", this.intensity * 3.5f));
            baseFilter2.setNextFilter(baseFilter3, new int[]{this.srcTextureIndex + 1});
            if (this.resName != null || this.fragmentShaderId != 0) {
                BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(this.fragmentShaderId));
                baseFilter4.addParam(new TextureResParam("inputImageTexture2", this.resName, 33986));
                baseFilter4.addParam(new UniformParam.FloatParam("inputH", this.inputH));
                baseFilter4.addParam(new UniformParam.FloatParam("inputS", this.inputS));
                baseFilter4.addParam(new UniformParam.FloatParam("inputV", this.inputV));
                baseFilter3.setNextFilter(baseFilter4, null);
                baseFilter3 = baseFilter4;
            }
            baseFilter3.getLastFilter().setNextFilter(baseFilter, null);
        }
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void setParameterDic(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) map);
            return;
        }
        if (map.containsKey("intensity")) {
            this.intensity = ((Float) map.get("intensity")).floatValue();
        }
        if (getmNextFilter() != null && getmNextFilter().getmNextFilter() != null) {
            getmNextFilter().getmNextFilter().addParam(new UniformParam.FloatParam("intensity", this.intensity * 3.5f));
        }
    }
}
