package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildCounterNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.ReportProxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
@ProxyService(proxy = ReportProxy.class)
/* loaded from: classes34.dex */
public class bc implements ReportProxy {
    private GuildCounterNames a(String str) {
        if (ReportProxy.COUNTER_EVENT_LOAD.equals(str)) {
            return GuildCounterNames.GUILD_MINI_CONTAINER_LOAD;
        }
        if (ReportProxy.COUNTER_EVENT_WHITE_SCREEN.equals(str)) {
            return GuildCounterNames.GUILD_MINI_CONTAINER_WHITE_SCREEN;
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ReportProxy
    public void report(String str, Map<String, String> map) {
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent(str, map);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ReportProxy
    public void reportContainerTimeCost(Map<String, String> map, long j3) {
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricTimeCost(GuildHistogramScene.GUILD_MINI_APP_LOAD_DURATION, map, j3);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ReportProxy
    public void reportCounter(String str, boolean z16, HashMap<String, String> hashMap) {
        GuildCounterNames a16 = a(str);
        if (a16 == null) {
            QLog.e("ReportProxyImpl", 1, "reportCounter but counterName is null:" + str);
            return;
        }
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricCount(a16, z16, hashMap);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ReportProxy
    public void reportMiniGameCenterDC00087(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map<String, String> map) {
        MiniAppUtils.reportMiniGameCenterDC00087(str, str2, str3, str4, str5, str6, str7, map);
    }
}
