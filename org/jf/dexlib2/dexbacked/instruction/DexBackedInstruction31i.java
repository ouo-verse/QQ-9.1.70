package org.jf.dexlib2.dexbacked.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.instruction.formats.Instruction31i;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedInstruction31i extends DexBackedInstruction implements Instruction31i {
    public DexBackedInstruction31i(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull Opcode opcode, int i3) {
        super(dexBackedDexFile, opcode, i3);
    }

    @Override // org.jf.dexlib2.iface.instruction.NarrowLiteralInstruction
    public int getNarrowLiteral() {
        return this.dexFile.getDataBuffer().readInt(this.instructionStart + 2);
    }

    @Override // org.jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.dexFile.getDataBuffer().readUbyte(this.instructionStart + 1);
    }

    @Override // org.jf.dexlib2.iface.instruction.WideLiteralInstruction
    public long getWideLiteral() {
        return getNarrowLiteral();
    }
}
