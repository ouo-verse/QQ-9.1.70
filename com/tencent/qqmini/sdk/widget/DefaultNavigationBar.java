package com.tencent.qqmini.sdk.widget;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.ReportConst;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.SquareImageView;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.MiniAppLauncher;
import com.tencent.qqmini.sdk.utils.MiniAppUtils;
import com.tencent.qqmini.sdk.utils.ProcessUtil;
import com.tencent.qqmini.sdk.widget.NavigationBar;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DefaultNavigationBar extends NavigationBar {
    private RelativeLayout C;
    private WebViewProgressBar D;
    private WebViewProgressBarController E;
    private boolean F;
    private View G;
    private ProgressBar H;
    private Drawable I;
    private RelativeLayout J;
    private RelativeLayout K;
    private LinearLayout L;
    private ImageView M;

    /* renamed from: d, reason: collision with root package name */
    private CapsuleButton f348376d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f348377e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f348378f;

    /* renamed from: h, reason: collision with root package name */
    private SquareImageView f348379h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f348380i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f348381m;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (DefaultNavigationBar.this.isEntryModelValid()) {
                MiniAppUtils.getMiniAppInfo().launchParam.entryModel.type = 10;
                MiniAppLauncher.launchMiniApp(DefaultNavigationBar.this.mMiniAppContext.getAttachActivity(), MiniAppUtils.getMiniAppInfo(), (Bundle) null, (ResultReceiver) null);
                SDKMiniProgramLpReportDC04239.reportAsyncR9(MiniAppUtils.getMiniAppInfo(), "page_view", "em_click", ReportConst.ACTION.HALFSCREEN_MINIAPP_TOFULLSCREEN, "", "", "halfscreen");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (DefaultNavigationBar.this.mMiniAppContext != null) {
                SDKMiniProgramLpReportDC04239.reportAsyncR9(MiniAppUtils.getMiniAppInfo(), "page_view", "em_click", ReportConst.ACTION.HALFSCREEN_MINIAPP_CLOSE_BUTTON, "", "", "halfscreen");
                ProcessUtil.exitProcess(DefaultNavigationBar.this.mMiniAppContext);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IMiniAppContext iMiniAppContext = DefaultNavigationBar.this.mMiniAppContext;
            if (iMiniAppContext != null) {
                ProcessUtil.exitProcess(iMiniAppContext);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DefaultNavigationBar.this.onBackClick();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DefaultNavigationBar.this.d();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public DefaultNavigationBar(Context context, IMiniAppContext iMiniAppContext) {
        super(context, iMiniAppContext);
    }

    private void a() {
        ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).changeNavIcon(this.f348380i, this.f348381m);
        this.f348376d.changeNavIcon(this.mBarTextStyle);
    }

    private void b() {
        boolean z16;
        NavigationBar.a aVar = this.mNavigationBarCallback;
        boolean z17 = false;
        if (aVar != null) {
            z16 = aVar.isTabPage();
        } else {
            z16 = false;
        }
        if (!z16 && (this.mPageCount > 1 || this.mWebViewCanGoBack)) {
            z17 = true;
        }
        this.F = z17;
        f();
    }

    private boolean c(IMiniAppContext iMiniAppContext) {
        boolean z16;
        boolean z17;
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null && iMiniAppContext.getMiniAppInfo().appMode != null && iMiniAppContext.getMiniAppInfo().appMode.closeTopRightCapsule) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null && iMiniAppContext.getMiniAppInfo().firstPage != null && iMiniAppContext.getMiniAppInfo().firstPage.pagePath != null && iMiniAppContext.getMiniAppInfo().firstPage.pagePath.startsWith("__wx__/functional-page.html?name=loginAndGetUserInfo&")) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 || z17) {
            return true;
        }
        return false;
    }

    private void e(IMiniAppContext iMiniAppContext) {
        if (iMiniAppContext != null && iMiniAppContext.getMiniAppInfo() != null && iMiniAppContext.getMiniAppInfo().iconUrl != null) {
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            Drawable drawable = getContext().getResources().getDrawable(R.drawable.mini_sdk_icon_loading_default);
            Drawable drawable2 = miniAppProxy.getDrawable(getContext(), iMiniAppContext.getMiniAppInfo().iconUrl, DisplayUtil.dip2px(getContext(), 24.0f), DisplayUtil.dip2px(getContext(), 24.0f), drawable);
            if (drawable2 != null) {
                drawable = drawable2;
            }
            SquareImageView squareImageView = this.f348379h;
            if (squareImageView != null) {
                squareImageView.setImageDrawable(drawable);
            }
            TextView textView = this.f348378f;
            if (textView != null) {
                textView.setText(iMiniAppContext.getMiniAppInfo().name);
            }
        }
    }

    private void f() {
        if (this.F && "default".equals(this.mBarStyle)) {
            this.f348377e.requestLayout();
            this.f348380i.setVisibility(0);
        } else {
            this.f348380i.setVisibility(8);
        }
    }

    protected void d() {
        NavigationBar.a aVar = this.mNavigationBarCallback;
        if (aVar != null) {
            aVar.onClickHome(this);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public CapsuleButton getCapsuleButton() {
        return this.f348376d;
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public int getHomeIconVisibility() {
        ImageView imageView = this.f348381m;
        if (imageView != null) {
            return imageView.getVisibility();
        }
        return 8;
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void hideLoading() {
        this.H.setVisibility(4);
    }

    protected void onBackClick() {
        NavigationBar.a aVar = this.mNavigationBarCallback;
        if (aVar != null) {
            aVar.onClickBack(this);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    protected void onInitView() {
        LayoutInflater from = LayoutInflater.from(getContext());
        if (isEntryModelValid() && MiniAppUtils.getMiniAppInfo().launchParam.entryModel.type == 9) {
            QMLog.d("minisdk-startDefaultNavigationBar", " onInitView half ");
            from.inflate(R.layout.mini_sdk_half_navigation_bar, this);
            this.K = (RelativeLayout) findViewById(R.id.mini_sdk_top_container);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.mini_sdk_top_bar_mask_container);
            this.C = relativeLayout;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        } else {
            from.inflate(R.layout.mini_sdk_default_title_navigation_bar, this);
        }
        this.J = (RelativeLayout) findViewById(R.id.mini_sdk_navigation_container);
        if (this.K != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            this.K.setPadding(0, DisplayUtil.getStatusBarHeight(getContext()), 0, 0);
            this.K.setLayoutParams(layoutParams);
            this.K.setClipChildren(false);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            this.J.setPadding(0, DisplayUtil.getStatusBarHeight(getContext()), 0, 0);
            this.J.setLayoutParams(layoutParams2);
            this.J.setClipChildren(false);
        }
        this.f348376d = (CapsuleButton) findViewById(R.id.mini_sdk_nav_capsule_btn);
        if (this.C != null) {
            this.L = (LinearLayout) findViewById(R.id.ll_avatar_name_title);
            SDKMiniProgramLpReportDC04239.reportAsyncR9(MiniAppUtils.getMiniAppInfo(), "page_view", "em_expo", ReportConst.ACTION.HALFSCREEN_MINIAPP_TOFULLSCREEN, "", "", "halfscreen");
            this.L.setOnClickListener(new a());
            this.M = (ImageView) findViewById(R.id.mini_sdk_top_bar_title_close);
            SDKMiniProgramLpReportDC04239.reportAsyncR9(MiniAppUtils.getMiniAppInfo(), "page_view", "em_expo", ReportConst.ACTION.HALFSCREEN_MINIAPP_CLOSE_BUTTON, "", "", "halfscreen");
            this.M.setOnClickListener(new b());
            this.C.setOnClickListener(new c());
            TextView textView = (TextView) findViewById(R.id.mini_sdk_name);
            this.f348378f = textView;
            textView.setText(this.mBarText);
            SquareImageView squareImageView = (SquareImageView) findViewById(R.id.mini_sdk_top_avatar);
            this.f348379h = squareImageView;
            squareImageView.setRoundRect(DisplayUtil.dip2px(getContext(), 5.0f));
        }
        View findViewById = findViewById(R.id.mini_sdk_nav_mask);
        this.G = findViewById;
        ViewGroup.LayoutParams layoutParams3 = findViewById.getLayoutParams();
        layoutParams3.height = DisplayUtil.getStatusBarHeight(getContext());
        this.G.setLayoutParams(layoutParams3);
        this.f348380i = (ImageView) findViewById(R.id.mini_sdk_top_bar_title_back);
        this.f348381m = (ImageView) findViewById(R.id.mini_sdk_top_bar_title_home);
        this.f348377e = (TextView) findViewById(R.id.mini_sdk_nav_title);
        this.H = (ProgressBar) findViewById(R.id.mini_sdk_nav_loading_view);
        this.f348380i.setOnClickListener(new d());
        this.f348381m.setOnClickListener(new e());
        this.D = (WebViewProgressBar) findViewById(R.id.mini_sdk_nav_loading);
        this.I = getResources().getDrawable(R.drawable.mini_sdk_common_loading);
        this.f348377e.setText(this.mBarText);
        this.f348377e.setTextColor(this.mBarTextStyle);
        this.H.setIndeterminateDrawable(this.I);
        this.H.setIndeterminate(true);
        this.H.setVisibility(8);
        this.D.setVisibility(8);
        if (this.F) {
            this.f348380i.setVisibility(0);
        } else {
            this.f348380i.setVisibility(4);
        }
        a();
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void setCapsuleVisible(int i3) {
        CapsuleButton capsuleButton = this.f348376d;
        if (capsuleButton != null) {
            capsuleButton.setVisibility(i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void setHomeIconVisibility(int i3) {
        ImageView imageView = this.f348381m;
        if (imageView != null) {
            imageView.setVisibility(i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void setInnerWebViewCanGoBack(boolean z16) {
        super.setInnerWebViewCanGoBack(z16);
        b();
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void setMaskVisible(int i3) {
        QMLog.d("minisdk-startDefaultNavigationBar", " setMaskVisible half = " + i3);
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public NavigationBar setNavBackgroundColor(int i3) {
        this.mBackGroundColor = i3;
        if (this.J != null) {
            if ("custom".equals(this.mBarStyle)) {
                this.J.setBackgroundColor(0);
            } else {
                this.J.setBackgroundColor(this.mBackGroundColor);
            }
        }
        return this;
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void setNeedCloseTopRightCapsule(boolean z16) {
        if (z16) {
            if (getCapsuleButton() != null) {
                getCapsuleButton().setVisibility(8);
            }
        } else if (getCapsuleButton() != null) {
            getCapsuleButton().setVisibility(0);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void setPageCount(int i3) {
        super.setPageCount(i3);
        b();
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public NavigationBar setTextStyle(String str) {
        if ("black".equals(str)) {
            this.mBarTextStyle = -16777216;
        } else if ("white".equals(str)) {
            this.mBarTextStyle = -1;
        }
        this.f348377e.setTextColor(this.mBarTextStyle);
        TextView textView = this.f348378f;
        if (textView != null) {
            textView.setTextColor(-1);
        }
        a();
        return this;
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void setTitleTextFromMiniApp(String str) {
        super.setTitleTextFromMiniApp(str);
        this.f348377e.setText(this.mBarText);
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void setUseCustomStatusBarStyle(boolean z16) {
        if (this.G != null) {
            RelativeLayout relativeLayout = this.K;
            if (relativeLayout != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
                if (z16) {
                    this.G.setVisibility(8);
                    this.K.setPadding(0, DisplayUtil.getStatusBarHeight(getContext()), 0, 0);
                    layoutParams.topMargin = 0;
                } else {
                    this.G.setVisibility(0);
                    this.K.setPadding(0, 0, 0, 0);
                    layoutParams.topMargin = DisplayUtil.getStatusBarHeight(getContext());
                }
                this.K.setLayoutParams(layoutParams);
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.J.getLayoutParams();
            if (z16) {
                this.G.setVisibility(8);
                this.J.setPadding(0, DisplayUtil.getStatusBarHeight(getContext()), 0, 0);
                layoutParams2.topMargin = 0;
            } else {
                this.G.setVisibility(0);
                this.J.setPadding(0, 0, 0, 0);
                layoutParams2.topMargin = DisplayUtil.getStatusBarHeight(getContext());
            }
            this.J.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public boolean shouldContentBelow(String str) {
        return "default".equals(str);
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void showLoading() {
        this.H.setVisibility(0);
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    protected void updateBarStyle() {
        if ("custom".equals(this.mBarStyle)) {
            this.f348377e.setVisibility(4);
            setNavBackgroundColor(0);
        } else {
            this.f348377e.setVisibility(0);
            NavigationBarInfo navigationBarInfo = this.barInfo;
            if (navigationBarInfo != null) {
                setNavBackgroundColor(navigationBarInfo.backgoundColor);
                setTextStyle(this.barInfo.textStyle);
            }
        }
        f();
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void updateByMiniAppContext(IMiniAppContext iMiniAppContext) {
        getCapsuleButton().updateRedDotVisible();
        getCapsuleButton().setListener(new CapsuleButtonClickListener(iMiniAppContext));
        setNeedCloseTopRightCapsule(c(iMiniAppContext));
        e(iMiniAppContext);
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public void updateProgress(byte b16) {
        WebViewProgressBar webViewProgressBar;
        WebViewProgressBar webViewProgressBar2;
        if (this.E == null) {
            WebViewProgressBarController webViewProgressBarController = new WebViewProgressBarController();
            this.E = webViewProgressBarController;
            WebViewProgressBar webViewProgressBar3 = this.D;
            if (webViewProgressBar3 != null) {
                webViewProgressBar3.setController(webViewProgressBarController);
                this.E.setProgressBar(this.D);
            }
        }
        if (b16 == 0 && (webViewProgressBar2 = this.D) != null) {
            webViewProgressBar2.setVisibility(0);
        }
        if (b16 == 2 && (webViewProgressBar = this.D) != null) {
            webViewProgressBar.setVisibility(8);
        }
        this.E.enterStatus(b16);
    }

    @Override // com.tencent.qqmini.sdk.widget.NavigationBar
    public NavigationBar setNavBackgroundColor(int i3, long j3, String str) {
        RelativeLayout relativeLayout = this.J;
        if (relativeLayout != null) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(relativeLayout, "backgroundColor", this.mBackGroundColor, i3);
            ofInt.setDuration(j3);
            ofInt.setEvaluator(new ArgbEvaluator());
            if (CanvasView.ACTION_LINER.equals(str)) {
                ofInt.setInterpolator(new LinearInterpolator());
            } else if ("easeIn".equals(str)) {
                ofInt.setInterpolator(new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f));
            } else if ("easeOut".equals(str)) {
                ofInt.setInterpolator(new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f));
            } else if ("easeInOut".equals(str)) {
                ofInt.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
            }
            ofInt.start();
        }
        this.mBackGroundColor = i3;
        return this;
    }
}
