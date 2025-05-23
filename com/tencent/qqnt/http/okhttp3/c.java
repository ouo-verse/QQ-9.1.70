package com.tencent.qqnt.http.okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0000\u00a8\u0006\u0005"}, d2 = {"Lokhttp3/Call;", "Lcom/tencent/qqnt/http/api/b;", "b", "Lcom/tencent/qqnt/http/api/impl/c;", "a", "http_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    @Nullable
    public static final com.tencent.qqnt.http.api.impl.c a(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "<this>");
        return (com.tencent.qqnt.http.api.impl.c) call.request().tag(com.tencent.qqnt.http.api.impl.c.class);
    }

    @Nullable
    public static final com.tencent.qqnt.http.api.b b(@NotNull Call call) {
        Intrinsics.checkNotNullParameter(call, "<this>");
        return (com.tencent.qqnt.http.api.b) call.request().tag(com.tencent.qqnt.http.api.b.class);
    }
}
