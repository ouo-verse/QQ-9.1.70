package org.jf.dexlib2.builder.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction22x;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderInstruction22x extends BuilderInstruction implements Instruction22x {
    public static final Format FORMAT = Format.Format22x;
    protected final int registerA;
    protected final int registerB;

    public BuilderInstruction22x(@Nonnull Opcode opcode, int i3, int i16) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
        this.registerB = Preconditions.checkShortRegister(i16);
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }

    @Override // org.jf.dexlib2.iface.instruction.TwoRegisterInstruction
    public int getRegisterB() {
        return this.registerB;
    }
}
