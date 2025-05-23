package com.tencent.qmethod.monitor.ext.traffic;

import android.os.Handler;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.NetworkUtil;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import or3.c;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\n\u001a\u00020\b*\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\r\u001a\u00020\b*\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016R\u001a\u0010\u0018\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010!\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b\u001b\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/f;", "Lor3/c$a;", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureBaseTask;", "checker", "", AdMetricTag.Report.TYPE, "Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "b", "Lorg/json/JSONObject;", "reqChecker", "g", "", "stack", tl.h.F, "", "i", "dbId", "onSuccess", "errorCode", "errorMsg", "a", "I", "f", "()I", "REPORT_TYPE_SENSITIVE_FIELD", "e", "REPORT_TYPE_OVERCALL", "c", "d", "REPORT_TYPE_HTTPPLAIN", "Landroid/os/Handler;", "Landroid/os/Handler;", "()Landroid/os/Handler;", "handler", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class f implements c.a {

    /* renamed from: e, reason: collision with root package name */
    public static final f f343729e = new f();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final int REPORT_TYPE_SENSITIVE_FIELD = 1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int REPORT_TYPE_OVERCALL = 2;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int REPORT_TYPE_HTTPPLAIN = 3;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler handler = new Handler(ThreadManager.f343506c.b());

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class a<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(((NetworkCaptureRule) t16).getSensitiveCategory(), ((NetworkCaptureRule) t17).getSensitiveCategory());
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public static final class b<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(((NetworkCaptureRule) t16).getSensitiveCategory(), ((NetworkCaptureRule) t17).getSensitiveCategory());
            return compareValues;
        }
    }

    f() {
    }

    private final ReportData b(NetworkCaptureBaseTask checker, int reportType) {
        JSONObject f16 = pr3.b.f(pr3.b.f427061b, "compliance", "network_capture", 0L, 4, null);
        NetworkUtil networkUtil = NetworkUtil.f343513c;
        f fVar = f343729e;
        String jSONObject = fVar.g(new JSONObject(), checker, reportType).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "JSONObject().putAttribut\u2026r, reportType).toString()");
        f16.put(ReportDataBuilder.KEY_ATTRIBUTES, networkUtil.a(jSONObject));
        String jSONObject2 = fVar.h(new JSONObject(), checker.getStack()).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "JSONObject().putBodyRepo\u2026checker.stack).toString()");
        JSONObject put = f16.put(ReportDataBuilder.KEY_BODY, networkUtil.a(jSONObject2));
        Intrinsics.checkExpressionValueIsNotNull(put, "ReportDataBuilder.makePa\u2026oString()))\n            }");
        return new ReportData(put, false, 2, null);
    }

    private final JSONObject g(@NotNull JSONObject jSONObject, NetworkCaptureBaseTask networkCaptureBaseTask, int i3) {
        List distinct;
        List sortedWith;
        List distinct2;
        List sortedWith2;
        jSONObject.put("url", networkCaptureBaseTask.getUrl());
        jSONObject.put("request_time_mills", networkCaptureBaseTask.getRequestTimeMills());
        jSONObject.put("request_source", networkCaptureBaseTask.getRequestSource());
        if (i3 == REPORT_TYPE_SENSITIVE_FIELD) {
            JSONArray jSONArray = new JSONArray();
            distinct2 = CollectionsKt___CollectionsKt.distinct(networkCaptureBaseTask.m());
            sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(distinct2, new a());
            Iterator it = sortedWith2.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(((NetworkCaptureRule) it.next()).getSensitiveCategory());
            }
            jSONObject.put("collect_data", jSONArray);
            jSONObject.put("origin_data", networkCaptureBaseTask.i());
            jSONObject.put("is_front_ground", networkCaptureBaseTask.getIsBackground() ? 1 : 0);
            jSONObject.put("is_plain_text", Intrinsics.areEqual("HTTP", networkCaptureBaseTask.getRequestSource()) ? 1 : 0);
            jSONObject.put("is_agree_before", networkCaptureBaseTask.getIsAgreeBefore() ? 1 : 0);
            jSONObject.put("is_share_data", networkCaptureBaseTask.t() ? 1 : 0);
        } else if (i3 == REPORT_TYPE_OVERCALL) {
            JSONArray jSONArray2 = new JSONArray();
            distinct = CollectionsKt___CollectionsKt.distinct(networkCaptureBaseTask.m());
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(distinct, new b());
            Iterator it5 = sortedWith.iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(((NetworkCaptureRule) it5.next()).getSensitiveCategory());
            }
            jSONObject.put("collect_data", jSONArray2);
            jSONObject.put("origin_data", networkCaptureBaseTask.i());
            jSONObject.put("is_front_ground", networkCaptureBaseTask.getIsBackground() ? 1 : 0);
            jSONObject.put("is_plain_text", Intrinsics.areEqual("HTTP", networkCaptureBaseTask.getRequestSource()) ? 1 : 0);
            jSONObject.put("is_agree_before", networkCaptureBaseTask.getIsAgreeBefore() ? 1 : 0);
            jSONObject.put("is_share_data", networkCaptureBaseTask.t() ? 1 : 0);
            jSONObject.put("over_trans_times", networkCaptureBaseTask.getOverCallCount());
        } else if (i3 == REPORT_TYPE_HTTPPLAIN) {
            jSONObject.put("is_http_insecure", 1);
            jSONObject.put("is_front_ground", networkCaptureBaseTask.getIsBackground() ? 1 : 0);
            jSONObject.put("is_plain_text", Intrinsics.areEqual("HTTP", networkCaptureBaseTask.getRequestSource()) ? 1 : 0);
            jSONObject.put("is_agree_before", networkCaptureBaseTask.getIsAgreeBefore() ? 1 : 0);
            jSONObject.put("is_share_data", networkCaptureBaseTask.t() ? 1 : 0);
        }
        return jSONObject;
    }

    private final JSONObject h(@NotNull JSONObject jSONObject, String str) {
        if (str != null && (!Intrinsics.areEqual(str, ""))) {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("count", 1);
            jSONObject2.put("call_stack", str);
            jSONArray.mo162put(jSONObject2);
            jSONObject.put("stacks", jSONArray);
        }
        return jSONObject;
    }

    @Override // or3.c.a
    public void a(int errorCode, @NotNull String errorMsg, int dbId) {
        Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
        o.a("NetworkCapture", "onFailure dbId " + dbId + "errorMsg " + errorMsg);
    }

    @NotNull
    public final Handler c() {
        return handler;
    }

    public final int d() {
        return REPORT_TYPE_HTTPPLAIN;
    }

    public final int e() {
        return REPORT_TYPE_OVERCALL;
    }

    public final int f() {
        return REPORT_TYPE_SENSITIVE_FIELD;
    }

    public final void i(@NotNull NetworkCaptureBaseTask checker, int reportType) {
        Intrinsics.checkParameterIsNotNull(checker, "checker");
        or3.d.f423470e.c(b(checker, reportType), this, true);
    }

    @Override // or3.c.a
    public void onCached() {
        c.a.C10936a.a(this);
    }

    @Override // or3.c.a
    public void onSuccess(int dbId) {
        o.a("NetworkCapture", "onSuccess dbId " + dbId);
    }
}
