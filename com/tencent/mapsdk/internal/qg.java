package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class qg implements JsonParser {

    /* renamed from: a, reason: collision with root package name */
    public boolean f149799a;

    /* renamed from: b, reason: collision with root package name */
    public List<qi> f149800b;

    private boolean a() {
        return this.f149799a;
    }

    private List<qi> b() {
        return this.f149800b;
    }

    @Override // com.tencent.map.tools.json.JsonParser
    public void parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean z16 = true;
            if (jSONObject.optInt("enable", 0) != 1) {
                z16 = false;
            }
            this.f149799a = z16;
            JSONArray optJSONArray = jSONObject.optJSONArray("layers");
            if (optJSONArray != null) {
                this.f149800b = JsonUtils.parseToList(optJSONArray, qi.class, new Object[0]);
            }
        }
    }
}
