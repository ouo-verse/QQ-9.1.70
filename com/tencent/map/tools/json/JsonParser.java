package com.tencent.map.tools.json;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes9.dex */
public interface JsonParser {

    /* loaded from: classes9.dex */
    public interface Deserializer<T> {
        T deserialize(Object obj, String str, Object obj2) throws JSONException;
    }

    void parse(JSONObject jSONObject);
}
