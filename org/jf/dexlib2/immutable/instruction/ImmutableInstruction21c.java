package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction21c;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.immutable.reference.ImmutableReference;
import org.jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction21c extends ImmutableInstruction implements Instruction21c {
    public static final Format FORMAT = Format.Format21c;

    @Nonnull
    protected final ImmutableReference reference;
    protected final int registerA;

    public ImmutableInstruction21c(@Nonnull Opcode opcode, int i3, @Nonnull Reference reference) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
        this.reference = ImmutableReferenceFactory.of(opcode.referenceType, reference);
    }

    public static ImmutableInstruction21c of(Instruction21c instruction21c) {
        if (instruction21c instanceof ImmutableInstruction21c) {
            return (ImmutableInstruction21c) instruction21c;
        }
        return new ImmutableInstruction21c(instruction21c.getOpcode(), instruction21c.getRegisterA(), instruction21c.getReference());
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

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    @Nonnull
    public ImmutableReference getReference() {
        return this.reference;
    }
}
