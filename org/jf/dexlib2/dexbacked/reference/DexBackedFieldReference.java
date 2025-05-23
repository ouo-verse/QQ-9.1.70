package org.jf.dexlib2.dexbacked.reference;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseFieldReference;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.reference.Reference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedFieldReference extends BaseFieldReference {

    @Nonnull
    public final DexBackedDexFile dexFile;
    private final int fieldIndex;

    public DexBackedFieldReference(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        this.dexFile = dexBackedDexFile;
        this.fieldIndex = i3;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getDefiningClass() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readUshort(this.dexFile.getFieldSection().getOffset(this.fieldIndex) + 0));
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field, org.jf.dexlib2.iface.Member
    @Nonnull
    public String getName() {
        return this.dexFile.getStringSection().get(this.dexFile.getBuffer().readSmallUint(this.dexFile.getFieldSection().getOffset(this.fieldIndex) + 4));
    }

    public int getSize() {
        return 8;
    }

    @Override // org.jf.dexlib2.iface.reference.FieldReference, org.jf.dexlib2.iface.Field
    @Nonnull
    public String getType() {
        return this.dexFile.getTypeSection().get(this.dexFile.getBuffer().readUshort(this.dexFile.getFieldSection().getOffset(this.fieldIndex) + 2));
    }

    @Override // org.jf.dexlib2.base.reference.BaseReference, org.jf.dexlib2.iface.reference.Reference
    public void validateReference() throws Reference.InvalidReferenceException {
        int i3 = this.fieldIndex;
        if (i3 >= 0 && i3 < this.dexFile.getFieldSection().size()) {
            return;
        }
        throw new Reference.InvalidReferenceException("field@" + this.fieldIndex);
    }
}
