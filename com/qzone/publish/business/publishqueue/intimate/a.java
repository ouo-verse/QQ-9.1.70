package com.qzone.publish.business.publishqueue.intimate;

import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.groupalbum.GroupAlbumUploadAlbumTask;
import com.qzone.publish.business.task.intimate.QZoneIntimateUploadBaseTask;
import com.qzone.publish.business.task.intimate.QZoneUploadIntimateTask;
import com.qzone.publish.business.task.qzonealbumx.QZAlbumxUploadPicTask;
import com.qzone.publish.business.task.qzonealbumx.QZAlbumxUploadVideoTask;
import com.qzone.publish.business.task.qzonealbumx.QZPublishXUploadShuoShuoTask;
import com.qzone.reborn.groupalbum.task.GroupAlbumPicCommentTask;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0016\u0010\b\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\t\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\"\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u0011\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\"\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e\"\u0015\u0010\u0015\u001a\u00020\u0003*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/publish/business/task/IQueueTask;", "", "tag", "", "f", "", QzoneIPCModule.RESULT_CODE, tl.h.F, "g", "a", "", "Ljava/util/List;", "RESULT_CODE_CAN_RETRY", "e", "(Lcom/qzone/publish/business/task/IQueueTask;)Z", "isQZoneTask", "c", "isIntimate", "b", "isGroupAlbum", "d", "isQZonePublishX", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final List<Integer> f51161a;

    public static final boolean a(IQueueTask iQueueTask, String tag) {
        List split$default;
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (iQueueTask == null) {
            return false;
        }
        String errorCode = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_SAFETY_STRIKE_CODE, QzoneConfig.DefaultValue.DEFAULT_PUBLISH_QUEUE_SAFETY_STRIKE_CODE);
        RFWLog.i(tag, RFWLog.USR, "isBeSafetyStruck, errorCode:" + errorCode + ", taskId:" + iQueueTask.getTaskId() + ", resultCode:" + iQueueTask.getResultCode());
        if (errorCode == null || errorCode.length() == 0) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(errorCode, "errorCode");
        split$default = StringsKt__StringsKt.split$default((CharSequence) errorCode, new String[]{","}, false, 0, 6, (Object) null);
        return split$default.contains(String.valueOf(iQueueTask.getResultCode()));
    }

    public static final boolean b(IQueueTask iQueueTask) {
        Intrinsics.checkNotNullParameter(iQueueTask, "<this>");
        return (iQueueTask instanceof GroupAlbumUploadAlbumTask) || (iQueueTask instanceof GroupAlbumPicCommentTask);
    }

    public static final boolean c(IQueueTask iQueueTask) {
        Intrinsics.checkNotNullParameter(iQueueTask, "<this>");
        return (iQueueTask instanceof QZoneUploadIntimateTask) || (iQueueTask instanceof QZoneIntimateUploadBaseTask);
    }

    public static final boolean d(IQueueTask iQueueTask) {
        Intrinsics.checkNotNullParameter(iQueueTask, "<this>");
        return (iQueueTask instanceof QZAlbumxUploadPicTask) || (iQueueTask instanceof QZAlbumxUploadVideoTask) || (iQueueTask instanceof QZPublishXUploadShuoShuoTask);
    }

    public static final boolean e(IQueueTask iQueueTask) {
        Intrinsics.checkNotNullParameter(iQueueTask, "<this>");
        if (Intrinsics.areEqual("0", iQueueTask.getCaseId())) {
            return true;
        }
        String caseId = iQueueTask.getCaseId();
        return caseId == null || caseId.length() == 0;
    }

    public static final boolean f(IQueueTask iQueueTask, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (iQueueTask == null) {
            return false;
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_RECONNECTION_TIMES, 10);
        RFWLog.i(tag, RFWLog.USR, "needRetry, taskId:" + iQueueTask.getTaskId() + ", state:" + iQueueTask.getState() + ", resultCode:" + iQueueTask.getResultCode() + ", retryNum:" + iQueueTask.getRetryNum() + ", maxRetryCount:" + config);
        return (iQueueTask.getState() == 2 || iQueueTask.getState() == 6) && h(iQueueTask.getResultCode()) && iQueueTask.getRetryNum() < config;
    }

    public static final boolean g(IQueueTask iQueueTask, String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (iQueueTask == null) {
            return false;
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_RECONNECTION_TIMES, Integer.MAX_VALUE);
        long config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_RECONNECTION_DAYS, 7) * 86400;
        RFWLog.i(tag, RFWLog.USR, "needToReconnection, taskId:" + iQueueTask.getTaskId() + ", retryNum:" + iQueueTask.getRetryNum() + ", timeStamp:" + iQueueTask.getTimeStamp());
        if (iQueueTask.getRetryNum() < config && System.currentTimeMillis() - iQueueTask.getTimeStamp() < config2) {
            RFWLog.i(tag, RFWLog.USR, "needToReconnection, return true ");
            return true;
        }
        RFWLog.i(tag, RFWLog.USR, "needToReconnection, return false ");
        return false;
    }

    private static final boolean h(int i3) {
        return f51161a.contains(Integer.valueOf(i3));
    }

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{0, -3000, -5000, 35000, 301002, 301013, 1000004});
        f51161a = listOf;
    }
}
