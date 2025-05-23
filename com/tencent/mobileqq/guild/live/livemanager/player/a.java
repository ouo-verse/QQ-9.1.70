package com.tencent.mobileqq.guild.live.livemanager.player;

import com.tencent.mobileqq.qqguildsdk.tianjige.GuildCounterNames;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    public static void a(boolean z16, boolean z17) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (z17) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("live_is_use_quic_flv_url", str);
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricCount(GuildCounterNames.GUILD_LIVE_HTTPDNS_PLAY, z16, hashMap);
    }

    public static void b(uq1.b bVar) {
        String str;
        HashMap hashMap = new HashMap();
        if (bVar.d()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("live_is_use_quic_flv_url", str);
        hashMap.put("is_backup", "1");
        try {
            String c16 = bVar.c();
            String substring = c16.substring(0, c16.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER));
            hashMap.put("stream_id", substring.substring(substring.lastIndexOf("/") + 1));
        } catch (Exception unused) {
            QLog.e("GuildLiveHttpDnsPlayStatistics", 1, bVar.c());
        }
        com.tencent.mobileqq.guild.performance.report.j.a("gpro_quality_living_first_frame_httpdns", hashMap);
    }

    public static void c(boolean z16, uq1.b bVar, int i3, int i16, int i17, String str) {
        String str2;
        HashMap hashMap = new HashMap();
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("live_is_use_quic_flv_url", str2);
        bVar.b();
        throw null;
    }
}
