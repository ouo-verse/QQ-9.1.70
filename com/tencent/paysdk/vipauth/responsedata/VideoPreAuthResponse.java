package com.tencent.paysdk.vipauth.responsedata;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.io.Serializable;

/* loaded from: classes22.dex */
public class VideoPreAuthResponse implements Serializable {
    static IPatchRedirector $redirector_;

    @SerializedName("pay_state")
    private boolean mPayState;

    @SerializedName("player_pay_view_merge_info")
    private PlayerPayViewMergeInfoBean mPlayerPayViewMergeInfoBean;

    @SerializedName("player_top_tips")
    private String mPlayerTopTips;

    /* loaded from: classes22.dex */
    public static class PlayerPayViewMergeInfoBean implements Serializable {
        static IPatchRedirector $redirector_;

        @SerializedName(AppConstants.Key.SHARE_REQ_AUDIO_URL)
        private String mAudioUrl;

        @SerializedName(QAdVrReportParams.ParamKey.EXPERIMENT_ID)
        private String mExperimentId;

        @SerializedName("is_auto_ad")
        private boolean mIsAutoAd;

        @SerializedName("is_not_new_hot")
        private boolean mIsNotNewBot;

        @SerializedName("open_vip_url")
        private String mOpenVipUrl;

        @SerializedName("player_payview_jsoninfo")
        private String mPlayerPayviewJsoninfo;

        @SerializedName("player_payview_url")
        private String mPlayerPayviewUrl;

        @SerializedName("player_toast_url")
        private String mToastUrl;

        @SerializedName("topbar_paybutton_url")
        private String mTopbarPaybuttonUrl;

        public PlayerPayViewMergeInfoBean() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String getAudioUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.mAudioUrl;
        }

        public String getExperimentId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return this.mExperimentId;
        }

        public boolean getIsAutoAd() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
            }
            return this.mIsAutoAd;
        }

        public boolean getIsNotNewBot() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
            }
            return this.mIsNotNewBot;
        }

        public String getOpenVipUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.mOpenVipUrl;
        }

        public String getPlayerPayviewJsoninfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.mPlayerPayviewJsoninfo;
        }

        public String getPlayerPayviewUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.mPlayerPayviewUrl;
        }

        public String getToastUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.mToastUrl;
        }

        public String getTopbarPaybuttonUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mTopbarPaybuttonUrl;
        }

        public void setAudioUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            } else {
                this.mAudioUrl = str;
            }
        }

        public void setExperimentId(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            } else {
                this.mExperimentId = str;
            }
        }

        public void setIsAutoAd(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, z16);
            } else {
                this.mIsAutoAd = z16;
            }
        }

        public void setIsNotNewBot(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, z16);
            } else {
                this.mIsNotNewBot = z16;
            }
        }

        public void setOpenVipUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            } else {
                this.mOpenVipUrl = str;
            }
        }

        public void setPlayerPayviewJsoninfo(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                this.mPlayerPayviewJsoninfo = str;
            }
        }

        public void setPlayerPayviewUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.mPlayerPayviewUrl = str;
            }
        }

        public void setTopbarPaybuttonUrl(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                this.mTopbarPaybuttonUrl = str;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (String) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            return "PlayerPayViewMergeInfoBean{mTopbarPaybuttonUrl='" + this.mTopbarPaybuttonUrl + "', mPlayerPayviewUrl='" + this.mPlayerPayviewUrl + "', mToastUrl='" + this.mToastUrl + "', mPlayerPayviewJsoninfo='" + this.mPlayerPayviewJsoninfo + "', mAudioUrl=" + this.mAudioUrl + ", mOpenVipUrl=" + this.mOpenVipUrl + ", mExperimentId=" + this.mExperimentId + ", mIsAutoAd=" + this.mIsAutoAd + ", mIsNotNewBot=" + this.mIsNotNewBot + '}';
        }
    }

    public VideoPreAuthResponse() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public PlayerPayViewMergeInfoBean getPlayerPayViewMergeInfoBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PlayerPayViewMergeInfoBean) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mPlayerPayViewMergeInfoBean;
    }

    public String getPlayerTopTips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mPlayerTopTips;
    }

    public boolean isPayState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mPayState;
    }

    public void setPayState(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mPayState = z16;
        }
    }

    public void setPlayerPayViewMergeInfoBean(PlayerPayViewMergeInfoBean playerPayViewMergeInfoBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) playerPayViewMergeInfoBean);
        } else {
            this.mPlayerPayViewMergeInfoBean = playerPayViewMergeInfoBean;
        }
    }

    public void setPlayerTopTips(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mPlayerTopTips = str;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "VideoPreAuthResponse{mPayState=" + this.mPayState + ", mPlayerTopTips='" + this.mPlayerTopTips + "', mPlayerPayViewMergeInfoBean=" + this.mPlayerPayViewMergeInfoBean + '}';
    }
}
