package com.tencent.mobileqq.tianjige.ntkernel;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianjige.ntkernel.NtMetricParser;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bB\u0010CJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J5\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J@\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J.\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J#\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0!H\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0004H\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010%\u001a\u00020\u0004H\u0002J.\u0010,\u001a\u00020\u00072\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00020!j\b\u0012\u0004\u0012\u00020\u0002`*2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J2\u0010-\u001a\u00020\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020!2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0!2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J>\u0010/\u001a\u00020\u00072&\u0010.\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J>\u00101\u001a\u00020\u00072&\u0010.\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020\nR\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R0\u00107\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002050\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000205`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00106R0\u00108\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0016`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u00106R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001d098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010:R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010:R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010>\u001a\u0004\b?\u0010@\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/tianjige/ntkernel/NtKernelMetricHelper;", "", "", "name", "", "pubPolicy", "grayPolicy", "", "j", "", "", "boundary", "l", "(Ljava/lang/String;[Ljava/lang/Double;II)V", "", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "", "count", "o", "Lcom/tencent/mobileqq/tianjige/ntkernel/b;", "histogramInfo", "", "map", "duration", "r", "type", "Lcom/tencent/mobileqq/tianjige/metric/a;", h.F, "Lcom/tencent/mobileqq/tianjige/metric/d;", "g", "Ljava/util/ArrayList;", "list", "f", "(Ljava/util/ArrayList;)[Ljava/lang/Double;", "policyNt", "Lcom/tencent/mobileqq/tianjige/ntkernel/PublicSampleRate;", "e", "Lcom/tencent/mobileqq/tianjige/ntkernel/GraySampleRate;", "d", "Lkotlin/collections/ArrayList;", "names", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "label", DomainData.DOMAIN_NAME, "value", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b", "[Ljava/lang/Double;", "defaultHistogramBoundary", "Lcom/tencent/mobileqq/tianjige/ntkernel/a;", "Ljava/util/HashMap;", "ntCountInfo", "ntHistogramInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "counters", "histograms", "Lcom/tencent/mobileqq/tianjige/metric/h;", "Lkotlin/Lazy;", "i", "()Lcom/tencent/mobileqq/tianjige/metric/h;", "metricRecorder", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NtKernelMetricHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NtKernelMetricHelper f292997a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Double[] defaultHistogramBoundary;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, a> ntCountInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, b> ntHistogramInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, com.tencent.mobileqq.tianjige.metric.a> counters;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, com.tencent.mobileqq.tianjige.metric.d> histograms;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy metricRecorder;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34579);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f292997a = new NtKernelMetricHelper();
        defaultHistogramBoundary = new Double[]{Double.valueOf(0.0d), Double.valueOf(1.0d), Double.valueOf(10.0d), Double.valueOf(25.0d), Double.valueOf(50.0d), Double.valueOf(100.0d), Double.valueOf(250.0d), Double.valueOf(500.0d), Double.valueOf(750.0d), Double.valueOf(1000.0d), Double.valueOf(2500.0d), Double.valueOf(5000.0d), Double.valueOf(10000.0d), Double.valueOf(20000.0d)};
        ntCountInfo = new HashMap<>();
        ntHistogramInfo = new HashMap<>();
        counters = new ConcurrentHashMap<>();
        histograms = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(NtKernelMetricHelper$metricRecorder$2.INSTANCE);
        metricRecorder = lazy;
    }

    NtKernelMetricHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean c(String name) {
        double a16;
        NtMetricParser.b bVar = (NtMetricParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("base_opentelemetry_config");
        if (bVar == null) {
            return false;
        }
        Double d16 = bVar.b().get(name);
        if (d16 != null) {
            a16 = d16.doubleValue();
        } else {
            a16 = bVar.a();
        }
        if (a16 <= 0.0d || Math.random() >= a16) {
            return false;
        }
        return true;
    }

    private final GraySampleRate d(int policyNt) {
        GraySampleRate graySampleRate = GraySampleRate.GRAY_FULL;
        if (policyNt != graySampleRate.getValue()) {
            GraySampleRate graySampleRate2 = GraySampleRate.GRAY_MANAGE;
            if (policyNt != graySampleRate2.getValue()) {
                return GraySampleRate.GRAY_NONE;
            }
            return graySampleRate2;
        }
        return graySampleRate;
    }

    private final PublicSampleRate e(int policyNt) {
        PublicSampleRate publicSampleRate = PublicSampleRate.PUBLIC_FULL;
        if (policyNt != publicSampleRate.getValue()) {
            PublicSampleRate publicSampleRate2 = PublicSampleRate.PUBLIC_MANAGE;
            if (policyNt != publicSampleRate2.getValue()) {
                return PublicSampleRate.PUBLIC_NONE;
            }
            return publicSampleRate2;
        }
        return publicSampleRate;
    }

    private final Double[] f(ArrayList<Double> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(((Number) it.next()).doubleValue()));
        }
        Object[] array = arrayList.toArray(new Double[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Double[]) array;
    }

    private final com.tencent.mobileqq.tianjige.metric.d g(b histogramInfo) {
        ConcurrentHashMap<String, com.tencent.mobileqq.tianjige.metric.d> concurrentHashMap = histograms;
        if (!concurrentHashMap.containsKey(histogramInfo.b())) {
            String b16 = histogramInfo.b();
            com.tencent.mobileqq.tianjige.metric.d f16 = i().f(histogramInfo.b(), histogramInfo.a());
            Intrinsics.checkNotNullExpressionValue(f16, "metricRecorder.createHis\u2026, histogramInfo.boundary)");
            concurrentHashMap.put(b16, f16);
        }
        return concurrentHashMap.get(histogramInfo.b());
    }

    private final com.tencent.mobileqq.tianjige.metric.a h(String type) {
        ConcurrentHashMap<String, com.tencent.mobileqq.tianjige.metric.a> concurrentHashMap = counters;
        if (!concurrentHashMap.containsKey(type)) {
            com.tencent.mobileqq.tianjige.metric.a b16 = i().b(type);
            Intrinsics.checkNotNullExpressionValue(b16, "metricRecorder.createCounter(type)");
            concurrentHashMap.put(type, b16);
        }
        return concurrentHashMap.get(type);
    }

    private final com.tencent.mobileqq.tianjige.metric.h i() {
        Object value = metricRecorder.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-metricRecorder>(...)");
        return (com.tencent.mobileqq.tianjige.metric.h) value;
    }

    private final void j(String name, int pubPolicy, int grayPolicy) {
        HashMap<String, a> hashMap = ntCountInfo;
        if (hashMap.containsKey(name)) {
            QLog.e("NtKernelMetricHelper", 1, "registerCount, name:" + name + " already exist, pubPolicy:" + pubPolicy + ", grayPolicy:" + grayPolicy);
        }
        hashMap.put(name, new a(name, e(pubPolicy), d(grayPolicy)));
    }

    private final void l(String name, Double[] boundary, int pubPolicy, int grayPolicy) {
        HashMap<String, b> hashMap = ntHistogramInfo;
        if (hashMap.containsKey(name)) {
            QLog.e("NtKernelMetricHelper", 1, "registerHistogram, name:" + name + " already exist, pubPolicy:" + pubPolicy + ", grayPolicy:" + grayPolicy + ", boundary:" + boundary);
        }
        hashMap.put(name, new b(name, boundary, e(pubPolicy), d(grayPolicy)));
    }

    private final void o(final String name, final HashMap<String, String> params, final long count) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.tianjige.ntkernel.c
            @Override // java.lang.Runnable
            public final void run() {
                NtKernelMetricHelper.p(name, count, params);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(String name, long j3, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(name, "$name");
        QLog.d("NtKernelMetricHelper", 4, "reportCountReal " + name);
        com.tencent.mobileqq.tianjige.metric.a h16 = f292997a.h(name);
        if (h16 != null) {
            h16.c(j3, hashMap);
        }
    }

    private final void r(final b histogramInfo, final Map<String, String> map, final double duration) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.tianjige.ntkernel.d
            @Override // java.lang.Runnable
            public final void run() {
                NtKernelMetricHelper.s(b.this, duration, map);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(b histogramInfo, double d16, Map map) {
        Intrinsics.checkNotNullParameter(histogramInfo, "$histogramInfo");
        QLog.d("NtKernelMetricHelper", 4, "reportHistogramReal " + histogramInfo.b());
        com.tencent.mobileqq.tianjige.metric.d g16 = f292997a.g(histogramInfo);
        if (g16 != null) {
            g16.b(d16, map);
        }
    }

    public final void k(@NotNull ArrayList<String> names, int pubPolicy, int grayPolicy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, names, Integer.valueOf(pubPolicy), Integer.valueOf(grayPolicy));
            return;
        }
        Intrinsics.checkNotNullParameter(names, "names");
        for (String str : names) {
            if (str != null) {
                f292997a.j(str, pubPolicy, grayPolicy);
            }
        }
    }

    public final void m(@NotNull ArrayList<String> names, @NotNull ArrayList<Double> boundary, int pubPolicy, int grayPolicy) {
        Double[] f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, names, boundary, Integer.valueOf(pubPolicy), Integer.valueOf(grayPolicy));
            return;
        }
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        if (boundary.isEmpty()) {
            f16 = defaultHistogramBoundary;
        } else {
            f16 = f(boundary);
        }
        if (f16.length == 0) {
            z16 = true;
        }
        if (z16) {
            QLog.e("NtKernelMetricHelper", 1, "registerHistograms with empty boundary, names:" + names + ", " + boundary);
            return;
        }
        for (String str : names) {
            if (str != null) {
                f292997a.l(str, f16, pubPolicy, grayPolicy);
            }
        }
    }

    public final void n(@Nullable HashMap<String, String> label, @NotNull String name, long count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, label, name, Long.valueOf(count));
            return;
        }
        Intrinsics.checkNotNullParameter(name, "name");
        if (ntCountInfo.get(name) == null) {
            QLog.e("NtKernelMetricHelper", 1, "reportCount, not registered yet, label:" + label + " name:" + name + ", count:" + count + ", ");
            return;
        }
        if (c(name)) {
            o(name, label, count);
        }
    }

    public final void q(@Nullable HashMap<String, String> label, @NotNull String name, double value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, label, name, Double.valueOf(value));
            return;
        }
        Intrinsics.checkNotNullParameter(name, "name");
        b bVar = ntHistogramInfo.get(name);
        if (bVar == null) {
            QLog.e("NtKernelMetricHelper", 1, "reportHistogram, not registered yet, label:" + label + " name:" + name + ", value:" + value + ", ");
            return;
        }
        if (c(name)) {
            r(bVar, label, value);
        }
    }
}
