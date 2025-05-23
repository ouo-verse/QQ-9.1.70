package com.tencent.mobileqq.springhb.entry.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.ad;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class BaseActivityData implements Serializable, a {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_BaseActivityData";

    @Nullable
    public BreathLightData breathLightData;
    public TimeInfo configTimeInfo;

    @Nullable
    public GameCenterConfigData gameCenterConfigData;

    /* renamed from: id, reason: collision with root package name */
    public String f289093id;
    public int peakDelayMs;

    @Nullable
    public PendantData pendantData;
    public int promotionId;
    public String specialVideoID;
    public String specialVideoUrl;
    public boolean staggerPeakSwitch;
    public TimeInfo taskTimeInfo;
    public int type;

    public BaseActivityData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f289093id = "";
        this.promotionId = 0;
        this.type = 0;
        this.staggerPeakSwitch = false;
        this.peakDelayMs = 0;
        this.specialVideoUrl = "";
        this.specialVideoID = "";
        this.configTimeInfo = TimeInfo.newEmpty();
        this.taskTimeInfo = TimeInfo.newEmpty();
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseActivityData baseActivityData = (BaseActivityData) obj;
        if (this.type == baseActivityData.type && this.f289093id.equals(baseActivityData.f289093id)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.springhb.entry.model.a
    @NonNull
    public TimeInfo getConfigTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TimeInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.configTimeInfo;
    }

    public String getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f289093id;
    }

    public int getPeakDelayMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.peakDelayMs;
    }

    public int getTaskAboutToOverDuration() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 0;
    }

    @NonNull
    public TimeInfo getTaskTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TimeInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.taskTimeInfo;
    }

    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.type;
    }

    public void parseJson(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.iAsync(TAG, 2, jSONObject.toString());
        }
        this.f289093id = jSONObject.optString("Id", this.f289093id);
        this.promotionId = jSONObject.optInt("PromotionId", this.promotionId);
        this.specialVideoUrl = jSONObject.optString("SpecialVideoUrl", this.specialVideoUrl);
        this.specialVideoID = jSONObject.optString("SpecialVideoID", this.specialVideoID);
        this.type = jSONObject.optInt("Type", this.type);
        boolean z16 = false;
        if (jSONObject.optInt("SupportStaggerPeak", 0) == 1) {
            z16 = true;
        }
        this.staggerPeakSwitch = z16;
        this.configTimeInfo.begin = ad.d(jSONObject.optString("BeginTime"));
        this.configTimeInfo.end = ad.d(jSONObject.optString("EndTime"));
        this.taskTimeInfo.copyFrom(this.configTimeInfo);
        this.breathLightData = BreathLightData.parseJson(jSONObject.optJSONObject("BreathLight"));
        this.pendantData = PendantData.parseJson(jSONObject.optJSONObject(AegisLogger.PENDANT));
        this.gameCenterConfigData = GameCenterConfigData.parseJson(jSONObject.optJSONObject("GameCenterConfig"));
    }

    public boolean schedulePendant() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }

    public boolean scheduleTaskAfterPeak() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    public String toSimpleString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "BaseActivityData{id='" + this.f289093id + "', promotionId=" + this.promotionId + ", type=" + com.tencent.mobileqq.springhb.b.a(this.type) + ", staggerPeakSwitch=" + this.staggerPeakSwitch + ", peakDelayMs=" + this.peakDelayMs + ", configTimeInfo=" + this.configTimeInfo + ", taskTimeInfo=" + this.taskTimeInfo + '}';
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "BaseActivityData{id='" + this.f289093id + "', promotionId=" + this.promotionId + ", type=" + com.tencent.mobileqq.springhb.b.a(this.type) + ", staggerPeakSwitch=" + this.staggerPeakSwitch + ", peakDelayMs=" + this.peakDelayMs + ", configTimeInfo=" + this.configTimeInfo + ", taskTimeInfo=" + this.taskTimeInfo + ", pendantData=" + this.pendantData + ", breathLightData=" + this.breathLightData + '}';
    }

    public void updatePeakDelay(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        PendantData pendantData = this.pendantData;
        if (pendantData != null) {
            if (pendantData.getConfigTime().begin < getTaskTime().begin) {
                pendantData.getTaskTime().begin = getTaskTime().begin;
            }
            if (!com.tencent.mobileqq.springhb.b.e(pendantData.getTaskTime())) {
                this.pendantData = null;
            }
        }
        BreathLightData breathLightData = this.breathLightData;
        if (breathLightData != null) {
            if (breathLightData.getConfigTime().begin < getTaskTime().begin) {
                breathLightData.getTaskTime().begin = getTaskTime().begin;
            }
            if (!com.tencent.mobileqq.springhb.b.e(breathLightData.getTaskTime())) {
                this.breathLightData = null;
            }
        }
    }

    public void validate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        PendantData pendantData = this.pendantData;
        if (pendantData != null && (!com.tencent.mobileqq.springhb.b.e(pendantData.getConfigTime()) || pendantData.getConfigTime().begin < getConfigTime().begin || pendantData.getConfigTime().end > getConfigTime().end)) {
            this.pendantData = null;
        }
        BreathLightData breathLightData = this.breathLightData;
        if (breathLightData != null) {
            if (!com.tencent.mobileqq.springhb.b.e(breathLightData.getConfigTime()) || breathLightData.getConfigTime().begin < getConfigTime().begin || breathLightData.getConfigTime().end > getConfigTime().end) {
                this.breathLightData = null;
            }
        }
    }
}
