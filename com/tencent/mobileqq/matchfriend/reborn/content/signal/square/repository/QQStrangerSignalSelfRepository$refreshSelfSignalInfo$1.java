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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSelfRepository$refreshSelfSignalInfo$1", f = "QQStrangerSignalSelfRepository.kt", i = {0, 1}, l = {36, 41, 44}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSelfRepository$refreshSelfSignalInfo$1 extends SuspendLambda implements Function2<FlowCollector<? super SignalPlazaSvrPB$SignalInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $loadCacheFirst;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerSignalSelfRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalSelfRepository$refreshSelfSignalInfo$1(boolean z16, QQStrangerSignalSelfRepository qQStrangerSignalSelfRepository, Continuation<? super QQStrangerSignalSelfRepository$refreshSelfSignalInfo$1> continuation) {
        super(2, continuation);
        this.$loadCacheFirst = z16;
        this.this$0 = qQStrangerSignalSelfRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerSignalSelfRepository$refreshSelfSignalInfo$1 qQStrangerSignalSelfRepository$refreshSelfSignalInfo$1 = new QQStrangerSignalSelfRepository$refreshSelfSignalInfo$1(this.$loadCacheFirst, this.this$0, continuation);
        qQStrangerSignalSelfRepository$refreshSelfSignalInfo$1.L$0 = obj;
        return qQStrangerSignalSelfRepository$refreshSelfSignalInfo$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        QQStrangerSignalSelfCacheHelper c16;
        SignalPlazaSvrPB$GetUserSignalRsp signalPlazaSvrPB$GetUserSignalRsp;
        SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo;
        QQStrangerSignalSelfCacheHelper c17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            if (this.$loadCacheFirst) {
                c16 = this.this$0.c();
                SignalPlazaSvrPB$GetUserSignalRsp c18 = c16.c();
                SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo2 = c18 != null ? c18.signal_info : null;
                this.L$0 = flowCollector;
                this.label = 1;
                if (flowCollector.emit(signalPlazaSvrPB$SignalInfo2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                signalPlazaSvrPB$GetUserSignalRsp = (SignalPlazaSvrPB$GetUserSignalRsp) obj;
                if (signalPlazaSvrPB$GetUserSignalRsp == null) {
                    c17 = this.this$0.c();
                    c17.e(signalPlazaSvrPB$GetUserSignalRsp);
                } else {
                    signalPlazaSvrPB$GetUserSignalRsp = null;
                }
                signalPlazaSvrPB$SignalInfo = signalPlazaSvrPB$GetUserSignalRsp == null ? signalPlazaSvrPB$GetUserSignalRsp.signal_info : null;
                this.L$0 = null;
                this.label = 3;
                if (flowCollector.emit(signalPlazaSvrPB$SignalInfo, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        QQStrangerSignalSelfRepository qQStrangerSignalSelfRepository = this.this$0;
        this.L$0 = flowCollector;
        this.label = 2;
        obj = qQStrangerSignalSelfRepository.e(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        signalPlazaSvrPB$GetUserSignalRsp = (SignalPlazaSvrPB$GetUserSignalRsp) obj;
        if (signalPlazaSvrPB$GetUserSignalRsp == null) {
        }
        if (signalPlazaSvrPB$GetUserSignalRsp == null) {
        }
        this.L$0 = null;
        this.label = 3;
        if (flowCollector.emit(signalPlazaSvrPB$SignalInfo, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super SignalPlazaSvrPB$SignalInfo> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerSignalSelfRepository$refreshSelfSignalInfo$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
