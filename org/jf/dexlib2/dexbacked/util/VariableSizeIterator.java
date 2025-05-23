package org.jf.dexlib2.dexbacked.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nonnull;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class VariableSizeIterator<T> implements Iterator<T> {
    private int index;

    @Nonnull
    private final DexReader reader;
    protected final int size;

    /* JADX INFO: Access modifiers changed from: protected */
    public VariableSizeIterator(@Nonnull DexBuffer dexBuffer, int i3, int i16) {
        this.reader = dexBuffer.readerAt(i3);
        this.size = i16;
    }

    public int getReaderOffset() {
        return this.reader.getOffset();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index < this.size) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        int i3 = this.index;
        if (i3 < this.size) {
            DexReader dexReader = this.reader;
            this.index = i3 + 1;
            return readNextItem(dexReader, i3);
        }
        throw new NoSuchElementException();
    }

    protected abstract T readNextItem(@Nonnull DexReader dexReader, int i3);

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VariableSizeIterator(@Nonnull DexReader dexReader, int i3) {
        this.reader = dexReader;
        this.size = i3;
    }
}
