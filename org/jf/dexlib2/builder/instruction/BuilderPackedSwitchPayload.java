package org.jf.dexlib2.builder.instruction;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderSwitchPayload;
import org.jf.dexlib2.builder.Label;
import org.jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;

/* loaded from: classes29.dex */
public class BuilderPackedSwitchPayload extends BuilderSwitchPayload implements PackedSwitchPayload {
    public static final Opcode OPCODE = Opcode.PACKED_SWITCH_PAYLOAD;

    @Nonnull
    protected final List<BuilderSwitchElement> switchElements;

    public BuilderPackedSwitchPayload(int i3, @Nullable List<? extends Label> list) {
        super(OPCODE);
        if (list == null) {
            this.switchElements = ImmutableList.of();
            return;
        }
        this.switchElements = Lists.h();
        Iterator<? extends Label> it = list.iterator();
        while (it.hasNext()) {
            this.switchElements.add(new BuilderSwitchElement(this, i3, it.next()));
            i3++;
        }
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction, org.jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (this.switchElements.size() * 2) + 4;
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
