package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository;

import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$GetSignalConfigRsp;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/QQStrangerSignalPublishRepository$b;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$GetSignalConfigRsp;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$requestSignalConfigsFlow$1", f = "QQStrangerSignalPublishRepository.kt", i = {}, l = {60, 60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSignalPublishRepository$requestSignalConfigsFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super QQStrangerSignalPublishRepository.b<SignalPlazaSvrPB$GetSignalConfigRsp>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerSignalPublishRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalPublishRepository$requestSignalConfigsFlow$1(QQStrangerSignalPublishRepository qQStrangerSignalPublishRepository, Continuation<? super QQStrangerSignalPublishRepository$requestSignalConfigsFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSignalPublishRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerSignalPublishRepository$requestSignalConfigsFlow$1 qQStrangerSignalPublishRepository$requestSignalConfigsFlow$1 = new QQStrangerSignalPublishRepository$requestSignalConfigsFlow$1(this.this$0, continuation);
        qQStrangerSignalPublishRepository$requestSignalConfigsFlow$1.L$0 = obj;
        return qQStrangerSignalPublishRepository$requestSignalConfigsFlow$1;
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
            this.L$0 = flowCollector;
            this.label = 1;
            obj = qQStrangerSignalPublishRepository.j(this);
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
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super QQStrangerSignalPublishRepository.b<SignalPlazaSvrPB$GetSignalConfigRsp>> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerSignalPublishRepository$requestSignalConfigsFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
