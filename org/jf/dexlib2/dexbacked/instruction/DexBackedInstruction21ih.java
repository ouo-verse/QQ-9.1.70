package org.jf.dexlib2.dexbacked.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.instruction.formats.Instruction21ih;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedInstruction21ih extends DexBackedInstruction implements Instruction21ih {
    public DexBackedInstruction21ih(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull Opcode opcode, int i3) {
        super(dexBackedDexFile, opcode, i3);
    }

    @Override // org.jf.dexlib2.iface.instruction.HatLiteralInstruction
    public short getHatLiteral() {
        return (short) this.dexFile.getDataBuffer().readShort(this.instructionStart + 2);
    }

    @Override // org.jf.dexlib2.iface.instruction.NarrowLiteralInstruction
    public int getNarrowLiteral() {
        return getHatLiteral() << 16;
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
