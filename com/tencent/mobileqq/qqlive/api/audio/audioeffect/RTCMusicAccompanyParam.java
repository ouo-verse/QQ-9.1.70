package com.tencent.mobileqq.qqlive.api.audio.audioeffect;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class RTCMusicAccompanyParam {
    static IPatchRedirector $redirector_;
    private String mDubFilePath;
    private String mOriginFilePath;
    private float mProgressIntervalSec;

    /* loaded from: classes17.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private String mDubFilePath;
        private String mOriginFilePath;
        private float mProgressIntervalSec;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mProgressIntervalSec = 1.0f;
            }
        }

        public RTCMusicAccompanyParam build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (RTCMusicAccompanyParam) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return new RTCMusicAccompanyParam(this);
        }

        public Builder dubFilePath(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.mDubFilePath = str;
            return this;
        }

        public Builder originFilePath(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.mOriginFilePath = str;
            return this;
        }

        public Builder progressIntervalSec(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
            }
            this.mProgressIntervalSec = f16;
            return this;
        }
    }

    RTCMusicAccompanyParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.mProgressIntervalSec = 1.0f;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public String getDubFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mDubFilePath;
    }

    public String getOriginFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mOriginFilePath;
    }

    public float getProgressIntervalSec() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.mProgressIntervalSec;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return "MusicAccompanyParam{orig=(" + this.mOriginFilePath + "),dub=(" + this.mDubFilePath + ")}";
    }

    RTCMusicAccompanyParam(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) builder);
            return;
        }
        this.mProgressIntervalSec = 1.0f;
        this.mOriginFilePath = builder.mOriginFilePath;
        this.mDubFilePath = builder.mDubFilePath;
        this.mProgressIntervalSec = builder.mProgressIntervalSec;
    }
}
