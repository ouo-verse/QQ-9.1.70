package org.jf.dexlib2.dexbacked.util;

import com.google.common.collect.AbstractIterator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class VariableSizeLookaheadIterator<T> extends AbstractIterator<T> {

    @Nonnull
    private final DexReader reader;

    /* JADX INFO: Access modifiers changed from: protected */
    public VariableSizeLookaheadIterator(@Nonnull DexBuffer dexBuffer, int i3) {
        this.reader = dexBuffer.readerAt(i3);
    }

    @Override // com.google.common.collect.AbstractIterator
    protected T computeNext() {
        return readNextItem(this.reader);
    }

    public final int getReaderOffset() {
        return this.reader.getOffset();
    }

    @Nullable
    protected abstract T readNextItem(@Nonnull DexReader dexReader);
}
