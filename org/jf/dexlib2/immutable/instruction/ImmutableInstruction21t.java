package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction21t;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction21t extends ImmutableInstruction implements Instruction21t {
    public static final Format FORMAT = Format.Format21t;
    protected final int codeOffset;
    protected final int registerA;

    public ImmutableInstruction21t(@Nonnull Opcode opcode, int i3, int i16) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
        this.codeOffset = Preconditions.checkShortCodeOffset(i16);
    }

    public static ImmutableInstruction21t of(Instruction21t instruction21t) {
        if (instruction21t instanceof ImmutableInstruction21t) {
            return (ImmutableInstruction21t) instruction21t;
        }
        return new ImmutableInstruction21t(instruction21t.getOpcode(), instruction21t.getRegisterA(), instruction21t.getCodeOffset());
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
}
