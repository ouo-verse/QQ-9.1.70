package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository;

import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.feed_plaza_svr.feed_plaza_svr.FeedPlazaSvrPB$FeedRecommendRsp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/QQStrangerFeedRepository$b;", "Lcom/tencent/trpcprotocol/kuolie/feed_plaza_svr/feed_plaza_svr/FeedPlazaSvrPB$FeedRecommendRsp;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$requestFeedsFlow$1", f = "QQStrangerFeedRepository.kt", i = {0}, l = {156, 158, 158}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: classes33.dex */
public final class QQStrangerFeedRepository$requestFeedsFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super QQStrangerFeedRepository.b<FeedPlazaSvrPB$FeedRecommendRsp>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $extData;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerFeedRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerFeedRepository$requestFeedsFlow$1(QQStrangerFeedRepository qQStrangerFeedRepository, String str, Continuation<? super QQStrangerFeedRepository$requestFeedsFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerFeedRepository;
        this.$extData = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerFeedRepository$requestFeedsFlow$1 qQStrangerFeedRepository$requestFeedsFlow$1 = new QQStrangerFeedRepository$requestFeedsFlow$1(this.this$0, this.$extData, continuation);
        qQStrangerFeedRepository$requestFeedsFlow$1.L$0 = obj;
        return qQStrangerFeedRepository$requestFeedsFlow$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007c A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            String j3 = com.tencent.mobileqq.matchfriend.utils.b.d().j();
            if (j3 == null || j3.length() == 0) {
                QLog.w("QQStrangerFeedRepository", 1, "requestFeedsFlow wait, because self openid is empty");
                this.L$0 = flowCollector;
                this.label = 1;
                if (DelayKt.delay(500L, this) == coroutine_suspended) {
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
                this.L$0 = null;
                this.label = 3;
                if (flowCollector.emit(obj, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        QQStrangerFeedRepository qQStrangerFeedRepository = this.this$0;
        String str = this.$extData;
        this.L$0 = flowCollector;
        this.label = 2;
        obj = qQStrangerFeedRepository.x(str, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.L$0 = null;
        this.label = 3;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super QQStrangerFeedRepository.b<FeedPlazaSvrPB$FeedRecommendRsp>> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerFeedRepository$requestFeedsFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
