package org.jf.dexlib2.dexbacked.instruction;

import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;
import org.jf.dexlib2.dexbacked.util.FixedSizeList;
import org.jf.dexlib2.iface.instruction.SwitchElement;
import org.jf.dexlib2.iface.instruction.formats.PackedSwitchPayload;

/* loaded from: classes29.dex */
public class DexBackedPackedSwitchPayload extends DexBackedInstruction implements PackedSwitchPayload {
    private static final int ELEMENT_COUNT_OFFSET = 2;
    private static final int FIRST_KEY_OFFSET = 4;
    private static final int TARGETS_OFFSET = 8;
    public final int elementCount;

    public DexBackedPackedSwitchPayload(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        super(dexBackedDexFile, Opcode.PACKED_SWITCH_PAYLOAD, i3);
        this.elementCount = dexBackedDexFile.getDataBuffer().readUshort(i3 + 2);
    }

    @Override // org.jf.dexlib2.dexbacked.instruction.DexBackedInstruction, org.jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (this.elementCount * 2) + 4;
    }

    @Override // org.jf.dexlib2.iface.instruction.formats.PackedSwitchPayload, org.jf.dexlib2.iface.instruction.SwitchPayload
    @Nonnull
    public List<? extends SwitchElement> getSwitchElements() {
        final int readInt = this.dexFile.getDataBuffer().readInt(this.instructionStart + 4);
        return new FixedSizeList<SwitchElement>() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedPackedSwitchPayload.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return DexBackedPackedSwitchPayload.this.elementCount;
            }

            @Override // org.jf.dexlib2.dexbacked.util.FixedSizeList
            @Nonnull
            public SwitchElement readItem(final int i3) {
                return new SwitchElement() { // from class: org.jf.dexlib2.dexbacked.instruction.DexBackedPackedSwitchPayload.1.1
                    @Override // org.jf.dexlib2.iface.instruction.SwitchElement
                    public int getKey() {
                        return readInt + i3;
                    }

                    @Override // org.jf.dexlib2.iface.instruction.SwitchElement
                    public int getOffset() {
                        return DexBackedPackedSwitchPayload.this.dexFile.getDataBuffer().readInt(DexBackedPackedSwitchPayload.this.instructionStart + 8 + (i3 * 4));
                    }
                };
            }
        };
    }
}
