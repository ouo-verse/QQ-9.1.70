package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface JvmTypeFactory<T> {
    @NotNull
    T boxType(@NotNull T t16);

    @NotNull
    T createFromString(@NotNull String str);

    @NotNull
    T createObjectType(@NotNull String str);

    @NotNull
    T createPrimitiveType(@NotNull PrimitiveType primitiveType);

    @NotNull
    T getJavaLangClassType();

    @NotNull
    String toString(@NotNull T t16);
}
