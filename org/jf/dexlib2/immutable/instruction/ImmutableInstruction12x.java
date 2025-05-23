package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction12x;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction12x extends ImmutableInstruction implements Instruction12x {
    public static final Format FORMAT = Format.Format12x;
    protected final int registerA;
    protected final int registerB;

    public ImmutableInstruction12x(@Nonnull Opcode opcode, int i3, int i16) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(i3);
        this.registerB = Preconditions.checkNibbleRegister(i16);
    }

    public static ImmutableInstruction12x of(Instruction12x instruction12x) {
        if (instruction12x instanceof ImmutableInstruction12x) {
            return (ImmutableInstruction12x) instruction12x;
        }
        return new ImmutableInstruction12x(instruction12x.getOpcode(), instruction12x.getRegisterA(), instruction12x.getRegisterB());
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
