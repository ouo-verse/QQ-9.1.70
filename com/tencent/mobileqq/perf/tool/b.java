package com.tencent.mobileqq.perf.tool;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u001a\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0006\u001a\u001a\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\b\u001a\u001a\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\n\u001a\u001a\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\f\u001a\u001a\u0010\u000e\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u001a\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0000\u00a8\u0006\u0010"}, d2 = {"Lorg/json/JSONObject;", "", "key", "", "default", "a", "", "b", "", "d", "", "f", "", "c", "g", "e", "QQPerf-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    @NotNull
    public static final Object a(@NotNull JSONObject jSONObject, @NotNull String key, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(obj, "default");
        if (jSONObject.has(key)) {
            Object obj2 = jSONObject.get(key);
            Intrinsics.checkNotNullExpressionValue(obj2, "get(key)");
            return obj2;
        }
        return obj;
    }

    public static final boolean b(@NotNull JSONObject jSONObject, @NotNull String key, boolean z16) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject.has(key)) {
            return jSONObject.getBoolean(key);
        }
        return z16;
    }

    public static final double c(@NotNull JSONObject jSONObject, @NotNull String key, double d16) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject.has(key)) {
            return jSONObject.getDouble(key);
        }
        return d16;
    }

    public static final int d(@NotNull JSONObject jSONObject, @NotNull String key, int i3) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject.has(key)) {
            return jSONObject.getInt(key);
        }
        return i3;
    }

    @NotNull
    public static final JSONObject e(@NotNull JSONObject jSONObject, @NotNull String key, @NotNull JSONObject jSONObject2) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(jSONObject2, "default");
        if (jSONObject.has(key)) {
            JSONObject jSONObject3 = jSONObject.getJSONObject(key);
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "getJSONObject(key)");
            return jSONObject3;
        }
        return jSONObject2;
    }

    public static final long f(@NotNull JSONObject jSONObject, @NotNull String key, long j3) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (jSONObject.has(key)) {
            return jSONObject.getLong(key);
        }
        return j3;
    }

    @NotNull
    public static final String g(@NotNull JSONObject jSONObject, @NotNull String key, @NotNull String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        if (jSONObject.has(key)) {
            String string = jSONObject.getString(key);
            Intrinsics.checkNotNullExpressionValue(string, "getString(key)");
            return string;
        }
        return str;
    }
}
