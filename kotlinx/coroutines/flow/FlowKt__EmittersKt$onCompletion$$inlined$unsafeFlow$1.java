package kotlinx.coroutines.flow;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", QCircleDaTongConstant.ElementParamValue.COLLECT, "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ Flow $this_onCompletion$inlined;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 1, 2}, l = {114, 121, 128}, m = QCircleDaTongConstant.ElementParamValue.COLLECT, n = {"this", "$this$onCompletion_u24lambda_u2d3", "e", "sc"}, s = {"L$0", "L$1", "L$0", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1, reason: invalid class name */
    /* loaded from: classes28.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.$this_onCompletion$inlined = flow;
        this.$action$inlined = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        Object invokeSafely$FlowKt__EmittersKt;
        SafeCollector safeCollector;
        SafeCollector safeCollector2;
        Object invoke;
        try {
            if (continuation instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) continuation;
                int i16 = anonymousClass1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.label = i16 - Integer.MIN_VALUE;
                    Object obj = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 == 3) {
                                    safeCollector2 = (SafeCollector) anonymousClass1.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                        safeCollector2.releaseIntercepted();
                                        return Unit.INSTANCE;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        safeCollector2.releaseIntercepted();
                                        throw th;
                                    }
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Throwable th6 = (Throwable) anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj);
                            throw th6;
                        }
                        flowCollector = (FlowCollector) anonymousClass1.L$1;
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Throwable th7) {
                            th = th7;
                            ThrowingCollector throwingCollector = new ThrowingCollector(th);
                            Function3 function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                            anonymousClass1.L$0 = th;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 2;
                            invokeSafely$FlowKt__EmittersKt = FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function3, th, anonymousClass1);
                            if (invokeSafely$FlowKt__EmittersKt != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw th;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        try {
                            Flow flow = this.$this_onCompletion$inlined;
                            anonymousClass1.L$0 = this;
                            anonymousClass1.L$1 = flowCollector;
                            anonymousClass1.label = 1;
                            if (flow.collect(flowCollector, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                        } catch (Throwable th8) {
                            th = th8;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                            ThrowingCollector throwingCollector2 = new ThrowingCollector(th);
                            Function3 function32 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                            anonymousClass1.L$0 = th;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 2;
                            invokeSafely$FlowKt__EmittersKt = FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector2, function32, th, anonymousClass1);
                            if (invokeSafely$FlowKt__EmittersKt != coroutine_suspended) {
                            }
                        }
                    }
                    safeCollector = new SafeCollector(flowCollector, anonymousClass1.getContext());
                    Function3 function33 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
                    anonymousClass1.L$0 = safeCollector;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 3;
                    InlineMarker.mark(6);
                    invoke = function33.invoke(safeCollector, null, anonymousClass1);
                    InlineMarker.mark(7);
                    if (invoke != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    safeCollector2 = safeCollector;
                    safeCollector2.releaseIntercepted();
                    return Unit.INSTANCE;
                }
            }
            Function3 function332 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.$action$inlined;
            anonymousClass1.L$0 = safeCollector;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 3;
            InlineMarker.mark(6);
            invoke = function332.invoke(safeCollector, null, anonymousClass1);
            InlineMarker.mark(7);
            if (invoke != coroutine_suspended) {
            }
        } catch (Throwable th9) {
            th = th9;
            safeCollector2 = safeCollector;
            safeCollector2.releaseIntercepted();
            throw th;
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 == 0) {
        }
        safeCollector = new SafeCollector(flowCollector, anonymousClass1.getContext());
    }
}
