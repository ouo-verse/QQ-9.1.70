package org.jf.dexlib2.writer.builder;

import java.util.List;
import javax.annotation.Nonnull;
import org.jf.dexlib2.base.BaseTryBlock;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderTryBlock extends BaseTryBlock<BuilderExceptionHandler> {
    private final int codeUnitCount;

    @Nonnull
    private final List<? extends BuilderExceptionHandler> exceptionHandlers;
    private final int startCodeAddress;

    public BuilderTryBlock(int i3, int i16, @Nonnull List<? extends BuilderExceptionHandler> list) {
        this.startCodeAddress = i3;
        this.codeUnitCount = i16;
        this.exceptionHandlers = list;
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    public int getCodeUnitCount() {
        return this.codeUnitCount;
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    @Nonnull
    public List<? extends BuilderExceptionHandler> getExceptionHandlers() {
        return this.exceptionHandlers;
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    public int getStartCodeAddress() {
        return this.startCodeAddress;
    }
}
