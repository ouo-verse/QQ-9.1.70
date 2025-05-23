package com.tencent.qmethod.monitor.report.base.reporter.batch;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qmethod.monitor.base.util.AppInfo;
import com.tencent.qmethod.monitor.report.base.db.b;
import com.tencent.qmethod.monitor.report.base.db.c;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import nr3.UserMeta;
import nr3.a;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/reporter/batch/StoreRecordDataRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "d", "Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "reportData", "<init>", "(Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class StoreRecordDataRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ReportData reportData;

    public StoreRecordDataRunnable(@NotNull ReportData reportData) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        this.reportData = reportData;
    }

    @Override // java.lang.Runnable
    public void run() {
        b dbHandler;
        long currentTimeMillis = System.currentTimeMillis();
        c cVar = a.f421181c;
        if (cVar != null && (dbHandler = cVar.getDbHandler()) != null) {
            UserMeta userMeta = a.f421180b;
            String str = userMeta.appId;
            AppInfo.Companion companion = AppInfo.INSTANCE;
            String c16 = companion.c(companion.a());
            String str2 = userMeta.appVersion;
            String uin = this.reportData.getUin();
            String jSONObject = this.reportData.getParams().toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "reportData.params.toString()");
            dbHandler.g(new mr3.a(str, c16, str2, uin, jSONObject, this.reportData.getIsRealTime(), currentTimeMillis), new Function0<Integer>() { // from class: com.tencent.qmethod.monitor.report.base.reporter.batch.StoreRecordDataRunnable$run$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2() {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Integer invoke() {
                    return Integer.valueOf(invoke2());
                }
            });
        }
    }
}
