package kotlinx.coroutines.flow;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", QCircleDaTongConstant.ElementParamValue.COLLECT, "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {117, 119}, m = QCircleDaTongConstant.ElementParamValue.COLLECT, n = {"this", "$this$retryWhen_u24lambda_u2d3", "attempt", "shallRetry", "this", "$this$retryWhen_u24lambda_u2d3", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "attempt"}, s = {"L$0", "L$1", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1, reason: invalid class name */
    /* loaded from: classes28.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
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
            return FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.$this_retryWhen$inlined = flow;
        this.$predicate$inlined = function4;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0077 -> B:14:0x00a9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0098 -> B:11:0x009b). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        long j3;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
        int i16;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1<T> flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
        FlowCollector<? super T> flowCollector2;
        Throwable th5;
        Object catchImpl;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i17 = anonymousClass1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i17 - Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = anonymousClass1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            j3 = anonymousClass1.J$0;
                            Throwable th6 = (Throwable) anonymousClass1.L$2;
                            flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                            flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                j3++;
                                i16 = 1;
                                flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                                if (i16 == 0) {
                                    return Unit.INSTANCE;
                                }
                                flowCollector = flowCollector2;
                                Flow flow = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.$this_retryWhen$inlined;
                                anonymousClass1.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                                anonymousClass1.L$1 = flowCollector;
                                anonymousClass1.L$2 = null;
                                anonymousClass1.J$0 = j3;
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                catchImpl = FlowKt.catchImpl(flow, flowCollector, anonymousClass1);
                                if (catchImpl != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                flowCollector2 = flowCollector;
                                i16 = 0;
                                flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                                obj = catchImpl;
                                th5 = (Throwable) obj;
                                if (th5 != null) {
                                    Function4 function4 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12.$predicate$inlined;
                                    Long boxLong = Boxing.boxLong(j3);
                                    anonymousClass1.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                                    anonymousClass1.L$1 = flowCollector2;
                                    anonymousClass1.L$2 = th5;
                                    anonymousClass1.J$0 = j3;
                                    anonymousClass1.label = 2;
                                    InlineMarker.mark(6);
                                    Object invoke = function4.invoke(flowCollector2, th5, boxLong, anonymousClass1);
                                    InlineMarker.mark(7);
                                    if (invoke == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    obj = invoke;
                                    th6 = th5;
                                    if (!((Boolean) obj).booleanValue()) {
                                        throw th6;
                                    }
                                }
                                flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                                if (i16 == 0) {
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        i16 = anonymousClass1.I$0;
                        j3 = anonymousClass1.J$0;
                        flowCollector2 = (FlowCollector) anonymousClass1.L$1;
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12 = (FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        th5 = (Throwable) obj;
                        if (th5 != null) {
                        }
                        flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$12;
                        if (i16 == 0) {
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    j3 = 0;
                    flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 = this;
                    Flow flow2 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.$this_retryWhen$inlined;
                    anonymousClass1.L$0 = flowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1;
                    anonymousClass1.L$1 = flowCollector;
                    anonymousClass1.L$2 = null;
                    anonymousClass1.J$0 = j3;
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.label = 1;
                    catchImpl = FlowKt.catchImpl(flow2, flowCollector, anonymousClass1);
                    if (catchImpl != coroutine_suspended) {
                    }
                }
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 == 0) {
        }
    }
}
