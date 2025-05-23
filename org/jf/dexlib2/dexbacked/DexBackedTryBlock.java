package org.jf.dexlib2.dexbacked;

import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.BaseTryBlock;
import org.jf.dexlib2.dexbacked.util.VariableSizeList;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedTryBlock extends BaseTryBlock<DexBackedExceptionHandler> {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int handlersStartOffset;
    private final int tryItemOffset;

    public DexBackedTryBlock(@Nonnull DexBackedDexFile dexBackedDexFile, int i3, int i16) {
        this.dexFile = dexBackedDexFile;
        this.tryItemOffset = i3;
        this.handlersStartOffset = i16;
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    public int getCodeUnitCount() {
        return this.dexFile.getDataBuffer().readUshort(this.tryItemOffset + 4);
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    @Nonnull
    public List<? extends DexBackedExceptionHandler> getExceptionHandlers() {
        DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(this.handlersStartOffset + this.dexFile.getDataBuffer().readUshort(this.tryItemOffset + 6));
        int readSleb128 = readerAt.readSleb128();
        if (readSleb128 > 0) {
            return new VariableSizeList<DexBackedTypedExceptionHandler>(this.dexFile.getDataBuffer(), readerAt.getOffset(), readSleb128) { // from class: org.jf.dexlib2.dexbacked.DexBackedTryBlock.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // org.jf.dexlib2.dexbacked.util.VariableSizeList
                @Nonnull
                public DexBackedTypedExceptionHandler readNextItem(@Nonnull DexReader dexReader, int i3) {
                    return new DexBackedTypedExceptionHandler(DexBackedTryBlock.this.dexFile, dexReader);
                }
            };
        }
        final int i3 = (readSleb128 * (-1)) + 1;
        return new VariableSizeList<DexBackedExceptionHandler>(this.dexFile.getDataBuffer(), readerAt.getOffset(), i3) { // from class: org.jf.dexlib2.dexbacked.DexBackedTryBlock.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // org.jf.dexlib2.dexbacked.util.VariableSizeList
            @Nonnull
            public DexBackedExceptionHandler readNextItem(@Nonnull DexReader dexReader, int i16) {
                if (i16 == i3 - 1) {
                    return new DexBackedCatchAllExceptionHandler(dexReader);
                }
                return new DexBackedTypedExceptionHandler(DexBackedTryBlock.this.dexFile, dexReader);
            }
        };
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    public int getStartCodeAddress() {
        return this.dexFile.getDataBuffer().readSmallUint(this.tryItemOffset + 0);
    }
}
