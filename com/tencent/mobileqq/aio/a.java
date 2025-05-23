package com.tencent.mobileqq.aio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/api/runtime/a;", "", "d", "c", "b", "a", "e", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    public static final boolean a(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.g().l().getBoolean("key_is_forward_preview_aio", false);
    }

    public static final boolean b(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.g().l().getBoolean("key_is_miniaio", false);
    }

    public static final boolean c(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.g().l().getBoolean("key_is_miniaio");
    }

    public static final boolean d(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.g().l().getBoolean("key_is_scale_chat");
    }

    public static final boolean e(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        return aVar.g().l().getBoolean("key_need_show_unread_count", false);
    }
}
