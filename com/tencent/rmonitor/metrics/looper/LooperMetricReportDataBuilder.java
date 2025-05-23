package com.tencent.rmonitor.metrics.looper;

import android.app.Application;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.DropFrameResultMeta;
import com.tencent.rmonitor.base.reporter.DiscardReason;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.sla.StatisticsReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJJ\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002J \u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006J2\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00102\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0017j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010`\u0018J\u0014\u0010\u001b\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J,\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006 "}, d2 = {"Lcom/tencent/rmonitor/metrics/looper/LooperMetricReportDataBuilder;", "", "", "pluginName", "Lkotlin/Pair;", "launchID", "", "Lorg/json/JSONObject;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "Lkotlin/collections/ArrayList;", "result", "", "f", "g", "Lcom/tencent/rmonitor/base/meta/DropFrameResultMeta;", PublicAccountMessageUtilImpl.META_NAME, "", "d", "e", "b", "data", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sceneMap", h.F, "a", "processLaunchID", "c", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class LooperMetricReportDataBuilder {
    private final boolean d(DropFrameResultMeta meta) {
        if (e.b(meta) == 0) {
            return true;
        }
        return false;
    }

    private final void f(String pluginName, Pair<String, String> launchID, List<? extends JSONObject> list, ArrayList<ReportData> result) {
        int coerceAtMost;
        int i3 = 0;
        while (i3 < list.size()) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3 + 100, list.size());
            result.add(c(pluginName, launchID.getFirst(), launchID.getSecond(), list.subList(i3, coerceAtMost)));
            i3 = coerceAtMost;
        }
        if (Logger.debug) {
            Logger.f365497g.d("RMonitor_looper", "makeReportData, pluginName: " + pluginName + ", launchID: " + launchID + ", listSize: " + list.size() + ", resultSize: " + result.size());
        }
    }

    private final List<JSONObject> g(List<? extends JSONObject> list) {
        if (list != null && !list.isEmpty()) {
            HashMap<String, DropFrameResultMeta> hashMap = new HashMap<>();
            for (JSONObject jSONObject : list) {
                DropFrameResultMeta dropFrameResultMeta = new DropFrameResultMeta(null, 0L, null, null, 0L, 0L, 0L, null, 255, null);
                dropFrameResultMeta.fromJSONObject(jSONObject);
                h(dropFrameResultMeta, hashMap);
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, DropFrameResultMeta> entry : hashMap.entrySet()) {
                if (d(entry.getValue())) {
                    arrayList.add(entry.getValue().toJSONObject());
                }
            }
            return arrayList;
        }
        return null;
    }

    @NotNull
    public final JSONObject a(@NotNull List<? extends JSONObject> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<? extends JSONObject> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        jSONObject.put("metrics", jSONArray);
        return jSONObject;
    }

    @Nullable
    public final List<ReportData> b() {
        Object obj;
        int i3;
        com.tencent.rmonitor.base.db.c dbHandler;
        com.tencent.rmonitor.base.db.c dbHandler2;
        com.tencent.rmonitor.base.db.table.a aVar = new com.tencent.rmonitor.base.db.table.a(BaseInfo.INSTANCE.makeBaseDBParam(), BuglyMonitorName.FLUENCY_METRIC);
        com.tencent.rmonitor.base.db.d dVar = BaseInfo.dbHelper;
        Object obj2 = null;
        if (dVar != null && (dbHandler2 = dVar.getDbHandler()) != null) {
            obj = dbHandler2.m(aVar, new Function0<Integer>() { // from class: com.tencent.rmonitor.metrics.looper.LooperMetricReportDataBuilder$buildLooperMetricReportDataAndClearCache$resultMap$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2() {
                    return 0;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Integer invoke() {
                    return Integer.valueOf(invoke2());
                }
            });
        } else {
            obj = null;
        }
        if (obj instanceof HashMap) {
            obj2 = obj;
        }
        HashMap hashMap = (HashMap) obj2;
        com.tencent.rmonitor.base.db.d dVar2 = BaseInfo.dbHelper;
        if (dVar2 != null && (dbHandler = dVar2.getDbHandler()) != null) {
            dbHandler.f(com.tencent.rmonitor.base.db.table.a.INSTANCE.a(), aVar.d(), aVar.c());
        }
        ArrayList<ReportData> arrayList = new ArrayList<>();
        if (hashMap != null) {
            i3 = 0;
            for (Map.Entry entry : hashMap.entrySet()) {
                List<JSONObject> g16 = g((List) entry.getValue());
                if (g16 != null && (!g16.isEmpty())) {
                    i3 += g16.size();
                    f(BuglyMonitorName.FLUENCY_METRIC, com.tencent.rmonitor.base.db.table.a.INSTANCE.c((String) entry.getKey()), g16, arrayList);
                }
            }
        } else {
            i3 = 0;
        }
        if (Logger.debug) {
            Logger.f365497g.d("RMonitor_looper", "buildLooperMetricReportData, pluginName: " + BuglyMonitorName.FLUENCY_METRIC + ", count: " + i3 + ", result: " + arrayList.size());
        }
        return arrayList;
    }

    @NotNull
    public final ReportData c(@NotNull String pluginName, @NotNull String launchID, @NotNull String processLaunchID, @NotNull List<? extends JSONObject> list) {
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        Intrinsics.checkParameterIsNotNull(launchID, "launchID");
        Intrinsics.checkParameterIsNotNull(processLaunchID, "processLaunchID");
        Intrinsics.checkParameterIsNotNull(list, "list");
        JSONObject a16 = a(list);
        JSONObject makeAttributes = ReportDataBuilder.makeAttributes(new String[]{"stage"});
        Application application = BaseInfo.app;
        UserMeta userMeta = BaseInfo.userMeta;
        JSONObject params = ReportDataBuilder.makeParam(application, "looper", pluginName, userMeta);
        params.put(ReportDataBuilder.KEY_LAUNCH_ID, launchID);
        params.put(ReportDataBuilder.KEY_PROCESS_LAUNCH_ID, processLaunchID);
        params.put(ReportDataBuilder.KEY_ATTRIBUTES, makeAttributes);
        params.put(ReportDataBuilder.KEY_BODY, a16);
        String str = userMeta.uin;
        Intrinsics.checkExpressionValueIsNotNull(params, "params");
        return new ReportData(str, 1, pluginName, params);
    }

    public final void e() {
        int i3;
        com.tencent.rmonitor.base.db.c dbHandler;
        com.tencent.rmonitor.base.db.c dbHandler2;
        long currentTimeMillis = System.currentTimeMillis() - 259200000;
        com.tencent.rmonitor.base.db.d dVar = BaseInfo.dbHelper;
        int i16 = 0;
        if (dVar != null && (dbHandler2 = dVar.getDbHandler()) != null) {
            i3 = dbHandler2.f(com.tencent.rmonitor.base.db.table.a.INSTANCE.a(), "plugin_name=? AND occur_time<?", new String[]{BuglyMonitorName.FLUENCY_METRIC, String.valueOf(currentTimeMillis)});
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            StatisticsReporter.INSTANCE.a().h("looper", BuglyMonitorName.FLUENCY_METRIC, DiscardReason.CACHE_EXPIRE);
        }
        com.tencent.rmonitor.base.db.d dVar2 = BaseInfo.dbHelper;
        if (dVar2 != null && (dbHandler = dVar2.getDbHandler()) != null) {
            i16 = dbHandler.f(com.tencent.rmonitor.base.db.table.a.INSTANCE.a(), "plugin_name=? AND occur_time<?", new String[]{BuglyMonitorName.FLUENCY_METRIC, String.valueOf(currentTimeMillis)});
        }
        if (i16 > 0) {
            StatisticsReporter.INSTANCE.a().h("looper", BuglyMonitorName.FLUENCY_METRIC, DiscardReason.CACHE_EXPIRE);
        }
    }

    public final void h(@NotNull DropFrameResultMeta data, @NotNull HashMap<String, DropFrameResultMeta> sceneMap) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        Intrinsics.checkParameterIsNotNull(sceneMap, "sceneMap");
        if (sceneMap.containsKey(data.scene)) {
            DropFrameResultMeta dropFrameResult = sceneMap.get(data.scene);
            if (dropFrameResult != null) {
                dropFrameResult.merge(data);
                String str = data.scene;
                Intrinsics.checkExpressionValueIsNotNull(dropFrameResult, "dropFrameResult");
                sceneMap.put(str, dropFrameResult);
                return;
            }
            return;
        }
        sceneMap.put(data.scene, data);
    }
}
