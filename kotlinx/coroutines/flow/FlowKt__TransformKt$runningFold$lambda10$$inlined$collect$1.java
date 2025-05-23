package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1, reason: invalid class name */
/* loaded from: classes28.dex */
public final class FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1<T> implements FlowCollector<T> {
    final /* synthetic */ Ref.ObjectRef $accumulator$inlined;
    final /* synthetic */ Function3 $operation$inlined;
    final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1", f = "Transform.kt", i = {0}, l = {135, 136}, m = "emit", n = {"this"}, s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$lambda-10$$inlined$collect$1$1, reason: invalid class name */
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
            return FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.this.emit(null, this);
        }
    }

    public FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1(Ref.ObjectRef objectRef, Function3 function3, FlowCollector flowCollector) {
        this.$accumulator$inlined = objectRef;
        this.$operation$inlined = function3;
        this.$this_unsafeFlow$inlined = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(T t16, @NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1<T> flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1;
        Ref.ObjectRef objectRef;
        FlowCollector flowCollector;
        T t17;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i16 = anonymousClass1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                T t18 = (T) anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = anonymousClass1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(t18);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) anonymousClass1.L$1;
                    flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1 = (FlowKt__TransformKt$runningFold$lambda10$$inlined$collect$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(t18);
                } else {
                    ResultKt.throwOnFailure(t18);
                    Ref.ObjectRef objectRef2 = this.$accumulator$inlined;
                    Function3 function3 = this.$operation$inlined;
                    T t19 = objectRef2.element;
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = objectRef2;
                    anonymousClass1.label = 1;
                    InlineMarker.mark(6);
                    Object invoke = function3.invoke(t19, t16, anonymousClass1);
                    InlineMarker.mark(7);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1 = this;
                    t18 = (T) invoke;
                    objectRef = objectRef2;
                }
                objectRef.element = t18;
                flowCollector = flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.$this_unsafeFlow$inlined;
                t17 = flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.$accumulator$inlined.element;
                anonymousClass1.L$0 = null;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 2;
                if (flowCollector.emit(t17, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        T t182 = (T) anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 == 0) {
        }
        objectRef.element = t182;
        flowCollector = flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.$this_unsafeFlow$inlined;
        t17 = flowKt__TransformKt$runningFold$lambda10$$inlined$collect$1.$accumulator$inlined.element;
        anonymousClass1.L$0 = null;
        anonymousClass1.L$1 = null;
        anonymousClass1.label = 2;
        if (flowCollector.emit(t17, anonymousClass1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
