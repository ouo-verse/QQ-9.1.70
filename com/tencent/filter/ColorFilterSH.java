package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ColorFilterSH extends BaseFilter {
    static IPatchRedirector $redirector_;
    private int effectindex;

    public ColorFilterSH() {
        super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.effectindex = 0;
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void applyFilterChain(boolean z16, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.glslProgramShader = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n";
        BaseFilter baseFilter = new BaseFilter(BaseFilter.getFragmentShader(62));
        int i3 = this.effectindex;
        String str = "sh/";
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            str = "sh/yellow_sh_blend.jpg";
                        }
                    } else {
                        str = "sh/red_sh_blend.jpg";
                    }
                } else {
                    str = "sh/purple_sh_blend.jpg";
                }
            } else {
                str = "sh/green_sh_blend.jpg";
            }
        } else {
            str = "sh/blue_sh_blend.jpg";
        }
        baseFilter.addParam(new TextureResParam("inputImageTexture2", str, 33986));
        setNextFilter(baseFilter, null);
        BaseFilter baseFilter2 = new BaseFilter(BaseFilter.getFragmentShader(3));
        if (this.effectindex == 2) {
            baseFilter2.addParam(new UniformParam.FloatParam("filterAdjustParam", 0.6f));
        } else {
            baseFilter2.addParam(new UniformParam.FloatParam("filterAdjustParam", 0.5f));
        }
        baseFilter.setNextFilter(baseFilter2, new int[]{this.srcTextureIndex});
        super.applyFilterChain(z16, f16, f17);
    }

    @Override // com.tencent.filter.BaseFilter
    public void setParameterDic(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
        } else if (map.containsKey("effectIndex")) {
            this.effectindex = ((Integer) map.get("effectIndex")).intValue();
        }
    }
}
