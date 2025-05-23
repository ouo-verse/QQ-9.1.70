package com.tencent.mobileqq.guild.feed.detail.task;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.data.o;
import com.tencent.mobileqq.guild.feed.detail.CommentDataUtil;
import com.tencent.mobileqq.guild.feed.detail.event.CommentStatusEvent;
import com.tencent.mobileqq.guild.feed.detail.event.FindUnfinishedCommentEvent;
import com.tencent.mobileqq.guild.feed.detail.event.GuildDoCommentEvent;
import com.tencent.mobileqq.guild.feed.detail.task.h;
import com.tencent.mobileqq.guild.feed.detail.task.k;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.FeedMediaUploadTask;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.ParentTaskContext;
import com.tencent.mobileqq.guild.feed.publish.u;
import com.tencent.mobileqq.guild.feed.publish.v;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedRichContentResultBean;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyRsp;
import ij1.GuildMediaUploadTaskInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u00172\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010)\u001a\u00020\b\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020!R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010(R\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/task/GuildCommentTask;", "Lcom/tencent/mobileqq/guild/feed/publish/v;", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;", "richText", "", BdhLogUtil.LogTag.Tag_Conn, "", "retCode", "", "errMsg", ReportConstant.COSTREPORT_PREFIX, "B", "u", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/h;", "uploadResult", "v", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "p", "Lcom/tencent/mobileqq/guild/feed/detail/task/CommentResult;", "o", "", "k", HippyTKDListViewAdapter.X, "l", "", "state", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, DomainData.DOMAIN_NAME, "b", "t", "r", "Lcom/tencent/mobileqq/guild/feed/detail/event/FindUnfinishedCommentEvent;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;", "a", "Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;", "mEvent", "Ljava/lang/String;", "mMainTaskId", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "mMainState", "Lcom/tencent/mobileqq/guild/feed/detail/task/k;", "d", "Lcom/tencent/mobileqq/guild/feed/detail/task/k;", "mDoReplyTask", "Lin1/c;", "e", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lin1/c;", "mUploadMediaTask", "Lkotlinx/coroutines/CoroutineScope;", "f", "Lkotlinx/coroutines/CoroutineScope;", "mScope", "Lcom/tencent/mobileqq/guild/feed/detail/task/h;", "g", "Lcom/tencent/mobileqq/guild/feed/detail/task/h;", "mDoCommentTask", tl.h.F, "mContent", "i", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedRichContentResultBean;", "mRichText", "j", "Lcom/tencent/mobileqq/guild/feed/detail/task/CommentResult;", "mResult", "<init>", "(Lcom/tencent/mobileqq/guild/feed/detail/event/GuildFeedCommentEvent;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildCommentTask implements v {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildDoCommentEvent mEvent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mMainTaskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger mMainState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k mDoReplyTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mUploadMediaTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope mScope;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h mDoCommentTask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mContent;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildFeedRichContentResultBean mRichText;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CommentResult mResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J$\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/detail/task/GuildCommentTask$b", "Lcom/tencent/mobileqq/guild/feed/detail/task/h$b;", "", "retCode", "", "errMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentRsp;", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoCommentReq;", Const.BUNDLE_KEY_REQUEST, "", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements h.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildFeedRichContentResultBean f218521b;

        b(GuildFeedRichContentResultBean guildFeedRichContentResultBean) {
            this.f218521b = guildFeedRichContentResultBean;
        }

        @Override // com.tencent.mobileqq.guild.feed.detail.task.h.b
        public void a(long retCode, @Nullable String errMsg, @Nullable GProStDoCommentReq request) {
            hj1.b.a("GuildCommentTask", "triggerCommentRequest fail");
            GuildCommentTask guildCommentTask = GuildCommentTask.this;
            GuildFeedRichContentResultBean guildFeedRichContentResultBean = this.f218521b;
            if (errMsg == null) {
                errMsg = "";
            }
            guildCommentTask.s(retCode, guildFeedRichContentResultBean, errMsg);
        }

        @Override // com.tencent.mobileqq.guild.feed.detail.task.h.b
        public void b(long retCode, @Nullable String errMsg, @NotNull GProStDoCommentRsp rsp, @NotNull GProStDoCommentReq request) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            Intrinsics.checkNotNullParameter(request, "request");
            GuildCommentTask.this.u();
            hj1.b.a("GuildCommentTask", "triggerCommentRequest success");
            bl c16 = bl.c();
            CommentResult commentResult = GuildCommentTask.this.mResult;
            GuildFeedRichContentResultBean guildFeedRichContentResultBean = this.f218521b;
            commentResult.setStatus(2);
            commentResult.setResult(retCode);
            String str = rsp.comment.idd;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.comment.idd");
            commentResult.setCommentID(str);
            commentResult.setJsonContent(guildFeedRichContentResultBean);
            commentResult.setSequence(rsp.comment.sequence);
            commentResult.setCreateTime(rsp.comment.createTime);
            c16.b(new CommentStatusEvent(CommentDataUtil.h(commentResult), GuildCommentTask.this.mEvent.getFeedId(), 2, GuildCommentTask.this.mEvent.getFromList(), 0L, null, 48, null), true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/detail/task/GuildCommentTask$c", "Lcom/tencent/mobileqq/guild/feed/detail/task/k$b;", "", "retCode", "", "errMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyRsp;", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStDoReplyReq;", Const.BUNDLE_KEY_REQUEST, "", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements k.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildFeedRichContentResultBean f218523b;

        c(GuildFeedRichContentResultBean guildFeedRichContentResultBean) {
            this.f218523b = guildFeedRichContentResultBean;
        }

        @Override // com.tencent.mobileqq.guild.feed.detail.task.k.b
        public void a(long retCode, @Nullable String errMsg, @Nullable GProStDoReplyReq request) {
            hj1.b.a("GuildCommentTask", "triggerReplyRequest fail");
            GuildCommentTask guildCommentTask = GuildCommentTask.this;
            GuildFeedRichContentResultBean guildFeedRichContentResultBean = this.f218523b;
            if (errMsg == null) {
                errMsg = "";
            }
            guildCommentTask.s(retCode, guildFeedRichContentResultBean, errMsg);
        }

        @Override // com.tencent.mobileqq.guild.feed.detail.task.k.b
        public void b(long retCode, @Nullable String errMsg, @NotNull GProStDoReplyRsp rsp, @Nullable GProStDoReplyReq request) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            GuildCommentTask.this.u();
            hj1.b.a("GuildCommentTask", "triggerReplyRequest success");
            bl c16 = bl.c();
            CommentResult commentResult = GuildCommentTask.this.mResult;
            GuildCommentTask guildCommentTask = GuildCommentTask.this;
            GuildFeedRichContentResultBean guildFeedRichContentResultBean = this.f218523b;
            commentResult.setStatus(2);
            commentResult.setResult(retCode);
            commentResult.setCommentID(guildCommentTask.mEvent.getCommentID());
            commentResult.setJsonContent(guildFeedRichContentResultBean);
            commentResult.setReplyTargetID(guildCommentTask.mEvent.getReplyTargetID());
            String str = rsp.reply.idd;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.reply.idd");
            commentResult.setReplyID(str);
            commentResult.setCreateTime(rsp.reply.createTime);
            c16.b(new CommentStatusEvent(CommentDataUtil.h(commentResult), GuildCommentTask.this.mEvent.getFeedId(), 2, GuildCommentTask.this.mEvent.getFromList(), 0L, null, 48, null), true);
        }
    }

    public GuildCommentTask(@NotNull GuildDoCommentEvent mEvent, @NotNull String mMainTaskId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mEvent, "mEvent");
        Intrinsics.checkNotNullParameter(mMainTaskId, "mMainTaskId");
        this.mEvent = mEvent;
        this.mMainTaskId = mMainTaskId;
        this.mMainState = new AtomicInteger(0);
        this.mDoReplyTask = new k(mEvent, this);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<FeedMediaUploadTask>() { // from class: com.tencent.mobileqq.guild.feed.detail.task.GuildCommentTask$mUploadMediaTask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FeedMediaUploadTask invoke() {
                String str;
                str = GuildCommentTask.this.mMainTaskId;
                return new FeedMediaUploadTask("GuildCommentTask.UploadTask", new ParentTaskContext(str, null, 2, null), false);
            }
        });
        this.mUploadMediaTask = lazy;
        this.mScope = CoroutineScopeKt.CoroutineScope(ae.a().b());
        this.mDoCommentTask = new h(mEvent, this);
        this.mContent = "";
        GuildFeedRichContentResultBean c16 = CommentDataUtil.c(mEvent.getMContent(), mEvent.getLocalMediaInfos(), mEvent.getMOriginalPic());
        this.mRichText = c16;
        this.mResult = CommentDataUtil.d(mEvent, c16);
    }

    private final synchronized void B(GuildFeedRichContentResultBean richText) {
        QLog.i("GuildCommentTask", 1, "[triggerRealCommentRequest]");
        this.mDoCommentTask.c(richText, new b(richText));
    }

    private final void C(GuildFeedRichContentResultBean richText) {
        QLog.i("GuildCommentTask", 1, "[triggerRealReplyRequest]");
        this.mDoReplyTask.c(richText, new c(richText));
        com.tencent.mobileqq.guild.feed.performance.report.c.b("feed_detail_reply_comment", null, 0L, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final in1.c m() {
        return (in1.c) this.mUploadMediaTask.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(long retCode, GuildFeedRichContentResultBean richText, String errMsg) {
        A(6);
        bl.c().b(new CommentStatusEvent(CommentDataUtil.h(CommentDataUtil.a(this.mResult, retCode, richText)), this.mEvent.getFeedId(), 3, this.mEvent.getFromList(), retCode, errMsg), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        A(4);
        e.h().s(this.mMainTaskId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.h uploadResult) {
        GuildMediaUploadTaskInfo guildMediaUploadTaskInfo;
        Collection<o> values = uploadResult.f().values();
        ArrayList arrayList = new ArrayList();
        for (o oVar : values) {
            if (oVar instanceof GuildMediaUploadTaskInfo) {
                guildMediaUploadTaskInfo = (GuildMediaUploadTaskInfo) oVar;
            } else {
                guildMediaUploadTaskInfo = null;
            }
            if (guildMediaUploadTaskInfo != null) {
                arrayList.add(guildMediaUploadTaskInfo);
            }
        }
        if (uploadResult.g() && !arrayList.isEmpty()) {
            QLog.i("GuildCommentTask", 1, "[onUploadResult] image upload success, taskInfoMap.size=" + uploadResult.f().size());
            A(2);
            CommentDataUtil.g(this.mRichText, arrayList, this.mEvent.getMOriginalPic());
            y();
            return;
        }
        QLog.e("GuildCommentTask", 1, "[onUploadResult] image upload failed, errorMsg=" + uploadResult.getErrMsg() + ", result=" + uploadResult.getResult() + ", taskInfoMap.size=" + uploadResult.f().size());
        w();
    }

    private final void w() {
        A(5);
        bl.c().b(new CommentStatusEvent(CommentDataUtil.h(CommentDataUtil.a(this.mResult, -1L, this.mRichText)), this.mEvent.getFeedId(), 3, this.mEvent.getFromList(), 0L, null, 48, null), true);
    }

    private final void y() {
        if (this.mEvent.getIsComment()) {
            B(this.mRichText);
        } else {
            C(this.mRichText);
        }
    }

    private final void z() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.mScope, null, null, new GuildCommentTask$sendRequestWithUpload$1(this, null), 3, null);
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.detail.task.GuildCommentTask$sendRequestWithUpload$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                in1.c m3;
                in1.c m16;
                if (th5 == null) {
                    m3 = GuildCommentTask.this.m();
                    m3.release();
                    return;
                }
                QLog.e("GuildCommentTask", 1, "[invoke]  | upload media task cancel");
                m16 = GuildCommentTask.this.m();
                CancellationException cancellationException = th5 instanceof CancellationException ? (CancellationException) th5 : null;
                if (cancellationException == null) {
                    cancellationException = new CancellationException(th5.toString());
                    cancellationException.initCause(th5);
                }
                m16.cancel(cancellationException);
            }
        });
    }

    public void A(int state) {
        this.mMainState.set(state);
        com.tencent.mobileqq.guild.feed.performance.report.c.f222706d.f(state);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.v
    @NotNull
    /* renamed from: b, reason: from getter */
    public String getMMainTaskId() {
        return this.mMainTaskId;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.v
    public /* synthetic */ boolean c() {
        return u.a(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.v
    public /* synthetic */ boolean d() {
        return u.b(this);
    }

    public final boolean k() {
        if ((new Date().getTime() / 1000) - this.mEvent.getCreateTime() > JoinTimeType.SIX_HOUR) {
            return true;
        }
        return false;
    }

    public final void l() {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        QLog.i("GuildCommentTask", 1, "[invoke]  | content = " + this.mEvent.getMContent());
        GuildFeedRichContentResultBean c16 = CommentDataUtil.c(this.mEvent.getMContent(), this.mEvent.getLocalMediaInfos(), this.mEvent.getMOriginalPic());
        this.mRichText = c16;
        Object obj = c16.ext;
        if (obj != null && (obj instanceof JSONObject)) {
            String guildId = this.mEvent.getGuildId();
            Object obj2 = this.mRichText.ext;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
            if (ax.g(guildId, (JSONObject) obj2)) {
                return;
            } else {
                this.mRichText.ext = null;
            }
        }
        this.mResult = CommentDataUtil.d(this.mEvent, this.mRichText);
        bl.c().b(new CommentStatusEvent(CommentDataUtil.h(this.mResult), this.mEvent.getFeedId(), 1, this.mEvent.getFromList(), 0L, null, 48, null), true);
        this.mContent = this.mEvent.getMContent();
        if (this.mEvent.getLocalMediaInfos().size() == 0) {
            A(3);
            y();
            return;
        }
        A(1);
        ArrayList<LocalMediaInfo> localMediaInfos = this.mEvent.getLocalMediaInfos();
        Iterator<T> it = localMediaInfos.iterator();
        while (it.hasNext()) {
            ((LocalMediaInfo) it.next()).isRwa = this.mEvent.getMOriginalPic();
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(localMediaInfos, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj3 : localMediaInfos) {
            linkedHashMap.put(com.tencent.mobileqq.guild.feed.nativepublish.publish.a.f222223a.b(), obj3);
        }
        m().h("Comment", linkedHashMap);
        z();
    }

    public int n() {
        return this.mMainState.get();
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final CommentResult getMResult() {
        return this.mResult;
    }

    @NotNull
    public final String p() {
        return this.mResult.getUuid();
    }

    public final boolean q(@NotNull FindUnfinishedCommentEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getGuildID(), this.mEvent.getGuildId()) && Intrinsics.areEqual(event.getChannelID(), this.mEvent.getChannelId()) && Intrinsics.areEqual(event.getFeedID(), this.mEvent.getFeedId())) {
            return true;
        }
        return false;
    }

    public final boolean r() {
        hj1.b.b("GuildCommentTask", "notFinished | state: " + n());
        if (n() != 4) {
            return true;
        }
        return false;
    }

    public final void t() {
        CoroutineScopeKt.cancel$default(this.mScope, "onFinish", null, 2, null);
        this.mDoCommentTask.f();
    }

    public final void x() {
        hj1.b.a("GuildCommentTask", "reExecute | state: " + this.mMainState.get());
        bl c16 = bl.c();
        CommentResult commentResult = this.mResult;
        commentResult.setStatus(1);
        c16.b(new CommentStatusEvent(CommentDataUtil.h(commentResult), this.mEvent.getFeedId(), 1, this.mEvent.getFromList(), 0L, null, 48, null), true);
        if (this.mMainState.get() == 5) {
            A(1);
            z();
        } else {
            A(3);
            y();
        }
        com.tencent.mobileqq.guild.feed.performance.report.c.b("feed_detail_reSend_comment", null, 0L, null, 14, null);
    }
}
