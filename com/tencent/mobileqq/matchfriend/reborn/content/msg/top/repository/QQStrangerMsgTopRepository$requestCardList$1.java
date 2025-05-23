package com.tencent.mobileqq.matchfriend.reborn.content.msg.top.repository;

import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$CardInfo;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.msg.top.repository.QQStrangerMsgTopRepository$requestCardList$1", f = "QQStrangerMsgTopRepository.kt", i = {0}, l = {53, 59}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes33.dex */
public final class QQStrangerMsgTopRepository$requestCardList$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends Prompt$CardInfo>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerMsgTopRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerMsgTopRepository$requestCardList$1(QQStrangerMsgTopRepository qQStrangerMsgTopRepository, Continuation<? super QQStrangerMsgTopRepository$requestCardList$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerMsgTopRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerMsgTopRepository$requestCardList$1 qQStrangerMsgTopRepository$requestCardList$1 = new QQStrangerMsgTopRepository$requestCardList$1(this.this$0, continuation);
        qQStrangerMsgTopRepository$requestCardList$1.L$0 = obj;
        return qQStrangerMsgTopRepository$requestCardList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends Prompt$CardInfo>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super List<Prompt$CardInfo>>) flowCollector, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            QQStrangerMsgTopRepository qQStrangerMsgTopRepository = this.this$0;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = qQStrangerMsgTopRepository.d(this);
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
        List list = (List) obj;
        this.this$0.h(list);
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            return Unit.INSTANCE;
        }
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(list, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super List<Prompt$CardInfo>> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerMsgTopRepository$requestCardList$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
