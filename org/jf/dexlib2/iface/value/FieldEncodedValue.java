package org.jf.dexlib2.iface.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.reference.FieldReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface FieldEncodedValue extends EncodedValue {
    @Override // java.lang.Comparable
    /* bridge */ /* synthetic */ int compareTo(@Nonnull EncodedValue encodedValue);

    /* JADX WARN: Can't rename method to resolve collision */
    int compareTo(@Nonnull EncodedValue encodedValue);

    boolean equals(@Nullable Object obj);

    @Nonnull
    FieldReference getValue();

    int hashCode();
}
