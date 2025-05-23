package com.tencent.mobileqq.wink.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/ao;", "", "", "jsonStr", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ao {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ao f326683a = new ao();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/utils/ao$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends TypeToken<Map<String, ? extends String>> {
        a() {
        }
    }

    ao() {
    }

    @Nullable
    public final Map<String, String> a(@NotNull String jsonStr) {
        boolean z16;
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        if (jsonStr.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return null;
        }
        try {
            return (Map) new Gson().fromJson(jsonStr, new a().getType());
        } catch (JsonSyntaxException e16) {
            w53.b.c("WinkJsonUtils", "jsonStrToMap  e = " + e16 + " , jsonStr = " + jsonStr);
            return null;
        }
    }
}
