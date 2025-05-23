package com.tencent.gdtad.web;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.GDTReportPlugin;
import java.net.URL;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtWebReportQQ implements h {

    /* renamed from: c, reason: collision with root package name */
    private long f109754c;

    /* renamed from: d, reason: collision with root package name */
    private long f109755d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f109756e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f109757f;

    /* renamed from: g, reason: collision with root package name */
    private k f109758g;

    /* renamed from: a, reason: collision with root package name */
    private int f109752a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f109753b = 0;

    /* renamed from: h, reason: collision with root package name */
    private int f109759h = 0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f109760i = false;

    public GdtWebReportQQ(k kVar) {
        this.f109758g = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String i(String str) {
        Activity activity;
        String str2;
        k kVar = this.f109758g;
        if (kVar != null) {
            activity = kVar.getActivity();
        } else {
            activity = null;
        }
        if (activity != null && activity.getIntent() != null) {
            str2 = activity.getIntent().getStringExtra(str);
        } else {
            str2 = "";
        }
        Log.i("GdtWebReportQQ", "name = " + str + ", s = " + str2);
        return str2;
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String host = new URL(str).getHost();
            for (String str2 : GDTReportPlugin.GDT_CLICK_CGI_HOST.split("#")) {
                if (host.equals(str2)) {
                    return true;
                }
            }
        } catch (Exception e16) {
            Log.e("GdtWebReportQQ", "check url is fail, error is " + e16);
        }
        return false;
    }

    private boolean l(long j3, String str) {
        if (j3 == 8589934593L && this.f109752a == 1 && !k(str)) {
            return true;
        }
        return false;
    }

    private void m(final int i3, final Boolean bool, final int i16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gdtad.web.GdtWebReportQQ.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity;
                int i17;
                if (QLog.isDebugVersion()) {
                    QLog.d("GdtWebReportQQ", 2, "report eventId is " + i3 + "costTime is" + i16 + "isCgiClick is" + bool);
                }
                if (GdtWebReportQQ.this.f109758g != null) {
                    activity = GdtWebReportQQ.this.f109758g.getActivity();
                } else {
                    activity = null;
                }
                Activity activity2 = activity;
                if (activity2 != null) {
                    ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(activity2, new InitGdtContextParams());
                    link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
                    reportBiz.cost_time = i16;
                    reportBiz.wv_progress = 2;
                    int i18 = 1;
                    if (bool.booleanValue()) {
                        reportBiz.click_req_type = 1;
                    } else {
                        reportBiz.click_req_type = 3;
                    }
                    if (GdtWebReportQQ.this.f109759h == 502 && GdtWebReportQQ.this.f109760i) {
                        if (GdtWebReportQQ.this.f109756e) {
                            i17 = 13;
                        } else {
                            i17 = 14;
                        }
                        reportBiz.lp_type = i17;
                    } else {
                        if (!GdtWebReportQQ.this.f109756e) {
                            i18 = 4;
                        }
                        reportBiz.lp_type = i18;
                    }
                    reportBiz.aid = GdtWebReportQQ.this.i("WebReport_AD_ID");
                    reportBiz.pid = GdtWebReportQQ.this.i("WebReport_POS_ID");
                    reportBiz.traceid = GdtWebReportQQ.this.i("WebReport_TRACE_ID");
                    reportBiz.act_code = GdtWebReportQQ.this.f109759h;
                    AdReporterForLinkEvent.getInstance().reportAsync(activity2, i3, null, reportBiz, null);
                }
            }
        }, 16, null, false);
    }

    @Override // com.tencent.gdtad.web.h
    public boolean a(String str, long j3, Map<String, Object> map) {
        int i3;
        boolean z16;
        boolean z17;
        boolean z18;
        long j16;
        boolean z19;
        long j17;
        boolean z26;
        if (TextUtils.isEmpty(i("WebReport_TRACE_ID"))) {
            Log.i("GdtWebReportQQ", "error, traceID is empty");
            return false;
        }
        int i16 = this.f109752a;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3 && (j3 == 8589934601L || j3 == 8589934598L)) {
                        this.f109752a = 4;
                        if (this.f109753b != 0) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        m(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_BEFORE_LOAD_SUCCESS, Boolean.valueOf(z26), (int) (System.currentTimeMillis() - this.f109754c));
                    }
                } else {
                    if (j3 == 8589934597L) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f109754c;
                        if (elapsedRealtime > 0) {
                            j17 = this.f109755d + elapsedRealtime;
                        } else {
                            j17 = this.f109755d;
                        }
                        this.f109755d = j17;
                    }
                    if (j3 == 2) {
                        this.f109754c = SystemClock.elapsedRealtime();
                    }
                    if (j3 == 8589934601L || j3 == 8589934598L || j3 == 8589934596L) {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime() - this.f109754c;
                        if (elapsedRealtime2 > 0) {
                            j16 = this.f109755d + elapsedRealtime2;
                        } else {
                            j16 = this.f109755d;
                        }
                        this.f109755d = j16;
                        if (this.f109753b != 0) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        m(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_AFTER_LOAD_SUCCESS, Boolean.valueOf(z19), (int) this.f109755d);
                        this.f109752a = 4;
                    }
                }
            } else if (j3 == 8589934594L) {
                this.f109752a = 2;
                if (this.f109753b != 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                m(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_LOAD_SUCCESS, Boolean.valueOf(z18), (int) (System.currentTimeMillis() - this.f109754c));
                this.f109754c = SystemClock.elapsedRealtime();
            } else if (j3 != 8589934595L && j3 != 8589934612L) {
                if (j3 == 8589934601L) {
                    this.f109752a = 4;
                    if (this.f109753b != 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    m(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXIT_BEFORE_LOAD_SUCCESS, Boolean.valueOf(z17), (int) (System.currentTimeMillis() - this.f109754c));
                }
            } else {
                this.f109752a = 3;
                if (k(str)) {
                    i3 = sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_FAILED;
                } else {
                    i3 = sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_LOAD_FAILED;
                }
                if (this.f109753b != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                m(i3, Boolean.valueOf(z16), (int) (System.currentTimeMillis() - this.f109754c));
            }
        } else if (j3 == 8589934593L) {
            if (k(str) && this.f109753b == 0) {
                this.f109753b = 1;
                m(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_START, Boolean.TRUE, (int) (System.currentTimeMillis() - this.f109754c));
            }
            this.f109752a = 1;
        }
        if (this.f109753b == 1) {
            boolean l3 = l(j3, str);
            if (l3 && !this.f109757f) {
                this.f109757f = true;
                m(sdk_event_log.SdkEventDimension.EVENT_STATISTICS_CLICK_SUCCESS, Boolean.TRUE, (int) (System.currentTimeMillis() - this.f109754c));
            }
            if (l3) {
                m(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_WEB_VIEW_LOAD_URL_START, Boolean.TRUE, (int) (System.currentTimeMillis() - this.f109754c));
                this.f109753b = 2;
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.tencent.gdtad.web.h
    public void c(CustomWebView customWebView) {
        j();
    }

    public void j() {
        long currentTimeMillis;
        int i3;
        GdtLog.d("GdtWebReportQQ", " init");
        k kVar = this.f109758g;
        if (kVar != null && kVar.getActivity() != null) {
            GdtLog.d("GdtWebReportQQ", " init success");
            Intent intent = this.f109758g.getActivity().getIntent();
            if (intent != null) {
                currentTimeMillis = intent.getLongExtra("WebReport_CLICK_TIME", System.currentTimeMillis());
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            this.f109754c = currentTimeMillis;
            boolean z16 = true;
            if (intent != null) {
                z16 = intent.getBooleanExtra("WebReport_IS_H5", true);
            }
            this.f109756e = z16;
            boolean z17 = false;
            if (intent != null) {
                i3 = intent.getIntExtra("WebReport_ACT_CODE", 0);
            } else {
                i3 = 0;
            }
            this.f109759h = i3;
            if (intent != null) {
                z17 = intent.getBooleanExtra("WebReport_HAS_REWARD_LANDING_PAGE", false);
            }
            this.f109760i = z17;
        }
    }

    @Override // com.tencent.gdtad.web.h
    public void b() {
    }

    @Override // com.tencent.gdtad.web.h
    public void onDestroy() {
    }
}
