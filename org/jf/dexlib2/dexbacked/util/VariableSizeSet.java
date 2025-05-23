package org.jf.dexlib2.dexbacked.util;

import java.util.AbstractSet;
import javax.annotation.Nonnull;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class VariableSizeSet<T> extends AbstractSet<T> {

    @Nonnull
    private final DexBuffer buffer;
    private final int offset;
    private final int size;

    public VariableSizeSet(@Nonnull DexBuffer dexBuffer, int i3, int i16) {
        this.buffer = dexBuffer;
        this.offset = i3;
        this.size = i16;
    }

    protected abstract T readNextItem(@Nonnull DexReader dexReader, int i3);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @Nonnull
    public VariableSizeIterator<T> iterator() {
        return new VariableSizeIterator<T>(this.buffer, this.offset, this.size) { // from class: org.jf.dexlib2.dexbacked.util.VariableSizeSet.1
            @Override // org.jf.dexlib2.dexbacked.util.VariableSizeIterator
            protected T readNextItem(@Nonnull DexReader dexReader, int i3) {
                return (T) VariableSizeSet.this.readNextItem(dexReader, i3);
            }
        };
    }
}
