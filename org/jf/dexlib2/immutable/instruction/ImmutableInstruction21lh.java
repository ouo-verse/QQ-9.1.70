package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction21lh;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction21lh extends ImmutableInstruction implements Instruction21lh {
    public static final Format FORMAT = Format.Format21lh;
    protected final long literal;
    protected final int registerA;

    public ImmutableInstruction21lh(@Nonnull Opcode opcode, int i3, long j3) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
        this.literal = Preconditions.checkLongHatLiteral(j3);
    }

    public static ImmutableInstruction21lh of(Instruction21lh instruction21lh) {
        if (instruction21lh instanceof ImmutableInstruction21lh) {
            return (ImmutableInstruction21lh) instruction21lh;
        }
        return new ImmutableInstruction21lh(instruction21lh.getOpcode(), instruction21lh.getRegisterA(), instruction21lh.getWideLiteral());
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.HatLiteralInstruction
    public short getHatLiteral() {
        return (short) (this.literal >>> 48);
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
