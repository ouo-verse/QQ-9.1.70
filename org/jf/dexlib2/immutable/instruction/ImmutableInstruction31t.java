package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction31t;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction31t extends ImmutableInstruction implements Instruction31t {
    public static final Format FORMAT = Format.Format31t;
    protected final int codeOffset;
    protected final int registerA;

    public ImmutableInstruction31t(@Nonnull Opcode opcode, int i3, int i16) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
        this.codeOffset = i16;
    }

    public static ImmutableInstruction31t of(Instruction31t instruction31t) {
        if (instruction31t instanceof ImmutableInstruction31t) {
            return (ImmutableInstruction31t) instruction31t;
        }
        return new ImmutableInstruction31t(instruction31t.getOpcode(), instruction31t.getRegisterA(), instruction31t.getCodeOffset());
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
