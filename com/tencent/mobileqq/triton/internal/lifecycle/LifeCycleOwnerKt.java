package com.tencent.mobileqq.triton.internal.lifecycle;

import com.tencent.mobileqq.triton.lifecycle.LifeCycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u00a8\u0006\u0005"}, d2 = {"observe", "", "Lcom/tencent/mobileqq/triton/lifecycle/LifeCycle;", "owner", "Lcom/tencent/mobileqq/triton/internal/lifecycle/LifeCycleOwner;", "Triton_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class LifeCycleOwnerKt {
    public static final void observe(@NotNull LifeCycle observe, @NotNull LifeCycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(observe, "$this$observe");
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        owner.observeLifeCycle(observe);
    }
}
