package fw2;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.ReportManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.PlayReportParams;
import com.tencent.qqlive.ona.protocol.jce.AdInSideVideoExposureItem;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdPositionItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import java.util.HashMap;
import pw2.n;
import pw2.u;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends c {

    /* renamed from: s, reason: collision with root package name */
    private int f400892s;

    /* renamed from: t, reason: collision with root package name */
    private int f400893t;

    /* renamed from: u, reason: collision with root package name */
    private int f400894u;

    /* renamed from: v, reason: collision with root package name */
    private String f400895v;

    a(AdReport adReport, String str, String str2, String str3, String str4, AdOrderItem adOrderItem, int i3, int i16, int i17, String str5) {
        super(adReport, str, str2, str3, str4, adOrderItem, "");
        this.f400892s = i3;
        this.f400893t = i16;
        this.f400894u = i17;
        this.f304054g = false;
        this.f400895v = str5;
    }

    public static a D(PlayReportParams playReportParams) {
        if (playReportParams == null) {
            return null;
        }
        return new a(playReportParams.k(), playReportParams.j(), playReportParams.l(), playReportParams.m(), playReportParams.n(), null, playReportParams.p(), playReportParams.q(), playReportParams.o(), null);
    }

    public static a E(AdOrderItem adOrderItem, int i3, int i16, int i17) {
        return F(adOrderItem, i3, i16, i17, null);
    }

    public static a F(AdOrderItem adOrderItem, int i3, int i16, int i17, String str) {
        AdInSideVideoExposureItem adInSideVideoExposureItem;
        String str2;
        if (adOrderItem != null && (adInSideVideoExposureItem = adOrderItem.exposureItem) != null && adInSideVideoExposureItem.emptyReport != null && !TextUtils.isEmpty(adInSideVideoExposureItem.playbackReport.url)) {
            AdInSideVideoExposureItem adInSideVideoExposureItem2 = adOrderItem.exposureItem;
            String str3 = adInSideVideoExposureItem2.adReportKey;
            String str4 = adInSideVideoExposureItem2.adReportParams;
            AdPositionItem adPositionItem = adOrderItem.positionItem;
            if (adPositionItem == null) {
                str2 = "";
            } else {
                str2 = adPositionItem.adSpace;
            }
            return new a(adInSideVideoExposureItem2.playbackReport, adOrderItem.orderId, str2, str3, str4, adOrderItem, i3, i16, i17, str);
        }
        return null;
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
        HashMap<String, String> b16 = b();
        if (b16.size() > 0) {
            hashMap.putAll(b16);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public void t(g gVar) {
        n.e("QAdPlayReportInfo", "reportPlay url = " + q());
        ReportManager.INSTANCE.report(this, this.f304054g, 8, gVar);
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
        return d16.replace("__PLAY_TYPE__", String.valueOf(this.f400892s)).replace("__TIME_OFFSET__", String.valueOf(this.f400893t)).replace("__TIMESTAMP__", String.valueOf(System.currentTimeMillis())).replace("__FAIL_REASON__", String.valueOf(this.f400894u));
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
}
