package com.tencent.mobileqq.guild.feed.report;

import android.os.Build;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.nt.misc.api.IAppInfoApi;
import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import guild.GuildClientReport$SingleTableData;
import guild.GuildCommon$Entry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/* loaded from: classes13.dex */
public class GuildPublishQualityReporter {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Long> f223274a = new HashMap<>();

    public static long a(String str) {
        if (f223274a.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis() - f223274a.remove(str).longValue();
            if (currentTimeMillis < 0) {
                QLog.d("GuildPublishQualityReporter", 1, "endKey... cost < 0 key:" + str);
                return -1L;
            }
            return currentTimeMillis;
        }
        QLog.w("GuildPublishQualityReporter", 1, "endKey... clickTimesMap not contain key:" + str);
        return -1L;
    }

    public static String b() {
        String str = ax.v() + "_" + new SimpleDateFormat("MMddHHmmssSSS").format(new Date(System.currentTimeMillis())) + "_" + UUID.randomUUID();
        QLog.d("GuildPublishQualityReporter", 1, "traceId:" + str);
        return str;
    }

    public static void c(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        QLog.d("GuildPublishQualityReporter", 1, "report... entity:" + qCirclePublishQualityDataBuilder.toString());
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()));
        ArrayList arrayList = new ArrayList(g(qCirclePublishQualityDataBuilder));
        arrayList.add(e.a("host_uin", ax.v()));
        arrayList.add(e.a("qua", ((IAppInfoApi) QRoute.api(IAppInfoApi.class)).getQua()));
        arrayList.add(e.a("client_time", format));
        arrayList.add(e.a("device_model", ((IAppInfoApi) QRoute.api(IAppInfoApi.class)).getDeviceName()));
        arrayList.add(e.a("device_os_ver", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(e.a("network_type", ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).getNetworkTypeString()));
        arrayList.add(e.a("appid", QQLiveReportConstants.VALUE_APPID));
        e(12004, arrayList);
    }

    public static void d(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        long a16 = a(qCirclePublishQualityDataBuilder.getKey());
        if (a16 > 0) {
            qCirclePublishQualityDataBuilder.setExt1(String.valueOf(a16));
            c(qCirclePublishQualityDataBuilder);
        } else {
            QLog.w("GuildPublishQualityReporter", 1, "reportEnd... cost < 0 id:" + qCirclePublishQualityDataBuilder.getKey());
        }
    }

    public static void e(final int i3, final List<GuildCommon$Entry> list) {
        GuildFeedReporter.o().n().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.report.GuildPublishQualityReporter.1
            @Override // java.lang.Runnable
            public void run() {
                GuildClientReport$SingleTableData guildClientReport$SingleTableData = new GuildClientReport$SingleTableData();
                guildClientReport$SingleTableData.tableID.set(i3);
                List list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    guildClientReport$SingleTableData.reportData.addAll(list);
                }
                GuildFeedReporter.o().k(guildClientReport$SingleTableData);
            }
        });
    }

    public static void f(String str) {
        f223274a.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    public static List<GuildCommon$Entry> g(QCirclePublishQualityDataBuilder qCirclePublishQualityDataBuilder) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(e.a("ext1", qCirclePublishQualityDataBuilder.getExt1()));
        arrayList.add(e.a("ext2", qCirclePublishQualityDataBuilder.getExt2()));
        arrayList.add(e.a("ext3", qCirclePublishQualityDataBuilder.getExt3()));
        arrayList.add(e.a("ext4", qCirclePublishQualityDataBuilder.getExt4()));
        arrayList.add(e.a("ext5", qCirclePublishQualityDataBuilder.getExt5()));
        arrayList.add(e.a("ext6", qCirclePublishQualityDataBuilder.getExt6()));
        arrayList.add(e.a("traceid", qCirclePublishQualityDataBuilder.getTraceId()));
        arrayList.add(e.a("event_id", qCirclePublishQualityDataBuilder.getKeyEventId()));
        arrayList.add(e.a("ret_code", qCirclePublishQualityDataBuilder.getKeyRetCode()));
        arrayList.add(e.a("desc", qCirclePublishQualityDataBuilder.getDesc()));
        return arrayList;
    }
}
