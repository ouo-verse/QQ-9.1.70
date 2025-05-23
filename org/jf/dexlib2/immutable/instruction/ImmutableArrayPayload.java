package org.jf.dexlib2.immutable.instruction;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.Format;
import org.jf.dexlib2.Opcode;
import org.jf.dexlib2.iface.instruction.formats.ArrayPayload;
import org.jf.dexlib2.util.Preconditions;
import org.jf.util.ImmutableUtils;

/* loaded from: classes29.dex */
public class ImmutableArrayPayload extends ImmutableInstruction implements ArrayPayload {
    public static final Opcode OPCODE = Opcode.ARRAY_PAYLOAD;

    @Nonnull
    protected final ImmutableList<Number> arrayElements;
    protected final int elementWidth;

    public ImmutableArrayPayload(int i3, @Nullable List<Number> list) {
        super(OPCODE);
        this.elementWidth = Preconditions.checkArrayPayloadElementWidth(i3);
        this.arrayElements = (ImmutableList) Preconditions.checkArrayPayloadElements(i3, list == null ? ImmutableList.of() : ImmutableList.copyOf((Collection) list));
    }

    @Nonnull
    public static ImmutableArrayPayload of(ArrayPayload arrayPayload) {
        if (arrayPayload instanceof ImmutableArrayPayload) {
            return (ImmutableArrayPayload) arrayPayload;
        }
        return new ImmutableArrayPayload(arrayPayload.getElementWidth(), arrayPayload.getArrayElements());
    }

    @Override // org.jf.dexlib2.iface.instruction.formats.ArrayPayload
    @Nonnull
    public List<Number> getArrayElements() {
        return this.arrayElements;
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction, org.jf.dexlib2.iface.instruction.Instruction
    public int getCodeUnits() {
        return (((this.elementWidth * this.arrayElements.size()) + 1) / 2) + 4;
    }

    @Override // org.jf.dexlib2.iface.instruction.formats.ArrayPayload
    public int getElementWidth() {
        return this.elementWidth;
    }

    @Override // org.jf.dexlib2.immutable.instruction.ImmutableInstruction
    public Format getFormat() {
        return OPCODE.format;
    }

    public ImmutableArrayPayload(int i3, @Nullable ImmutableList<Number> immutableList) {
        super(OPCODE);
        this.elementWidth = Preconditions.checkArrayPayloadElementWidth(i3);
        this.arrayElements = (ImmutableList) Preconditions.checkArrayPayloadElements(i3, ImmutableUtils.nullToEmptyList(immutableList));
    }
}
