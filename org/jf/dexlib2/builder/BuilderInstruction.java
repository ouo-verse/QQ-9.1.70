package org.jf.dexlib2.builder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.util.Preconditions;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BuilderInstruction implements Instruction {

    @Nullable
    MethodLocation location;

    @Nonnull
    protected final Opcode opcode;

    /* JADX INFO: Access modifiers changed from: protected */
    public BuilderInstruction(@Nonnull Opcode opcode) {
        Preconditions.checkFormat(opcode, getFormat());
        this.opcode = opcode;
    }

    @Override // org.jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return getFormat().size / 2;
    }

    public abstract Format getFormat();

    @Nonnull
    public MethodLocation getLocation() {
        MethodLocation methodLocation = this.location;
        if (methodLocation != null) {
            return methodLocation;
        }
        throw new IllegalStateException("Cannot get the location of an instruction that hasn't been added to a method.");
    }

    @Override // org.jf.dexlib2.iface.instruction.Instruction
    @Nonnull
    public Opcode getOpcode() {
        return this.opcode;
    }
}
