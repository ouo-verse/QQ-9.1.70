package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.immutable.reference.ImmutableReference;
import org.jf.dexlib2.immutable.reference.ImmutableReferenceFactory;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction35c extends ImmutableInstruction implements Instruction35c {
    public static final Format FORMAT = Format.Format35c;

    @Nonnull
    protected final ImmutableReference reference;
    protected final int registerC;
    protected final int registerCount;
    protected final int registerD;
    protected final int registerE;
    protected final int registerF;
    protected final int registerG;

    public ImmutableInstruction35c(@Nonnull Opcode opcode, int i3, int i16, int i17, int i18, int i19, int i26, @Nonnull Reference reference) {
        super(opcode);
        int i27;
        int i28;
        int i29;
        int i36;
        this.registerCount = Preconditions.check35cAnd45ccRegisterCount(i3);
        if (i3 > 0) {
            i27 = Preconditions.checkNibbleRegister(i16);
        } else {
            i27 = 0;
        }
        this.registerC = i27;
        if (i3 > 1) {
            i28 = Preconditions.checkNibbleRegister(i17);
        } else {
            i28 = 0;
        }
        this.registerD = i28;
        if (i3 > 2) {
            i29 = Preconditions.checkNibbleRegister(i18);
        } else {
            i29 = 0;
        }
        this.registerE = i29;
        if (i3 > 3) {
            i36 = Preconditions.checkNibbleRegister(i19);
        } else {
            i36 = 0;
        }
        this.registerF = i36;
        this.registerG = i3 > 4 ? Preconditions.checkNibbleRegister(i26) : 0;
        this.reference = ImmutableReferenceFactory.of(opcode.referenceType, reference);
    }

    public static ImmutableInstruction35c of(Instruction35c instruction35c) {
        if (instruction35c instanceof ImmutableInstruction35c) {
            return (ImmutableInstruction35c) instruction35c;
        }
        return new ImmutableInstruction35c(instruction35c.getOpcode(), instruction35c.getRegisterCount(), instruction35c.getRegisterC(), instruction35c.getRegisterD(), instruction35c.getRegisterE(), instruction35c.getRegisterF(), instruction35c.getRegisterG(), instruction35c.getReference());
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    public int getReferenceType() {
        return this.opcode.referenceType;
    }

    @Override // org.jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterC() {
        return this.registerC;
    }

    @Override // org.jf.dexlib2.iface.instruction.VariableRegisterInstruction
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // org.jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterD() {
        return this.registerD;
    }

    @Override // org.jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterE() {
        return this.registerE;
    }

    @Override // org.jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterF() {
        return this.registerF;
    }

    @Override // org.jf.dexlib2.iface.instruction.FiveRegisterInstruction
    public int getRegisterG() {
        return this.registerG;
    }

    @Override // org.jf.dexlib2.iface.instruction.ReferenceInstruction
    @Nonnull
    public ImmutableReference getReference() {
        return this.reference;
    }
}
