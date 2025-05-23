package com.tencent.mobileqq.winkpublish.outbox;

import com.tencent.mobileqq.winkpublish.outbox.task.TaskContext;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0092\u0001\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0001\u001a\u0012\u0010\u0012\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u0090\u0001\u0010\u0013\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0001\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/outbox/task/TaskContext;", "", "eventId", "traceId", "retCode", "ext1", "ext2", "ext3", "ext4", "ext5", "ext6", "desc", "attachInfo", "index", "key", QCircleWeakNetReporter.KEY_COST, "", "d", "c", "a", "qq_winkpublish_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d {
    public static final void a(TaskContext taskContext, String eventId, String traceId, String retCode, String ext1, String ext2, String ext3, String ext4, String ext5, String ext6, String desc, String attachInfo, String index, String key, String cost) {
        Intrinsics.checkNotNullParameter(taskContext, "<this>");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(retCode, "retCode");
        Intrinsics.checkNotNullParameter(ext1, "ext1");
        Intrinsics.checkNotNullParameter(ext2, "ext2");
        Intrinsics.checkNotNullParameter(ext3, "ext3");
        Intrinsics.checkNotNullParameter(ext4, "ext4");
        Intrinsics.checkNotNullParameter(ext5, "ext5");
        Intrinsics.checkNotNullParameter(ext6, "ext6");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cost, "cost");
        taskContext.d().getReporter().b(taskContext.d(), new WinkPublishQualityReportData(eventId, traceId, retCode, ext1, ext2, ext3, ext4, ext5, ext6, desc, attachInfo, index, key, cost, 0L, 16384, null));
    }

    public static final void c(TaskContext taskContext, String key) {
        Intrinsics.checkNotNullParameter(taskContext, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        taskContext.d().getReporter().startKey(key);
    }

    public static final void d(TaskContext taskContext, String eventId, String traceId, String retCode, String ext1, String ext2, String ext3, String ext4, String ext5, String ext6, String desc, String attachInfo, String index, String key, String cost) {
        Intrinsics.checkNotNullParameter(taskContext, "<this>");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(retCode, "retCode");
        Intrinsics.checkNotNullParameter(ext1, "ext1");
        Intrinsics.checkNotNullParameter(ext2, "ext2");
        Intrinsics.checkNotNullParameter(ext3, "ext3");
        Intrinsics.checkNotNullParameter(ext4, "ext4");
        Intrinsics.checkNotNullParameter(ext5, "ext5");
        Intrinsics.checkNotNullParameter(ext6, "ext6");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cost, "cost");
        taskContext.d().getReporter().a(taskContext.d(), new WinkPublishQualityReportData(eventId, traceId, retCode, ext1, ext2, ext3, ext4, ext5, ext6, desc, attachInfo, index, key, cost, 0L, 16384, null));
    }

    public static /* synthetic */ void e(TaskContext taskContext, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i3, Object obj) {
        d(taskContext, str, str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? "" : str9, (i3 & 512) != 0 ? "" : str10, (i3 & 1024) != 0 ? "" : str11, (i3 & 2048) != 0 ? "" : str12, (i3 & 4096) != 0 ? "" : str13, (i3 & 8192) != 0 ? "" : str14);
    }
}
