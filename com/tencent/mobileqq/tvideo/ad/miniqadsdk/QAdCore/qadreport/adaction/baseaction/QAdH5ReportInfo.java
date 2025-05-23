package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction;

import com.tencent.qqlive.ona.protocol.jce.AdReport;
import java.io.Serializable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdH5ReportInfo implements Serializable {
    public Map<String, String> adExperimentMap;
    public String adId;
    public String adPos;
    public AdReport adReport;
    public String adReportKey;
    public String adReportParams;
    public int adType;
    public Map<String, String> extraMap;
    public String oid;
    public String requestId;
    public VideoReportInfo videoReportInfo;
    public String vrPageId;
    public Map vrReportMap;
    public int webViewType;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f303946a;

        /* renamed from: b, reason: collision with root package name */
        private AdReport f303947b;

        /* renamed from: c, reason: collision with root package name */
        private String f303948c;

        /* renamed from: d, reason: collision with root package name */
        private String f303949d;

        /* renamed from: e, reason: collision with root package name */
        private String f303950e;

        /* renamed from: f, reason: collision with root package name */
        private String f303951f;

        /* renamed from: g, reason: collision with root package name */
        private Map<String, String> f303952g;

        /* renamed from: h, reason: collision with root package name */
        private VideoReportInfo f303953h;

        /* renamed from: i, reason: collision with root package name */
        private Map f303954i;

        /* renamed from: j, reason: collision with root package name */
        private Map<String, String> f303955j;

        /* renamed from: k, reason: collision with root package name */
        private String f303956k;

        /* renamed from: l, reason: collision with root package name */
        private String f303957l;

        /* renamed from: m, reason: collision with root package name */
        private int f303958m;

        /* renamed from: n, reason: collision with root package name */
        private String f303959n;

        public a A(int i3) {
            this.f303958m = i3;
            return this;
        }

        public a n(Map<String, String> map) {
            this.f303952g = map;
            return this;
        }

        public a o(String str) {
            this.f303948c = str;
            return this;
        }

        public a p(String str) {
            this.f303949d = str;
            return this;
        }

        public a q(AdReport adReport) {
            this.f303947b = adReport;
            return this;
        }

        public a r(String str) {
            this.f303950e = str;
            return this;
        }

        public a s(String str) {
            this.f303951f = str;
            return this;
        }

        public a t(int i3) {
            this.f303946a = i3;
            return this;
        }

        public QAdH5ReportInfo u() {
            QAdH5ReportInfo qAdH5ReportInfo = new QAdH5ReportInfo();
            qAdH5ReportInfo.adType = this.f303946a;
            qAdH5ReportInfo.adReport = this.f303947b;
            qAdH5ReportInfo.adId = this.f303948c;
            qAdH5ReportInfo.adPos = this.f303949d;
            qAdH5ReportInfo.adReportKey = this.f303950e;
            qAdH5ReportInfo.adReportParams = this.f303951f;
            qAdH5ReportInfo.adExperimentMap = this.f303952g;
            qAdH5ReportInfo.extraMap = this.f303955j;
            qAdH5ReportInfo.oid = this.f303956k;
            qAdH5ReportInfo.requestId = this.f303957l;
            qAdH5ReportInfo.webViewType = this.f303958m;
            qAdH5ReportInfo.videoReportInfo = this.f303953h;
            qAdH5ReportInfo.vrReportMap = this.f303954i;
            qAdH5ReportInfo.vrPageId = this.f303959n;
            return qAdH5ReportInfo;
        }

        public a v(String str) {
            this.f303956k = str;
            return this;
        }

        public a w(String str) {
            this.f303957l = str;
            return this;
        }

        public a x(VideoReportInfo videoReportInfo) {
            this.f303953h = videoReportInfo;
            return this;
        }

        public a y(String str) {
            this.f303959n = str;
            return this;
        }

        public a z(Map map) {
            this.f303954i = map;
            return this;
        }
    }

    public QAdH5ReportInfo() {
    }

    public QAdH5ReportInfo(a aVar) {
        this.adType = aVar.f303946a;
        this.adReport = aVar.f303947b;
        this.adId = aVar.f303948c;
        this.adPos = aVar.f303949d;
        this.adReportKey = aVar.f303950e;
        this.adReportParams = aVar.f303951f;
        this.adExperimentMap = aVar.f303952g;
        this.extraMap = aVar.f303955j;
        this.oid = aVar.f303956k;
        this.requestId = aVar.f303957l;
        this.webViewType = aVar.f303958m;
        this.vrReportMap = aVar.f303954i;
        this.vrPageId = aVar.f303959n;
    }
}
