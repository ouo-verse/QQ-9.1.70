package org.jf.dexlib2.builder.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction35mi;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderInstruction35mi extends BuilderInstruction implements Instruction35mi {
    public static final Format FORMAT = Format.Format35mi;
    protected final int inlineIndex;
    protected final int registerC;
    protected final int registerCount;
    protected final int registerD;
    protected final int registerE;
    protected final int registerF;
    protected final int registerG;

    public BuilderInstruction35mi(@Nonnull Opcode opcode, int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        super(opcode);
        int i28;
        int i29;
        int i36;
        int i37;
        this.registerCount = Preconditions.check35cAnd45ccRegisterCount(i3);
        if (i3 > 0) {
            i28 = Preconditions.checkNibbleRegister(i16);
        } else {
            i28 = 0;
        }
        this.registerC = i28;
        if (i3 > 1) {
            i29 = Preconditions.checkNibbleRegister(i17);
        } else {
            i29 = 0;
        }
        this.registerD = i29;
        if (i3 > 2) {
            i36 = Preconditions.checkNibbleRegister(i18);
        } else {
            i36 = 0;
        }
        this.registerE = i36;
        if (i3 > 3) {
            i37 = Preconditions.checkNibbleRegister(i19);
        } else {
            i37 = 0;
        }
        this.registerF = i37;
        this.registerG = i3 > 4 ? Preconditions.checkNibbleRegister(i26) : 0;
        this.inlineIndex = i27;
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.InlineIndexInstruction
    public int getInlineIndex() {
        return this.inlineIndex;
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
