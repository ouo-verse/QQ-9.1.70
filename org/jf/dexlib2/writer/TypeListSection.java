package org.jf.dexlib2.writer;

import java.util.Collection;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface TypeListSection<TypeKey, TypeListKey> extends NullableOffsetSection<TypeListKey> {
    @Override // org.jf.dexlib2.writer.NullableOffsetSection
    int getNullableItemOffset(@Nullable TypeListKey typelistkey);

    @Nonnull
    Collection<? extends TypeKey> getTypes(@Nullable TypeListKey typelistkey);
}
