package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoCommentCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import yl1.i;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J6\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/b;", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "currentFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "currentComment", "", "isPoster", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "b", "feed", "comment", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/CommentFeedRequestCallback;", "callback", "", "c", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    private final GProStDoCommentReq b(a.CommentMainFeedData currentFeed, GProStComment currentComment, boolean isPoster) {
        GProStDoCommentReq gProStDoCommentReq = new GProStDoCommentReq();
        gProStDoCommentReq.feed.idd = currentFeed.getFeedId();
        gProStDoCommentReq.feed.poster.idd = currentFeed.getPosterId();
        gProStDoCommentReq.feed.createTime = currentFeed.getCreateTime();
        try {
            gProStDoCommentReq.feed.channelInfo.sign.channelId = Long.parseLong(currentFeed.getChannelId());
        } catch (Exception unused) {
        }
        GProStComment gProStComment = gProStDoCommentReq.comment;
        gProStComment.idd = currentComment.idd;
        gProStComment.postUser.idd = currentComment.postUser.idd;
        gProStComment.createTime = currentComment.createTime;
        gProStComment.createTimeNs = currentComment.createTimeNs;
        int i3 = 0;
        gProStDoCommentReq.from = 0;
        gProStDoCommentReq.jsonComment = "{}";
        if (isPoster) {
            i3 = 2;
        }
        gProStDoCommentReq.commentType = i3;
        GProStCommonExt gProStCommonExt = new GProStCommonExt();
        gProStCommonExt.mapInfoList.addAll(i.f450608a.f());
        gProStDoCommentReq.extInfo = gProStCommonExt;
        return gProStDoCommentReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RequestSenderCallback callback, GProStDoCommentReq req, int i3, String errMsg, boolean z16, GProStDoCommentRsp rsp) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(req, "$req");
        com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.a aVar = new com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.a();
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        callback.b(aVar, i3, errMsg, req, rsp);
    }

    public final void c(@NotNull a.CommentMainFeedData feed, @NotNull GProStComment comment, boolean isPoster, @NotNull final RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp> callback) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final GProStDoCommentReq b16 = b(feed, comment, isPoster);
        o c16 = l.c();
        if (c16 != null) {
            c16.doComment(b16, new IGProDoCommentCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.a
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoCommentCallback
                public final void onResult(int i3, String str, boolean z16, GProStDoCommentRsp gProStDoCommentRsp) {
                    b.d(RequestSenderCallback.this, b16, i3, str, z16, gProStDoCommentRsp);
                }
            });
        }
    }
}
