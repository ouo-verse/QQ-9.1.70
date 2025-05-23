package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment;

import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.detail.CommentDataUtil;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.ICommentTask;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.STATE;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.FeedRichTextConvertTool;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedRichContentResultBean;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoReplyCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import yl1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<JK\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\u0004\u0018\u0001`\u0018H\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010)\u001a\u00020\f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010*R:\u00102\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u0018\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010:\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/replycomment/ReplyCommentTask;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;", "", "content", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "localMediaInfoList", "", "originalPic", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "feed", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "replyCommentArgs", "", "H", "(Ljava/lang/String;Ljava/util/ArrayList;ZLcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;", "replyRichText", "jsonFromReplyRichText", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/replycomment/ReplyCommentRequestCallback2;", "D", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "j", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "E", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;", "K", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$c;)V", "k", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "G", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "M", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;)V", "replyArgs", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", "req", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "getCallbackWf", "()Ljava/lang/ref/WeakReference;", "J", "(Ljava/lang/ref/WeakReference;)V", "callbackWf", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", UserInfo.SEX_FEMALE, "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "L", "(Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "perfStageReportTask", "<init>", "()V", "o", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ReplyCommentTask extends ICommentTask {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public a.CommentMainFeedData feed;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public ReplyCommentArgs replyArgs;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GProStDoReplyReq req;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp>> callbackWf;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask perfStageReportTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0002\b\u0005R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/replycomment/ReplyCommentTask$a;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/replycomment/ReplyCommentTask;", "", "Lkotlin/ExtensionFunctionType;", "init", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;", "a", "", "REPLY_ID_PREFIX", "Ljava/lang/String;", "", "REPLY_TYPE", "I", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment.ReplyCommentTask$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ICommentTask a(@NotNull Function1<? super ReplyCommentTask, Unit> init) {
            Intrinsics.checkNotNullParameter(init, "init");
            ReplyCommentTask replyCommentTask = new ReplyCommentTask();
            init.invoke(replyCommentTask);
            return replyCommentTask;
        }

        Companion() {
        }
    }

    public ReplyCommentTask() {
        super("ReplyCommentTask");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B() {
        if (this.feed != null && this.replyArgs != null) {
            if (k()) {
                return true;
            }
            QLog.e("ReplyCommentTask", 1, "need config lifecycleScope");
            if (!QLog.isDebugVersion()) {
                return false;
            }
            throw new Exception("need config lifecycleScope");
        }
        QLog.e("ReplyCommentTask", 1, "need config feed");
        if (!QLog.isDebugVersion()) {
            return false;
        }
        throw new Exception("need config lifecycleScope");
    }

    private final GProStDoReplyReq C(GuildFeedRichContentResultBean replyRichText, String jsonFromReplyRichText, ReplyCommentArgs replyCommentArgs, a.CommentMainFeedData feed) {
        String idd;
        GProStUser postUser;
        GProStDoReplyReq gProStDoReplyReq = new GProStDoReplyReq();
        gProStDoReplyReq.jsonReply = jsonFromReplyRichText;
        gProStDoReplyReq.replyType = 1;
        gProStDoReplyReq.replyContent = new FeedRichTextConvertTool().c(replyRichText);
        GProStReply gProStReply = gProStDoReplyReq.reply;
        gProStReply.postUser.idd = ax.u();
        gProStReply.createTime = NetConnInfoCenter.getServerTime();
        GProStUser gProStUser = gProStReply.targetUser;
        GProStReply reply = replyCommentArgs.getReply();
        if (reply == null || (postUser = reply.getPostUser()) == null || (idd = postUser.getIdd()) == null) {
            idd = replyCommentArgs.getComment().getPostUser().getIdd();
        }
        gProStUser.idd = idd;
        gProStReply.targetReplyID = replyCommentArgs.e();
        GProStComment comment = replyCommentArgs.getComment();
        GProStComment gProStComment = gProStDoReplyReq.comment;
        gProStComment.idd = comment.getIdd();
        gProStComment.createTime = comment.getCreateTime();
        gProStComment.postUser.idd = comment.getPostUser().getIdd();
        GProStFeed gProStFeed = gProStDoReplyReq.feed;
        gProStFeed.idd = feed.getFeedId();
        gProStFeed.createTime = feed.getCreateTime();
        gProStFeed.poster.idd = feed.getPosterId();
        GProStChannelSign gProStChannelSign = gProStFeed.channelInfo.sign;
        try {
            gProStChannelSign.guildId = Long.parseLong(feed.getGuildId());
            gProStChannelSign.channelId = Long.parseLong(feed.getChannelId());
        } catch (Exception unused) {
        }
        gProStDoReplyReq.needSyncGroup = replyCommentArgs.getNeedSyncToGroup();
        GProStCommonExt gProStCommonExt = new GProStCommonExt();
        gProStCommonExt.mapInfoList.addAll(i.f450608a.f());
        gProStDoReplyReq.extInfo = gProStCommonExt;
        return gProStDoReplyReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp> D() {
        WeakReference<RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp>> weakReference = this.callbackWf;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object H(String str, ArrayList<LocalMediaInfo> arrayList, boolean z16, a.CommentMainFeedData commentMainFeedData, ReplyCommentArgs replyCommentArgs, Continuation<? super Unit> continuation) {
        ReplyCommentTask$sendInner$1 replyCommentTask$sendInner$1;
        Object coroutine_suspended;
        int i3;
        GuildFeedRichContentResultBean c16;
        final GProStDoReplyReq C;
        boolean z17;
        final ReplyCommentTask replyCommentTask;
        GProStDoReplyReq gProStDoReplyReq;
        Object m476constructorimpl;
        String str2;
        o c17;
        RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp> D;
        com.tencent.qqnt.msg.api.c cVar;
        boolean z18 = z16;
        if (continuation instanceof ReplyCommentTask$sendInner$1) {
            replyCommentTask$sendInner$1 = (ReplyCommentTask$sendInner$1) continuation;
            int i16 = replyCommentTask$sendInner$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                replyCommentTask$sendInner$1.label = i16 - Integer.MIN_VALUE;
                Object obj = replyCommentTask$sendInner$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = replyCommentTask$sendInner$1.label;
                String str3 = "";
                String str4 = null;
                boolean z19 = true;
                if (i3 == 0) {
                    if (i3 == 1) {
                        z18 = replyCommentTask$sendInner$1.Z$0;
                        gProStDoReplyReq = (GProStDoReplyReq) replyCommentTask$sendInner$1.L$2;
                        c16 = (GuildFeedRichContentResultBean) replyCommentTask$sendInner$1.L$1;
                        replyCommentTask = (ReplyCommentTask) replyCommentTask$sendInner$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    s("feed_Reply" + UUID.randomUUID());
                    r(STATE.INITIAL);
                    c16 = CommentDataUtil.c(str, arrayList, z16);
                    Object obj2 = c16.ext;
                    if (obj2 instanceof JSONObject) {
                        if (ax.g(commentMainFeedData.getGuildId(), (JSONObject) obj2)) {
                            com.tencent.mobileqq.guild.feed.report.c.f223280a.b(this.perfStageReportTask, "stage_finish", -1L, "intercept of at");
                            return Unit.INSTANCE;
                        }
                        c16.ext = null;
                    }
                    C = C(c16, "", replyCommentArgs, commentMainFeedData);
                    QLog.i("ReplyCommentTask", 1, "doReply | feedId = " + commentMainFeedData.getFeedId() + ", requestHashCode = " + C.hashCode());
                    if (!arrayList.isEmpty()) {
                        C.replyContent.images = CommentDataUtil.b(arrayList, z16);
                    }
                    RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp> D2 = D();
                    if (D2 != null) {
                        z17 = D2.d(this, C);
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        com.tencent.mobileqq.guild.feed.report.c.f223280a.b(this.perfStageReportTask, "stage_finish", -1L, "network err");
                        return Unit.INSTANCE;
                    }
                    if (!arrayList.isEmpty()) {
                        com.tencent.mobileqq.guild.feed.report.c.f223280a.p(this.perfStageReportTask, "stage_upload_media_start");
                        r(STATE.MEDIA_UPLOADING);
                        replyCommentTask$sendInner$1.L$0 = this;
                        replyCommentTask$sendInner$1.L$1 = c16;
                        replyCommentTask$sendInner$1.L$2 = C;
                        replyCommentTask$sendInner$1.Z$0 = z18;
                        replyCommentTask$sendInner$1.label = 1;
                        obj = t(arrayList, z18, replyCommentTask$sendInner$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        replyCommentTask = this;
                        gProStDoReplyReq = C;
                    } else {
                        replyCommentTask = this;
                        replyCommentTask.r(STATE.COMMENT_SENDING);
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(new Gson().toJson(c16));
                        } catch (Throwable th5) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                        }
                        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null && (D = replyCommentTask.D()) != null) {
                            D.a("ReplyCommentTask", "sendRequest| toJson fail");
                        }
                        if (Result.m482isFailureimpl(m476constructorimpl)) {
                            m476constructorimpl = null;
                        }
                        str2 = (String) m476constructorimpl;
                        if (str2 != null) {
                            if (str2.length() <= 0) {
                                z19 = false;
                            }
                            if (z19) {
                                str4 = str2;
                            }
                            if (str4 != null) {
                                str3 = str4;
                            }
                        }
                        C.jsonReply = str3;
                        replyCommentTask.req = C;
                        com.tencent.mobileqq.guild.feed.report.c.f223280a.p(replyCommentTask.perfStageReportTask, "stage_send_comment_start");
                        c17 = l.c();
                        if (c17 != null) {
                            c17.doReply(C, new IGProDoReplyCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.replycomment.c
                                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoReplyCallback
                                public final void onResult(int i17, String str5, boolean z26, GProStDoReplyRsp gProStDoReplyRsp) {
                                    ReplyCommentTask.I(ReplyCommentTask.this, C, i17, str5, z26, gProStDoReplyRsp);
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                }
                cVar = (com.tencent.qqnt.msg.api.c) obj;
                com.tencent.mobileqq.guild.feed.report.c.f223280a.b(replyCommentTask.perfStageReportTask, "stage_upload_media_end", cVar.c(), cVar.b());
                if (cVar.d()) {
                    QLog.e("ReplyCommentTask", 1, "imageUploadResult code=" + cVar.c() + ", msg=" + cVar.b());
                    replyCommentTask.r(STATE.MEDIA_UPLOAD_FAILED);
                    RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp> D3 = replyCommentTask.D();
                    if (D3 != null) {
                        D3.e(replyCommentTask, gProStDoReplyReq);
                    }
                    return Unit.INSTANCE;
                }
                CommentDataUtil.g(c16, (Collection) cVar.a(), z18);
                gProStDoReplyReq.reply.richContents = new FeedRichTextConvertTool().c(c16);
                C = gProStDoReplyReq;
                replyCommentTask.r(STATE.COMMENT_SENDING);
                Result.Companion companion3 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(new Gson().toJson(c16));
                if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                    D.a("ReplyCommentTask", "sendRequest| toJson fail");
                }
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                }
                str2 = (String) m476constructorimpl;
                if (str2 != null) {
                }
                C.jsonReply = str3;
                replyCommentTask.req = C;
                com.tencent.mobileqq.guild.feed.report.c.f223280a.p(replyCommentTask.perfStageReportTask, "stage_send_comment_start");
                c17 = l.c();
                if (c17 != null) {
                }
                return Unit.INSTANCE;
            }
        }
        replyCommentTask$sendInner$1 = new ReplyCommentTask$sendInner$1(this, continuation);
        Object obj3 = replyCommentTask$sendInner$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = replyCommentTask$sendInner$1.label;
        String str32 = "";
        String str42 = null;
        boolean z192 = true;
        if (i3 == 0) {
        }
        cVar = (com.tencent.qqnt.msg.api.c) obj3;
        com.tencent.mobileqq.guild.feed.report.c.f223280a.b(replyCommentTask.perfStageReportTask, "stage_upload_media_end", cVar.c(), cVar.b());
        if (cVar.d()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(ReplyCommentTask this$0, GProStDoReplyReq request, int i3, String errMsg, boolean z16, GProStDoReplyRsp rsp) {
        STATE state;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        QLog.i("ReplyCommentTask", 1, "handleReplyRsp result = " + i3 + " errorMsg = " + errMsg);
        com.tencent.mobileqq.guild.feed.report.c.f223280a.F(this$0.perfStageReportTask, "stage_finish", (long) i3, errMsg, this$0.req, rsp);
        if (i3 == 0) {
            this$0.b();
            state = STATE.SUCCESS;
        } else {
            state = STATE.COMMENT_SEND_FAILED;
        }
        this$0.r(state);
        RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp> D = this$0.D();
        if (D != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            D.b(this$0, i3, errMsg, request, rsp);
        }
    }

    @NotNull
    public final a.CommentMainFeedData E() {
        a.CommentMainFeedData commentMainFeedData = this.feed;
        if (commentMainFeedData != null) {
            return commentMainFeedData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("feed");
        return null;
    }

    @Nullable
    /* renamed from: F, reason: from getter */
    public final IPerformanceReportTask getPerfStageReportTask() {
        return this.perfStageReportTask;
    }

    @NotNull
    public final ReplyCommentArgs G() {
        ReplyCommentArgs replyCommentArgs = this.replyArgs;
        if (replyCommentArgs != null) {
            return replyCommentArgs;
        }
        Intrinsics.throwUninitializedPropertyAccessException("replyArgs");
        return null;
    }

    public final void J(@Nullable WeakReference<RequestSenderCallback<GProStDoReplyReq, GProStDoReplyRsp>> weakReference) {
        this.callbackWf = weakReference;
    }

    public final void K(@NotNull a.CommentMainFeedData commentMainFeedData) {
        Intrinsics.checkNotNullParameter(commentMainFeedData, "<set-?>");
        this.feed = commentMainFeedData;
    }

    public final void L(@Nullable IPerformanceReportTask iPerformanceReportTask) {
        this.perfStageReportTask = iPerformanceReportTask;
    }

    public final void M(@NotNull ReplyCommentArgs replyCommentArgs) {
        Intrinsics.checkNotNullParameter(replyCommentArgs, "<set-?>");
        this.replyArgs = replyCommentArgs;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.ICommentTask
    public void l() {
        BuildersKt__Builders_commonKt.launch$default(d(), null, null, new ReplyCommentTask$resend$1(this, null), 3, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.ICommentTask
    public void m() {
        if (B()) {
            BuildersKt__Builders_commonKt.launch$default(d(), null, null, new ReplyCommentTask$send$1(this, null), 3, null);
        }
    }
}
