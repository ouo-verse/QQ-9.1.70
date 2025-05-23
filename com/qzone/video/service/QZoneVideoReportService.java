package com.qzone.video.service;

import android.text.TextUtils;
import com.qzone.business.lbsv2.business.c;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader;
import com.qzone.reborn.configx.g;
import com.qzone.util.al;
import com.qzone.util.q;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.report.b;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import com.tencent.tmassistantbase.util.GlobalUtil;
import common.config.service.QzoneConfig;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.QUA;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_dc03701;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.report.lp.LpReportUtils;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.SafeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneVideoReportService implements com.tencent.mobileqq.qzoneplayer.report.a {

    /* renamed from: b, reason: collision with root package name */
    private static al<QZoneVideoReportService, Void> f60095b = new a();

    /* renamed from: a, reason: collision with root package name */
    private boolean f60096a;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends al<QZoneVideoReportService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneVideoReportService a(Void r16) {
            return new QZoneVideoReportService();
        }
    }

    public QZoneVideoReportService() {
        this.f60096a = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SETTING_VIDEO_RECOMMEND_CLEAR_REPORT_LIST, 1) == 1;
    }

    private String j(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : hashMap.keySet()) {
                if (str != null && hashMap.get(str) != null) {
                    jSONObject.put(str, hashMap.get(str));
                }
            }
            return jSONObject.toString();
        } catch (JSONException e16) {
            PlayerUtils.log(6, "QZoneVideoReportService", "convertHashMapToJSONString: JSONException when convert HashMap data - " + e16.getMessage());
            return "";
        }
    }

    private void k(HashMap<String, String> hashMap) {
        String valueOf;
        String valueOf2;
        String str;
        if (c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).a() == null) {
            if (!g.f53821a.b().q()) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.video.service.QZoneVideoReportService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).f();
                    }
                });
            } else {
                QLog.e("QZoneRequest", 2, "disable silent locate in QZoneVideoReportService");
            }
            valueOf2 = "";
            valueOf = valueOf2;
        } else {
            valueOf = String.valueOf((r0.lat * 1.0d) / 1000000.0d);
            valueOf2 = String.valueOf((r0.lon * 1.0d) / 1000000.0d);
        }
        LpReportUtils.safePut(hashMap, "longitude", valueOf2);
        LpReportUtils.safePut(hashMap, "latitude", valueOf);
        String e16 = q.e();
        if (!TextUtils.isEmpty(e16)) {
            LpReportUtils.safePut(hashMap, "localdns", e16);
        }
        String c16 = q.c();
        if (!TextUtils.isEmpty(c16)) {
            LpReportUtils.safePut(hashMap, "client_ip", c16);
        }
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset > 0) {
            str = Marker.ANY_NON_NULL_MARKER + rawOffset;
        } else {
            str = "" + rawOffset;
        }
        LpReportUtils.safePut(hashMap, "timezone", str);
        float b16 = b.c().b();
        if (b16 != 0.0f) {
            LpReportUtils.safePut(hashMap, "videospeed", String.valueOf(b16));
        }
        LpReportUtils.safePut(hashMap, "network", getNetworkType());
    }

    public static QZoneVideoReportService l() {
        return f60095b.get(null);
    }

    private boolean m(String str) {
        return "video_play_ret".equals(str) || "video_download_ret".equals(str);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public long c(int i3) {
        if (i3 == 406) {
            return i3;
        }
        return 1000027L;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public void d(ArrayList<Map<String, String>> arrayList, Map<String, String> map, String str, Map<String, String> map2, String str2) {
        QZoneVideoLoader.l().w(false);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public void g(String str, Map<String, String> map) {
        HashMap<String, String> hashMap;
        if (m(str)) {
            if (map instanceof HashMap) {
                hashMap = (HashMap) map;
            } else {
                hashMap = new HashMap<>(map);
            }
            boolean z16 = !hashMap.containsKey("ret_code") || hashMap.get("ret_code").equals("0");
            BaseApplicationImpl.getApplication();
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), str, z16, 0L, 0L, hashMap, null);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public long getLocalStoreTotalCountLimit() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_LOCALVIDEOPALYDATA_COUNT_LIMIT, 100);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public String getNetworkType() {
        int networkType = NetworkState.getNetworkType();
        if (networkType == 1) {
            return Global.TRACKING_WIFI;
        }
        if (networkType == 2) {
            return "2G";
        }
        if (networkType == 3) {
            return "3G";
        }
        if (networkType == 4) {
            return "4G";
        }
        if (networkType != 5) {
            return "UNKNOWN";
        }
        return "5G";
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public String getQua() {
        return QUA.getQUA3();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public long getUin() {
        return LoginData.getInstance().getUin();
    }

    public void n(String str) {
        try {
            AppRuntime qZoneRuntime = LoginData.getInstance().getQZoneRuntime();
            if (qZoneRuntime != null) {
                NewIntent tcSdkDownloadReportServlet = ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).getTcSdkDownloadReportServlet(BaseApplication.getContext());
                tcSdkDownloadReportServlet.putExtra("uin", LoginData.getInstance().getUinString());
                tcSdkDownloadReportServlet.putExtra("report_msg", str);
                qZoneRuntime.startServlet(tcSdkDownloadReportServlet);
            } else {
                QZLog.w("QZoneVideoReportService", "tcSdkReport AppRuntime is null");
            }
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public void f(String str, String str2, String str3, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        k(hashMap);
        String j3 = j(hashMap);
        if (QZLog.isDevelopLevel()) {
            QZLog.i("QZoneVideoReportService", "reportVideoRateToDc03701: extraInfo=" + j3);
        }
        LpReportInfo_dc03701.report(new LpReportInfo_dc03701(str, str2, str3, hashMap));
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public void h(int i3, String str, String str2, String str3, HashMap<String, String> hashMap, boolean z16, boolean z17) {
        if (hashMap != null) {
            hashMap.put("wifissid", "");
            hashMap.put("wifimac", GlobalUtil.DEFAULT_MAC_ADDRESS);
            hashMap.put("actiontime", String.valueOf(System.currentTimeMillis() / 1000));
        }
        String j3 = j(hashMap);
        if (QZLog.isDevelopLevel()) {
            QZLog.i("QZoneVideoReportService", "reportVideoEventToDc00321: extraInfo=" + j3);
        }
        LpReportInfo_dc00321 lpReportInfo_dc00321 = new LpReportInfo_dc00321(c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).c());
        lpReportInfo_dc00321.actiontype = SafeUtil.toInt(str);
        lpReportInfo_dc00321.subactiontype = SafeUtil.toInt(str2);
        lpReportInfo_dc00321.reserves = SafeUtil.toInt(str3);
        lpReportInfo_dc00321.extraInfo = j3;
        LpReportManager.getInstance().reportToDC00321(lpReportInfo_dc00321, z16, z17);
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public void b(ArrayList<Map<String, String>> arrayList) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public void i(String str, int i3) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public void a(String str, long j3, long j16) {
    }

    @Override // com.tencent.mobileqq.qzoneplayer.report.a
    public void e(Map<String, String> map, int i3, boolean z16) {
    }
}
