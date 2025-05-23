package com.tencent.qmethod.monitor.report.api;

import android.os.Handler;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.NetworkUtil;
import com.tencent.qmethod.monitor.base.util.f;
import com.tencent.qmethod.monitor.report.api.ApiInvokeRecord;
import com.tencent.qmethod.monitor.report.base.reporter.batch.BatchReportHelper;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\r\u001a\u00020\f*\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qmethod/monitor/report/api/ApiInvokeReporter;", "", "", "sdkStartTime", "", "apiInvokeStr", "", "Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "c", "Lcom/tencent/qmethod/monitor/report/api/b;", "apiInvokeRecords", "b", "Lorg/json/JSONObject;", "d", "", "e", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "handler", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hadReport", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class ApiInvokeReporter {

    /* renamed from: c, reason: collision with root package name */
    public static final ApiInvokeReporter f343787c = new ApiInvokeReporter();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Handler handler = new Handler(ThreadManager.f343506c.b());

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean hadReport = new AtomicBoolean();

    ApiInvokeReporter() {
    }

    private final ReportData b(List<ApiInvokeRecord> apiInvokeRecords, long sdkStartTime) {
        JSONObject f16 = pr3.b.f(pr3.b.f427061b, "compliance", "func_invoke", 0L, 4, null);
        NetworkUtil networkUtil = NetworkUtil.f343513c;
        String jSONObject = f343787c.d(new JSONObject(), apiInvokeRecords, sdkStartTime).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "JSONObject().putBodyRepo\u2026 sdkStartTime).toString()");
        f16.put(ReportDataBuilder.KEY_BODY, networkUtil.a(jSONObject));
        JSONObject put = f16.put(ReportDataBuilder.KEY_TRANSLATE_TYPE, KuiklyLaunchParams.SPLIT_MODE_LAUNCH_MODE_STANDARD);
        Intrinsics.checkExpressionValueIsNotNull(put, "ReportDataBuilder.makePa\u2026\"standard\")\n            }");
        return new ReportData(put, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ReportData> c(long sdkStartTime, String apiInvokeStr) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(apiInvokeStr);
            ArrayList arrayList2 = new ArrayList();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                ApiInvokeRecord.Companion companion = ApiInvokeRecord.INSTANCE;
                Object obj = jSONArray.get(i3);
                if (obj != null) {
                    arrayList2.add(companion.a((JSONObject) obj));
                    if (i3 % 20 == 19 || i3 >= jSONArray.length() - 1) {
                        arrayList.add(f343787c.b(arrayList2, sdkStartTime));
                        arrayList2.clear();
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
        } catch (Throwable th5) {
            o.d("", "generateReportDataList", th5);
        }
        return arrayList;
    }

    private final JSONObject d(@NotNull JSONObject jSONObject, List<ApiInvokeRecord> list, long j3) {
        JSONArray jSONArray = new JSONArray();
        for (ApiInvokeRecord apiInvokeRecord : list) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("module", apiInvokeRecord.getModuleName());
            jSONObject2.put(DTConstants.TAG.API, apiInvokeRecord.getApiName());
            jSONObject2.put("procName", com.tencent.qmethod.pandoraex.core.collector.utils.a.a());
            jSONObject2.put("sdkStartTime", j3);
            jSONObject2.put("fgCount", apiInvokeRecord.getFgCount());
            jSONObject2.put("bgCount", apiInvokeRecord.getBgCount());
            jSONObject2.put("fgCacheCount", apiInvokeRecord.getFgCacheCount());
            jSONObject2.put("bgCacheCount", apiInvokeRecord.getBgCacheCount());
            jSONObject2.put("normalCount", apiInvokeRecord.getNormalCount());
            jSONObject2.put("beforeCount", apiInvokeRecord.getBeforeCount());
            jSONObject2.put("illegalCount", apiInvokeRecord.getIllegalCount());
            jSONObject2.put("backCount", apiInvokeRecord.getBackCount());
            jSONObject2.put("highFreqCount", apiInvokeRecord.getHighFreqCount());
            jSONObject2.put("silenceCount", apiInvokeRecord.getSilenceCount());
            jSONObject2.put("denyRetryCount", apiInvokeRecord.getDenyRetryCount());
            jSONObject2.put("banCount", apiInvokeRecord.getBanCount());
            jSONObject2.put("useCacheCount", apiInvokeRecord.getCacheCount());
            jSONObject2.put("noCacheCount", apiInvokeRecord.getNoCacheCount());
            jSONObject2.put("useStorageCount", apiInvokeRecord.getStorageCount());
            jSONObject2.put("noStorageCount", apiInvokeRecord.getNoStorageCount());
            jSONObject2.put("cacheOnlyCount", apiInvokeRecord.getCacheOnlyCount());
            jSONObject2.put("notSetCount", apiInvokeRecord.getNotSetCount());
            jSONObject2.put("call_stack", apiInvokeRecord.getStackStr());
            jSONObject2.put("pages", new JSONArray((Collection) apiInvokeRecord.s()));
            jSONArray.mo162put(jSONObject2);
        }
        jSONObject.put("invokeEvents", jSONArray);
        return jSONObject;
    }

    public final void e() {
        boolean z16 = false;
        if (hadReport.compareAndSet(false, true)) {
            c cVar = c.f343818c;
            final long c16 = f.c(cVar.b());
            ApiInvokeAnalyse.f343783d.e();
            final String d16 = f.d(cVar.a());
            if (d16 == null) {
                d16 = "";
            }
            f.g(cVar.a(), "");
            if (d16.length() == 0) {
                z16 = true;
            }
            if (z16) {
                a.a("\u5f85\u4e0a\u62a5\u6570\u636e\u4e3a\u7a7a");
                return;
            }
            o.a("APIInvokeAnalyse", "reportLastAnalyse");
            com.tencent.qmethod.monitor.utils.a.f343870a.a("invoke_report_count");
            handler.postDelayed(new Runnable() { // from class: com.tencent.qmethod.monitor.report.api.ApiInvokeReporter$reportLastAnalyse$1
                @Override // java.lang.Runnable
                public final void run() {
                    List c17;
                    if (com.tencent.qmethod.monitor.a.f343451h.h()) {
                        c17 = ApiInvokeReporter.f343787c.c(c16, d16);
                        BatchReportHelper.e(new BatchReportHelper(null, 1, 0 == true ? 1 : 0), c17, null, 2, null);
                        a.a("\u4e0a\u62a5\u6570\u636e\uff1a" + c17);
                    }
                }
            }, 10000L);
        }
    }
}
