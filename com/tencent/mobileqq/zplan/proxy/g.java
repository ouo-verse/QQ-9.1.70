package com.tencent.mobileqq.zplan.proxy;

import android.os.SystemClock;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil;
import com.tencent.mobileqq.zplan.utils.aj;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJJ\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/g;", "Llx4/c;", "", "url", "filePath", "", "header", "", "priority", "", "timeout", "Lnx4/a;", "listener", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g implements lx4.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final String f334992b = "QQZPlanDownloaderProxy";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/g$a;", "", "", "TAG", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.proxy.g$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return g.f334992b;
        }

        Companion() {
        }
    }

    @Override // lx4.c
    public boolean a(String url, String filePath, Map<String, String> header, boolean priority, int timeout, nx4.a listener) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (ac3.b.INSTANCE.f()) {
            ZPlanFileDownloadUtil zPlanFileDownloadUtil = ZPlanFileDownloadUtil.f328039a;
            if (url == null) {
                url = "";
            }
            return zPlanFileDownloadUtil.i(url, filePath, "", header, Boolean.valueOf(priority), listener);
        }
        return aj.j().i(url, filePath, header, priority, Downloader.DownloadMode.OkHttpMode, new b(listener, filePath, url));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/zplan/proxy/g$b", "Lcom/tencent/component/network/downloader/Downloader$DownloadListener;", "", "url", "", "onDownloadCanceled", "Lcom/tencent/component/network/downloader/DownloadResult;", "downloadResult", "onDownloadFailed", ReportConstant.COSTREPORT_PREFIX, "onDownloadSucceed", "", "totalSize", "", "progress", "onDownloadProgress", "a", "J", "beginEnqueue", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements Downloader.DownloadListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long beginEnqueue = SystemClock.uptimeMillis();

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ nx4.a f334994b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f334995c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f334996d;

        b(nx4.a aVar, String str, String str2) {
            this.f334994b = aVar;
            this.f334995c = str;
            this.f334996d = str2;
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            QLog.i(g.INSTANCE.a(), 1, "download cancel, url=" + url);
            nx4.a aVar = this.f334994b;
            if (aVar != null) {
                aVar.onDownloadFailed(-1, "abort");
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String url, DownloadResult downloadResult) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(downloadResult, "downloadResult");
            QLog.i(g.INSTANCE.a(), 1, "download failed, code=" + downloadResult.getStatus().httpStatus + ", msg=" + downloadResult.getStatus().getErrorMessage() + ", url=" + url);
            nx4.a aVar = this.f334994b;
            if (aVar != null) {
                aVar.onDownloadFailed(downloadResult.getStatus().httpStatus, downloadResult.getStatus().getErrorMessage());
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String url, long totalSize, float progress) {
            Intrinsics.checkNotNullParameter(url, "url");
            nx4.a aVar = this.f334994b;
            if (aVar != null) {
                aVar.onDownloadProgress(progress, ((float) totalSize) * progress, totalSize);
            }
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String s16, DownloadResult downloadResult) {
            Intrinsics.checkNotNullParameter(s16, "s");
            Intrinsics.checkNotNullParameter(downloadResult, "downloadResult");
            nx4.a aVar = this.f334994b;
            if (aVar != null) {
                aVar.a(downloadResult.getStatus().httpStatus, this.f334995c, aj.h(downloadResult));
            }
            QLog.e(g.INSTANCE.a(), 1, "download success [timecost=" + (SystemClock.uptimeMillis() - this.beginEnqueue) + "][receiveData=" + downloadResult.getReport().t_recvdata + "][connect=" + downloadResult.getReport().t_conn + "][duration=" + downloadResult.getProcess().duration + "][totalDuration=" + downloadResult.getProcess().totalDuration + "][wait=" + downloadResult.getReport().t_wait + "][url=" + this.f334996d + "]");
        }
    }
}
