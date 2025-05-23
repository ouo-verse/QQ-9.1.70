package org.jf.dexlib2.builder.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction3rms;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderInstruction3rms extends BuilderInstruction implements Instruction3rms {
    public static final Format FORMAT = Format.Format3rms;
    protected final int registerCount;
    protected final int startRegister;
    protected final int vtableIndex;

    public BuilderInstruction3rms(@Nonnull Opcode opcode, int i3, int i16, int i17) {
        super(opcode);
        this.startRegister = Preconditions.checkShortRegister(i3);
        this.registerCount = Preconditions.checkRegisterRangeCount(i16);
        this.vtableIndex = i17;
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction
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
