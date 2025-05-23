package org.jf.dexlib2.writer;

import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface NullableIndexSection<Key> extends IndexSection<Key> {
    int getNullableItemIndex(@Nullable Key key);
}
