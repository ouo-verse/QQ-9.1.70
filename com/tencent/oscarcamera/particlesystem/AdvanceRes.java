package com.tencent.oscarcamera.particlesystem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AdvanceRes {
    static IPatchRedirector $redirector_;
    public String audioPath;
    public int blendMode;
    public int particleCenterLen;
    public int particleCenterOffset;
    public int particleColorLen;
    public int particleColorOffset;
    public int particleCount;
    public int particleSizeLen;
    public int particleSizeOffset;
    boolean playAudio;
    public int positionIndexLen;
    public int positionIndexOffset;
    public String tex;
    public int texCoordsLen;
    public int texCoordsOffset;

    public AdvanceRes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
