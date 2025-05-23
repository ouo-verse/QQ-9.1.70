package com.tencent.mobileqq.winkpublish.outbox.slot;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkpublish.model.params.FeedParams;
import com.tencent.mobileqq.winkpublish.model.params.NetVideoParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.outbox.task.BaseTask;
import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.outbox.task.UploadMediaInfo;
import com.tencent.mobileqq.winkreport.utils.WinkReportUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadResult;
import com.tencent.upload.uinterface.data.VideoUploadResult;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/BaseQueueSlot;", "Lva3/a;", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/a;", "Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "taskContext", "", "f", "Lcom/tencent/mobileqq/winkpublish/outbox/task/a;", "mediaInfo", "Lcom/tencent/mobileqq/winkpublish/outbox/slot/VideoSummary;", "g", "d", "Lcom/tencent/mobileqq/winkpublish/outbox/task/BaseTask;", "task", "", "e", "<init>", "()V", "a", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class BaseQueueSlot extends va3.a implements a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy<Boolean> f327260f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/slot/BaseQueueSlot$a;", "", "", "fallback$delegate", "Lkotlin/Lazy;", "a", "()Z", AdMetricTag.FALLBACK, "", "BEACON_REPORT_MAX_LENGTH", "I", "<init>", "()V", "qq_winkpublish_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.winkpublish.outbox.slot.BaseQueueSlot$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return ((Boolean) BaseQueueSlot.f327260f.getValue()).booleanValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Boolean> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.winkpublish.outbox.slot.BaseQueueSlot$Companion$fallback$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("queue_slot_channel_switch", false));
            }
        });
        f327260f = lazy;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String f(TaskContext taskContext) {
        String str;
        Object firstOrNull;
        HashMap<String, String> requestExtInfo;
        try {
            long currentTimeMillis = System.currentTimeMillis() - taskContext.getStartTimeMillis();
            int uploadTaskType = taskContext.getUploadTaskType();
            int uploadCoverType = taskContext.getUploadCoverType();
            int seqId = taskContext.getSeqId();
            boolean B = taskContext.B();
            boolean C = taskContext.C();
            String feedId = taskContext.getFeedId();
            FeedParams feedParams = taskContext.getPublishParams().getFeedParams();
            String str2 = (feedParams == null || (requestExtInfo = feedParams.getRequestExtInfo()) == null) ? null : requestExtInfo.get("up_source");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) taskContext.x());
            try {
                str = e.a(new TaskEndSummary(0, currentTimeMillis, uploadTaskType, seqId, B, C, feedId, g((UploadMediaInfo) firstOrNull), uploadCoverType, str2, 1, null));
            } catch (Exception e16) {
                e = e16;
                QLog.w(d(), 1, "[taskSummary] ", e);
                str = "";
                if (QLog.isColorLevel()) {
                }
                if (str.length() > 1000) {
                }
            }
        } catch (Exception e17) {
            e = e17;
        }
        if (QLog.isColorLevel()) {
            QLog.d(d(), 2, "[taskSummary] summaryString=" + str);
        }
        if (str.length() > 1000) {
            return str;
        }
        QLog.w(d(), 1, "[taskSummary] summaryString is too long");
        return "";
    }

    public String d() {
        return "WinkPublish-upload2-BaseQueueSlot";
    }

    public final void e(BaseTask task) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(task, "task");
        TaskContext taskContext = task.getTaskContext();
        if (QLog.isColorLevel()) {
            QLog.d(d(), 2, "id:" + task.u() + " errCode=" + taskContext.getErrCode() + ", errMsg=" + taskContext.getErrMsg() + ", cameraSessionId=" + taskContext.getDtCameraSessionId());
        }
        String r16 = taskContext.r();
        String errCode = taskContext.getErrCode();
        String errMsg = taskContext.getErrMsg();
        String valueOf = String.valueOf(taskContext.getSeqId());
        if (taskContext.B()) {
            str = "1";
        } else {
            str = "0";
        }
        String dtCameraSessionId = taskContext.getDtCameraSessionId();
        if (taskContext.C()) {
            str2 = "video";
        } else {
            str2 = "image";
        }
        String str4 = str2;
        if (taskContext.A()) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        String isInMultiWindowMode = WinkReportUtils.isInMultiWindowMode(null);
        String f16 = f(taskContext);
        Intrinsics.checkNotNullExpressionValue(isInMultiWindowMode, "isInMultiWindowMode(null)");
        com.tencent.mobileqq.winkpublish.outbox.d.e(taskContext, "E_PUBLISH_COMPLETE_TASK", r16, errCode, valueOf, str, dtCameraSessionId, str4, str3, isInMultiWindowMode, errMsg, f16, null, null, null, 14336, null);
    }

    private final VideoSummary g(UploadMediaInfo mediaInfo) {
        if ((mediaInfo != null ? mediaInfo.r() : null) == null) {
            if ((mediaInfo != null ? mediaInfo.m() : null) == null) {
                QLog.w("WinkPublish-upload2-VideoSummary", 1, "[videoSummary] invalid mediaInfo");
                return null;
            }
        }
        VideoParams r16 = mediaInfo.r();
        if (r16 != null) {
            String localPath = r16.getLocalPath();
            AbstractUploadResult uploadResponse = mediaInfo.getUploadResponse();
            VideoUploadResult videoUploadResult = uploadResponse instanceof VideoUploadResult ? (VideoUploadResult) uploadResponse : null;
            String str = videoUploadResult != null ? videoUploadResult.sVid : null;
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "(mediaInfo.uploadRespons\u2026UploadResult)?.sVid ?: \"\"");
            }
            return new VideoSummary(localPath, str, r16.getWidth(), r16.getHeight(), r16.getBitrate(), r16.getDuration(), r16.getRotation(), r16.getFileSize(), r16.getMimetype(), r16.isHDR(), r16.isHEVC());
        }
        NetVideoParams m3 = mediaInfo.m();
        if (m3 != null) {
            return new VideoSummary("[none]", m3.getVid(), m3.getWidth(), m3.getHeight(), m3.getBitrate(), m3.getDuration(), 0, m3.getFileSize(), "", false, false, 1536, null);
        }
        return null;
    }
}
