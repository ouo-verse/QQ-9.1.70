package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class NameResolverUtilKt {
    @NotNull
    public static final ClassId getClassId(@NotNull NameResolver nameResolver, int i3) {
        Intrinsics.checkNotNullParameter(nameResolver, "<this>");
        ClassId fromString = ClassId.fromString(nameResolver.getQualifiedClassName(i3), nameResolver.isLocalClassName(i3));
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(getQualifiedC\u2026 isLocalClassName(index))");
        return fromString;
    }

    @NotNull
    public static final Name getName(@NotNull NameResolver nameResolver, int i3) {
        Intrinsics.checkNotNullParameter(nameResolver, "<this>");
        Name guessByFirstCharacter = Name.guessByFirstCharacter(nameResolver.getString(i3));
        Intrinsics.checkNotNullExpressionValue(guessByFirstCharacter, "guessByFirstCharacter(getString(index))");
        return guessByFirstCharacter;
    }
}
