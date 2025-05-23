package com.tencent.mobileqq.springhb.entry.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.ad;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes18.dex */
public class PendantData implements Serializable, a {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_PendantData";
    public TimeInfo configTimeInfo;
    public boolean isRedDotPendant;
    public String jumpUrl;
    public String logoUrl;
    public String pendantImgUrl;
    public boolean showCloseBtn;
    public boolean showPendantSwitch;
    public TimeInfo taskTimeInfo;
    public String zplanJumpUrl;

    public PendantData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.configTimeInfo = TimeInfo.newEmpty();
        this.taskTimeInfo = TimeInfo.newEmpty();
        this.pendantImgUrl = "";
        this.logoUrl = "";
        this.jumpUrl = "";
        this.zplanJumpUrl = "";
        this.showCloseBtn = false;
        this.showPendantSwitch = false;
        this.isRedDotPendant = false;
    }

    public static PendantData newEmpty() {
        return new PendantData();
    }

    @Nullable
    public static PendantData parseJson(@Nullable JSONObject jSONObject) {
        boolean z16;
        if (jSONObject == null) {
            return null;
        }
        PendantData pendantData = new PendantData();
        pendantData.configTimeInfo.begin = ad.d(jSONObject.optString("BeginTime"));
        pendantData.configTimeInfo.end = ad.d(jSONObject.optString("EndTime"));
        pendantData.taskTimeInfo.copyFrom(pendantData.configTimeInfo);
        pendantData.pendantImgUrl = jSONObject.optString("PendantImgUrl", pendantData.pendantImgUrl);
        pendantData.jumpUrl = jSONObject.optString("JumpUrl", pendantData.jumpUrl);
        pendantData.zplanJumpUrl = jSONObject.optString("ZplanJumpUrl", pendantData.zplanJumpUrl);
        boolean z17 = false;
        if (jSONObject.optInt("ShowCloseBtn", 0) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        pendantData.showCloseBtn = z16;
        if (jSONObject.optInt("ShowPendantSwitch", 0) == 1) {
            z17 = true;
        }
        pendantData.showPendantSwitch = z17;
        return pendantData;
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
        return 0;
    }

    @NonNull
    public TimeInfo getTaskTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TimeInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.taskTimeInfo;
    }

    public String toSimpleString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "PendantData{, configTimeInfo=" + this.configTimeInfo + ", taskTimeInfo=" + this.taskTimeInfo + ", showPendantSwitch=" + this.showPendantSwitch + '}';
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "PendantData{, configTimeInfo=" + this.configTimeInfo + ", taskTimeInfo=" + this.taskTimeInfo + ", showPendantSwitch=" + this.showPendantSwitch + ", pendantImgUrl='" + this.pendantImgUrl + "', logoUrl='" + this.logoUrl + "', jumpUrl='" + this.jumpUrl + "'}";
    }
}
