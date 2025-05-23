package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction32x;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction32x extends ImmutableInstruction implements Instruction32x {
    public static final Format FORMAT = Format.Format32x;
    protected final int registerA;
    protected final int registerB;

    public ImmutableInstruction32x(@Nonnull Opcode opcode, int i3, int i16) {
        super(opcode);
        this.registerA = Preconditions.checkShortRegister(i3);
        this.registerB = Preconditions.checkShortRegister(i16);
    }

    public static ImmutableInstruction32x of(Instruction32x instruction32x) {
        if (instruction32x instanceof ImmutableInstruction32x) {
            return (ImmutableInstruction32x) instruction32x;
        }
        return new ImmutableInstruction32x(instruction32x.getOpcode(), instruction32x.getRegisterA(), instruction32x.getRegisterB());
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
