package com.tencent.could.huiyansdk.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes5.dex */
public class CameraRiskParamData {
    static IPatchRedirector $redirector_;
    private CameraRiskParam reflect;
    private int stage;
    private CameraRiskParam start;

    public CameraRiskParamData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.stage = 3;
        }
    }

    public CameraRiskParam getReflect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CameraRiskParam) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.reflect;
    }

    public int getStage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.stage;
    }

    public CameraRiskParam getStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CameraRiskParam) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.start;
    }

    public void setReflect(CameraRiskParam cameraRiskParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cameraRiskParam);
        } else {
            this.reflect = cameraRiskParam;
        }
    }

    public void setStage(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.stage = i3;
        }
    }

    public void setStart(CameraRiskParam cameraRiskParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cameraRiskParam);
        } else {
            this.start = cameraRiskParam;
        }
    }
}
