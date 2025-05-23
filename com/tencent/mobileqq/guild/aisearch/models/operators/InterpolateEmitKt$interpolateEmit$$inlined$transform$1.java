package com.tencent.mobileqq.guild.aisearch.models.operators;

import android.util.Log;
import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@\u00a8\u0006\u0004"}, d2 = {"T", BdhLogUtil.LogTag.Tag_Req, "Lkotlinx/coroutines/flow/FlowCollector;", "", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.operators.InterpolateEmitKt$interpolateEmit$$inlined$transform$1", f = "interpolateEmit.kt", i = {}, l = {223}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class InterpolateEmitKt$interpolateEmit$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super ChatAnswerData>, Continuation<? super Unit>, Object> {
    final /* synthetic */ EmitStatus $emitStatus$inlined;
    final /* synthetic */ Ref.ObjectRef $prevAnswerData$inlined;
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.aisearch.models.operators.InterpolateEmitKt$interpolateEmit$$inlined$transform$1$1, reason: invalid class name */
    /* loaded from: classes12.dex */
    public static final class AnonymousClass1 implements FlowCollector<ChatAnswerData> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FlowCollector f214159d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EmitStatus f214160e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f214161f;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.tencent.mobileqq.guild.aisearch.models.operators.InterpolateEmitKt$interpolateEmit$$inlined$transform$1$1", f = "interpolateEmit.kt", i = {0, 0, 0, 1, 1}, l = {143, 146}, m = "emit", n = {"this", "data", "$this$interpolateEmit_u24lambda_u242", "this", "data"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
        /* renamed from: com.tencent.mobileqq.guild.aisearch.models.operators.InterpolateEmitKt$interpolateEmit$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C76671 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            /* synthetic */ Object result;

            public C76671(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, EmitStatus emitStatus, Ref.ObjectRef objectRef) {
            this.f214160e = emitStatus;
            this.f214161f = objectRef;
            this.f214159d = flowCollector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00c2 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object emit(ChatAnswerData chatAnswerData, @NotNull Continuation continuation) {
            C76671 c76671;
            Object coroutine_suspended;
            int i3;
            List b16;
            FlowCollector flowCollector;
            ChatAnswerData chatAnswerData2;
            Iterator it;
            Object obj;
            AnonymousClass1 anonymousClass1;
            T t16;
            AnonymousClass1 anonymousClass12;
            if (continuation instanceof C76671) {
                c76671 = (C76671) continuation;
                int i16 = c76671.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    c76671.label = i16 - Integer.MIN_VALUE;
                    Object obj2 = c76671.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = c76671.label;
                    if (i3 == 0) {
                        if (i3 != 1) {
                            if (i3 == 2) {
                                ChatAnswerData chatAnswerData3 = (ChatAnswerData) c76671.L$1;
                                anonymousClass12 = (AnonymousClass1) c76671.L$0;
                                ResultKt.throwOnFailure(obj2);
                                t16 = chatAnswerData3;
                                anonymousClass12.f214161f.element = t16;
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        it = (Iterator) c76671.L$3;
                        FlowCollector flowCollector2 = (FlowCollector) c76671.L$2;
                        ChatAnswerData chatAnswerData4 = (ChatAnswerData) c76671.L$1;
                        AnonymousClass1 anonymousClass13 = (AnonymousClass1) c76671.L$0;
                        ResultKt.throwOnFailure(obj2);
                        chatAnswerData2 = chatAnswerData4;
                        flowCollector = flowCollector2;
                        obj = coroutine_suspended;
                        anonymousClass1 = anonymousClass13;
                    } else {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector3 = this.f214159d;
                        ChatAnswerData chatAnswerData5 = chatAnswerData;
                        b16 = InterpolateEmitKt.b(this.f214160e, (ChatAnswerData) this.f214161f.element, chatAnswerData5);
                        flowCollector = flowCollector3;
                        chatAnswerData2 = chatAnswerData5;
                        it = b16.iterator();
                        obj = coroutine_suspended;
                        anonymousClass1 = this;
                    }
                    while (it.hasNext()) {
                        ChatAnswerData chatAnswerData6 = (ChatAnswerData) it.next();
                        Logger logger = Logger.f235387a;
                        if (QLog.isDevelopLevel()) {
                            Log.d("AIChatRepository", "interpolateEmit: emit " + chatAnswerData6);
                        }
                        c76671.L$0 = anonymousClass1;
                        c76671.L$1 = chatAnswerData2;
                        c76671.L$2 = flowCollector;
                        c76671.L$3 = it;
                        c76671.label = 1;
                        if (flowCollector.emit(chatAnswerData6, c76671) == obj) {
                            return obj;
                        }
                    }
                    c76671.L$0 = anonymousClass1;
                    c76671.L$1 = chatAnswerData2;
                    c76671.L$2 = null;
                    c76671.L$3 = null;
                    c76671.label = 2;
                    if (flowCollector.emit(chatAnswerData2, c76671) != obj) {
                        return obj;
                    }
                    t16 = chatAnswerData2;
                    anonymousClass12 = anonymousClass1;
                    anonymousClass12.f214161f.element = t16;
                    return Unit.INSTANCE;
                }
            }
            c76671 = new C76671(continuation);
            Object obj22 = c76671.result;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i3 = c76671.label;
            if (i3 == 0) {
            }
            while (it.hasNext()) {
            }
            c76671.L$0 = anonymousClass1;
            c76671.L$1 = chatAnswerData2;
            c76671.L$2 = null;
            c76671.L$3 = null;
            c76671.label = 2;
            if (flowCollector.emit(chatAnswerData2, c76671) != obj) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterpolateEmitKt$interpolateEmit$$inlined$transform$1(Flow flow, Continuation continuation, EmitStatus emitStatus, Ref.ObjectRef objectRef) {
        super(2, continuation);
        this.$this_transform = flow;
        this.$emitStatus$inlined = emitStatus;
        this.$prevAnswerData$inlined = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        InterpolateEmitKt$interpolateEmit$$inlined$transform$1 interpolateEmitKt$interpolateEmit$$inlined$transform$1 = new InterpolateEmitKt$interpolateEmit$$inlined$transform$1(this.$this_transform, continuation, this.$emitStatus$inlined, this.$prevAnswerData$inlined);
        interpolateEmitKt$interpolateEmit$$inlined$transform$1.L$0 = obj;
        return interpolateEmitKt$interpolateEmit$$inlined$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = this.$this_transform;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector, this.$emitStatus$inlined, this.$prevAnswerData$inlined);
            this.label = 1;
            if (flow.collect(anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super ChatAnswerData> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((InterpolateEmitKt$interpolateEmit$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
