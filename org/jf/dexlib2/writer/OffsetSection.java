package org.jf.dexlib2.writer;

import java.util.Collection;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface OffsetSection<Key> {
    int getItemOffset(@Nonnull Key key);

    @Nonnull
    Collection<? extends Map.Entry<? extends Key, Integer>> getItems();
}
