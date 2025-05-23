package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\u00020\u0004B\u001b\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ'\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ%\u0010\u001a\u001a\u0004\u0018\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J \u0010$\u001a\u00020\u001c2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0&H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0010H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collector", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collectContextSize", "", "completion", "Lkotlin/coroutines/Continuation;", "", "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "lastEmissionContext", "checkContext", "currentContext", "previousContext", "value", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "uCont", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "exceptionTransparencyViolated", "exception", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T> {

    @JvmField
    @NotNull
    public final CoroutineContext collectContext;

    @JvmField
    public final int collectContextSize;

    @JvmField
    @NotNull
    public final FlowCollector<T> collector;

    @Nullable
    private Continuation<? super Unit> completion;

    @Nullable
    private CoroutineContext lastEmissionContext;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(@NotNull FlowCollector<? super T> flowCollector, @NotNull CoroutineContext coroutineContext) {
        super(NoOpContinuation.INSTANCE, EmptyCoroutineContext.INSTANCE);
        this.collector = flowCollector;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, new Function2<Integer, CoroutineContext.Element, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector$collectContextSize$1
            public final int invoke(int i3, @NotNull CoroutineContext.Element element) {
                return i3 + 1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.Element element) {
                return Integer.valueOf(invoke(num.intValue(), element));
            }
        })).intValue();
    }

    private final void checkContext(CoroutineContext currentContext, CoroutineContext previousContext, T value) {
        if (previousContext instanceof DownstreamExceptionElement) {
            exceptionTransparencyViolated((DownstreamExceptionElement) previousContext, value);
        }
        SafeCollector_commonKt.checkContext(this, currentContext);
        this.lastEmissionContext = currentContext;
    }

    private final void exceptionTransparencyViolated(DownstreamExceptionElement exception, Object value) {
        String trimIndent;
        trimIndent = StringsKt__IndentKt.trimIndent("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + exception.e + ", but then emission attempt of value '" + value + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(trimIndent.toString());
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t16, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        try {
            Object emit = emit(continuation, (Continuation<? super Unit>) t16);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (emit == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return emit == coroutine_suspended2 ? emit : Unit.INSTANCE;
        } catch (Throwable th5) {
            this.lastEmissionContext = new DownstreamExceptionElement(th5);
            throw th5;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.Continuation
    @NotNull
    /* renamed from: getContext */
    public CoroutineContext get$context() {
        CoroutineContext coroutineContext;
        Continuation<? super Unit> continuation = this.completion;
        if (continuation == null) {
            coroutineContext = null;
        } else {
            coroutineContext = continuation.get$context();
        }
        if (coroutineContext == null) {
            return EmptyCoroutineContext.INSTANCE;
        }
        return coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public Object invokeSuspend(@NotNull Object result) {
        Object coroutine_suspended;
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(result);
        if (m479exceptionOrNullimpl != null) {
            this.lastEmissionContext = new DownstreamExceptionElement(m479exceptionOrNullimpl);
        }
        Continuation<? super Unit> continuation = this.completion;
        if (continuation != null) {
            continuation.resumeWith(result);
        }
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return coroutine_suspended;
    }

    @Override // kotlin.coroutines.jvm.internal.ContinuationImpl, kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }

    private final Object emit(Continuation<? super Unit> uCont, T value) {
        CoroutineContext coroutineContext = uCont.get$context();
        JobKt.ensureActive(coroutineContext);
        CoroutineContext coroutineContext2 = this.lastEmissionContext;
        if (coroutineContext2 != coroutineContext) {
            checkContext(coroutineContext, coroutineContext2, value);
        }
        this.completion = uCont;
        return SafeCollectorKt.access$getEmitFun$p().invoke(this.collector, value, this);
    }
}
