package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.internal.en;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ek implements JsonParser.Deserializer<en.a.C7029a.AbstractC7030a> {
    private static en.a.C7029a.AbstractC7030a a(Object obj) throws JSONException {
        if (obj == null || !(obj instanceof JSONObject)) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        String string = jSONObject.getString("type");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if ("Point".equalsIgnoreCase(string)) {
            return (en.a.C7029a.AbstractC7030a) JsonUtils.parseToModel(jSONObject, en.a.C7029a.d.class, new Object[0]);
        }
        if ("Points".equalsIgnoreCase(string)) {
            return (en.a.C7029a.AbstractC7030a) JsonUtils.parseToModel(jSONObject, en.a.C7029a.e.class, new Object[0]);
        }
        if ("Line".equalsIgnoreCase(string)) {
            return (en.a.C7029a.AbstractC7030a) JsonUtils.parseToModel(jSONObject, en.a.C7029a.b.class, new Object[0]);
        }
        if (!"Model".equalsIgnoreCase(string)) {
            return null;
        }
        return (en.a.C7029a.AbstractC7030a) JsonUtils.parseToModel(jSONObject, en.a.C7029a.c.class, new Object[0]);
    }

    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public final /* synthetic */ en.a.C7029a.AbstractC7030a deserialize(Object obj, String str, Object obj2) throws JSONException {
        if (obj2 == null || !(obj2 instanceof JSONObject)) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) obj2;
        String string = jSONObject.getString("type");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if ("Point".equalsIgnoreCase(string)) {
            return (en.a.C7029a.AbstractC7030a) JsonUtils.parseToModel(jSONObject, en.a.C7029a.d.class, new Object[0]);
        }
        if ("Points".equalsIgnoreCase(string)) {
            return (en.a.C7029a.AbstractC7030a) JsonUtils.parseToModel(jSONObject, en.a.C7029a.e.class, new Object[0]);
        }
        if ("Line".equalsIgnoreCase(string)) {
            return (en.a.C7029a.AbstractC7030a) JsonUtils.parseToModel(jSONObject, en.a.C7029a.b.class, new Object[0]);
        }
        if (!"Model".equalsIgnoreCase(string)) {
            return null;
        }
        return (en.a.C7029a.AbstractC7030a) JsonUtils.parseToModel(jSONObject, en.a.C7029a.c.class, new Object[0]);
    }
}
