package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository;

import com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.b;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$saveShowExpireAtSoonTime$1", f = "QQStrangerSignalSquareRepository.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSquareRepository$saveShowExpireAtSoonTime$1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $timeMillis;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerSignalSquareRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalSquareRepository$saveShowExpireAtSoonTime$1(long j3, QQStrangerSignalSquareRepository qQStrangerSignalSquareRepository, Continuation<? super QQStrangerSignalSquareRepository$saveShowExpireAtSoonTime$1> continuation) {
        super(2, continuation);
        this.$timeMillis = j3;
        this.this$0 = qQStrangerSignalSquareRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerSignalSquareRepository$saveShowExpireAtSoonTime$1 qQStrangerSignalSquareRepository$saveShowExpireAtSoonTime$1 = new QQStrangerSignalSquareRepository$saveShowExpireAtSoonTime$1(this.$timeMillis, this.this$0, continuation);
        qQStrangerSignalSquareRepository$saveShowExpireAtSoonTime$1.L$0 = obj;
        return qQStrangerSignalSquareRepository$saveShowExpireAtSoonTime$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQStrangerSignalSquareCacheHelper j3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            long j16 = this.$timeMillis;
            QLog.i("QQStrangerSignalSquareRepository", 2, "[saveShowExpireAtSoonTime] timeMillis: " + j16 + ", dataString: " + b.c(j16));
            j3 = this.this$0.j();
            j3.h(this.$timeMillis);
            Boolean boxBoolean = Boxing.boxBoolean(true);
            this.label = 1;
            if (flowCollector.emit(boxBoolean, this) == coroutine_suspended) {
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
    public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerSignalSquareRepository$saveShowExpireAtSoonTime$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
