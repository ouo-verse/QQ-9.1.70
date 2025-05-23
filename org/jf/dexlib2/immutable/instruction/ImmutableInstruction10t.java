package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction10t;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction10t extends ImmutableInstruction implements Instruction10t {
    public static final Format FORMAT = Format.Format10t;
    protected final int codeOffset;

    public ImmutableInstruction10t(@Nonnull Opcode opcode, int i3) {
        super(opcode);
        this.codeOffset = Preconditions.checkByteCodeOffset(i3);
    }

    public static ImmutableInstruction10t of(Instruction10t instruction10t) {
        if (instruction10t instanceof ImmutableInstruction10t) {
            return (ImmutableInstruction10t) instruction10t;
        }
        return new ImmutableInstruction10t(instruction10t.getOpcode(), instruction10t.getCodeOffset());
    }

    @Override // org.jf.dexlib2.iface.instruction.OffsetInstruction
    public int getCodeOffset() {
        return this.codeOffset;
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }
}
