package org.jf.dexlib2.builder.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction21c;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderInstruction21c extends BuilderInstruction implements Instruction21c {
    public static final Format FORMAT = Format.Format21c;

    @Nonnull
    protected final Reference reference;
    protected final int registerA;

    public BuilderInstruction21c(@Nonnull Opcode opcode, int i3, @Nonnull Reference reference) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
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
        return this.opcode.referenceType;
    }

    @Override // org.jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }
}
