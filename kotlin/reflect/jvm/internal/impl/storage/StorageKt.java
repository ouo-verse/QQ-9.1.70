package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class StorageKt {
    @NotNull
    public static final <T> T getValue(@NotNull NotNullLazyValue<? extends T> notNullLazyValue, @Nullable Object obj, @NotNull KProperty<?> p16) {
        Intrinsics.checkNotNullParameter(notNullLazyValue, "<this>");
        Intrinsics.checkNotNullParameter(p16, "p");
        return notNullLazyValue.invoke();
    }

    @Nullable
    public static final <T> T getValue(@NotNull NullableLazyValue<? extends T> nullableLazyValue, @Nullable Object obj, @NotNull KProperty<?> p16) {
        Intrinsics.checkNotNullParameter(nullableLazyValue, "<this>");
        Intrinsics.checkNotNullParameter(p16, "p");
        return nullableLazyValue.invoke();
    }
}
