package org.jf.dexlib2.immutable.instruction;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;
import org.jf.dexlib2.util.Preconditions;
import org.jf.util.ImmutableUtils;

/* loaded from: classes29.dex */
public class ImmutablePackedSwitchPayload extends ImmutableInstruction implements PackedSwitchPayload {
    public static final Opcode OPCODE = Opcode.PACKED_SWITCH_PAYLOAD;

    @Nonnull
    protected final ImmutableList<? extends ImmutableSwitchElement> switchElements;

    public ImmutablePackedSwitchPayload(@Nullable List<? extends SwitchElement> list) {
        super(OPCODE);
        this.switchElements = (ImmutableList) Preconditions.checkSequentialOrderedKeys(ImmutableSwitchElement.immutableListOf(list));
    }

    @Nonnull
    public static ImmutablePackedSwitchPayload of(PackedSwitchPayload packedSwitchPayload) {
        if (packedSwitchPayload instanceof ImmutablePackedSwitchPayload) {
            return (ImmutablePackedSwitchPayload) packedSwitchPayload;
        }
        return new ImmutablePackedSwitchPayload(packedSwitchPayload.getSwitchElements());
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction, org.jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (this.switchElements.size() * 2) + 4;
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return OPCODE.format;
    }

    @Override // org.jf.dexlib2.iface.instruction.formats.PackedSwitchPayload, org.jf.dexlib2.iface.instruction.SwitchPayload
    @Nonnull
    public List<? extends SwitchElement> getSwitchElements() {
        return this.switchElements;
    }

    public ImmutablePackedSwitchPayload(@Nullable ImmutableList<? extends ImmutableSwitchElement> immutableList) {
        super(OPCODE);
        this.switchElements = (ImmutableList) Preconditions.checkSequentialOrderedKeys(ImmutableUtils.nullToEmptyList(immutableList));
    }
}
