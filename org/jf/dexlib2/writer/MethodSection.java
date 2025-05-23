package org.jf.dexlib2.writer;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.reference.MethodProtoReference;
import org.jf.dexlib2.iface.reference.MethodReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface MethodSection<StringKey, TypeKey, ProtoRefKey extends MethodProtoReference, MethodRefKey extends MethodReference, MethodKey> extends IndexSection<MethodRefKey> {
    @Nonnull
    TypeKey getDefiningClass(@Nonnull MethodRefKey methodrefkey);

    int getMethodIndex(@Nonnull MethodKey methodkey);

    @Nonnull
    MethodRefKey getMethodReference(@Nonnull MethodKey methodkey);

    @Nonnull
    StringKey getName(@Nonnull MethodRefKey methodrefkey);

    @Nonnull
    ProtoRefKey getPrototype(@Nonnull MethodKey methodkey);

    @Nonnull
    ProtoRefKey getPrototype(@Nonnull MethodRefKey methodrefkey);
}
