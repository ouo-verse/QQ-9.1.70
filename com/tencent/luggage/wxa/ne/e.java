package com.tencent.luggage.wxa.ne;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f135742a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f135743b;

    /* renamed from: c, reason: collision with root package name */
    public JSONObject f135744c;

    public JSONObject a() {
        if (this.f135744c == null) {
            JSONObject jSONObject = new JSONObject();
            this.f135744c = jSONObject;
            jSONObject.put("uuid", this.f135742a);
            this.f135744c.put("isPrimary", this.f135743b);
        }
        return this.f135744c;
    }
}
