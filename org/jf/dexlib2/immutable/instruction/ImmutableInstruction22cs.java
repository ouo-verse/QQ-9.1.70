package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction22cs;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction22cs extends ImmutableInstruction implements Instruction22cs {
    public static final Format FORMAT = Format.Format22cs;
    protected final int fieldOffset;
    protected final int registerA;
    protected final int registerB;

    public ImmutableInstruction22cs(@Nonnull Opcode opcode, int i3, int i16, int i17) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(i3);
        this.registerB = Preconditions.checkNibbleRegister(i16);
        this.fieldOffset = Preconditions.checkFieldOffset(i17);
    }

    public static ImmutableInstruction22cs of(Instruction22cs instruction22cs) {
        if (instruction22cs instanceof ImmutableInstruction22cs) {
            return (ImmutableInstruction22cs) instruction22cs;
        }
        return new ImmutableInstruction22cs(instruction22cs.getOpcode(), instruction22cs.getRegisterA(), instruction22cs.getRegisterB(), instruction22cs.getFieldOffset());
    }

    @Override // org.jf.dexlib2.iface.instruction.FieldOffsetInstruction
    public int getFieldOffset() {
        return this.fieldOffset;
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
