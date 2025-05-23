package com.tencent.mobileqq.zootopia.scene.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"Lorg/json/JSONObject;", "other", "", "a", "zplan_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    public static final boolean a(@NotNull JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        JsonObject jsonObject;
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (jSONObject2 == null) {
            return false;
        }
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "toString()");
        String jSONObject4 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject4, "other.toString()");
        JsonElement parse = new JsonParser().parse(jSONObject3);
        JsonObject jsonObject2 = null;
        if (parse instanceof JsonObject) {
            jsonObject = (JsonObject) parse;
        } else {
            jsonObject = null;
        }
        JsonElement parse2 = new JsonParser().parse(jSONObject4);
        if (parse2 instanceof JsonObject) {
            jsonObject2 = (JsonObject) parse2;
        }
        if (jsonObject == null) {
            if (jsonObject2 != null) {
                return false;
            }
            return true;
        }
        return Intrinsics.areEqual(jsonObject, jsonObject2);
    }
}
