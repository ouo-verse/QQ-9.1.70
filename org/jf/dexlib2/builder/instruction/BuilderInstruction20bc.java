package org.jf.dexlib2.builder.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.ReferenceType;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction20bc;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderInstruction20bc extends BuilderInstruction implements Instruction20bc {
    public static final Format FORMAT = Format.Format20bc;

    @Nonnull
    protected final Reference reference;
    protected final int verificationError;

    public BuilderInstruction20bc(@Nonnull Opcode opcode, int i3, @Nonnull Reference reference) {
        super(opcode);
        this.verificationError = Preconditions.checkVerificationError(i3);
        this.reference = reference;
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    @Nonnull
    public Reference getReference() {
        return this.reference;
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        return ReferenceType.getReferenceType(this.reference);
    }

    @Override // org.jf.dexlib2.iface.instruction.VerificationErrorInstruction
    public int getVerificationError() {
        return this.verificationError;
    }
}
