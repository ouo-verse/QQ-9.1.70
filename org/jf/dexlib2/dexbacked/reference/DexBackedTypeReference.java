package org.jf.dexlib2.dexbacked.reference;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.reference.Reference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedTypeReference extends BaseTypeReference {

    @Nonnull
    public final DexBackedDexFile dexFile;
    public final int typeIndex;

    public DexBackedTypeReference(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        this.dexFile = dexBackedDexFile;
        this.typeIndex = i3;
    }

    public int getSize() {
        return 4;
    }

    @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
    @Nonnull
    public String getType() {
        return this.dexFile.getTypeSection().get(this.typeIndex);
    }

    @Override // org.jf.dexlib2.base.reference.BaseReference, org.jf.dexlib2.iface.reference.Reference
    public void validateReference() throws Reference.InvalidReferenceException {
        int i3 = this.typeIndex;
        if (i3 >= 0 && i3 < this.dexFile.getTypeSection().size()) {
            return;
        }
        throw new Reference.InvalidReferenceException("type@" + this.typeIndex);
    }
}
