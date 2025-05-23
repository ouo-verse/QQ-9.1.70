package org.jf.dexlib2.builder;

import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.OffsetInstruction;
import org.jf.util.ExceptionWithContext;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BuilderOffsetInstruction extends BuilderInstruction implements OffsetInstruction {

    @Nonnull
    protected final Label target;

    public BuilderOffsetInstruction(@Nonnull Opcode opcode, @Nonnull Label label) {
        super(opcode);
        this.target = label;
    }

    @Override // org.jf.dexlib2.iface.instruction.OffsetInstruction
    public int getCodeOffset() {
        int internalGetCodeOffset = internalGetCodeOffset();
        if (getCodeUnits() == 1) {
            if (internalGetCodeOffset < -128 || internalGetCodeOffset > 127) {
                throw new ExceptionWithContext("Invalid instruction offset: %d. Offset must be in [-128, 127]", Integer.valueOf(internalGetCodeOffset));
            }
        } else if (getCodeUnits() == 2 && (internalGetCodeOffset < -32768 || internalGetCodeOffset > 32767)) {
            throw new ExceptionWithContext("Invalid instruction offset: %d. Offset must be in [-32768, 32767]", Integer.valueOf(internalGetCodeOffset));
        }
        return internalGetCodeOffset;
    }

    @Nonnull
    public Label getTarget() {
        return this.target;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int internalGetCodeOffset() {
        return this.target.getCodeAddress() - getLocation().getCodeAddress();
    }
}
