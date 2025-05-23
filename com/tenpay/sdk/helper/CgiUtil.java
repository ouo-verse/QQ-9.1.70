package com.tenpay.sdk.helper;

import com.huawei.hms.adapter.internal.CommonCode;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CgiUtil {
    public static JSONObject wrapWxSuccessCallbackData(JSONObject jSONObject, Map<String, String> map) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("send_listid", jSONObject.optString("send_listid"));
            jSONObject2.put("wx_pay_success", "0");
            jSONObject2.put(CommonCode.MapKey.TRANSACTION_ID, "");
            jSONObject2.put("pay_time", "");
            jSONObject2.put("sp_data", "");
            jSONObject2.put("callback_url", "");
            jSONObject2.put("iswechatpay", "1");
            if (map != null) {
                for (String str : map.keySet()) {
                    jSONObject2.put(str, map.get(str));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject2;
    }
}
