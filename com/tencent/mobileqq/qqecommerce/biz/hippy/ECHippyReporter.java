package com.tencent.mobileqq.qqecommerce.biz.hippy;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u001aB\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ4\u0010\n\u001a\u00020\t2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J,\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002JD\u0010\u0011\u001a\u00020\t2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\fj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J4\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00032\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J,\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\u0015\u001a\u00020\tJ \u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hippy/ECHippyReporter;", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "stepCosts", "Lcom/tencent/mobileqq/qqecommerce/biz/hippy/b;", "ecHippyPerformance", "", "f", "b", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "stepName", "startTime", "endTime", "g", "key", "d", "c", tl.h.F, "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "msg", "e", "a", "J", "loadHippyStartTime", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECHippyReporter {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy<ECHippyReporter> f262542c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long loadHippyStartTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hippy/ECHippyReporter$a;", "", "Lcom/tencent/mobileqq/qqecommerce/biz/hippy/ECHippyReporter;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qqecommerce/biz/hippy/ECHippyReporter;", "INSTANCE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.hippy.ECHippyReporter$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ECHippyReporter a() {
            return (ECHippyReporter) ECHippyReporter.f262542c.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<ECHippyReporter> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECHippyReporter>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hippy.ECHippyReporter$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECHippyReporter invoke() {
                return new ECHippyReporter(null);
            }
        });
        f262542c = lazy;
    }

    public /* synthetic */ ECHippyReporter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final HashMap<String, Long> c(ECHippyPerformance ecHippyPerformance) {
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.putAll(ecHippyPerformance.a());
        hashMap.put(HippyQQConstants.STEP_NAME_LOAD_HIPPY_START, Long.valueOf(this.loadHippyStartTime));
        return hashMap;
    }

    private final long d(String key, HashMap<String, Long> stepCosts) {
        if (!stepCosts.containsKey(key)) {
            return 0L;
        }
        Long l3 = stepCosts.get(key);
        Intrinsics.checkNotNull(l3);
        return l3.longValue();
    }

    private final void f(HashMap<String, Long> stepCosts, ECHippyPerformance ecHippyPerformance) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Hippy Performancedata isPreload:");
        sb5.append(ecHippyPerformance.getIsPreloaded());
        sb5.append(',');
        for (Map.Entry<String, Long> entry : stepCosts.entrySet()) {
            String key = entry.getKey();
            long longValue = entry.getValue().longValue();
            sb5.append(key);
            sb5.append(':');
            sb5.append(longValue);
            sb5.append(',');
        }
        QLog.i("ECHippyReporter", 2, sb5.toString());
    }

    public final void e(int statusCode, String msg2, ECHippyPerformance ecHippyPerformance) {
        Intrinsics.checkNotNullParameter(ecHippyPerformance, "ecHippyPerformance");
        HashMap<String, Long> b16 = b(ecHippyPerformance);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ret", Integer.valueOf(statusCode));
        if (msg2 == null) {
            msg2 = "";
        }
        hashMap.put("errMsg", msg2);
        hashMap.put("isPreload", Boolean.valueOf(ecHippyPerformance.getIsPreloaded()));
        hashMap.put("isPredraw", Boolean.valueOf(ecHippyPerformance.getIsPreDraw()));
        String preloadTypeToString = TabPreloadItem.preloadTypeToString(ecHippyPerformance.getPreloadType());
        Intrinsics.checkNotNullExpressionValue(preloadTypeToString, "preloadTypeToString(ecHi\u2026yPerformance.preloadType)");
        hashMap.put(OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE, preloadTypeToString);
        if (statusCode != 0 && statusCode != -11) {
            hashMap.putAll(ecHippyPerformance.e());
        }
        HippyReporter.getInstance().reportHippyLoadResult(3, ecHippyPerformance.getModuleName(), ecHippyPerformance.getModuleVersion(), hashMap, b16, null);
        if (QLog.isColorLevel()) {
            f(b16, ecHippyPerformance);
        }
    }

    public final void h() {
        this.loadHippyStartTime = System.currentTimeMillis();
    }

    ECHippyReporter() {
    }

    private final HashMap<String, Long> b(ECHippyPerformance ecHippyPerformance) {
        HashMap<String, Long> c16 = c(ecHippyPerformance);
        long d16 = d(HippyQQConstants.STEP_NAME_LOAD_HIPPY_START, c16);
        long d17 = d(HippyQQConstants.STEP_NAME_LOAD_LIBRARY_START, c16);
        long d18 = d(HippyQQConstants.STEP_NAME_LOAD_LIBRARY_END, c16);
        long d19 = d(HippyQQConstants.STEP_NAME_INIT_ENGINE_END, c16);
        long d26 = d(HippyQQConstants.STEP_NAME_LOAD_MODULE_START, c16);
        long d27 = d(HippyQQConstants.STEP_NAME_LOAD_MODULE_END, c16);
        long d28 = d(HippyQQConstants.STEP_NAME_LOAD_SNAPSHOT_END, c16);
        LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>();
        g(linkedHashMap, "prepareData", d17, d16);
        g(linkedHashMap, "loadLibrary", d18, d17);
        g(linkedHashMap, "initEngine", d19, d18);
        g(linkedHashMap, "checkJsBundle", d26, d19);
        if (d28 != 0) {
            g(linkedHashMap, "loadSnapshot", d28, d26);
            g(linkedHashMap, "snapshotTotal", d28, d16);
        }
        g(linkedHashMap, "loadJsBundle", d27, d26);
        g(linkedHashMap, "total", d27, d16);
        return linkedHashMap;
    }

    private final void g(LinkedHashMap<String, Long> stepCosts, String stepName, long startTime, long endTime) {
        if (startTime <= 0 || endTime <= 0) {
            return;
        }
        stepCosts.put(stepName, Long.valueOf(startTime - endTime));
    }
}
