package kotlinx.coroutines.channels;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u001a\u009e\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2-\b\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017\u00a2\u0006\u0002\b\u001aH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001b\u001a\u00a8\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2-\b\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017\u00a2\u0006\u0002\b\u001aH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001e\u001ae\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017\u00a2\u0006\u0002\b\u001aH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"awaitClose", "", "Lkotlinx/coroutines/channels/ProducerScope;", "block", "Lkotlin/Function0;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produce", "Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ProduceKt {
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @ExperimentalCoroutinesApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitClose(@NotNull ProducerScope<?> producerScope, @NotNull Function0<Unit> function0, @NotNull Continuation<? super Unit> continuation) {
        ProduceKt$awaitClose$1 produceKt$awaitClose$1;
        Object coroutine_suspended;
        int i3;
        boolean z16;
        Continuation intercepted;
        Object coroutine_suspended2;
        try {
            if (continuation instanceof ProduceKt$awaitClose$1) {
                produceKt$awaitClose$1 = (ProduceKt$awaitClose$1) continuation;
                int i16 = produceKt$awaitClose$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    produceKt$awaitClose$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = produceKt$awaitClose$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = produceKt$awaitClose$1.label;
                    if (i3 == 0) {
                        if (i3 == 1) {
                            function0 = (Function0) produceKt$awaitClose$1.L$1;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        if (produceKt$awaitClose$1.get$context().get(Job.INSTANCE) == producerScope) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            produceKt$awaitClose$1.L$0 = producerScope;
                            produceKt$awaitClose$1.L$1 = function0;
                            produceKt$awaitClose$1.label = 1;
                            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(produceKt$awaitClose$1);
                            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                            cancellableContinuationImpl.initCancellability();
                            producerScope.invokeOnClose(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.ProduceKt$awaitClose$4$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@Nullable Throwable th5) {
                                    cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                                }
                            });
                            Object result = cancellableContinuationImpl.getResult();
                            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (result == coroutine_suspended2) {
                                DebugProbes.probeCoroutineSuspended(produceKt$awaitClose$1);
                            }
                            if (result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
                        }
                    }
                    function0.invoke();
                    return Unit.INSTANCE;
                }
            }
            if (i3 == 0) {
            }
            function0.invoke();
            return Unit.INSTANCE;
        } catch (Throwable th5) {
            function0.invoke();
            throw th5;
        }
        produceKt$awaitClose$1 = new ProduceKt$awaitClose$1(continuation);
        Object obj2 = produceKt$awaitClose$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = produceKt$awaitClose$1.label;
    }

    public static /* synthetic */ Object awaitClose$default(ProducerScope producerScope, Function0 function0, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function0 = new Function0<Unit>() { // from class: kotlinx.coroutines.channels.ProduceKt$awaitClose$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return awaitClose(producerScope, function0, continuation);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <E> ReceiveChannel<E> produce(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i3, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return produce(coroutineScope, coroutineContext, i3, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, function2);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i3, Function2 function2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return produce(coroutineScope, coroutineContext, i3, function2);
    }

    @InternalCoroutinesApi
    @NotNull
    public static final <E> ReceiveChannel<E> produce(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i3, @NotNull CoroutineStart coroutineStart, @Nullable Function1<? super Throwable, Unit> function1, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return produce(coroutineScope, coroutineContext, i3, BufferOverflow.SUSPEND, coroutineStart, function1, function2);
    }

    @NotNull
    public static final <E> ReceiveChannel<E> produce(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i3, @NotNull BufferOverflow bufferOverflow, @NotNull CoroutineStart coroutineStart, @Nullable Function1<? super Throwable, Unit> function1, @BuilderInference @NotNull Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        ProducerCoroutine producerCoroutine = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext), ChannelKt.Channel$default(i3, bufferOverflow, null, 4, null));
        if (function1 != null) {
            producerCoroutine.invokeOnCompletion(function1);
        }
        producerCoroutine.start(coroutineStart, producerCoroutine, function2);
        return producerCoroutine;
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i3, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i16 & 8) != 0) {
            function1 = null;
        }
        return produce(coroutineScope, coroutineContext2, i17, coroutineStart2, function1, function2);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, Function1 function1, Function2 function2, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i16 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i16 & 16) != 0) {
            function1 = null;
        }
        return produce(coroutineScope, coroutineContext2, i17, bufferOverflow2, coroutineStart2, function1, function2);
    }
}
