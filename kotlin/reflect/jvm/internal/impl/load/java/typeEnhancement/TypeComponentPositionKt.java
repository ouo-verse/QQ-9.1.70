package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public final class TypeComponentPositionKt {
    public static final boolean shouldEnhance(@NotNull TypeComponentPosition typeComponentPosition) {
        Intrinsics.checkNotNullParameter(typeComponentPosition, "<this>");
        if (typeComponentPosition != TypeComponentPosition.INFLEXIBLE) {
            return true;
        }
        return false;
    }
}
