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
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", QCircleDaTongConstant.ElementParamValue.COLLECT, "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1<R> implements Flow<R> {
    final /* synthetic */ Object $initial$inlined;
    final /* synthetic */ Function3 $operation$inlined;
    final /* synthetic */ Flow $this_runningFold$inlined;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", f = "Transform.kt", i = {0, 0, 0}, l = {114, 116}, m = QCircleDaTongConstant.ElementParamValue.COLLECT, n = {"this", "$this$runningFold_u24lambda_u2d10", "accumulator"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1$1, reason: invalid class name */
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
            return FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(Object obj, Flow flow, Function3 function3) {
        this.$initial$inlined = obj;
        this.$this_runningFold$inlined = flow;
        this.$operation$inlined = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super R> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1<R> flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1;
        FlowCollector<? super R> flowCollector2;
        Ref.ObjectRef objectRef;
        Flow flow;
        FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1 flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1;
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
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) anonymousClass1.L$2;
                    flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                    flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = (FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    ?? r26 = this.$initial$inlined;
                    objectRef2.element = r26;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = flowCollector;
                    anonymousClass1.L$2 = objectRef2;
                    anonymousClass1.label = 1;
                    if (flowCollector.emit(r26, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = this;
                    flowCollector2 = flowCollector;
                    objectRef = objectRef2;
                }
                flow = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$this_runningFold$inlined;
                flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1 = new FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1(objectRef, flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$operation$inlined, flowCollector2);
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.L$2 = null;
                anonymousClass1.label = 2;
                if (flow.collect(flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
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
        flow = flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$this_runningFold$inlined;
        flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1 = new FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1(objectRef, flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1.$operation$inlined, flowCollector2);
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = null;
        anonymousClass1.label = 2;
        if (flow.collect(flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1, anonymousClass1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
