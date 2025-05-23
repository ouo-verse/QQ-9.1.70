package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import java.io.Serializable;

/* loaded from: classes19.dex */
public class PlayReportParams {

    /* renamed from: a, reason: collision with root package name */
    private AdReport f304078a;

    /* renamed from: b, reason: collision with root package name */
    private String f304079b;

    /* renamed from: c, reason: collision with root package name */
    private String f304080c;

    /* renamed from: d, reason: collision with root package name */
    private String f304081d;

    /* renamed from: e, reason: collision with root package name */
    private String f304082e;

    /* renamed from: f, reason: collision with root package name */
    private int f304083f;

    /* renamed from: g, reason: collision with root package name */
    private int f304084g;

    /* renamed from: h, reason: collision with root package name */
    private int f304085h;

    /* renamed from: i, reason: collision with root package name */
    private IVRPlayReport f304086i;

    /* loaded from: classes19.dex */
    public static class Builder implements Serializable {
        private PlayReportParams adDetailParams = new PlayReportParams();

        public PlayReportParams build() {
            return this.adDetailParams;
        }

        public Builder setAdId(String str) {
            this.adDetailParams.f304082e = str;
            return this;
        }

        public Builder setAdPlayReport(AdReport adReport) {
            this.adDetailParams.f304078a = adReport;
            return this;
        }

        public Builder setAdPos(String str) {
            this.adDetailParams.f304081d = str;
            return this;
        }

        public Builder setAdReportKey(String str) {
            this.adDetailParams.f304080c = str;
            return this;
        }

        public Builder setAdReportParams(String str) {
            this.adDetailParams.f304079b = str;
            return this;
        }

        public Builder setFailReason(int i3) {
            this.adDetailParams.f304084g = i3;
            return this;
        }

        public Builder setPlayType(int i3) {
            this.adDetailParams.f304085h = i3;
            return this;
        }

        public Builder setTimeOffset(int i3) {
            this.adDetailParams.f304083f = i3;
            return this;
        }

        public Builder setVrPlayReport(IVRPlayReport iVRPlayReport) {
            this.adDetailParams.f304086i = iVRPlayReport;
            return this;
        }
    }

    public String j() {
        return this.f304082e;
    }

    public AdReport k() {
        return this.f304078a;
    }

    public String l() {
        return this.f304081d;
    }

    public String m() {
        return this.f304080c;
    }

    public String n() {
        return this.f304079b;
    }

    public int o() {
        return this.f304084g;
    }

    public int p() {
        return this.f304085h;
    }

    public int q() {
        return this.f304083f;
    }

    PlayReportParams() {
    }
}
