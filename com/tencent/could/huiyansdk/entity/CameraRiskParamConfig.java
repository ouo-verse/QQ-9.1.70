package com.tencent.could.huiyansdk.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes5.dex */
public class CameraRiskParamConfig {
    static IPatchRedirector $redirector_;
    private CameraRiskChangeInfo cameraRiskChangeStageReflect;
    private CameraRiskChangeInfo cameraRiskChangeStageStart;
    private int stage;

    public CameraRiskParamConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.stage = 3;
        }
    }

    public CameraRiskChangeInfo getCameraRiskChangeStageReflect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CameraRiskChangeInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.cameraRiskChangeStageReflect;
    }

    public CameraRiskChangeInfo getCameraRiskChangeStageStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CameraRiskChangeInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.cameraRiskChangeStageStart;
    }

    public int getStage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.stage;
    }

    public void setCameraRiskChangeStageReflect(CameraRiskChangeInfo cameraRiskChangeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) cameraRiskChangeInfo);
        } else {
            this.cameraRiskChangeStageReflect = cameraRiskChangeInfo;
        }
    }

    public void setCameraRiskChangeStageStart(CameraRiskChangeInfo cameraRiskChangeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cameraRiskChangeInfo);
        } else {
            this.cameraRiskChangeStageStart = cameraRiskChangeInfo;
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
}
