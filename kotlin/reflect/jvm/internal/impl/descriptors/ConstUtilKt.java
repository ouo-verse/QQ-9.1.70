package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ConstUtilKt {
    public static final boolean canBeUsedForConstVal(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (((!KotlinBuiltIns.isPrimitiveType(kotlinType) && !UnsignedTypes.isUnsignedType(kotlinType)) || TypeUtils.isNullableType(kotlinType)) && !KotlinBuiltIns.isString(kotlinType)) {
            return false;
        }
        return true;
    }
}
