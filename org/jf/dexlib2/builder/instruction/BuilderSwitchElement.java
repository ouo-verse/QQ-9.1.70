package org.jf.dexlib2.builder.instruction;

import javax.annotation.Nonnull;
import org.jf.dexlib2.builder.BuilderSwitchPayload;
import org.jf.dexlib2.builder.Label;
import org.jf.dexlib2.iface.instruction.SwitchElement;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderSwitchElement implements SwitchElement {
    private final int key;

    @Nonnull
    BuilderSwitchPayload parent;

    @Nonnull
    private final Label target;

    public BuilderSwitchElement(@Nonnull BuilderSwitchPayload builderSwitchPayload, int i3, @Nonnull Label label) {
        this.parent = builderSwitchPayload;
        this.key = i3;
        this.target = label;
    }

    @Override // org.jf.dexlib2.iface.instruction.SwitchElement
    public int getKey() {
        return this.key;
    }

    @Override // org.jf.dexlib2.iface.instruction.SwitchElement
    public int getOffset() {
        return this.target.getCodeAddress() - this.parent.getReferrer().getCodeAddress();
    }

    @Nonnull
    public Label getTarget() {
        return this.target;
    }
}
