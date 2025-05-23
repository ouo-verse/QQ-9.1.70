package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FlaresFilter extends BaseFilter {
    static IPatchRedirector $redirector_;
    private String surfaceBlurName;
    private int type;

    public FlaresFilter(int i3) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        double d16 = f16 / f17;
        this.glslProgramShader = BaseFilter.getFragmentShader(14);
        addParam(new TextureResParam("inputImageTexture3", "flares/flares_curve.png", 33987));
        switch (this.type) {
            case 0:
                addParam(new TextureResParam("inputImageTexture2", "flares/flares_bokeh_basic_1.jpg", 33986, d16));
                addParam(new UniformParam.IntParam("flag", 0));
                break;
            case 1:
                addParam(new TextureResParam("inputImageTexture2", "flares/flares_bokeh_basic_2.jpg", 33986, d16));
                addParam(new UniformParam.IntParam("flag", 0));
                break;
            case 2:
                addParam(new TextureResParam("inputImageTexture2", "flares/flares_bokeh_basic_3.jpg", 33986, d16));
                addParam(new UniformParam.IntParam("flag", 0));
                break;
            case 3:
                addParam(new TextureResParam("inputImageTexture2", "flares/flares_bokeh_heart_1.jpg", 33986, d16));
                addParam(new UniformParam.IntParam("flag", 0));
                break;
            case 4:
                addParam(new TextureResParam("inputImageTexture2", "flares/flares_bokeh_heart_2.jpg", 33986, d16));
                addParam(new UniformParam.IntParam("flag", 0));
                break;
            case 5:
                addParam(new TextureResParam("inputImageTexture2", "flares/flares_lens_flares_1.jpg", 33986, d16));
                addParam(new UniformParam.IntParam("flag", 0));
                break;
            case 6:
                addParam(new TextureResParam("inputImageTexture2", "flares/flares_lens_flares_2.jpg", 33986, d16));
                addParam(new UniformParam.IntParam("flag", 0));
                break;
            case 7:
                addParam(new TextureResParam("inputImageTexture2", "flares/flares_lens_flares_3.jpg", 33986, d16));
                addParam(new UniformParam.IntParam("flag", 0));
                break;
            case 8:
                addParam(new TextureResParam("inputImageTexture2", "flares/flares_light_leak_1.jpg", 33986, d16));
                addParam(new UniformParam.IntParam("flag", 1));
                break;
            case 9:
                addParam(new TextureResParam("inputImageTexture2", "flares/flares_light_leak_2.jpg", 33986, d16));
                addParam(new UniformParam.IntParam("flag", 1));
                break;
            default:
                addParam(new TextureResParam("inputImageTexture2", "flares/flares_light_leak_3.jpg", 33986, d16));
                addParam(new UniformParam.IntParam("flag", 1));
                break;
        }
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void setParameterDic(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
        } else if (map.containsKey("effectIndex")) {
            this.type = ((Integer) map.get("effectIndex")).intValue();
        }
    }
}
