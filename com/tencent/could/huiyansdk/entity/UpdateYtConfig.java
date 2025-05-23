package com.tencent.could.huiyansdk.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class UpdateYtConfig {
    static IPatchRedirector $redirector_;
    public AngleDetectConfig angleDetectConfig;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class AngleDetectConfig {
        static IPatchRedirector $redirector_;
        public float secondaryPitchThreshold;
        public float secondaryRollThreshold;
        public float secondaryYawThreshold;

        public AngleDetectConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.secondaryYawThreshold = 30.0f;
            this.secondaryRollThreshold = 30.0f;
            this.secondaryPitchThreshold = 40.0f;
        }

        public float getSecondaryPitchThreshold() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
            }
            return this.secondaryPitchThreshold;
        }

        public float getSecondaryRollThreshold() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
            }
            return this.secondaryRollThreshold;
        }

        public float getSecondaryYawThreshold() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
            }
            return this.secondaryYawThreshold;
        }

        public void setSecondaryPitchThreshold(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            } else {
                this.secondaryPitchThreshold = f16;
            }
        }

        public void setSecondaryRollThreshold(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
            } else {
                this.secondaryRollThreshold = f16;
            }
        }

        public void setSecondaryYawThreshold(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16));
            } else {
                this.secondaryYawThreshold = f16;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "AngleDetectConfig{secondaryYawThreshold=" + this.secondaryYawThreshold + ", secondaryRollThreshold=" + this.secondaryRollThreshold + ", secondaryPitchThreshold=" + this.secondaryPitchThreshold + '}';
        }
    }

    public UpdateYtConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.angleDetectConfig = null;
        }
    }

    public AngleDetectConfig getAngleDetectConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AngleDetectConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.angleDetectConfig;
    }

    public void setAngleDetectConfig(AngleDetectConfig angleDetectConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) angleDetectConfig);
        } else {
            this.angleDetectConfig = angleDetectConfig;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.angleDetectConfig == null) {
            return "";
        }
        return "UpdateYtConfig{angleDetectConfig=" + this.angleDetectConfig.toString() + '}';
    }
}
