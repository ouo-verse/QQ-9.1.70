package org.jf.dexlib2.dexbacked.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.instruction.formats.Instruction21t;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedInstruction21t extends DexBackedInstruction implements Instruction21t {
    public DexBackedInstruction21t(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull Opcode opcode, int i3) {
        super(dexBackedDexFile, opcode, i3);
    }

    @Override // org.jf.dexlib2.iface.instruction.OffsetInstruction
    public int getCodeOffset() {
        return this.dexFile.getDataBuffer().readShort(this.instructionStart + 2);
    }

    @Override // org.jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1);
    }
}
