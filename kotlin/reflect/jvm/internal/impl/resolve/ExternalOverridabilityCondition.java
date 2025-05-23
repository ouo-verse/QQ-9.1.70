package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface ExternalOverridabilityCondition {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum Contract {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum Result {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN
    }

    @NotNull
    Contract getContract();

    @NotNull
    Result isOverridable(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor);
}
