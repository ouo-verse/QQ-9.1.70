package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class KotlinTypeKt {
    public static final boolean isError(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (!(unwrap instanceof ErrorType) && (!(unwrap instanceof FlexibleType) || !(((FlexibleType) unwrap).getDelegate() instanceof ErrorType))) {
            return false;
        }
        return true;
    }

    public static final boolean isNullable(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return TypeUtils.isNullableType(kotlinType);
    }
}
