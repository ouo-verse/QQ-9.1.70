package f12;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryAttributes;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.data.GuildPerformanceInfo;
import com.tencent.mobileqq.guild.performance.report.data.InfoType;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildGaugeNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0000\u001a\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0000\u001a\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\b\u001a\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n\u001a\u0006\u0010\r\u001a\u00020\u0006\u001a\u0006\u0010\u000e\u001a\u00020\u0006\u001a\u001e\u0010\u0012\u001a\u00020\u00032\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000fj\b\u0012\u0004\u0012\u00020\u0003`\u0010\u001a\u0006\u0010\u0013\u001a\u00020\u0006\u001a\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003\u001a,\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u0000\u001a\u001a\u0010\u001e\u001a\u00020\u00062\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0018\u001a\u001a\u0010\u001f\u001a\u00020\u00062\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0018\u001a.\u0010 \u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u0000H\u0002\u001a\u0010\u0010\"\u001a\n !*\u0004\u0018\u00010\u00140\u0014H\u0002\u00a8\u0006#"}, d2 = {"", tl.h.F, "g", "Lcom/tencent/mobileqq/guild/performance/report/data/b;", "info", "isReportInfo", "", "j", "Lf12/j;", "k", "", "tempDiff", "l", "b", "i", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "d", "f", "", "e", "Lcom/tencent/mobileqq/guild/performance/report/GuildTelemetryTask;", "telemetryTask", "", "Lcom/tencent/mobileqq/guild/performance/report/GuildTelemetryAttributes;", "params", "needCLRLog", "o", "map", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "kotlin.jvm.PlatformType", "c", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class q {
    public static final void b() {
        d dVar = d.f397604d;
        o oVar = o.f397685a;
        dVar.c(oVar.f());
        b.f397591a.c(oVar.f());
    }

    private static final String c() {
        return AppSetting.f99551k;
    }

    @NotNull
    public static final GuildPerformanceInfo d(@NotNull ArrayList<GuildPerformanceInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        for (GuildPerformanceInfo guildPerformanceInfo : list) {
            f16 += guildPerformanceInfo.getMFps() / list.size();
            f17 += guildPerformanceInfo.getMDeviceFps() / list.size();
            f18 += guildPerformanceInfo.getMSmoothRate() / list.size();
        }
        list.clear();
        return new GuildPerformanceInfo(f16, f17, f18, 0.0f, 0.0f, 0.0f, 0.0f, null, null, false, false, null, 0.0d, 0.0d, 16376, null);
    }

    @NotNull
    public static final String e(@NotNull GuildPerformanceInfo info) {
        float coerceAtMost;
        float coerceAtLeast;
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getMDeviceFps() <= 0.0f) {
            QLog.i("ReportUtil", 1, "getNormalizedFps deviceFps illegal, info:" + info);
            return "";
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(info.getMFps(), k.INSTANCE.d().getMaxFps());
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(coerceAtMost, 0.0f);
        return String.valueOf(coerceAtLeast);
    }

    public static final void f() {
        Iterator<Map.Entry<String, Integer>> it = o.f397685a.i().entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().getValue().intValue();
        }
        if (i3 >= k.INSTANCE.d().getMaxListReportTimes() * 10) {
            d.f397604d.f();
            o.f397685a.p(true);
        }
    }

    public static final boolean g() {
        o oVar = o.f397685a;
        if (!oVar.j() || oVar.k() >= k.INSTANCE.d().getPublicRate()) {
            return false;
        }
        return true;
    }

    public static final boolean h() {
        if (!o.f397685a.j() && QLog.isColorLevel()) {
            QLog.d("ReportUtil", 2, "manageSwitch is closed");
        }
        return false;
    }

    public static final void i() {
        d dVar = d.f397604d;
        o oVar = o.f397685a;
        dVar.l(oVar.f());
        b.f397591a.h(oVar.f());
    }

    public static final void j(@NotNull GuildPerformanceInfo info, boolean z16) {
        Map<String, String> mutableMapOf;
        Map<String, String> mutableMapOf2;
        int i3;
        Intrinsics.checkNotNullParameter(info, "info");
        if (!z16) {
            return;
        }
        EnumMap enumMap = new EnumMap(GuildTelemetryAttributes.class);
        enumMap.put((EnumMap) GuildTelemetryAttributes.GUILD_SCENE, (GuildTelemetryAttributes) info.getMScene());
        GuildTelemetryAttributes guildTelemetryAttributes = GuildTelemetryAttributes.IS_BACKGROUND;
        f fVar = f.f397616a;
        enumMap.put((EnumMap) guildTelemetryAttributes, (GuildTelemetryAttributes) fVar.a(info.getMIsBackground()));
        int i16 = 0;
        if (info.getMInfoType() == InfoType.DROP_FRAME_INFO) {
            o oVar = o.f397685a;
            Integer num = oVar.i().get(info.getMScene());
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            if (i3 >= k.INSTANCE.d().getMaxListReportTimes() && !oVar.l()) {
                return;
            }
            ArrayList<GuildPerformanceInfo> arrayList = oVar.g().get(info.getMScene());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            oVar.g().put(info.getMScene(), arrayList);
            arrayList.add(info);
            if (arrayList.size() < 3) {
                return;
            }
            GuildPerformanceInfo d16 = d(arrayList);
            enumMap.put((EnumMap) GuildTelemetryAttributes.FPS, (GuildTelemetryAttributes) e(d16));
            enumMap.put((EnumMap) GuildTelemetryAttributes.FLUENCY, (GuildTelemetryAttributes) String.valueOf(d16.getMSmoothRate()));
            o(GuildTelemetryTask.PERF_MONITOR_FPS, enumMap, true);
            Map<String, Integer> i17 = oVar.i();
            String mScene = info.getMScene();
            Integer num2 = oVar.i().get(info.getMScene());
            if (num2 != null) {
                i16 = num2.intValue();
            }
            i17.put(mScene, Integer.valueOf(i16 + 1));
            f();
            return;
        }
        if (info.getMInfoType() == InfoType.MEMORY_CPU_INFO) {
            enumMap.put((EnumMap) GuildTelemetryAttributes.GUILD_SIDE_SCENE, (GuildTelemetryAttributes) info.getMSideScene());
            enumMap.put((EnumMap) GuildTelemetryAttributes.CPU_USAGE, (GuildTelemetryAttributes) String.valueOf(info.getMCpuUsage()));
            enumMap.put((EnumMap) GuildTelemetryAttributes.PROCESS_MEMORY_USAGE, (GuildTelemetryAttributes) String.valueOf(info.getMProcessMemoryUsage()));
            enumMap.put((EnumMap) GuildTelemetryAttributes.HEAP_MEMORY, (GuildTelemetryAttributes) String.valueOf(info.getMAllocatedHeapMemory()));
            enumMap.put((EnumMap) GuildTelemetryAttributes.IS_GUILDTAB, (GuildTelemetryAttributes) fVar.a(info.getMInGuildTab()));
            o(GuildTelemetryTask.PERF_MONITOR_MEMORY_CPU, enumMap, false);
            return;
        }
        if (info.getMInfoType() == InfoType.CPU_TEMP_INFO) {
            double mTempDiff = info.getMTempDiff();
            if (mTempDiff > 1000.0d) {
                IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
                GuildGaugeNames guildGaugeNames = GuildGaugeNames.CPU_TEMPERATURE_DIFF;
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("telemetry_gauge_type", "cpu_temp_diff"), TuplesKt.to("telemetry_gauge_scene", info.getMScene()));
                iQQOpenTelemetryReportApi.reportMetricGauge(guildGaugeNames, mutableMapOf2, mTempDiff);
            }
            IQQOpenTelemetryReportApi iQQOpenTelemetryReportApi2 = (IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class);
            GuildGaugeNames guildGaugeNames2 = GuildGaugeNames.CPU_TEMPERATURE;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("telemetry_gauge_type", "current_cpu_temp"), TuplesKt.to("telemetry_gauge_scene", info.getMScene()));
            iQQOpenTelemetryReportApi2.reportMetricGauge(guildGaugeNames2, mutableMapOf, info.getMTemperature());
        }
    }

    public static final void k(@NotNull GuildPowerConsumptionData info) {
        Intrinsics.checkNotNullParameter(info, "info");
        EnumMap enumMap = new EnumMap(GuildTelemetryAttributes.class);
        enumMap.put((EnumMap) GuildTelemetryAttributes.POWER_SCENE, (GuildTelemetryAttributes) info.getMScene());
        enumMap.put((EnumMap) GuildTelemetryAttributes.GUILD_SIDE_SCENE, (GuildTelemetryAttributes) info.getMSideScene());
        enumMap.put((EnumMap) GuildTelemetryAttributes.CPU_CONSUMPTION, (GuildTelemetryAttributes) String.valueOf(info.getMCpuJiffies()));
        enumMap.put((EnumMap) GuildTelemetryAttributes.NET_RX_CONSUMPTION, (GuildTelemetryAttributes) String.valueOf(info.getMRxBytes()));
        enumMap.put((EnumMap) GuildTelemetryAttributes.NET_TX_CONSUMPTION, (GuildTelemetryAttributes) String.valueOf(info.getMTxBytes()));
        enumMap.put((EnumMap) GuildTelemetryAttributes.SENSOR_TYPE_ACCELEROMETER_CONSUMPTION, (GuildTelemetryAttributes) String.valueOf(info.getMSensorAccelarationTime()));
        GuildTelemetryAttributes guildTelemetryAttributes = GuildTelemetryAttributes.IS_BACKGROUND;
        f fVar = f.f397616a;
        enumMap.put((EnumMap) guildTelemetryAttributes, (GuildTelemetryAttributes) fVar.a(info.getMBackGround()));
        enumMap.put((EnumMap) GuildTelemetryAttributes.IS_GUILDTAB, (GuildTelemetryAttributes) fVar.a(info.getMInGuildTab()));
        o(GuildTelemetryTask.POWER_MONITOR, enumMap, true);
    }

    public static final void l(double d16) {
        EnumMap enumMap = new EnumMap(GuildTelemetryAttributes.class);
        enumMap.put((EnumMap) GuildTelemetryAttributes.TEMP_DIFF, (GuildTelemetryAttributes) String.valueOf(d16));
        o(GuildTelemetryTask.TEMP_MONITOR, enumMap, true);
    }

    public static final void m(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        o oVar = o.f397685a;
        if (oVar.l()) {
            map.put(GuildTelemetryAttributes.AUTO_TASK_ID.getAttrName(), oVar.d());
        }
        String attrName = GuildTelemetryAttributes.BRANCH_NAME.getAttrName();
        String branchName = AppSetting.f99544d;
        Intrinsics.checkNotNullExpressionValue(branchName, "branchName");
        map.put(attrName, branchName);
        String attrName2 = GuildTelemetryAttributes.APP_VERSION.getAttrName();
        String c16 = c();
        Intrinsics.checkNotNullExpressionValue(c16, "getAppVersion()");
        map.put(attrName2, c16);
    }

    public static final void n(@NotNull Map<GuildTelemetryAttributes, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        o oVar = o.f397685a;
        if (oVar.l()) {
            params.put(GuildTelemetryAttributes.AUTO_TASK_ID, oVar.d());
            params.put(GuildTelemetryAttributes.AUTO_TASK_TIME, oVar.e());
        }
        GuildTelemetryAttributes guildTelemetryAttributes = GuildTelemetryAttributes.BRANCH_NAME;
        String branchName = AppSetting.f99544d;
        Intrinsics.checkNotNullExpressionValue(branchName, "branchName");
        params.put(guildTelemetryAttributes, branchName);
        GuildTelemetryAttributes guildTelemetryAttributes2 = GuildTelemetryAttributes.APP_VERSION;
        String c16 = c();
        Intrinsics.checkNotNullExpressionValue(c16, "getAppVersion()");
        params.put(guildTelemetryAttributes2, c16);
    }

    public static final void o(@NotNull final GuildTelemetryTask telemetryTask, @NotNull final Map<GuildTelemetryAttributes, String> params, final boolean z16) {
        Intrinsics.checkNotNullParameter(telemetryTask, "telemetryTask");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!h()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: f12.p
            @Override // java.lang.Runnable
            public final void run() {
                q.p(GuildTelemetryTask.this, params, z16);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GuildTelemetryTask telemetryTask, Map params, boolean z16) {
        Intrinsics.checkNotNullParameter(telemetryTask, "$telemetryTask");
        Intrinsics.checkNotNullParameter(params, "$params");
        q(telemetryTask, params, z16);
    }

    private static final void q(GuildTelemetryTask guildTelemetryTask, Map<GuildTelemetryAttributes, String> map, boolean z16) {
        n(map);
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).telemetryReport(guildTelemetryTask, map);
        if (QLog.isColorLevel() && z16) {
            QLog.d("ReportUtil", 2, "reportInfo check passed, report params:" + map);
        }
    }
}
