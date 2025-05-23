package com.tencent.mobileqq.springhb.entry.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DragonCardData implements Serializable {
    static IPatchRedirector $redirector_;
    public String actId;
    public long animationDuration;
    public int flappyFlag;
    public String gameAppId;
    public String guestJumpURL;

    /* renamed from: id, reason: collision with root package name */
    public int f289094id;
    public String jumpURL;
    public String keyWord;
    public int matchMode;
    public String pagResUrl;
    public String percentage;
    public int priority;
    public int source;
    public TimeInfo timeInfo;
    public String tips;
    public int triggerTimeLimit;
    public int type;
    public double unClickablePercentage;
    public long vibrateLength;
    public double vibrateMoment;

    public DragonCardData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f289094id = 0;
        this.jumpURL = "";
        this.tips = "";
        this.keyWord = "";
        this.pagResUrl = "";
        this.animationDuration = 0L;
        this.triggerTimeLimit = Integer.MAX_VALUE;
        this.percentage = "";
        this.flappyFlag = 0;
        this.timeInfo = new TimeInfo(0L, 0L);
        this.source = 0;
        this.type = 0;
        this.priority = 1;
        this.matchMode = 0;
        this.guestJumpURL = "";
        this.actId = "";
        this.vibrateMoment = -1.0d;
        this.vibrateLength = 0L;
        this.gameAppId = "";
    }

    public void parseJson(JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject == null) {
            return;
        }
        this.timeInfo.begin = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).parseTime(jSONObject.optString("BeginTime")).longValue();
        this.timeInfo.end = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).parseTime(jSONObject.optString("EndTime")).longValue();
        this.source = jSONObject.optInt("Source", this.source);
        this.type = jSONObject.optInt("Type", this.type);
        this.priority = jSONObject.optInt("Priority", this.priority);
        this.matchMode = jSONObject.optInt("MatchMode", this.matchMode);
        this.unClickablePercentage = jSONObject.optDouble("UnClickablePercentage", this.unClickablePercentage);
        this.guestJumpURL = jSONObject.optString("GuestJumpURL", this.guestJumpURL);
        this.f289094id = jSONObject.optInt("ID", this.f289094id);
        String optString = jSONObject.optString("HostJumpURL", this.jumpURL);
        this.jumpURL = optString;
        if (TextUtils.isEmpty(optString)) {
            this.jumpURL = jSONObject.optString("JumpURL", this.jumpURL);
        }
        this.actId = jSONObject.optString("ActId", this.actId);
        this.vibrateMoment = jSONObject.optDouble("VibrateMoment", this.vibrateMoment);
        this.vibrateLength = jSONObject.optLong("VibrateLengthInMill", this.vibrateLength);
        this.gameAppId = jSONObject.optString("GameAppID", this.gameAppId);
        this.tips = jSONObject.optString("Text", this.tips);
        this.keyWord = jSONObject.optString("Keyword", this.keyWord);
        this.pagResUrl = jSONObject.optString("PagResUrl", this.pagResUrl);
        this.animationDuration = jSONObject.optLong("AnimationDuration", this.animationDuration);
        this.triggerTimeLimit = jSONObject.optInt("TriggerTimeLimit", this.triggerTimeLimit);
        this.percentage = jSONObject.optString("Percentage", this.percentage);
        this.flappyFlag = jSONObject.optInt("FlappyFlag", this.flappyFlag);
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TipsData{ID=" + this.f289094id + ", jumpURL=" + this.jumpURL + ", tips=" + this.tips + ", keyWord=" + this.keyWord + ", pagResUrl=" + this.pagResUrl + ", animationDuration=" + this.animationDuration + ", triggerTimeLimit=" + this.triggerTimeLimit + ", percentage=" + this.percentage + ", flappyFlag=" + this.flappyFlag + "}";
    }
}
