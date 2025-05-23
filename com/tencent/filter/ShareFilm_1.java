package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ShareFilm_1 extends BaseFilter {
    static IPatchRedirector $redirector_;

    public ShareFilm_1() {
        super(BaseFilter.getFragmentShader(5), "share_film.jpg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            addParam(new UniformParam.Float2fParam("randomCoord2", (float) Math.random(), (float) Math.random()));
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void OnDrawFrameGLSL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        UniformParam.Float2fParam float2fParam = (UniformParam.Float2fParam) getParam("randomCoord2");
        float2fParam.f61801x = (float) Math.random();
        float2fParam.f61802y = (float) Math.random();
        super.OnDrawFrameGLSL();
    }
}
