package com.tencent.mobileqq.qne.util;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a&\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0003j\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000`\u0004*\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"", "Lorg/json/JSONObject;", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "qne-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    @Nullable
    public static final JSONObject a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return new JSONObject(str);
        } catch (JSONException e16) {
            QLog.e("String2Json", 1, "parse " + str + " to json exception", e16);
            return null;
        }
    }

    @NotNull
    public static final HashMap<String, String> b(@NotNull JSONObject jSONObject) {
        String obj;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            Object opt = jSONObject.opt(key);
            Intrinsics.checkNotNullExpressionValue(key, "key");
            if (opt != null && (obj = opt.toString()) != null) {
                hashMap.put(key, obj);
            }
        }
        return hashMap;
    }
}
