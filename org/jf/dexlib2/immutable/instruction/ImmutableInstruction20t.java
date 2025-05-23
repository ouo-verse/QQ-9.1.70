package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction20t;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction20t extends ImmutableInstruction implements Instruction20t {
    public static final Format FORMAT = Format.Format20t;
    protected final int codeOffset;

    public ImmutableInstruction20t(@Nonnull Opcode opcode, int i3) {
        super(opcode);
        this.codeOffset = Preconditions.checkShortCodeOffset(i3);
    }

    public static ImmutableInstruction20t of(Instruction20t instruction20t) {
        if (instruction20t instanceof ImmutableInstruction20t) {
            return (ImmutableInstruction20t) instruction20t;
        }
        return new ImmutableInstruction20t(instruction20t.getOpcode(), instruction20t.getCodeOffset());
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
