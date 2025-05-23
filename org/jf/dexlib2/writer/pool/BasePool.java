package org.jf.dexlib2.writer.pool;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;

/* loaded from: classes29.dex */
public class BasePool<Key, Value> implements Markable {

    @Nonnull
    protected final DexPool dexPool;

    @Nonnull
    protected final Map<Key, Value> internedItems = Maps.k();
    private int markedItemCount = -1;

    public BasePool(@Nonnull DexPool dexPool) {
        this.dexPool = dexPool;
    }

    public int getItemCount() {
        return this.internedItems.size();
    }

    @Override // org.jf.dexlib2.writer.pool.Markable
    public void mark() {
        this.markedItemCount = this.internedItems.size();
    }

    @Override // org.jf.dexlib2.writer.pool.Markable
    public void reset() {
        int i3 = this.markedItemCount;
        if (i3 >= 0) {
            if (i3 == this.internedItems.size()) {
                return;
            }
            Iterator<Key> it = this.internedItems.keySet().iterator();
            for (int i16 = 0; i16 < this.markedItemCount; i16++) {
                it.next();
            }
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
            return;
        }
        throw new IllegalStateException("mark() must be called before calling reset()");
    }
}
