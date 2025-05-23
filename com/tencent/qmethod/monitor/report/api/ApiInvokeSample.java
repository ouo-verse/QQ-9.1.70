package com.tencent.qmethod.monitor.report.api;

import com.tencent.qmethod.monitor.base.util.f;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0010\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qmethod/monitor/report/api/ApiInvokeSample;", "", "", "apiName", "", "a", "(Ljava/lang/String;)Z", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "()Ljava/util/concurrent/ConcurrentHashMap;", "apiRateMap", "Lkotlin/Lazy;", "c", "()Z", "enableGlobal", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class ApiInvokeSample {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableGlobal;

    /* renamed from: c, reason: collision with root package name */
    public static final ApiInvokeSample f343792c = new ApiInvokeSample();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Double> apiRateMap = new ConcurrentHashMap<>();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qmethod.monitor.report.api.ApiInvokeSample$enableGlobal$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                boolean z16;
                e eVar = ConfigManager.f343549h.p().g().get("func_invoke_user");
                if (eVar == null) {
                    Intrinsics.throwNpe();
                }
                e eVar2 = eVar;
                com.tencent.qmethod.monitor.utils.a aVar = com.tencent.qmethod.monitor.utils.a.f343870a;
                if (aVar.b("invoke_enable_global", 1)) {
                    z16 = f.a("invoke_enable_global");
                } else {
                    aVar.a("invoke_enable_global");
                    boolean z17 = SampleHelper.z(SampleHelper.f343779l, eVar2.getRate(), 0, 0, 6, null);
                    o.a("APIInvokeAnalyse", "rate " + eVar2.getRate() + " ret " + z17);
                    f.e("invoke_enable_global", z17);
                    z16 = z17;
                }
                return z16 && !aVar.b("invoke_report_count", eVar2.getMaxReport());
            }
        });
        enableGlobal = lazy;
    }

    ApiInvokeSample() {
    }

    public final boolean a(@NotNull String apiName) {
        double d16;
        Intrinsics.checkParameterIsNotNull(apiName, "apiName");
        Double d17 = apiRateMap.get(apiName);
        if (d17 == null) {
            d17 = Double.valueOf(1.0d);
        }
        Intrinsics.checkExpressionValueIsNotNull(d17, "apiRateMap[apiName] ?: FULL_SAMPLE");
        double doubleValue = d17.doubleValue();
        e eVar = ConfigManager.f343549h.p().g().get("func_invoke_api");
        if (eVar != null) {
            d16 = eVar.getRate();
        } else {
            d16 = 0.0d;
        }
        if (ApiInvokeAnalyse.f343783d.a() && c() && SampleHelper.z(SampleHelper.f343779l, doubleValue * d16, 0, 0, 6, null)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ConcurrentHashMap<String, Double> b() {
        return apiRateMap;
    }

    public final boolean c() {
        return ((Boolean) enableGlobal.getValue()).booleanValue();
    }
}
