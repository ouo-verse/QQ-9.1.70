package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$GetSignalConfigRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/repository/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.repository.QQStrangerSignalPublishRepository$loadGetSignalConfigRspCacheFlow$1", f = "QQStrangerSignalPublishRepository.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSignalPublishRepository$loadGetSignalConfigRspCacheFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super QQStrangerSignalConfigResult>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerSignalPublishRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalPublishRepository$loadGetSignalConfigRspCacheFlow$1(QQStrangerSignalPublishRepository qQStrangerSignalPublishRepository, Continuation<? super QQStrangerSignalPublishRepository$loadGetSignalConfigRspCacheFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSignalPublishRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerSignalPublishRepository$loadGetSignalConfigRspCacheFlow$1 qQStrangerSignalPublishRepository$loadGetSignalConfigRspCacheFlow$1 = new QQStrangerSignalPublishRepository$loadGetSignalConfigRspCacheFlow$1(this.this$0, continuation);
        qQStrangerSignalPublishRepository$loadGetSignalConfigRspCacheFlow$1.L$0 = obj;
        return qQStrangerSignalPublishRepository$loadGetSignalConfigRspCacheFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQStrangerSignalPublishCacheHelper d16;
        PBUInt64Field pBUInt64Field;
        PBRepeatMessageField<SignalPB$SignalConfig> pBRepeatMessageField;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            d16 = this.this$0.d();
            SignalPlazaSvrPB$GetSignalConfigRsp c16 = d16.c();
            List<SignalPB$SignalConfig> list = (c16 == null || (pBRepeatMessageField = c16.signal_configs) == null) ? null : pBRepeatMessageField.get();
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            QQStrangerSignalConfigResult qQStrangerSignalConfigResult = new QQStrangerSignalConfigResult(true, list, (c16 == null || (pBUInt64Field = c16.signal_expire) == null) ? 0L : pBUInt64Field.get());
            this.label = 1;
            if (flowCollector.emit(qQStrangerSignalConfigResult, this) == coroutine_suspended) {
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
    public final Object invoke(FlowCollector<? super QQStrangerSignalConfigResult> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerSignalPublishRepository$loadGetSignalConfigRspCacheFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
