package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction21s;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction21s extends ImmutableInstruction implements Instruction21s {
    public static final Format FORMAT = Format.Format21s;
    protected final int literal;
    protected final int registerA;

    public ImmutableInstruction21s(@Nonnull Opcode opcode, int i3, int i16) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
        this.literal = Preconditions.checkShortLiteral(i16);
    }

    public static ImmutableInstruction21s of(Instruction21s instruction21s) {
        if (instruction21s instanceof ImmutableInstruction21s) {
            return (ImmutableInstruction21s) instruction21s;
        }
        return new ImmutableInstruction21s(instruction21s.getOpcode(), instruction21s.getRegisterA(), instruction21s.getNarrowLiteral());
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
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

    @Override // org.jf.dexlib2.iface.instruction.WideLiteralInstruction
    public long getWideLiteral() {
        return this.literal;
    }
}
