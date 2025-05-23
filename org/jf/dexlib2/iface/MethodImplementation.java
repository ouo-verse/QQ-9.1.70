package org.jf.dexlib2.iface;

import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.instruction.Instruction;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface MethodImplementation {
    @Nonnull
    Iterable<? extends DebugItem> getDebugItems();

    @Nonnull
    Iterable<? extends Instruction> getInstructions();

    int getRegisterCount();

    @Nonnull
    List<? extends TryBlock<? extends ExceptionHandler>> getTryBlocks();
}
