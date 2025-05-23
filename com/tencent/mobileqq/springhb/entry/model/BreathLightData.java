package com.tencent.mobileqq.springhb.entry.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.ad;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BreathLightData implements Serializable, a {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_BreathLightData";
    public TimeInfo configTimeInfo;
    public TimeInfo taskTimeInfo;
    public int type;

    public BreathLightData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.configTimeInfo = TimeInfo.newEmpty();
        this.taskTimeInfo = TimeInfo.newEmpty();
        this.type = 0;
    }

    @Nullable
    public static BreathLightData parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        BreathLightData breathLightData = new BreathLightData();
        breathLightData.configTimeInfo.begin = ad.d(jSONObject.optString("BeginTime"));
        breathLightData.configTimeInfo.end = ad.d(jSONObject.optString("EndTime"));
        breathLightData.taskTimeInfo.copyFrom(breathLightData.configTimeInfo);
        breathLightData.type = jSONObject.optInt("Type", breathLightData.type);
        return breathLightData;
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

    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("BreathLightData{, configTimeInfo=");
        sb5.append(this.configTimeInfo);
        sb5.append(", taskTimeInfo=");
        sb5.append(this.taskTimeInfo);
        sb5.append(", type=");
        if (this.type == 0) {
            str = "yellow";
        } else {
            str = "red";
        }
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }
}
