package com.tencent.qmethod.monitor.ext.overcall;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.ark.ark;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.report.PMonitorReporter;
import com.tencent.qmethod.pandoraex.api.n;
import com.tencent.qmethod.pandoraex.api.q;
import com.tencent.qmethod.pandoraex.api.t;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0004R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/overcall/OverCallMonitor;", "", "Lcom/tencent/qmethod/pandoraex/api/u;", "reportStrategy", "", "d", "", "f", ark.ARKMETADATA_JSON, "g", "c", "e", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "monitorList", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class OverCallMonitor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> monitorList;

    /* renamed from: b, reason: collision with root package name */
    public static final OverCallMonitor f343654b = new OverCallMonitor();

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"NI#G_HW_ADDR", "WI#G_BSSID", "BA#G_ADDR", "TM#G_DID", "SE#G_AID", "BU#MODEL", "TM#G_SID", "BU#SER", "SUBM#G_ATIVE_SUB#I", "TM#G_UICC_INFO", "TM#G_SIM_SE_NUM"});
        monitorList = listOf;
    }

    OverCallMonitor() {
    }

    private final void d(u reportStrategy) {
        b bVar = b.f343662a;
        bVar.e(f(reportStrategy));
        bVar.g();
    }

    private final String f(@NotNull u uVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("moduleName", uVar.f343964a);
        jSONObject.put("apiName", uVar.f343965b);
        jSONObject.put(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, uVar.f343968e);
        jSONObject.put("isCallSystemApi", uVar.f343969f);
        jSONObject.put("overCallTimes", uVar.f343987x);
        jSONObject.put("processName", uVar.f343979p);
        jSONObject.put("sdkVersion", uVar.f343978o);
        jSONObject.put("time", uVar.f343977n);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "JSONObject().apply {\n   \u2026ime)\n        }.toString()");
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final u g(String json) {
        List<t> listOf;
        try {
            JSONObject jSONObject = new JSONObject(json);
            u uVar = new u(jSONObject.optString("moduleName"), jSONObject.optString("apiName"));
            uVar.f343967d = "over_call";
            uVar.f343968e = jSONObject.optString(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY);
            uVar.f343969f = jSONObject.optBoolean("isCallSystemApi");
            uVar.f343987x = jSONObject.optInt("overCallTimes");
            uVar.f343979p = jSONObject.optString("processName");
            uVar.f343978o = jSONObject.optString("sdkVersion");
            uVar.f343977n = jSONObject.optLong("time");
            t tVar = new t();
            tVar.f343962b = "\u65e0\u5806\u6808";
            tVar.f343963c = 1;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(tVar);
            uVar.f343980q = listOf;
            return uVar;
        } catch (JSONException e16) {
            o.d("OverCallMonitor", "toReportStrategy: " + e16.getMessage(), e16);
            return null;
        }
    }

    @NotNull
    public final List<String> b() {
        return monitorList;
    }

    public final void c(@NotNull u reportStrategy) {
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        if (reportStrategy.f343969f && monitorList.contains(reportStrategy.f343965b) && a.f343661f.b(reportStrategy)) {
            d(reportStrategy);
        }
    }

    public final void e() {
        new Handler(ThreadManager.f343506c.b()).postDelayed(new Runnable() { // from class: com.tencent.qmethod.monitor.ext.overcall.OverCallMonitor$startReport$1
            @Override // java.lang.Runnable
            public final void run() {
                u g16;
                b bVar = b.f343662a;
                String c16 = bVar.c();
                if (c16 == null || TextUtils.isEmpty(c16)) {
                    return;
                }
                bVar.f();
                g16 = OverCallMonitor.f343654b.g(c16);
                if (g16 != null && (q.j() instanceof PMonitorReporter)) {
                    n j3 = q.j();
                    if (j3 != null) {
                        ((PMonitorReporter) j3).e(g16);
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.tencent.qmethod.monitor.report.PMonitorReporter");
                }
            }
        }, 5000L);
    }
}
