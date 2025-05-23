package com.tencent.mobileqq.qqlive.data.trtc;

import androidx.annotation.IntRange;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveMixUserConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int MIX_INPUT_TYPE_AUDIO_VIDEO = 1;
    public static final int MIX_INPUT_TYPE_PURE_AUDIO = 3;
    public static final int MIX_INPUT_TYPE_PURE_VIDEO = 2;
    public static final int MIX_INPUT_TYPE_UNDEFINED = 0;
    public static final int VIDEO_STREAM_TYPE_BIG = 0;
    public static final int VIDEO_STREAM_TYPE_SMALL = 1;
    public static final int VIDEO_STREAM_TYPE_SUB = 2;
    public int height;
    public int inputType;
    public boolean pureAudio;
    public String roomId;
    public int streamType;
    public String userId;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f271216x;

    /* renamed from: y, reason: collision with root package name */
    public int f271217y;
    public int zOrder;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private QQLiveMixUserConfig mixUserConfig;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.mixUserConfig = new QQLiveMixUserConfig();
            }
        }

        public QQLiveMixUserConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (QQLiveMixUserConfig) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.mixUserConfig;
        }

        public Builder setHeight(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            this.mixUserConfig.height = i3;
            return this;
        }

        public Builder setInputType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, i3);
            }
            this.mixUserConfig.inputType = i3;
            return this;
        }

        public Builder setPureAudio(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, z16);
            }
            this.mixUserConfig.pureAudio = z16;
            return this;
        }

        public Builder setRoomId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            }
            this.mixUserConfig.roomId = str;
            return this;
        }

        public Builder setStreamType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.mixUserConfig.streamType = i3;
            return this;
        }

        public Builder setUserId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.mixUserConfig.userId = str;
            return this;
        }

        public Builder setWidth(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.mixUserConfig.width = i3;
            return this;
        }

        public Builder setX(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.mixUserConfig.f271216x = i3;
            return this;
        }

        public Builder setY(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.mixUserConfig.f271217y = i3;
            return this;
        }

        public Builder setZOrder(@IntRange(from = 1, to = 15) int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            this.mixUserConfig.zOrder = i3;
            return this;
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface MixInputType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface VideoStreamType {
    }

    QQLiveMixUserConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
