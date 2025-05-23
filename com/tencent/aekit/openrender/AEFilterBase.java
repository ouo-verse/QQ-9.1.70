package com.tencent.aekit.openrender;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class AEFilterBase extends AEChainI {
    static IPatchRedirector $redirector_;
    private VideoFilterBase mVideoFilterBase;

    public AEFilterBase(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mVideoFilterBase = new VideoFilterBase(str, str2);
        }
    }

    public void addAttribParam(String str, float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) fArr);
        } else {
            this.mVideoFilterBase.addAttribParam(str, fArr);
        }
    }

    public void addUniformParam(UniformParam uniformParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uniformParam);
        } else {
            this.mVideoFilterBase.addParam(uniformParam);
        }
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public void apply() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mVideoFilterBase.initParams();
            this.mVideoFilterBase.ApplyGLSLFilter();
        }
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mVideoFilterBase.clearGLSLSelf();
        }
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mVideoFilterBase.isValid();
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public Frame render(Frame frame) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Frame) iPatchRedirector.redirect((short) 5, (Object) this, (Object) frame);
        }
        return this.mVideoFilterBase.RenderProcess(frame.getTextureId(), frame.width, frame.height);
    }
}
