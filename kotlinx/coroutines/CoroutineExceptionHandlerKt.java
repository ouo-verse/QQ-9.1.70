package kotlinx.coroutines;

import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a%\u0010\u0000\u001a\u00020\u00012\u001a\b\u0004\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0086\b\u001a\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0005H\u0007\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0000\u00a8\u0006\r"}, d2 = {"CoroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handler", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "", "", "handleCoroutineException", "context", "exception", "handlerException", "originalException", "thrownException", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class CoroutineExceptionHandlerKt {
    @NotNull
    public static final CoroutineExceptionHandler CoroutineExceptionHandler(@NotNull Function2<? super CoroutineContext, ? super Throwable, Unit> function2) {
        return new CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1(function2, CoroutineExceptionHandler.INSTANCE);
    }

    @InternalCoroutinesApi
    public static final void handleCoroutineException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th5) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.get(CoroutineExceptionHandler.INSTANCE);
            if (coroutineExceptionHandler == null) {
                CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(coroutineContext, th5);
            } else {
                coroutineExceptionHandler.handleException(coroutineContext, th5);
            }
        } catch (Throwable th6) {
            CoroutineExceptionHandlerImplKt.handleCoroutineExceptionImpl(coroutineContext, handlerException(th5, th6));
        }
    }

    @NotNull
    public static final Throwable handlerException(@NotNull Throwable th5, @NotNull Throwable th6) {
        if (th5 == th6) {
            return th5;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th6);
        ExceptionsKt__ExceptionsKt.addSuppressed(runtimeException, th5);
        return runtimeException;
    }
}
