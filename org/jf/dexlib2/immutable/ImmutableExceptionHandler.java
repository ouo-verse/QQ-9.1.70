package org.jf.dexlib2.immutable;

import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseExceptionHandler;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.util.ImmutableConverter;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableExceptionHandler extends BaseExceptionHandler {
    private static final ImmutableConverter<ImmutableExceptionHandler, ExceptionHandler> CONVERTER = new ImmutableConverter<ImmutableExceptionHandler, ExceptionHandler>() { // from class: org.jf.dexlib2.immutable.ImmutableExceptionHandler.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        public boolean isImmutable(@Nonnull ExceptionHandler exceptionHandler) {
            return exceptionHandler instanceof ImmutableExceptionHandler;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // org.jf.util.ImmutableConverter
        @Nonnull
        public ImmutableExceptionHandler makeImmutable(@Nonnull ExceptionHandler exceptionHandler) {
            return ImmutableExceptionHandler.of(exceptionHandler);
        }
    };

    @Nullable
    protected final String exceptionType;
    protected final int handlerCodeAddress;

    public ImmutableExceptionHandler(@Nullable String str, int i3) {
        this.exceptionType = str;
        this.handlerCodeAddress = i3;
    }

    @Nonnull
    public static ImmutableList<ImmutableExceptionHandler> immutableListOf(@Nullable Iterable<? extends ExceptionHandler> iterable) {
        return CONVERTER.toList(iterable);
    }

    public static ImmutableExceptionHandler of(ExceptionHandler exceptionHandler) {
        if (exceptionHandler instanceof ImmutableExceptionHandler) {
            return (ImmutableExceptionHandler) exceptionHandler;
        }
        return new ImmutableExceptionHandler(exceptionHandler.getExceptionType(), exceptionHandler.getHandlerCodeAddress());
    }

    @Override // org.jf.dexlib2.iface.ExceptionHandler
    @Nullable
    public String getExceptionType() {
        return this.exceptionType;
    }

    @Override // org.jf.dexlib2.iface.ExceptionHandler
    public int getHandlerCodeAddress() {
        return this.handlerCodeAddress;
    }
}
