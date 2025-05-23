package com.tencent.mobileqq.guild.util;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class bm {
    public static String a(JSONArray jSONArray, String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (str.equals(jSONObject.optString("bytes_name"))) {
                return jSONObject.optString("bytes_value");
            }
            if (QLog.isColorLevel()) {
                QLog.d("Guild.comm.EmotionReplyAction", 2, "result:" + jSONObject.optString("bytes_value"));
            }
        }
        return "";
    }
}
