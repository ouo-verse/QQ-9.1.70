package com.tencent.ecommerce.base.ktx;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0014\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"Lorg/json/JSONObject;", "", "jsonString", "b", "label", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class e {
    public static final JSONObject a(JSONObject jSONObject, String str) {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
        if (split$default.isEmpty()) {
            return jSONObject;
        }
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            JSONObject optJSONObject = jSONObject.optJSONObject((String) it.next());
            if (optJSONObject != null) {
                jSONObject = optJSONObject;
            }
        }
        return jSONObject;
    }

    public static final JSONObject b(JSONObject jSONObject, String str) {
        if (str == null || str.length() == 0) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }
}
