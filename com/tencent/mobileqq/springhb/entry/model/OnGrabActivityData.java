package com.tencent.mobileqq.springhb.entry.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.common.api.AegisLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class OnGrabActivityData extends BaseActivityData {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_OnGrabActivityData";
    public AnimConfigData animConfigData;
    public String bgAudioUrl;
    public String bgUrl;
    public String comboViewType;
    public String endWording;
    public String grabWording;
    public int playDuration;
    public PreviewEntryData previewEntryData;
    public String progressBrandImgUrl;
    public Share shareData;
    public String shuaAnimationResUrl;
    public String startWording;
    public String tipBarWording;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class Share implements Serializable {
        static IPatchRedirector $redirector_;
        public String bottomWording;
        public boolean isZplanJump;
        public String jumpText;
        public String jumpUrl;
        public String logoImgUrl;
        public String merchantName;
        public String qrImgUrl;
        public String shareButtonText;
        public List<Integer> shareLevelList;
        public String title;
        public String zplanButtonText;

        public Share() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.logoImgUrl = "";
            this.qrImgUrl = "";
            this.title = "";
            this.merchantName = "";
            this.bottomWording = "";
            this.shareLevelList = null;
            this.isZplanJump = false;
            this.jumpUrl = "";
            this.jumpText = "";
            this.shareButtonText = "";
            this.zplanButtonText = "";
        }

        void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.logoImgUrl = jSONObject.optString("LogoImgUrl", this.logoImgUrl);
            this.qrImgUrl = jSONObject.optString("QRImgUrl", this.qrImgUrl);
            this.title = jSONObject.optString("Title", this.title);
            this.bottomWording = jSONObject.optString("BottomWording", this.bottomWording);
            this.merchantName = jSONObject.optString("MerchantName", this.merchantName);
            JSONArray optJSONArray = jSONObject.optJSONArray("ShareLevelList");
            boolean z16 = false;
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add(Integer.valueOf(optJSONArray.optInt(i3)));
                }
                if (arrayList.size() == 4) {
                    this.shareLevelList = arrayList;
                }
            }
            this.jumpUrl = jSONObject.optString("JumpUrl", this.jumpUrl);
            this.jumpText = jSONObject.optString("JumpText", this.jumpText);
            this.shareButtonText = jSONObject.optString("ShareButtonText", this.shareButtonText);
            this.zplanButtonText = jSONObject.optString("ZplanButtonText", this.zplanButtonText);
            if (jSONObject.optInt("IsZplanJump", 0) == 1) {
                z16 = true;
            }
            this.isZplanJump = z16;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "Share{logoImgUrl='" + this.logoImgUrl + "', qrImgUrl='" + this.qrImgUrl + "', bottomWording='" + this.bottomWording + "'}";
        }
    }

    public OnGrabActivityData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.playDuration = 30;
        this.tipBarWording = "";
        this.grabWording = "";
        this.startWording = "";
        this.endWording = "";
        this.progressBrandImgUrl = "";
        this.bgAudioUrl = "";
        this.bgUrl = "";
        this.shuaAnimationResUrl = "";
        this.shareData = new Share();
        this.previewEntryData = new PreviewEntryData();
        this.animConfigData = new AnimConfigData();
        this.comboViewType = "";
    }

    @Override // com.tencent.mobileqq.springhb.entry.model.BaseActivityData
    public int getTaskAboutToOverDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.playDuration;
    }

    @Override // com.tencent.mobileqq.springhb.entry.model.BaseActivityData
    public void parseJson(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject == null) {
            return;
        }
        super.parseJson(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("GrabActivity");
        if (optJSONObject != null) {
            this.playDuration = optJSONObject.optInt("PlayDuration", this.playDuration);
            this.tipBarWording = optJSONObject.optString("TipBarWording", this.tipBarWording);
            this.grabWording = optJSONObject.optString("GrabWording", this.grabWording);
            this.startWording = optJSONObject.optString("StartWording", this.startWording);
            this.endWording = optJSONObject.optString("EndWording", this.endWording);
            this.progressBrandImgUrl = optJSONObject.optString("ProgressBrandImgUrl", this.progressBrandImgUrl);
            this.bgAudioUrl = optJSONObject.optString("spring_shua_background_audio", this.bgAudioUrl);
            String optString = optJSONObject.optString("BgUrl", this.bgUrl);
            this.bgUrl = optString;
            this.shuaAnimationResUrl = optJSONObject.optString("ShuaAnimationResUrl", optString);
            this.comboViewType = optJSONObject.optString("ComboViewType", this.comboViewType);
            this.shareData.parseJson(optJSONObject.optJSONObject(AegisLogger.SHARE));
            this.previewEntryData.parseJson(optJSONObject.optJSONObject("PreviewEntry"));
            this.animConfigData.parseJson(optJSONObject.optJSONObject("AnimConfigData"));
        }
    }

    @Override // com.tencent.mobileqq.springhb.entry.model.BaseActivityData
    public boolean schedulePendant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.springhb.entry.model.BaseActivityData
    public boolean scheduleTaskAfterPeak() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.entry.model.BaseActivityData
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "OnGrabActivityData{superData=" + super.toString() + ", playDuration=" + this.playDuration + ", tipBarWording='" + this.tipBarWording + "', grabWording='" + this.grabWording + "', bgUrl='" + this.bgUrl + "', shareData=" + this.shareData + ", previewEntryData=" + this.previewEntryData + ", animConfigData=" + this.animConfigData + '}';
    }
}
