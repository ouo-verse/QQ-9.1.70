package com.tencent.oscarcamera.particlesystem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public class ParticleValueBundle {
    static IPatchRedirector $redirector_;
    private double[] res;

    public ParticleValueBundle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
