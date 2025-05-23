package com.tencent.mobileqq.qqlive.data.trtc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes17.dex */
public class TRTCVideoQualityParams implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<TRTCVideoQualityParams> CREATOR;
    private boolean mEnableAdjustRes;
    private int mMinVideoBitRate;
    private int mVideoBitRate;
    private int mVideoFps;
    private int mVideoResolution;
    private int mVideoResolutionMode;

    /* loaded from: classes17.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        private TRTCVideoQualityParams videoQuality;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.videoQuality = new TRTCVideoQualityParams();
            }
        }

        public TRTCVideoQualityParams build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (TRTCVideoQualityParams) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.videoQuality;
        }

        public Builder setEnableAdjustRes(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                this.videoQuality.mEnableAdjustRes = z16;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, z16);
        }

        public Builder setMinVideoBitRate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                this.videoQuality.mMinVideoBitRate = i3;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }

        public Builder setVideoBitRate(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                this.videoQuality.mVideoBitRate = i3;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }

        public Builder setVideoFps(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.videoQuality.mVideoFps = i3;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }

        public Builder setVideoResolution(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.videoQuality.mVideoResolution = i3;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }

        public Builder setVideoResolutionMode(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                this.videoQuality.mVideoResolutionMode = i3;
                return this;
            }
            return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            CREATOR = new Parcelable.Creator<TRTCVideoQualityParams>() { // from class: com.tencent.mobileqq.qqlive.data.trtc.TRTCVideoQualityParams.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public TRTCVideoQualityParams createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new TRTCVideoQualityParams(parcel) : (TRTCVideoQualityParams) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public TRTCVideoQualityParams[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new TRTCVideoQualityParams[i3] : (TRTCVideoQualityParams[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    protected TRTCVideoQualityParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mVideoResolutionMode = 1;
            this.mEnableAdjustRes = false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public int getMinVideoBitRate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.mMinVideoBitRate;
    }

    public int getVideoBitRate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mVideoBitRate;
    }

    public int getVideoFps() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mVideoFps;
    }

    public int getVideoResolution() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mVideoResolution;
    }

    public int getVideoResolutionMode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mVideoResolutionMode;
    }

    public boolean isEnableAdjustRes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mEnableAdjustRes;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "TRTCVideoQualityParams{mVideoResolution=" + this.mVideoResolution + ", mVideoFps=" + this.mVideoFps + ", mVideoBitRate=" + this.mVideoBitRate + ", mMinVideoBitRate=" + this.mMinVideoBitRate + ", mVideoResolutionMode=" + this.mVideoResolutionMode + ", mEnableAdjustRes=" + this.mEnableAdjustRes + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.mVideoResolution);
        parcel.writeInt(this.mVideoFps);
        parcel.writeInt(this.mVideoBitRate);
        parcel.writeInt(this.mMinVideoBitRate);
        parcel.writeInt(this.mVideoResolutionMode);
        parcel.writeByte(this.mEnableAdjustRes ? (byte) 1 : (byte) 0);
    }

    protected TRTCVideoQualityParams(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mVideoResolutionMode = 1;
        this.mEnableAdjustRes = false;
        this.mVideoResolution = parcel.readInt();
        this.mVideoFps = parcel.readInt();
        this.mVideoBitRate = parcel.readInt();
        this.mMinVideoBitRate = parcel.readInt();
        this.mVideoResolutionMode = parcel.readInt();
        this.mEnableAdjustRes = parcel.readByte() != 0;
    }
}
