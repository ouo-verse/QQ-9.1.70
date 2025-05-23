package com.tencent.mobileqq.springhb.entry.model;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.ad;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MsgTabBannerData implements Serializable, a {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_MsgTabBannerData";
    public String bgUrl;
    public TimeInfo configTimeInfo;
    public String countDownText;
    public TimeInfo countDownTimeInfo;

    /* renamed from: id, reason: collision with root package name */
    public String f289095id;
    public String jumpUrl;
    public String liuhaiBgUrl;
    public int peakDelayMs;
    public boolean staggerPeakSwitch;
    public TimeInfo taskTimeInfo;
    public String text;

    public MsgTabBannerData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f289095id = "";
        this.staggerPeakSwitch = false;
        this.configTimeInfo = TimeInfo.newEmpty();
        this.taskTimeInfo = TimeInfo.newEmpty();
        this.peakDelayMs = 0;
        this.bgUrl = "";
        this.liuhaiBgUrl = "";
        this.jumpUrl = "";
        this.text = "";
        this.countDownTimeInfo = TimeInfo.newEmpty();
        this.countDownText = "";
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.f289095id.equals(((MsgTabBannerData) obj).f289095id);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.entry.model.a
    @NonNull
    public TimeInfo getConfigTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TimeInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.configTimeInfo;
    }

    public int getPeakDelayMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.peakDelayMs;
    }

    @NonNull
    public TimeInfo getTaskTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TimeInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.taskTimeInfo;
    }

    public void parseJson(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject == null) {
            return;
        }
        this.f289095id = jSONObject.optString("Id", "");
        boolean z16 = false;
        if (jSONObject.optInt("SupportStaggerPeak", 0) == 1) {
            z16 = true;
        }
        this.staggerPeakSwitch = z16;
        this.configTimeInfo.begin = ad.d(jSONObject.optString("BeginTime"));
        this.configTimeInfo.end = ad.d(jSONObject.optString("EndTime"));
        this.taskTimeInfo.copyFrom(this.configTimeInfo);
        this.bgUrl = jSONObject.optString("BgUrl", this.bgUrl);
        this.liuhaiBgUrl = jSONObject.optString("LiuhaiBgUrl", this.liuhaiBgUrl);
        this.jumpUrl = jSONObject.optString("JumpUrl", this.jumpUrl);
        this.text = jSONObject.optString("Text", this.text);
        this.countDownTimeInfo.begin = ad.d(jSONObject.optString("CountDownBeginTime"));
        this.countDownTimeInfo.end = ad.d(jSONObject.optString("CountDownEndTime"));
        this.countDownText = jSONObject.optString("CountDownText", this.countDownText);
    }

    public String toSimpleString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MsgTabBannerData{id='" + this.f289095id + "', staggerPeakSwitch=" + this.staggerPeakSwitch + ", configTimeInfo=" + this.configTimeInfo + ", taskTimeInfo=" + this.taskTimeInfo + ", peakDelayMs=" + this.peakDelayMs + '}';
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "MsgTabBannerData{id='" + this.f289095id + "', staggerPeakSwitch=" + this.staggerPeakSwitch + ", configTimeInfo=" + this.configTimeInfo + ", taskTimeInfo=" + this.taskTimeInfo + ", peakDelayMs=" + this.peakDelayMs + ", imgUrl='" + this.bgUrl + "', liuhaiBgUrl='" + this.liuhaiBgUrl + "', jumpUrl='" + this.jumpUrl + "', text='" + this.text + "', countDownTimeInfo='" + this.countDownTimeInfo + "', countDownText='" + this.countDownText + "'}";
    }
}
