package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoReplyCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import yl1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J>\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/replycomment/b;", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "currentFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "currentReply", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "currentComment", "", "isPoster", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "b", "feed", "reply", "comment", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/replycomment/ReplyCommentRequestCallback2;", "callback", "", "c", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    private final GProStDoReplyReq b(a.CommentMainFeedData currentFeed, GProStReply currentReply, GProStComment currentComment, boolean isPoster) {
        GProStDoReplyReq gProStDoReplyReq = new GProStDoReplyReq();
        gProStDoReplyReq.feed.idd = currentFeed.getFeedId();
        gProStDoReplyReq.feed.poster.idd = currentFeed.getPosterId();
        gProStDoReplyReq.feed.createTime = currentFeed.getCreateTime();
        try {
            gProStDoReplyReq.feed.channelInfo.sign.channelId = Long.parseLong(currentFeed.getChannelId());
        } catch (Exception unused) {
        }
        GProStComment gProStComment = gProStDoReplyReq.comment;
        gProStComment.idd = currentComment.idd;
        gProStComment.postUser.idd = currentComment.postUser.idd;
        gProStComment.createTime = currentComment.createTime;
        gProStComment.createTimeNs = currentComment.createTimeNs;
        GProStReply gProStReply = gProStDoReplyReq.reply;
        gProStReply.idd = currentReply.idd;
        gProStReply.postUser.idd = currentReply.postUser.idd;
        gProStReply.createTime = currentReply.createTime;
        gProStReply.createTimeNs = currentReply.createTimeNs;
        int i3 = 0;
        gProStDoReplyReq.from = 0;
        gProStDoReplyReq.jsonReply = "{}";
        if (isPoster) {
            i3 = 2;
        }
        gProStDoReplyReq.replyType = i3;
        GProStCommonExt gProStCommonExt = new GProStCommonExt();
        gProStCommonExt.mapInfoList.addAll(i.f450608a.f());
        gProStDoReplyReq.extInfo = gProStCommonExt;
        return gProStDoReplyReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RequestSenderCallback callback, GProStDoReplyReq req, int i3, String errMsg, boolean z16, GProStDoReplyRsp rsp) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(req, "$req");
        com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.a aVar = new com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.a();
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        callback.b(aVar, i3, errMsg, req, rsp);
    }

    public final void c(@NotNull a.CommentMainFeedData feed, @NotNull GProStReply reply, @NotNull GProStComment comment, boolean isPoster, @NotNull final RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp> callback) {
        o c16;
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(reply, "reply");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final GProStDoReplyReq b16 = b(feed, reply, comment, isPoster);
        if (callback.d(new com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.a(), b16) && (c16 = l.c()) != null) {
            c16.doReply(b16, new IGProDoReplyCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment.a
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoReplyCallback
                public final void onResult(int i3, String str, boolean z16, GProStDoReplyRsp gProStDoReplyRsp) {
                    b.d(RequestSenderCallback.this, b16, i3, str, z16, gProStDoReplyRsp);
                }
            });
        }
    }
}
