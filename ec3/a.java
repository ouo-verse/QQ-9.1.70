package ec3;

import ac3.ZPlanDownloadDnsConfig;
import ac3.ZPlanDownloadMultiThreadConfig;
import ac3.b;
import com.tencent.halley.downloader.DownloaderTask;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.z1.download.db.ZootopiaDownloadEntity;
import com.tencent.mobileqq.zootopia.download.HalleyDownloader;
import com.tencent.mobileqq.zootopia.utils.m;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00192\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b1\u00102J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J<\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0002JH\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00102\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0010H\u0002JH\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00102\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0014J.\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J6\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007J\u0016\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0015J\u0016\u0010\u001f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007J&\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007J&\u0010&\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015J\u000e\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020'R\u0016\u0010\u001d\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010+R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010-R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010-R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010-R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010-R\u001a\u00100\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000b\u0010-\u001a\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lec3/a;", "Lec3/b;", "", "downloadUrl", "id", "taskType", "uniqueTraceKey", "", "isUpdate", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, "", "i", "Lcom/tencent/halley/downloader/DownloaderTask;", "downloaderTask", "logString", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "g", "paramMap", "f", "e", "", "byte", h.F, "d", "j", "isResumeStart", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "receiveBytes", "totalByte", "o", "l", "isSuccess", "isSilentDownload", "k", "url", "threadSwitchCostTime", "queryDbCostTime", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/z1/download/db/ZootopiaDownloadEntity;", "modDownloadEntity", "p", "c", "J", "lastReceivedBytes", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tag", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile long totalByte;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile long lastReceivedBytes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile String id = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile String url = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private volatile String taskType = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile String uniqueTraceKey = "";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String tag = "Zootopia_DownloadTask_Report";

    private final HashMap<String, String> e(HashMap<String, String> paramMap) {
        b.Companion companion = ac3.b.INSTANCE;
        ZPlanDownloadMultiThreadConfig e16 = companion.e();
        boolean z16 = com.tencent.mobileqq.vip.d.d() == 1;
        paramMap.put("k_download_enable_multi_thread", String.valueOf(e16.getEnableMultiThread()));
        paramMap.put("k_download_enable_dual_download", String.valueOf(e16.getEnableDualDownload()));
        paramMap.put("k_download_is_king_card", String.valueOf(z16));
        ZPlanDownloadDnsConfig b16 = companion.b();
        paramMap.put("k_download_pre_dnsparse_type", b16.getDnsParseTypeConfigString());
        paramMap.put("k_download_enable_httpdns", String.valueOf(b16.getEnableHttpDns()));
        paramMap.put("k_download_is_multi_downloader", String.valueOf(HalleyDownloader.f327980a.i()));
        return paramMap;
    }

    private final HashMap<String, String> f(HashMap<String, String> paramMap) {
        paramMap.put("k_net_type", m.f329564a.b());
        return paramMap;
    }

    private final HashMap<String, String> g(DownloaderTask downloaderTask, boolean isUpdate, String logString) {
        HashMap<String, String> hashMapOf;
        int curAverageSpeed = downloaderTask.getCurAverageSpeed();
        long receivedLen = downloaderTask.getReceivedLen();
        long totalCostTime = downloaderTask.getTotalCostTime();
        long j3 = curAverageSpeed;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_download_task_url", this.url), TuplesKt.to("k_download_task_id", this.id), TuplesKt.to("k_download_task_type", this.taskType), TuplesKt.to("k_download_task_unique_key", this.uniqueTraceKey), TuplesKt.to("k_download_total_size", String.valueOf(h(this.totalByte))), TuplesKt.to("k_download_received_size", String.valueOf(h(receivedLen))), TuplesKt.to("k_download_averagespeed", String.valueOf(h(j3))), TuplesKt.to("k_cost_time", String.valueOf(totalCostTime / 1000)), TuplesKt.to("k_download_is_update", String.valueOf(isUpdate)));
        f(hashMapOf);
        e(hashMapOf);
        QLog.i("Zootopia_DownloadTask_Report", 1, logString + "  averageSpeed is " + curAverageSpeed + " Byte/s " + t74.a.a(j3) + "/s, receivedLength = " + receivedLen + ", costTime = " + totalCostTime + ", isUpdate = " + isUpdate);
        return hashMapOf;
    }

    private final void i(String downloadUrl, String id5, String taskType, String uniqueTraceKey, boolean isUpdate, String reportKey) {
        HashMap<String, String> hashMapOf;
        this.url = downloadUrl;
        this.id = id5;
        this.taskType = taskType;
        this.uniqueTraceKey = uniqueTraceKey;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_download_task_url", this.url), TuplesKt.to("k_download_task_id", id5), TuplesKt.to("k_download_is_update", String.valueOf(isUpdate)), TuplesKt.to("k_download_task_type", taskType), TuplesKt.to("k_download_task_unique_key", uniqueTraceKey));
        f(hashMapOf);
        e(hashMapOf);
        c(reportKey, 0, "", hashMapOf);
    }

    @Override // ec3.b
    /* renamed from: b, reason: from getter */
    public String getTag() {
        return this.tag;
    }

    @Override // ec3.b
    protected boolean d() {
        return true;
    }

    public final synchronized void j(String downloadUrl, String id5, String taskType, String uniqueTraceKey, boolean isUpdate) {
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(uniqueTraceKey, "uniqueTraceKey");
        i(downloadUrl, id5, taskType, uniqueTraceKey, isUpdate, "e_zplan_download_task_create");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052 A[Catch: all -> 0x006a, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:13:0x002a, B:15:0x0052, B:21:0x0016, B:24:0x000c), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void k(boolean isSuccess, DownloaderTask downloaderTask, boolean isUpdate, boolean isSilentDownload) {
        String failInfoMsg;
        String str;
        Intrinsics.checkNotNullParameter(downloaderTask, "downloaderTask");
        int ret = isSuccess ? 0 : downloaderTask.getRet();
        if (!isSuccess) {
            failInfoMsg = downloaderTask.getFailInfoMsg();
            if (failInfoMsg == null) {
            }
            if (!(ret == -5)) {
                str = ", MD5 ERROR!!!";
            } else {
                str = "";
            }
            HashMap<String, String> g16 = g(downloaderTask, isUpdate, "reportDownloadFinish" + str);
            g16.put("k_errcode", String.valueOf(ret));
            c("e_zplan_download_task_finish", ret, failInfoMsg, g16);
            if (isSuccess) {
                c.f396091a.b(this.url, this.uniqueTraceKey, String.valueOf(h(this.totalByte)), this.taskType, isSilentDownload);
            }
        }
        failInfoMsg = "";
        if (!(ret == -5)) {
        }
        HashMap<String, String> g162 = g(downloaderTask, isUpdate, "reportDownloadFinish" + str);
        g162.put("k_errcode", String.valueOf(ret));
        c("e_zplan_download_task_finish", ret, failInfoMsg, g162);
        if (isSuccess) {
        }
    }

    public final synchronized void l(DownloaderTask downloaderTask, boolean isUpdate) {
        Intrinsics.checkNotNullParameter(downloaderTask, "downloaderTask");
        c("e_zplan_download_task_pause", 0, "", g(downloaderTask, isUpdate, "reportDownloadPause"));
    }

    public final synchronized void m(String downloadUrl, String id5, String taskType, String uniqueTraceKey, boolean isUpdate, boolean isResumeStart) {
        String str;
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(uniqueTraceKey, "uniqueTraceKey");
        if (isResumeStart) {
            str = "e_zplan_download_task_resume";
        } else {
            str = "e_zplan_download_task_start";
        }
        i(downloadUrl, id5, taskType, uniqueTraceKey, isUpdate, str);
    }

    public final void n(String taskType, String url, long threadSwitchCostTime, long queryDbCostTime) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(url, "url");
        if (threadSwitchCostTime > 1000) {
            long currentTimeMillis = System.currentTimeMillis();
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_download_task_type", taskType), TuplesKt.to("k_download_task_url", url), TuplesKt.to("k_errcode", String.valueOf(0)), TuplesKt.to("k_thread_cost_time", String.valueOf(threadSwitchCostTime)), TuplesKt.to("k_db_query_time", String.valueOf(queryDbCostTime)));
            c("e_zplan_download_task_thread", 0, "", hashMapOf);
            QLog.e("ZootopiaFileDownloadManager_Report", 1, "reportDownloadThreadInfo threadSwitchCostTime too long - " + threadSwitchCostTime + ", " + url + ", reportCostTime= " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final synchronized void o(long receiveBytes, long totalByte) {
        this.totalByte = totalByte;
        this.lastReceivedBytes = receiveBytes;
    }

    public final void p(ZootopiaDownloadEntity modDownloadEntity) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(modDownloadEntity, "modDownloadEntity");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("k_mod_pak_real_deleted", "1"), TuplesKt.to("k_mod_map_id", modDownloadEntity.zootopiaId), TuplesKt.to("k_mod_version", modDownloadEntity.version), TuplesKt.to("k_mod_pack_type", String.valueOf(modDownloadEntity.packType)), TuplesKt.to("k_mod_url", modDownloadEntity.url), TuplesKt.to("k_mod_total_size", String.valueOf(h(modDownloadEntity.size))));
        c("e_zplan_mod_main_pak_deleted", 0, "", hashMapOf);
    }

    private final long h(long r36) {
        long roundToLong;
        roundToLong = MathKt__MathJVMKt.roundToLong(r36 / t74.a.f435529b);
        return roundToLong;
    }
}
