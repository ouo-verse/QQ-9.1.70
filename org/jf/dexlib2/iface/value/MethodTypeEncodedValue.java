package org.jf.dexlib2.iface.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.reference.MethodProtoReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface MethodTypeEncodedValue extends EncodedValue {
    @Override // java.lang.Comparable
    /* bridge */ /* synthetic */ int compareTo(@Nonnull EncodedValue encodedValue);

    /* JADX WARN: Can't rename method to resolve collision */
    int compareTo(@Nonnull EncodedValue encodedValue);

    boolean equals(@Nullable Object obj);

    @Nonnull
    MethodProtoReference getValue();

    int hashCode();
}
