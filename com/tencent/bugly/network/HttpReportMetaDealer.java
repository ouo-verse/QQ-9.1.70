package com.tencent.bugly.network;

import android.support.annotation.NonNull;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.data.ReportDataCacheMng;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;
import s04.b;

/* compiled from: P */
/* loaded from: classes5.dex */
class HttpReportMetaDealer implements HttpReportMetaCollector {
    private static final int CACHE_NONE = 0;
    private static final int CACHE_NOT_FULL = 1;
    private static final String LIST = "list";
    private static final String TAG = "RMonitor_net_quality_dealer";
    private final NetQualityPluginConfig config;
    private final ReportDataCacheMng dataCacheMng;
    private ReportData lastReportData = null;
    private int lastCachedCount = 0;
    private Runnable lastTask = null;
    private final ConcurrentLinkedQueue<HttpReportMeta> cache = new ConcurrentLinkedQueue<>();

    public HttpReportMetaDealer(@NonNull NetQualityPluginConfig netQualityPluginConfig, ReportDataCacheMng reportDataCacheMng) {
        this.config = netQualityPluginConfig;
        this.dataCacheMng = reportDataCacheMng;
        if (Logger.verbos) {
            Logger.f365497g.v(TAG, "config: " + netQualityPluginConfig);
        }
    }

    private boolean tryReport(int i3, ArrayList<HttpReportMeta> arrayList) {
        int size = arrayList.size();
        ReportData makeReportData = makeReportData(arrayList, BaseInfo.userMeta);
        if (makeReportData == null) {
            return true;
        }
        if (size >= i3) {
            realReport(makeReportData);
            return false;
        }
        this.lastReportData = makeReportData;
        this.lastCachedCount = size;
        this.dataCacheMng.insertReportDataToCache(makeReportData);
        return true;
    }

    protected void appendData(ReportData reportData, List<HttpReportMeta> list) {
        if (reportData == null) {
            return;
        }
        appendData(reportData.getParams(), list);
    }

    @Override // com.tencent.bugly.network.HttpReportMetaCollector
    public void collectMeta(HttpReportMeta httpReportMeta) {
        if (httpReportMeta == null) {
            return;
        }
        this.cache.offer(httpReportMeta);
        if (this.cache.size() >= this.config.maxBatchCount) {
            reportOrCacheDataAsync("meet maxBatchCount");
        }
    }

    protected int dealCachedReportData(int i3, int i16) {
        ReportData reportData = this.lastReportData;
        if (reportData == null) {
            return 0;
        }
        int i17 = i3 - this.lastCachedCount;
        if (i17 >= 0) {
            ArrayList<HttpReportMeta> arrayList = new ArrayList<>();
            pollBatchData(arrayList, i17);
            appendData(reportData, arrayList);
            this.lastCachedCount += arrayList.size();
        }
        if (this.lastCachedCount >= i16) {
            this.dataCacheMng.deleteReportDataFromCache(reportData);
            realReport(reportData);
            this.lastReportData = null;
            this.lastCachedCount = 0;
            return 0;
        }
        this.dataCacheMng.updateReportDataToCache(reportData);
        return 1;
    }

    @Override // com.tencent.bugly.network.HttpReportMetaCollector
    public NetQualityPluginConfig getConfig() {
        return this.config;
    }

    protected ReportData makeReportData(List<HttpReportMeta> list, UserMeta userMeta) {
        Object obj;
        if (list == null || list.isEmpty() || userMeta == null) {
            return null;
        }
        JSONObject makeParam = ReportDataBuilder.makeParam(ContextUtil.getGlobalContext(), "resource", BuglyMonitorName.NET_QUALITY, userMeta);
        if (makeParam == null) {
            Logger.f365497g.d(TAG, "makeReportData fail for param is null.");
            return null;
        }
        try {
            Iterator<HttpReportMeta> it = list.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                z16 |= it.next().hasStacks;
            }
            if (z16) {
                obj = CanvasView.ACTION_TRANSLATE;
            } else {
                obj = "none";
            }
            makeParam.put(ReportDataBuilder.KEY_TRANSLATE_TYPE, obj);
            JSONObject makeAttributes = ReportDataBuilder.makeAttributes(ReportDataBuilder.FILTER_STAGE);
            b.j().g(makeAttributes);
            b.j().c(true, BuglyMonitorName.NET_QUALITY, makeAttributes);
            makeParam.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
            appendData(makeParam, list);
        } catch (Throwable th5) {
            Logger.f365497g.d(TAG, "makeReportData fail for " + th5.getMessage());
        }
        ReportData reportData = new ReportData(userMeta.uin, 1, BuglyMonitorName.NET_QUALITY, makeParam);
        reportData.setShouldRecordLinkData(false);
        return reportData;
    }

    protected void pollBatchData(@NonNull ArrayList<HttpReportMeta> arrayList, int i3) {
        arrayList.clear();
        for (int i16 = 0; i16 < i3 && !this.cache.isEmpty(); i16++) {
            HttpReportMeta poll = this.cache.poll();
            if (poll != null) {
                arrayList.add(poll);
            } else {
                return;
            }
        }
    }

    protected void realReport(ReportData reportData) {
        Logger.f365497g.d(TAG, "realReport, id: " + reportData.getDbId());
        ReporterMachine.f365411g.reportNow(reportData, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportOrCacheDataAsync(String str) {
        if (this.lastTask != null) {
            Logger.f365497g.d(TAG, "try report or cache data fail for last task not finish.");
            return;
        }
        Logger.f365497g.d(TAG, "try report or cache data for " + str);
        Runnable runnable = new Runnable() { // from class: com.tencent.bugly.network.HttpReportMetaDealer.1
            @Override // java.lang.Runnable
            public void run() {
                HttpReportMetaDealer.this.reportOrCacheDataSync();
                HttpReportMetaDealer.this.lastTask = null;
            }
        };
        this.lastTask = runnable;
        ThreadManager.runInMonitorThread(runnable, 0L);
    }

    protected void reportOrCacheDataInner(int i3, int i16) {
        if (i3 <= 0 || i16 < 0 || i3 < i16 || this.cache.isEmpty() || dealCachedReportData(i3, i16) == 1) {
            return;
        }
        ArrayList<HttpReportMeta> arrayList = new ArrayList<>();
        int size = (this.cache.size() / i3) + 1;
        boolean z16 = false;
        for (int i17 = 0; !z16 && i17 < size && !this.cache.isEmpty(); i17++) {
            pollBatchData(arrayList, i3);
            if (arrayList.isEmpty()) {
                z16 = true;
            } else {
                z16 = tryReport(i16, arrayList);
            }
        }
    }

    public void reportOrCacheDataSync() {
        NetQualityPluginConfig netQualityPluginConfig = this.config;
        reportOrCacheDataInner(netQualityPluginConfig.maxBatchCount, netQualityPluginConfig.minBatchCount);
    }

    protected void appendData(JSONObject jSONObject, List<HttpReportMeta> list) {
        if (jSONObject == null || list == null || list.isEmpty()) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(ReportDataBuilder.KEY_BODY);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                jSONObject.put(ReportDataBuilder.KEY_BODY, optJSONObject);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                optJSONObject.put("list", optJSONArray);
            }
            Iterator<HttpReportMeta> it = list.iterator();
            while (it.hasNext()) {
                optJSONArray.mo162put(it.next().data);
            }
        } catch (Throwable th5) {
            Logger.f365497g.e(TAG, "appendData fail for " + th5.getMessage());
        }
    }
}
