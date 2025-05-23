package org.jf.dexlib2.dexbacked.reference;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseStringReference;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.DexBuffer;
import org.jf.dexlib2.dexbacked.DexReader;
import org.jf.dexlib2.iface.reference.Reference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedStringReference extends BaseStringReference {

    @Nonnull
    public final DexBackedDexFile dexFile;
    public final int stringIndex;

    public DexBackedStringReference(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        this.dexFile = dexBackedDexFile;
        this.stringIndex = i3;
    }

    public int getSize() {
        DexReader<? extends DexBuffer> readerAt = this.dexFile.getDataBuffer().readerAt(this.dexFile.getBuffer().readSmallUint(this.dexFile.getStringSection().getOffset(this.stringIndex)));
        return readerAt.peekSmallUleb128Size() + 4 + readerAt.peekStringLength(readerAt.readSmallUleb128());
    }

    @Override // org.jf.dexlib2.iface.reference.StringReference
    @Nonnull
    public String getString() {
        return this.dexFile.getStringSection().get(this.stringIndex);
    }

    @Override // org.jf.dexlib2.base.reference.BaseReference, org.jf.dexlib2.iface.reference.Reference
    public void validateReference() throws Reference.InvalidReferenceException {
        int i3 = this.stringIndex;
        if (i3 >= 0 && i3 < this.dexFile.getStringSection().size()) {
            return;
        }
        throw new Reference.InvalidReferenceException("string@" + this.stringIndex);
    }
}
