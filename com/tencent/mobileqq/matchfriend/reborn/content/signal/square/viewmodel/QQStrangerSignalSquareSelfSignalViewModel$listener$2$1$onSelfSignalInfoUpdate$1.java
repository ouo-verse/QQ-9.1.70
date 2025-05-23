package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel;

import com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.b;
import com.tencent.qphone.base.util.QLog;
import k82.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1", f = "QQStrangerSignalSquareSelfSignalViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
final class QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ QQStrangerSignalSquareSelfSignalViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1$2", f = "QQStrangerSignalSquareSelfSignalViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1$2, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ QQStrangerSignalSquareSelfSignalViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(QQStrangerSignalSquareSelfSignalViewModel qQStrangerSignalSquareSelfSignalViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = qQStrangerSignalSquareSelfSignalViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.Z$0 = ((Boolean) obj).booleanValue();
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return invoke(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.Z$0) {
                    this.this$0.O1(a.C10641a.f411899a);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(boolean z16, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(Boolean.valueOf(z16), continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1(QQStrangerSignalSquareSelfSignalViewModel qQStrangerSignalSquareSelfSignalViewModel, Continuation<? super QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSignalSquareSelfSignalViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQStrangerSignalSquareRepository R1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            R1 = this.this$0.R1();
            final Flow<Long> k3 = R1.k();
            Flow onEach = FlowKt.onEach(new Flow<Boolean>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1$invokeSuspend$$inlined$map$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes33.dex */
                public static final class AnonymousClass2 implements FlowCollector<Long> {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f245035d;

                    /* compiled from: P */
                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1$invokeSuspend$$inlined$map$1$2", f = "QQStrangerSignalSquareSelfSignalViewModel.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.viewmodel.QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: classes33.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.f245035d = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public Object emit(Long l3, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        Object coroutine_suspended;
                        int i3;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i16 = anonymousClass1.label;
                            if ((i16 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                                Object obj = anonymousClass1.result;
                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i3 = anonymousClass1.label;
                                if (i3 != 0) {
                                    ResultKt.throwOnFailure(obj);
                                    FlowCollector flowCollector = this.f245035d;
                                    long longValue = l3.longValue();
                                    QLog.i("QQStrangerSelfSignalViewModel", 1, "onSelfSignalInfoUpdate lastShowExpireAtSoonTime: " + longValue + ", date string: " + b.c(longValue));
                                    Boolean boxBoolean = Boxing.boxBoolean(b.b(longValue));
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(boxBoolean, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        anonymousClass1 = new AnonymousClass1(continuation);
                        Object obj2 = anonymousClass1.result;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i3 = anonymousClass1.label;
                        if (i3 != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                    Object coroutine_suspended2;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    return collect == coroutine_suspended2 ? collect : Unit.INSTANCE;
                }
            }, new AnonymousClass2(this.this$0, null));
            this.label = 1;
            if (FlowKt.collect(onEach, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerSignalSquareSelfSignalViewModel$listener$2$1$onSelfSignalInfoUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
