package com.tencent.ecommerce.biz.detail.utils;

import kotlin.Metadata;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0000\u00a8\u0006\u000b"}, d2 = {"Lorg/json/JSONObject;", "", "g", "a", "b", "f", "c", "d", "e", "", h.F, "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f {
    public static final boolean a(JSONObject jSONObject) {
        String optString = jSONObject.optString("active_id", "");
        int optInt = jSONObject.optInt("active_detail_status", 0);
        return (optString.length() > 0) && g(jSONObject) && (optInt == 1 || optInt == 2);
    }

    public static final boolean b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        return jSONObject.optInt("status", 0) == 1 && (optJSONObject = jSONObject.optJSONObject("active_info")) != null && a(optJSONObject);
    }

    public static final boolean c(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("active_discount_status", 0);
        return f(jSONObject) && (optInt == 1 || optInt == 2);
    }

    public static final boolean d(JSONObject jSONObject) {
        return f(jSONObject) && jSONObject.optInt("active_discount_status", 0) == 5;
    }

    public static final boolean e(JSONObject jSONObject) {
        JSONObject optJSONObject;
        return jSONObject.optInt("status", 0) == 1 && (optJSONObject = jSONObject.optJSONObject("active_info")) != null && d(optJSONObject);
    }

    public static final boolean f(JSONObject jSONObject) {
        return jSONObject.optInt("active_type", 0) == 2;
    }

    public static final boolean g(JSONObject jSONObject) {
        return jSONObject.optInt("active_type", 0) == 1;
    }

    public static final String h(JSONObject jSONObject) {
        String optString = jSONObject.optString("active_id", "");
        int optInt = jSONObject.optInt("active_detail_status", 0);
        JSONObject optJSONObject = jSONObject.optJSONObject("live_time_range");
        return "[activeId:" + optString + ", activeStatus:" + optInt + ", endTime:" + (optJSONObject != null ? optJSONObject.optLong("end") : 0L) + ']';
    }
}
