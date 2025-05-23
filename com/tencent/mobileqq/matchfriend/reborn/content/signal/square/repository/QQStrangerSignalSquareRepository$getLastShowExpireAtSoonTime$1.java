package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository;

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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.signal.square.repository.QQStrangerSignalSquareRepository$getLastShowExpireAtSoonTime$1", f = "QQStrangerSignalSquareRepository.kt", i = {}, l = {190}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSignalSquareRepository$getLastShowExpireAtSoonTime$1 extends SuspendLambda implements Function2<FlowCollector<? super Long>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerSignalSquareRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSignalSquareRepository$getLastShowExpireAtSoonTime$1(QQStrangerSignalSquareRepository qQStrangerSignalSquareRepository, Continuation<? super QQStrangerSignalSquareRepository$getLastShowExpireAtSoonTime$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSignalSquareRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerSignalSquareRepository$getLastShowExpireAtSoonTime$1 qQStrangerSignalSquareRepository$getLastShowExpireAtSoonTime$1 = new QQStrangerSignalSquareRepository$getLastShowExpireAtSoonTime$1(this.this$0, continuation);
        qQStrangerSignalSquareRepository$getLastShowExpireAtSoonTime$1.L$0 = obj;
        return qQStrangerSignalSquareRepository$getLastShowExpireAtSoonTime$1;
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
            j3 = this.this$0.j();
            Long boxLong = Boxing.boxLong(j3.d());
            this.label = 1;
            if (flowCollector.emit(boxLong, this) == coroutine_suspended) {
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
    public final Object invoke(FlowCollector<? super Long> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerSignalSquareRepository$getLastShowExpireAtSoonTime$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
