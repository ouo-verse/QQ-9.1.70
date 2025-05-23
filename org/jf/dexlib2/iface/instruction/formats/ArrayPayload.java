package org.jf.dexlib2.iface.instruction.formats;

import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.instruction.PayloadInstruction;

/* loaded from: classes29.dex */
public interface ArrayPayload extends PayloadInstruction {
    @Nonnull
    List<Number> getArrayElements();

    int getElementWidth();
}
