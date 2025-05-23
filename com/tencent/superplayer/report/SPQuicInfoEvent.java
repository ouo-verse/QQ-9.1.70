package com.tencent.superplayer.report;

import android.text.TextUtils;
import com.tencent.superplayer.utils.LogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class SPQuicInfoEvent {
    private static final String TAG = "SPQuicInfoEvent";
    private Map<String, String> data = new HashMap();
    private String eventName;

    private void doParseReportJsonContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (!TextUtils.isEmpty(jSONObject.optString(str2))) {
                    this.data.put(str2, jSONObject.optString(str2));
                }
            }
        } catch (JSONException e16) {
            LogUtil.e(TAG, "innerParseEvent exception = " + e16.toString());
        }
    }

    private void innerParseEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("report_event");
            this.eventName = optString;
            if (!TextUtils.isEmpty(optString)) {
                if (!"LightQuicConnectionStats".equals(this.eventName) && !"LightQuicTaskStats".equals(this.eventName)) {
                    if ("QuicDownaloderStats".equals(this.eventName)) {
                        doParseReportJsonContent(str);
                    }
                }
                doParseReportJsonContent(jSONObject.optString("content"));
                this.data.put("client_ip", jSONObject.optString("client_ip"));
                this.data.put("net_type", String.valueOf(jSONObject.optInt("net_type")));
            }
        } catch (JSONException e16) {
            LogUtil.e(TAG, "innerParseEvent error:" + e16.getMessage());
        }
    }

    public static SPQuicInfoEvent parseEvent(String str) {
        SPQuicInfoEvent sPQuicInfoEvent = new SPQuicInfoEvent();
        sPQuicInfoEvent.innerParseEvent(str);
        return sPQuicInfoEvent;
    }

    public Map<String, String> getDataMap() {
        return this.data;
    }

    public String getEventName() {
        return this.eventName;
    }

    public boolean needReport() {
        if (!TextUtils.isEmpty(this.eventName) && !this.data.isEmpty()) {
            return true;
        }
        return false;
    }
}
