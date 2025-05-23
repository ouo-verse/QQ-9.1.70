package com.tencent.gdtad.basics.motivevideo.hippy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveHippyParams;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.basics.motivevideo.hippy.i;
import com.tencent.gdtad.basics.motivevideo.report.GdtAnalysisHelperForMotiveAd;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.gdt_motive_hippy_data;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: r, reason: collision with root package name */
    private static boolean f108960r = false;

    /* renamed from: b, reason: collision with root package name */
    private GdtMotiveVideoModel f108962b;

    /* renamed from: c, reason: collision with root package name */
    private i f108963c;

    /* renamed from: d, reason: collision with root package name */
    private StartGdtMotiveVideoParams f108964d;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference<om0.d> f108965e;

    /* renamed from: n, reason: collision with root package name */
    private long f108974n;

    /* renamed from: a, reason: collision with root package name */
    private View f108961a = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f108966f = false;

    /* renamed from: l, reason: collision with root package name */
    private final GdtThirdProcessorProxy f108972l = new GdtThirdProcessorProxy();

    /* renamed from: m, reason: collision with root package name */
    private final com.tencent.gdtad.basics.motivevideo.report.d f108973m = new com.tencent.gdtad.basics.motivevideo.report.d();

    /* renamed from: o, reason: collision with root package name */
    private volatile boolean f108975o = false;

    /* renamed from: p, reason: collision with root package name */
    private final Handler f108976p = new Handler(Looper.getMainLooper());

    /* renamed from: q, reason: collision with root package name */
    private final Runnable f108977q = new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.a
        @Override // java.lang.Runnable
        public final void run() {
            d.this.O();
        }
    };

    /* renamed from: g, reason: collision with root package name */
    private final c f108967g = new c();

    /* renamed from: h, reason: collision with root package name */
    private final e f108968h = new e();

    /* renamed from: i, reason: collision with root package name */
    private final b f108969i = new b(new WeakReference(this));

    /* renamed from: j, reason: collision with root package name */
    private final C1154d f108970j = new C1154d();

    /* renamed from: k, reason: collision with root package name */
    private final a f108971k = new a(new WeakReference(this));

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a implements com.tencent.gdtad.basics.motivevideo.hippy.video.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<d> f108978a;

        public a(WeakReference<d> weakReference) {
            this.f108978a = weakReference;
        }

        @Override // com.tencent.gdtad.basics.motivevideo.hippy.video.a
        public void a() {
            d dVar;
            long j3;
            WeakReference<d> weakReference = this.f108978a;
            GdtMotiveVideoModel gdtMotiveVideoModel = null;
            if (weakReference != null) {
                dVar = weakReference.get();
            } else {
                dVar = null;
            }
            if (dVar != null) {
                gdtMotiveVideoModel = dVar.f108962b;
            }
            GdtMotiveVideoModel gdtMotiveVideoModel2 = gdtMotiveVideoModel;
            if (dVar != null) {
                j3 = dVar.G();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.l("GdtMotiveHippyController", "[GdtMotiveVideoListener][onPrepareStart]", AdMetricID.Reward.HIPPY_VIDEO_PREPARE_START, AdMetricID.Reward.HIPPY_VIDEO_PREPARE_START_TIME_MILLIS, gdtMotiveVideoModel2, j3);
        }

        @Override // com.tencent.gdtad.basics.motivevideo.hippy.video.a
        public void onError(int i3, int i16, int i17, String str) {
            d dVar;
            long j3;
            WeakReference<d> weakReference = this.f108978a;
            GdtMotiveVideoModel gdtMotiveVideoModel = null;
            if (weakReference != null) {
                dVar = weakReference.get();
            } else {
                dVar = null;
            }
            String str2 = "[GdtMotiveVideoListener][onError] module:" + i3 + " errorType:" + i16 + " errorCode:" + i17 + " extraInfo:" + str;
            if (dVar != null) {
                gdtMotiveVideoModel = dVar.f108962b;
            }
            GdtMotiveVideoModel gdtMotiveVideoModel2 = gdtMotiveVideoModel;
            if (dVar != null) {
                j3 = dVar.G();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.g("GdtMotiveHippyController", str2, null, AdMetricID.Reward.HIPPY_VIDEO_ERROR, AdMetricID.Reward.HIPPY_VIDEO_ERROR_TIME_MILLIS, gdtMotiveVideoModel2, j3, i3, i16, i17);
        }

        @Override // com.tencent.gdtad.basics.motivevideo.hippy.video.a
        public void onFirstFrameRendered() {
            d dVar;
            WeakReference<d> weakReference = this.f108978a;
            if (weakReference != null) {
                dVar = weakReference.get();
            } else {
                dVar = null;
            }
            if (dVar == null) {
                QLog.e("GdtMotiveHippyController", 1, "[GdtMotiveVideoListener][onFirstFrameRendered] controller is null");
            } else {
                QLog.i("GdtMotiveHippyController", 1, "[GdtMotiveVideoListener][onFirstFrameRendered]");
                dVar.T();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class b implements LibraryLoadListener {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<d> f108979a;

        public b(WeakReference<d> weakReference) {
            this.f108979a = weakReference;
        }

        @Override // com.tencent.hippy.qq.api.LibraryLoadListener
        public void onLoadFail(int i3, String str) {
            d dVar;
            GdtMotiveVideoModel gdtMotiveVideoModel;
            long j3;
            Activity activity;
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            WeakReference<d> weakReference = this.f108979a;
            if (weakReference != null) {
                dVar = weakReference.get();
            } else {
                dVar = null;
            }
            String str2 = "[onLoadFail] statusCode:" + i3 + " errorMsg:" + str;
            if (dVar != null) {
                gdtMotiveVideoModel = dVar.f108962b;
            } else {
                gdtMotiveVideoModel = null;
            }
            if (dVar != null) {
                j3 = dVar.G();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.i("GdtMotiveHippyController", str2, null, AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_LOAD_LIBRARY_FAILED, AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_LOAD_LIBRARY_FAILED_TIME_MILLIS, gdtMotiveVideoModel, j3, 6, AdMetricTag.Reward.ERROR_CODE_LOAD_LIBRARY, Integer.valueOf(i3));
            if (dVar != null) {
                if (dVar.f108964d != null) {
                    activity = dVar.f108964d.activity;
                } else {
                    activity = null;
                }
                if (dVar.f108964d != null) {
                    gdtMotiveVideoPageData = dVar.f108964d.data;
                } else {
                    gdtMotiveVideoPageData = null;
                }
                GdtAnalysisHelperForMotiveAd.k(activity, gdtMotiveVideoPageData, dVar.G(), 6);
                dVar.Q(6, i3);
            }
        }

        @Override // com.tencent.hippy.qq.api.LibraryLoadListener
        public void onLoadSuccess() {
            d dVar;
            long j3;
            WeakReference<d> weakReference = this.f108979a;
            GdtMotiveVideoModel gdtMotiveVideoModel = null;
            if (weakReference != null) {
                dVar = weakReference.get();
            } else {
                dVar = null;
            }
            if (dVar != null) {
                gdtMotiveVideoModel = dVar.f108962b;
            }
            GdtMotiveVideoModel gdtMotiveVideoModel2 = gdtMotiveVideoModel;
            if (dVar != null) {
                j3 = dVar.G();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.l("GdtMotiveHippyController", "[onLoadSuccess]", AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_LOAD_LIBRARY_SUCCESS, AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_LOAD_LIBRARY_SUCCESS_TIME_MILLIS, gdtMotiveVideoModel2, j3);
            if (dVar != null) {
                dVar.K(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public final class c implements om0.a {
        c() {
        }

        @Override // om0.a
        public void a(String str) {
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[onAdClicked]", AdMetricID.Reward.HIPPY_EVENT_LISTENER_ON_CLICK, d.this.f108962b);
            d dVar = d.this;
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(dVar.F(dVar.f108962b, str));
        }

        @Override // om0.a
        public void b() {
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[onAdPresent]", AdMetricID.Reward.HIPPY_EVENT_LISTENER_ON_PRESENT, d.this.f108962b);
            d.this.U(0);
        }

        @Override // om0.a
        public void c() {
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[onUserEarnedReward]", AdMetricID.Reward.HIPPY_EVENT_LISTENER_ON_REWARD, d.this.f108962b);
            d.this.f108966f = true;
            d.this.U(2);
        }

        @Override // om0.a
        public void d(int i3, String str) {
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[onNativeRenderer]", AdMetricID.Reward.HIPPY_EVENT_LISTENER_ON_NATIVE_RENDER, d.this.f108962b);
            d.this.Q(21, i3);
        }

        @Override // om0.a
        public String e(List<String> list) {
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[onSwitchAd]", AdMetricID.Reward.HIPPY_EVENT_LISTENER_ON_SWITCH_AD, d.this.f108962b);
            return d.this.E(list);
        }

        @Override // om0.a
        public void f(int i3) {
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[onAdClosed] playTimeSec:" + i3, AdMetricID.Reward.HIPPY_EVENT_LISTENER_ON_CLOSED, d.this.f108962b);
            d.this.f108974n = (long) (i3 * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.basics.motivevideo.hippy.d$d, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1154d implements om0.c {
        C1154d() {
        }

        @Override // om0.c
        public void a() {
            QLog.i("GdtMotiveHippyController", 1, "[onAdPlayError]");
        }

        @Override // om0.c
        public void onAdPlayComplete() {
            QLog.i("GdtMotiveHippyController", 1, "[onAdPlayComplete]");
        }

        @Override // om0.c
        public void onAdPlayPause() {
            QLog.i("GdtMotiveHippyController", 1, "[onAdPlayPause]");
        }

        @Override // om0.c
        public void onAdPlayResume() {
            QLog.i("GdtMotiveHippyController", 1, "[onAdPlayResume]");
        }

        @Override // om0.c
        public void onAdPlayStart() {
            QLog.i("GdtMotiveHippyController", 1, "[onAdPlayStart]");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public final class e implements om0.b {
        e() {
        }

        private void j(int i3, int i16) {
            d.this.Q(i3, i16);
        }

        private void k() {
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            if (d.this.f108964d != null) {
                gdtMotiveVideoPageData = d.this.f108964d.data;
            } else {
                gdtMotiveVideoPageData = null;
            }
            if (gdtMotiveVideoPageData != null && gdtMotiveVideoPageData.hippyParams != null) {
                i iVar = d.this.f108963c;
                if (iVar == null) {
                    com.tencent.gdtad.basics.motivevideo.report.a.j("GdtMotiveHippyController", "[setCurrentJsBundleVersion] error, hippyEngine is null", null, AdMetricID.Reward.HIPPY_SET_CURRENT_JS_BUNDLE_VERSION_FAILED, d.this.f108962b, 1);
                    return;
                }
                String H = iVar.H();
                gdtMotiveVideoPageData.hippyParams.setCurrentJsBundleVersion(H);
                com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[setCurrentJsBundleVersion] jsBundleVersion:" + H, AdMetricID.Reward.HIPPY_SET_CURRENT_JS_BUNDLE_VERSION_SUCCESS, d.this.f108962b);
                return;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.j("GdtMotiveHippyController", "[setCurrentJsBundleVersion] error", null, AdMetricID.Reward.HIPPY_SET_CURRENT_JS_BUNDLE_VERSION_FAILED, d.this.f108962b, 1);
        }

        @Override // om0.b
        public void a(int i3) {
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            com.tencent.gdtad.basics.motivevideo.report.a.h("GdtMotiveHippyController", "[onCheckParamsFailed]", null, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_CHECK_PARAM_FAILED, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_CHECK_PARAM_FAILED_TIME_MILLIS, d.this.f108962b, d.this.G(), Integer.valueOf(i3));
            Activity D = d.this.D();
            if (d.this.f108964d != null) {
                gdtMotiveVideoPageData = d.this.f108964d.data;
            } else {
                gdtMotiveVideoPageData = null;
            }
            GdtAnalysisHelperForMotiveAd.f(D, gdtMotiveVideoPageData, d.this.G(), i3);
            j(i3, Integer.MIN_VALUE);
        }

        @Override // om0.b
        public void b(int i3, int i16) {
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            com.tencent.gdtad.basics.motivevideo.report.a.i("GdtMotiveHippyController", "[onLoadJSBundleFailed] errorCode:" + i3 + " originErrorCode:" + i16, null, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_LOAD_JS_BUNDLE_FAILED, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_LOAD_JS_BUNDLE_FAILED_TIME_MILLIS, d.this.f108962b, d.this.G(), Integer.valueOf(i3), AdMetricTag.Reward.ERROR_CODE_LOAD_JS_BUNDLE, Integer.valueOf(i16));
            Activity D = d.this.D();
            if (d.this.f108964d != null) {
                gdtMotiveVideoPageData = d.this.f108964d.data;
            } else {
                gdtMotiveVideoPageData = null;
            }
            GdtAnalysisHelperForMotiveAd.l(D, gdtMotiveVideoPageData, d.this.G(), i3, i16);
            j(i3, i16);
        }

        @Override // om0.b
        public void c(View view) {
            om0.d dVar;
            com.tencent.gdtad.basics.motivevideo.report.a.l("GdtMotiveHippyController", "[onCreateViewSuccess]", AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_CREATE_VIEW_SUCCESS, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_CREATE_VIEW_SUCCESS_TIME_MILLIS, d.this.f108962b, d.this.G());
            d.this.S();
            GdtMotiveVideoPageData gdtMotiveVideoPageData = null;
            if (d.this.f108965e != null) {
                dVar = (om0.d) d.this.f108965e.get();
            } else {
                dVar = null;
            }
            if (dVar != null && view != null) {
                Activity D = d.this.D();
                if (d.this.f108964d != null) {
                    gdtMotiveVideoPageData = d.this.f108964d.data;
                }
                GdtAnalysisHelperForMotiveAd.d(D, gdtMotiveVideoPageData, d.this.G(), true);
                dVar.addView(view);
            }
        }

        @Override // om0.b
        public void d() {
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            com.tencent.gdtad.basics.motivevideo.report.a.l("GdtMotiveHippyController", "[onShowViewSuccess]", AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_SHOW_VIEW_SUCCESS, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_SHOW_VIEW_SUCCESS_TIME_MILLIS, d.this.f108962b, d.this.G());
            d.this.f108976p.removeCallbacks(d.this.f108977q);
            Activity D = d.this.D();
            if (d.this.f108964d != null) {
                gdtMotiveVideoPageData = d.this.f108964d.data;
            } else {
                gdtMotiveVideoPageData = null;
            }
            GdtAnalysisHelperForMotiveAd.o(D, gdtMotiveVideoPageData, d.this.G());
        }

        @Override // om0.b
        public void e() {
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            com.tencent.gdtad.basics.motivevideo.report.a.l("GdtMotiveHippyController", "[onLoadJSBundleSuccess]", AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_LOAD_JS_BUNDLE_SUCCESS, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_LOAD_JS_BUNDLE_SUCCESS_TIME_MILLIS, d.this.f108962b, d.this.G());
            Activity D = d.this.D();
            if (d.this.f108964d != null) {
                gdtMotiveVideoPageData = d.this.f108964d.data;
            } else {
                gdtMotiveVideoPageData = null;
            }
            GdtAnalysisHelperForMotiveAd.m(D, gdtMotiveVideoPageData, d.this.G());
        }

        @Override // om0.b
        public void f(int i3, int i16) {
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            com.tencent.gdtad.basics.motivevideo.report.a.i("GdtMotiveHippyController", "[onInitializeEngineFailed] errorCode:" + i3 + " originErrorCode:" + i16, null, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_INITIALIZE_ENGINE_FAILED, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_INITIALIZE_ENGINE_FAILED_TIME_MILLIS, d.this.f108962b, d.this.G(), Integer.valueOf(i3), AdMetricTag.Reward.ERROR_CODE_INITIALIZE_ENGINE, Integer.valueOf(i16));
            Activity D = d.this.D();
            if (d.this.f108964d != null) {
                gdtMotiveVideoPageData = d.this.f108964d.data;
            } else {
                gdtMotiveVideoPageData = null;
            }
            GdtAnalysisHelperForMotiveAd.i(D, gdtMotiveVideoPageData, d.this.G(), i3, i16);
            j(i3, i16);
        }

        @Override // om0.b
        public void g() {
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            com.tencent.gdtad.basics.motivevideo.report.a.l("GdtMotiveHippyController", "[onInitializeEngineSuccess]", AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_INITIALIZE_ENGINE_SUCCESS, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_INITIALIZE_ENGINE_SUCCESS_TIME_MILLIS, d.this.f108962b, d.this.G());
            Activity D = d.this.D();
            if (d.this.f108964d != null) {
                gdtMotiveVideoPageData = d.this.f108964d.data;
            } else {
                gdtMotiveVideoPageData = null;
            }
            GdtAnalysisHelperForMotiveAd.j(D, gdtMotiveVideoPageData, d.this.G());
        }

        @Override // om0.b
        public void h(int i3, int i16) {
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            com.tencent.gdtad.basics.motivevideo.report.a.i("GdtMotiveHippyController", "[onCreateViewFailed] errorCode:" + i3 + " originErrorCode:" + i16, null, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_CREATE_VIEW_FAILED, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_CREATE_VIEW_FAILED_TIME_MILLIS, d.this.f108962b, d.this.G(), Integer.valueOf(i3), AdMetricTag.Reward.ERROR_CODE_CREATE_VIEW, Integer.valueOf(i16));
            Activity D = d.this.D();
            if (d.this.f108964d != null) {
                gdtMotiveVideoPageData = d.this.f108964d.data;
            } else {
                gdtMotiveVideoPageData = null;
            }
            GdtAnalysisHelperForMotiveAd.h(D, gdtMotiveVideoPageData, d.this.G(), i3, i16);
            j(i3, i16);
        }

        @Override // om0.b
        public void i() {
            GdtMotiveVideoPageData gdtMotiveVideoPageData;
            com.tencent.gdtad.basics.motivevideo.report.a.l("GdtMotiveHippyController", "[onCheckParamsSuccess]", AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_CHECK_PARAM_SUCCESS, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_CHECK_PARAM_SUCCESS_TIME_MILLIS, d.this.f108962b, d.this.G());
            Activity D = d.this.D();
            if (d.this.f108964d != null) {
                gdtMotiveVideoPageData = d.this.f108964d.data;
            } else {
                gdtMotiveVideoPageData = null;
            }
            GdtAnalysisHelperForMotiveAd.g(D, gdtMotiveVideoPageData, d.this.G());
            d.this.Z(1);
        }

        @Override // om0.b
        public void onClose() {
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[onClose]", AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_CLOSE, d.this.f108962b);
            d.this.y(0, Integer.MIN_VALUE);
        }

        @Override // om0.b
        public void onWillCreateEngine() {
            com.tencent.gdtad.basics.motivevideo.report.a.l("GdtMotiveHippyController", "[onWillCreateEngine]", AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_WILL_CREATE_ENGINE, AdMetricID.Reward.HIPPY_SHOW_LISTENER_ON_WILL_CREATE_ENGINE_TIME_MILLIS, d.this.f108962b, d.this.G());
            k();
        }
    }

    d(StartGdtMotiveVideoParams startGdtMotiveVideoParams, WeakReference<om0.d> weakReference) {
        this.f108965e = weakReference;
        J(startGdtMotiveVideoParams);
        K(false);
    }

    private static String B(GdtMotiveVideoModel gdtMotiveVideoModel, int i3, int i16, int i17, List<String> list) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        int i18;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        } else {
            gdtMotiveVideoPageData = null;
        }
        if (gdtMotiveVideoPageData != null && gdtMotiveVideoModel.getGdtAd() != null && gdtMotiveVideoPageData.hippyParams != null) {
            GdtAd gdtAd = gdtMotiveVideoModel.getGdtAd();
            Gson gson = new Gson();
            gdt_motive_hippy_data.MotiveHippyData motiveHippyData = new gdt_motive_hippy_data.MotiveHippyData();
            motiveHippyData.extendInfo.baseInfo.posId = gdtAd.getPosId();
            motiveHippyData.extendInfo.baseInfo.traceId = gdtAd.getTraceId();
            motiveHippyData.extendInfo.baseInfo.adId = String.valueOf(gdtAd.getAId());
            motiveHippyData.extendInfo.baseInfo.originalExposureUrl = gdtAd.getOriginalExposureUrl();
            motiveHippyData.extendInfo.baseInfo.effectExposureUrl = gdtAd.getUrlForImpression();
            gdt_motive_hippy_data.MotiveHippyData.ExtendInfo.BaseInfo baseInfo = motiveHippyData.extendInfo.baseInfo;
            baseInfo.adHeight = i16;
            baseInfo.adWidth = i17;
            baseInfo.safeAreaTop = i3;
            baseInfo.funcSwitch = C(list);
            motiveHippyData.extendInfo.templateId = gdtMotiveVideoPageData.hippyParams.getTemplateId();
            motiveHippyData.extendInfo.rewardAd.info.unlockTime = GdtUtil.getRewardTime(gdtMotiveVideoModel);
            gdt_motive_hippy_data.MotiveHippyData.ExtendInfo.RewardAd.Info info = motiveHippyData.extendInfo.rewardAd.info;
            info.initialAdListCount = 1;
            info.displayType = gdtAd.getRewardPlayType();
            gdt_motive_hippy_data.MotiveHippyData.ExtendInfo.RewardAd rewardAd = motiveHippyData.extendInfo.rewardAd;
            gdt_motive_hippy_data.MotiveHippyData.ExtendInfo.RewardAd.Info info2 = rewardAd.info;
            if (gdtMotiveVideoPageData.screenOrientation == 0) {
                i18 = 0;
            } else {
                i18 = 1;
            }
            info2.displayOrientation = i18;
            gdt_motive_hippy_data.MotiveHippyData.ExtendInfo.RewardAd.Materials materials = rewardAd.materials;
            materials.adAvatar.url = gdtMotiveVideoPageData.bannerLogo;
            materials.adImage.onlineUrl = gdtMotiveVideoPageData.previewImgUrl;
            gdt_motive_hippy_data.MotiveHippyData.ExtendInfo.RewardAd.Texts texts = rewardAd.texts;
            texts.title = gdtMotiveVideoPageData.bannerImgName;
            texts.subTitle = gdtMotiveVideoPageData.bannerBaseInfoText;
            texts.actionButtonTitle = gdtAd.getMotiveButtonText();
            gdt_motive_hippy_data.MotiveHippyData.ExtendInfo.RewardAd.Materials.AdVideo adVideo = motiveHippyData.extendInfo.rewardAd.materials.adVideo;
            adVideo.onlineUrl = gdtMotiveVideoPageData.url;
            adVideo.posterUrl = gdtMotiveVideoPageData.previewImgUrl;
            adVideo.duration = gdtAd.getVideoDuration();
            try {
                motiveHippyData.extendInfo.rewardAd.passThoughRewardInfo = (JsonObject) gson.fromJson(gdtMotiveVideoPageData.passThroughData, JsonObject.class);
            } catch (Throwable th5) {
                QLog.e("GdtMotiveHippyController", 1, "[generateAdData] gson.fromJson error", th5);
            }
            try {
                Object pbToJson = GdtJsonPbUtil.pbToJson(gdtAd.info);
                if (pbToJson instanceof JSONObject) {
                    motiveHippyData.extendInfo.adInfo = (JsonObject) gson.fromJson(pbToJson.toString(), JsonObject.class);
                } else {
                    QLog.e("GdtMotiveHippyController", 1, "[generateAdData] fill hippyData.extendInfo.adInfo error, object is not a JSONObject");
                }
            } catch (Throwable th6) {
                QLog.e("GdtMotiveHippyController", 1, "[generateAdData] fill hippyData.extendInfo.adInfo error", th6);
            }
            try {
                String json = gson.toJson(motiveHippyData);
                com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[generateAdData]", AdMetricID.Reward.HIPPY_CONTROLLER_GENERATE_DATA_SUCCESS, gdtMotiveVideoModel);
                return json;
            } catch (Throwable th7) {
                com.tencent.gdtad.basics.motivevideo.report.a.j("GdtMotiveHippyController", "[generateAdData]", th7, AdMetricID.Reward.HIPPY_CONTROLLER_GENERATE_DATA_FAILED, gdtMotiveVideoModel, 15);
                return null;
            }
        }
        com.tencent.gdtad.basics.motivevideo.report.a.j("GdtMotiveHippyController", "[generateAdData] error, not valid", null, AdMetricID.Reward.HIPPY_CONTROLLER_GENERATE_DATA_FAILED, gdtMotiveVideoModel, 1);
        return null;
    }

    private static JsonObject C(List<String> list) {
        String str;
        JsonObject jsonObject = null;
        if (list != null && !list.isEmpty()) {
            JsonObject jsonObject2 = new JsonObject();
            for (String str2 : list) {
                if (TextUtils.isEmpty(str2)) {
                    QLog.e("GdtMotiveHippyController", 1, "[generateConfigJsonObject] error, switchId is empty");
                } else {
                    boolean z16 = false;
                    try {
                        z16 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str2, false);
                    } catch (Throwable th5) {
                        QLog.e("GdtMotiveHippyController", 1, "[generateConfigJsonObject]", th5);
                    }
                    if (!z16) {
                        QLog.i("GdtMotiveHippyController", 1, "[generateConfigJsonObject], switch off, switchId:" + str2);
                    } else {
                        try {
                            str = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(str2, "");
                        } catch (Throwable th6) {
                            QLog.e("GdtMotiveHippyController", 1, "[generateConfigJsonObject]", th6);
                            str = null;
                        }
                        QLog.i("GdtMotiveHippyController", 1, "[generateConfigJsonObject], switch on, switchId:" + str2 + " config:" + str);
                        jsonObject2.addProperty(str2, str);
                    }
                }
            }
            if (jsonObject2.size() > 0) {
                jsonObject = jsonObject2;
            }
            QLog.i("GdtMotiveHippyController", 1, "[generateConfigJsonObject] switchIdList:" + list + " result:" + jsonObject);
        }
        return jsonObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity D() {
        om0.d dVar;
        WeakReference<om0.d> weakReference = this.f108965e;
        if (weakReference != null) {
            dVar = weakReference.get();
        } else {
            dVar = null;
        }
        if (dVar == null) {
            return null;
        }
        return dVar.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String E(List<String> list) {
        View view;
        int i3;
        i iVar = this.f108963c;
        if (iVar != null) {
            view = iVar.M();
        } else {
            view = null;
        }
        if (view == null) {
            QLog.e("GdtMotiveHippyController", 1, "[getAdData] error, rootView is null");
            return null;
        }
        try {
            if (f108960r) {
                i3 = GdtUIUtils.sNotchHeight;
            } else {
                i3 = GdtUIUtils.sLiuHaiTopHeight;
            }
            return B(this.f108962b, GdtUIUtils.px2dp(i3, view.getResources()), GdtUIUtils.px2dp(view.getHeight(), view.getResources()), GdtUIUtils.px2dp(view.getWidth(), view.getResources()), list);
        } catch (Throwable th5) {
            QLog.e("GdtMotiveHippyController", 1, "[getAdData]", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GdtHandler.Params F(GdtMotiveVideoModel gdtMotiveVideoModel, String str) {
        Activity D = D();
        String str2 = null;
        if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.getGdtAd() != null && gdtMotiveVideoModel.getGdtMotiveVideoPageData() != null && D != null) {
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[getClickParam]", AdMetricID.Reward.HIPPY_CONTROLLER_GET_CLICK_PARAMS_SUCCESS, gdtMotiveVideoModel);
            GdtHandler.Params params = new GdtHandler.Params();
            params.processId = gdtMotiveVideoModel.getGdtMotiveVideoPageData().processId;
            params.activity = new WeakReference<>(D);
            params.f108486ad = new GdtAd(gdtMotiveVideoModel.getAdInfo());
            params.reportForClick = true;
            params.antiSpamParams = str;
            params.extra = new Bundle();
            Intent intent = D.getIntent();
            if (intent != null) {
                str2 = intent.getStringExtra(LaunchParam.KEY_REF_ID);
                if (TextUtils.isEmpty(str2)) {
                    QLog.i("GdtMotiveHippyController", 1, "[getClickParam] refId is empty");
                    str2 = intent.getStringExtra("big_brother_source_key");
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                params.extra.putString(LaunchParam.KEY_REF_ID, str2);
            }
            return params;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.j("GdtMotiveHippyController", "[getClickParam] error", null, AdMetricID.Reward.HIPPY_CONTROLLER_GET_CLICK_PARAMS_FAILED, gdtMotiveVideoModel, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long G() {
        long I = I();
        if (I == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            QLog.e("GdtMotiveHippyController", 1, "[getCostTimeMillis] error, startTime is not valid");
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - I;
    }

    private long H() {
        long j3;
        com.tencent.gdtad.config.data.g h16 = wm0.b.m().h();
        if (h16 != null) {
            j3 = h16.initTimeOutSeconds;
        } else {
            j3 = 5;
        }
        QLog.i("GdtMotiveHippyController", 1, "[getInitTimeOutMillis] timeDelay:" + j3);
        return j3 * 1000;
    }

    private long I() {
        Activity D = D();
        if (D == null) {
            QLog.e("GdtMotiveHippyController", 1, "[getStartTimeMillis] error, activity is null");
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        Intent intent = D.getIntent();
        if (intent == null) {
            QLog.e("GdtMotiveHippyController", 1, "[getStartTimeMillis] error, intent is null");
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return intent.getLongExtra("key_motive_show_start_time", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
    }

    private void J(StartGdtMotiveVideoParams startGdtMotiveVideoParams) {
        this.f108964d = startGdtMotiveVideoParams;
        this.f108962b = new GdtMotiveVideoModel(startGdtMotiveVideoParams.data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(boolean z16) {
        Activity activity;
        long j3;
        Activity activity2;
        this.f108976p.postDelayed(this.f108977q, H());
        GdtMotiveVideoPageData gdtMotiveVideoPageData = null;
        try {
            if (!((IHippyLibrary) QRoute.api(IHippyLibrary.class)).isLibraryLoaded()) {
                com.tencent.gdtad.basics.motivevideo.report.a.l("GdtMotiveHippyController", "[initHippy] isLibraryLoaded:false", AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_LOAD_LIBRARY_START, AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_LOAD_LIBRARY_START_TIME_MILLIS, this.f108962b, G());
                ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).loadLibraryIfNeed(this.f108969i);
                return;
            }
            if (z16) {
                j3 = AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_LIBRARY_LOADED_AFTER_LOAD_LIBRARY_SUCCESS;
            } else {
                j3 = AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_LIBRARY_LOADED_BEFORE_LOAD_LIBRARY_SUCCESS;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[initHippy] isLibraryLoaded:true", j3, this.f108962b);
            StartGdtMotiveVideoParams startGdtMotiveVideoParams = this.f108964d;
            if (startGdtMotiveVideoParams != null) {
                activity2 = startGdtMotiveVideoParams.activity;
            } else {
                activity2 = null;
            }
            if (startGdtMotiveVideoParams != null) {
                gdtMotiveVideoPageData = startGdtMotiveVideoParams.data;
            }
            GdtAnalysisHelperForMotiveAd.n(activity2, gdtMotiveVideoPageData, G());
            L();
        } catch (Throwable th5) {
            com.tencent.gdtad.basics.motivevideo.report.a.h("GdtMotiveHippyController", "[initHippy]", th5, AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_LOAD_LIBRARY_FAILED, AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_LOAD_LIBRARY_FAILED_TIME_MILLIS, this.f108962b, G(), 15);
            StartGdtMotiveVideoParams startGdtMotiveVideoParams2 = this.f108964d;
            if (startGdtMotiveVideoParams2 != null) {
                activity = startGdtMotiveVideoParams2.activity;
            } else {
                activity = null;
            }
            if (startGdtMotiveVideoParams2 != null) {
                gdtMotiveVideoPageData = startGdtMotiveVideoParams2.data;
            }
            GdtAnalysisHelperForMotiveAd.k(activity, gdtMotiveVideoPageData, G(), 15);
            Q(6, Integer.MIN_VALUE);
        }
    }

    private void L() {
        boolean z16;
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        Activity D = D();
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f108962b;
        boolean z17 = true;
        if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.getGdtMotiveVideoPageData() != null && D != null) {
            GdtMotiveHippyParams gdtMotiveHippyParams = this.f108962b.getGdtMotiveVideoPageData().hippyParams;
            if (gdtMotiveHippyParams == null) {
                com.tencent.gdtad.basics.motivevideo.report.a.j("GdtMotiveHippyController", "[initView] error, gdtHippyParams is null", null, AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_VIEW_FAILED, this.f108962b, 1);
                return;
            }
            if (this.f108963c == null) {
                this.f108963c = new i();
            }
            this.f108963c.o0(new WeakReference<>(this.f108970j));
            i.c cVar = new i.c();
            cVar.f109005a = new WeakReference<>(D);
            cVar.f109006b = gdtMotiveHippyParams.getTemplateId();
            cVar.f109007c = new WeakReference<>(this.f108968h);
            cVar.f109008d = new WeakReference<>(this.f108967g);
            cVar.f109009e = new WeakReference<>(this.f108971k);
            if (D.getResources().getConfiguration().orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || !this.f108962b.getGdtMotiveVideoPageData().isForcePortrait) {
                z17 = false;
            }
            f108960r = z17;
            StartGdtMotiveVideoParams startGdtMotiveVideoParams = this.f108964d;
            if (startGdtMotiveVideoParams != null && (gdtMotiveVideoPageData = startGdtMotiveVideoParams.data) != null) {
                gdtMotiveVideoPageData.isLandscapeForcePortrait = z17;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[initView] isOriLandscape:" + z16 + " isForcePortrait:" + this.f108962b.getGdtMotiveVideoPageData().isForcePortrait, AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_VIEW_SUCCESS, this.f108962b);
            this.f108963c.p0(cVar);
            GdtUIUtils.enableTopLiuHaiIfNeeded(D, this.f108962b.getGdtMotiveVideoPageData().screenOrientation);
            v();
            return;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.j("GdtMotiveHippyController", "[initView] error, not valid", null, AdMetricID.Reward.HIPPY_CONTROLLER_INITIALIZE_VIEW_FAILED, this.f108962b, 1);
    }

    private static boolean M(StartGdtMotiveVideoParams startGdtMotiveVideoParams) {
        GdtMotiveHippyParams gdtMotiveHippyParams;
        if (startGdtMotiveVideoParams == null) {
            QLog.e("GdtMotiveHippyController", 1, "[initData] error, params is null");
            return false;
        }
        GdtMotiveVideoPageData gdtMotiveVideoPageData = startGdtMotiveVideoParams.data;
        if (gdtMotiveVideoPageData != null && (gdtMotiveHippyParams = gdtMotiveVideoPageData.hippyParams) != null) {
            if (gdtMotiveHippyParams.isValid()) {
                return true;
            }
            QLog.e("GdtMotiveHippyController", 1, "[initData] error, hippyParams is inValid");
            return false;
        }
        QLog.e("GdtMotiveHippyController", 1, "[initData] error, hippyParams is null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        boolean z16;
        om0.d dVar;
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[addLoadingView] invoke addView, mLoadingView:");
            boolean z17 = false;
            if (this.f108961a != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            String sb6 = sb5.toString();
            if (this.f108961a == null) {
                z17 = true;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.e("GdtMotiveHippyController", sb6, null, z17, AdMetricID.Reward.HIPPY_CONTROLLER_ADD_LOADING_VIEW_SUCCESS, AdMetricID.Reward.HIPPY_CONTROLLER_ADD_LOADING_VIEW_FAILED, this.f108962b, 1);
            this.f108961a = z();
            WeakReference<om0.d> weakReference = this.f108965e;
            if (weakReference != null) {
                dVar = weakReference.get();
            } else {
                dVar = null;
            }
            if (dVar != null) {
                dVar.addView(this.f108961a);
            }
        } catch (Throwable th5) {
            QLog.e("GdtMotiveHippyController", 1, "[addLoadingView]", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O() {
        QLog.i("GdtMotiveHippyController", 1, "[timeout]");
        Q(13, Integer.MIN_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        om0.d dVar;
        boolean z16;
        WeakReference<om0.d> weakReference = this.f108965e;
        if (weakReference != null) {
            dVar = weakReference.get();
        } else {
            dVar = null;
        }
        if (this.f108961a != null) {
            if (dVar != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.e("GdtMotiveHippyController", "[removeLoadingView] invoke removeView, mLoadingView:", null, z16, AdMetricID.Reward.HIPPY_CONTROLLER_REMOVE_LOADING_VIEW_SUCCESS, AdMetricID.Reward.HIPPY_CONTROLLER_REMOVE_LOADING_VIEW_FAILED, this.f108962b, 1);
        }
        if (dVar != null) {
            dVar.removeView(this.f108961a);
        }
        this.f108961a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i3, int i16) {
        com.tencent.gdtad.basics.motivevideo.report.a.n("GdtMotiveHippyController", "[onHippyShowError] errorCode:" + i3 + " subCode:" + i16, AdMetricID.Reward.HIPPY_CONTROLLER_ON_SHOW_ERROR, this.f108962b, Integer.valueOf(i3));
        X(this.f108964d, i3);
        y(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        Activity D = D();
        if (D == null) {
            com.tencent.gdtad.basics.motivevideo.report.a.j("GdtMotiveHippyController", "[removeLoadingView] error, activity is null", null, AdMetricID.Reward.HIPPY_CONTROLLER_REMOVE_LOADING_VIEW_FAILED, this.f108962b, 1);
        } else {
            D.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.P();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        Activity D = D();
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f108962b;
        if (gdtMotiveVideoModel != null) {
            gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        } else {
            gdtMotiveVideoPageData = null;
        }
        if (gdtMotiveVideoPageData != null && D != null && D.getIntent() != null) {
            if (this.f108975o) {
                QLog.i("GdtMotiveHippyController", 1, "[reportForMotiveVideoFirstFrameRendered] first frame reported");
                return;
            }
            this.f108975o = true;
            Intent intent = D.getIntent();
            long j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            long longExtra = intent.getLongExtra("key_motive_show_start_time", WebViewConstants.WV.ENABLE_WEBAIO_SWITCH);
            if (longExtra != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                j3 = System.currentTimeMillis() - longExtra;
            }
            com.tencent.gdtad.basics.motivevideo.report.a.l("GdtMotiveHippyController", "[reportForMotiveVideoFirstFrameRendered]", AdMetricID.Reward.HIPPY_VIDEO_FIRST_FRAME_RENDERED, AdMetricID.Reward.HIPPY_VIDEO_FIRST_FRAME_RENDERED_TIME_MILLIS, this.f108962b, j3);
            GdtAnalysisHelperForMotiveAd.u(D, gdtMotiveVideoPageData, j3, true);
            return;
        }
        QLog.e("GdtMotiveHippyController", 1, "[reportForMotiveVideoFirstFrameRendered] report params error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i3) {
        String str;
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f108962b;
        if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.getGdtMotiveVideoPageData() != null) {
            GdtMotiveVideoPageData gdtMotiveVideoPageData = this.f108962b.getGdtMotiveVideoPageData();
            GdtAd gdtAd = this.f108962b.getGdtAd();
            try {
                com.tencent.gdtad.basics.motivevideo.report.d dVar = this.f108973m;
                long serverTime = NetConnInfoCenter.getServerTime();
                if (gdtAd != null) {
                    str = String.valueOf(gdtAd.getAId());
                } else {
                    str = "";
                }
                dVar.a(i3, serverTime, str, gdtMotiveVideoPageData.appId);
                return;
            } catch (Exception e16) {
                QLog.e("GdtMotiveHippyController", 1, "[reportMiniGdtMvAction] error", e16);
                return;
            }
        }
        QLog.e("GdtMotiveHippyController", 1, "[reportMiniGdtMvAction] data is null");
    }

    public static void X(StartGdtMotiveVideoParams startGdtMotiveVideoParams, int i3) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        if (startGdtMotiveVideoParams != null && startGdtMotiveVideoParams.data != null) {
            com.tencent.gdtad.basics.motivevideo.report.a.q("GdtMotiveHippyController", "[startNativeMotivePage] errorCode:" + i3, AdMetricID.Reward.HIPPY_CONTROLLER_START_NATIVE_PAGE_SUCCESS, startGdtMotiveVideoParams.data, i3);
            startGdtMotiveVideoParams.data.enableHippy = false;
            GdtMotiveVideoFragment.wh(startGdtMotiveVideoParams);
            return;
        }
        String str = "[startNativeMotivePage] error, not valid, errorCode:" + i3;
        if (startGdtMotiveVideoParams != null) {
            gdtMotiveVideoPageData = startGdtMotiveVideoParams.data;
        } else {
            gdtMotiveVideoPageData = null;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.k("GdtMotiveHippyController", str, null, AdMetricID.Reward.HIPPY_CONTROLLER_START_NATIVE_PAGE_FAILED, gdtMotiveVideoPageData, 1);
    }

    private void v() {
        QLog.i("GdtMotiveHippyController", 1, "[addLoadingView]");
        S();
        Activity D = D();
        if (D == null) {
            com.tencent.gdtad.basics.motivevideo.report.a.j("GdtMotiveHippyController", "[addLoadingView] error, activity is null", null, AdMetricID.Reward.HIPPY_CONTROLLER_ADD_LOADING_VIEW_FAILED, this.f108962b, 1);
        } else {
            D.runOnUiThread(new Runnable() { // from class: com.tencent.gdtad.basics.motivevideo.hippy.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.N();
                }
            });
        }
    }

    public static d x(StartGdtMotiveVideoParams startGdtMotiveVideoParams, WeakReference<om0.d> weakReference) {
        if (startGdtMotiveVideoParams != null && M(startGdtMotiveVideoParams)) {
            QLog.i("GdtMotiveHippyController", 1, "[build]");
            return new d(startGdtMotiveVideoParams, weakReference);
        }
        QLog.e("GdtMotiveHippyController", 1, "[build] error, not valid");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(int i3, int i16) {
        om0.d dVar;
        com.tencent.gdtad.basics.motivevideo.report.a.n("GdtMotiveHippyController", "[closeView] errorCode:" + i3, AdMetricID.Reward.HIPPY_CONTROLLER_CLOSE, this.f108962b, Integer.valueOf(i3));
        WeakReference<om0.d> weakReference = this.f108965e;
        if (weakReference != null) {
            dVar = weakReference.get();
        } else {
            dVar = null;
        }
        if (this.f108964d != null) {
            GdtAnalysisHelperForMotiveAd.c(D(), this.f108964d.data, i3, i16, true);
        }
        if (dVar != null) {
            dVar.finish();
        }
        if (i3 == 0) {
            Z(0);
        }
    }

    private View z() {
        Activity D = D();
        if (D == null) {
            com.tencent.gdtad.basics.motivevideo.report.a.j("GdtMotiveHippyController", "[createLoadingView] error", null, AdMetricID.Reward.HIPPY_CONTROLLER_CREATE_LOADING_VIEW_FAILED, this.f108962b, 1);
            return null;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[createLoadingView]", AdMetricID.Reward.HIPPY_CONTROLLER_CREATE_LOADING_VIEW_SUCCESS, this.f108962b);
        LinearLayout linearLayout = new LinearLayout(D);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        View progressBar = new ProgressBar(D);
        int dp2px = GdtUIUtils.dp2px(34.0f, linearLayout.getResources());
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(dp2px, dp2px));
        linearLayout.addView(progressBar);
        TextView textView = new TextView(D);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = GdtUIUtils.dp2px(10.0f, linearLayout.getResources());
        textView.setLayoutParams(layoutParams2);
        textView.setTextSize(1, 14.0f);
        textView.setTextColor(-1);
        textView.setText("\u52aa\u529b\u52a0\u8f7d\u4e2d");
        linearLayout.addView(textView);
        return linearLayout;
    }

    public void A() {
        if (this.f108963c != null) {
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[destroy]", AdMetricID.Reward.HIPPY_CONTROLLER_DESTROY, this.f108962b);
            this.f108963c.G();
        }
        this.f108963c = null;
        this.f108976p.removeCallbacksAndMessages(null);
        com.tencent.gdtad.basics.motivevideo.report.a.b();
    }

    public void R() {
        i iVar = this.f108963c;
        if (iVar != null) {
            iVar.r0();
        }
    }

    public void V() {
        i iVar = this.f108963c;
        if (iVar != null) {
            iVar.m0();
        }
    }

    public void Z(int i3) {
        if (f108960r && D() != null) {
            QLog.i("GdtMotiveHippyController", 1, "[updateForceOrientation] orientation:" + i3);
            D().setRequestedOrientation(i3);
        }
    }

    public void w() {
        om0.d dVar;
        GdtAd gdtAd;
        WeakReference<om0.d> weakReference = this.f108965e;
        GdtMotiveVideoPageData gdtMotiveVideoPageData = null;
        if (weakReference != null) {
            dVar = weakReference.get();
        } else {
            dVar = null;
        }
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f108962b;
        if (gdtMotiveVideoModel != null) {
            gdtAd = gdtMotiveVideoModel.getGdtAd();
        } else {
            gdtAd = null;
        }
        StartGdtMotiveVideoParams startGdtMotiveVideoParams = this.f108964d;
        if (startGdtMotiveVideoParams != null) {
            gdtMotiveVideoPageData = startGdtMotiveVideoParams.data;
        }
        if (dVar != null && gdtAd != null && gdtMotiveVideoPageData != null && gdtMotiveVideoPageData.enableHippy) {
            Intent intent = new Intent();
            intent.putExtra("profitable_flag", this.f108966f);
            intent.putExtra("arg_callback", gdtMotiveVideoPageData.getAsyncCallbackId());
            com.tencent.gdtad.basics.motivevideo.report.a.m("GdtMotiveHippyController", "[beforeFinish] mProfitable:mProfitable", AdMetricID.Reward.HIPPY_CONTROLLER_BEFORE_FINISH_SUCCESS, this.f108962b);
            dVar.setResult(-1, intent);
            return;
        }
        com.tencent.gdtad.basics.motivevideo.report.a.j("GdtMotiveHippyController", "[beforeFinish] error", null, AdMetricID.Reward.HIPPY_CONTROLLER_BEFORE_FINISH_FAILED, this.f108962b, 1);
    }

    public void W() {
    }

    public void Y() {
    }
}
