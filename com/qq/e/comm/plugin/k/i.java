package com.qq.e.comm.plugin.k;

import com.qq.e.comm.plugin.base.ad.clickcomponent.ClickInfo;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class i {
    private static JSONArray a(JSONObject jSONObject) {
        if (y.a(jSONObject)) {
            return jSONObject.optJSONArray("materials");
        }
        return null;
    }

    private static boolean b(JSONArray jSONArray, int i3) {
        return !y.a(jSONArray) && i3 >= 0 && i3 < jSONArray.length();
    }

    public static String c(JSONObject jSONObject, ClickInfo.a aVar) {
        int i3;
        if (!y.a(jSONObject)) {
            return null;
        }
        if (aVar != null) {
            i3 = aVar.b();
        } else {
            i3 = Integer.MIN_VALUE;
        }
        JSONArray a16 = a(jSONObject);
        if (i3 != Integer.MIN_VALUE && b(a16, i3)) {
            JSONObject a17 = a(a16, i3);
            if (a17 == null) {
                return null;
            }
            return a17.optString("click_url");
        }
        return jSONObject.optString("rl");
    }

    public static String b(JSONObject jSONObject, ClickInfo.a aVar) {
        if (!y.a(jSONObject)) {
            return null;
        }
        int b16 = aVar != null ? aVar.b() : Integer.MIN_VALUE;
        JSONArray a16 = a(jSONObject);
        if (b16 != Integer.MIN_VALUE && b(a16, b16)) {
            JSONObject a17 = a(a16, b16);
            if (a17 != null) {
                return a17.optString("wx_mini_program_path");
            }
            return null;
        }
        return jSONObject.optString("wechat_app_path");
    }

    private static JSONObject a(JSONArray jSONArray, int i3) {
        if (y.a(jSONArray)) {
            return null;
        }
        return jSONArray.optJSONObject(i3);
    }

    public static String a(JSONObject jSONObject, ClickInfo.a aVar) {
        if (!y.a(jSONObject)) {
            return null;
        }
        int b16 = aVar != null ? aVar.b() : Integer.MIN_VALUE;
        JSONArray a16 = a(jSONObject);
        if (b16 != Integer.MIN_VALUE && b(a16, b16)) {
            JSONObject a17 = a(a16, b16);
            if (a17 != null) {
                return a17.optString(QZoneAdTianshuFeedData.KEY_SCHEMA_URL);
            }
            return null;
        }
        return jSONObject.optString("customized_invoke_url");
    }
}
