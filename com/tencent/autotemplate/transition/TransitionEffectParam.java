package com.tencent.autotemplate.transition;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tav.coremedia.CMTime;

/* loaded from: classes3.dex */
public class TransitionEffectParam {
    static IPatchRedirector $redirector_;
    private CMTime durationTime;
    private String effectId;
    private String filePath;
    private boolean isFaceTransition;
    private CMTime leftTransitionTime;
    private CMTime overlayTime;
    private CMTime rightTransitionTime;
    private String stickerId;

    public TransitionEffectParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.effectId = "";
        this.filePath = "";
        this.stickerId = "";
        CMTime cMTime = CMTime.CMTimeZero;
        this.leftTransitionTime = cMTime;
        this.rightTransitionTime = cMTime;
        this.overlayTime = cMTime;
        this.durationTime = cMTime;
    }

    public CMTime getDurationTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (CMTime) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.durationTime;
    }

    public String getEffectId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.effectId;
    }

    public String getFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.filePath;
    }

    public CMTime getLeftTransitionTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CMTime) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.leftTransitionTime;
    }

    public CMTime getOverlayTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (CMTime) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.overlayTime;
    }

    public CMTime getRightTransitionTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (CMTime) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.rightTransitionTime;
    }

    public String getStickerId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.stickerId;
    }

    public boolean isFaceTransition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.isFaceTransition;
    }

    public void setDurationTime(CMTime cMTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) cMTime);
        } else {
            this.durationTime = cMTime;
        }
    }

    public void setEffectId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.effectId = str;
        }
    }

    public void setFaceTransition(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.isFaceTransition = z16;
        }
    }

    public void setFilePath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.filePath = str;
        }
    }

    public void setLeftTransitionTime(CMTime cMTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) cMTime);
        } else {
            this.leftTransitionTime = cMTime;
        }
    }

    public void setOverlayTime(CMTime cMTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) cMTime);
        } else {
            this.overlayTime = cMTime;
        }
    }

    public void setRightTransitionTime(CMTime cMTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) cMTime);
        } else {
            this.rightTransitionTime = cMTime;
        }
    }

    public void setStickerId(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.stickerId = str;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TransitionEffectParam m94clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (TransitionEffectParam) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        TransitionEffectParam transitionEffectParam = new TransitionEffectParam();
        transitionEffectParam.setEffectId(this.effectId);
        transitionEffectParam.setFilePath(this.filePath);
        transitionEffectParam.setStickerId(this.stickerId);
        transitionEffectParam.setLeftTransitionTime(this.leftTransitionTime);
        transitionEffectParam.setRightTransitionTime(this.rightTransitionTime);
        transitionEffectParam.setOverlayTime(this.overlayTime);
        transitionEffectParam.setFaceTransition(this.isFaceTransition);
        transitionEffectParam.setDurationTime(this.durationTime);
        return transitionEffectParam;
    }
}
