package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class HianalyticsBaseData {
    public static final String EVENT_ID = "url_request";
    public static final String SDK_NAME = "sdk_name";
    public static final String SDK_TYPE = "sdk_type";
    public static final String SDK_VERSION = "sdk_version";
    private static final String TAG = "HianalyticsBaseData";
    private LinkedHashMap<String, String> data;

    public HianalyticsBaseData() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        this.data = linkedHashMap;
        linkedHashMap.put(SDK_TYPE, "UxPP");
        this.data.put(SDK_NAME, "networkkit");
    }

    public LinkedHashMap<String, String> get() {
        return this.data;
    }

    public HianalyticsBaseData put(String str, String str2) {
        if (str != null && str2 != null) {
            this.data.put(str, str2);
        } else {
            Logger.v(TAG, "key = " + str + " : value = " + str2);
        }
        return this;
    }

    public HianalyticsBaseData putIfNotDefault(String str, long j3, long j16) {
        if (j3 == j16) {
            return this;
        }
        return put(str, j3);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : get().entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e16) {
            Logger.w(TAG, "catch JSONException", e16);
        }
        return jSONObject.toString();
    }

    public HianalyticsBaseData put(String str, long j3) {
        if (str == null) {
            Logger.v(TAG, "key = null : value = " + j3);
        } else {
            this.data.put(str, "" + j3);
        }
        return this;
    }

    public HianalyticsBaseData put(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            this.data.putAll(linkedHashMap);
        } else {
            Logger.v(TAG, "data is null");
        }
        return this;
    }
}
