package com.tencent.filter.art;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CartoonFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private int type;

    public CartoonFilter(int i3) {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.type = i3;
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        clearGLSL();
        if (z16) {
            this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
            setNextFilter(null, null);
        } else {
            this.glslProgramShader = BaseFilter.getFragmentShader(78);
            BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(77));
            setNextFilter(baseFilter, null);
            BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(79));
            baseFilter.setNextFilter(baseFilter2, null);
            BaseFilter baseFilter3 = new BaseFilter(BaseFilter.getFragmentShader(72));
            baseFilter3.addParam(new UniformParam.FloatParam("threshold", 0.0f));
            baseFilter2.setNextFilter(baseFilter3, null);
            BaseFilter baseFilter4 = new BaseFilter(BaseFilter.getFragmentShader(82));
            baseFilter3.setNextFilter(baseFilter4, null);
            BaseFilter baseFilter5 = new BaseFilter(BaseFilter.getFragmentShader(73));
            baseFilter5.addParam(new UniformParam.FloatParam("inv_2sigma2", 127.00195f));
            baseFilter5.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 8.0E-4f));
            baseFilter4.setNextFilter(baseFilter5, new int[]{2});
            BaseFilter baseFilter6 = new BaseFilter(BaseFilter.getFragmentShader(76));
            baseFilter6.addParam(new UniformParam.FloatParam("par", 0.15f));
            baseFilter5.setNextFilter(baseFilter6, new int[]{4});
            BaseFilter baseFilter7 = new BaseFilter(BaseFilter.getFragmentShader(75));
            baseFilter7.addParam(new UniformParam.FloatParam("par", 0.35f));
            baseFilter7.addParam(new UniformParam.FloatParam("par_b", 0.2f));
            baseFilter6.setNextFilter(baseFilter7, new int[]{4, 5});
            BaseFilter baseFilter8 = new BaseFilter(BaseFilter.getFragmentShader(74));
            baseFilter8.addParam(new UniformParam.FloatParam("inv_2sigma", 12.0f));
            baseFilter7.setNextFilter(baseFilter8, new int[]{4});
            int i3 = this.type;
            if (i3 == 1) {
                BaseFilter baseFilter9 = new BaseFilter(BaseFilter.getFragmentShader(71));
                baseFilter9.addParam(new UniformParam.FloatParam("inv_2sigma2", 144.5f));
                baseFilter9.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 0.02f));
                baseFilter8.setNextFilter(baseFilter9, new int[]{5, 4});
                BaseFilter baseFilter10 = new BaseFilter(BaseFilter.getFragmentShader(70));
                baseFilter10.addParam(new UniformParam.FloatParam("inv_2sigma2", 144.5f));
                baseFilter10.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 0.02f));
                baseFilter9.setNextFilter(baseFilter10, new int[]{4});
                baseFilter10.setNextFilter(new BaseFilter(BaseFilter.getFragmentShader(80)), new int[]{8});
            } else if (i3 == 2) {
                BaseFilter baseFilter11 = new BaseFilter(BaseFilter.getFragmentShader(71));
                baseFilter11.addParam(new UniformParam.FloatParam("inv_2sigma2", 144.5f));
                baseFilter11.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 0.02f));
                baseFilter8.setNextFilter(baseFilter11, new int[]{5, 4});
                BaseFilter baseFilter12 = new BaseFilter(BaseFilter.getFragmentShader(70));
                baseFilter12.addParam(new UniformParam.FloatParam("inv_2sigma2", 144.5f));
                baseFilter12.addParam(new UniformParam.FloatParam("inv_sigma_root_2pi", 0.02f));
                baseFilter11.setNextFilter(baseFilter12, new int[]{4});
                baseFilter12.setNextFilter(new BaseFilter(BaseFilter.getFragmentShader(81)), new int[]{8});
            }
        }
        super.applyFilterChain(z16, f16, f17);
    }
}
