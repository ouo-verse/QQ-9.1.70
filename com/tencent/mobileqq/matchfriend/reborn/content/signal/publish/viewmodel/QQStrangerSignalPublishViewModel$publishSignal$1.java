package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.viewmodel;

import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishResult;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import g82.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.viewmodel.QQStrangerSignalPublishViewModel$publishSignal$1", f = "QQStrangerSignalPublishViewModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSignalPublishViewModel$publishSignal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $partnerAdjID;
    final /* synthetic */ SignalPB$SignalConfig $signalConfig;
    int label;
    final /* synthetic */ QQStrangerSignalPublishViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.viewmodel.QQStrangerSignalPublishViewModel$publishSignal$1$1", f = "QQStrangerSignalPublishViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.viewmodel.QQStrangerSignalPublishViewModel$publishSignal$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<QQStrangerSignalPublishResult, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ QQStrangerSignalPublishViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(QQStrangerSignalPublishViewModel qQStrangerSignalPublishViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = qQStrangerSignalPublishViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(QQStrangerSignalPublishResult qQStrangerSignalPublishResult, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(qQStrangerSignalPublishResult, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.O1(new a.QQStrangerUpdatePublishState((QQStrangerSignalPublishResult) this.L$0));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalPublishViewModel$publishSignal$1(QQStrangerSignalPublishViewModel qQStrangerSignalPublishViewModel, SignalPB$SignalConfig signalPB$SignalConfig, long j3, Continuation<? super QQStrangerSignalPublishViewModel$publishSignal$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSignalPublishViewModel;
        this.$signalConfig = signalPB$SignalConfig;
        this.$partnerAdjID = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerSignalPublishViewModel$publishSignal$1(this.this$0, this.$signalConfig, this.$partnerAdjID, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQStrangerSignalPublishRepository qQStrangerSignalPublishRepository;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            qQStrangerSignalPublishRepository = this.this$0.publishConfigRepository;
            Flow onEach = FlowKt.onEach(qQStrangerSignalPublishRepository.f(this.$signalConfig, this.$partnerAdjID), new AnonymousClass1(this.this$0, null));
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
        return ((QQStrangerSignalPublishViewModel$publishSignal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
