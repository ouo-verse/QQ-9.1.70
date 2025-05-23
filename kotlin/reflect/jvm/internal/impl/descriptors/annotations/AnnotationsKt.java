package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class AnnotationsKt {
    @NotNull
    public static final Annotations composeAnnotations(@NotNull Annotations first, @NotNull Annotations second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        if (first.isEmpty()) {
            return second;
        }
        if (!second.isEmpty()) {
            return new CompositeAnnotations(first, second);
        }
        return first;
    }
}
