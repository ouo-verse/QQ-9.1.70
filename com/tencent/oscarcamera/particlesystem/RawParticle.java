package com.tencent.oscarcamera.particlesystem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* loaded from: classes22.dex */
public class RawParticle {
    static IPatchRedirector $redirector_;
    public List<String> color;
    public String emissionRate;
    public String energyMax;
    public String life;
    public String name;
    public String particleCountMax;
    public List<String> position;
    public String size;
    public Sprite sprite;

    public RawParticle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
