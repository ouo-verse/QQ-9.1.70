package com.tencent.mobileqq.richmediabrowser.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    public static List<c> a(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("LiuHaiArray")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("LiuHaiArray");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        c cVar = new c();
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        if (jSONObject2.has("manufacturer")) {
                            cVar.f281802a = jSONObject2.optString("manufacturer", "");
                        }
                        if (jSONObject2.has("brand")) {
                            cVar.f281803b = jSONObject2.optString("brand", "");
                        }
                        if (jSONObject2.has("model")) {
                            cVar.f281804c = jSONObject2.optString("model", "");
                        }
                        arrayList.add(cVar);
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("ListConfigParseUtils", 2, "parseWhiteListConfig exception = " + e16.getMessage());
                }
            }
        }
        return arrayList;
    }
}
