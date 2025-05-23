package com.qzone.util;

import com.tencent.ark.ark;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a.\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00072\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"", "obj", "", "a", "", ark.ARKMETADATA_JSON, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class r {
    public static final boolean a(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (!(key instanceof String) || !(value instanceof String)) {
                return false;
            }
        }
        return true;
    }

    public static final HashMap<String, String> b(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        try {
            JSONObject jSONObject = new JSONObject(json);
            HashMap<String, String> hashMap = new HashMap<>();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                String optString = jSONObject.optString(key);
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(key)");
                hashMap.put(key, optString);
            }
            return hashMap;
        } catch (JSONException e16) {
            QLog.e("MapUtils", 1, e16, new Object[0]);
            return null;
        }
    }
}
