package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u000b\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\f\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\r\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u000f"}, d2 = {"Lorg/json/JSONObject;", "", "a", "", tl.h.F, "", "g", "c", "d", "f", "e", "b", "i", "k", "j", "qcircle-plugin-module_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class j {
    public static final boolean a(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        long serverTime = NetConnInfoCenter.getServerTime();
        if (g(jSONObject) <= serverTime && serverTime <= c(jSONObject)) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String b(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String optString = jSONObject.optString("button_image_url");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"button_image_url\")");
        return optString;
    }

    public static final long c(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return jSONObject.optLong("end_time");
    }

    @NotNull
    public static final String d(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String optString = jSONObject.optString("image_url");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"image_url\")");
        return optString;
    }

    @NotNull
    public static final String e(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String optString = jSONObject.optString("mask_link");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"mask_link\")");
        return optString;
    }

    @NotNull
    public static final String f(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String optString = jSONObject.optString("pag_video_url");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"pag_video_url\")");
        return optString;
    }

    public static final long g(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        return jSONObject.optLong("start_time");
    }

    @NotNull
    public static final String h(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String optString = jSONObject.optString("task_id");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"task_id\")");
        return optString;
    }

    @NotNull
    public static final String i(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String optString = jSONObject.optString("button_link");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"button_link\")");
        return optString;
    }

    @NotNull
    public static final String j(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String optString = jSONObject.optString("cover_res_path", "");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(QFSPublicAccou\u2026stant.COVER_RES_PATH, \"\")");
        return optString;
    }

    @NotNull
    public static final String k(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        String optString = jSONObject.optString("pag_res_path", "");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(QFSPublicAccou\u2026onstant.PAG_RES_PATH, \"\")");
        return optString;
    }
}
