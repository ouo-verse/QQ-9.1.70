package org.jf.dexlib2.writer;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.reference.FieldReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface FieldSection<StringKey, TypeKey, FieldRefKey extends FieldReference, FieldKey> extends IndexSection<FieldRefKey> {
    @Nonnull
    TypeKey getDefiningClass(@Nonnull FieldRefKey fieldrefkey);

    int getFieldIndex(@Nonnull FieldKey fieldkey);

    @Nonnull
    TypeKey getFieldType(@Nonnull FieldRefKey fieldrefkey);

    @Nonnull
    StringKey getName(@Nonnull FieldRefKey fieldrefkey);
}
