package com.tencent.mobileqq.matchfriend.reborn.content.signal.api.impl;

import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.api.impl.QQStrangerSelfSignalInfoServiceImpl$refreshSelfSignalInfo$1", f = "QQStrangerSelfSignalInfoServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
final class QQStrangerSelfSignalInfoServiceImpl$refreshSelfSignalInfo$1 extends SuspendLambda implements Function2<SignalPlazaSvrPB$SignalInfo, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerSelfSignalInfoServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSelfSignalInfoServiceImpl$refreshSelfSignalInfo$1(QQStrangerSelfSignalInfoServiceImpl qQStrangerSelfSignalInfoServiceImpl, Continuation<? super QQStrangerSelfSignalInfoServiceImpl$refreshSelfSignalInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSelfSignalInfoServiceImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerSelfSignalInfoServiceImpl$refreshSelfSignalInfo$1 qQStrangerSelfSignalInfoServiceImpl$refreshSelfSignalInfo$1 = new QQStrangerSelfSignalInfoServiceImpl$refreshSelfSignalInfo$1(this.this$0, continuation);
        qQStrangerSelfSignalInfoServiceImpl$refreshSelfSignalInfo$1.L$0 = obj;
        return qQStrangerSelfSignalInfoServiceImpl$refreshSelfSignalInfo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo, Continuation<? super Unit> continuation) {
        return ((QQStrangerSelfSignalInfoServiceImpl$refreshSelfSignalInfo$1) create(signalPlazaSvrPB$SignalInfo, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo = (SignalPlazaSvrPB$SignalInfo) this.L$0;
            this.this$0.selfSignalInfo = signalPlazaSvrPB$SignalInfo;
            this.this$0.notifySelfSignalInfoUpdate(signalPlazaSvrPB$SignalInfo, false);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
