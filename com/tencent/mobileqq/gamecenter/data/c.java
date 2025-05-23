package com.tencent.mobileqq.gamecenter.data;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Integer> f211991a = new HashMap<>();

    public c a(String str, int i3) {
        HashMap<String, Integer> hashMap = this.f211991a;
        if (hashMap != null) {
            hashMap.put(str, Integer.valueOf(i3));
        }
        return this;
    }

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        HashMap<String, Integer> hashMap = this.f211991a;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, Integer> entry : this.f211991a.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }
}
