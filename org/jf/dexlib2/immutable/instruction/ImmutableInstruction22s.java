package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction22s;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction22s extends ImmutableInstruction implements Instruction22s {
    public static final Format FORMAT = Format.Format22s;
    protected final int literal;
    protected final int registerA;
    protected final int registerB;

    public ImmutableInstruction22s(@Nonnull Opcode opcode, int i3, int i16, int i17) {
        super(opcode);
        this.registerA = Preconditions.checkNibbleRegister(i3);
        this.registerB = Preconditions.checkNibbleRegister(i16);
        this.literal = Preconditions.checkShortLiteral(i17);
    }

    public static ImmutableInstruction22s of(Instruction22s instruction22s) {
        if (instruction22s instanceof ImmutableInstruction22s) {
            return (ImmutableInstruction22s) instruction22s;
        }
        return new ImmutableInstruction22s(instruction22s.getOpcode(), instruction22s.getRegisterA(), instruction22s.getRegisterB(), instruction22s.getNarrowLiteral());
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

    @Override // org.jf.dexlib2.iface.instruction.TwoRegisterInstruction
    public int getRegisterB() {
        return this.registerB;
    }

    @Override // org.jf.dexlib2.iface.instruction.WideLiteralInstruction
    public long getWideLiteral() {
        return this.literal;
    }
}
