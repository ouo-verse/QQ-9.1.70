package com.tencent.mobileqq.springhb.entry.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import cooperation.qzone.QZoneClickReport;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DragonCardConfigData implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_DragonCardConfigData";
    public Map<String, DragonCardData> animationItems;
    public long businessID;
    private Map<String, DragonCardData> dragonCardDataMap;
    public boolean isSupportChildrenMode;
    public TimeInfo timeInfo;
    public long timeInterval;
    public long totalTimeInterval;
    public long totalTriggerLimit;
    public long totalTriggerLimitPerDay;
    public long triggerLimit;
    public long triggerLimitPerDay;

    public DragonCardConfigData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.timeInterval = 0L;
        this.businessID = 0L;
        this.triggerLimitPerDay = TTL.MAX_VALUE;
        this.triggerLimit = TTL.MAX_VALUE;
        this.totalTimeInterval = 0L;
        this.totalTriggerLimitPerDay = TTL.MAX_VALUE;
        this.totalTriggerLimit = TTL.MAX_VALUE;
        this.isSupportChildrenMode = true;
        this.timeInfo = new TimeInfo(0L, 0L);
        this.dragonCardDataMap = new HashMap();
        this.animationItems = new HashMap();
    }

    private String a(@Nullable String str, int i3) {
        return str + "_" + i3;
    }

    private void b(JSONObject jSONObject, int i3) {
        String str;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    str = "";
                } else {
                    str = "Other";
                }
            } else {
                str = "Space";
            }
        } else {
            str = QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "tryParseSubJsonObject key is null");
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                Object opt = optJSONArray.opt(i16);
                if (opt instanceof JSONObject) {
                    DragonCardData dragonCardData = new DragonCardData();
                    dragonCardData.parseJson((JSONObject) opt);
                    this.dragonCardDataMap.put(a(dragonCardData.keyWord, i3), dragonCardData);
                    if (dragonCardData.flappyFlag == 1) {
                        this.animationItems.put(dragonCardData.keyWord, dragonCardData);
                    }
                }
            }
        }
    }

    public DragonCardData getDragonCardData(@Nullable String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DragonCardData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
        return this.dragonCardDataMap.get(a(str, i3));
    }

    public void parseJson(JSONObject jSONObject) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSONObject);
            return;
        }
        if (jSONObject == null) {
            return;
        }
        this.timeInterval = jSONObject.optLong("TimeInterval", this.timeInterval);
        this.businessID = jSONObject.optLong("BusinessID", this.businessID);
        this.triggerLimitPerDay = jSONObject.optLong("TriggerLimitPerDay", this.triggerLimitPerDay);
        this.triggerLimit = jSONObject.optLong("TriggerLimit", this.triggerLimit);
        this.totalTimeInterval = jSONObject.optLong("TotalTimeInterval", this.totalTimeInterval);
        this.totalTriggerLimitPerDay = jSONObject.optLong("TotalTriggerLimitPerDay", this.totalTriggerLimitPerDay);
        this.totalTriggerLimit = jSONObject.optLong("TotalTriggerLimit", this.totalTriggerLimit);
        if (jSONObject.optInt("ChildrenMode", 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isSupportChildrenMode = z16;
        this.timeInfo.begin = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).parseTime(jSONObject.optString("BeginTime")).longValue();
        this.timeInfo.end = ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).parseTime(jSONObject.optString("EndTime")).longValue();
        b(jSONObject, 1);
        b(jSONObject, 2);
        b(jSONObject, 3);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        Iterator<DragonCardData> it = this.dragonCardDataMap.values().iterator();
        while (it.hasNext()) {
            sb5.append(it.next().toString());
            sb5.append(", ");
        }
        sb5.append("}");
        return "DragonCardConfigData{, timeInterval=" + this.timeInterval + ", beginTime=" + this.timeInfo.begin + ", endTime=" + this.timeInfo.end + ", Items='" + sb5.toString() + "}";
    }
}
