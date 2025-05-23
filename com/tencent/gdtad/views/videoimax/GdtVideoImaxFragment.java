package com.tencent.gdtad.views.videoimax;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ad.tangram.statistics.canvas.AdTimeStatistics;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtActionReporter;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuPresenter;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.m;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.smtt.sdk.WebView;
import com.tencent.view.FilterEnum;
import cooperation.qzone.util.SystemUtil;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
public final class GdtVideoImaxFragment extends PublicBaseFragment {

    @Nullable
    private GdtImaxData C;
    private boolean D;
    private boolean E;
    private GdtVideoCommonView F;
    private TouchWebView G;
    private zm0.c H;
    private FrameLayout I;
    private GdtVideoCeilingTitleBar J;
    private GdtVideoCeilingLandView K;

    @Nullable
    private GdtDanmakuPresenter L;
    private RelativeLayout M;
    private URLImageView N;
    private TextView P;
    private View Q;
    private Button R;

    @Nullable
    private ResultReceiver S;
    private View U;

    @NonNull
    private GdtVideoCommonView.h T = new GdtVideoCommonView.h() { // from class: com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.1
        @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.h
        public void a(GdtVideoCommonView gdtVideoCommonView) {
            GdtLog.d("GdtVideoImaxFragment", "onComplete() called with: v = [" + gdtVideoCommonView + "]");
        }

        @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.h
        public void b(GdtVideoCommonView gdtVideoCommonView) {
            GdtLog.d("GdtVideoImaxFragment", "onPrepared() called with: v = [" + gdtVideoCommonView + "]");
        }

        @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.h
        public void c(GdtVideoCommonView gdtVideoCommonView) {
            GdtLog.d("GdtVideoImaxFragment", "onStart() called with: ");
            if (GdtVideoImaxFragment.this.D) {
                GdtVideoImaxFragment.this.Y.removeCallbacks(GdtVideoImaxFragment.this.Z);
                GdtVideoImaxFragment.this.Y.postDelayed(new Runnable() { // from class: com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GdtVideoImaxFragment.this.F.setBackgroundColor(-16777216);
                        if (GdtVideoImaxFragment.this.S != null) {
                            GdtVideoImaxFragment.this.S.send(2, new Bundle());
                        } else {
                            GdtLog.d("GdtVideoImaxFragment", "onStart() mResultReceiver != null");
                        }
                    }
                }, 75L);
                GdtVideoImaxFragment.this.D = false;
            }
        }

        @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.h
        public void d(View view) {
            GdtVideoImaxFragment.this.F.T().setFinishType(2);
            if (GdtVideoImaxFragment.this.C.getVideoSplicePageStyle() == 1) {
                GdtVideoImaxFragment.this.Nh(GdtVideoImaxFragment.this.Hh(view));
                GdtVideoImaxFragment.this.Qh();
            } else if (GdtVideoImaxFragment.this.C.getVideoSplicePageStyle() == 0) {
                GdtVideoImaxFragment.this.F.m0();
                int[] portraitScreenSize = GdtUIUtils.getPortraitScreenSize(GdtVideoImaxFragment.this.getBaseActivity());
                GdtVideoImaxFragment.this.Yh(portraitScreenSize[1], r0.K.getLayoutParams().height, portraitScreenSize[1]);
            }
        }

        @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.h
        public void e(GdtVideoCommonView gdtVideoCommonView) {
            GdtLog.d("GdtVideoImaxFragment", "onStop() called with: v = [" + gdtVideoCommonView + "]");
        }
    };

    @NonNull
    protected AdTimeStatistics V = new AdTimeStatistics();

    @NonNull
    private AdTimeStatistics W = new AdTimeStatistics();
    private boolean X = false;

    @NonNull
    private Handler Y = new Handler(Looper.getMainLooper());

    @NonNull
    private Runnable Z = new Runnable() { // from class: com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.2
        @Override // java.lang.Runnable
        public void run() {
            GdtLog.d("GdtVideoImaxFragment", "run() mTimeoutRunnable");
            if (GdtVideoImaxFragment.this.D) {
                GdtVideoImaxFragment.this.F.setBackgroundColor(-16777216);
                if (GdtVideoImaxFragment.this.S != null) {
                    GdtVideoImaxFragment.this.S.send(2, new Bundle());
                } else {
                    GdtLog.d("GdtVideoImaxFragment", "run() mResultReceiver != null");
                }
                GdtVideoImaxFragment.this.D = false;
            }
        }
    };

    /* renamed from: a0, reason: collision with root package name */
    @NonNull
    private View.OnClickListener f109727a0 = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class MyResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<GdtVideoImaxFragment> f109730d;

        public MyResultReceiver(Handler handler) {
            super(handler);
        }

        public void a(GdtVideoImaxFragment gdtVideoImaxFragment) {
            this.f109730d = new WeakReference<>(gdtVideoImaxFragment);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            GdtLog.d("GdtVideoImaxFragment", "onReceiveResult() called with: resultCode = [" + i3 + "], resultData = [" + bundle + "]");
            GdtVideoImaxFragment gdtVideoImaxFragment = this.f109730d.get();
            if (gdtVideoImaxFragment != null && i3 == 1) {
                gdtVideoImaxFragment.Oh();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtVideoImaxFragment.this.Nh(GdtVideoImaxFragment.this.Hh(view));
            GdtVideoImaxFragment.this.Qh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f109732d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f109733e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f109734f;

        b(float f16, float f17, int i3) {
            this.f109732d = f16;
            this.f109733e = f17;
            this.f109734f = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            float f16 = this.f109732d;
            float f17 = f16 + ((this.f109733e - f16) * animatedFraction);
            GdtLog.d("GdtVideoImaxFragment", "onAnimationUpdate() called with: current = [" + f17 + "]");
            ViewGroup.LayoutParams layoutParams = GdtVideoImaxFragment.this.K.getLayoutParams();
            layoutParams.height = (int) f17;
            GdtVideoImaxFragment.this.K.setLayoutParams(layoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) GdtVideoImaxFragment.this.U.getLayoutParams();
            marginLayoutParams.height = Math.abs((int) (this.f109734f - f17));
            GdtVideoImaxFragment.this.U.setLayoutParams(marginLayoutParams);
            if (animatedFraction == 1.0f && !GdtVideoImaxFragment.this.E) {
                GdtVideoImaxFragment.this.E = true;
                GdtVideoImaxFragment.this.G.loadUrl(GdtVideoImaxFragment.this.C.getWebUrl());
                GdtVideoImaxFragment.this.V.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements GdtVideoCeilingTitleBar.b {
        c() {
        }

        @Override // com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar.b
        public void c(@NonNull View view) {
            if (view.getId() == R.id.f164559a43) {
                GdtVideoImaxFragment.this.r3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d extends zm0.c {
        d(Context context, Activity activity, Intent intent, AppInterface appInterface) {
            super(context, activity, intent, appInterface);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            GdtLog.i(AbsWebView.TAG, "onPageFinished:" + str);
            GdtVideoImaxFragment.this.Ph(true);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            GdtLog.i(AbsWebView.TAG, "onPageStarted:" + str);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            super.onReceivedError(webView, i3, str, str2);
            GdtVideoImaxFragment.this.Ph(false);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            GdtLog.i(AbsWebView.TAG, "onReceivedTitle: " + str);
            GdtVideoImaxFragment.this.J.setWebBarTitle(str);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull String str) {
            GdtLog.i(AbsWebView.TAG, "shouldOverrideUrlLoading:" + str);
            if (!TextUtils.isEmpty(str) && str.startsWith("jsbridge://")) {
                return true;
            }
            WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
            String str2 = null;
            if (!str.startsWith("file://") && !str.startsWith("data:") && !str.startsWith("http://") && !str.startsWith("https://")) {
                Uri parse = AdUriUtil.parse(str);
                if (parse != null) {
                    str2 = parse.getScheme();
                }
                if (AuthorizeConfig.y().G(webView.getUrl(), str2).booleanValue()) {
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, parse);
                    intent.addFlags(268435456);
                    try {
                        this.mContext.startActivity(intent);
                    } catch (ActivityNotFoundException e16) {
                        GdtLog.e(AbsWebView.TAG, e16.toString());
                    }
                }
                return true;
            }
            if (pluginEngine != null && pluginEngine.s(str, 16L, null)) {
                return true;
            }
            return false;
        }
    }

    GdtVideoImaxFragment() {
    }

    private void Ih(@NonNull GdtVideoCommonView gdtVideoCommonView, @NonNull GdtVideoData gdtVideoData) {
        gdtVideoCommonView.setData(gdtVideoData);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) gdtVideoCommonView.getLayoutParams();
        int[] portraitScreenSize = GdtUIUtils.getPortraitScreenSize(getBaseActivity());
        marginLayoutParams.height = portraitScreenSize[1];
        GdtLog.d("GdtVideoImaxFragment", "bindVideo() called with: width = [" + marginLayoutParams.width + "], height = [" + marginLayoutParams.height + "]");
        marginLayoutParams.leftMargin = getResources().getDisplayMetrics().widthPixels - 1;
        gdtVideoCommonView.setLayoutParams(marginLayoutParams);
        View findViewById = getView().findViewById(R.id.li7);
        this.U = findViewById;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
        marginLayoutParams2.height = portraitScreenSize[1];
        this.U.setLayoutParams(marginLayoutParams2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((RelativeLayout) gdtVideoCommonView.findViewById(R.id.close)).getLayoutParams();
        layoutParams.addRule(9, 0);
        layoutParams.addRule(11);
        ImageView imageView = (ImageView) gdtVideoCommonView.findViewById(R.id.dun);
        imageView.setImageResource(R.drawable.hn_);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.addRule(11);
        layoutParams2.width = -2;
        layoutParams2.leftMargin = 0;
        layoutParams2.rightMargin = GdtUIUtils.dp2px(15.0f, getResources());
        gdtVideoCommonView.N(this.T);
    }

    private void Jh() {
        GdtImaxData gdtImaxData = this.C;
        if (gdtImaxData != null && gdtImaxData.getAd() != null && this.C.getAd().isValid()) {
            GdtPreLoader.c().h(this.C.getAd());
        }
    }

    private void Kh() {
        this.K.setIgnoreInterceptTouchEvent(true);
        this.K.setIgnoreTouchEvent(true);
    }

    private void Lh() {
        this.J.c();
        if (SystemUtil.getNotchHeight(getBaseActivity(), getBaseActivity()) > 0) {
            this.Q.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.Q.getLayoutParams();
            layoutParams.height = SystemUtil.getNotchHeight(getBaseActivity(), getBaseActivity());
            this.Q.setLayoutParams(layoutParams);
        }
        this.J.setOnBtnClickListener(new c());
    }

    private void Mh() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        BaseActivity baseActivity = getBaseActivity();
        TouchWebView touchWebView = new TouchWebView(baseActivity);
        this.G = touchWebView;
        this.I.addView(touchWebView);
        d dVar = new d(baseActivity, baseActivity, baseActivity.getIntent(), appInterface);
        this.H = dVar;
        dVar.setWebView(this.G);
        new m(this.H).a(null, appInterface, getBaseActivity().getIntent());
        ViewGroup.LayoutParams layoutParams = this.K.getLayoutParams();
        layoutParams.height = 0;
        this.K.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh(boolean z16) {
        GdtImaxData gdtImaxData = this.C;
        if (gdtImaxData != null && gdtImaxData.getAd() != null && this.C.getAd().info != null) {
            try {
                Activity baseActivity = getBaseActivity();
                if (baseActivity instanceof BasePluginActivity) {
                    baseActivity = ((BasePluginActivity) baseActivity).getOutActivity();
                }
                GdtHandler.Params params = new GdtHandler.Params();
                params.processId = 7;
                params.activity = new WeakReference<>(baseActivity);
                params.f108486ad = new GdtAd(this.C.getAd().info);
                params.reportForClick = false;
                params.appAutoDownload = z16;
                Bundle bundle = new Bundle();
                params.extra = bundle;
                bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh() {
        GdtLog.d("GdtVideoImaxFragment", "onAnimationEnd() called");
        this.D = true;
        Zh();
        Uh();
        Th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph(boolean z16) {
        GdtLog.d("GdtVideoImaxFragment", "onWebViewLoadFinish() called with: success = [" + z16 + "]");
        if (!this.X) {
            this.X = true;
            this.V.stop();
            Rh(this.V.getTime(), z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qh() {
        GdtImaxData gdtImaxData = this.C;
        if (gdtImaxData != null && gdtImaxData.getAd() != null) {
            com.tencent.gdtad.statistics.c.a(this.C.getAd(), FilterEnum.MIC_PTU_TRANS_XINXIAN);
        }
    }

    private void Rh(long j3, boolean z16) {
        int i3;
        GdtLog.d("GdtVideoImaxFragment", "reportLoadTimeForAction() called with: time = [" + j3 + "], success = [" + z16 + "]");
        GdtActionReporter.Params params = new GdtActionReporter.Params();
        params.f109471ad = this.C.getAd();
        PBUInt32Field pBUInt32Field = params.data.landing_page_action_type;
        if (z16) {
            i3 = 3;
        } else {
            i3 = 4;
        }
        pBUInt32Field.set(i3);
        params.data.latency_ms.set(j3);
        GdtActionReporter.report(params);
    }

    private void Sh() {
        GdtLog.d("GdtVideoImaxFragment", "reportStayTimeForAction() called");
        GdtActionReporter.Params params = new GdtActionReporter.Params();
        params.f109471ad = this.C.getAd();
        params.data.landing_page_action_type.set(7);
        params.data.latency_ms.set(this.W.getTime());
        GdtActionReporter.report(params);
    }

    private void Th() {
        this.Y.postDelayed(this.Z, 500L);
    }

    private void Uh() {
        GdtLog.d("GdtVideoImaxFragment", "setPreviewImageVisible() called");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.F.getLayoutParams();
        marginLayoutParams.leftMargin = 0;
        this.F.setLayoutParams(marginLayoutParams);
    }

    private void Vh() {
        if (this.R == null) {
            return;
        }
        GdtImaxData gdtImaxData = this.C;
        if (gdtImaxData != null && gdtImaxData.getAd() != null && this.C.getAd().getProductType() == 12) {
            if (AdAppUtil.isInstalled(getBaseActivity(), this.C.getAd().getAppPackageName())) {
                this.R.setText(HardCodeUtil.qqStr(R.string.n1y));
                return;
            } else {
                this.R.setText(HardCodeUtil.qqStr(R.string.n1x));
                return;
            }
        }
        this.R.setText(HardCodeUtil.qqStr(R.string.n1s));
    }

    private void Wh(@NonNull View view) {
        view.findViewById(R.id.f165905ln4).setVisibility(8);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.m6a);
        this.M = relativeLayout;
        relativeLayout.setVisibility(0);
        this.N = (URLImageView) view.findViewById(R.id.dgu);
        this.P = (TextView) view.findViewById(R.id.mbt);
        this.R = (Button) view.findViewById(R.id.l8e);
        GdtImaxData gdtImaxData = this.C;
        if (gdtImaxData != null && gdtImaxData.getAd() != null) {
            if (!TextUtils.isEmpty(this.C.getAd().getAdvertiser_corporate_logo())) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable();
                obtain.mLoadingDrawable = defaultFaceDrawable;
                obtain.mFailedDrawable = defaultFaceDrawable;
                URLDrawable drawable = URLDrawable.getDrawable(this.C.getAd().getAdvertiser_corporate_logo(), obtain);
                drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306322b);
                drawable.setFadeInImage(true);
                this.N.setImageDrawable(drawable);
            }
            this.P.setText(this.C.getAd().getAdvertiser_corporate_image_name());
            Vh();
        }
        this.N.setOnClickListener(this.f109727a0);
        this.P.setOnClickListener(this.f109727a0);
        this.R.setOnClickListener(this.f109727a0);
    }

    private boolean Xh() {
        GdtDanmakuPresenter gdtDanmakuPresenter = this.L;
        if (gdtDanmakuPresenter == null) {
            return false;
        }
        if (gdtDanmakuPresenter.k()) {
            this.L.setVisibility(0);
            return true;
        }
        String[] danmakuContents = this.C.getDanmakuContents();
        if (danmakuContents != null && danmakuContents.length != 0) {
            this.L.setOnClickListener(this.f109727a0);
            this.L.j(AdUIUtils.getScreenWidth(getContext()), danmakuContents);
            if (this.L.m()) {
                this.L.setVisibility(0);
            } else {
                this.L.setVisibility(8);
                QLog.i("GdtVideoImaxFragment", 4, "mDanmakuPresenter cannot start");
            }
            return true;
        }
        this.L.setVisibility(8);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yh(int i3, float f16, float f17) {
        GdtLog.d("GdtVideoImaxFragment", "showWebView() called with: total = [" + i3 + "], from = [" + f16 + "], to = [" + f17 + "]");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(250L);
        ofFloat.addUpdateListener(new b(f16, f17, i3));
        ofFloat.start();
        ((ViewGroup) getBaseActivity().getWindow().getDecorView()).setSystemUiVisibility(7942);
    }

    private void Zh() {
        GdtLog.d("GdtVideoImaxFragment", "startPlay() called");
        this.F.p0();
    }

    private boolean ai() {
        if (this.K.getLayoutParams().height > 0) {
            return true;
        }
        return false;
    }

    public boolean Hh(@Nullable View view) {
        boolean z16 = false;
        if (view == null) {
            QLog.i("GdtVideoImaxFragment", 1, "appAutoDownload() view is null");
            return false;
        }
        int id5 = view.getId();
        if (id5 == R.id.dgu || id5 == R.id.mbt || id5 == R.id.l8e) {
            z16 = true;
        }
        QLog.i("GdtVideoImaxFragment", 1, "appAutoDownload:" + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity == null) {
            return;
        }
        activity.setRequestedOrientation(1);
        Window window = activity.getWindow();
        window.addFlags(1024);
        ((ViewGroup) window.getDecorView()).setSystemUiVisibility(7942);
        GdtUIUtils.enableTopLiuHaiIfNeeded(activity, 1);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        Intent intent = activity.getIntent();
        this.C = (GdtImaxData) intent.getSerializableExtra("data");
        this.S = (ResultReceiver) intent.getParcelableExtra("callback");
        Bundle bundle = new Bundle();
        MyResultReceiver myResultReceiver = new MyResultReceiver(new Handler(Looper.getMainLooper()));
        myResultReceiver.a(this);
        ClassLoader classLoader = MyResultReceiver.class.getClassLoader();
        GdtLog.d("GdtVideoImaxFragment", "onAttach() classLoader = [" + classLoader + "]");
        bundle.setClassLoader(classLoader);
        bundle.putParcelable("callback", myResultReceiver);
        this.S.send(0, bundle);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return r3();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.c8f, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.F.l0();
        if (this.C.getVideoSplicePageStyle() == 0) {
            this.H.onDestroy();
            ViewParent parent = this.G.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeAllViewsInLayout();
            }
        }
        GdtDanmakuPresenter gdtDanmakuPresenter = this.L;
        if (gdtDanmakuPresenter != null && gdtDanmakuPresenter.k()) {
            this.L.n();
            this.L = null;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        GdtImaxData gdtImaxData = this.C;
        if (gdtImaxData != null && gdtImaxData.getVideoSplicePageStyle() == 0) {
            Sh();
        }
        super.onDetach();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.F.n0();
        this.W.stop();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.F.u0();
        this.W.start();
        Vh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        Jh();
        this.F = (GdtVideoCommonView) view.findViewById(R.id.koo);
        this.I = (FrameLayout) view.findViewById(R.id.l1y);
        this.J = (GdtVideoCeilingTitleBar) view.findViewById(R.id.l1w);
        this.Q = view.findViewById(R.id.lxq);
        this.K = (GdtVideoCeilingLandView) view.findViewById(R.id.crt);
        this.L = (GdtDanmakuPresenter) view.findViewById(R.id.f165770xj2);
        Ih(this.F, this.C.getVideoData());
        if (this.C.getVideoSplicePageStyle() == 1) {
            Wh(view);
        } else if (this.C.getVideoSplicePageStyle() == 0) {
            Lh();
            Mh();
        }
        Kh();
        if (this.C.isDanmakuAdv()) {
            Xh();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16) {
            getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
        }
    }

    public boolean r3() {
        String str;
        GdtLog.d("GdtVideoImaxFragment", "----back click");
        boolean z16 = true;
        if (this.C.getVideoSplicePageStyle() == 1 && getBaseActivity() != null) {
            getBaseActivity().finish();
            return true;
        }
        if (this.G.canGoBack()) {
            this.G.goBack();
            str = " mWebView.goBack() result = true";
        } else if (ai()) {
            Yh(this.K.getLayoutParams().height, this.K.getLayoutParams().height, 0.0f);
            this.F.p0();
            str = " webViewIsShowing result = true";
        } else if (getBaseActivity() != null) {
            getBaseActivity().finish();
            str = " getActivity().finish() result = true";
        } else {
            str = "";
            z16 = false;
        }
        GdtLog.d("GdtVideoImaxFragment", "----back return " + z16 + str);
        return z16;
    }
}
