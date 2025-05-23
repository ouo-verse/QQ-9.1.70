package com.tencent.oscarcamera.particlesystem;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes22.dex */
public class Particle {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public double[] f341931a;
    public double birth;
    public int currFrame;
    public int frameCount;
    public boolean musicPlayed;
    public Particle next;
    public int paramOffset;
    public String tex;
    public int total;
    public double[] touchedPosition;

    public Particle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.musicPlayed = false;
        this.f341931a = new double[10];
        this.touchedPosition = new double[3];
        this.next = null;
        this.total = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void copy(Particle particle) {
        if (particle == null) {
            return;
        }
        this.tex = particle.tex;
        this.frameCount = particle.frameCount;
        this.currFrame = particle.currFrame;
        int length = this.f341931a.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f341931a[i3] = particle.f341931a[i3];
        }
        double[] dArr = this.touchedPosition;
        double[] dArr2 = particle.touchedPosition;
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        dArr[2] = dArr2[2];
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return String.format("(%f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %d, %d)", Double.valueOf(this.f341931a[2]), Double.valueOf(this.f341931a[0]), Double.valueOf(this.f341931a[1]), Double.valueOf(this.f341931a[7]), Double.valueOf(this.f341931a[8]), Double.valueOf(this.f341931a[9]), Double.valueOf(this.f341931a[3]), Double.valueOf(this.f341931a[4]), Double.valueOf(this.f341931a[5]), Double.valueOf(this.f341931a[6]), Integer.valueOf(this.frameCount), Integer.valueOf(this.currFrame));
    }
}
