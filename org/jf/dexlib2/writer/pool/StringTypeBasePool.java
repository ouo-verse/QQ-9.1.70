package org.jf.dexlib2.writer.pool;

import java.util.Collection;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.writer.NullableIndexSection;
import org.jf.util.ExceptionWithContext;

/* loaded from: classes29.dex */
public abstract class StringTypeBasePool extends BasePool<String, Integer> implements NullableIndexSection<CharSequence> {
    public StringTypeBasePool(@Nonnull DexPool dexPool) {
        super(dexPool);
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    @Nonnull
    public Collection<Map.Entry<String, Integer>> getItems() {
        return this.internedItems.entrySet();
    }

    @Override // org.jf.dexlib2.writer.IndexSection
    public int getItemIndex(@Nonnull CharSequence charSequence) {
        Integer num = (Integer) this.internedItems.get(charSequence.toString());
        if (num != null) {
            return num.intValue();
        }
        throw new ExceptionWithContext("Item not found.: %s", charSequence.toString());
    }

    @Override // org.jf.dexlib2.writer.NullableIndexSection
    public int getNullableItemIndex(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            return -1;
        }
        return getItemIndex(charSequence);
    }
}
