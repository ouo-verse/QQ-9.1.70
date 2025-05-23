package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction;

import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.repository.QQStrangerFeedRepository;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$CommentAndReplyRsp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
/* synthetic */ class QQStrangerLiteActionListPart$onPartCreate$1 extends FunctionReferenceImpl implements Function1<QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp>, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp> bVar) {
        invoke2(bVar);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QQStrangerLiteActionListPart$onPartCreate$1(Object obj) {
        super(1, obj, QQStrangerLiteActionListPart.class, "handleCommentReply", "handleCommentReply(Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/repository/QQStrangerFeedRepository$ResponseData;)V", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(QQStrangerFeedRepository.b<FeedPB$CommentAndReplyRsp> p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((QQStrangerLiteActionListPart) this.receiver).K9(p06);
    }
}
