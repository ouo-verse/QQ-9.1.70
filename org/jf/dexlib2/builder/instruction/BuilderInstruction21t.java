package org.jf.dexlib2.builder.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderOffsetInstruction;
import org.jf.dexlib2.builder.Label;
import org.jf.dexlib2.iface.instruction.formats.Instruction21t;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderInstruction21t extends BuilderOffsetInstruction implements Instruction21t {
    public static final Format FORMAT = Format.Format21t;
    protected final int registerA;

    public BuilderInstruction21t(@Nonnull Opcode opcode, int i3, @Nonnull Label label) {
        super(opcode, label);
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
