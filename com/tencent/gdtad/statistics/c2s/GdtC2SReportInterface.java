package com.tencent.gdtad.statistics.c2s;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtReporterForAnalysis;
import com.tencent.gdtad.statistics.a;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtC2SReportInterface implements a.InterfaceC1166a {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f109486a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f109487b;

    /* renamed from: c, reason: collision with root package name */
    private List<String> f109488c;

    /* renamed from: d, reason: collision with root package name */
    private String f109489d;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public qq_ad_get.QQAdGetRsp.AdInfo f109492g;

    /* renamed from: e, reason: collision with root package name */
    public int f109490e = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f109491f = -1;

    /* renamed from: h, reason: collision with root package name */
    public long f109493h = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    private int g(String str, int i3) {
        int i16;
        HttpURLConnection httpURLConnection;
        int i17;
        int i18;
        int i19;
        long currentTimeMillis = System.currentTimeMillis();
        GdtReporterForAnalysis.h(BaseApplicationImpl.getApplication(), this, str);
        int i26 = i();
        int i27 = -1;
        HttpURLConnection httpURLConnection2 = null;
        try {
            GdtLog.d("GdtC2SReporter", "index: " + i3 + " mOpeType " + this.f109490e);
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection3.setRequestMethod("GET");
                httpURLConnection3.setConnectTimeout(i26);
                httpURLConnection3.setReadTimeout(i26);
                httpURLConnection3.setUseCaches(false);
                httpURLConnection3.setInstanceFollowRedirects(true);
                httpURLConnection3.connect();
                int responseCode = httpURLConnection3.getResponseCode();
                try {
                    GdtLog.d("GdtC2SReporter", "rspCode:  " + responseCode + " index: " + i3 + " mOpeType " + this.f109490e + " reportUrl =" + str);
                    i18 = this.f109490e;
                    if (responseCode == 200) {
                        i19 = 0;
                    } else {
                        i19 = 1;
                    }
                    i17 = responseCode;
                    httpURLConnection = httpURLConnection3;
                } catch (Throwable th5) {
                    th = th5;
                    i17 = responseCode;
                    httpURLConnection = httpURLConnection3;
                }
                try {
                    ReportController.r(null, "dc00898", "", "", "0X8009B97", "0X8009B97", i18, i19, "", "", this.f109489d, str);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable th6) {
                        GdtLog.e("GdtC2SReporter", "urlConnection excetpion: " + th6.getMessage());
                    }
                    i16 = i17;
                } catch (Throwable th7) {
                    th = th7;
                    i27 = i17;
                    httpURLConnection2 = httpURLConnection;
                    try {
                        GdtLog.e("GdtC2SReporter", "c2sReport excetpion: " + th.getMessage());
                        if (httpURLConnection2 == null) {
                            return i27;
                        }
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Throwable th8) {
                            GdtLog.e("GdtC2SReporter", "urlConnection excetpion: " + th8.getMessage());
                        }
                        i16 = i27;
                        GdtReporterForAnalysis.e(BaseApplicationImpl.getApplication(), this, str, i16, System.currentTimeMillis() - currentTimeMillis);
                        return i16;
                    } catch (Throwable th9) {
                        if (httpURLConnection2 == null) {
                            return i27;
                        }
                        try {
                            httpURLConnection2.disconnect();
                            throw th9;
                        } catch (Throwable th10) {
                            GdtLog.e("GdtC2SReporter", "urlConnection excetpion: " + th10.getMessage());
                            throw th9;
                        }
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                httpURLConnection = httpURLConnection3;
            }
        } catch (Throwable th12) {
            th = th12;
        }
        GdtReporterForAnalysis.e(BaseApplicationImpl.getApplication(), this, str, i16, System.currentTimeMillis() - currentTimeMillis);
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(@NonNull List<String> list) {
        int i3 = 0;
        int i16 = -1;
        for (String str : list) {
            i3++;
            int g16 = g(str, i3);
            if (g16 < 0) {
                g16 = g(str, i3);
            }
            i16 = g16;
            GdtReporterForAnalysis.f(BaseApplicationImpl.getApplication(), this, str, i16);
        }
        ReportController.r(null, "dc00898", "", "", "0X8009EBF", "0X8009EBF", this.f109490e, i16, "", "", this.f109489d, "");
    }

    private int i() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int i3 = 10000;
        if (peekAppRuntime == null) {
            QLog.e("GdtC2SReportInterface", 1, "appRuntime is null");
            return 10000;
        }
        if (((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("ad_gdt_c2s_reporter_timeout", false)) {
            i3 = 30000;
        }
        QLog.d("GdtC2SReportInterface", 1, "getReportTimeout: " + i3);
        return i3;
    }

    @Override // com.tencent.gdtad.statistics.a.InterfaceC1166a
    public void a(int i3, int i16, @Nullable qq_ad_get.QQAdGetRsp.AdInfo adInfo) {
        List<String> list;
        List<String> list2;
        List<String> list3;
        this.f109491f = i16;
        this.f109492g = adInfo;
        if (adInfo != null) {
            this.f109486a = adInfo.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.get();
            this.f109487b = adInfo.report_info.thirdparty_monitor_urls.api_click_monitor_url.get();
            this.f109488c = adInfo.report_info.thirdparty_monitor_urls.video_play_monitor_url.get();
            String l3 = Long.toString(adInfo.report_info.trace_info.aid.get());
            this.f109489d = l3;
            if (l3 != null) {
                if (i3 == 0 && (list3 = this.f109486a) != null && list3.size() > 0) {
                    this.f109490e = i3;
                }
                if (i3 == 1 && (list2 = this.f109487b) != null && list2.size() > 0) {
                    this.f109490e = i3;
                }
                if (i3 == 2 && (list = this.f109488c) != null && list.size() > 0) {
                    this.f109490e = i3;
                }
                if (this.f109490e != -1) {
                    GdtLog.d("GdtC2SReporter", "reportAsync for ADID: " + this.f109489d + ", operationType: " + i3);
                    GdtReporterForAnalysis.g(BaseApplicationImpl.getApplication(), new GdtAd(adInfo), i3, i16, true);
                    this.f109493h = System.currentTimeMillis();
                    ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.gdtad.statistics.c2s.GdtC2SReportInterface.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GdtC2SReportInterface gdtC2SReportInterface = GdtC2SReportInterface.this;
                            ReportController.r(null, "dc00898", "", "", "0X8009EBE", "0X8009EBE", gdtC2SReportInterface.f109490e, 0, "", "", gdtC2SReportInterface.f109489d, "");
                            GdtC2SReportInterface gdtC2SReportInterface2 = GdtC2SReportInterface.this;
                            int i17 = gdtC2SReportInterface2.f109490e;
                            if (i17 == 0) {
                                gdtC2SReportInterface2.h(gdtC2SReportInterface2.f109486a);
                            } else if (i17 == 1) {
                                gdtC2SReportInterface2.h(gdtC2SReportInterface2.f109487b);
                            } else if (i17 == 2) {
                                gdtC2SReportInterface2.h(gdtC2SReportInterface2.f109488c);
                            }
                        }
                    });
                    ReportController.r(null, "dc00898", "", "", "0X8009EBC", "0X8009EBC", this.f109490e, 0, "", "", this.f109489d, "");
                    return;
                }
            }
        }
        GdtReporterForAnalysis.g(BaseApplicationImpl.getApplication(), new GdtAd(adInfo), i3, i16, false);
    }
}
