package org.jf.dexlib2.dexbacked.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.instruction.formats.UnknownInstruction;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedUnknownInstruction extends DexBackedInstruction implements UnknownInstruction {
    public DexBackedUnknownInstruction(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        super(dexBackedDexFile, Opcode.NOP, i3);
    }

    @Override // org.jf.dexlib2.iface.instruction.formats.UnknownInstruction
    public int getOriginalOpcode() {
        int readUbyte = this.dexFile.getDataBuffer().readUbyte(this.instructionStart);
        if (readUbyte == 0) {
            return this.dexFile.getDataBuffer().readUshort(this.instructionStart);
        }
        return readUbyte;
    }
}
