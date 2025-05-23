package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel;

import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$CommentAndReplyRsp;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel.QQStrangerSquareViewModel$doComment$1", f = "QQStrangerSquareViewModel.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QQStrangerSquareViewModel$doComment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ FeedPB$Feed $feed;
    int label;
    final /* synthetic */ QQStrangerSquareViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSquareViewModel$doComment$1(QQStrangerSquareViewModel qQStrangerSquareViewModel, FeedPB$Feed feedPB$Feed, String str, Continuation<? super QQStrangerSquareViewModel$doComment$1> continuation) {
        super(2, continuation);
        this.this$0 = qQStrangerSquareViewModel;
        this.$feed = feedPB$Feed;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerSquareViewModel$doComment$1(this.this$0, this.$feed, this.$content, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        QQStrangerFeedRepository qQStrangerFeedRepository;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            qQStrangerFeedRepository = this.this$0.feedRepository;
            String str = this.$feed.feed_id.get();
            Intrinsics.checkNotNullExpressionValue(str, "feed.feed_id.get()");
            String str2 = this.$content;
            this.label = 1;
            obj = qQStrangerFeedRepository.i(str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp> bVar = (QQStrangerFeedRepository.b) obj;
        if (bVar.getIsSuccess()) {
            this.this$0.S1().postValue(Boxing.boxInt(this.$feed.comment_count.get() + 1));
        } else {
            this.this$0.T1().postValue(bVar);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerSquareViewModel$doComment$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
