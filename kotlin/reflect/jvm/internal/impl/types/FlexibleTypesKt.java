package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class FlexibleTypesKt {
    @NotNull
    public static final FlexibleType asFlexibleType(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        Intrinsics.checkNotNull(unwrap, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (FlexibleType) unwrap;
    }

    public static final boolean isFlexible(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof FlexibleType;
    }

    @NotNull
    public static final SimpleType lowerIfFlexible(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            return ((FlexibleType) unwrap).getLowerBound();
        }
        if (unwrap instanceof SimpleType) {
            return (SimpleType) unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final SimpleType upperIfFlexible(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            return ((FlexibleType) unwrap).getUpperBound();
        }
        if (unwrap instanceof SimpleType) {
            return (SimpleType) unwrap;
        }
        throw new NoWhenBranchMatchedException();
    }
}
