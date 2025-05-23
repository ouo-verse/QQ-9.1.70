package org.jf.dexlib2.immutable;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.MethodImplementation;
import org.jf.dexlib2.iface.TryBlock;
import org.jf.dexlib2.iface.debug.DebugItem;
import org.jf.dexlib2.iface.instruction.Instruction;
import org.jf.dexlib2.immutable.debug.ImmutableDebugItem;
import org.jf.dexlib2.immutable.instruction.ImmutableInstruction;
import org.jf.util.ImmutableUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableMethodImplementation implements MethodImplementation {

    @Nonnull
    protected final ImmutableList<? extends ImmutableDebugItem> debugItems;

    @Nonnull
    protected final ImmutableList<? extends ImmutableInstruction> instructions;
    protected final int registerCount;

    @Nonnull
    protected final ImmutableList<? extends ImmutableTryBlock> tryBlocks;

    public ImmutableMethodImplementation(int i3, @Nullable Iterable<? extends Instruction> iterable, @Nullable List<? extends TryBlock<? extends ExceptionHandler>> list, @Nullable Iterable<? extends DebugItem> iterable2) {
        this.registerCount = i3;
        this.instructions = ImmutableInstruction.immutableListOf(iterable);
        this.tryBlocks = ImmutableTryBlock.immutableListOf(list);
        this.debugItems = ImmutableDebugItem.immutableListOf(iterable2);
    }

    @Nullable
    public static ImmutableMethodImplementation of(@Nullable MethodImplementation methodImplementation) {
        if (methodImplementation == null) {
            return null;
        }
        if (methodImplementation instanceof ImmutableMethodImplementation) {
            return (ImmutableMethodImplementation) methodImplementation;
        }
        return new ImmutableMethodImplementation(methodImplementation.getRegisterCount(), methodImplementation.getInstructions(), methodImplementation.getTryBlocks(), methodImplementation.getDebugItems());
    }

    @Override // org.jf.dexlib2.iface.MethodImplementation
    public int getRegisterCount() {
        return this.registerCount;
    }

    @Override // org.jf.dexlib2.iface.MethodImplementation
    @Nonnull
    public ImmutableList<? extends ImmutableDebugItem> getDebugItems() {
        return this.debugItems;
    }

    @Override // org.jf.dexlib2.iface.MethodImplementation
    @Nonnull
    public ImmutableList<? extends ImmutableInstruction> getInstructions() {
        return this.instructions;
    }

    @Override // org.jf.dexlib2.iface.MethodImplementation
    @Nonnull
    public ImmutableList<? extends ImmutableTryBlock> getTryBlocks() {
        return this.tryBlocks;
    }

    public ImmutableMethodImplementation(int i3, @Nullable ImmutableList<? extends ImmutableInstruction> immutableList, @Nullable ImmutableList<? extends ImmutableTryBlock> immutableList2, @Nullable ImmutableList<? extends ImmutableDebugItem> immutableList3) {
        this.registerCount = i3;
        this.instructions = ImmutableUtils.nullToEmptyList(immutableList);
        this.tryBlocks = ImmutableUtils.nullToEmptyList(immutableList2);
        this.debugItems = ImmutableUtils.nullToEmptyList(immutableList3);
    }
}
