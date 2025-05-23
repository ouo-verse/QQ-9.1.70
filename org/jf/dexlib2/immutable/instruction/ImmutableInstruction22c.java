package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction22c;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.immutable.reference.ImmutableReference;
import org.jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction22c extends ImmutableInstruction implements Instruction22c {
    public static final Format FORMAT = Format.Format22c;

    @Nonnull
    protected final ImmutableReference reference;
    protected final int registerA;
    protected final int registerB;

    public ImmutableInstruction22c(@Nonnull Opcode opcode, int i3, int i16, @Nonnull Reference reference) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(i3);
        this.registerB = Preconditions.checkNibbleRegister(i16);
        this.reference = ImmutableReferenceFactory.of(opcode.referenceType, reference);
    }

    public static ImmutableInstruction22c of(Instruction22c instruction22c) {
        if (instruction22c instanceof ImmutableInstruction22c) {
            return (ImmutableInstruction22c) instruction22c;
        }
        return new ImmutableInstruction22c(instruction22c.getOpcode(), instruction22c.getRegisterA(), instruction22c.getRegisterB(), instruction22c.getReference());
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        return this.opcode.referenceType;
    }

    @Override // org.jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }

    @Override // org.jf.dexlib2.iface.instruction.TwoRegisterInstruction
    public int getRegisterB() {
        return this.registerB;
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    @Nonnull
    public ImmutableReference getReference() {
        return this.reference;
    }
}
