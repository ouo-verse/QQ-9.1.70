package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send;

import android.os.Handler;
import android.util.ArrayMap;
import androidx.core.util.Predicate;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichText;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J0\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0003H\u0014\u00a8\u0006\u001a"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart$getReplyCommentRequestCallback$1", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/replycomment/ReplyCommentRequestCallback2;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "feedDetailMainData", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "replyCommentArgs", "req", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;", "task", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "t", "", "result", "errMsg", "rsp", DomainData.DOMAIN_NAME, "v", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class InputSendPart$getReplyCommentRequestCallback$1 extends RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ a.CommentMainFeedData f220751b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ReplyCommentArgs f220752c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ InputSendPart f220753d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputSendPart$getReplyCommentRequestCallback$1(a.CommentMainFeedData commentMainFeedData, ReplyCommentArgs replyCommentArgs, InputSendPart inputSendPart) {
        super(false, 1, null);
        this.f220751b = commentMainFeedData;
        this.f220752c = replyCommentArgs;
        this.f220753d = inputSendPart;
    }

    private final GProStReply m(String taskId, a.CommentMainFeedData feedDetailMainData, ReplyCommentArgs replyCommentArgs, GProStDoReplyReq req) {
        AppInterface appInterface;
        GProStUser postUser;
        String selfTinyId;
        c cVar;
        GProStReply gProStReply = new GProStReply();
        InputSendPart inputSendPart = this.f220753d;
        gProStReply.idd = taskId;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null && (selfTinyId = iGPSService.getSelfTinyId()) != null) {
            Intrinsics.checkNotNullExpressionValue(selfTinyId, "selfTinyId");
            GProStUser postUser2 = gProStReply.postUser;
            Intrinsics.checkNotNullExpressionValue(postUser2, "postUser");
            com.tencent.mobileqq.guild.feed.nativeinterface.kt.b.d(postUser2, feedDetailMainData.getGuildId(), feedDetailMainData.getChannelId(), selfTinyId);
            cVar = inputSendPart.commentReplyArgsProvider;
            if (cVar != null) {
                GProStUser postUser3 = gProStReply.postUser;
                Intrinsics.checkNotNullExpressionValue(postUser3, "postUser");
                cVar.c(postUser3);
            }
        }
        if (replyCommentArgs.getReplyType() == 1) {
            gProStReply.targetUser = replyCommentArgs.getComment().postUser;
        } else {
            GProStReply reply = replyCommentArgs.getReply();
            if (reply != null && (postUser = reply.postUser) != null) {
                Intrinsics.checkNotNullExpressionValue(postUser, "postUser");
                gProStReply.targetUser = postUser;
            }
        }
        gProStReply.targetReplyID = replyCommentArgs.e();
        gProStReply.createTime = req.reply.createTime;
        gProStReply.richContents = req.replyContent;
        return gProStReply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(InputSendPart this$0, boolean z16, int i3, String errMsg, ReplyCommentArgs replyCommentArgs, GProStReply gProStReply, GProStDoReplyReq req, GProStDoReplyRsp rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        Intrinsics.checkNotNullParameter(replyCommentArgs, "$replyCommentArgs");
        Intrinsics.checkNotNullParameter(req, "$req");
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        if (yl1.n.v(i3)) {
            errMsg = "";
        }
        this$0.ea(z16, errMsg);
        this$0.broadcastMessage("message_on_reply_completed", new a.OnReplyCommentCompletedMessage(replyCommentArgs.getReplyType(), z16, gProStReply, req, rsp, replyCommentArgs.getPayload()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(GProStDoReplyReq req, Pair pair) {
        Intrinsics.checkNotNullParameter(req, "$req");
        return Intrinsics.areEqual(pair.getFirst(), req);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(InputSendPart this$0, ReplyCommentArgs replyCommentArgs, GProStReply fakeReply, GProStDoReplyReq req) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyCommentArgs, "$replyCommentArgs");
        Intrinsics.checkNotNullParameter(fakeReply, "$fakeReply");
        Intrinsics.checkNotNullParameter(req, "$req");
        this$0.broadcastMessage("message_on_reply_comment_sending", new a.OnReplyCommentSendingMessage(replyCommentArgs.getReplyType(), fakeReply, req, replyCommentArgs.getPayload()));
        this$0.broadcastMessage("message_on_reply_completed", new a.OnReplyCommentCompletedMessage(replyCommentArgs.getReplyType(), false, fakeReply, req, null, replyCommentArgs.getPayload()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(InputSendPart this$0, ReplyCommentArgs replyCommentArgs, GProStReply fakeReply, GProStDoReplyReq req) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyCommentArgs, "$replyCommentArgs");
        Intrinsics.checkNotNullParameter(fakeReply, "$fakeReply");
        Intrinsics.checkNotNullParameter(req, "$req");
        this$0.broadcastMessage("message_on_reply_comment_sending", new a.OnReplyCommentSendingMessage(replyCommentArgs.getReplyType(), fakeReply, req, replyCommentArgs.getPayload()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean u(GProStDoReplyReq req, Pair pair) {
        Intrinsics.checkNotNullParameter(req, "$req");
        return Intrinsics.areEqual(pair.getFirst(), req);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull ICommentTask task, final int result, @NotNull final String errMsg, @NotNull final GProStDoReplyReq req, @NotNull final GProStDoReplyRsp rsp) {
        final boolean z16;
        LinkedList linkedList;
        Object ga5;
        GProStReply gProStReply;
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
        InputSendPart inputSendPart = this.f220753d;
        linkedList = inputSendPart.pendingReplyRequests;
        ga5 = inputSendPart.ga(linkedList, z16, new Predicate() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.n
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                boolean p16;
                p16 = InputSendPart$getReplyCommentRequestCallback$1.p(GProStDoReplyReq.this, (Pair) obj);
                return p16;
            }
        });
        Pair pair = (Pair) ga5;
        if (pair != null) {
            gProStReply = (GProStReply) pair.getSecond();
        } else {
            gProStReply = null;
        }
        final GProStReply gProStReply2 = gProStReply;
        arrayMap = this.f220753d.pendingSendTaskList;
        InputSendPart inputSendPart2 = this.f220753d;
        synchronized (arrayMap) {
            if (z16) {
                arrayMap2 = inputSendPart2.pendingSendTaskList;
                arrayMap2.remove(task.getCom.heytap.mcssdk.a.a.d java.lang.String());
            }
            Unit unit = Unit.INSTANCE;
        }
        if (gProStReply2 == null) {
            QLog.e("InputSendPart", 1, "cannot find target fakeReply for " + req.hashCode() + ", thread safe problem happens!");
            return;
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final InputSendPart inputSendPart3 = this.f220753d;
        final ReplyCommentArgs replyCommentArgs = this.f220752c;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.o
            @Override // java.lang.Runnable
            public final void run() {
                InputSendPart$getReplyCommentRequestCallback$1.o(InputSendPart.this, z16, result, errMsg, replyCommentArgs, gProStReply2, req, rsp);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean d(@NotNull ICommentTask task, @NotNull final GProStDoReplyReq req) {
        LinkedList linkedList;
        LinkedList linkedList2;
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(req, "req");
        final GProStReply m3 = m(task.getCom.heytap.mcssdk.a.a.d java.lang.String(), this.f220751b, this.f220752c, req);
        req.replyContent = new GProStRichText();
        linkedList = this.f220753d.pendingReplyRequests;
        InputSendPart inputSendPart = this.f220753d;
        synchronized (linkedList) {
            linkedList2 = inputSendPart.pendingReplyRequests;
            linkedList2.add(TuplesKt.to(req, m3));
        }
        arrayMap = this.f220753d.pendingSendTaskList;
        InputSendPart inputSendPart2 = this.f220753d;
        synchronized (arrayMap) {
            arrayMap2 = inputSendPart2.pendingSendTaskList;
        }
        if (yl1.n.d(false, 0, 3, null)) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final InputSendPart inputSendPart3 = this.f220753d;
            final ReplyCommentArgs replyCommentArgs = this.f220752c;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.q
                @Override // java.lang.Runnable
                public final void run() {
                    InputSendPart$getReplyCommentRequestCallback$1.r(InputSendPart.this, replyCommentArgs, m3, req);
                }
            });
            return false;
        }
        Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
        final InputSendPart inputSendPart4 = this.f220753d;
        final ReplyCommentArgs replyCommentArgs2 = this.f220752c;
        uIHandlerV22.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.r
            @Override // java.lang.Runnable
            public final void run() {
                InputSendPart$getReplyCommentRequestCallback$1.s(InputSendPart.this, replyCommentArgs2, m3, req);
            }
        });
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void e(@NotNull ICommentTask task, @NotNull final GProStDoReplyReq req) {
        LinkedList linkedList;
        Object ga5;
        GProStReply gProStReply;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(req, "req");
        InputSendPart inputSendPart = this.f220753d;
        linkedList = inputSendPart.pendingReplyRequests;
        ga5 = inputSendPart.ga(linkedList, false, new Predicate() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.p
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                boolean u16;
                u16 = InputSendPart$getReplyCommentRequestCallback$1.u(GProStDoReplyReq.this, (Pair) obj);
                return u16;
            }
        });
        Pair pair = (Pair) ga5;
        if (pair != null) {
            gProStReply = (GProStReply) pair.getSecond();
        } else {
            gProStReply = null;
        }
        GProStReply gProStReply2 = gProStReply;
        if (gProStReply2 == null) {
            QLog.e("InputSendPart", 1, "cannot find target fakeReply for " + req.hashCode() + ", thread safe problem happens!");
            return;
        }
        LifecycleCoroutineScope e16 = com.tencent.mobileqq.guild.feed.part.a.e(this.f220753d);
        if (e16 != null) {
            BuildersKt__Builders_commonKt.launch$default(e16, null, null, new InputSendPart$getReplyCommentRequestCallback$1$onRequestSendingFail$1(this.f220753d, this.f220752c, gProStReply2, req, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void g(@NotNull GProStDoReplyReq req, @NotNull GProStDoReplyRsp rsp) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
    }
}
