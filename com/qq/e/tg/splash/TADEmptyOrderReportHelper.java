package com.qq.e.tg.splash;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.MainHandler;
import com.qq.e.tg.splash.TGSplashAD;
import com.qq.e.tg.splash.lifecycle.SplashLifeCycleCallback;
import com.qq.e.tg.splash.lifecycle.TADSplashLifeCycleHolder;
import com.qq.e.tg.splash.report.SplashStubEvent;
import com.qq.e.tg.splash.report.TADSplashReportUtil;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TADEmptyOrderReportHelper {

    /* renamed from: a, reason: collision with root package name */
    private TGSplashAD f40738a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f40739b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f40740c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private final SplashLifeCycleCallback f40741d = new SplashLifeCycleCallback() { // from class: com.qq.e.tg.splash.TADEmptyOrderReportHelper.1
        @Override // com.qq.e.tg.splash.lifecycle.SplashLifeCycleCallback
        public void onSplashDismiss(boolean z16) {
            GDTLogger.i("TADEmptyOrderReportHelper onSplashDismiss :" + z16);
            TADEmptyOrderReportHelper.a(TADEmptyOrderReportHelper.this, z16);
        }

        @Override // com.qq.e.tg.splash.lifecycle.SplashLifeCycleCallback
        public void onSplashExposure(boolean z16) {
            GDTLogger.i("TADEmptyOrderReportHelper onSplashExposure :" + z16);
            if (TADEmptyOrderReportHelper.this.f40739b == z16) {
                TADEmptyOrderReportHelper.this.f40740c.compareAndSet(false, true);
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ReportParams {
        public String appId;
        public Context context;
        public long delayMillis;
        public int errorCode;
        public boolean hasExposureChance;
        public boolean isHotStart;
        public String posId = "";
        public String expParams = "";

        public boolean isValid() {
            if (!TextUtils.isEmpty(this.appId) && this.context != null && !TextUtils.isEmpty(this.posId)) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "ReportParams{posId='" + this.posId + "', hasExposureChance=" + this.hasExposureChance + ", isHotStart=" + this.isHotStart + ", delayMillis=" + this.delayMillis + ", expParams='" + this.expParams + "', errorCode=" + this.errorCode + ", context=" + this.context + ", appId=" + this.appId + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i3, ReportParams reportParams) {
        if (reportParams == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pid", reportParams.posId);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("hasExposureChance", Boolean.valueOf(reportParams.hasExposureChance));
        hashMap2.put("startMode", reportParams.isHotStart ? "1" : "0");
        hashMap2.put("cost_time", Long.valueOf(reportParams.delayMillis));
        hashMap2.put("expParams", reportParams.expParams);
        hashMap2.put("error_code", Integer.valueOf(reportParams.errorCode));
        TADSplashReportUtil.report(i3, 0, hashMap, hashMap2);
    }

    public void dealEmptyOrderReportAfterAWhile(final ReportParams reportParams) {
        if (reportParams != null && reportParams.isValid()) {
            this.f40739b = reportParams.isHotStart;
            TADSplashLifeCycleHolder.getInstance().addListener(reportParams.isHotStart, this.f40741d);
            GDTLogger.i("TADEmptyOrderReportHelper [dealEmptyOrderReportAfterAWhile] " + reportParams);
            a(SplashStubEvent.NEW_EMPTY_ORDER_REPORT_CALL, reportParams);
            MainHandler.postDelayed(new Runnable() { // from class: com.qq.e.tg.splash.TADEmptyOrderReportHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    GdtSDKThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qq.e.tg.splash.TADEmptyOrderReportHelper.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (TADEmptyOrderReportHelper.this.f40740c.get()) {
                                    GDTLogger.i("TADEmptyOrderReportHelper has exposure do noting");
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    TADEmptyOrderReportHelper tADEmptyOrderReportHelper = TADEmptyOrderReportHelper.this;
                                    TADEmptyOrderReportHelper.a(SplashStubEvent.DEAL_EMPTY_ORDER_REPORT_HAS_EXPOSURE, reportParams);
                                } else {
                                    GDTADManager gDTADManager = GDTADManager.getInstance();
                                    ReportParams reportParams2 = reportParams;
                                    gDTADManager.initWith(reportParams2.context, reportParams2.appId);
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    TADEmptyOrderReportHelper tADEmptyOrderReportHelper2 = TADEmptyOrderReportHelper.this;
                                    TADEmptyOrderReportHelper.a(SplashStubEvent.DEAL_EMPTY_ORDER_REPORT_NO_EXPOSURE, reportParams);
                                    AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                                    TADEmptyOrderReportHelper.a(TADEmptyOrderReportHelper.this, reportParams);
                                }
                                TADEmptyOrderReportHelper tADEmptyOrderReportHelper3 = TADEmptyOrderReportHelper.this;
                                TADEmptyOrderReportHelper.a(tADEmptyOrderReportHelper3, tADEmptyOrderReportHelper3.f40739b);
                            } catch (Throwable th5) {
                                GDTLogger.e("TADEmptyOrderReportHelper ", th5);
                            }
                        }
                    });
                }
            }, reportParams.delayMillis);
            return;
        }
        GDTLogger.e("TADEmptyOrderReportHelper [dealEmptyOrderReportAfterAWhile] no params");
    }

    static /* synthetic */ void a(TADEmptyOrderReportHelper tADEmptyOrderReportHelper, ReportParams reportParams) {
        PreCacheSplashAd preCacheSplashAd;
        if (reportParams == null || !reportParams.isValid()) {
            GDTLogger.e("TADEmptyOrderReportHelper [dealEmptyOrderReportAfterAWhile] no params");
            return;
        }
        GDTLogger.i("TADEmptyOrderReportHelper [dealEmptyOrderReport] posId:" + reportParams.posId + " hasExposureChance:" + reportParams.hasExposureChance);
        if (tADEmptyOrderReportHelper.f40739b) {
            preCacheSplashAd = TGSplashBackupOrderHolder.getInstance().getCachedEmptyOrder();
        } else {
            TGSplashPreCacheResult emptyOrderApUrlByDate = TGSplashPreCacheUtil.getEmptyOrderApUrlByDate(reportParams.posId, TGSplashPreCacheUtil.getTodayDate());
            preCacheSplashAd = emptyOrderApUrlByDate != null ? emptyOrderApUrlByDate.getPreCacheSplashAd() : null;
        }
        if (preCacheSplashAd == null) {
            GDTLogger.e("TADEmptyOrderReportHelper [dealEmptyOrderReport] emptyOrder get null");
            a(SplashStubEvent.DEAL_EMPTY_ORDER_REPORT_HAS_ORDER, reportParams);
            return;
        }
        if (!GDTADManager.getInstance().initWith(reportParams.context, reportParams.appId)) {
            GDTLogger.e("TADEmptyOrderReportHelper [dealEmptyOrderReport] !initSDKSuccess");
            a(SplashStubEvent.DEAL_EMPTY_ORDER_REPORT_SDK_INIT_FAIL, reportParams);
            return;
        }
        a(SplashStubEvent.DEAL_EMPTY_ORDER_REPORT_NO_ORDER, reportParams);
        if (tADEmptyOrderReportHelper.f40738a == null) {
            tADEmptyOrderReportHelper.f40738a = new TGSplashAD(reportParams.context, reportParams.appId, reportParams.posId, null);
            LoadAdParams loadAdParams = new LoadAdParams();
            loadAdParams.setHotStart(tADEmptyOrderReportHelper.f40739b);
            tADEmptyOrderReportHelper.f40738a.setLoadAdParams(loadAdParams);
        }
        TGSplashAD.FetchAdParams fetchAdParams = new TGSplashAD.FetchAdParams();
        fetchAdParams.emptyOrderApUrl = preCacheSplashAd.getApUrl();
        if (reportParams.hasExposureChance) {
            fetchAdParams.needCallPreSelect = true;
            fetchAdParams.needIncreasePlayRound = true;
            tADEmptyOrderReportHelper.f40738a.reportEmptyOrderIfNecessaryAndPreFetchAd(fetchAdParams);
        } else {
            fetchAdParams.needCallPreSelect = false;
            fetchAdParams.needIncreasePlayRound = false;
            tADEmptyOrderReportHelper.f40738a.reportEmptyOrderIfNecessaryAndPreFetchAd(fetchAdParams);
        }
    }

    static /* synthetic */ void a(TADEmptyOrderReportHelper tADEmptyOrderReportHelper, boolean z16) {
        GDTLogger.i("TADEmptyOrderReportHelper recycleListener :" + z16);
        TADSplashLifeCycleHolder.getInstance().removeListener(z16, tADEmptyOrderReportHelper.f40741d);
    }
}
