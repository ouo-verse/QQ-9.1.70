package org.jf.dexlib2.writer;

import java.util.Collection;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface IndexSection<Key> {
    int getItemCount();

    int getItemIndex(@Nonnull Key key);

    @Nonnull
    Collection<? extends Map.Entry<? extends Key, Integer>> getItems();
}
