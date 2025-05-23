package org.jf.dexlib2.writer;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface TypeSection<StringKey, TypeKey, TypeRef extends TypeReference> extends NullableIndexSection<TypeKey> {
    int getItemIndex(@Nonnull TypeRef typeref);

    @Nonnull
    StringKey getString(@Nonnull TypeKey typekey);
}
