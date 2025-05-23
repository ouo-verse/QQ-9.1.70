package org.jf.dexlib2.dexbacked.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.instruction.formats.Instruction22cs;
import org.jf.util.NibbleUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedInstruction22cs extends DexBackedInstruction implements Instruction22cs {
    public DexBackedInstruction22cs(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull Opcode opcode, int i3) {
        super(dexBackedDexFile, opcode, i3);
    }

    @Override // org.jf.dexlib2.iface.instruction.FieldOffsetInstruction
    public int getFieldOffset() {
        return this.dexFile.getDataBuffer().readUshort(this.instructionStart + 2);
    }

    @Override // org.jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return NibbleUtils.extractLowUnsignedNibble(this.dexFile.getDataBuffer().readByte(this.instructionStart + 1));
    }

    @Override // org.jf.dexlib2.iface.instruction.TwoRegisterInstruction
    public int getRegisterB() {
        return NibbleUtils.extractHighUnsignedNibble(this.dexFile.getDataBuffer().readByte(this.instructionStart + 1));
    }
}
