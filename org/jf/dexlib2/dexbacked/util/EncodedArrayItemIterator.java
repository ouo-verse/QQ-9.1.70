package org.jf.dexlib2.dexbacked.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.dexbacked.value.DexBackedEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class EncodedArrayItemIterator {
    public static final EncodedArrayItemIterator EMPTY = new EncodedArrayItemIterator() { // from class: org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator.1
        @Override // org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public int getItemCount() {
            return 0;
        }

        @Override // org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        @Nullable
        public EncodedValue getNextOrNull() {
            return null;
        }

        @Override // org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public int getReaderOffset() {
            return 0;
        }

        @Override // org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public void skipNext() {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class EncodedArrayItemIteratorImpl extends EncodedArrayItemIterator {

        @Nonnull
        private final DexBackedDexFile dexFile;
        private int index = 0;

        @Nonnull
        private final DexReader reader;
        private final int size;

        public EncodedArrayItemIteratorImpl(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
            this.dexFile = dexBackedDexFile;
            DexReader<? extends DexBuffer> readerAt = dexBackedDexFile.getDataBuffer().readerAt(i3);
            this.reader = readerAt;
            this.size = readerAt.readSmallUleb128();
        }

        @Override // org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public int getItemCount() {
            return this.size;
        }

        @Override // org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        @Nullable
        public EncodedValue getNextOrNull() {
            int i3 = this.index;
            if (i3 < this.size) {
                this.index = i3 + 1;
                return DexBackedEncodedValue.readFrom(this.dexFile, this.reader);
            }
            return null;
        }

        @Override // org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public int getReaderOffset() {
            return this.reader.getOffset();
        }

        @Override // org.jf.dexlib2.dexbacked.util.EncodedArrayItemIterator
        public void skipNext() {
            int i3 = this.index;
            if (i3 < this.size) {
                this.index = i3 + 1;
                DexBackedEncodedValue.skipFrom(this.reader);
            }
        }
    }

    @Nonnull
    public static EncodedArrayItemIterator newOrEmpty(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        if (i3 == 0) {
            return EMPTY;
        }
        return new EncodedArrayItemIteratorImpl(dexBackedDexFile, i3);
    }

    public abstract int getItemCount();

    @Nullable
    public abstract EncodedValue getNextOrNull();

    public abstract int getReaderOffset();

    public abstract void skipNext();
}
