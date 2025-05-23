package com.tencent.mobileqq.perf.report.opentelemetry;

import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianjige.a;
import com.tencent.mobileqq.tianjige.metric.d;
import com.tencent.mobileqq.tianjige.metric.f;
import com.tencent.mobileqq.tianjige.metric.h;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J!\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\f\u0010\rJJ\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0011H\u0007R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0010j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/perf/report/opentelemetry/a;", "", "Lcom/tencent/mobileqq/tianjige/metric/h;", "c", "", "metricName", "eventType", "Lcom/tencent/mobileqq/tianjige/metric/d;", "b", "type", "", "", "a", "(Ljava/lang/String;)[Ljava/lang/Double;", "", "value", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInitMetric", "Ljava/util/HashMap;", "perfHistogramMap", "Lcom/tencent/mobileqq/tianjige/metric/h;", "perfRecorder", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f258018a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final AtomicBoolean hasInitMetric;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, d> perfHistogramMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static h perfRecorder;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35213);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f258018a = new a();
        hasInitMetric = new AtomicBoolean(false);
        perfHistogramMap = new HashMap<>();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Double[] a(String type) {
        int hashCode;
        if (type != null && ((hashCode = type.hashCode()) == -640368431 ? type.equals("coldCost") : hashCode == -632148676 ? type.equals("actLoginS") : !(hashCode != -19480352 || !type.equals("sysLaunch")))) {
            return new Double[]{Double.valueOf(10.0d), Double.valueOf(500.0d), Double.valueOf(1000.0d), Double.valueOf(2000.0d), Double.valueOf(3000.0d), Double.valueOf(4000.0d), Double.valueOf(5000.0d), Double.valueOf(10000.0d), Double.valueOf(30000.0d)};
        }
        return null;
    }

    private final d b(String metricName, String eventType) {
        HashMap<String, d> hashMap = perfHistogramMap;
        if (hashMap.containsKey(metricName)) {
            return hashMap.get(metricName);
        }
        d f16 = c().f(metricName, a(eventType));
        Intrinsics.checkNotNullExpressionValue(f16, "this");
        hashMap.put(metricName, f16);
        QLog.d("QQPerfOpenTelemetry", 1, "finish create histogram:" + metricName);
        return f16;
    }

    private final h c() {
        String str;
        boolean z16 = false;
        if (hasInitMetric.compareAndSet(false, true)) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 26 && i3 != 27) {
                z16 = true;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentAccountUin();
            } else {
                str = null;
            }
            f.d(1, new a.C8649a().o("qq").m(0.5d).p(str).l(AppSetting.n()).n(z16).k());
            h b16 = f.b(1);
            Intrinsics.checkNotNullExpressionValue(b16, "getMetricRecorder(QQOpen\u2026tants.BusinessId.QQ_PERF)");
            perfRecorder = b16;
            QLog.d("QQPerfOpenTelemetry", 1, "finish init metricConfig and perfRecorder");
        }
        h hVar = perfRecorder;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("perfRecorder");
            return null;
        }
        return hVar;
    }

    @JvmStatic
    public static final void d(@NotNull String metricName, long value, @Nullable String eventType, @Nullable HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(metricName, "metricName");
        if (params == null) {
            params = new HashMap<>();
        }
        if (eventType != null) {
            params.put(CGNonAgeReport.EVENT_TYPE, eventType);
        }
        params.put("app_version", AppSetting.n());
        params.put("is_gray", "false");
        d b16 = f258018a.b(metricName, eventType);
        if (b16 != null) {
            b16.c(value, params);
        }
    }
}
