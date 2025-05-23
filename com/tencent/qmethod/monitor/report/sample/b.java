package com.tencent.qmethod.monitor.report.sample;

import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.pandoraex.api.m;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.api.v;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sr3.c;
import sr3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qmethod/monitor/report/sample/b;", "Lcom/tencent/qmethod/pandoraex/api/m;", "", "module", "apiName", "Lcom/tencent/qmethod/pandoraex/api/v;", TransferConfig.ExtendParamFloats.KEY_RULE, "", "b", "a", "", "type", "Lcom/tencent/qmethod/pandoraex/api/u;", "reportStrategy", "c", "(ILcom/tencent/qmethod/pandoraex/api/u;)Z", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isUITest", "", "Lsr3/b;", "Ljava/util/Map;", "controllerList", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b implements m {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<Integer, sr3.b> controllerList;

    /* renamed from: c, reason: collision with root package name */
    public static final b f343868c = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isUITest = new AtomicBoolean(false);

    static {
        Map<Integer, sr3.b> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new sr3.a()), TuplesKt.to(2, new d()), TuplesKt.to(3, new c()));
        controllerList = mapOf;
    }

    b() {
    }

    @Override // com.tencent.qmethod.pandoraex.api.m
    public boolean a() {
        return SampleHelper.f343779l.u();
    }

    @Override // com.tencent.qmethod.pandoraex.api.m
    public boolean b(@Nullable String module, @Nullable String apiName, @Nullable v rule) {
        boolean z16 = true;
        if (isUITest.get()) {
            return true;
        }
        boolean z17 = false;
        if (module != null && apiName != null && rule != null) {
            for (Map.Entry<Integer, sr3.b> entry : controllerList.entrySet()) {
                boolean e16 = entry.getValue().e(module, apiName, rule);
                String d16 = entry.getValue().d(module, apiName, rule);
                if (e16) {
                    entry.getValue().a(d16);
                    z17 = true;
                }
                if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                    o.a("PMonitorReportControl", "tryAddToken=" + d16 + ", " + entry.getValue().c() + " = " + e16);
                }
            }
            return z17;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("check fail, module=");
        sb5.append(module);
        sb5.append(", apiName= ");
        sb5.append(apiName);
        sb5.append(", rule = ");
        if (rule != null) {
            z16 = false;
        }
        sb5.append(z16);
        o.c("PMonitorReportControl", sb5.toString());
        return false;
    }

    public final boolean c(int type, @NotNull u reportStrategy) {
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        String str = reportStrategy.f343964a + reportStrategy.f343965b + reportStrategy.f343967d + reportStrategy.f343968e;
        sr3.b bVar = controllerList.get(Integer.valueOf(type));
        if (bVar != null) {
            return bVar.b(str);
        }
        if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
            o.a("PMonitorReportControl", "consumeToken=" + str + ", type=" + type + ", result=false");
        }
        return false;
    }
}
