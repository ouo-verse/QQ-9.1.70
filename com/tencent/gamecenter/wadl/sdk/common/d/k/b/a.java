package com.tencent.gamecenter.wadl.sdk.common.d.k.b;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Map<String, Object> f107177a = new HashMap();

    public void a(String str, Object obj) {
        this.f107177a.put(str, obj);
    }

    public byte[] a() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : this.f107177a.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception unused) {
            }
        }
        return jSONObject.toString().getBytes();
    }
}
