package org.jf.dexlib2.analysis;

import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.Instruction;

/* compiled from: P */
/* loaded from: classes29.dex */
public class UnresolvedOdexInstruction implements Instruction {
    public final int objectRegisterNum;
    public final Instruction originalInstruction;

    public UnresolvedOdexInstruction(Instruction instruction, int i3) {
        this.originalInstruction = instruction;
        this.objectRegisterNum = i3;
    }

    @Override // org.jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return this.originalInstruction.getCodeUnits();
    }

    @Override // org.jf.dexlib2.iface.instruction.Instruction
    public Opcode getOpcode() {
        return this.originalInstruction.getOpcode();
    }
}
