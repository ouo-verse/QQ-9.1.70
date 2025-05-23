package com.tencent.gdtad.basics.motivevideo;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.views.floattips.AdFloatTipsViewContainer;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.basics.motivevideo.report.b;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.views.adcard.GdtMvAdCardData;
import com.tencent.gdtad.views.adcard.GdtMvBottomAdCardView;
import com.tencent.gdtad.views.adcard.GdtMvEndAdCardView;
import com.tencent.gdtad.views.guide.GdtClickGuideView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.util.LiuHaiUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import tencent.gdt.qq_ad_get;
import tencent.gdt.qq_common;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g implements View.OnClickListener {
    private LinearLayout C;
    private ImageView D;
    private TextView E;
    private View F;
    private View G;
    private GdtClickGuideView H;
    private GdtMvBottomAdCardView I;
    private GdtMvEndAdCardView J;
    private float K;
    private float L;
    private GdtMotiveVideoModel N;
    private final com.tencent.gdtad.basics.motivevideo.report.b P;
    public GdtThirdProcessorProxy Q;
    private GdtAd R;
    private boolean S;
    private final HashSet<Integer> T;

    /* renamed from: d, reason: collision with root package name */
    private GdtMvVideoViewController f108940d;

    /* renamed from: e, reason: collision with root package name */
    private Context f108941e;

    /* renamed from: f, reason: collision with root package name */
    private View f108942f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f108943h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f108944i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f108945m;
    private float M = 0.0f;
    private int U = 1;
    private int V = 0;
    private volatile boolean W = true;
    private volatile boolean X = false;
    private final List<ValueAnimator> Y = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!g.this.W) {
                return false;
            }
            float y16 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    QLog.d("GdtMvElementsController", 1, "MotionEvent.ACTION_UP y:" + y16);
                    float f16 = g.this.M - y16;
                    g.this.M = y16;
                    if (f16 > ViewUtils.dpToPx(75.0f) && g.this.I != null) {
                        QLog.d("GdtMvElementsController", 1, "mIsSwipeUpEnable: " + g.this.W + ", offsetY: " + f16);
                        g.this.I(true);
                        return true;
                    }
                    if (g.this.X) {
                        g.this.I(false);
                        return true;
                    }
                }
            } else {
                QLog.d("GdtMvElementsController", 1, "MotionEvent.ACTION_DOWN y:" + y16);
                g.this.M = y16;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements b.InterfaceC1159b {
        b() {
        }

        @Override // com.tencent.gdtad.basics.motivevideo.report.b.InterfaceC1159b
        public void a(long j3, long j16, int i3, int i16, int i17, int i18) {
            int i19;
            g.this.K = i17;
            g.this.L = i18;
            if (QLog.isColorLevel()) {
                QLog.i("GdtMvElementsController", 2, "mClickUpX:" + g.this.K + ";mClickUpY:" + g.this.L);
            }
            if (g.this.U == 3 && g.this.W && (i19 = i16 - i18) > ViewUtils.dpToPx(75.0f)) {
                QLog.d("GdtMvElementsController", 1, "mIsSwipeUpEnable: " + g.this.W + ", downY - upY: " + i19);
                g.this.I(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GdtLog.i("GdtMvElementsController", "tips industry view onClick, do nothing");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (g.this.C == null) {
                return;
            }
            g.this.C.setTranslationY(floatValue * ViewUtils.dpToPx(10.0f) * (-1.0f));
        }
    }

    public g(GdtMvVideoViewController gdtMvVideoViewController, View view, GdtMotiveVideoModel gdtMotiveVideoModel, GdtThirdProcessorProxy gdtThirdProcessorProxy) {
        GdtAd gdtAd;
        GdtLog.d("GdtMvElementsController", "GdtMvElementsController: ");
        this.f108940d = gdtMvVideoViewController;
        this.f108942f = view;
        Context context = view.getContext();
        this.f108941e = context;
        this.f108941e = u(context);
        this.N = gdtMotiveVideoModel;
        if (gdtMotiveVideoModel != null) {
            gdtAd = gdtMotiveVideoModel.getGdtAd();
        } else {
            gdtAd = null;
        }
        this.R = gdtAd;
        this.P = new com.tencent.gdtad.basics.motivevideo.report.b();
        this.Q = gdtThirdProcessorProxy;
        this.T = new HashSet<>();
    }

    private void A() {
        View view;
        GdtMvBottomAdCardView gdtMvBottomAdCardView = this.I;
        if (gdtMvBottomAdCardView != null) {
            b0(gdtMvBottomAdCardView.getAdBtn(), true);
        }
        Z(v(false), false);
        if (this.U == 3 && (view = this.F) != null) {
            view.setOnTouchListener(new a());
        }
        this.P.k(new b());
    }

    private void B() {
        int i3;
        try {
            LiuHaiUtils.initLiuHaiProperty((Activity) this.f108941e);
            if (LiuHaiUtils.isLiuHaiUseValid()) {
                i3 = LiuHaiUtils.getNotchInScreenHeight((Activity) this.f108941e);
            } else {
                i3 = 0;
            }
            this.V = i3;
        } catch (Throwable th5) {
            QLog.e("GdtMvElementsController", 1, "getNotchInScreenHeight error:", th5);
        }
    }

    private void C() {
        View view = this.f108942f;
        if (view == null) {
            QLog.e("GdtMvElementsController", 1, "initViews fail: rootView is null");
            return;
        }
        this.f108943h = (RelativeLayout) view.findViewById(R.id.krm);
        this.f108944i = (FrameLayout) this.f108942f.findViewById(R.id.scc);
        this.f108945m = (FrameLayout) this.f108942f.findViewById(R.id.vml);
        this.C = (LinearLayout) this.f108942f.findViewById(R.id.sc8);
        this.D = (ImageView) this.f108942f.findViewById(R.id.sc9);
        this.E = (TextView) this.f108942f.findViewById(R.id.sc_);
        this.F = this.f108942f.findViewById(R.id.f911054_);
        this.G = this.f108942f.findViewById(R.id.sc7);
        this.I = (GdtMvBottomAdCardView) this.f108942f.findViewById(R.id.sb9);
        this.J = (GdtMvEndAdCardView) this.f108942f.findViewById(R.id.sbg);
    }

    private void E(GdtMotiveVideoModel gdtMotiveVideoModel) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData;
        if (gdtMotiveVideoModel == null || (gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData()) == null) {
            return;
        }
        gdtMotiveVideoPageData.getType();
        if (gdtMotiveVideoPageData.screenOrientation == 1) {
            R(true);
            Q(true);
        } else {
            R(false);
            Q(false);
        }
    }

    private boolean F() {
        if (this.I != null && this.J != null) {
            return true;
        }
        return false;
    }

    private boolean G() {
        com.tencent.mobileqq.ad.debug.a aVar = com.tencent.mobileqq.ad.debug.a.f186830a;
        if (aVar.f()) {
            return aVar.h();
        }
        GdtAd gdtAd = this.R;
        if (gdtAd != null && gdtAd.isSupportNoneButtonStyle()) {
            return true;
        }
        return false;
    }

    private boolean H() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2 = this.f108944i;
        if ((frameLayout2 != null && frameLayout2.getVisibility() == 0) || ((frameLayout = this.f108945m) != null && frameLayout.getVisibility() == 0)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(boolean z16) {
        GdtMvBottomAdCardView gdtMvBottomAdCardView = this.I;
        if (gdtMvBottomAdCardView != null && gdtMvBottomAdCardView.getAdBtn() != null) {
            View adBtn = this.I.getAdBtn();
            if (v(false) == 2) {
                adBtn = this.I;
            } else if (v(false) == 4) {
                adBtn = this.f108942f;
            }
            J(adBtn.getId(), null, false, z16);
        }
    }

    private GdtMvAdCardData P(GdtMotiveVideoModel gdtMotiveVideoModel) {
        if (gdtMotiveVideoModel == null) {
            return null;
        }
        GdtMotiveVideoPageData gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        GdtMvAdCardData gdtMvAdCardData = new GdtMvAdCardData();
        gdtMvAdCardData.adIconUrl = gdtMotiveVideoPageData.bannerLogo;
        gdtMvAdCardData.adTitle = gdtMotiveVideoPageData.bannerImgName;
        gdtMvAdCardData.adContent = gdtMotiveVideoPageData.bannerBaseInfoText;
        gdtMvAdCardData.adBtnText = h.a(gdtMotiveVideoModel);
        return gdtMvAdCardData;
    }

    private void Q(boolean z16) {
        int dpToPx;
        GdtMvBottomAdCardView gdtMvBottomAdCardView = this.I;
        if (gdtMvBottomAdCardView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gdtMvBottomAdCardView.getLayoutParams();
        float f16 = 16.0f;
        float f17 = 12.0f;
        if (this.S) {
            dpToPx = ViewUtils.dpToPx(12.0f);
        } else {
            dpToPx = ViewUtils.dpToPx(16.0f) + this.V;
        }
        layoutParams.leftMargin = dpToPx;
        if (this.S) {
            f16 = 12.0f;
        }
        layoutParams.rightMargin = ViewUtils.dpToPx(f16);
        if (H()) {
            layoutParams.bottomMargin = ViewUtils.dpToPx(19.0f);
            return;
        }
        if (!z16) {
            f17 = 10.0f;
        }
        layoutParams.bottomMargin = ViewUtils.dpToPx(f17);
    }

    private void R(boolean z16) {
        float f16;
        if (this.U >= 3 && this.C != null && this.G != null && this.D != null && this.E != null) {
            T();
            U();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
            if (z16) {
                f16 = 12.0f;
            } else {
                f16 = 8.0f;
            }
            layoutParams.bottomMargin = ViewUtils.dpToPx(f16);
            this.C.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.G.getLayoutParams()).height = (int) (GdtUIUtils.getScreenHeight(this.f108941e) * 0.5f);
            this.G.setVisibility(0);
        }
    }

    private void T() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable("https://qq-weather.cdn-go.cn/weather-hippy/latest/gdt_mv_ad_swipe_up_icon.png", obtain);
        this.D.setImageDrawable(drawable);
        Drawable currDrawable = drawable.getCurrDrawable();
        if (currDrawable instanceof ApngDrawable) {
            ApngDrawable apngDrawable = (ApngDrawable) currDrawable;
            apngDrawable.getImage().setSupportGlobalPasued(false);
            apngDrawable.resume();
        }
    }

    private void U() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 0.5f, 1.0f, 1.0f, 0.5f, 0.0f, 0.0f, 0.0f);
        ofFloat.addUpdateListener(new d());
        ofFloat.setDuration(1190L);
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        this.Y.add(ofFloat);
    }

    private void V(boolean z16) {
        if (z16) {
            b0(this.J, true);
        } else {
            b0(this.I, true);
        }
    }

    private void W() {
        b0(this.I, false);
        b0(this.J, false);
        b0(this.f108942f, true);
        this.X = true;
    }

    private void X(boolean z16) {
        if (z16) {
            GdtMvEndAdCardView gdtMvEndAdCardView = this.J;
            if (gdtMvEndAdCardView == null) {
                return;
            }
            b0(gdtMvEndAdCardView, false);
            b0(this.J.getAdBtn(), true);
            return;
        }
        GdtMvBottomAdCardView gdtMvBottomAdCardView = this.I;
        if (gdtMvBottomAdCardView == null) {
            return;
        }
        b0(gdtMvBottomAdCardView, false);
        b0(this.I.getAdBtn(), true);
    }

    private void Y(boolean z16) {
        if (z16) {
            GdtMvEndAdCardView gdtMvEndAdCardView = this.J;
            if (gdtMvEndAdCardView == null) {
                return;
            }
            b0(gdtMvEndAdCardView, false);
            b0(this.J.getAdLogoView(), true);
            b0(this.J.getAdTitle(), true);
            b0(this.J.getAdContent(), true);
            b0(this.J.getAdBtn(), true);
            return;
        }
        GdtMvBottomAdCardView gdtMvBottomAdCardView = this.I;
        if (gdtMvBottomAdCardView == null) {
            return;
        }
        b0(gdtMvBottomAdCardView, false);
        b0(this.I.getAdLogoView(), true);
        b0(this.I.getAdTitle(), true);
        b0(this.I.getAdContent(), true);
        b0(this.I.getAdBtn(), true);
    }

    private void Z(int i3, boolean z16) {
        View view;
        if (this.P != null && (view = this.f108942f) != null) {
            this.T.remove(Integer.valueOf(view.getId()));
            this.P.i(this.f108942f);
            c0(this.f108942f, false);
            this.X = false;
            a0(i3, z16);
            return;
        }
        QLog.i("GdtMvElementsController", 1, "object is null, can't updateButtonClickable");
    }

    private void a0(int i3, boolean z16) {
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    X(z16);
                    return;
                } else {
                    W();
                    return;
                }
            }
            Y(z16);
            return;
        }
        V(z16);
    }

    private void b0(View view, boolean z16) {
        if (view == null) {
            return;
        }
        if (z16) {
            this.T.add(Integer.valueOf(view.getId()));
            this.P.g(view);
        } else {
            this.T.remove(Integer.valueOf(view.getId()));
            this.P.i(view);
        }
        c0(view, z16);
    }

    private void c0(View view, boolean z16) {
        if (view == null) {
            QLog.i("GdtMvElementsController", 1, "view is null, can't updateViewClickable");
        } else if (z16) {
            view.setOnClickListener(this);
        } else {
            view.setClickable(false);
        }
    }

    private void m(boolean z16) {
        float f16;
        if ((this.f108942f instanceof ViewGroup) && this.f108941e != null && r()) {
            GdtLog.i("GdtMvElementsController", "[addClickGuideView] isVertical:" + z16);
            GdtClickGuideView gdtClickGuideView = new GdtClickGuideView(this.f108941e);
            int dpToPx = ViewUtils.dpToPx(180.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
            layoutParams.addRule(5, R.id.sbg);
            layoutParams.addRule(6, R.id.sbg);
            if (this.S) {
                f16 = 100.0f;
            } else {
                f16 = 50.0f;
            }
            layoutParams.leftMargin = ViewUtils.dpToPx(f16);
            layoutParams.topMargin = ViewUtils.dpToPx(125.0f);
            ((ViewGroup) this.f108942f).addView(gdtClickGuideView, layoutParams);
            gdtClickGuideView.start();
            this.H = gdtClickGuideView;
        }
    }

    private void n(GdtMotiveVideoModel gdtMotiveVideoModel) {
        if (gdtMotiveVideoModel == null) {
            return;
        }
        FrameLayout frameLayout = this.f108944i;
        if (frameLayout != null) {
            if (!this.S) {
                ((RelativeLayout.LayoutParams) frameLayout.getLayoutParams()).leftMargin = ViewUtils.dpToPx(16.0f) + this.V;
                this.f108944i.requestLayout();
            }
            this.f108944i.setVisibility(0);
            this.f108944i.removeAllViews();
        }
        FrameLayout frameLayout2 = this.f108945m;
        if (frameLayout2 != null) {
            if (!this.S) {
                ((RelativeLayout.LayoutParams) frameLayout2.getLayoutParams()).leftMargin = ViewUtils.dpToPx(16.0f) + this.V;
                this.f108945m.requestLayout();
            }
            this.f108945m.setVisibility(0);
            this.f108945m.removeAllViews();
        }
        qq_common.FloatingTip floatingTips = gdtMotiveVideoModel.getGdtAd().getFloatingTips(1);
        qq_common.FloatingTip floatingTips2 = gdtMotiveVideoModel.getGdtAd().getFloatingTips(2);
        if (floatingTips == null && floatingTips2 == null) {
            FrameLayout frameLayout3 = this.f108944i;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            FrameLayout frameLayout4 = this.f108945m;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(8);
                return;
            }
            return;
        }
        Context context = this.f108941e;
        AdFloatTipsViewContainer adFloatTipsViewContainer = new AdFloatTipsViewContainer(context, s(context, floatingTips, true), s(this.f108941e, floatingTips2, true));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout5 = this.f108944i;
        if (frameLayout5 != null) {
            frameLayout5.addView(adFloatTipsViewContainer, layoutParams);
        }
        if (floatingTips2 == null) {
            FrameLayout frameLayout6 = this.f108945m;
            if (frameLayout6 != null) {
                frameLayout6.setVisibility(8);
                return;
            }
            return;
        }
        Context context2 = this.f108941e;
        AdFloatTipsViewContainer adFloatTipsViewContainer2 = new AdFloatTipsViewContainer(context2, s(context2, floatingTips, false), s(this.f108941e, floatingTips2, false));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout7 = this.f108945m;
        if (frameLayout7 != null) {
            frameLayout7.addView(adFloatTipsViewContainer2, layoutParams2);
        }
        adFloatTipsViewContainer2.getIndustrialView().setOnClickListener(new c());
    }

    private void o(boolean z16) {
        if (!F()) {
            return;
        }
        this.f108943h.setVisibility(8);
        this.I.setVisibility(8);
        LinearLayout linearLayout = this.C;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view = this.G;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.F;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        this.W = false;
        this.J.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.J.getLayoutParams();
        if (z16) {
            layoutParams.topMargin = x(500);
        } else {
            layoutParams.addRule(15);
        }
        this.J.startEndCardAnimation();
        this.J.clearNoneButtonColor();
    }

    private void q() {
        GdtMvAdCardData P = P(this.N);
        this.I.bindData(P);
        this.J.bindData(P, false);
    }

    private boolean r() {
        return true;
    }

    private static AdFloatTipsViewContainer.Params s(Context context, qq_common.FloatingTip floatingTip, boolean z16) {
        int i3;
        String str;
        AdFloatTipsViewContainer.Params params = new AdFloatTipsViewContainer.Params();
        if (floatingTip != null && !TextUtils.isEmpty(floatingTip.text.get())) {
            params.text = floatingTip.text.get();
        }
        if (floatingTip != null && z16) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        params.textColor = i3;
        params.textSize = GdtUIUtils.getOffsetByBaseline(16, 1624, GdtUIUtils.getMaxScreenSize(context));
        params.iconSize = y(context);
        if (floatingTip != null && z16) {
            str = floatingTip.get().icon_url.get();
        } else {
            str = null;
        }
        params.iconUrl = str;
        return params;
    }

    private void t() {
        for (ValueAnimator valueAnimator : this.Y) {
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
        this.Y.clear();
    }

    private static Context u(Context context) {
        if (context != null && !(context instanceof Activity) && (context instanceof ContextThemeWrapper)) {
            return u(((ContextThemeWrapper) context).getBaseContext());
        }
        return context;
    }

    private int v(boolean z16) {
        int motiveVideoBottomCardClickModel;
        if (this.R == null) {
            return 1;
        }
        boolean G = G();
        if (z16) {
            com.tencent.mobileqq.ad.debug.a aVar = com.tencent.mobileqq.ad.debug.a.f186830a;
            if (aVar.d()) {
                int e16 = aVar.e();
                if (G && e16 != 4) {
                    return 2;
                }
                return e16;
            }
        }
        if (!z16) {
            com.tencent.mobileqq.ad.debug.a aVar2 = com.tencent.mobileqq.ad.debug.a.f186830a;
            if (aVar2.b()) {
                int c16 = aVar2.c();
                if (G && c16 != 4) {
                    return 2;
                }
                return c16;
            }
        }
        if (z16) {
            motiveVideoBottomCardClickModel = this.R.getMotiveVideoEndCardClickModel();
        } else {
            motiveVideoBottomCardClickModel = this.R.getMotiveVideoBottomCardClickModel();
        }
        if (G && motiveVideoBottomCardClickModel != 4) {
            return 2;
        }
        return motiveVideoBottomCardClickModel;
    }

    private int x(int i3) {
        return GdtUIUtils.getOffsetByBaseline(i3, 1624, GdtUIUtils.getMaxScreenSize(this.f108941e));
    }

    private static int y(Context context) {
        return GdtUIUtils.getOffsetByBaseline(20, 1624, GdtUIUtils.getMaxScreenSize(context));
    }

    public void D() {
        int i3;
        boolean z16;
        com.tencent.mobileqq.ad.debug.a aVar = com.tencent.mobileqq.ad.debug.a.f186830a;
        boolean z17 = true;
        if (aVar.f()) {
            this.U = aVar.g();
        } else {
            GdtAd gdtAd = this.R;
            if (gdtAd != null) {
                i3 = gdtAd.getAdCardStyle();
            } else {
                i3 = 1;
            }
            this.U = i3;
        }
        GdtMotiveVideoPageData gdtMotiveVideoPageData = this.N.getGdtMotiveVideoPageData();
        if (gdtMotiveVideoPageData.screenOrientation == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.S = z16;
        boolean G = G();
        C();
        if (F()) {
            GdtMvBottomAdCardView gdtMvBottomAdCardView = this.I;
            int i16 = this.U;
            boolean z18 = this.S;
            if (gdtMotiveVideoPageData.getType() != 2) {
                z17 = false;
            }
            gdtMvBottomAdCardView.initView(i16, z18, z17, G);
            this.J.initView(this.U, G);
        }
        B();
        n(this.N);
        E(this.N);
        q();
        A();
    }

    public void J(int i3, String str, boolean z16, boolean z17) {
        L(this.N, i3, str, z16, z17);
    }

    public void K(View view, String str, boolean z16) {
        L(this.N, view.getId(), str, z16, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void L(GdtMotiveVideoModel gdtMotiveVideoModel, int i3, String str, boolean z16, boolean z17) {
        String str2;
        String str3;
        boolean z18;
        if (gdtMotiveVideoModel == null) {
            return;
        }
        GdtMotiveVideoPageData gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtMotiveVideoModel.getAdInfo();
        long M = this.f108940d.M();
        this.f108940d.N().setFinishType(2);
        if (this.T.contains(Integer.valueOf(i3))) {
            GdtLog.d("GdtMvElementsController", "[click ad btn] " + adInfo);
            com.tencent.gdtad.basics.motivevideo.b bVar = com.tencent.gdtad.basics.motivevideo.b.f108898a;
            bVar.e(this.f108941e, gdtMotiveVideoModel, 1);
            Activity activity = this.f108940d.L().getActivity();
            if (adInfo != null && activity != null) {
                str2 = adInfo.report_info.click_url.get();
                adInfo.report_info.click_url.set(this.P.f(str2, M, this.f108940d.K(), this.f108940d.a0(), str));
                if (i3 == 1) {
                    z18 = z16;
                } else {
                    z18 = false;
                }
                QLog.i("GdtMvElementsController", 1, "appAutoDownload:" + z18);
                GdtHandler.Params w3 = w(adInfo, gdtMotiveVideoPageData, activity, z18);
                int showCardStatus = GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus();
                if (showCardStatus == 2) {
                    w3.componentID = 48;
                } else if (showCardStatus == 1) {
                    w3.componentID = 47;
                }
                w3.useVerticalTransitionBetweenActivities = z17;
                if (bVar.d(this.R)) {
                    w3.videoCeilingSupportedIfNotInstalled = true;
                }
                w3.videoStartPositionMillis = M;
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(w3);
                str3 = str2;
                if (!TextUtils.isEmpty(str3) && adInfo != null) {
                    adInfo.report_info.click_url.set(str3);
                }
                if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() != 2) {
                    GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020015);
                } else if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() == 1) {
                    GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020014);
                }
                this.f108940d.u0(5);
            }
        }
        str2 = "";
        str3 = str2;
        if (!TextUtils.isEmpty(str3)) {
            adInfo.report_info.click_url.set(str3);
        }
        if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() != 2) {
        }
        this.f108940d.u0(5);
    }

    public void M() {
        t();
        GdtMvBottomAdCardView gdtMvBottomAdCardView = this.I;
        if (gdtMvBottomAdCardView != null) {
            gdtMvBottomAdCardView.clearAnimation();
            this.I.onDestroy();
            this.I = null;
        }
        GdtMvEndAdCardView gdtMvEndAdCardView = this.J;
        if (gdtMvEndAdCardView != null) {
            gdtMvEndAdCardView.clearAnimation();
            this.J = null;
        }
        if (this.G != null) {
            this.G = null;
        }
        LinearLayout linearLayout = this.C;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.C = null;
        }
        if (this.D != null) {
            this.D = null;
        }
        RelativeLayout relativeLayout = this.f108943h;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
            this.f108943h = null;
        }
        com.tencent.gdtad.basics.motivevideo.report.b bVar = this.P;
        if (bVar != null) {
            bVar.h();
        }
        GdtClickGuideView gdtClickGuideView = this.H;
        if (gdtClickGuideView != null) {
            gdtClickGuideView.stop();
            this.H = null;
        }
    }

    public void N() {
        GdtLog.d("GdtMvElementsController", "onPause: ");
        com.tencent.gdtad.basics.motivevideo.report.b bVar = this.P;
        if (bVar != null) {
            bVar.l(true);
        }
        GdtClickGuideView gdtClickGuideView = this.H;
        if (gdtClickGuideView != null) {
            gdtClickGuideView.stop();
        }
    }

    public void O() {
        GdtLog.d("GdtMvElementsController", "onResume: ");
        if (this.H != null && r()) {
            this.H.start();
        }
    }

    public void S(boolean z16) {
        this.S = z16;
        com.tencent.gdtad.basics.motivevideo.report.b bVar = this.P;
        if (bVar != null) {
            bVar.j(z16);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        K(view, null, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p(int i3) {
        GdtMotiveVideoPageData gdtMotiveVideoPageData = this.N.getGdtMotiveVideoPageData();
        if (gdtMotiveVideoPageData == null) {
            return;
        }
        Z(v(true), true);
        GdtLog.i("GdtMvElementsController", "adjustViewsPosition " + i3 + " style " + gdtMotiveVideoPageData.style);
        if (gdtMotiveVideoPageData.screenOrientation == 1) {
            o(true);
            m(true);
        } else {
            o(false);
            m(false);
        }
    }

    public GdtHandler.Params w(qq_ad_get.QQAdGetRsp.AdInfo adInfo, GdtMotiveVideoPageData gdtMotiveVideoPageData, Activity activity, boolean z16) {
        GdtHandler.Params params = new GdtHandler.Params();
        params.processId = gdtMotiveVideoPageData.processId;
        params.activity = new WeakReference<>(activity);
        params.f108486ad = new GdtAd(adInfo);
        params.reportForClick = true;
        params.appAutoDownload = z16;
        params.extra = new Bundle();
        String stringExtra = activity.getIntent().getStringExtra(LaunchParam.KEY_REF_ID);
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.i("GdtMvElementsController", 1, "getClickParam refId is empty");
            stringExtra = activity.getIntent().getStringExtra("big_brother_source_key");
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            params.extra.putString(LaunchParam.KEY_REF_ID, stringExtra);
        }
        return params;
    }

    public void z() {
        FrameLayout frameLayout = this.f108944i;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        FrameLayout frameLayout2 = this.f108945m;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
    }
}
