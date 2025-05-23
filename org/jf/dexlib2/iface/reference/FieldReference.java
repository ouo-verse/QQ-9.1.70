package org.jf.dexlib2.iface.reference;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface FieldReference extends Reference, Comparable<FieldReference> {
    @Override // java.lang.Comparable
    /* bridge */ /* synthetic */ int compareTo(@Nonnull FieldReference fieldReference);

    /* JADX WARN: Can't rename method to resolve collision */
    int compareTo(@Nonnull FieldReference fieldReference);

    boolean equals(@Nullable Object obj);

    @Nonnull
    String getDefiningClass();

    @Nonnull
    String getName();

    @Nonnull
    String getType();

    int hashCode();
}
