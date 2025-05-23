package com.tencent.mobileqq.matchfriend.reborn.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\u001a&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u001a \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000*\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u0014\u0010\f\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\t\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"T", "Lorg/json/JSONObject;", "", "parseKey", "", "", "d", "", "c", "key", "a", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "b", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {
    public static final Integer a(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return Integer.valueOf(jSONObject.getInt(key));
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String b(JSONObject jSONObject, String key) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return jSONObject.getString(key);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final <T> List<T> c(JSONObject jSONObject, String parseKey) {
        JSONArray optJSONArray;
        Intrinsics.checkNotNullParameter(parseKey, "parseKey");
        try {
            ArrayList arrayList = new ArrayList();
            if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(parseKey)) == null) {
                return arrayList;
            }
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(optJSONArray.get(i3));
            }
            return arrayList;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static final <T> Map<Integer, T> d(JSONObject jSONObject, String parseKey) {
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(parseKey, "parseKey");
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject(parseKey)) == null) {
                return linkedHashMap;
            }
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Object obj = optJSONObject.get(key);
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(Integer.valueOf(Integer.parseInt(key)), obj);
            }
            return linkedHashMap;
        } catch (Exception unused) {
            return new LinkedHashMap();
        }
    }
}
