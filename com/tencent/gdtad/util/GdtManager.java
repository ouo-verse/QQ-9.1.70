package com.tencent.gdtad.util;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.AdManagerForQQ;
import com.tencent.ad.tangram.config.AdConfigManager;
import com.tencent.ad.tangram.device.AdDevice;
import com.tencent.ad.tangram.device.AdDeviceAdapter;
import com.tencent.ad.tangram.device.AdTAID;
import com.tencent.ad.tangram.device.AdTAIDAdapter;
import com.tencent.ad.tangram.dialog.AdProgressDialog;
import com.tencent.ad.tangram.dialog.AdProgressDialogAdapter;
import com.tencent.ad.tangram.downloader.AdDownloadUrlManager;
import com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2;
import com.tencent.ad.tangram.downloader.AdDownloaderV2;
import com.tencent.ad.tangram.halfScreenDownload.AdHalfScreenDownload;
import com.tencent.ad.tangram.halfScreenDownload.AdHalfScreenDownloadAdapter;
import com.tencent.ad.tangram.image.AdImageViewAdapter;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.ad.tangram.interpage.AdInterPage;
import com.tencent.ad.tangram.interpage.AdInterPageAdapter;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.lbs.AdLocationAdapter;
import com.tencent.ad.tangram.lbs.AdLocationManager;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.log.AdLogAdapter;
import com.tencent.ad.tangram.mini.AdQQMINIProgram;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter;
import com.tencent.ad.tangram.privacy.AdPrivacyPolicyManager;
import com.tencent.ad.tangram.privacy.AdPrivacyPolicyManagerAdapter;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.process.AdProcessManagerAdapter;
import com.tencent.ad.tangram.statistics.AdReporterForOuterJump;
import com.tencent.ad.tangram.statistics.AdReporterForOuterJumpAdapter;
import com.tencent.ad.tangram.statistics.metric.AdMetricService;
import com.tencent.ad.tangram.statistics.metric.IAdMetricServiceAdapter;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.thread.AdThreadManagerAdapter;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.ad.tangram.toast.AdToastAdapter;
import com.tencent.ad.tangram.triple.AdTripleLink;
import com.tencent.ad.tangram.triple.AdTripleLinkAdapter;
import com.tencent.ad.tangram.util.AdAppReceiverWrapper;
import com.tencent.ad.tangram.util.AdExposureListHolder;
import com.tencent.ad.tangram.util.AdSafeUtil;
import com.tencent.ad.tangram.version.AdVersion;
import com.tencent.ad.tangram.version.AdVersionAdapter;
import com.tencent.ad.tangram.videoceiling.AdVideoCeiling;
import com.tencent.ad.tangram.videoceiling.AdVideoCeilingAdapter;
import com.tencent.ad.tangram.views.AdUISettings;
import com.tencent.ad.tangram.views.AdUISettingsAdapter;
import com.tencent.ad.tangram.views.feedback.AdFeedback;
import com.tencent.ad.tangram.views.feedback.AdFeedbackAdapter;
import com.tencent.ad.tangram.views.floatwindow.AdFloatWindow;
import com.tencent.ad.tangram.views.floatwindow.AdFloatWindowAdapter;
import com.tencent.ad.tangram.web.AdBrowser;
import com.tencent.ad.tangram.web.AdBrowserAdapter;
import com.tencent.ad.tangram.wechat.AdWXCanvas;
import com.tencent.ad.tangram.wechat.AdWXCanvasAdapter;
import com.tencent.ad.tangram.wechat.AdWXCustomerService;
import com.tencent.ad.tangram.wechat.AdWXCustomerServiceAdapter;
import com.tencent.ad.tangram.wechat.AdWXMINIProgram;
import com.tencent.ad.tangram.wechat.AdWXMINIProgramAdapter;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdapterAPI;
import com.tencent.gdtad.IGdtMotiveAPI;
import com.tencent.gdtad.adapter.GdtThreadManagerAdapter;
import com.tencent.gdtad.adapter.GdtWXCanvasAdapter;
import com.tencent.gdtad.adapter.u;
import com.tencent.gdtad.adapter.v;
import com.tencent.gdtad.adapter.x;
import com.tencent.gdtad.aditem.GdtOuterJumpReporter;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAPI;
import com.tencent.gdtad.kuikly.IGdtKuiklyAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtManager {
    private static volatile GdtManager E;
    private AdConfigManager.Adapter A;
    private IAdMetricServiceAdapter B;
    private AdWXCustomerServiceAdapter C;
    private AdAppReceiverWrapper.Adapter D;

    /* renamed from: o, reason: collision with root package name */
    @NonNull
    private AdDownloaderAdapterV2 f109525o;

    /* renamed from: x, reason: collision with root package name */
    private AdReporterForOuterJumpAdapter f109534x;

    /* renamed from: y, reason: collision with root package name */
    private AdFloatWindowAdapter f109535y;

    /* renamed from: z, reason: collision with root package name */
    private AdInterPageAdapter f109536z;

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f109511a = false;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private AdIPCManager.Adapter f109512b = new com.tencent.gdtad.adapter.f();

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private AdLogAdapter f109513c = new com.tencent.gdtad.adapter.j();

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private AdProcessManagerAdapter f109514d = new com.tencent.gdtad.adapter.m();

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private AdThreadManagerAdapter f109515e = new GdtThreadManagerAdapter();

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private AdBrowserAdapter f109516f = new com.tencent.gdtad.adapter.b();

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    private AdVideoCeilingAdapter f109517g = new v();

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private AdQQMINIProgramAdapter f109518h = new com.tencent.gdtad.adapter.p();

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    private AdToastAdapter f109519i = new com.tencent.gdtad.adapter.r();

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    private AdProgressDialogAdapter f109520j = new com.tencent.gdtad.adapter.n();

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    private AdImageViewAdapter f109521k = new com.tencent.gdtad.adapter.g();

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    private AdVersionAdapter f109522l = new u();

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    private AdTAIDAdapter f109523m = new GdtTAIDAdapter();

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    private AdLocationAdapter f109524n = new com.tencent.gdtad.adapter.i();

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    private AdUISettingsAdapter f109526p = new com.tencent.gdtad.adapter.t();

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    private AdWXCanvasAdapter f109527q = new GdtWXCanvasAdapter();

    /* renamed from: r, reason: collision with root package name */
    @NonNull
    private AdWXMINIProgramAdapter f109528r = new x();

    /* renamed from: s, reason: collision with root package name */
    @NonNull
    private AdPrivacyPolicyManagerAdapter f109529s = new com.tencent.gdtad.adapter.l();

    /* renamed from: t, reason: collision with root package name */
    @NonNull
    private AdHalfScreenDownloadAdapter f109530t = new com.tencent.gdtad.adapter.e();

    /* renamed from: u, reason: collision with root package name */
    @NonNull
    private AdTripleLinkAdapter f109531u = new com.tencent.gdtad.adapter.s();

    /* renamed from: v, reason: collision with root package name */
    @NonNull
    private AdFeedbackAdapter f109532v = new com.tencent.gdtad.adapter.d();

    /* renamed from: w, reason: collision with root package name */
    @NonNull
    private AdDeviceAdapter f109533w = new com.tencent.gdtad.adapter.c();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static final class a {
    }

    GdtManager() {
    }

    private void A(final Context context) {
        AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.util.l
            @Override // java.lang.Runnable
            public final void run() {
                GdtManager.C(context);
            }
        }, "GdtManager", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        this.f109536z = ((IGdtAdapterAPI) QRoute.api(IGdtAdapterAPI.class)).createAdInterPageAdapter();
        AdInterPage.getInstance().setAdapter(new WeakReference<>(this.f109536z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(Context context) {
        ((IGdtMotiveAPI) QRoute.api(IGdtMotiveAPI.class)).registerIPCForHippy(context);
    }

    public static GdtManager q() {
        if (E == null) {
            synchronized (GdtManager.class) {
                if (E == null) {
                    E = new GdtManager();
                }
            }
        }
        return E;
    }

    private void s(Context context, a aVar) {
        AdExposureListHolder.getInstance().init(context);
    }

    private void t(Context context, a aVar) {
        if (this.f109511a) {
            return;
        }
        synchronized (GdtManager.class) {
            if (this.f109511a) {
                return;
            }
            this.f109511a = true;
            AdIPCManager.getInstance().init(context, new WeakReference<>(this.f109512b));
            AdLog.setAdapter(new WeakReference(this.f109513c));
            AdProcessManager.getInstance().setAdapter(new WeakReference<>(this.f109514d));
            AdThreadManager.getInstance().setAdapter(new WeakReference<>(this.f109515e));
            AdBrowser.getInstance().setAdapter(new WeakReference<>(this.f109516f));
            AdVideoCeiling.getInstance().setAdapter(new WeakReference<>(this.f109517g));
            AdQQMINIProgram.getInstance().setAdapter(new WeakReference<>(this.f109518h));
            AdToast.getInstance().setAdapter(new WeakReference<>(this.f109519i));
            AdProgressDialog.getInstance().setAdapter(new WeakReference<>(this.f109520j));
            AdImageViewBuilder.getInstance().setAdapter(new WeakReference<>(this.f109521k));
            AdVersion.getInstance().setAdapter(new WeakReference<>(this.f109522l));
            AdTAID.getInstance().setAdapter(new WeakReference<>(this.f109523m));
            AdLocationManager.getInstance().setAdapter(new WeakReference<>(this.f109524n));
            AdUISettings.getInstance().setAdapter(new WeakReference<>(this.f109526p));
            AdWXCanvas.getInstance().setAdapter(new WeakReference<>(this.f109527q));
            AdWXMINIProgram.getInstance().setAdapter(new WeakReference<>(this.f109528r));
            AdPrivacyPolicyManager.getInstance().setAdapter(new WeakReference<>(this.f109529s));
            AdHalfScreenDownload.getInstance().setAdapter(new WeakReference<>(this.f109530t));
            AdTripleLink.getInstance().setAdapter(new WeakReference<>(this.f109531u));
            AdFeedback.getInstance().setAdapter(new WeakReference<>(this.f109532v));
            AdDevice.getInstance().setAdapter(new WeakReference<>(this.f109533w));
            AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.util.GdtManager.1
                @Override // java.lang.Runnable
                public void run() {
                    GdtManager.this.f109525o = ((IGdtAdapterAPI) QRoute.api(IGdtAdapterAPI.class)).getDownloadAdapter();
                    AdDownloaderV2.getInstance().setAdapter(new WeakReference<>(GdtManager.this.f109525o));
                }
            }, "GdtManager", "[createDownloadAdapter]");
            AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.util.GdtManager.2
                @Override // java.lang.Runnable
                public void run() {
                    GdtManager.this.f109534x = ((IGdtAdapterAPI) QRoute.api(IGdtAdapterAPI.class)).createReporterForOuterJumpAdapter();
                    AdReporterForOuterJump.getInstance().setAdapter(new WeakReference<>(GdtManager.this.f109534x));
                }
            }, "GdtManager", "[createReporterForOuterJumpAdapter]");
            AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.util.GdtManager.3
                @Override // java.lang.Runnable
                public void run() {
                    GdtManager.this.f109535y = ((IGdtAdapterAPI) QRoute.api(IGdtAdapterAPI.class)).createFloatWindowAdapter();
                    AdFloatWindow.getInstance().setAdapter(new WeakReference<>(GdtManager.this.f109535y));
                }
            }, "GdtManager", "[createFloatWindowAdapter]");
            AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.util.m
                @Override // java.lang.Runnable
                public final void run() {
                    GdtManager.this.B();
                }
            }, "GdtManager", "[createAdInterPageAdapter]");
            AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.util.GdtManager.4
                @Override // java.lang.Runnable
                public void run() {
                    GdtManager.this.A = ((IGdtAdapterAPI) QRoute.api(IGdtAdapterAPI.class)).createConfigManagerAdapter();
                    AdConfigManager.getInstance().setAdapter(new WeakReference<>(GdtManager.this.A));
                }
            }, "GdtManager", "[createConfigManagerAdapter]");
            AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.util.GdtManager.5
                @Override // java.lang.Runnable
                public void run() {
                    GdtManager.this.B = ((IGdtAdapterAPI) QRoute.api(IGdtAdapterAPI.class)).createMetricServiceAdapter();
                    AdMetricService.getInstance().setAdapter(new WeakReference<>(GdtManager.this.B));
                }
            }, "GdtManager", "[createMetricServiceAdapter]");
            AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.util.GdtManager.6
                @Override // java.lang.Runnable
                public void run() {
                    GdtManager.this.C = ((IGdtAdapterAPI) QRoute.api(IGdtAdapterAPI.class)).createWXCustomerServiceScreenAdapter();
                    AdWXCustomerService.getInstance().setAdapter(new WeakReference<>(GdtManager.this.C));
                }
            }, "GdtManager", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.util.GdtManager.7
                @Override // java.lang.Runnable
                public void run() {
                    GdtManager.this.D = ((IGdtAdapterAPI) QRoute.api(IGdtAdapterAPI.class)).createAppReceiverWrapperAdapter();
                    AdAppReceiverWrapper.getInstance().setAdapter(new WeakReference<>(GdtManager.this.D));
                }
            }, "GdtManager", "");
        }
    }

    private void u() {
        GdtOuterJumpReporter.getInstance().registerOuterReportHandler();
    }

    private void v(Context context, a aVar) {
        GdtDeviceInfoHelper.init(context);
    }

    private void w(final Context context) {
        AdSafeUtil.safeRun(new Runnable() { // from class: com.tencent.gdtad.util.GdtManager.8
            @Override // java.lang.Runnable
            public void run() {
                AdDownloadUrlManager.getInstance().init(context);
            }
        }, "GdtManager", "[initForDownload]");
    }

    private void x(Context context, a aVar) {
        ((IGdtInterstitialAPI) QRoute.api(IGdtInterstitialAPI.class)).init(context);
    }

    private void y(Context context) {
        try {
            ((IGdtKuiklyAPI) QRoute.api(IGdtKuiklyAPI.class)).init(context);
        } catch (Throwable th5) {
            QLog.e("GdtManager", 1, "[initForKuikly]", th5);
        }
    }

    private void z(Context context) {
        ((IGdtAPI) QRoute.api(IGdtAPI.class)).initLandingPageConfig(context);
    }

    @Deprecated
    public void r(Context context, a aVar) {
        GdtLog.i("GdtManager", String.format("init allowed:%b", Boolean.valueOf(PrivacyPolicyHelper.isUserAllow())));
        t(context, aVar);
        AdManagerForQQ.getInstance().init(new WeakReference<>(context));
        v(context, aVar);
        x(context, aVar);
        s(context, aVar);
        z(context);
        A(context);
        u();
        w(context);
        y(context);
    }
}
