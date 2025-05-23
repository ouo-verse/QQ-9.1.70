package org.jf.dexlib2.builder.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction11x;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderInstruction11x extends BuilderInstruction implements Instruction11x {
    public static final Format FORMAT = Format.Format11x;
    protected final int registerA;

    public BuilderInstruction11x(@Nonnull Opcode opcode, int i3) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }
}
