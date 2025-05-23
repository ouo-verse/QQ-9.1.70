package com.tencent.mobileqq.guild.util.performance;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildGaugeNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import f12.o;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/util/performance/h;", "", "", "e", "Lcom/tencent/mobileqq/guild/util/performance/h$a;", "b", "", "path", "", "g", "(Ljava/lang/String;)Ljava/lang/Double;", FaceUtil.IMG_TEMP, "", "f", "c", tl.h.F, "", "Ljava/util/List;", "CPU_TEMP_FILE_PATHS", "Lcom/tencent/mobileqq/guild/util/performance/h$a;", "getCTempResult", "()Lcom/tencent/mobileqq/guild/util/performance/h$a;", "setCTempResult", "(Lcom/tencent/mobileqq/guild/util/performance/h$a;)V", "cTempResult", "d", "D", "getCTempDiff", "()D", "setCTempDiff", "(D)V", "cTempDiff", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f235590a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> CPU_TEMP_FILE_PATHS;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static CpuTemperatureResult cTempResult;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static double cTempDiff;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/util/performance/h$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "filePath", "", "b", "D", "()D", FaceUtil.IMG_TEMP, "<init>", "(Ljava/lang/String;D)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.util.performance.h$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class CpuTemperatureResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String filePath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final double temp;

        public CpuTemperatureResult() {
            this(null, 0.0d, 3, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getFilePath() {
            return this.filePath;
        }

        /* renamed from: b, reason: from getter */
        public final double getTemp() {
            return this.temp;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CpuTemperatureResult)) {
                return false;
            }
            CpuTemperatureResult cpuTemperatureResult = (CpuTemperatureResult) other;
            if (Intrinsics.areEqual(this.filePath, cpuTemperatureResult.filePath) && Double.compare(this.temp, cpuTemperatureResult.temp) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.filePath.hashCode() * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.temp);
        }

        @NotNull
        public String toString() {
            return "CpuTemperatureResult(filePath=" + this.filePath + ", temp=" + this.temp + ")";
        }

        public CpuTemperatureResult(@NotNull String filePath, double d16) {
            Intrinsics.checkNotNullParameter(filePath, "filePath");
            this.filePath = filePath;
            this.temp = d16;
        }

        public /* synthetic */ CpuTemperatureResult(String str, double d16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0.0d : d16);
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"/sys/class/thermal/thermal_zone1/temp", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/thermal/thermal_zone0/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/devices/platform/s5p-tmu/curr_temp"});
        CPU_TEMP_FILE_PATHS = listOf;
    }

    h() {
    }

    private final CpuTemperatureResult b() {
        int collectionSizeOrDefault;
        Object obj;
        boolean z16;
        List<String> list = CPU_TEMP_FILE_PATHS;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : list) {
            h hVar = f235590a;
            Double g16 = hVar.g(str);
            String str2 = "";
            double d16 = 0.0d;
            if (g16 != null) {
                double doubleValue = g16.doubleValue();
                if (!hVar.f(doubleValue) && !hVar.f(doubleValue / 1000)) {
                    str = "";
                } else {
                    d16 = doubleValue;
                }
                str2 = str;
            }
            arrayList.add(new CpuTemperatureResult(str2, d16));
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((CpuTemperatureResult) obj).getFilePath().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (CpuTemperatureResult) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        f235590a.e();
    }

    private final synchronized void e() {
        Double d16;
        CpuTemperatureResult cpuTemperatureResult = cTempResult;
        if (cpuTemperatureResult == null) {
            cTempResult = b();
        } else {
            Intrinsics.checkNotNull(cpuTemperatureResult);
            Double g16 = g(cpuTemperatureResult.getFilePath());
            if (g16 != null) {
                double doubleValue = g16.doubleValue();
                CpuTemperatureResult cpuTemperatureResult2 = cTempResult;
                Intrinsics.checkNotNull(cpuTemperatureResult2);
                d16 = Double.valueOf(doubleValue - cpuTemperatureResult2.getTemp());
            } else {
                d16 = null;
            }
            if (d16 != null) {
                double doubleValue2 = d16.doubleValue();
                double d17 = 1000;
                cTempDiff = f235590a.f(doubleValue2 / d17) ? RangesKt___RangesKt.coerceAtLeast(cTempDiff, doubleValue2) : RangesKt___RangesKt.coerceAtLeast(cTempDiff, doubleValue2 * d17);
            }
        }
    }

    private final boolean f(double temp) {
        if (-30.0d > temp || temp > 250.0d) {
            return false;
        }
        return true;
    }

    private final Double g(String path) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            String readLine = randomAccessFile.readLine();
            randomAccessFile.close();
            return Double.valueOf(Double.parseDouble(readLine));
        } catch (NumberFormatException | Exception unused) {
            return null;
        }
    }

    public final void c() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.util.performance.g
            @Override // java.lang.Runnable
            public final void run() {
                h.d();
            }
        }, 64, null, true);
    }

    public final void h() {
        Map<String, String> mutableMapOf;
        IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
        GuildGaugeNames guildGaugeNames = GuildGaugeNames.CPU_TEMPERATURE_LOGIN_DIFF;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("telemetry_gauge_type", "cpu_temp_diff"));
        iQQOpenTelemetryReportApi.reportMetricGauge(guildGaugeNames, mutableMapOf, cTempDiff);
        o.f397685a.o(cTempDiff);
    }
}
