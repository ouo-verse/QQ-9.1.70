package com.tencent.paysdk.vipauth.responsedata;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DefinitionAuthResponse {
    static IPatchRedirector $redirector_;

    @SerializedName("open_vip_url")
    private String mOpenVipUrl;

    @SerializedName("pay_info_status")
    private int mPayInfoStatus;

    @SerializedName("pay_toast")
    private String mPayToast;

    @SerializedName("pc_window_type")
    private int mPcWindowType;

    @SerializedName("pc_window_url")
    private String mPcWindowUrl;

    @SerializedName("video_info")
    private VideoInfo mVideoInfo;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class VideoInfo {
        static IPatchRedirector $redirector_;

        @SerializedName("audioCodeKey")
        private String mAudioCodeKey;

        @SerializedName("cid")
        private String mCid;

        @SerializedName("definitionKey")
        private String mDefinitionKey;

        @SerializedName("vid")
        private String mVid;

        public VideoInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String getAudioCodeKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.mAudioCodeKey;
        }

        public String getCid() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.mCid;
        }

        public String getDefinitionKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.mDefinitionKey;
        }

        public String getVid() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mVid;
        }

        public void setAudioCodeKey(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                this.mAudioCodeKey = str;
            }
        }

        public void setCid(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.mCid = str;
            }
        }

        public void setDefinitionKey(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                this.mDefinitionKey = str;
            }
        }

        public void setVid(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.mVid = str;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "VideoInfo{mVid='" + this.mVid + "', mCid='" + this.mCid + "', mDefinitionKey='" + this.mDefinitionKey + "', mAudioCodeKey='" + this.mAudioCodeKey + "'}";
        }
    }

    public DefinitionAuthResponse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String getOpenVipUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mOpenVipUrl;
    }

    public int getPayInfoStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mPayInfoStatus;
    }

    public String getPayToast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mPayToast;
    }

    public int getPcWindowType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.mPcWindowType;
    }

    public String getPcWindowUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mPcWindowUrl;
    }

    public VideoInfo getVideoInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (VideoInfo) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mVideoInfo;
    }

    public void setOpenVipUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mOpenVipUrl = str;
        }
    }

    public void setPayInfoStatus(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.mPayInfoStatus = i3;
        }
    }

    public void setPayToast(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mPayToast = str;
        }
    }

    public void setPcWindowType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.mPcWindowType = i3;
        }
    }

    public void setPcWindowUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.mPcWindowUrl = str;
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) videoInfo);
        } else {
            this.mVideoInfo = videoInfo;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "DefinitionAuthResponse{mVideoInfo=" + this.mVideoInfo + ", mPayInfoStatus=" + this.mPayInfoStatus + ", mPcWindowUrl='" + this.mPcWindowUrl + "', mPcWindowType=" + this.mPcWindowType + ", mOpenVipUrl='" + this.mOpenVipUrl + "', mPayToast='" + this.mPayToast + "'}";
    }
}
