package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.guild.data.o;
import com.tencent.mobileqq.guild.feed.api.h;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiImpl;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUploadStatus;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0002\u0013\rB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/f;", "Lcom/tencent/mobileqq/guild/feed/api/h;", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/f$b;", "wrapper", "Lcom/tencent/mobileqq/guild/data/o;", "info", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUploadStatus;", "endStatus", "", "i", "", "mediumId", "e", "b", "d", tl.h.F, "f", "g", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/ParentTaskContext;", "a", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/ParentTaskContext;", "parentTaskContext", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "reportTasks", "<init>", "(Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/ParentTaskContext;)V", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements com.tencent.mobileqq.guild.feed.api.h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ParentTaskContext parentTaskContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, b> reportTasks;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\f\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/f$b;", "", "", "e", "a", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "c", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "", "<set-?>", "b", "J", "d", "()J", "timeCost", "", "Z", "()Z", "f", "(Z)V", "hasReportEnd", "resumeTimestamp", "<init>", "(Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IPerformanceReportTask reportTask;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long timeCost;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean hasReportEnd;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long resumeTimestamp;

        public b(@NotNull IPerformanceReportTask reportTask) {
            Intrinsics.checkNotNullParameter(reportTask, "reportTask");
            this.reportTask = reportTask;
        }

        public final void a() {
            long j3 = this.resumeTimestamp;
            if (j3 > 0) {
                this.resumeTimestamp = 0L;
                this.timeCost += System.currentTimeMillis() - j3;
            }
        }

        /* renamed from: b, reason: from getter */
        public final boolean getHasReportEnd() {
            return this.hasReportEnd;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final IPerformanceReportTask getReportTask() {
            return this.reportTask;
        }

        /* renamed from: d, reason: from getter */
        public final long getTimeCost() {
            return this.timeCost;
        }

        public final void e() {
            this.resumeTimestamp = System.currentTimeMillis();
        }

        public final void f(boolean z16) {
            this.hasReportEnd = z16;
        }
    }

    public f(@NotNull ParentTaskContext parentTaskContext) {
        Intrinsics.checkNotNullParameter(parentTaskContext, "parentTaskContext");
        this.parentTaskContext = parentTaskContext;
        this.reportTasks = new ConcurrentHashMap<>();
    }

    private final void i(b wrapper, o info, GProUploadStatus endStatus) {
        if (wrapper.getHasReportEnd()) {
            return;
        }
        wrapper.a();
        IPerformanceReportTask duplicate = wrapper.getReportTask().duplicate("upload_version", "upload_duration", "file_type", "file_id", "publish_task_id", "media_length", "upload_media_length");
        IPerformanceReportTask extra = duplicate.setStageCode("stage_single_media_upload_end").setTimeCost(wrapper.getTimeCost()).setExtra("upload_duration", Long.valueOf(wrapper.getTimeCost())).setExtra("end_status", Integer.valueOf(endStatus.ordinal()));
        String apn = NetworkUtil.getApn(BaseApplication.getContext());
        if (apn == null) {
            apn = "";
        }
        extra.setParam("apn", apn);
        if (info != null) {
            duplicate.setExtra("media_length", Long.valueOf(info.getOriginSize())).setExtra("upload_media_length", Long.valueOf(info.getTotalUploadFileSize())).setExtra(VipFunCallConstants.KEY_SV_URL, info.getUrl()).setExtra("svr_file_id", info.f()).setResultCode(info.getErrCode()).setResultMsg(info.getErrMsg());
        }
        duplicate.report();
        wrapper.f(true);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h, com.tencent.mobileqq.guild.feed.api.f
    public void a(@NotNull o oVar) {
        h.a.g(this, oVar);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void b(@NotNull String mediumId, @NotNull o info) {
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        Intrinsics.checkNotNullParameter(info, "info");
        b bVar = this.reportTasks.get(mediumId);
        if (bVar == null) {
            QLog.e("FeedMediaUploadTaskMonitorReportListener", 1, "[onPause]: " + mediumId + " not found");
            return;
        }
        bVar.a();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void c(@NotNull String str, long j3, long j16, @NotNull o oVar) {
        h.a.c(this, str, j3, j16, oVar);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void d(@NotNull String mediumId, @NotNull o info) {
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        Intrinsics.checkNotNullParameter(info, "info");
        b bVar = this.reportTasks.get(mediumId);
        if (bVar == null) {
            QLog.e("FeedMediaUploadTaskMonitorReportListener", 1, "[onResume]: " + mediumId + " not found");
            return;
        }
        if (!bVar.getReportTask().getIsReported()) {
            IPerformanceReportTask reportTask = bVar.getReportTask();
            reportTask.setExtra("media_length", Long.valueOf(info.getOriginSize()));
            reportTask.setExtra("upload_media_length", Long.valueOf(info.getTotalUploadFileSize()));
            String apn = NetworkUtil.getApn(BaseApplication.getContext());
            if (apn == null) {
                apn = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(apn, "NetworkUtil.getApn(BaseA\u2026ation.getContext()) ?: \"\"");
            }
            reportTask.setParam("apn", apn);
            reportTask.report();
        }
        bVar.e();
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void e(@NotNull String mediumId, @NotNull o info) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        Intrinsics.checkNotNullParameter(info, "info");
        Pair[] pairArr = new Pair[6];
        int i3 = 0;
        pairArr[0] = TuplesKt.to("upload_version", Integer.valueOf(yl1.i.f450608a.m(GuildFeedMediaUploadServiceApiImpl.INSTANCE.b())));
        pairArr[1] = TuplesKt.to("file_id", mediumId);
        if (info.isVideoTask()) {
            i3 = 2;
        } else if (info.g()) {
            i3 = 1;
        }
        pairArr[2] = TuplesKt.to("file_type", Integer.valueOf(i3));
        pairArr[3] = TuplesKt.to("publish_task_id", this.parentTaskContext.getParentId());
        pairArr[4] = TuplesKt.to("media_length", Long.valueOf(info.getTotalFileSize()));
        pairArr[5] = TuplesKt.to("upload_media_length", Long.valueOf(info.getTotalUploadFileSize()));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        this.reportTasks.put(mediumId, new b(Reporters.f231995a.b().a("media_uploader").setStageCode("stage_single_media_upload_begin").setExtras(mapOf)));
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void f(@NotNull String mediumId, @NotNull o info) {
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        Intrinsics.checkNotNullParameter(info, "info");
        b bVar = this.reportTasks.get(mediumId);
        if (bVar == null) {
            QLog.e("FeedMediaUploadTaskMonitorReportListener", 1, "[onResume]: " + mediumId + " not found");
            return;
        }
        i(bVar, info, GProUploadStatus.KUPLOADSUCCESS);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void g(@NotNull String mediumId, @NotNull o info) {
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        Intrinsics.checkNotNullParameter(info, "info");
        b bVar = this.reportTasks.get(mediumId);
        if (bVar == null) {
            QLog.e("FeedMediaUploadTaskMonitorReportListener", 1, "[onResume]: " + mediumId + " not found");
            return;
        }
        i(bVar, info, GProUploadStatus.KUPLOADFAILED);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.h
    public void h(@NotNull String mediumId, @Nullable o info) {
        Intrinsics.checkNotNullParameter(mediumId, "mediumId");
        b bVar = this.reportTasks.get(mediumId);
        if (bVar == null) {
            QLog.e("FeedMediaUploadTaskMonitorReportListener", 1, "[onResume]: " + mediumId + " not found");
            return;
        }
        i(bVar, info, GProUploadStatus.KUPLOADCANCELED);
    }
}
