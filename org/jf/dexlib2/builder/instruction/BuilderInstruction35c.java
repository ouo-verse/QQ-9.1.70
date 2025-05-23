package org.jf.dexlib2.builder.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction35c;
import org.jf.dexlib2.iface.reference.Reference;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderInstruction35c extends BuilderInstruction implements Instruction35c {
    public static final Format FORMAT = Format.Format35c;

    @Nonnull
    protected final Reference reference;
    protected final int registerC;
    protected final int registerCount;
    protected final int registerD;
    protected final int registerE;
    protected final int registerF;
    protected final int registerG;

    public BuilderInstruction35c(@Nonnull Opcode opcode, int i3, int i16, int i17, int i18, int i19, int i26, @Nonnull Reference reference) {
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
}
