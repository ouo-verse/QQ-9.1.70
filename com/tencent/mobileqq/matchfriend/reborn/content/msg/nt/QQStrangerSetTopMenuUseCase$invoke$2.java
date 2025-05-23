package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

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

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerSetTopMenuUseCase$invoke$2", f = "QQStrangerSetTopMenuUseCase.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
final class QQStrangerSetTopMenuUseCase$invoke$2 extends SuspendLambda implements Function2<FlowCollector<? super com.tencent.qqnt.chats.main.vm.usecase.result.a>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerSetTopMenuUseCase$invoke$2 qQStrangerSetTopMenuUseCase$invoke$2 = new QQStrangerSetTopMenuUseCase$invoke$2(continuation);
        qQStrangerSetTopMenuUseCase$invoke$2.L$0 = obj;
        return qQStrangerSetTopMenuUseCase$invoke$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        List emptyList;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            com.tencent.qqnt.chats.main.vm.usecase.result.a aVar = new com.tencent.qqnt.chats.main.vm.usecase.result.a(emptyList);
            this.label = 1;
            if (flowCollector.emit(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QQStrangerSetTopMenuUseCase$invoke$2(Continuation<? super QQStrangerSetTopMenuUseCase$invoke$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super com.tencent.qqnt.chats.main.vm.usecase.result.a> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerSetTopMenuUseCase$invoke$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
