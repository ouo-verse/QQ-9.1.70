package org.jf.dexlib2.dexbacked.util;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import javax.annotation.Nonnull;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class VariableSizeListIterator<T> implements ListIterator<T> {
    private int index;

    @Nonnull
    private DexReader<? extends DexBuffer> reader;
    protected final int size;
    private final int startOffset;

    /* JADX INFO: Access modifiers changed from: protected */
    public VariableSizeListIterator(@Nonnull DexBuffer dexBuffer, int i3, int i16) {
        this.reader = dexBuffer.readerAt(i3);
        this.startOffset = i3;
        this.size = i16;
    }

    @Override // java.util.ListIterator
    public void add(T t16) {
        throw new UnsupportedOperationException();
    }

    public int getReaderOffset() {
        return this.reader.getOffset();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        if (this.index < this.size) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        if (this.index > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        int i3 = this.index;
        if (i3 < this.size) {
            DexReader<? extends DexBuffer> dexReader = this.reader;
            this.index = i3 + 1;
            return readNextItem(dexReader, i3);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index;
    }

    @Override // java.util.ListIterator
    public T previous() {
        int i3 = this.index - 1;
        this.reader.setOffset(this.startOffset);
        this.index = 0;
        while (true) {
            int i16 = this.index;
            if (i16 < i3) {
                DexReader<? extends DexBuffer> dexReader = this.reader;
                this.index = i16 + 1;
                readNextItem(dexReader, i16);
            } else {
                DexReader<? extends DexBuffer> dexReader2 = this.reader;
                this.index = i16 + 1;
                return readNextItem(dexReader2, i16);
            }
        }
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.index - 1;
    }

    protected abstract T readNextItem(@Nonnull DexReader<? extends DexBuffer> dexReader, int i3);

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public void set(T t16) {
        throw new UnsupportedOperationException();
    }
}
