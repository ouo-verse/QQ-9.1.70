package com.tencent.oscarcamera.particlesystem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public class FrameParticleData {
    static IPatchRedirector $redirector_;
    public String audioPath;
    public int blendMode;
    public float[] particleCenter;
    public float[] particleColor;
    public int particleCount;
    public float[] particleSize;
    public boolean playAudio;
    public float[] positionIndex;
    public String tex;
    public float[] texCoords;

    public FrameParticleData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
