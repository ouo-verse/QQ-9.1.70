package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.ReferenceType;
import org.jf.dexlib2.iface.instruction.formats.Instruction20bc;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.immutable.reference.ImmutableReference;
import org.jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction20bc extends ImmutableInstruction implements Instruction20bc {
    public static final Format FORMAT = Format.Format20bc;

    @Nonnull
    protected final ImmutableReference reference;
    protected final int verificationError;

    public ImmutableInstruction20bc(@Nonnull Opcode opcode, int i3, @Nonnull Reference reference) {
        super(opcode);
        this.verificationError = Preconditions.checkVerificationError(i3);
        this.reference = ImmutableReferenceFactory.of(opcode.referenceType, reference);
    }

    public static ImmutableInstruction20bc of(Instruction20bc instruction20bc) {
        if (instruction20bc instanceof ImmutableInstruction20bc) {
            return (ImmutableInstruction20bc) instruction20bc;
        }
        return new ImmutableInstruction20bc(instruction20bc.getOpcode(), instruction20bc.getVerificationError(), instruction20bc.getReference());
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        return ReferenceType.getReferenceType(this.reference);
    }

    @Override // org.jf.dexlib2.iface.instruction.VerificationErrorInstruction
    public int getVerificationError() {
        return this.verificationError;
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    @Nonnull
    public ImmutableReference getReference() {
        return this.reference;
    }
}
