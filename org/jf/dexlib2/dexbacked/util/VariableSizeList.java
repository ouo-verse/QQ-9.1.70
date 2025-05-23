package org.jf.dexlib2.dexbacked.util;

import java.util.AbstractSequentialList;
import javax.annotation.Nonnull;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class VariableSizeList<T> extends AbstractSequentialList<T> {

    @Nonnull
    private final DexBuffer buffer;
    private final int offset;
    private final int size;

    public VariableSizeList(@Nonnull DexBuffer dexBuffer, int i3, int i16) {
        this.buffer = dexBuffer;
        this.offset = i3;
        this.size = i16;
    }

    protected abstract T readNextItem(@Nonnull DexReader dexReader, int i3);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    @Nonnull
    public VariableSizeListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    @Nonnull
    public VariableSizeListIterator<T> listIterator(int i3) {
        VariableSizeListIterator<T> variableSizeListIterator = new VariableSizeListIterator<T>(this.buffer, this.offset, this.size) { // from class: org.jf.dexlib2.dexbacked.util.VariableSizeList.1
            @Override // org.jf.dexlib2.dexbacked.util.VariableSizeListIterator
            protected T readNextItem(@Nonnull DexReader dexReader, int i16) {
                return (T) VariableSizeList.this.readNextItem(dexReader, i16);
            }
        };
        for (int i16 = 0; i16 < i3; i16++) {
            variableSizeListIterator.next();
        }
        return variableSizeListIterator;
    }
}
