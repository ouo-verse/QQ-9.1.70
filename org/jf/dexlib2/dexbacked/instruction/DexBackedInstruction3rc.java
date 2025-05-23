package org.jf.dexlib2.dexbacked.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.reference.DexBackedReference;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rc;
import org.jf.dexlib2.iface.reference.Reference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedInstruction3rc extends DexBackedInstruction implements Instruction3rc {
    public DexBackedInstruction3rc(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull Opcode opcode, int i3) {
        super(dexBackedDexFile, opcode, i3);
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    @Nonnull
    public Reference getReference() {
        DexBackedDexFile dexBackedDexFile = this.dexFile;
        return DexBackedReference.makeReference(dexBackedDexFile, this.opcode.referenceType, dexBackedDexFile.getDataBuffer().readUshort(this.instructionStart + 2));
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        return this.opcode.referenceType;
    }

    @Override // org.jf.dexlib2.iface.instruction.VariableRegisterInstruction
    public int getRegisterCount() {
        return this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1);
    }

    @Override // org.jf.dexlib2.iface.instruction.RegisterRangeInstruction
    public int getStartRegister() {
        return this.dexFile.getDataBuffer().readUshort(this.instructionStart + 4);
    }
}
