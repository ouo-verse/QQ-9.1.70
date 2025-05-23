package com.tencent.richframework.argus.business.performance.report;

import com.google.gson.Gson;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.monitor.window.WindowPerformanceData;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.preload.activity.ArgusPreloadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bJ\u0014\u0010\u0011\u001a\u00020\u0002*\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R7\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/richframework/argus/business/performance/report/ArgusReportHelper;", "", "", "input", "getSimpleClassName", "Lcom/tencent/biz/richframework/monitor/window/WindowPerformanceData;", "windowPerformanceData", "type", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "createReportMap", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "report", "Lcom/google/gson/Gson;", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "toSafeJson", "scene", "getArgusReportParams", "", "sIsOpenPreload", "I", "getSIsOpenPreload", "()I", "setSIsOpenPreload", "(I)V", "sIsPublicVersion", "Ljava/lang/String;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "argusSceneHashMap$delegate", "Lkotlin/Lazy;", "getArgusSceneHashMap", "()Ljava/util/HashMap;", "argusSceneHashMap", "<init>", "()V", "qq-argus-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ArgusReportHelper {

    @NotNull
    public static final ArgusReportHelper INSTANCE = new ArgusReportHelper();

    /* renamed from: argusSceneHashMap$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy argusSceneHashMap;

    @NotNull
    private static final Gson gson;
    private static int sIsOpenPreload;

    @NotNull
    private static final String sIsPublicVersion;

    static {
        String str;
        Lazy lazy;
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isPublicVersion()) {
            str = "1";
        } else {
            str = "0";
        }
        sIsPublicVersion = str;
        gson = new Gson();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, String>>() { // from class: com.tencent.richframework.argus.business.performance.report.ArgusReportHelper$argusSceneHashMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, String> invoke() {
                HashMap<String, String> hashMap = new HashMap<>();
                String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("argus_bugly_report_scene_config", "");
                QLog.d("Argus-ArgusReportHelper", 1, "argusSceneHashMap string: " + loadAsString);
                try {
                    JSONObject jSONObject = new JSONObject(loadAsString);
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        if (str2 == null) {
                            str2 = "";
                        }
                        hashMap.put(str2, jSONObject.optString(str2));
                    }
                } catch (Exception e16) {
                    QLog.d("Argus-ArgusReportHelper", 1, "argusSceneHashMap ex: " + e16);
                }
                return hashMap;
            }
        });
        argusSceneHashMap = lazy;
    }

    ArgusReportHelper() {
    }

    private final HashMap<String, String> getArgusSceneHashMap() {
        return (HashMap) argusSceneHashMap.getValue();
    }

    private final String getSimpleClassName(String input) {
        int lastIndexOf$default;
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) input, '.', 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            String substring = input.substring(lastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return input;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0122, code lost:
    
        r2 = kotlin.collections.ArraysKt___ArraysKt.joinToString$default(r8, (java.lang.CharSequence) null, (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) com.tencent.richframework.argus.business.performance.report.ArgusReportHelper$createReportMap$1.INSTANCE, 31, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0174, code lost:
    
        r2 = kotlin.collections.ArraysKt___ArraysKt.joinToString$default(r8, (java.lang.CharSequence) null, (java.lang.CharSequence) null, (java.lang.CharSequence) null, 0, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) com.tencent.richframework.argus.business.performance.report.ArgusReportHelper$createReportMap$2.INSTANCE, 31, (java.lang.Object) null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HashMap<String, String> createReportMap(@NotNull WindowPerformanceData windowPerformanceData, @NotNull String type) {
        int lastIndex;
        Pair<Integer, Float> pair;
        NodePO nodePO;
        String str;
        ArrayList arrayList;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(windowPerformanceData, "windowPerformanceData");
        Intrinsics.checkNotNullParameter(type, "type");
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<Pair<Integer, Float>> it = windowPerformanceData.getFps().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "windowPerformanceData.fps.iterator()");
        ArrayList<Pair<Integer, Float>> fps = windowPerformanceData.getFps();
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(fps);
        float f16 = 0.0f;
        if (lastIndex >= 0) {
            pair = fps.get(0);
        } else {
            pair = TuplesKt.to(0, Float.valueOf(0.0f));
        }
        float floatValue = pair.getSecond().floatValue();
        if (windowPerformanceData.getTotalCount() != 0) {
            float f17 = 0.0f;
            while (it.hasNext()) {
                Pair<Integer, Float> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                Pair<Integer, Float> pair2 = next;
                f16 += (pair2.getSecond().floatValue() * pair2.getFirst().floatValue()) / ((float) windowPerformanceData.getTotalCount());
                floatValue = RangesKt___RangesKt.coerceAtMost(floatValue, pair2.getSecond().floatValue());
                f17 = RangesKt___RangesKt.coerceAtLeast(f17, pair2.getSecond().floatValue());
            }
            hashMap.put("fps_avg", String.valueOf(f16));
            hashMap.put("fps_max", String.valueOf(f17));
            hashMap.put("fps_min", String.valueOf(floatValue));
        }
        Object obj = windowPerformanceData.getExtMap().get("block_msg");
        HashMap hashMap2 = null;
        if (obj instanceof NodePO) {
            nodePO = (NodePO) obj;
        } else {
            nodePO = null;
        }
        if (nodePO != null) {
            hashMap.put("current_block", toSafeJson(gson, nodePO));
        }
        hashMap.put("type", type);
        hashMap.put("refresh_rate", String.valueOf(windowPerformanceData.getRefresh()));
        hashMap.put("smooth_rate", String.valueOf(windowPerformanceData.getFluency()));
        hashMap.put("is_public", sIsPublicVersion);
        hashMap.put("first_draw_time", String.valueOf(windowPerformanceData.getFirstDrawTime()));
        long[] firstDrawTimeCombination = windowPerformanceData.getFirstDrawTimeCombination();
        String str2 = " ";
        if (firstDrawTimeCombination == null || str == null) {
            str = " ";
        }
        hashMap.put("first_draw_time_composition", str);
        hashMap.put("scroll_time", String.valueOf(windowPerformanceData.getMonitorDuration()));
        String buildNum = ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).buildNum();
        Intrinsics.checkNotNullExpressionValue(buildNum, "api(IAppSettingApi::class.java).buildNum()");
        hashMap.put("build_version", buildNum);
        hashMap.put("max_frame_duration", String.valueOf(windowPerformanceData.getMaxFrameTime()));
        long[] maxFrameCombination = windowPerformanceData.getMaxFrameCombination();
        if (maxFrameCombination != null && joinToString$default != null) {
            str2 = joinToString$default;
        }
        hashMap.put("max_frame_composition", str2);
        Object obj2 = windowPerformanceData.getExtMap().get("error_msg");
        if (obj2 instanceof ArrayList) {
            arrayList = (ArrayList) obj2;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            hashMap.put("ext", toSafeJson(gson, arrayList));
        }
        Object obj3 = windowPerformanceData.getExtMap().get("monitor_report_business_ext_params");
        if (obj3 instanceof HashMap) {
            hashMap2 = (HashMap) obj3;
        }
        if (hashMap2 != null) {
            hashMap.put(HippyQQFileUtil.HIPPY_BUSINESS_DATA_DIR, INSTANCE.toSafeJson(gson, hashMap2));
        }
        return hashMap;
    }

    @NotNull
    public final String getArgusReportParams(@Nullable String scene) {
        boolean z16;
        if (scene != null && scene.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "";
        }
        String simpleClassName = getSimpleClassName(scene);
        String str = getArgusSceneHashMap().get(simpleClassName);
        if (str != null) {
            simpleClassName = str;
        }
        Intrinsics.checkNotNullExpressionValue(simpleClassName, "argusSceneHashMap[simple\u2026sName] ?: simpleClassName");
        Pair<Integer, Integer> preloadCount = ArgusPreloadManager.INSTANCE.getPreloadCount(simpleClassName);
        if (preloadCount.getSecond().intValue() == 0) {
            return "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("preloadCacheCount", String.valueOf(preloadCount.getFirst().intValue()));
        hashMap.put("preloadTotalCount", String.valueOf(preloadCount.getSecond().intValue()));
        hashMap.put("preloadProbability", String.valueOf(preloadCount.getFirst().floatValue() / (preloadCount.getSecond().floatValue() * 1.0f)));
        return toSafeJson(gson, hashMap);
    }

    @NotNull
    public final Gson getGson() {
        return gson;
    }

    public final void report(@NotNull Map<String, String> reportParams) {
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        QQBeaconReport.reportWithAppKey("0AND05X6VF2BAI40", RFWApplication.getAccountId(), "argus_performance_report", reportParams);
    }

    public final void setSIsOpenPreload(int i3) {
        sIsOpenPreload = i3;
    }

    @NotNull
    public final String toSafeJson(@NotNull Gson gson2, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(gson2, "<this>");
        try {
            String json = gson2.toJson(obj);
            Intrinsics.checkNotNullExpressionValue(json, "{\n            this.toJson(any)\n        }");
            return json;
        } catch (Exception unused) {
            return "";
        }
    }
}
