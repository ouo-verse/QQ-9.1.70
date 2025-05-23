package com.tencent.facebeauty;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes5.dex */
public class NormalizedFaceParam {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private double f105498h;

    /* renamed from: w, reason: collision with root package name */
    private double f105499w;

    /* renamed from: x, reason: collision with root package name */
    private double f105500x;

    /* renamed from: y, reason: collision with root package name */
    private double f105501y;

    public NormalizedFaceParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f105499w = 0.0d;
        this.f105498h = 0.0d;
        this.f105500x = 0.0d;
        this.f105501y = 0.0d;
    }

    public double getH() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Double) iPatchRedirector.redirect((short) 4, (Object) this)).doubleValue();
        }
        return this.f105498h;
    }

    public double getW() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
        }
        return this.f105499w;
    }

    public double getX() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Double) iPatchRedirector.redirect((short) 6, (Object) this)).doubleValue();
        }
        return this.f105500x;
    }

    public double getY() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Double) iPatchRedirector.redirect((short) 8, (Object) this)).doubleValue();
        }
        return this.f105501y;
    }

    public void setH(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Double.valueOf(d16));
        } else {
            this.f105498h = d16;
        }
    }

    public void setW(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Double.valueOf(d16));
        } else {
            this.f105499w = d16;
        }
    }

    public void setX(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Double.valueOf(d16));
        } else {
            this.f105500x = d16;
        }
    }

    public void setY(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Double.valueOf(d16));
        } else {
            this.f105501y = d16;
        }
    }
}
