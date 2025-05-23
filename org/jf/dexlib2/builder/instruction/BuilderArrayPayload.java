package org.jf.dexlib2.builder.instruction;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.builder.BuilderInstruction;
import org.jf.dexlib2.iface.instruction.formats.ArrayPayload;

/* loaded from: classes29.dex */
public class BuilderArrayPayload extends BuilderInstruction implements ArrayPayload {
    public static final Opcode OPCODE = Opcode.ARRAY_PAYLOAD;

    @Nonnull
    protected final List<Number> arrayElements;
    protected final int elementWidth;

    public BuilderArrayPayload(int i3, @Nullable List<Number> list) {
        super(OPCODE);
        this.elementWidth = i3;
        this.arrayElements = list == null ? ImmutableList.of() : list;
    }

    @Override // org.jf.dexlib2.iface.instruction.formats.ArrayPayload
    @Nonnull
    public List<Number> getArrayElements() {
        return this.arrayElements;
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction, org.jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (((this.elementWidth * this.arrayElements.size()) + 1) / 2) + 4;
    }

    @Override // org.jf.dexlib2.iface.instruction.formats.ArrayPayload
    public int getElementWidth() {
        return this.elementWidth;
    }

    @Override // org.jf.dexlib2.builder.BuilderInstruction
    public Format getFormat() {
        return OPCODE.format;
    }
}
