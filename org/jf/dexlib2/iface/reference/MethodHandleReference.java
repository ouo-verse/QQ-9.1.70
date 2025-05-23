package org.jf.dexlib2.iface.reference;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface MethodHandleReference extends Reference, Comparable<MethodHandleReference> {
    @Override // java.lang.Comparable
    /* bridge */ /* synthetic */ int compareTo(@Nonnull MethodHandleReference methodHandleReference);

    /* JADX WARN: Can't rename method to resolve collision */
    int compareTo(@Nonnull MethodHandleReference methodHandleReference);

    boolean equals(@Nullable Object obj);

    @Nonnull
    Reference getMemberReference();

    int getMethodHandleType();

    int hashCode();
}
