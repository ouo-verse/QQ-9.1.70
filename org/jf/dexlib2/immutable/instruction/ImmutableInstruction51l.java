package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction51l;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction51l extends ImmutableInstruction implements Instruction51l {
    public static final Format FORMAT = Format.Format51l;
    protected final long literal;
    protected final int registerA;

    public ImmutableInstruction51l(@Nonnull Opcode opcode, int i3, long j3) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
        this.literal = j3;
    }

    public static ImmutableInstruction51l of(Instruction51l instruction51l) {
        if (instruction51l instanceof ImmutableInstruction51l) {
            return (ImmutableInstruction51l) instruction51l;
        }
        return new ImmutableInstruction51l(instruction51l.getOpcode(), instruction51l.getRegisterA(), instruction51l.getWideLiteral());
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }

    @Override // org.jf.dexlib2.iface.instruction.WideLiteralInstruction
    public long getWideLiteral() {
        return this.literal;
    }
}
