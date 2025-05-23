package org.jf.dexlib2.builder;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.instruction.BuilderSwitchElement;
import org.jf.dexlib2.iface.instruction.SwitchPayload;

/* loaded from: classes29.dex */
public abstract class BuilderSwitchPayload extends BuilderInstruction implements SwitchPayload {

    @Nullable
    MethodLocation referrer;

    /* JADX INFO: Access modifiers changed from: protected */
    public BuilderSwitchPayload(@Nonnull Opcode opcode) {
        super(opcode);
    }

    @Nonnull
    public MethodLocation getReferrer() {
        MethodLocation methodLocation = this.referrer;
        if (methodLocation != null) {
            return methodLocation;
        }
        throw new IllegalStateException("The referrer has not been set yet");
    }

    @Override // org.jf.dexlib2.iface.instruction.SwitchPayload
    @Nonnull
    public abstract List<? extends BuilderSwitchElement> getSwitchElements();
}
