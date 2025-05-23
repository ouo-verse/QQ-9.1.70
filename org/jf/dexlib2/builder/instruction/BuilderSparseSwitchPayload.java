package org.jf.dexlib2.builder.instruction;

import com.google.common.base.d;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderSwitchPayload;
import org.jf.dexlib2.builder.SwitchLabelElement;
import org.jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;

/* loaded from: classes29.dex */
public class BuilderSparseSwitchPayload extends BuilderSwitchPayload implements SparseSwitchPayload {
    public static final Opcode OPCODE = Opcode.SPARSE_SWITCH_PAYLOAD;

    @Nonnull
    protected final List<BuilderSwitchElement> switchElements;

    public BuilderSparseSwitchPayload(@Nullable List<? extends SwitchLabelElement> list) {
        super(OPCODE);
        if (list == null) {
            this.switchElements = ImmutableList.of();
        } else {
            this.switchElements = Lists.n(list, new d<SwitchLabelElement, BuilderSwitchElement>() { // from class: org.jf.dexlib2.builder.instruction.BuilderSparseSwitchPayload.1
                static final /* synthetic */ boolean $assertionsDisabled = false;

                @Override // com.google.common.base.d
                @Nullable
                public BuilderSwitchElement apply(@Nullable SwitchLabelElement switchLabelElement) {
                    return new BuilderSwitchElement(BuilderSparseSwitchPayload.this, switchLabelElement.key, switchLabelElement.target);
                }
            });
        }
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction, org.jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (this.switchElements.size() * 4) + 2;
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return OPCODE.format;
    }

    @Override // org.jf.dexlib2.builder.BuilderSwitchPayload, org.jf.dexlib2.iface.instruction.SwitchPayload
    @Nonnull
    public List<BuilderSwitchElement> getSwitchElements() {
        return this.switchElements;
    }
}
