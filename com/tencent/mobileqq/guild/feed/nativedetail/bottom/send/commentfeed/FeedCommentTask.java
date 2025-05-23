package com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed;

import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.detail.CommentDataUtil;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.ICommentTask;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.STATE;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.framework.RequestSenderCallback;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.FeedRichTextConvertTool;
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
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoCommentCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import yl1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104JC\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\bH\u0002J\u001c\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010j\u0004\u0018\u0001`\u0013H\u0002J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\fH\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR:\u0010%\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u0002`\u0013\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010+\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00102\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/FeedCommentTask;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;", "", "content", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "localMediaInfoList", "", "originalPic", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/c;", "commentRequestArgs", "", "H", "(Ljava/lang/String;Ljava/util/ArrayList;ZLcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/framework/RequestSenderCallback;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/CommentFeedRequestCallback;", "E", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;", "richText", "jsonFormRichText", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "j", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", "req", "Ljava/lang/ref/WeakReference;", "k", "Ljava/lang/ref/WeakReference;", "getCallbackWf", "()Ljava/lang/ref/WeakReference;", "J", "(Ljava/lang/ref/WeakReference;)V", "callbackWf", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/c;", "G", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/c;", "L", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/c;)V", "requestArgs", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", UserInfo.SEX_FEMALE, "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "K", "(Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "perfStageReportTask", "<init>", "()V", DomainData.DOMAIN_NAME, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedCommentTask extends ICommentTask {

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GProStDoCommentReq req;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp>> callbackWf;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public CommentFeedRequestArgs requestArgs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask perfStageReportTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\b\u001a\u00020\u00072\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0002\b\u0005R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/FeedCommentTask$a;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/FeedCommentTask;", "", "Lkotlin/ExtensionFunctionType;", "init", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/ICommentTask;", "a", "", "COMMENT_FROM", "I", "", "COMMENT_ID_PREFIX", "Ljava/lang/String;", "COMMENT_TYPE", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.FeedCommentTask$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ICommentTask a(@NotNull Function1<? super FeedCommentTask, Unit> init) {
            Intrinsics.checkNotNullParameter(init, "init");
            FeedCommentTask feedCommentTask = new FeedCommentTask();
            init.invoke(feedCommentTask);
            return feedCommentTask;
        }

        Companion() {
        }
    }

    public FeedCommentTask() {
        super("FeedCommentTask");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean C() {
        if (!k()) {
            QLog.e("FeedCommentTask", 1, "need config lifecycleScope");
            if (!QLog.isDebugVersion()) {
                return false;
            }
            throw new Exception("need config lifecycleScope");
        }
        if (this.requestArgs != null) {
            return true;
        }
        QLog.e("FeedCommentTask", 1, "need config requestArgs");
        if (!QLog.isDebugVersion()) {
            return false;
        }
        throw new Exception("need config requestArgs");
    }

    private final GProStDoCommentReq D(CommentFeedRequestArgs commentRequestArgs, GuildFeedRichContentResultBean richText, String jsonFormRichText) {
        GProStFeed gProStFeed = new GProStFeed();
        gProStFeed.idd = commentRequestArgs.getFeedId();
        gProStFeed.createTime = commentRequestArgs.getFeedCreateTime();
        GProStUser gProStUser = new GProStUser();
        gProStUser.idd = commentRequestArgs.getFeedPosterTinyId();
        gProStFeed.poster = gProStUser;
        GProStChannelInfo gProStChannelInfo = new GProStChannelInfo();
        GProStChannelSign gProStChannelSign = new GProStChannelSign();
        gProStChannelSign.guildId = Long.parseLong(commentRequestArgs.getGuildId());
        gProStChannelSign.channelId = Long.parseLong(commentRequestArgs.getChannelId());
        gProStChannelInfo.sign = gProStChannelSign;
        gProStFeed.channelInfo = gProStChannelInfo;
        GProStComment gProStComment = new GProStComment();
        GProStUser gProStUser2 = new GProStUser();
        gProStUser2.idd = ax.u();
        gProStComment.postUser = gProStUser2;
        gProStComment.createTime = NetConnInfoCenter.getServerTime();
        gProStComment.richContents = new FeedRichTextConvertTool().c(richText);
        GProStDoCommentReq gProStDoCommentReq = new GProStDoCommentReq();
        gProStDoCommentReq.jsonComment = jsonFormRichText;
        gProStDoCommentReq.commentType = 1;
        gProStDoCommentReq.feed = gProStFeed;
        gProStDoCommentReq.comment = gProStComment;
        gProStDoCommentReq.from = 0;
        gProStDoCommentReq.needSyncGroup = commentRequestArgs.getNeedSyncToGroup();
        GProStCommonExt gProStCommonExt = new GProStCommonExt();
        gProStCommonExt.mapInfoList.addAll(i.f450608a.f());
        gProStDoCommentReq.extInfo = gProStCommonExt;
        return gProStDoCommentReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp> E() {
        WeakReference<RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp>> weakReference = this.callbackWf;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object H(String str, ArrayList<LocalMediaInfo> arrayList, boolean z16, CommentFeedRequestArgs commentFeedRequestArgs, Continuation<? super Unit> continuation) {
        FeedCommentTask$sendCommentInner$1 feedCommentTask$sendCommentInner$1;
        Object coroutine_suspended;
        int i3;
        GuildFeedRichContentResultBean c16;
        final GProStDoCommentReq D;
        boolean z17;
        final FeedCommentTask feedCommentTask;
        Object obj;
        boolean z18;
        GProStDoCommentReq gProStDoCommentReq;
        Object m476constructorimpl;
        String str2;
        o c17;
        RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp> E;
        com.tencent.qqnt.msg.api.c cVar;
        CommentFeedRequestArgs commentFeedRequestArgs2 = commentFeedRequestArgs;
        if (continuation instanceof FeedCommentTask$sendCommentInner$1) {
            feedCommentTask$sendCommentInner$1 = (FeedCommentTask$sendCommentInner$1) continuation;
            int i16 = feedCommentTask$sendCommentInner$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                feedCommentTask$sendCommentInner$1.label = i16 - Integer.MIN_VALUE;
                Object obj2 = feedCommentTask$sendCommentInner$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = feedCommentTask$sendCommentInner$1.label;
                String str3 = "";
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    r(STATE.INITIAL);
                    c16 = CommentDataUtil.c(str, arrayList, false);
                    Object obj3 = c16.ext;
                    if (obj3 instanceof JSONObject) {
                        if (ax.g(commentFeedRequestArgs.getGuildId(), (JSONObject) obj3)) {
                            com.tencent.mobileqq.guild.feed.report.c.f223280a.b(this.perfStageReportTask, "stage_finish", -1L, "intercept of at");
                            return Unit.INSTANCE;
                        }
                        c16.ext = null;
                    }
                    D = D(commentFeedRequestArgs2, c16, "");
                    QLog.i("FeedCommentTask", 1, "onCommentFeedSending feedId = " + commentFeedRequestArgs.getFeedId() + " requestHashCode=" + D.hashCode());
                    RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp> E2 = E();
                    Boolean boxBoolean = E2 != null ? Boxing.boxBoolean(E2.d(this, D)) : null;
                    if (boxBoolean != null && (boxBoolean.booleanValue() ^ true)) {
                        com.tencent.mobileqq.guild.feed.report.c.f223280a.b(this.perfStageReportTask, "stage_finish", -1L, "network err");
                        return Unit.INSTANCE;
                    }
                    if (!arrayList.isEmpty()) {
                        com.tencent.mobileqq.guild.feed.report.c.f223280a.p(this.perfStageReportTask, "stage_upload_media_start");
                        r(STATE.MEDIA_UPLOADING);
                        feedCommentTask$sendCommentInner$1.L$0 = this;
                        feedCommentTask$sendCommentInner$1.L$1 = commentFeedRequestArgs2;
                        feedCommentTask$sendCommentInner$1.L$2 = c16;
                        feedCommentTask$sendCommentInner$1.L$3 = D;
                        feedCommentTask$sendCommentInner$1.Z$0 = z16;
                        feedCommentTask$sendCommentInner$1.label = 1;
                        Object t16 = t(arrayList, z16, feedCommentTask$sendCommentInner$1);
                        if (t16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = t16;
                        feedCommentTask = this;
                        z18 = z16;
                        gProStDoCommentReq = D;
                    } else {
                        z17 = true;
                        feedCommentTask = this;
                        feedCommentTask.r(STATE.COMMENT_SENDING);
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(new Gson().toJson(c16));
                        } catch (Throwable th5) {
                            Result.Companion companion2 = Result.INSTANCE;
                            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                        }
                        if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null && (E = feedCommentTask.E()) != null) {
                            E.a("FeedCommentTask", "sendRequest| toJson fail, feedId: " + commentFeedRequestArgs2.getFeedId());
                        }
                        if (Result.m482isFailureimpl(m476constructorimpl)) {
                            m476constructorimpl = null;
                        }
                        str2 = (String) m476constructorimpl;
                        if (str2 != null) {
                            if (str2.length() <= 0) {
                                z17 = false;
                            }
                            String str4 = z17 ? str2 : null;
                            if (str4 != null) {
                                str3 = str4;
                            }
                        }
                        D.jsonComment = str3;
                        feedCommentTask.req = D;
                        com.tencent.mobileqq.guild.feed.report.c.f223280a.p(feedCommentTask.perfStageReportTask, "stage_send_comment_start");
                        c17 = l.c();
                        if (c17 != null) {
                            c17.doComment(D, new IGProDoCommentCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.d
                                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoCommentCallback
                                public final void onResult(int i17, String str5, boolean z19, GProStDoCommentRsp gProStDoCommentRsp) {
                                    FeedCommentTask.I(FeedCommentTask.this, D, i17, str5, z19, gProStDoCommentRsp);
                                }
                            });
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z18 = feedCommentTask$sendCommentInner$1.Z$0;
                    gProStDoCommentReq = (GProStDoCommentReq) feedCommentTask$sendCommentInner$1.L$3;
                    GuildFeedRichContentResultBean guildFeedRichContentResultBean = (GuildFeedRichContentResultBean) feedCommentTask$sendCommentInner$1.L$2;
                    CommentFeedRequestArgs commentFeedRequestArgs3 = (CommentFeedRequestArgs) feedCommentTask$sendCommentInner$1.L$1;
                    FeedCommentTask feedCommentTask2 = (FeedCommentTask) feedCommentTask$sendCommentInner$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    c16 = guildFeedRichContentResultBean;
                    commentFeedRequestArgs2 = commentFeedRequestArgs3;
                    feedCommentTask = feedCommentTask2;
                    obj = obj2;
                }
                cVar = (com.tencent.qqnt.msg.api.c) obj;
                com.tencent.mobileqq.guild.feed.report.c.f223280a.b(feedCommentTask.perfStageReportTask, "stage_upload_media_end", cVar.c(), cVar.b());
                if (cVar.d()) {
                    QLog.e("FeedCommentTask", 1, "imageUploadResult code=" + cVar.c() + ", msg=" + cVar.b());
                    feedCommentTask.r(STATE.MEDIA_UPLOAD_FAILED);
                    RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp> E3 = feedCommentTask.E();
                    if (E3 != null) {
                        E3.e(feedCommentTask, gProStDoCommentReq);
                    }
                    return Unit.INSTANCE;
                }
                z17 = true;
                CommentDataUtil.g(c16, (Collection) cVar.a(), z18);
                gProStDoCommentReq.comment.richContents = new FeedRichTextConvertTool().c(c16);
                D = gProStDoCommentReq;
                feedCommentTask.r(STATE.COMMENT_SENDING);
                Result.Companion companion3 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(new Gson().toJson(c16));
                if (Result.m479exceptionOrNullimpl(m476constructorimpl) != null) {
                    E.a("FeedCommentTask", "sendRequest| toJson fail, feedId: " + commentFeedRequestArgs2.getFeedId());
                }
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                }
                str2 = (String) m476constructorimpl;
                if (str2 != null) {
                }
                D.jsonComment = str3;
                feedCommentTask.req = D;
                com.tencent.mobileqq.guild.feed.report.c.f223280a.p(feedCommentTask.perfStageReportTask, "stage_send_comment_start");
                c17 = l.c();
                if (c17 != null) {
                }
                return Unit.INSTANCE;
            }
        }
        feedCommentTask$sendCommentInner$1 = new FeedCommentTask$sendCommentInner$1(this, continuation);
        Object obj22 = feedCommentTask$sendCommentInner$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = feedCommentTask$sendCommentInner$1.label;
        String str32 = "";
        if (i3 != 0) {
        }
        cVar = (com.tencent.qqnt.msg.api.c) obj;
        com.tencent.mobileqq.guild.feed.report.c.f223280a.b(feedCommentTask.perfStageReportTask, "stage_upload_media_end", cVar.c(), cVar.b());
        if (cVar.d()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(FeedCommentTask this$0, GProStDoCommentReq request, int i3, String errMsg, boolean z16, GProStDoCommentRsp rsp) {
        STATE state;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        QLog.i("FeedCommentTask", 1, "handleCommentRsp result = " + i3 + " errorMsg = " + errMsg + " callback=" + this$0.E());
        com.tencent.mobileqq.guild.feed.report.c.f223280a.o(this$0.perfStageReportTask, "stage_finish", (long) i3, errMsg, rsp);
        if (i3 == 0) {
            this$0.b();
            state = STATE.SUCCESS;
        } else {
            state = STATE.COMMENT_SEND_FAILED;
        }
        this$0.r(state);
        RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp> E = this$0.E();
        if (E != null) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            E.b(this$0, i3, errMsg, request, rsp);
        }
    }

    @Nullable
    /* renamed from: F, reason: from getter */
    public final IPerformanceReportTask getPerfStageReportTask() {
        return this.perfStageReportTask;
    }

    @NotNull
    public final CommentFeedRequestArgs G() {
        CommentFeedRequestArgs commentFeedRequestArgs = this.requestArgs;
        if (commentFeedRequestArgs != null) {
            return commentFeedRequestArgs;
        }
        Intrinsics.throwUninitializedPropertyAccessException("requestArgs");
        return null;
    }

    public final void J(@Nullable WeakReference<RequestSenderCallback<GProStDoCommentReq, GProStDoCommentRsp>> weakReference) {
        this.callbackWf = weakReference;
    }

    public final void K(@Nullable IPerformanceReportTask iPerformanceReportTask) {
        this.perfStageReportTask = iPerformanceReportTask;
    }

    public final void L(@NotNull CommentFeedRequestArgs commentFeedRequestArgs) {
        Intrinsics.checkNotNullParameter(commentFeedRequestArgs, "<set-?>");
        this.requestArgs = commentFeedRequestArgs;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.ICommentTask
    public void l() {
        BuildersKt__Builders_commonKt.launch$default(d(), null, null, new FeedCommentTask$resend$1(this, null), 3, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.ICommentTask
    public void m() {
        if (C()) {
            BuildersKt__Builders_commonKt.launch$default(d(), null, null, new FeedCommentTask$send$1(this, null), 3, null);
        }
    }
}
