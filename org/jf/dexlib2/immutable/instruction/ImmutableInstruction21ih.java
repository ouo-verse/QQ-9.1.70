package org.jf.dexlib2.immutable.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.Instruction21ih;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableInstruction21ih extends ImmutableInstruction implements Instruction21ih {
    public static final Format FORMAT = Format.Format21ih;
    protected final int literal;
    protected final int registerA;

    public ImmutableInstruction21ih(@Nonnull Opcode opcode, int i3, int i16) {
        super(opcode);
        this.registerA = Preconditions.checkByteRegister(i3);
        this.literal = Preconditions.checkIntegerHatLiteral(i16);
    }

    public static ImmutableInstruction21ih of(Instruction21ih instruction21ih) {
        if (instruction21ih instanceof ImmutableInstruction21ih) {
            return (ImmutableInstruction21ih) instruction21ih;
        }
        return new ImmutableInstruction21ih(instruction21ih.getOpcode(), instruction21ih.getRegisterA(), instruction21ih.getNarrowLiteral());
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return FORMAT;
    }

    @Override // org.jf.dexlib2.iface.instruction.HatLiteralInstruction
    public short getHatLiteral() {
        return (short) (this.literal >>> 16);
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
