package ai2;

import com.tencent.mobileqq.qqguildsdk.tianjige.GuildGraySampleRate;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildPublicSampleRate;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002J.\u0010\u0014\u001a\u00020\u00132\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0002j\b\u0012\u0004\u0012\u00020\u000e`\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bJ\u001e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bJ2\u0010\u0018\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bJ3\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ>\u0010 \u001a\u00020\u00132&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u001c2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eJ>\u0010\"\u001a\u00020\u00132&\u0010\u001d\u001a\"\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u001c2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0003R0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020#0\u001bj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020#`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010$R0\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020&0\u001bj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020&`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010$\u00a8\u0006*"}, d2 = {"Lai2/b;", "", "Ljava/util/ArrayList;", "", "list", "", "c", "(Ljava/util/ArrayList;)[Ljava/lang/Double;", "", "policyNt", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildPublicSampleRate;", "b", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGraySampleRate;", "a", "", "Lkotlin/collections/ArrayList;", "names", "pubPolicy", "grayPolicy", "", "e", "name", "d", "boundary", "g", "f", "(Ljava/lang/String;[Ljava/lang/Double;II)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "label", "", "count", h.F, "value", "i", "Lai2/a;", "Ljava/util/HashMap;", "countMap", "Lai2/c;", "histogramMap", "<init>", "()V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f26109a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, CountInfo> countMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, HistogramInfo> histogramMap = new HashMap<>();

    b() {
    }

    private final GuildGraySampleRate a(int policyNt) {
        GuildGraySampleRate guildGraySampleRate = GuildGraySampleRate.GRAY_FULL;
        if (policyNt != guildGraySampleRate.getValue()) {
            GuildGraySampleRate guildGraySampleRate2 = GuildGraySampleRate.GRAY_MANAGE;
            if (policyNt != guildGraySampleRate2.getValue()) {
                return GuildGraySampleRate.GRAY_NONE;
            }
            return guildGraySampleRate2;
        }
        return guildGraySampleRate;
    }

    private final GuildPublicSampleRate b(int policyNt) {
        GuildPublicSampleRate guildPublicSampleRate = GuildPublicSampleRate.PUBLIC_FULL;
        if (policyNt != guildPublicSampleRate.getValue()) {
            GuildPublicSampleRate guildPublicSampleRate2 = GuildPublicSampleRate.PUBLIC_MANAGE;
            if (policyNt != guildPublicSampleRate2.getValue()) {
                return GuildPublicSampleRate.PUBLIC_NONE;
            }
            return guildPublicSampleRate2;
        }
        return guildPublicSampleRate;
    }

    private final Double[] c(ArrayList<Double> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(((Number) it.next()).doubleValue()));
        }
        Object[] array = arrayList.toArray(new Double[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (Double[]) array;
    }

    public final void d(@NotNull String name, int pubPolicy, int grayPolicy) {
        Intrinsics.checkNotNullParameter(name, "name");
        HashMap<String, CountInfo> hashMap = countMap;
        if (hashMap.containsKey(name)) {
            QLog.e("GuildNtMetricScene", 1, "registerCount, name:" + name + " already exist, pubPolicy:" + pubPolicy + ", grayPolicy:" + grayPolicy);
        }
        hashMap.put(name, new CountInfo(name, b(pubPolicy), a(grayPolicy)));
    }

    public final void e(@NotNull ArrayList<String> names, int pubPolicy, int grayPolicy) {
        Intrinsics.checkNotNullParameter(names, "names");
        for (String str : names) {
            if (str != null) {
                f26109a.d(str, pubPolicy, grayPolicy);
            }
        }
    }

    public final void f(@NotNull String name, @NotNull Double[] boundary, int pubPolicy, int grayPolicy) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        HashMap<String, HistogramInfo> hashMap = histogramMap;
        if (hashMap.containsKey(name)) {
            QLog.e("GuildNtMetricScene", 1, "registerHistogram, name:" + name + " already exist, pubPolicy:" + pubPolicy + ", grayPolicy:" + grayPolicy + ", boundary:" + boundary);
        }
        hashMap.put(name, new HistogramInfo(name, boundary, b(pubPolicy), a(grayPolicy)));
    }

    public final void g(@NotNull ArrayList<String> names, @NotNull ArrayList<Double> boundary, int pubPolicy, int grayPolicy) {
        boolean z16;
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        Double[] c16 = c(boundary);
        if (c16.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.e("GuildNtMetricScene", 1, "registerHistograms with empty boundary, names:" + names + ", " + boundary);
            return;
        }
        for (String str : names) {
            if (str != null) {
                f26109a.f(str, c16, pubPolicy, grayPolicy);
            }
        }
    }

    public final void h(@Nullable HashMap<String, String> label, @NotNull String name, long count) {
        Intrinsics.checkNotNullParameter(name, "name");
        CountInfo countInfo = countMap.get(name);
        if (countInfo == null) {
            QLog.e("GuildNtMetricScene", 1, "reportCount, not registered yet, label:" + label + " name:" + name + ", count:" + count + ", ");
            return;
        }
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricCountWithPolicy(countInfo, label, count);
    }

    public final void i(@Nullable HashMap<String, String> label, @NotNull String name, double value) {
        Intrinsics.checkNotNullParameter(name, "name");
        HistogramInfo histogramInfo = histogramMap.get(name);
        if (histogramInfo == null) {
            QLog.e("GuildNtMetricScene", 1, "reportHistogram, not registered yet, label:" + label + " name:" + name + ", value:" + value + ", ");
            return;
        }
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportHistogramWithPolicy(histogramInfo, label, value);
    }
}
