package org.jf.dexlib2.dexbacked.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.iface.instruction.formats.Instruction11n;
import org.jf.util.NibbleUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedInstruction11n extends DexBackedInstruction implements Instruction11n {
    public DexBackedInstruction11n(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull Opcode opcode, int i3) {
        super(dexBackedDexFile, opcode, i3);
    }

    @Override // org.jf.dexlib2.iface.instruction.NarrowLiteralInstruction
    public int getNarrowLiteral() {
        return NibbleUtils.extractHighSignedNibble(this.dexFile.getDataBuffer().readByte(this.instructionStart + 1));
    }

    @Override // org.jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return NibbleUtils.extractLowUnsignedNibble(this.dexFile.getDataBuffer().readByte(this.instructionStart + 1));
    }

    @Override // org.jf.dexlib2.iface.instruction.WideLiteralInstruction
    public long getWideLiteral() {
        return getNarrowLiteral();
    }
}
