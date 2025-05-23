package com.tencent.rmonitor.base.reporter.batch;

import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.rmonitor.base.db.c;
import com.tencent.rmonitor.base.db.d;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.util.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/rmonitor/base/reporter/batch/StoreRecordDataRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lcom/tencent/bugly/common/reporter/data/ReportData;", "d", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "reportData", "<init>", "(Lcom/tencent/bugly/common/reporter/data/ReportData;)V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class StoreRecordDataRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ReportData reportData;

    public StoreRecordDataRunnable(@NotNull ReportData reportData) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        this.reportData = reportData;
    }

    @Override // java.lang.Runnable
    public void run() {
        Integer num;
        int dbId;
        c dbHandler;
        UserMeta userMeta = BaseInfo.userMeta;
        com.tencent.rmonitor.base.db.table.c cVar = new com.tencent.rmonitor.base.db.table.c(userMeta.appId, a.INSTANCE.c(BaseInfo.app), userMeta.appVersion, this.reportData);
        d dVar = BaseInfo.dbHelper;
        if (dVar != null && (dbHandler = dVar.getDbHandler()) != null) {
            num = Integer.valueOf(dbHandler.h(cVar, new Function0<Integer>() { // from class: com.tencent.rmonitor.base.reporter.batch.StoreRecordDataRunnable$run$dbId$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2() {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Integer invoke() {
                    return Integer.valueOf(invoke2());
                }
            }));
        } else {
            num = null;
        }
        ReportData reportData = this.reportData;
        if (num != null) {
            dbId = num.intValue();
        } else {
            dbId = reportData.getDbId();
        }
        reportData.setDbId(dbId);
    }
}
