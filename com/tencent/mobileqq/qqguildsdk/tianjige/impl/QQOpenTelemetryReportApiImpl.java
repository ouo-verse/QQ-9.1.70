package com.tencent.mobileqq.qqguildsdk.tianjige.impl;

import ai2.CountInfo;
import ai2.HistogramInfo;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqguildsdk.manager.c;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildCounterNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildGaugeNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qqguildsdk.tianjige.e;
import com.tencent.mobileqq.qqguildsdk.tianjige.j;
import java.util.HashMap;
import java.util.Map;
import zh2.d;
import zh2.g;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQOpenTelemetryReportApiImpl implements IQQOpenTelemetryReportApi {
    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void endOpenTelemetryTask(String str) {
        j.b(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public String getTraceInfo(String str) {
        return j.c(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void init(e eVar) {
        j.k(eVar);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public boolean isColorUser() {
        return c.d().e().getIsColorUser();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public boolean isSdkEnable() {
        return c.d().e().getIsTraceSdkEnable();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void reportEvent(String str) {
        j.e(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void reportHistogramWithPolicy(HistogramInfo histogramInfo, @Nullable Map<String, String> map, double d16) {
        g.f452566a.i(histogramInfo, map, d16);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void reportMetricCount(GuildCounterNames guildCounterNames, boolean z16, HashMap<String, String> hashMap) {
        d.f452558a.d(guildCounterNames, z16, hashMap);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void reportMetricCountWithPolicy(CountInfo countInfo, HashMap<String, String> hashMap, long j3) {
        d.f452558a.i(countInfo, j3, hashMap);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void reportMetricGauge(GuildGaugeNames guildGaugeNames, @Nullable Map<String, String> map, double d16) {
        zh2.j.f452572a.f(guildGaugeNames, map, d16);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void reportMetricTimeCost(GuildHistogramScene guildHistogramScene, Map<String, String> map, double d16) {
        g.f452566a.g(guildHistogramScene, map, d16);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void reportOpenTelemetryTask(String str, String str2) {
        j.g(str, str2);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void setOpenTelemetryTaskAttributes(String str, Map<String, String> map) {
        j.i(str, map);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void setStatusCode(String str, int i3) {
        j.j(str, i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public String startOpenTelemetryTask(String str) {
        return j.l(str);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void reportEvent(String str, Map<String, String> map) {
        j.f(str, map);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public void reportOpenTelemetryTask(String str, String str2, Map<String, String> map) {
        j.h(str, str2, map);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi
    public String startOpenTelemetryTask(String str, String str2) {
        return j.m(str, str2);
    }
}
