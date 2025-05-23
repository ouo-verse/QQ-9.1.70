package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class StrictEqualityTypeChecker {

    @NotNull
    public static final StrictEqualityTypeChecker INSTANCE = new StrictEqualityTypeChecker();

    StrictEqualityTypeChecker() {
    }

    public final boolean strictEqualTypes(@NotNull UnwrappedType a16, @NotNull UnwrappedType b16) {
        Intrinsics.checkNotNullParameter(a16, "a");
        Intrinsics.checkNotNullParameter(b16, "b");
        return AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(SimpleClassicTypeSystemContext.INSTANCE, a16, b16);
    }
}
