package com.tencent.qmethod.monitor.report.api;

import android.os.Handler;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.f;
import com.tencent.qmethod.pandoraex.api.t;
import com.tencent.qmethod.pandoraex.api.u;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000f\u0010\r\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R0\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a`\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/qmethod/monitor/report/api/ApiInvokeAnalyse;", "", "Lcom/tencent/qmethod/pandoraex/api/u;", "reportStrategy", "", "d", "g", "b", "", DTConstants.TAG.API, "", "rate", h.F, "e", "()V", "f", "c", "(Lcom/tencent/qmethod/pandoraex/api/u;)V", "", "<set-?>", "a", "Z", "()Z", "hadInit", "Ljava/util/HashMap;", "", "Lcom/tencent/qmethod/monitor/report/api/b;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "invokeRecords", "", "J", "sdkStartTime", "<init>", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class ApiInvokeAnalyse {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean hadInit;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long sdkStartTime;

    /* renamed from: d, reason: collision with root package name */
    public static final ApiInvokeAnalyse f343783d = new ApiInvokeAnalyse();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<Integer, ApiInvokeRecord> invokeRecords = new HashMap<>();

    ApiInvokeAnalyse() {
    }

    private final void d(u reportStrategy) {
        Object firstOrNull;
        String str;
        boolean z16;
        List<t> list = reportStrategy.f343980q;
        Intrinsics.checkExpressionValueIsNotNull(list, "reportStrategy.reportStackItems");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
        t tVar = (t) firstOrNull;
        if (tVar != null) {
            str = tVar.f343962b;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            o.c("APIInvokeAnalyse", "\u8b66\u544a\uff1a\u5806\u6808\u4e3a\u7a7a");
            return;
        }
        HashMap<Integer, ApiInvokeRecord> hashMap = invokeRecords;
        Integer valueOf = Integer.valueOf(str.hashCode());
        ApiInvokeRecord apiInvokeRecord = hashMap.get(Integer.valueOf(str.hashCode()));
        if (apiInvokeRecord == null) {
            apiInvokeRecord = new ApiInvokeRecord(null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 4194303, null);
        }
        apiInvokeRecord.w(reportStrategy, str);
        Intrinsics.checkExpressionValueIsNotNull(apiInvokeRecord, "(invokeRecords[stackStr.\u2026tegy, stackStr)\n        }");
        hashMap.put(valueOf, apiInvokeRecord);
        a.a("\u5b58\u50a8API\u6267\u884c\uff0c\u5806\u6808\u4e2a\u6570\uff1a" + hashMap.keySet().size());
        a.a("\u5b58\u50a8API\u6267\u884c\uff0c" + hashMap.get(Integer.valueOf(str.hashCode())));
        a.a("\u6240\u6709\u5b58\u50a8\uff1a" + hashMap);
        g();
    }

    private final void g() {
        String a16 = c.f343818c.a();
        JSONArray jSONArray = new JSONArray();
        Collection<ApiInvokeRecord> values = invokeRecords.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "invokeRecords.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(((ApiInvokeRecord) it.next()).x());
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONArray2, "JSONArray().apply {\n    \u2026   }\n        }.toString()");
        f.g(a16, jSONArray2);
    }

    public final boolean a() {
        return hadInit;
    }

    public final void b() {
        if (!hadInit) {
            com.tencent.qmethod.monitor.base.util.h hVar = com.tencent.qmethod.monitor.base.util.h.f343541c;
            hVar.e("APIInvokeAnalyse_INIT");
            sdkStartTime = System.currentTimeMillis();
            hVar.b("APIInvokeAnalyse_INIT");
            hadInit = true;
        }
    }

    public final void c(@NotNull u reportStrategy) {
        Intrinsics.checkParameterIsNotNull(reportStrategy, "reportStrategy");
        a.a("onApiInvoke, module:" + reportStrategy.f343964a + ", api:" + reportStrategy.f343965b);
        synchronized (ApiInvokeAnalyse.class) {
            if (!hadInit) {
                a.a("onApiInvoke-\u672a\u521d\u59cb\u5316");
            } else {
                if (!com.tencent.qmethod.monitor.report.sample.b.f343868c.c(1, reportStrategy)) {
                    a.a("onApiInvoke-\u672a\u547d\u4e2dAPI\u91c7\u6837");
                    return;
                }
                ApiInvokeReporter.f343787c.e();
                f343783d.d(reportStrategy);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void e() {
        if (ApiInvokeSample.f343792c.c()) {
            f.f(c.f343818c.b(), sdkStartTime);
        }
    }

    public final void f() {
        if (!hadInit) {
            return;
        }
        new Handler(ThreadManager.f343506c.b()).postDelayed(new Runnable() { // from class: com.tencent.qmethod.monitor.report.api.ApiInvokeAnalyse$reportLastAnalyseDelay$1
            @Override // java.lang.Runnable
            public final void run() {
                ApiInvokeReporter.f343787c.e();
            }
        }, 5000L);
    }

    public final void h(@NotNull String api, double rate) {
        Intrinsics.checkParameterIsNotNull(api, "api");
        ApiInvokeSample.f343792c.b().put(api, Double.valueOf(rate));
    }
}
