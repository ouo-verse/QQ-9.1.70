package com.tencent.gdtad.views.videoceiling;

import android.R;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.protocol.link_report;
import com.tencent.ad.tangram.protocol.sdk_event_log;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtVideoCeilingView extends FrameLayout implements GdtVideoCommonView.g, GdtVideoCeilingListener, GdtVideoCeilingTitleBar.b {
    private zm0.c C;
    private GdtVideoCeilingLandView D;
    private FrameLayout E;
    private int F;
    private GdtVideoCeilingTitleBar G;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private GdtVideoCeilingData f109710d;

    /* renamed from: e, reason: collision with root package name */
    private GdtVideoCommonView f109711e;

    /* renamed from: f, reason: collision with root package name */
    private View f109712f;

    /* renamed from: h, reason: collision with root package name */
    private int f109713h;

    /* renamed from: i, reason: collision with root package name */
    private int f109714i;

    /* renamed from: m, reason: collision with root package name */
    private TouchWebView f109715m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            GdtVideoCeilingView.this.B(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXTENSIONS_LOAD_SUCCESS);
            GdtVideoCeilingView.this.f109711e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c extends zm0.c {
        c(Context context, Activity activity, Intent intent, AppInterface appInterface) {
            super(context, activity, intent, appInterface);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            GdtLog.i("GdtVideoCeilingView", "onPageFinished:" + str);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            GdtLog.i("GdtVideoCeilingView", "onPageStarted:" + str);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            GdtLog.i("GdtVideoCeilingView", "onReceivedTitle: " + str);
            GdtVideoCeilingView.this.G.setWebBarTitle(str);
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView
        public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull String str) {
            return a(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f109719d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f109720e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f109721f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ GdtVideoCeilingLandView f109722h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f109723i;

        d(RelativeLayout.LayoutParams layoutParams, int i3, int i16, GdtVideoCeilingLandView gdtVideoCeilingLandView, boolean z16) {
            this.f109719d = layoutParams;
            this.f109720e = i3;
            this.f109721f = i16;
            this.f109722h = gdtVideoCeilingLandView;
            this.f109723i = z16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RelativeLayout.LayoutParams layoutParams = this.f109719d;
            int i3 = this.f109720e + ((int) (floatValue * this.f109721f));
            layoutParams.topMargin = i3;
            if (i3 < 1 || i3 >= GdtVideoCeilingView.this.f109713h) {
                GdtVideoCeilingLandView gdtVideoCeilingLandView = this.f109722h;
                if (gdtVideoCeilingLandView.isAnimating) {
                    GdtVideoCeilingView.this.l(this.f109719d, gdtVideoCeilingLandView, this.f109723i);
                    return;
                }
            }
            GdtVideoCeilingLandView gdtVideoCeilingLandView2 = this.f109722h;
            if (gdtVideoCeilingLandView2 != null) {
                gdtVideoCeilingLandView2.setLayoutParams(this.f109719d);
            }
        }
    }

    public GdtVideoCeilingView(@NonNull Context context) {
        super(context);
        this.f109713h = 607;
        this.f109714i = 1920;
        this.F = 1;
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i3) {
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(getContext(), new InitGdtContextParams());
        String stringExtra = o().getStringExtra("WebReport_TRACE_ID");
        if (TextUtils.isEmpty(stringExtra)) {
            GdtLog.d("GdtVideoCeilingView", "traceId is null, report is failed ");
            return;
        }
        long longExtra = o().getLongExtra("WebReport_CLICK_TIME", System.currentTimeMillis());
        link_report.LinkReport.ReportBiz reportBiz = new link_report.LinkReport.ReportBiz();
        reportBiz.cost_time = (int) (System.currentTimeMillis() - longExtra);
        QLog.d("GdtVideoCeilingView", 2, "report eventId is " + i3 + "costTime is" + reportBiz.cost_time);
        reportBiz.aid = o().getStringExtra("WebReport_AD_ID");
        reportBiz.pid = o().getStringExtra("WebReport_POS_ID");
        reportBiz.traceid = stringExtra;
        AdReporterForLinkEvent.getInstance().reportAsync(m(), i3, null, reportBiz, null);
    }

    private void C(int i3, int i16) {
        boolean z16;
        int i17;
        if (this.f109711e == null) {
            return;
        }
        if (i3 < i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GdtVideoCeilingView", 2, "updateLayout width " + i3 + " height " + i16 + " Portrait " + z16);
        }
        if (z16) {
            i17 = p(i3, i16);
        } else {
            i17 = i16;
        }
        if (i17 <= 0) {
            i17 = 607;
        }
        this.f109713h = i17;
        if (QLog.isColorLevel()) {
            QLog.d("GdtVideoCeilingView", 2, "videoView height " + this.f109713h);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f109711e.getLayoutParams();
        layoutParams.height = this.f109713h;
        this.f109711e.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f109712f.getLayoutParams();
        layoutParams2.height = this.f109713h;
        this.f109712f.setLayoutParams(layoutParams2);
        if (i16 <= 0) {
            i16 = 1920;
        }
        this.f109714i = i16;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
        int i18 = this.f109713h;
        layoutParams3.topMargin = i18;
        layoutParams3.height = this.f109714i - i18;
        this.D.setLayoutParams(layoutParams3);
    }

    private void j() {
        GdtLog.d("GdtVideoCeilingView", "----close click");
        Activity m3 = m();
        if (m3 != null) {
            m3.finish();
            m3.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            GdtLog.d("GdtVideoCeilingView", "----finish activity");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@NonNull RelativeLayout.LayoutParams layoutParams, @Nullable GdtVideoCeilingLandView gdtVideoCeilingLandView, boolean z16) {
        GdtVideoCommonView gdtVideoCommonView;
        if (gdtVideoCeilingLandView == null) {
            return;
        }
        if (gdtVideoCeilingLandView.mState == 0) {
            layoutParams.height = this.f109714i - this.f109713h;
        } else {
            layoutParams.height = this.f109714i;
        }
        gdtVideoCeilingLandView.isAnimating = false;
        gdtVideoCeilingLandView.setLayoutParams(layoutParams);
        if (z16 && (gdtVideoCommonView = this.f109711e) != null && gdtVideoCommonView.I) {
            gdtVideoCommonView.p0();
        }
        View view = this.f109712f;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    @Nullable
    private Activity m() {
        if (getContext() instanceof Activity) {
            return (Activity) getContext();
        }
        return null;
    }

    @Nullable
    private Intent o() {
        if (m() == null) {
            return null;
        }
        return m().getIntent();
    }

    private int p(int i3, int i16) {
        int i17 = (int) (i3 * 0.5625d);
        String widthHeightRatio = this.f109710d.getWidthHeightRatio();
        if (TextUtils.isEmpty(widthHeightRatio)) {
            return i17;
        }
        if (widthHeightRatio.split(":").length == 0) {
            return i17;
        }
        return (int) Math.min(i3 * (Float.parseFloat(r1[1]) / Integer.parseInt(r1[0])), i16 * 0.85d);
    }

    private void q() {
        t();
    }

    private void r() {
        this.f109712f = findViewById(com.tencent.mobileqq.R.id.ks9);
        GdtVideoCeilingLandView gdtVideoCeilingLandView = (GdtVideoCeilingLandView) findViewById(com.tencent.mobileqq.R.id.crt);
        this.D = gdtVideoCeilingLandView;
        gdtVideoCeilingLandView.setGdtVideoCeilingListeners(this, this.f109715m);
    }

    private void s() {
        B(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXTENSIONS_LOAD_START);
        GdtVideoCommonView gdtVideoCommonView = (GdtVideoCommonView) findViewById(com.tencent.mobileqq.R.id.koo);
        this.f109711e = gdtVideoCommonView;
        gdtVideoCommonView.setOnVideoFullScreen(this);
        this.f109711e.N(new a());
        this.f109711e.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    private void t() {
        View.inflate(getContext(), com.tencent.mobileqq.R.layout.f168004or, this);
        s();
        r();
    }

    private void u() {
        GdtVideoCeilingTitleBar gdtVideoCeilingTitleBar = (GdtVideoCeilingTitleBar) findViewById(com.tencent.mobileqq.R.id.l1w);
        this.G = gdtVideoCeilingTitleBar;
        gdtVideoCeilingTitleBar.setOnBtnClickListener(this);
        this.G.c();
    }

    private void v() {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        this.E = (FrameLayout) findViewById(com.tencent.mobileqq.R.id.l1y);
        TouchWebView touchWebView = new TouchWebView(getContext());
        this.f109715m = touchWebView;
        this.E.addView(touchWebView);
        c cVar = new c(getContext(), m(), o(), appInterface);
        this.C = cVar;
        cVar.setWebView(this.f109715m);
        new m(this.C).a(null, appInterface, o());
    }

    public void A(@Nullable GdtVideoCeilingLandView gdtVideoCeilingLandView, int i3, boolean z16) {
        if (gdtVideoCeilingLandView == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gdtVideoCeilingLandView.getLayoutParams();
        ofFloat.addUpdateListener(new d(layoutParams, layoutParams.topMargin, i3, gdtVideoCeilingLandView, z16));
        ofFloat.setDuration(300L);
        gdtVideoCeilingLandView.isAnimating = true;
        ofFloat.start();
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.g
    public void a() {
        GdtVideoCommonView gdtVideoCommonView = this.f109711e;
        if (gdtVideoCommonView != null && !gdtVideoCommonView.c0()) {
            this.f109711e.setisFullScreen(true, 0);
        }
    }

    @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.g
    public void b() {
        this.f109711e.setisFullScreen(false, 0);
    }

    @Override // com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar.b
    public void c(@NonNull View view) {
        int id5 = view.getId();
        if (id5 == com.tencent.mobileqq.R.id.f164559a43) {
            i();
        } else if (id5 == com.tencent.mobileqq.R.id.tzs) {
            j();
        }
    }

    public boolean i() {
        String str;
        GdtLog.d("GdtVideoCeilingView", "----back click");
        boolean z16 = true;
        if (this.f109711e.c0()) {
            b();
            str = " videoView.isFullScreen() result = true";
        } else {
            TouchWebView touchWebView = this.f109715m;
            if (touchWebView != null && touchWebView.canGoBack()) {
                this.f109715m.goBack();
                str = " webView.goBack() result = true";
            } else if (m() != null) {
                m().finish();
                m().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                str = " getActivity().finish() result = true";
            } else {
                z16 = false;
                str = "";
            }
        }
        GdtLog.d("GdtVideoCeilingView", "----back return " + z16 + str);
        return z16;
    }

    protected void k(int i3) {
        GdtVideoCeilingLandView gdtVideoCeilingLandView = this.D;
        if (gdtVideoCeilingLandView != null && this.f109711e != null && i3 == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gdtVideoCeilingLandView.getLayoutParams();
            layoutParams.topMargin = this.f109713h;
            int i16 = layoutParams.height;
            int i17 = this.f109714i;
            if (i16 != i17) {
                layoutParams.height = i17;
                this.D.setLayoutParams(layoutParams);
            }
        }
    }

    public long n() {
        GdtVideoCommonView gdtVideoCommonView = this.f109711e;
        if (gdtVideoCommonView != null) {
            return gdtVideoCommonView.S();
        }
        return 0L;
    }

    @Override // com.tencent.gdtad.views.videoceiling.GdtVideoCeilingListener
    public void onDrag(int i3) {
        if (this.D != null && this.f109712f != null) {
            GdtVideoCommonView gdtVideoCommonView = this.f109711e;
            if (gdtVideoCommonView != null) {
                gdtVideoCommonView.m0();
            }
            k(this.D.mState);
            int top = this.D.getTop() + ((int) (i3 + 0.5f));
            int i16 = this.f109713h;
            if (top > i16) {
                top = i16;
            } else if (top < 0) {
                top = 0;
            }
            GdtLog.i("GdtVideoCeilingView", "onDrag newTop " + top);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams.topMargin = top;
            this.D.setLayoutParams(layoutParams);
            try {
                if (this.f109713h == 0) {
                    this.f109713h = 607;
                }
                if (this.f109712f.getVisibility() == 4) {
                    this.f109712f.setVisibility(0);
                }
                this.f109712f.setAlpha(1.0f - ((top * 1.0f) / this.f109713h));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        if (r6.F == 1) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    @Override // com.tencent.gdtad.views.videoceiling.GdtVideoCeilingListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onEnd(int i3) {
        int i16;
        GdtVideoCeilingLandView gdtVideoCeilingLandView = this.D;
        if (gdtVideoCeilingLandView == null) {
            GdtLog.e("GdtVideoCeilingView", "onEnd  view null ");
            return;
        }
        int i17 = this.f109713h;
        int i18 = (int) (i17 * 0.2f);
        int i19 = i17 - i18;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gdtVideoCeilingLandView.getLayoutParams();
        int i26 = layoutParams.topMargin;
        boolean z16 = true;
        if (i3 == 0) {
            if (i26 <= i19) {
                this.D.mState = 2;
                i16 = -i26;
            } else {
                i16 = this.f109713h - i26;
            }
        } else {
            if (i26 >= i18) {
                this.D.mState = 0;
                i16 = this.f109713h - i26;
                if (Math.abs(i16) <= 0) {
                    A(this.D, i16, z16);
                    return;
                } else {
                    l(layoutParams, this.D, z16);
                    return;
                }
            }
            i16 = -i26;
        }
        z16 = false;
        if (Math.abs(i16) <= 0) {
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16) {
            C(i17 - i3, i18 - i16);
        }
    }

    @Override // com.tencent.gdtad.views.videoceiling.GdtVideoCeilingListener
    public void onStart(int i3) {
        int i16;
        if (this.f109711e.d0()) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        this.F = i16;
    }

    public void setData(@Nullable GdtVideoCeilingData gdtVideoCeilingData) {
        GdtVideoCommonView gdtVideoCommonView;
        if (gdtVideoCeilingData != null && gdtVideoCeilingData.isValid() && (gdtVideoCommonView = this.f109711e) != null) {
            this.f109710d = gdtVideoCeilingData;
            gdtVideoCommonView.setData(gdtVideoCeilingData.getVideoData());
            u();
            v();
            this.G.setVisibility(0);
            findViewById(com.tencent.mobileqq.R.id.ioc).setVisibility(0);
            this.E.setVisibility(0);
            this.f109715m.loadUrl(this.f109710d.getWebUrl());
        }
    }

    public void w(Bundle bundle) {
        zm0.c cVar = this.C;
        if (cVar != null) {
            cVar.onCreate(bundle);
        }
    }

    public void x() {
        ViewParent parent;
        GdtVideoCommonView gdtVideoCommonView = this.f109711e;
        if (gdtVideoCommonView != null) {
            gdtVideoCommonView.l0();
        }
        zm0.c cVar = this.C;
        if (cVar != null) {
            cVar.onDestroy();
        }
        TouchWebView touchWebView = this.f109715m;
        if (touchWebView != null && (parent = touchWebView.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeAllViewsInLayout();
        }
    }

    public void y() {
        GdtVideoCommonView gdtVideoCommonView = this.f109711e;
        if (gdtVideoCommonView != null) {
            gdtVideoCommonView.n0();
        }
        zm0.c cVar = this.C;
        if (cVar != null) {
            cVar.onPause();
        }
    }

    public void z() {
        GdtVideoCommonView gdtVideoCommonView = this.f109711e;
        if (gdtVideoCommonView != null) {
            gdtVideoCommonView.u0();
        }
        zm0.c cVar = this.C;
        if (cVar != null) {
            cVar.onResume();
        }
    }

    public GdtVideoCeilingView(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f109713h = 607;
        this.f109714i = 1920;
        this.F = 1;
        q();
    }

    public GdtVideoCeilingView(@NonNull Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f109713h = 607;
        this.f109714i = 1920;
        this.F = 1;
        q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements GdtVideoCommonView.h {
        a() {
        }

        @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.h
        public void b(GdtVideoCommonView gdtVideoCommonView) {
            GdtVideoCeilingView.this.B(sdk_event_log.SdkEventDimension.EVENT_LANDING_PAGE_EXTENSIONS_VIDEO_PLAY_START);
        }

        @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.h
        public void a(GdtVideoCommonView gdtVideoCommonView) {
        }

        @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.h
        public void c(GdtVideoCommonView gdtVideoCommonView) {
        }

        @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.h
        public void d(View view) {
        }

        @Override // com.tencent.gdtad.views.video.GdtVideoCommonView.h
        public void e(GdtVideoCommonView gdtVideoCommonView) {
        }
    }
}
