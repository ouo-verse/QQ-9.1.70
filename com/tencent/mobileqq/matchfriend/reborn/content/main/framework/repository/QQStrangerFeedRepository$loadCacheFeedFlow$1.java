package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.trpcprotocol.kuolie.feed_plaza_svr.feed_plaza_svr.FeedPlazaSvrPB$FeedRecommendRsp;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository$loadCacheFeedFlow$1", f = "QQStrangerFeedRepository.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerFeedRepository$loadCacheFeedFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super QQStrangerFeedResult>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ QQStrangerFeedRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerFeedRepository$loadCacheFeedFlow$1(QQStrangerFeedRepository qQStrangerFeedRepository, Continuation<? super QQStrangerFeedRepository$loadCacheFeedFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerFeedRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        QQStrangerFeedRepository$loadCacheFeedFlow$1 qQStrangerFeedRepository$loadCacheFeedFlow$1 = new QQStrangerFeedRepository$loadCacheFeedFlow$1(this.this$0, continuation);
        qQStrangerFeedRepository$loadCacheFeedFlow$1.L$0 = obj;
        return qQStrangerFeedRepository$loadCacheFeedFlow$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053 A[Catch: all -> 0x0088, TryCatch #0 {all -> 0x0088, blocks: (B:17:0x0041, B:19:0x0047, B:24:0x0053, B:25:0x0064), top: B:16:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQStrangerSquareCacheHelper n3;
        ReentrantLock o16;
        boolean z16;
        QQStrangerFeedResult qQStrangerFeedResult;
        List list;
        List list2;
        PBRepeatMessageField<FeedPB$Feed> pBRepeatMessageField;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            n3 = this.this$0.n();
            FeedPlazaSvrPB$FeedRecommendRsp c16 = n3.c();
            List<FeedPB$Feed> list3 = (c16 == null || (pBRepeatMessageField = c16.content_feeds) == null) ? null : pBRepeatMessageField.get();
            o16 = this.this$0.o();
            QQStrangerFeedRepository qQStrangerFeedRepository = this.this$0;
            o16.lock();
            try {
                List<FeedPB$Feed> list4 = list3;
                if (list4 != null && !list4.isEmpty()) {
                    z16 = false;
                    if (!z16) {
                        list = qQStrangerFeedRepository.feedList;
                        list.clear();
                        list2 = qQStrangerFeedRepository.feedList;
                        list2.addAll(list3);
                    }
                    Unit unit = Unit.INSTANCE;
                    o16.unlock();
                    this.this$0.s("[loadCacheData]", list3);
                    qQStrangerFeedResult = new QQStrangerFeedResult(true, true, this.this$0.h(), false);
                    this.label = 1;
                    if (flowCollector.emit(qQStrangerFeedResult, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                z16 = true;
                if (!z16) {
                }
                Unit unit2 = Unit.INSTANCE;
                o16.unlock();
                this.this$0.s("[loadCacheData]", list3);
                qQStrangerFeedResult = new QQStrangerFeedResult(true, true, this.this$0.h(), false);
                this.label = 1;
                if (flowCollector.emit(qQStrangerFeedResult, this) == coroutine_suspended) {
                }
            } catch (Throwable th5) {
                o16.unlock();
                throw th5;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super QQStrangerFeedResult> flowCollector, Continuation<? super Unit> continuation) {
        return ((QQStrangerFeedRepository$loadCacheFeedFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
