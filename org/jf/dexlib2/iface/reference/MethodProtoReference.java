package org.jf.dexlib2.iface.reference;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes29.dex */
public interface MethodProtoReference extends Reference, Comparable<MethodProtoReference> {
    @Override // java.lang.Comparable
    /* bridge */ /* synthetic */ int compareTo(@Nonnull MethodProtoReference methodProtoReference);

    /* JADX WARN: Can't rename method to resolve collision */
    int compareTo(@Nonnull MethodProtoReference methodProtoReference);

    boolean equals(@Nullable Object obj);

    @Nonnull
    List<? extends CharSequence> getParameterTypes();

    @Nonnull
    String getReturnType();

    int hashCode();
}
