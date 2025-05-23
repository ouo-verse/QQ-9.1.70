package org.jf.dexlib2.builder.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction51l;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderInstruction51l extends BuilderInstruction implements Instruction51l {
    public static final Format FORMAT = Format.Format51l;
    protected final long literal;
    protected final int registerA;

    public BuilderInstruction51l(@Nonnull Opcode opcode, int i3, long j3) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
        this.literal = j3;
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }

    @Override // org.jf.dexlib2.iface.instruction.WideLiteralInstruction
    public long getWideLiteral() {
        return this.literal;
    }
}
