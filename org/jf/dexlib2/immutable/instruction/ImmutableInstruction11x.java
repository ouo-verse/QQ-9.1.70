package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction11x;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction11x extends ImmutableInstruction implements Instruction11x {
    public static final Format FORMAT = Format.Format11x;
    protected final int registerA;

    public ImmutableInstruction11x(@Nonnull Opcode opcode, int i3) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
    }

    public static ImmutableInstruction11x of(Instruction11x instruction11x) {
        if (instruction11x instanceof ImmutableInstruction11x) {
            return (ImmutableInstruction11x) instruction11x;
        }
        return new ImmutableInstruction11x(instruction11x.getOpcode(), instruction11x.getRegisterA());
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
