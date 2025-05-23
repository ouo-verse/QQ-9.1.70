package com.tencent.mobileqq.vas.webview.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/webview/plugin/VasTransformUtils;", "", "()V", "transformBubble", "", "callbackId", "id", "", "result", "transformFont", "transformProfileCard", "transformVipClubQueryInfo", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasTransformUtils {

    @NotNull
    public static final VasTransformUtils INSTANCE = new VasTransformUtils();

    VasTransformUtils() {
    }

    @NotNull
    public final String transformBubble(@NotNull String callbackId, int id5, @NotNull String result) {
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(result, "result");
        return callbackId + "(" + transformFont(id5, result) + ");";
    }

    @NotNull
    public final String transformFont(int id5, @NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        JSONObject jSONObject = new JSONObject();
        try {
            int optInt = new JSONObject(result).optInt("status");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", optInt);
            jSONObject.put("result", 0);
            if (optInt != 2) {
                if (optInt == 3) {
                    jSONObject.put("message", "\u4e0b\u8f7d\u5b8c\u6bd5");
                    jSONObject2.put("progress", 100);
                }
            } else {
                jSONObject.put("message", "\u4e0b\u8f7d\u4e2d");
                jSONObject2.put("progress", 0);
            }
            jSONObject2.put("id", id5);
            jSONObject.put("data", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "json.toString()");
            return jSONObject3;
        } catch (Exception unused) {
            String jSONObject4 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject4, "json.toString()");
            return jSONObject4;
        }
    }

    @NotNull
    public final String transformProfileCard(@NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        JSONObject jSONObject = new JSONObject();
        try {
            int optInt = new JSONObject(result).optInt("status");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", optInt);
            if (optInt != 2) {
                if (optInt == 3) {
                    jSONObject2.put("progress", 100);
                }
            } else {
                jSONObject2.put("progress", 0);
            }
            jSONObject.put("result", 0);
            jSONObject.put("data", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "json.toString()");
            return jSONObject3;
        } catch (Exception unused) {
            String jSONObject4 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject4, "json.toString()");
            return jSONObject4;
        }
    }

    @NotNull
    public final String transformVipClubQueryInfo(@NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", new JSONObject(result).optInt("status"));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "data.toString()");
            return jSONObject2;
        } catch (Exception unused) {
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "data.toString()");
            return jSONObject3;
        }
    }
}
