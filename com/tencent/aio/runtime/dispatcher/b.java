package com.tencent.aio.runtime.dispatcher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/aio/api/runtime/a;", "", "state", "", "a", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    public static final void a(@NotNull com.tencent.aio.api.runtime.a setBuildState, int i3) {
        Intrinsics.checkNotNullParameter(setBuildState, "$this$setBuildState");
        com.tencent.aio.runtime.a.a(setBuildState).q().a(i3);
    }
}
