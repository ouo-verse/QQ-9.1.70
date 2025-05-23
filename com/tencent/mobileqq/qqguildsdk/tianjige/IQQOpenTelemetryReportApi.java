package com.tencent.mobileqq.qqguildsdk.tianjige;

import ai2.CountInfo;
import ai2.HistogramInfo;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQOpenTelemetryReportApi extends QRouteApi {
    void endOpenTelemetryTask(String str);

    String getTraceInfo(String str);

    void init(e eVar);

    boolean isColorUser();

    boolean isSdkEnable();

    void reportEvent(String str);

    void reportEvent(String str, Map<String, String> map);

    void reportHistogramWithPolicy(HistogramInfo histogramInfo, @Nullable Map<String, String> map, double d16);

    void reportMetricCount(GuildCounterNames guildCounterNames, boolean z16, @Nullable HashMap<String, String> hashMap);

    void reportMetricCountWithPolicy(CountInfo countInfo, @Nullable HashMap<String, String> hashMap, long j3);

    void reportMetricGauge(GuildGaugeNames guildGaugeNames, @Nullable Map<String, String> map, double d16);

    void reportMetricTimeCost(GuildHistogramScene guildHistogramScene, @Nullable Map<String, String> map, double d16);

    void reportOpenTelemetryTask(String str, String str2);

    void reportOpenTelemetryTask(String str, String str2, Map<String, String> map);

    void setOpenTelemetryTaskAttributes(String str, Map<String, String> map);

    void setStatusCode(String str, int i3);

    String startOpenTelemetryTask(String str);

    String startOpenTelemetryTask(String str, String str2);
}
