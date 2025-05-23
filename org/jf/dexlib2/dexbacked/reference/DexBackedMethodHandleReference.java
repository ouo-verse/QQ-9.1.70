package org.jf.dexlib2.dexbacked.reference;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.reference.BaseMethodHandleReference;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedMethodHandleReference extends BaseMethodHandleReference {

    @Nonnull
    public final DexBackedDexFile dexFile;
    public final int methodHandleIndex;
    public final int methodHandleOffset;

    public DexBackedMethodHandleReference(DexBackedDexFile dexBackedDexFile, int i3) {
        this.dexFile = dexBackedDexFile;
        this.methodHandleIndex = i3;
        this.methodHandleOffset = dexBackedDexFile.getMethodHandleSection().getOffset(i3);
    }

    @Override // org.jf.dexlib2.iface.reference.MethodHandleReference
    @Nonnull
    public Reference getMemberReference() {
        int readUshort = this.dexFile.getBuffer().readUshort(this.methodHandleOffset + 4);
        switch (getMethodHandleType()) {
            case 0:
            case 1:
            case 2:
            case 3:
                return new DexBackedFieldReference(this.dexFile, readUshort);
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return new DexBackedMethodReference(this.dexFile, readUshort);
            default:
                throw new ExceptionWithContext("Invalid method handle type: %d", Integer.valueOf(getMethodHandleType()));
        }
    }

    @Override // org.jf.dexlib2.iface.reference.MethodHandleReference
    public int getMethodHandleType() {
        return this.dexFile.getBuffer().readUshort(this.methodHandleOffset + 0);
    }

    @Override // org.jf.dexlib2.base.reference.BaseReference, org.jf.dexlib2.iface.reference.Reference
    public void validateReference() throws Reference.InvalidReferenceException {
        int i3 = this.methodHandleIndex;
        if (i3 >= 0 && i3 < this.dexFile.getMethodHandleSection().size()) {
            try {
                getMemberReference();
                return;
            } catch (ExceptionWithContext e16) {
                throw new Reference.InvalidReferenceException("methodhandle@" + this.methodHandleIndex, e16);
            }
        }
        throw new Reference.InvalidReferenceException("methodhandle@" + this.methodHandleIndex);
    }
}
