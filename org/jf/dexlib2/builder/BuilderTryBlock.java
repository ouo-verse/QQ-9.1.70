package org.jf.dexlib2.builder;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseTryBlock;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderTryBlock extends BaseTryBlock<BuilderExceptionHandler> {

    @Nonnull
    public final Label end;

    @Nonnull
    public final BuilderExceptionHandler exceptionHandler;

    @Nonnull
    public final Label start;

    public BuilderTryBlock(@Nonnull Label label, @Nonnull Label label2, @Nullable String str, @Nonnull Label label3) {
        this.start = label;
        this.end = label2;
        this.exceptionHandler = BuilderExceptionHandler.newExceptionHandler(str, label3);
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    public int getCodeUnitCount() {
        return this.end.getCodeAddress() - this.start.getCodeAddress();
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    @Nonnull
    public List<? extends BuilderExceptionHandler> getExceptionHandlers() {
        return ImmutableList.of(this.exceptionHandler);
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    public int getStartCodeAddress() {
        return this.start.getCodeAddress();
    }

    public BuilderTryBlock(@Nonnull Label label, @Nonnull Label label2, @Nullable TypeReference typeReference, @Nonnull Label label3) {
        this.start = label;
        this.end = label2;
        this.exceptionHandler = BuilderExceptionHandler.newExceptionHandler(typeReference, label3);
    }

    public BuilderTryBlock(@Nonnull Label label, @Nonnull Label label2, @Nonnull Label label3) {
        this.start = label;
        this.end = label2;
        this.exceptionHandler = BuilderExceptionHandler.newExceptionHandler(label3);
    }
}
