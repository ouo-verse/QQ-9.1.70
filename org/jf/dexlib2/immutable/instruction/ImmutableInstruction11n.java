package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction11n;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction11n extends ImmutableInstruction implements Instruction11n {
    public static final Format FORMAT = Format.Format11n;
    protected final int literal;
    protected final int registerA;

    public ImmutableInstruction11n(@Nonnull Opcode opcode, int i3, int i16) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(i3);
        this.literal = Preconditions.checkNibbleLiteral(i16);
    }

    public static ImmutableInstruction11n of(Instruction11n instruction11n) {
        if (instruction11n instanceof ImmutableInstruction11n) {
            return (ImmutableInstruction11n) instruction11n;
        }
        return new ImmutableInstruction11n(instruction11n.getOpcode(), instruction11n.getRegisterA(), instruction11n.getNarrowLiteral());
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
