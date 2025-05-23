package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface TypeWithEnhancement {
    @NotNull
    KotlinType getEnhancement();

    @NotNull
    UnwrappedType getOrigin();
}
