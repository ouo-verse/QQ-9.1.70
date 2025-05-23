package com.tencent.oscarcamera.particlesystem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Sprite {
    static IPatchRedirector $redirector_;
    public int animated;
    public String audioPath;
    public int blendMode;
    public int frameCount;
    public double frameDuration;
    public int height;
    public int looped;
    public String path;
    public float[] texCoords;
    public int width;

    public Sprite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.path = "";
            this.audioPath = "";
        }
    }
}
