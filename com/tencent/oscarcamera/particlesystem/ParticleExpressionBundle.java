package com.tencent.oscarcamera.particlesystem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public class ParticleExpressionBundle {
    static IPatchRedirector $redirector_;
    public long[] expressions;
    public int paramLine;
    public int[] paramOffsets;

    public ParticleExpressionBundle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
