package org.jf.dexlib2.iface.reference;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface MethodReference extends Reference, Comparable<MethodReference> {
    @Override // java.lang.Comparable
    /* bridge */ /* synthetic */ int compareTo(@Nonnull MethodReference methodReference);

    /* JADX WARN: Can't rename method to resolve collision */
    int compareTo(@Nonnull MethodReference methodReference);

    boolean equals(@Nullable Object obj);

    @Nonnull
    String getDefiningClass();

    @Nonnull
    String getName();

    @Nonnull
    List<? extends CharSequence> getParameterTypes();

    @Nonnull
    String getReturnType();

    int hashCode();
}
