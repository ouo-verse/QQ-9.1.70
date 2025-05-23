package com.tencent.filter;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class SurfaceTextureFilter extends BaseFilter {
    static IPatchRedirector $redirector_;

    public SurfaceTextureFilter() {
        super(BaseFilter.getVertexShader(1), BaseFilter.getFragmentShader(9));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.filter.BaseFilter, com.tencent.aekit.openrender.internal.AEChainI
    public void apply() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            applyForOES();
        }
    }
}
