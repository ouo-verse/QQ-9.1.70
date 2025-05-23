package kotlinx.coroutines.flow;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.SafeCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", QCircleDaTongConstant.ElementParamValue.COLLECT, "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function2 $action$inlined;
    final /* synthetic */ Flow $this_onEmpty$inlined;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0, 1}, l = {115, 122}, m = QCircleDaTongConstant.ElementParamValue.COLLECT, n = {"this", "$this$onEmpty_u24lambda_u2d5", "isEmpty", "collector"}, s = {"L$0", "L$1", "L$2", "L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1, reason: invalid class name */
    /* loaded from: classes28.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
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
            return FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(Flow flow, Function2 function2) {
        this.$this_onEmpty$inlined = flow;
        this.$action$inlined = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull final FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1<T> flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1;
        FlowCollector<? super T> flowCollector2;
        Ref.BooleanRef booleanRef;
        Throwable th5;
        SafeCollector safeCollector;
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
                        if (i3 == 2) {
                            safeCollector = (SafeCollector) anonymousClass1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                safeCollector.releaseIntercepted();
                                return Unit.INSTANCE;
                            } catch (Throwable th6) {
                                th5 = th6;
                                safeCollector.releaseIntercepted();
                                throw th5;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    booleanRef = (Ref.BooleanRef) anonymousClass1.L$2;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                    flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    booleanRef2.element = true;
                    Flow flow = this.$this_onEmpty$inlined;
                    FlowCollector<T> flowCollector3 = new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$lambda-5$$inlined$collect$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        @Nullable
                        public Object emit(T t16, @NotNull Continuation<? super Unit> continuation2) {
                            Object coroutine_suspended2;
                            Ref.BooleanRef.this.element = false;
                            Object emit = flowCollector.emit(t16, continuation2);
                            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (emit == coroutine_suspended2) {
                                return emit;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = flowCollector;
                    anonymousClass1.L$2 = booleanRef2;
                    anonymousClass1.label = 1;
                    if (flow.collect(flowCollector3, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 = this;
                    flowCollector2 = flowCollector;
                    booleanRef = booleanRef2;
                }
                if (booleanRef.element) {
                    SafeCollector safeCollector2 = new SafeCollector(flowCollector2, anonymousClass1.getContext());
                    try {
                        Function2 function2 = flowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.$action$inlined;
                        anonymousClass1.L$0 = safeCollector2;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.label = 2;
                        InlineMarker.mark(6);
                        Object invoke = function2.invoke(safeCollector2, anonymousClass1);
                        InlineMarker.mark(7);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                    } catch (Throwable th7) {
                        th5 = th7;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th5;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 == 0) {
        }
        if (booleanRef.element) {
        }
        return Unit.INSTANCE;
    }
}
