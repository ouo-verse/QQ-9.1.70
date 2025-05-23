package com.tencent.android.androidbypass.richui.utils;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000\u00a8\u0006\u0006"}, d2 = {"Lorg/json/JSONObject;", "other", "", "a", "dataJson", "b", "bypass_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class c {
    public static final void a(@NotNull JSONObject combine, @NotNull JSONObject other) {
        Intrinsics.checkNotNullParameter(combine, "$this$combine");
        Intrinsics.checkNotNullParameter(other, "other");
        Iterator keys = other.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = other.get(str);
            if (!combine.has(str)) {
                combine.put(str, obj);
            } else if (obj instanceof JSONObject) {
                JSONObject originObject = combine.getJSONObject(str);
                Intrinsics.checkNotNullExpressionValue(originObject, "originObject");
                a(originObject, (JSONObject) obj);
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = combine.getJSONArray(str);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject originObject2 = jSONArray.getJSONObject(i3);
                    JSONObject otherObject = ((JSONArray) obj).getJSONObject(i3);
                    Intrinsics.checkNotNullExpressionValue(originObject2, "originObject");
                    Intrinsics.checkNotNullExpressionValue(otherObject, "otherObject");
                    a(originObject2, otherObject);
                }
            }
        }
    }

    public static final void b(@NotNull JSONObject replacePlaceHolder, @NotNull JSONObject dataJson) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(replacePlaceHolder, "$this$replacePlaceHolder");
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        Iterator keys = replacePlaceHolder.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = replacePlaceHolder.get(str);
            if (obj instanceof String) {
                String str2 = (String) obj;
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str2, "data_", false, 2, null);
                if (startsWith$default) {
                    Object opt = dataJson.opt(str2);
                    if (opt != null) {
                        replacePlaceHolder.put(str, opt);
                    }
                }
            }
            if (obj instanceof JSONObject) {
                b((JSONObject) obj, dataJson);
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        b(optJSONObject, dataJson);
                    }
                }
            }
        }
    }
}
