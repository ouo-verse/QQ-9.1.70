package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction22t;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction22t extends ImmutableInstruction implements Instruction22t {
    public static final Format FORMAT = Format.Format22t;
    protected final int codeOffset;
    protected final int registerA;
    protected final int registerB;

    public ImmutableInstruction22t(@Nonnull Opcode opcode, int i3, int i16, int i17) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(i3);
        this.registerB = Preconditions.checkNibbleRegister(i16);
        this.codeOffset = Preconditions.checkShortCodeOffset(i17);
    }

    public static ImmutableInstruction22t of(Instruction22t instruction22t) {
        if (instruction22t instanceof ImmutableInstruction22t) {
            return (ImmutableInstruction22t) instruction22t;
        }
        return new ImmutableInstruction22t(instruction22t.getOpcode(), instruction22t.getRegisterA(), instruction22t.getRegisterB(), instruction22t.getCodeOffset());
    }

    @Override // org.jf.dexlib2.iface.instruction.OffsetInstruction
    public int getCodeOffset() {
        return this.codeOffset;
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
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
