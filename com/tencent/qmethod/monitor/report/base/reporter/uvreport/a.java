package com.tencent.qmethod.monitor.report.base.reporter.uvreport;

import android.os.Handler;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.qmethod.monitor.base.thread.ThreadManager;
import com.tencent.qmethod.monitor.base.util.AppInfo;
import com.tencent.qmethod.monitor.base.util.NetworkUtil;
import com.tencent.qmethod.monitor.base.util.d;
import com.tencent.qmethod.monitor.config.ConfigManager;
import com.tencent.qmethod.monitor.config.bean.e;
import com.tencent.qmethod.monitor.report.SampleHelper;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import com.tencent.qmethod.pandoraex.core.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import or3.c;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pr3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\b\u001a\u00020\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/reporter/uvreport/a;", "Landroid/os/Handler;", "", "fistReport", "", "a", "", "b", "c", "Z", "started", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a extends Handler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean started;

    /* renamed from: b, reason: collision with root package name */
    public static final a f343854b = new a();

    a() {
        super(ThreadManager.f343506c.b());
    }

    private final synchronized void a(boolean fistReport) {
        if (started) {
            AppInfo.Companion companion = AppInfo.INSTANCE;
            if (com.tencent.qmethod.pandoraex.core.collector.utils.a.j(companion.a())) {
                if (d.c(d.f343534a, 1, "KEY_DAU_REPORT", 0, 4, null)) {
                    o.a("UVEventReport", "ignore dau report because of limit");
                    return;
                }
                if (!SampleHelper.f343779l.q().get()) {
                    o.a("UVEventReport", "ignore dau report because of sample rate");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("process_name", companion.c(companion.a()));
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.mo162put("compliance.api");
                    jSONObject.put("features_enabled", jSONArray);
                    jSONObject.put("first_report", fistReport);
                    jSONObject.put("dau_rate_count", b());
                    JSONObject f16 = b.f(b.f427061b, "metric", "dau_compliance", 0L, 4, null);
                    NetworkUtil networkUtil = NetworkUtil.f343513c;
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "attributes.toString()");
                    f16.put(ReportDataBuilder.KEY_ATTRIBUTES, networkUtil.a(jSONObject2));
                    or3.d.f423470e.a(new ReportData(f16, true), new C9337a());
                } catch (JSONException e16) {
                    o.d("UVEventReport", "reportInternal", e16);
                }
                d.f343534a.d(1, "KEY_DAU_REPORT");
                AppConfigReport.f343851a.h();
            }
        }
    }

    private final int b() {
        double d16;
        int roundToInt;
        e eVar = ConfigManager.f343549h.p().g().get(ReadInJoyMMapKvStorage.NAME_DEFAULT);
        if (eVar != null) {
            d16 = eVar.getRate();
        } else {
            d16 = 0.0d;
        }
        if (d16 != 0.0d) {
            roundToInt = MathKt__MathJVMKt.roundToInt(1.0d / d16);
            return roundToInt;
        }
        return 1;
    }

    public final void c() {
        if (!started) {
            started = true;
            a(true);
        } else {
            o.c("UVEventReport", "\u91cd\u590d\u542f\u52a8DAU\u4e0a\u62a5");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qmethod/monitor/report/base/reporter/uvreport/a$a", "Lor3/c$a;", "", "dbId", "", "onSuccess", "errorCode", "", "errorMsg", "a", "onCached", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qmethod.monitor.report.base.reporter.uvreport.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9337a implements c.a {
        C9337a() {
        }

        @Override // or3.c.a
        public void a(int errorCode, @NotNull String errorMsg, int dbId) {
            Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
            o.c("UVEventReport", "report dau Internal fail! errorCode = " + errorCode + ", errorMsg = " + errorMsg);
            d.f343534a.e(1, "KEY_DAU_REPORT");
        }

        @Override // or3.c.a
        public void onSuccess(int dbId) {
            o.e("UVEventReport", "report dau Internal success!");
        }

        @Override // or3.c.a
        public void onCached() {
        }
    }
}
