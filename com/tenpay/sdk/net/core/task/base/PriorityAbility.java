package com.tenpay.sdk.net.core.task.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0000H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/net/core/task/base/PriorityAbility;", "", "compareTo", "", "other", "getPriority", "Lcom/tenpay/sdk/net/core/task/base/Priority;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface PriorityAbility extends Comparable<PriorityAbility> {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class DefaultImpls {
        public static int compareTo(@NotNull PriorityAbility priorityAbility, @NotNull PriorityAbility other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return other.getPriority().getValue() - priorityAbility.getPriority().getValue();
        }
    }

    int compareTo(@NotNull PriorityAbility other);

    @NotNull
    Priority getPriority();
}
