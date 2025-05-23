package org.jf.dexlib2.builder.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.Instruction22s;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderInstruction22s extends BuilderInstruction implements Instruction22s {
    public static final Format FORMAT = Format.Format22s;
    protected final int literal;
    protected final int registerA;
    protected final int registerB;

    public BuilderInstruction22s(@Nonnull Opcode opcode, int i3, int i16, int i17) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(i3);
        this.registerB = Preconditions.checkNibbleRegister(i16);
        this.literal = Preconditions.checkShortLiteral(i17);
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.NarrowLiteralInstruction
    public int getNarrowLiteral() {
        return this.literal;
    }

    @Override // org.jf.dexlib2.iface.instruction.OneRegisterInstruction
    public int getRegisterA() {
        return this.registerA;
    }

    @Override // org.jf.dexlib2.iface.instruction.TwoRegisterInstruction
    public int getRegisterB() {
        return this.registerB;
    }

    @Override // org.jf.dexlib2.iface.instruction.WideLiteralInstruction
    public long getWideLiteral() {
        return this.literal;
    }
}
