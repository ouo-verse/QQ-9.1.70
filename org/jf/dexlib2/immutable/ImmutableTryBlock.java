package org.jf.dexlib2.immutable;

import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseTryBlock;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.TryBlock;
import org.jf.util.ImmutableConverter;
import org.jf.util.ImmutableUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableTryBlock extends BaseTryBlock<ImmutableExceptionHandler> {
    private static final ImmutableConverter<ImmutableTryBlock, TryBlock<? extends ExceptionHandler>> CONVERTER = new ImmutableConverter<ImmutableTryBlock, TryBlock<? extends ExceptionHandler>>() { // from class: org.jf.dexlib2.immutable.ImmutableTryBlock.1
        @Override // org.jf.util.ImmutableConverter
        protected /* bridge */ /* synthetic */ boolean isImmutable(@Nonnull TryBlock<? extends ExceptionHandler> tryBlock) {
            return isImmutable2((TryBlock) tryBlock);
        }

        /* renamed from: isImmutable, reason: avoid collision after fix types in other method */
        protected boolean isImmutable2(@Nonnull TryBlock tryBlock) {
            return tryBlock instanceof ImmutableTryBlock;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public ImmutableTryBlock makeImmutable(@Nonnull TryBlock<? extends ExceptionHandler> tryBlock) {
            return ImmutableTryBlock.of(tryBlock);
        }
    };
    protected final int codeUnitCount;

    @Nonnull
    protected final ImmutableList<? extends ImmutableExceptionHandler> exceptionHandlers;
    protected final int startCodeAddress;

    public ImmutableTryBlock(int i3, int i16, @Nullable List<? extends ExceptionHandler> list) {
        this.startCodeAddress = i3;
        this.codeUnitCount = i16;
        this.exceptionHandlers = ImmutableExceptionHandler.immutableListOf(list);
    }

    @Nonnull
    public static ImmutableList<ImmutableTryBlock> immutableListOf(@Nullable List<? extends TryBlock<? extends ExceptionHandler>> list) {
        return CONVERTER.toList(list);
    }

    public static ImmutableTryBlock of(TryBlock<? extends ExceptionHandler> tryBlock) {
        if (tryBlock instanceof ImmutableTryBlock) {
            return (ImmutableTryBlock) tryBlock;
        }
        return new ImmutableTryBlock(tryBlock.getStartCodeAddress(), tryBlock.getCodeUnitCount(), (List<? extends ExceptionHandler>) tryBlock.getExceptionHandlers());
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    public int getCodeUnitCount() {
        return this.codeUnitCount;
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    public int getStartCodeAddress() {
        return this.startCodeAddress;
    }

    @Override // org.jf.dexlib2.iface.TryBlock
    @Nonnull
    public ImmutableList<? extends ImmutableExceptionHandler> getExceptionHandlers() {
        return this.exceptionHandlers;
    }

    public ImmutableTryBlock(int i3, int i16, @Nullable ImmutableList<? extends ImmutableExceptionHandler> immutableList) {
        this.startCodeAddress = i3;
        this.codeUnitCount = i16;
        this.exceptionHandlers = ImmutableUtils.nullToEmptyList(immutableList);
    }
}
