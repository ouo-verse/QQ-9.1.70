package org.jf.dexlib2.immutable.instruction;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.instruction.formats.SparseSwitchPayload;
import org.jf.util.ImmutableUtils;

/* loaded from: classes29.dex */
public class ImmutableSparseSwitchPayload extends ImmutableInstruction implements SparseSwitchPayload {
    public static final Opcode OPCODE = Opcode.SPARSE_SWITCH_PAYLOAD;

    @Nonnull
    protected final ImmutableList<? extends ImmutableSwitchElement> switchElements;

    public ImmutableSparseSwitchPayload(@Nullable List<? extends SwitchElement> list) {
        super(OPCODE);
        this.switchElements = ImmutableSwitchElement.immutableListOf(list);
    }

    @Nonnull
    public static ImmutableSparseSwitchPayload of(SparseSwitchPayload sparseSwitchPayload) {
        if (sparseSwitchPayload instanceof ImmutableSparseSwitchPayload) {
            return (ImmutableSparseSwitchPayload) sparseSwitchPayload;
        }
        return new ImmutableSparseSwitchPayload(sparseSwitchPayload.getSwitchElements());
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction, org.jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (this.switchElements.size() * 4) + 2;
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return OPCODE.format;
    }

    @Override // org.jf.dexlib2.iface.instruction.SwitchPayload
    @Nonnull
    public List<? extends SwitchElement> getSwitchElements() {
        return this.switchElements;
    }

    public ImmutableSparseSwitchPayload(@Nullable ImmutableList<? extends ImmutableSwitchElement> immutableList) {
        super(OPCODE);
        this.switchElements = ImmutableUtils.nullToEmptyList(immutableList);
    }
}
