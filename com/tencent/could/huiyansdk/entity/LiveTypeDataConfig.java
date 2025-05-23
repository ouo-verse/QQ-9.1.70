package com.tencent.could.huiyansdk.entity;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LiveTypeDataConfig {
    static IPatchRedirector $redirector_;

    @SerializedName("angle_detect")
    public AngleDetectConfig angleDetectConfig;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class AngleDetectConfig {
        static IPatchRedirector $redirector_;

        @SerializedName("secondary_pitch_threshold")
        public float secondaryPitchThreshold;

        @SerializedName("secondary_roll_threshold")
        public float secondaryRollThreshold;

        @SerializedName("secondary_yaw_threshold")
        public float secondaryYawThreshold;

        public AngleDetectConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveTypeDataConfig.this);
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
    }

    public LiveTypeDataConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.angleDetectConfig = null;
        }
    }
}
