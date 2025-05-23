package org.jf.dexlib2.writer;

import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.reference.StringReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface StringSection<StringKey, StringRef extends StringReference> extends NullableIndexSection<StringKey> {
    int getItemIndex(@Nonnull StringRef stringref);

    boolean hasJumboIndexes();
}
