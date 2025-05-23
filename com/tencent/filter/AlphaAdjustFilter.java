package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class AlphaAdjustFilter extends BaseFilter {
    static IPatchRedirector $redirector_;

    public AlphaAdjustFilter(int i3) {
        super(BaseFilter.getFragmentShader(i3));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void setAdjustParam(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16));
        } else {
            addParam(new UniformParam.FloatParam("filterAdjustParam", f16));
        }
    }
}
