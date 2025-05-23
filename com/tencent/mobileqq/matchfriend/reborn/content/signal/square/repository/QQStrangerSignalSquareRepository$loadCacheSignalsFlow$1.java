package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalRecommendRsp;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/repository/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$loadCacheSignalsFlow$1", f = "QQStrangerSignalSquareRepository.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSquareRepository$loadCacheSignalsFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super QQStrangerSignalInfoResult>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerSignalSquareRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalSquareRepository$loadCacheSignalsFlow$1(QQStrangerSignalSquareRepository qQStrangerSignalSquareRepository, Continuation<? super QQStrangerSignalSquareRepository$loadCacheSignalsFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSignalSquareRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerSignalSquareRepository$loadCacheSignalsFlow$1 qQStrangerSignalSquareRepository$loadCacheSignalsFlow$1 = new QQStrangerSignalSquareRepository$loadCacheSignalsFlow$1(this.this$0, continuation);
        qQStrangerSignalSquareRepository$loadCacheSignalsFlow$1.L$0 = obj;
        return qQStrangerSignalSquareRepository$loadCacheSignalsFlow$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005a A[Catch: all -> 0x00a1, TryCatch #0 {all -> 0x00a1, blocks: (B:17:0x0041, B:19:0x004e, B:24:0x005a, B:25:0x0063), top: B:16:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQStrangerSignalSquareCacheHelper j3;
        ReentrantLock l3;
        List list;
        boolean z16;
        List list2;
        QQStrangerSignalInfoResult qQStrangerSignalInfoResult;
        List i3;
        List list3;
        PBRepeatMessageField<SignalPlazaSvrPB$SignalInfo> pBRepeatMessageField;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            j3 = this.this$0.j();
            SignalPlazaSvrPB$SignalRecommendRsp e16 = j3.e();
            List<SignalPlazaSvrPB$SignalInfo> list4 = (e16 == null || (pBRepeatMessageField = e16.signal_infos) == null) ? null : pBRepeatMessageField.get();
            l3 = this.this$0.l();
            QQStrangerSignalSquareRepository qQStrangerSignalSquareRepository = this.this$0;
            l3.lock();
            try {
                list = qQStrangerSignalSquareRepository.signalList;
                list.clear();
                List<SignalPlazaSvrPB$SignalInfo> list5 = list4;
                if (list5 != null && !list5.isEmpty()) {
                    z16 = false;
                    if (!z16) {
                        list3 = qQStrangerSignalSquareRepository.signalList;
                        list3.addAll(list4);
                    }
                    Unit unit = Unit.INSTANCE;
                    l3.unlock();
                    list2 = this.this$0.signalList;
                    QLog.i("QQStrangerSignalSquareRepository", 1, "[loadCacheSignalsFlow] signalListSize=" + list2.size());
                    i3 = this.this$0.i();
                    qQStrangerSignalInfoResult = new QQStrangerSignalInfoResult(true, true, i3, false);
                    this.label = 1;
                    if (flowCollector.emit(qQStrangerSignalInfoResult, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                z16 = true;
                if (!z16) {
                }
                Unit unit2 = Unit.INSTANCE;
                l3.unlock();
                list2 = this.this$0.signalList;
                QLog.i("QQStrangerSignalSquareRepository", 1, "[loadCacheSignalsFlow] signalListSize=" + list2.size());
                i3 = this.this$0.i();
                qQStrangerSignalInfoResult = new QQStrangerSignalInfoResult(true, true, i3, false);
                this.label = 1;
                if (flowCollector.emit(qQStrangerSignalInfoResult, this) == coroutine_suspended) {
                }
            } catch (Throwable th5) {
                l3.unlock();
                throw th5;
            }
        } else if (i16 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super QQStrangerSignalInfoResult> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerSignalSquareRepository$loadCacheSignalsFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
