package com.tencent.qmethod.monitor.ext.traffic;

import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.pandoraex.core.o;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureSample;", "", "", "a", "()Z", "c", "", "d", "Lkotlin/Lazy;", "b", "enableGlobal", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class NetworkCaptureSample {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy enableGlobal;

    /* renamed from: b, reason: collision with root package name */
    public static final NetworkCaptureSample f343708b = new NetworkCaptureSample();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureSample$enableGlobal$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                boolean z16;
                com.tencent.qmethod.monitor.config.bean.e eVar = ConfigManager.f343549h.p().g().get("func_traffic_user");
                if (eVar == null) {
                    Intrinsics.throwNpe();
                }
                com.tencent.qmethod.monitor.config.bean.e eVar2 = eVar;
                com.tencent.qmethod.monitor.utils.a aVar = com.tencent.qmethod.monitor.utils.a.f343870a;
                if (aVar.b("traffic_enable_global", 1)) {
                    z16 = com.tencent.qmethod.monitor.base.util.f.a("traffic_enable_global");
                } else {
                    aVar.a("traffic_enable_global");
                    boolean z17 = SampleHelper.z(SampleHelper.f343779l, eVar2.getRate(), 0, 0, 6, null);
                    o.a("NetworkCapture", "rate " + eVar2.getRate() + " ret " + z17);
                    com.tencent.qmethod.monitor.base.util.f.e("traffic_enable_global", z17);
                    z16 = z17;
                }
                return z16 && !aVar.b("traffic_report_count", eVar2.getMaxReport());
            }
        });
        enableGlobal = lazy;
    }

    NetworkCaptureSample() {
    }

    public final boolean a() {
        com.tencent.qmethod.monitor.config.bean.e eVar = ConfigManager.f343549h.p().g().get("func_traffic_event");
        if (eVar == null) {
            Intrinsics.throwNpe();
        }
        return SampleHelper.z(SampleHelper.f343779l, eVar.getRate(), 0, 0, 6, null);
    }

    public final boolean b() {
        return ((Boolean) enableGlobal.getValue()).booleanValue();
    }

    public final boolean c() {
        com.tencent.qmethod.monitor.config.bean.e eVar = ConfigManager.f343549h.p().g().get("func_traffic_user");
        if (eVar == null) {
            Intrinsics.throwNpe();
        }
        return com.tencent.qmethod.monitor.utils.a.f343870a.b("traffic_report_count", eVar.getMaxReport());
    }

    public final void d() {
        com.tencent.qmethod.monitor.utils.a.f343870a.a("traffic_report_count");
    }
}
