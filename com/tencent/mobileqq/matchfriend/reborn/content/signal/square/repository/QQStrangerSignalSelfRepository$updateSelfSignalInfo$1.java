package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository;

import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$GetUserSignalRsp;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSelfRepository$updateSelfSignalInfo$1", f = "QQStrangerSignalSelfRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSelfRepository$updateSelfSignalInfo$1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ SignalPlazaSvrPB$SignalInfo $signalInfo;
    int label;
    final /* synthetic */ QQStrangerSignalSelfRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalSelfRepository$updateSelfSignalInfo$1(QQStrangerSignalSelfRepository qQStrangerSignalSelfRepository, SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo, Continuation<? super QQStrangerSignalSelfRepository$updateSelfSignalInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSignalSelfRepository;
        this.$signalInfo = signalPlazaSvrPB$SignalInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerSignalSelfRepository$updateSelfSignalInfo$1(this.this$0, this.$signalInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        QQStrangerSignalSelfCacheHelper c16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SignalPlazaSvrPB$GetUserSignalRsp signalPlazaSvrPB$GetUserSignalRsp = new SignalPlazaSvrPB$GetUserSignalRsp();
            signalPlazaSvrPB$GetUserSignalRsp.signal_info.set(this.$signalInfo);
            signalPlazaSvrPB$GetUserSignalRsp.ret_code.set(1);
            c16 = this.this$0.c();
            c16.e(signalPlazaSvrPB$GetUserSignalRsp);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super Unit> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerSignalSelfRepository$updateSelfSignalInfo$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
