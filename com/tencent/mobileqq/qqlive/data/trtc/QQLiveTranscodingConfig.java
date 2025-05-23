package com.tencent.mobileqq.qqlive.data.trtc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveTranscodingConfig {
    static IPatchRedirector $redirector_ = null;
    public static final int AUDIO_CHANNEL_NUMS_DOUBLE = 2;
    public static final int AUDIO_CHANNEL_NUMS_SINGLE = 1;
    public static final int TRANS_CODING_MODE_MANUAL = 1;
    public static final int TRANS_CODING_MODE_PRESET_LAYOUT = 3;
    public static final int TRANS_CODING_MODE_PURE_AUDIO = 2;
    public static final int TRANS_CODING_MODE_SCREEN_SHARING = 4;
    public static final int TRANS_CODING_MODE_UNKNOWN = 0;
    public int appId;
    public int audioBitRate;
    public int audioChannels;
    public int audioSampleRate;
    public int backgroundColor;
    public String backgroundImage;
    public int bizId;
    public ArrayList<QQLiveMixUserConfig> mixUsers;
    public int mode;
    public String streamId;
    public int videoBitRate;
    public int videoFrameRate;
    public int videoGOP;
    public int videoHeight;
    public int videoWidth;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface AudioChannelNums {
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private QQLiveTranscodingConfig transcodingConfig;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.transcodingConfig = new QQLiveTranscodingConfig();
            }
        }

        public QQLiveTranscodingConfig build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (QQLiveTranscodingConfig) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return this.transcodingConfig;
        }

        public Builder setAppId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.transcodingConfig.appId = i3;
            return this;
        }

        public Builder setAudioBitRate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (Builder) iPatchRedirector.redirect((short) 13, (Object) this, i3);
            }
            this.transcodingConfig.audioBitRate = i3;
            return this;
        }

        public Builder setAudioChannels(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (Builder) iPatchRedirector.redirect((short) 14, (Object) this, i3);
            }
            this.transcodingConfig.audioChannels = i3;
            return this;
        }

        public Builder setAudioSampleRate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (Builder) iPatchRedirector.redirect((short) 12, (Object) this, i3);
            }
            this.transcodingConfig.audioSampleRate = i3;
            return this;
        }

        public Builder setBackgroundColor(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (Builder) iPatchRedirector.redirect((short) 10, (Object) this, i3);
            }
            this.transcodingConfig.backgroundColor = i3;
            return this;
        }

        public Builder setBackgroundImage(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (Builder) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            }
            this.transcodingConfig.backgroundImage = str;
            return this;
        }

        public Builder setBizId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            this.transcodingConfig.bizId = i3;
            return this;
        }

        public Builder setMixUsers(ArrayList<QQLiveMixUserConfig> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (Builder) iPatchRedirector.redirect((short) 15, (Object) this, (Object) arrayList);
            }
            this.transcodingConfig.mixUsers = arrayList;
            return this;
        }

        public Builder setMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.transcodingConfig.mode = i3;
            return this;
        }

        public Builder setStreamId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Builder) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            }
            this.transcodingConfig.streamId = str;
            return this;
        }

        public Builder setVideoBitrate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            this.transcodingConfig.videoBitRate = i3;
            return this;
        }

        public Builder setVideoFrameRate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, i3);
            }
            this.transcodingConfig.videoFrameRate = i3;
            return this;
        }

        public Builder setVideoGOP(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (Builder) iPatchRedirector.redirect((short) 9, (Object) this, i3);
            }
            this.transcodingConfig.videoGOP = i3;
            return this;
        }

        public Builder setVideoHeight(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            this.transcodingConfig.videoHeight = i3;
            return this;
        }

        public Builder setVideoWidth(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.transcodingConfig.videoWidth = i3;
            return this;
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface TransCodingMode {
    }

    QQLiveTranscodingConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
