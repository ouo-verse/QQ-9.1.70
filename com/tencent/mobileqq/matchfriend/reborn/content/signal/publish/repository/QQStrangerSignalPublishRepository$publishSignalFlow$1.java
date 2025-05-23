package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository;

import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalPublishRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/QQStrangerSignalPublishRepository$b;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalPublishRsp;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$publishSignalFlow$1", f = "QQStrangerSignalPublishRepository.kt", i = {0}, l = {128, 129}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes33.dex */
public final class QQStrangerSignalPublishRepository$publishSignalFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super QQStrangerSignalPublishRepository.b<SignalPlazaSvrPB$SignalPublishRsp>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $partnerAdjID;
    final /* synthetic */ SignalPB$SignalConfig $signalConfig;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerSignalPublishRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalPublishRepository$publishSignalFlow$1(QQStrangerSignalPublishRepository qQStrangerSignalPublishRepository, SignalPB$SignalConfig signalPB$SignalConfig, long j3, Continuation<? super QQStrangerSignalPublishRepository$publishSignalFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSignalPublishRepository;
        this.$signalConfig = signalPB$SignalConfig;
        this.$partnerAdjID = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerSignalPublishRepository$publishSignalFlow$1 qQStrangerSignalPublishRepository$publishSignalFlow$1 = new QQStrangerSignalPublishRepository$publishSignalFlow$1(this.this$0, this.$signalConfig, this.$partnerAdjID, continuation);
        qQStrangerSignalPublishRepository$publishSignalFlow$1.L$0 = obj;
        return qQStrangerSignalPublishRepository$publishSignalFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            QQStrangerSignalPublishRepository qQStrangerSignalPublishRepository = this.this$0;
            SignalPB$SignalConfig signalPB$SignalConfig = this.$signalConfig;
            long j3 = this.$partnerAdjID;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = qQStrangerSignalPublishRepository.i(signalPB$SignalConfig, j3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit((QQStrangerSignalPublishRepository.b) obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super QQStrangerSignalPublishRepository.b<SignalPlazaSvrPB$SignalPublishRsp>> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerSignalPublishRepository$publishSignalFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
