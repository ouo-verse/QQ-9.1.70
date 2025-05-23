package org.jf.dexlib2.dexbacked.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.ReferenceType;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.reference.DexBackedReference;
import org.jf.dexlib2.iface.instruction.formats.Instruction20bc;
import org.jf.dexlib2.iface.reference.Reference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedInstruction20bc extends DexBackedInstruction implements Instruction20bc {
    public DexBackedInstruction20bc(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull Opcode opcode, int i3) {
        super(dexBackedDexFile, opcode, i3);
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    @Nonnull
    public Reference getReference() {
        final int readUshort = this.dexFile.getDataBuffer().readUshort(this.instructionStart + 2);
        try {
            return DexBackedReference.makeReference(this.dexFile, getReferenceType(), readUshort);
        } catch (ReferenceType.InvalidReferenceTypeException e16) {
            return new Reference() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedInstruction20bc.1
                @Override // org.jf.dexlib2.iface.reference.Reference
                public void validateReference() throws Reference.InvalidReferenceException {
                    throw new Reference.InvalidReferenceException(String.format("%d@%d", Integer.valueOf(e16.getReferenceType()), Integer.valueOf(readUshort)), e16);
                }
            };
        }
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        int readUbyte = (this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1) >>> 6) + 1;
        ReferenceType.validateReferenceType(readUbyte);
        return readUbyte;
    }

    @Override // org.jf.dexlib2.iface.instruction.VerificationErrorInstruction
    public int getVerificationError() {
        return this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1) & 63;
    }
}
