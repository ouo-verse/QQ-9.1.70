package com.tencent.mobileqq.qcoroutine.souce;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "", "parallelism", "a", "QCoroutine_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class d {
    @NotNull
    public static final CoroutineDispatcher a(@NotNull CoroutineDispatcher qlimitedParallelism, int i3) {
        Intrinsics.checkNotNullParameter(qlimitedParallelism, "$this$qlimitedParallelism");
        c.a(i3);
        return new LimitedDispatcher(qlimitedParallelism, i3);
    }
}
