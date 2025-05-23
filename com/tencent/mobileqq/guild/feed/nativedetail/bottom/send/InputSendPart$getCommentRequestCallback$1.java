package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send;

import android.os.Handler;
import android.util.ArrayMap;
import androidx.core.util.Predicate;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichText;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J(\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J0\u0010\u0017\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0003H\u0014\u00a8\u0006\u0019"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart$getCommentRequestCallback$1", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/CommentFeedRequestCallback;", "", "commentTaskId", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "commentInReq", "guildId", "channelId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;", "task", "req", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "t", "", "result", "errMsg", "rsp", DomainData.DOMAIN_NAME, "v", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class InputSendPart$getCommentRequestCallback$1 extends RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ InputSendPart f220743b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a.CommentMainFeedData f220744c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputSendPart$getCommentRequestCallback$1(InputSendPart inputSendPart, a.CommentMainFeedData commentMainFeedData) {
        super(false, 1, null);
        this.f220743b = inputSendPart;
        this.f220744c = commentMainFeedData;
    }

    private final GProStComment m(String commentTaskId, GProStComment commentInReq, String guildId, String channelId) {
        c cVar;
        c cVar2;
        GProStComment gProStComment = new GProStComment();
        InputSendPart inputSendPart = this.f220743b;
        gProStComment.idd = commentTaskId;
        cVar = inputSendPart.commentReplyArgsProvider;
        if (cVar != null) {
            cVar2 = inputSendPart.commentReplyArgsProvider;
            Intrinsics.checkNotNull(cVar2);
            GProStUser postUser = gProStComment.postUser;
            Intrinsics.checkNotNullExpressionValue(postUser, "postUser");
            cVar2.c(postUser);
            gProStComment.postUser.idd = commentInReq.postUser.idd;
        } else {
            GProStUser postUser2 = gProStComment.postUser;
            Intrinsics.checkNotNullExpressionValue(postUser2, "postUser");
            String str = commentInReq.postUser.idd;
            Intrinsics.checkNotNullExpressionValue(str, "commentInReq.postUser.idd");
            com.tencent.mobileqq.guild.feed.nativeinterface.kt.b.d(postUser2, guildId, channelId, str);
        }
        gProStComment.createTime = commentInReq.createTime;
        gProStComment.richContents = commentInReq.richContents;
        return gProStComment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(GProStDoCommentReq req, Pair pair) {
        Intrinsics.checkNotNullParameter(req, "$req");
        return Intrinsics.areEqual(pair.getFirst(), req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(InputSendPart this$0, boolean z16, int i3, String errMsg, GProStComment gProStComment, GProStDoCommentReq req, GProStDoCommentRsp rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        if (yl1.n.v(i3)) {
            errMsg = "";
        }
        this$0.da(z16, errMsg);
        this$0.broadcastMessage("message_on_comment_completed", new a.OnCommentCompletedMessage(z16, gProStComment, req, rsp));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(InputSendPart this$0, GProStComment fakeComment, GProStDoCommentReq req) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fakeComment, "$fakeComment");
        Intrinsics.checkNotNullParameter(req, "$req");
        this$0.broadcastMessage("message_on_comment_sending", new a.OnCommentSendingMessage(fakeComment, req));
        this$0.broadcastMessage("message_on_comment_completed", new a.OnCommentCompletedMessage(false, fakeComment, req, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(InputSendPart this$0, GProStComment fakeComment, GProStDoCommentReq req) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fakeComment, "$fakeComment");
        Intrinsics.checkNotNullParameter(req, "$req");
        this$0.broadcastMessage("message_on_comment_sending", new a.OnCommentSendingMessage(fakeComment, req));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u(GProStDoCommentReq req, Pair pair) {
        Intrinsics.checkNotNullParameter(req, "$req");
        return Intrinsics.areEqual(pair.getFirst(), req);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull ICommentTask task, final int result, @NotNull final String errMsg, @NotNull final GProStDoCommentReq req, @NotNull final GProStDoCommentRsp rsp) {
        final boolean z16;
        LinkedList linkedList;
        Object ga5;
        GProStComment gProStComment;
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        if (result == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("InputSendPart", 1, "handleResponse isSuccess=" + z16 + " errMsg=" + errMsg);
        InputSendPart inputSendPart = this.f220743b;
        linkedList = inputSendPart.pendingCommentRequests;
        ga5 = inputSendPart.ga(linkedList, z16, new Predicate() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.i
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                boolean o16;
                o16 = InputSendPart$getCommentRequestCallback$1.o(GProStDoCommentReq.this, (Pair) obj);
                return o16;
            }
        });
        Pair pair = (Pair) ga5;
        if (pair != null) {
            gProStComment = (GProStComment) pair.getSecond();
        } else {
            gProStComment = null;
        }
        final GProStComment gProStComment2 = gProStComment;
        arrayMap = this.f220743b.pendingSendTaskList;
        InputSendPart inputSendPart2 = this.f220743b;
        synchronized (arrayMap) {
            if (z16) {
                arrayMap2 = inputSendPart2.pendingSendTaskList;
                arrayMap2.remove(task.getCom.heytap.mcssdk.a.a.d java.lang.String());
            }
            Unit unit = Unit.INSTANCE;
        }
        if (gProStComment2 == null) {
            QLog.e("InputSendPart", 1, "cannot find target fakeComment for " + req.hashCode() + ", thread safe problem happens!");
            return;
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final InputSendPart inputSendPart3 = this.f220743b;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.j
            @Override // java.lang.Runnable
            public final void run() {
                InputSendPart$getCommentRequestCallback$1.p(InputSendPart.this, z16, result, errMsg, gProStComment2, req, rsp);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean d(@NotNull ICommentTask task, @NotNull final GProStDoCommentReq req) {
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        LinkedList linkedList;
        LinkedList linkedList2;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(req, "req");
        arrayMap = this.f220743b.pendingSendTaskList;
        InputSendPart inputSendPart = this.f220743b;
        synchronized (arrayMap) {
            arrayMap2 = inputSendPart.pendingSendTaskList;
        }
        String str = task.getCom.heytap.mcssdk.a.a.d java.lang.String();
        GProStComment gProStComment = req.comment;
        Intrinsics.checkNotNullExpressionValue(gProStComment, "req.comment");
        final GProStComment m3 = m(str, gProStComment, this.f220744c.getGuildId(), this.f220744c.getChannelId());
        req.comment.richContents = new GProStRichText();
        linkedList = this.f220743b.pendingCommentRequests;
        InputSendPart inputSendPart2 = this.f220743b;
        synchronized (linkedList) {
            linkedList2 = inputSendPart2.pendingCommentRequests;
            linkedList2.add(TuplesKt.to(req, m3));
        }
        if (yl1.n.d(false, 0, 3, null)) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final InputSendPart inputSendPart3 = this.f220743b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.l
                @Override // java.lang.Runnable
                public final void run() {
                    InputSendPart$getCommentRequestCallback$1.r(InputSendPart.this, m3, req);
                }
            });
            return false;
        }
        Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
        final InputSendPart inputSendPart4 = this.f220743b;
        uIHandlerV22.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.m
            @Override // java.lang.Runnable
            public final void run() {
                InputSendPart$getCommentRequestCallback$1.s(InputSendPart.this, m3, req);
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void e(@NotNull ICommentTask task, @NotNull final GProStDoCommentReq req) {
        LinkedList linkedList;
        Object ga5;
        GProStComment gProStComment;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(req, "req");
        InputSendPart inputSendPart = this.f220743b;
        linkedList = inputSendPart.pendingCommentRequests;
        ga5 = inputSendPart.ga(linkedList, false, new Predicate() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.k
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                boolean u16;
                u16 = InputSendPart$getCommentRequestCallback$1.u(GProStDoCommentReq.this, (Pair) obj);
                return u16;
            }
        });
        Pair pair = (Pair) ga5;
        if (pair != null) {
            gProStComment = (GProStComment) pair.getSecond();
        } else {
            gProStComment = null;
        }
        if (gProStComment == null) {
            QLog.e("InputSendPart", 1, "cannot find target fakeComment for " + req.hashCode() + ", thread safe problem happens!");
            return;
        }
        LifecycleCoroutineScope e16 = com.tencent.mobileqq.guild.feed.part.a.e(this.f220743b);
        if (e16 != null) {
            BuildersKt__Builders_commonKt.launch$default(e16, null, null, new InputSendPart$getCommentRequestCallback$1$onRequestSendingFail$1(this.f220743b, gProStComment, req, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void g(@NotNull GProStDoCommentReq req, @NotNull GProStDoCommentRsp rsp) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
    }
}
