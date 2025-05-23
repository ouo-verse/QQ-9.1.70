package com.tencent.qqnt.kernel.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/kernel/utils/c;", "T", "Lkotlin/Function0;", "initializer", "Lcom/tencent/qqnt/kernel/utils/d;", "a", "kernel_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e {
    @NotNull
    public static final <T extends c> d<T> a(@NotNull Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new ClearableLazyImpl(initializer, null, 2, null);
    }
}
