package com.tencent.gdtad.downloader;

import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/gdtad/downloader/u;", "", "", "eventId", "Lcom/tencent/open/downloadnew/DownloadInfo;", "downloadInfo", "", "a", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f109203a = new u();

    u() {
    }

    public final void a(int eventId, @NotNull DownloadInfo downloadInfo) {
        Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
        QLog.d("AdDownloaderReportHelper", 2, "report eventId is " + eventId + "," + downloadInfo.f341206v0);
        v.f109204a.b(String.valueOf(eventId), downloadInfo);
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        reportBiz.wv_progress = 2;
        reportBiz.download_scene = downloadInfo.f341206v0;
        if (eventId == 4001009) {
            reportBiz.cost_time = (int) (NetConnInfoCenter.getServerTimeMillis() - downloadInfo.D);
        }
        reportBiz.aid = downloadInfo.f341194k0;
        reportBiz.pid = downloadInfo.f341195l0;
        reportBiz.traceid = downloadInfo.f341193j0;
        AdReporterForLinkEvent.getInstance().reportAsync(QBaseActivity.sTopActivity, eventId, null, reportBiz, null);
        com.tencent.mobileqq.ad.schedule.d.f186939a.n(eventId, downloadInfo);
    }
}
