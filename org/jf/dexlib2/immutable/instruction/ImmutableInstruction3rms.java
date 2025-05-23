package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rms;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction3rms extends ImmutableInstruction implements Instruction3rms {
    public static final Format FORMAT = Format.Format3rms;
    protected final int registerCount;
    protected final int startRegister;
    protected final int vtableIndex;

    public ImmutableInstruction3rms(@Nonnull Opcode opcode, int i3, int i16, int i17) {
        super(opcode);
        this.startRegister = Preconditions.checkShortRegister(i3);
        this.registerCount = Preconditions.checkRegisterRangeCount(i16);
        this.vtableIndex = Preconditions.checkVtableIndex(i17);
    }

    public static ImmutableInstruction3rms of(Instruction3rms instruction3rms) {
        if (instruction3rms instanceof ImmutableInstruction3rms) {
            return (ImmutableInstruction3rms) instruction3rms;
        }
        return new ImmutableInstruction3rms(instruction3rms.getOpcode(), instruction3rms.getStartRegister(), instruction3rms.getRegisterCount(), instruction3rms.getVtableIndex());
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.VariableRegisterInstruction
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // org.jf.dexlib2.iface.instruction.RegisterRangeInstruction
    public int getStartRegister() {
        return this.startRegister;
    }

    @Override // org.jf.dexlib2.iface.instruction.VtableIndexInstruction
    public int getVtableIndex() {
        return this.vtableIndex;
    }
}
