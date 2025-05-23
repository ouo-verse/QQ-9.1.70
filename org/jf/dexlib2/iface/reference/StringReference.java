package org.jf.dexlib2.iface.reference;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface StringReference extends Reference, CharSequence, Comparable<CharSequence> {
    int compareTo(@Nonnull CharSequence charSequence);

    /* bridge */ /* synthetic */ int compareTo(@Nonnull Object obj);

    boolean equals(@Nullable Object obj);

    @Nonnull
    String getString();

    int hashCode();
}
