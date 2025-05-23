package com.tencent.rmonitor.base.db;

import android.content.ContentValues;
import android.support.annotation.NonNull;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportDataCacheMng;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.rmonitor.base.meta.BaseInfo;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e implements ReportDataCacheMng {

    /* renamed from: a, reason: collision with root package name */
    private final Function0<Integer> f365373a = new a();

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a implements Function0<Integer> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer invoke() {
            return 0;
        }
    }

    private boolean c(ReportData reportData, DBDataStatus dBDataStatus) {
        c b16;
        if (reportData == null || (b16 = b()) == null) {
            return false;
        }
        com.tencent.rmonitor.base.db.table.c a16 = a(reportData);
        a16.h(dBDataStatus);
        int h16 = b16.h(a16, this.f365373a);
        if (!d(h16)) {
            return false;
        }
        reportData.setDbId(h16);
        return true;
    }

    protected com.tencent.rmonitor.base.db.table.c a(@NonNull ReportData reportData) {
        UserMeta userMeta = BaseInfo.userMeta;
        return new com.tencent.rmonitor.base.db.table.c(userMeta.appId, ProcessUtil.getCurrentProcessName(ContextUtil.getGlobalContext()), userMeta.appVersion, reportData);
    }

    protected c b() {
        d dVar = BaseInfo.dbHelper;
        if (dVar != null) {
            return dVar.getDbHandler();
        }
        return null;
    }

    protected boolean d(int i3) {
        if (i3 != -1 && i3 != -2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.bugly.common.reporter.data.ReportDataCacheMng
    public boolean deleteReportDataFromCache(ReportData reportData) {
        if (reportData == null) {
            return false;
        }
        com.tencent.rmonitor.base.db.table.c a16 = a(reportData);
        c b16 = b();
        if (b16 == null) {
            return false;
        }
        Pair<String, String[]> f16 = a16.f();
        if (b16.f("report_data", f16.getFirst(), f16.getSecond()) <= 0) {
            return false;
        }
        reportData.setDbId(0);
        return true;
    }

    @Override // com.tencent.bugly.common.reporter.data.ReportDataCacheMng
    public boolean insertReportDataToCache(ReportData reportData) {
        return c(reportData, DBDataStatus.TO_SEND);
    }

    @Override // com.tencent.bugly.common.reporter.data.ReportDataCacheMng
    public boolean insertReportDataToCacheAsSend(ReportData reportData) {
        return c(reportData, DBDataStatus.SENT);
    }

    @Override // com.tencent.bugly.common.reporter.data.ReportDataCacheMng
    public boolean updateReportDataToCache(ReportData reportData) {
        if (reportData == null) {
            return false;
        }
        if (reportData.getDbId() == 0) {
            return insertReportDataToCache(reportData);
        }
        com.tencent.rmonitor.base.db.table.c a16 = a(reportData);
        c b16 = b();
        if (b16 == null) {
            return false;
        }
        ContentValues g16 = a16.g();
        g16.put("_id", Integer.valueOf(reportData.getDbId()));
        int l3 = b16.l("report_data", "_id", g16);
        if (!d(l3)) {
            return false;
        }
        reportData.setDbId(l3);
        return true;
    }
}
