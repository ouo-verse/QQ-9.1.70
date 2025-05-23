package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rc;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.immutable.reference.ImmutableReference;
import org.jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction3rc extends ImmutableInstruction implements Instruction3rc {
    public static final Format FORMAT = Format.Format3rc;

    @Nonnull
    protected final ImmutableReference reference;
    protected final int registerCount;
    protected final int startRegister;

    public ImmutableInstruction3rc(@Nonnull Opcode opcode, int i3, int i16, @Nonnull Reference reference) {
        super(opcode);
        this.startRegister = Preconditions.checkShortRegister(i3);
        this.registerCount = Preconditions.checkRegisterRangeCount(i16);
        this.reference = ImmutableReferenceFactory.of(opcode.referenceType, reference);
    }

    public static ImmutableInstruction3rc of(Instruction3rc instruction3rc) {
        if (instruction3rc instanceof ImmutableInstruction3rc) {
            return (ImmutableInstruction3rc) instruction3rc;
        }
        return new ImmutableInstruction3rc(instruction3rc.getOpcode(), instruction3rc.getStartRegister(), instruction3rc.getRegisterCount(), instruction3rc.getReference());
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        return this.opcode.referenceType;
    }

    @Override // org.jf.dexlib2.iface.instruction.VariableRegisterInstruction
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // org.jf.dexlib2.iface.instruction.RegisterRangeInstruction
    public int getStartRegister() {
        return this.startRegister;
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    @Nonnull
    public ImmutableReference getReference() {
        return this.reference;
    }
}
