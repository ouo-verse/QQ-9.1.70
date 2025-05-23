package com.tencent.rmonitor.base.reporter.batch;

import android.database.Cursor;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.network.NetworkWatcher;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportStrategy;
import com.tencent.bugly.common.reporter.link.PluginLinkDataProxy;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.rmonitor.base.db.DBDataStatus;
import com.tencent.rmonitor.base.db.c;
import com.tencent.rmonitor.base.db.d;
import com.tencent.rmonitor.base.db.table.AttaEventTable;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.DiscardReason;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.common.util.b;
import com.tencent.rmonitor.sla.StatisticsReporter;
import cooperation.qzone.util.QZoneAppCtrlUploadFileLogic;
import j04.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \u00112\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u00020\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J&\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u001c\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007H\u0002J,\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002J<\u0010 \u001a\u00020\u00042\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00072\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007H\u0002J\b\u0010!\u001a\u00020\u0004H\u0016J$\u0010%\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u00150\"R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010&R\u0014\u0010)\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010(R\u0016\u0010+\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010*R\u0018\u0010-\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/rmonitor/base/reporter/batch/CollectRecordDataRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "reportData", "", "d", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "relatedLagDataList", "e", "j", "k", h.F, "Lcom/tencent/rmonitor/base/db/DBDataStatus;", "dbDataStatus", "Lcom/tencent/rmonitor/base/reporter/DiscardReason;", "discardReason", "i", "Lorg/json/JSONObject;", "exception", "f", "", "b", "", DomainData.DOMAIN_NAME, "l", "", "start", "end", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "inputList", "outputList", "g", TencentLocation.RUN_MODE, "", "", "map", "c", "Ljava/util/ArrayList;", "reportDataList", "Ljava/lang/Runnable;", "reportDbDataRunnable", "I", "listIndex", "Lorg/json/JSONObject;", "lastExceptionFromCache", "<init>", "()V", "a", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class CollectRecordDataRunnable implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ReportData> reportDataList = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Runnable reportDbDataRunnable = new Runnable() { // from class: com.tencent.rmonitor.base.reporter.batch.CollectRecordDataRunnable$reportDbDataRunnable$1
        @Override // java.lang.Runnable
        public final void run() {
            CollectRecordDataRunnable.this.k();
        }
    };

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int listIndex;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private JSONObject lastExceptionFromCache;

    private final void b(ReportData reportData, String exception) {
        reportData.getParams().put(ReportDataBuilder.KEY_EXCEPTION_LINK, exception);
    }

    private final void d(ReportData reportData) {
        if (reportData.getParams().has(ReportDataBuilder.KEY_ATTRIBUTES)) {
            Object obj = reportData.getParams().get(ReportDataBuilder.KEY_ATTRIBUTES);
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.has("fileObj")) {
                    String string = jSONObject.getString("fileObj");
                    Intrinsics.checkExpressionValueIsNotNull(string, "attributes.getString(\"fileObj\")");
                    reportData.addFile(string, true, true);
                }
            }
        }
    }

    private final void e(ArrayList<ReportData> relatedLagDataList) {
        this.reportDataList.clear();
        this.listIndex = 0;
        if (relatedLagDataList != null) {
            this.reportDataList.addAll(relatedLagDataList);
        }
        g(l(), this.reportDataList);
        ArrayList<ReportData> b16 = a.b();
        if (b16 != null) {
            this.reportDataList.addAll(b16);
        }
        if (Logger.debug) {
            Logger.f365497g.d("RMonitor_report_cache", "collect db data count: " + this.reportDataList.size());
        }
    }

    private final ArrayList<ReportData> f(JSONObject exception) {
        if (exception != null && !(!Intrinsics.areEqual(QZoneAppCtrlUploadFileLogic.ANR_LOG_DIRECTORY, exception.optString(ReportDataBuilder.KEY_BASE_TYPE)))) {
            String optString = exception.optString(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID);
            long optLong = exception.optLong(ReportDataBuilder.KEY_EVENT_TIME_IN_MS);
            ArrayList<ReportData> m3 = m(optLong - 60000, optLong + 10);
            if (m3 != null) {
                ArrayList<ReportData> arrayList = new ArrayList<>();
                for (ReportData reportData : m3) {
                    String pluginNameFromParam = ReportDataBuilder.getPluginNameFromParam(reportData.getParams());
                    if (Intrinsics.areEqual(optString, ReportDataBuilder.getProcessLaunchIdFromParam(reportData.getParams())) && Intrinsics.areEqual(BuglyMonitorName.LOOPER_STACK, pluginNameFromParam)) {
                        String optString2 = exception.optString(ReportDataBuilder.KEY_BASE_TYPE);
                        Intrinsics.checkExpressionValueIsNotNull(optString2, "exception.optString(Repo\u2026ataBuilder.KEY_BASE_TYPE)");
                        b(reportData, optString2);
                        arrayList.add(reportData);
                    }
                }
                Logger.f365497g.d("RMonitor_report_cache", "collectExceptionRelatedLagData, targetProcessLaunchId: " + optString + ", count: " + arrayList.size());
                return arrayList;
            }
            Logger.f365497g.d("RMonitor_report_cache", "collectExceptionRelatedLagData, targetProcessLaunchId: " + optString + ", empty");
            return m3;
        }
        Logger.f365497g.d("RMonitor_report_cache", "collectExceptionRelatedLagData fail for last exception is not anr.");
        return null;
    }

    private final void g(ArrayList<ReportData> inputList, ArrayList<ReportData> outputList) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = outputList.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((ReportData) it.next()).getDbId()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (inputList != null) {
            for (ReportData reportData : inputList) {
                if (!arrayList.contains(Integer.valueOf(reportData.getDbId())) && c(reportData, linkedHashMap)) {
                    outputList.add(reportData);
                    arrayList.add(Integer.valueOf(reportData.getDbId()));
                }
            }
        }
        Iterator<T> it5 = outputList.iterator();
        while (it5.hasNext()) {
            d((ReportData) it5.next());
        }
        if (Logger.debug) {
            Logger.f365497g.d("RMonitor_report_cache", "dealBeforeReport, count: " + outputList.size());
        }
    }

    private final void h() {
        d dVar;
        c dbHandler;
        Logger.f365497g.d("RMonitor_report_cache", "deleteAllSentOrOverTime");
        FileUtil.Companion companion = FileUtil.INSTANCE;
        companion.d(companion.i(), 259200000);
        i(DBDataStatus.TO_SEND, DiscardReason.CACHE_EXPIRE);
        i(DBDataStatus.SENT_FAIL, DiscardReason.RETRY_EXCEEDED);
        for (String str : c.INSTANCE.b()) {
            try {
                Logger.f365497g.d("RMonitor_report_cache", "table: " + str);
                if (!Intrinsics.areEqual(str, AttaEventTable.INSTANCE.b()) && (dVar = BaseInfo.dbHelper) != null && (dbHandler = dVar.getDbHandler()) != null) {
                    dbHandler.g(str, true);
                }
            } catch (Throwable th5) {
                Logger.f365497g.e("RMonitor_report_cache", "delete expired data fail for " + th5.getMessage());
            }
        }
    }

    private final void i(DBDataStatus dbDataStatus, DiscardReason discardReason) {
        Cursor cursor;
        c dbHandler;
        Logger.f365497g.d("RMonitor_report_cache", "recordDiscardData");
        long currentTimeMillis = System.currentTimeMillis() - 259200000;
        d dVar = BaseInfo.dbHelper;
        if (dVar != null && (dbHandler = dVar.getDbHandler()) != null) {
            cursor = c.k(dbHandler, com.tencent.rmonitor.base.db.table.c.INSTANCE.a(), new String[]{"params"}, "status=? AND occur_time<?", new String[]{String.valueOf(dbDataStatus.getValue()), String.valueOf(currentTimeMillis)}, false, null, null, null, null, w.CTRL_INDEX, null);
        } else {
            cursor = null;
        }
        if (cursor != null) {
            Cursor cursor2 = cursor;
            try {
                Cursor cursor3 = cursor2;
                if (cursor3.getCount() > 0) {
                    while (cursor3.moveToNext()) {
                        JSONObject jSONObject = new JSONObject(cursor3.getString(cursor3.getColumnIndex("params")));
                        com.tencent.rmonitor.common.util.d dVar2 = com.tencent.rmonitor.common.util.d.f365537a;
                        String a16 = dVar2.a(jSONObject, ReportDataBuilder.KEY_BASE_TYPE);
                        String a17 = dVar2.a(jSONObject, "sub_type");
                        if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(a17)) {
                            StatisticsReporter.INSTANCE.a().h(a16, a17, discardReason);
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor2, null);
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(cursor2, th5);
                    throw th6;
                }
            }
        }
    }

    private final void j() {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        if (this.reportDataList.isEmpty()) {
            return;
        }
        int i3 = this.listIndex + 1;
        this.listIndex = i3;
        if (i3 <= this.reportDataList.size()) {
            ReportData reportData = this.reportDataList.get(this.listIndex - 1);
            Intrinsics.checkExpressionValueIsNotNull(reportData, "reportDataList[listIndex - 1]");
            ReportData reportData2 = reportData;
            reportData2.getReportStrategy().setUploadStrategy(ReportStrategy.UploadStrategy.UPLOAD_ANY);
            reportData2.getReportStrategy().setRetryTimes(0);
            reportData2.getReportStrategy().setNeedCache(false);
            ReporterMachine reporterMachine = ReporterMachine.f365411g;
            reporterMachine.reportNow(reportData2, null);
            reporterMachine.l(this.reportDbDataRunnable, 500L);
            if (Logger.debug) {
                Logger.f365497g.d("RMonitor_report_cache", "reportDbDataOneByOne, total:" + this.reportDataList.size() + ", index:" + this.listIndex + ", cur: " + reportData2.getPluginName());
            }
        }
    }

    private final ArrayList<ReportData> l() {
        Object obj;
        c dbHandler;
        UserMeta userMeta = BaseInfo.userMeta;
        com.tencent.rmonitor.base.db.table.c cVar = new com.tencent.rmonitor.base.db.table.c(userMeta.appId, com.tencent.rmonitor.common.util.a.INSTANCE.c(BaseInfo.app), userMeta.appVersion);
        d dVar = BaseInfo.dbHelper;
        Object obj2 = null;
        if (dVar != null && (dbHandler = dVar.getDbHandler()) != null) {
            obj = dbHandler.m(cVar, new Function0<Integer>() { // from class: com.tencent.rmonitor.base.reporter.batch.CollectRecordDataRunnable$searchNoneSendValidData$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2() {
                    return 1;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Integer invoke() {
                    return Integer.valueOf(invoke2());
                }
            });
        } else {
            obj = null;
        }
        if (obj instanceof ArrayList) {
            obj2 = obj;
        }
        return (ArrayList) obj2;
    }

    private final ArrayList<ReportData> m(long start, long end) {
        Object obj;
        c dbHandler;
        UserMeta userMeta = BaseInfo.userMeta;
        com.tencent.rmonitor.base.db.table.c cVar = new com.tencent.rmonitor.base.db.table.c(userMeta.appId, com.tencent.rmonitor.common.util.a.INSTANCE.c(BaseInfo.app), userMeta.appVersion);
        cVar.i(start, end);
        d dVar = BaseInfo.dbHelper;
        Object obj2 = null;
        if (dVar != null && (dbHandler = dVar.getDbHandler()) != null) {
            obj = dbHandler.m(cVar, new Function0<Integer>() { // from class: com.tencent.rmonitor.base.reporter.batch.CollectRecordDataRunnable$searchRangeData$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2() {
                    return 2;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Integer invoke() {
                    return Integer.valueOf(invoke2());
                }
            });
        } else {
            obj = null;
        }
        if (obj instanceof ArrayList) {
            obj2 = obj;
        }
        return (ArrayList) obj2;
    }

    private final boolean n() {
        NetworkWatcher networkWatcher = NetworkWatcher.INSTANCE;
        if (networkWatcher.isWiFiConnectedRealtime()) {
            return true;
        }
        if (!networkWatcher.isNetworkConnectedRealtime()) {
            return false;
        }
        if (b.f365535j.a(BaseInfo.app) || this.lastExceptionFromCache != null) {
            return true;
        }
        return false;
    }

    public final boolean c(@NotNull ReportData reportData, @NotNull Map<Integer, String> map) {
        boolean z16;
        String str;
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        Intrinsics.checkParameterIsNotNull(map, "map");
        if (reportData.isCurLaunchData()) {
            str = "current launch data";
            z16 = false;
        } else {
            int myPid = Process.myPid();
            if (!map.containsKey(Integer.valueOf(myPid))) {
                map.put(Integer.valueOf(myPid), ProcessUtil.INSTANCE.getProcessNameByCmdLine(myPid));
                Logger.f365497g.d("RMonitor_report_cache", "filter, pid: " + myPid + ", name: " + map.get(Integer.valueOf(myPid)));
            }
            int pidFromParam = ReportDataBuilder.getPidFromParam(reportData.getParams());
            if (!map.containsKey(Integer.valueOf(pidFromParam))) {
                map.put(Integer.valueOf(pidFromParam), ProcessUtil.INSTANCE.getProcessNameByCmdLineInner(pidFromParam));
                Logger.f365497g.d("RMonitor_report_cache", "filter, pid: " + pidFromParam + ", name: " + map.get(Integer.valueOf(pidFromParam)));
            }
            if (map.get(Integer.valueOf(pidFromParam)) == null || !TextUtils.equals(map.get(Integer.valueOf(pidFromParam)), map.get(Integer.valueOf(myPid)))) {
                z16 = true;
            } else {
                z16 = false;
            }
            str = "same-named surviving process";
        }
        if (!z16 && Logger.debug) {
            String optString = reportData.getParams().optString(ReportDataBuilder.KEY_CLIENT_IDENTIFY);
            Logger.f365497g.d("RMonitor_report_cache", "filter data [" + optString + "] for " + str);
        }
        return z16;
    }

    @Override // java.lang.Runnable
    public void run() {
        Logger logger = Logger.f365497g;
        logger.d("RMonitor_report_cache", "start collect cached data.");
        PluginLinkDataProxy pluginLinkDataProxy = PluginLinkDataProxy.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(pluginLinkDataProxy, "PluginLinkDataProxy.getInstance()");
        this.lastExceptionFromCache = pluginLinkDataProxy.getLastExceptionDataFromCache();
        logger.d("RMonitor_report_cache", "lastExceptionFromCache: " + this.lastExceptionFromCache);
        ArrayList<ReportData> f16 = f(this.lastExceptionFromCache);
        h();
        if (n()) {
            PluginLinkDataProxy.getInstance().saveLastExceptionDataToCache(null);
            e(f16);
            j();
            return;
        }
        logger.d("RMonitor_report_cache", "should not report cached data.");
    }
}
