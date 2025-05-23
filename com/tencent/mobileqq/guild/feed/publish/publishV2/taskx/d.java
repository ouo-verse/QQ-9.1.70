package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.guild.data.o;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedMediaUploadServiceApiImpl;
import com.tencent.mobileqq.guild.feed.publish.GuildSingleMainTask;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.report.DummyPerformanceReportTask;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0004J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/d;", "", "Lcom/tencent/mobileqq/guild/feed/publish/GuildSingleMainTask;", "mainTask", "", "", "Lcom/tencent/mobileqq/guild/data/o;", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediumUploadTaskInfo;", "taskInfoMap", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "a", "stageBeginReportTask", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/h;", "uploadResult", "", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f223127a = new d();

    d() {
    }

    @NotNull
    public final IPerformanceReportTask a(@NotNull GuildSingleMainTask mainTask, @NotNull Map<String, ? extends o> taskInfoMap) {
        long originSize;
        Intrinsics.checkNotNullParameter(mainTask, "mainTask");
        Intrinsics.checkNotNullParameter(taskInfoMap, "taskInfoMap");
        Iterator<Map.Entry<String, ? extends o>> it = taskInfoMap.entrySet().iterator();
        long j3 = 0;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        long j16 = 0;
        while (it.hasNext()) {
            o value = it.next().getValue();
            if (value.g()) {
                i3++;
                if (value.e()) {
                    i16++;
                    originSize = value.getOriginSize();
                    j3 += originSize;
                    j16 += value.getOriginSize();
                } else {
                    j16 += value.getOriginSize();
                }
            } else {
                if (value.isVideoTask() && value.e()) {
                    i17++;
                    originSize = value.getOriginSize();
                    j3 += originSize;
                }
                j16 += value.getOriginSize();
            }
        }
        IPerformanceReportTask j17 = GuildTaskQueueManager.m().j(mainTask.getMMainTaskId());
        if (j17 == null) {
            return DummyPerformanceReportTask.INSTANCE;
        }
        IPerformanceReportTask extra = j17.duplicate(new String[0]).setStageCode("stage_media_group_upload_begin").setExtra("upload_version", Integer.valueOf(yl1.i.f450608a.m(GuildFeedMediaUploadServiceApiImpl.INSTANCE.b()))).setExtra("publish_task_id", mainTask.getMMainTaskId()).setExtra("image_count", Integer.valueOf(i3)).setExtra("video_count", Integer.valueOf(taskInfoMap.size() - i3)).setExtra("preload_image_count", Integer.valueOf(i16)).setExtra("preload_video_count", Integer.valueOf(i17)).setExtra("preload_media_length", Long.valueOf(j3)).setExtra("total_media_length", Long.valueOf(j16));
        String apn = NetworkUtil.getApn(BaseApplication.getContext());
        if (apn == null) {
            apn = "";
        }
        return extra.setParam("apn", apn).setParam("guild_id", mainTask.n().getGuildId()).report();
    }

    public final void b(@NotNull IPerformanceReportTask stageBeginReportTask, @NotNull h uploadResult) {
        boolean z16;
        Intrinsics.checkNotNullParameter(stageBeginReportTask, "stageBeginReportTask");
        Intrinsics.checkNotNullParameter(uploadResult, "uploadResult");
        IPerformanceReportTask stageCode = stageBeginReportTask.duplicate("guild_id", "upload_version", "publish_task_id", "video_count", "image_count").setStageCode("stage_media_group_upload_end");
        IPerformanceReportTask resultMsg = stageCode.setResultCode(uploadResult.getErrorCodeFromService()).setResultMsg(uploadResult.getErrMsg());
        String apn = NetworkUtil.getApn(BaseApplication.getContext());
        if (apn == null) {
            apn = "";
        }
        resultMsg.setParam("apn", apn);
        String firstFailFileId = uploadResult.getFirstFailFileId();
        if (firstFailFileId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            firstFailFileId = null;
        }
        if (firstFailFileId != null) {
            stageCode.setExtra("first_fail_file_id", firstFailFileId);
        }
        stageCode.report();
    }
}
