package ew2;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.qqlive.ona.protocol.jce.AdInSideVideoExposureItem;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.tvideo.protocol.pb.AdEmptyInfo;
import com.tencent.tvideo.protocol.pb.AdReportType;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import pw2.n;
import pw2.u;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.c {

    /* renamed from: s, reason: collision with root package name */
    private int f397285s;

    /* renamed from: t, reason: collision with root package name */
    private Map<String, String> f397286t;

    /* renamed from: u, reason: collision with root package name */
    private String f397287u;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        AdReport f397288a;

        /* renamed from: b, reason: collision with root package name */
        String f397289b;

        /* renamed from: c, reason: collision with root package name */
        String f397290c;

        /* renamed from: d, reason: collision with root package name */
        AdOrderItem f397291d;

        /* renamed from: e, reason: collision with root package name */
        String f397292e;

        /* renamed from: f, reason: collision with root package name */
        Map<String, String> f397293f;

        /* renamed from: g, reason: collision with root package name */
        String f397294g;

        public b a(AdOrderItem adOrderItem) {
            this.f397291d = adOrderItem;
            return this;
        }

        public b b(AdReport adReport) {
            this.f397288a = adReport;
            return this;
        }

        public b c(String str) {
            this.f397289b = str;
            return this;
        }

        public b d(String str) {
            this.f397290c = str;
            return this;
        }

        public f e() {
            return new f(this);
        }

        public b f(String str) {
            this.f397294g = str;
            return this;
        }

        public b g(String str) {
            this.f397292e = str;
            return this;
        }

        public b h(Map<String, String> map) {
            this.f397293f = map;
            return this;
        }
    }

    public static f D(AdOrderItem adOrderItem, String str) {
        return E(adOrderItem, str, null, null);
    }

    public static f E(AdOrderItem adOrderItem, String str, Map<String, String> map, String str2) {
        AdInSideVideoExposureItem adInSideVideoExposureItem;
        AdReport adReport;
        if (adOrderItem != null && (adInSideVideoExposureItem = adOrderItem.exposureItem) != null && (adReport = adInSideVideoExposureItem.emptyReport) != null && !TextUtils.isEmpty(adReport.url)) {
            AdInSideVideoExposureItem adInSideVideoExposureItem2 = adOrderItem.exposureItem;
            AdReport adReport2 = adInSideVideoExposureItem2.emptyReport;
            return new b().b(adReport2).c(adInSideVideoExposureItem2.adReportKey).d(adInSideVideoExposureItem2.adReportParams).a(adOrderItem).g(str).h(map).f(str2).e();
        }
        return null;
    }

    public static f F(AdEmptyInfo adEmptyInfo, int i3) {
        com.tencent.tvideo.protocol.pb.AdReport adReport;
        if (adEmptyInfo != null && (adReport = adEmptyInfo.empty_report) != null && !y.h(adReport.report_urls)) {
            f fVar = new f();
            AdReport adReport2 = new AdReport();
            Map<String, String> map = adEmptyInfo.reporter_dict;
            adReport2.url = adEmptyInfo.empty_report.report_urls.get(0);
            String uuid = UUID.randomUUID().toString();
            fVar.f304049b = "55";
            fVar.f304047r = nv2.a.a(uuid);
            fVar.x(adEmptyInfo.mta_report_dict);
            fVar.f397285s = i3;
            fVar.f304048a = adReport2;
            if (!y.i(map)) {
                fVar.f304044o = map.get("__CHANNEL_ID__");
                fVar.f304045p = y.m(map.get("__SEQ__"), 0);
                fVar.f304046q = y.m(map.get("__ABS_SEQ__"), 0);
            }
            return fVar;
        }
        return null;
    }

    public static f G(com.tencent.tvideo.protocol.pb.AdOrderItem adOrderItem, String str, int i3) {
        if (adOrderItem == null) {
            return null;
        }
        AdReportType adReportType = AdReportType.AD_REPORT_TYPE_EMPTY;
        AdReport a16 = kw2.b.a(adOrderItem, adReportType);
        if (a16 == null) {
            n.a("QAdStandardEmptyReportInfo", "createPBEmptyReportInfo. adReport is null");
            return null;
        }
        f fVar = new f();
        fVar.f304052e = adOrderItem.ad_report_param;
        fVar.f304051d = adOrderItem.ad_report_key;
        fVar.f304049b = adOrderItem.order_id;
        fVar.f304047r = str;
        fVar.f304048a = a16;
        fVar.f397285s = i3;
        Map<String, String> c16 = kw2.b.c(adOrderItem, adReportType);
        if (!y.i(c16)) {
            fVar.f304044o = c16.get("__CHANNEL_ID__");
            fVar.f304045p = y.m(c16.get("__SEQ__"), 0);
            fVar.f304046q = y.m(c16.get("__ABS_SEQ__"), 0);
        }
        return fVar;
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
        if (!y.i(this.f397286t)) {
            hashMap.putAll(this.f397286t);
        }
        HashMap<String, String> b16 = b();
        if (b16.size() > 0) {
            hashMap.putAll(b16);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public void t(g gVar) {
        n.a("FocusAdReport", "[Empty] reportUrl = ");
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.e.d(this, this.f304054g, gVar);
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
        String replace = d16.replace("__ENCRYPT_DATA__", this.f304047r).replace("__EXP__", String.valueOf(this.f397285s));
        if (!TextUtils.isEmpty(this.f397287u)) {
            return replace.replace("__TIME_OFFSET__", this.f397287u);
        }
        return replace;
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

    f(b bVar) {
        super(bVar.f397288a, "", "", bVar.f397289b, bVar.f397290c, bVar.f397291d, bVar.f397292e);
        this.f397286t = bVar.f397293f;
        this.f397287u = bVar.f397294g;
    }

    f() {
        super(null, null, null, null, null, null, null);
    }
}
