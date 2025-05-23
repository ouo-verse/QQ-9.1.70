package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adexposure;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.QAdDeviceUtils;
import com.tencent.qqlive.ona.protocol.jce.AdInSideVideoExposureItem;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdPositionItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.tvideo.protocol.pb.AdReportType;
import java.util.HashMap;
import java.util.Map;
import kw2.b;
import pw2.n;
import pw2.u;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdStandardExposureReportInfo extends c {

    /* renamed from: s, reason: collision with root package name */
    protected int f304018s;

    /* renamed from: t, reason: collision with root package name */
    private long f304019t;

    /* renamed from: u, reason: collision with root package name */
    private int f304020u;

    /* renamed from: v, reason: collision with root package name */
    private Map<String, String> f304021v;

    /* renamed from: w, reason: collision with root package name */
    private long f304022w;

    public QAdStandardExposureReportInfo() {
        super(null, null, null, null, null, null, null);
    }

    public static QAdStandardExposureReportInfo E(AdReport adReport, AdOrderItem adOrderItem, int i3, String str, long j3) {
        String str2;
        String str3;
        String str4;
        if (adOrderItem != null && adReport != null) {
            AdInSideVideoExposureItem adInSideVideoExposureItem = adOrderItem.exposureItem;
            if (adInSideVideoExposureItem == null) {
                str2 = "";
            } else {
                str2 = adInSideVideoExposureItem.adReportKey;
            }
            if (adInSideVideoExposureItem == null) {
                str3 = "";
            } else {
                str3 = adInSideVideoExposureItem.adReportParams;
            }
            AdPositionItem adPositionItem = adOrderItem.positionItem;
            if (adPositionItem == null) {
                str4 = "";
            } else {
                str4 = adPositionItem.adSpace;
            }
            return new QAdStandardExposureReportInfo(i3, adReport, adOrderItem.orderId, str4, str2, str3, adOrderItem, str, j3);
        }
        return null;
    }

    public static QAdStandardExposureReportInfo F(AdReport adReport, AdOrderItem adOrderItem, int i3, String str, long j3, Map<String, String> map) {
        QAdStandardExposureReportInfo E = E(adReport, adOrderItem, i3, str, j3);
        if (E != null) {
            E.J(map);
        }
        return E;
    }

    public static QAdStandardExposureReportInfo G(com.tencent.tvideo.protocol.pb.AdOrderItem adOrderItem, int i3, int i16, String str, long j3, int i17) {
        AdReport a16;
        Map<String, String> c16;
        if (adOrderItem == null) {
            return null;
        }
        QAdStandardExposureReportInfo qAdStandardExposureReportInfo = new QAdStandardExposureReportInfo();
        if (i3 != 1000) {
            if (i3 != 1001) {
                c16 = null;
                a16 = null;
            } else {
                AdReportType adReportType = AdReportType.AD_REPORT_TYPE_EXPOSURE;
                a16 = b.a(adOrderItem, adReportType);
                c16 = b.c(adOrderItem, adReportType);
            }
        } else {
            AdReportType adReportType2 = AdReportType.AD_REPORT_TYPE_ORIGIN_EXPOSURE;
            a16 = b.a(adOrderItem, adReportType2);
            c16 = b.c(adOrderItem, adReportType2);
        }
        if (a16 == null) {
            n.a("QAdStandardExposureReportInfo", "createStageExposureInfo, adreport is null");
            return null;
        }
        qAdStandardExposureReportInfo.f304048a = a16;
        qAdStandardExposureReportInfo.f304049b = adOrderItem.order_id;
        qAdStandardExposureReportInfo.f304018s = i3;
        qAdStandardExposureReportInfo.f304047r = str;
        qAdStandardExposureReportInfo.f304019t = j3;
        qAdStandardExposureReportInfo.f304020u = i17;
        qAdStandardExposureReportInfo.f304052e = adOrderItem.ad_report_param;
        qAdStandardExposureReportInfo.f304051d = adOrderItem.ad_report_key;
        if (!y.i(c16)) {
            qAdStandardExposureReportInfo.f304044o = c16.get("__CHANNEL_ID__");
            qAdStandardExposureReportInfo.f304045p = y.m(c16.get("__SEQ__"), 0);
            qAdStandardExposureReportInfo.f304046q = y.m(c16.get("__ABS_SEQ__"), 0);
        }
        return qAdStandardExposureReportInfo;
    }

    private void H(long j3, final g gVar) {
        pw2.g.b(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adexposure.QAdStandardExposureReportInfo.1
            @Override // java.lang.Runnable
            public void run() {
                QAdStandardExposureReportInfo.this.I(gVar);
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(g gVar) {
        e.e(this, this.f304054g, gVar);
    }

    public void J(Map<String, String> map) {
        this.f304021v = map;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public HashMap<String, String> s() {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = this.f304049b;
        if (str != null) {
            hashMap.put("adId", str);
        }
        String str2 = this.f304050c;
        if (str2 != null) {
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_POS, str2);
        }
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_EXPOSURE_TYPE, String.valueOf(this.f304018s));
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLIP_PLAY_TIME, String.valueOf(this.f304019t));
        Map<String, String> map = this.f304021v;
        if (map != null) {
            hashMap.putAll(map);
        }
        HashMap<String, String> b16 = b();
        if (b16.size() > 0) {
            hashMap.putAll(b16);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public void t(g gVar) {
        n.e("QAdStandardExposureReportInfo", "sendReport , type = " + this.f304018s);
        long j3 = this.f304022w;
        if (j3 > 0) {
            H(j3, gVar);
        } else {
            I(gVar);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c
    public String y() {
        String str;
        AdReport adReport = this.f304048a;
        if (adReport == null || (str = adReport.url) == null) {
            str = null;
        }
        String d16 = u.d(str);
        if (d16 == null) {
            return null;
        }
        String replace = d16.replace("__EXPOSURE_TYPE__", String.valueOf(this.f304018s));
        String str2 = this.f304044o;
        if (str2 == null) {
            str2 = "";
        }
        return replace.replace("__CHANNEL_ID__", str2).replace("__SEQ__", String.valueOf(this.f304045p)).replace("__ABS_SEQ__", String.valueOf(this.f304046q)).replace("__ENCRYPT_DATA__", this.f304047r).replace("__EXPOSURE_TIME__", String.valueOf(this.f304019t)).replace("__EXP__", String.valueOf(this.f304020u)).replace("__NET_STATUS__", String.valueOf(QAdDeviceUtils.l()));
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c
    public String z() {
        String str;
        AdReport adReport = this.f304048a;
        if (adReport == null || (str = adReport.url) == null) {
            str = null;
        }
        return u.e(str);
    }

    public QAdStandardExposureReportInfo(int i3, AdReport adReport, String str, String str2, String str3, String str4, AdOrderItem adOrderItem, String str5, long j3) {
        super(adReport, str, str2, str3, str4, adOrderItem, str5);
        this.f304018s = i3;
        this.f304019t = j3;
    }
}
