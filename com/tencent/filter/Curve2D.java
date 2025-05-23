package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class Curve2D extends BaseFilter {
    static IPatchRedirector $redirector_;
    private float[] transMat;

    public Curve2D() {
        super(BaseFilter.getFragmentShader(7));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        float[] fArr = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.transMat = fArr;
        addParam(new UniformParam.FloatsParam("colorMat", fArr));
        addParam(new UniformParam.FloatsParam("transMat", new float[]{1.0f, 1.0f, 0.0f, 0.0f}));
    }

    public void setMatrix(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fArr);
        } else {
            addParam(new UniformParam.FloatsParam("colorMat", fArr));
        }
    }

    public Curve2D(String str) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            addParam(new TextureResParam("inputImageTexture2", str, 33986));
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
    }

    public Curve2D(int i3, String str) {
        super(BaseFilter.getFragmentShader(i3));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            return;
        }
        float[] fArr = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        this.transMat = fArr;
        addParam(new UniformParam.FloatsParam("colorMat", fArr));
        addParam(new TextureResParam("inputImageTexture2", str, 33986));
    }
}
