package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class NullabilityChecker {

    @NotNull
    public static final NullabilityChecker INSTANCE = new NullabilityChecker();

    NullabilityChecker() {
    }

    public final boolean isSubtypeOfAny(@NotNull UnwrappedType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return AbstractNullabilityChecker.INSTANCE.hasNotNullSupertype(SimpleClassicTypeSystemContext.INSTANCE.newTypeCheckerState(false, true), FlexibleTypesKt.lowerIfFlexible(type), TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE);
    }
}
