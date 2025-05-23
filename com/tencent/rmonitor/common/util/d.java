package com.tencent.rmonitor.common.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/rmonitor/common/util/d;", "", "Lorg/json/JSONObject;", "jsonObject", "", "key", "a", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f365537a = new d();

    d() {
    }

    @NotNull
    public final String a(@Nullable JSONObject jsonObject, @NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (jsonObject != null) {
            String optString = jsonObject.optString(key);
            Intrinsics.checkExpressionValueIsNotNull(optString, "it.optString(key)");
            return optString;
        }
        return "";
    }
}
