package com.tencent.gdtad.basics.motivevideo.motivepicture;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.views.floattips.AdFloatTipsViewContainer;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.h;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.adcard.GdtMvAdCardData;
import com.tencent.gdtad.views.adcard.GdtMvBigBottomAdCardView;
import com.tencent.gdtad.views.adcard.GdtMvBottomAdCardView;
import com.tencent.gdtad.views.adcard.GdtMvEndAdCardView;
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
public class b implements View.OnClickListener {
    private RelativeLayout C;
    private ImageView D;
    private View E;
    private GdtMvBottomAdCardView F;
    private GdtMvBigBottomAdCardView G;
    private GdtMvEndAdCardView H;
    private FrameLayout I;
    private FrameLayout J;
    private boolean K;
    private int L;
    private int M = 3;
    private int N = 0;
    private final HashSet<Integer> P = new HashSet<>();
    private final List<ValueAnimator> Q = Collections.synchronizedList(new ArrayList());

    /* renamed from: d, reason: collision with root package name */
    private Context f109079d;

    /* renamed from: e, reason: collision with root package name */
    private GdtMotiveVideoModel f109080e;

    /* renamed from: f, reason: collision with root package name */
    private final GdtMvPictureViewController f109081f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.gdtad.basics.motivevideo.report.d f109082h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.gdtad.basics.motivevideo.report.b f109083i;

    /* renamed from: m, reason: collision with root package name */
    private View f109084m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.basics.motivevideo.motivepicture.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1158b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f109086d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f109087e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f109088f;

        C1158b(RelativeLayout.LayoutParams layoutParams, int i3, int i16) {
            this.f109086d = layoutParams;
            this.f109087e = i3;
            this.f109088f = i16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.C == null) {
                return;
            }
            this.f109086d.bottomMargin = (int) (this.f109087e + (((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f109088f));
            b.this.C.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f109090d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f109091e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f109092f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f109093h;

        c(RelativeLayout.LayoutParams layoutParams, int i3, int i16, int i17) {
            this.f109090d = layoutParams;
            this.f109091e = i3;
            this.f109092f = i16;
            this.f109093h = i17;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.C == null) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            RelativeLayout.LayoutParams layoutParams = this.f109090d;
            layoutParams.bottomMargin = (int) (this.f109091e * floatValue);
            layoutParams.width = (int) (this.f109092f - (floatValue * this.f109093h));
            b.this.C.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout.LayoutParams f109095d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f109096e;

        d(RelativeLayout.LayoutParams layoutParams, int i3) {
            this.f109095d = layoutParams;
            this.f109096e = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.C == null) {
                return;
            }
            this.f109095d.rightMargin = (int) (this.f109096e * ((Float) valueAnimator.getAnimatedValue()).floatValue());
            b.this.C.requestLayout();
        }
    }

    public b(GdtMvPictureViewController gdtMvPictureViewController, View view, GdtMotiveVideoModel gdtMotiveVideoModel, GdtThirdProcessorProxy gdtThirdProcessorProxy) {
        this.f109081f = gdtMvPictureViewController;
        if (view == null) {
            return;
        }
        this.f109084m = view;
        Context context = view.getContext();
        this.f109079d = context;
        this.f109079d = l(context);
        this.f109080e = gdtMotiveVideoModel;
        this.f109083i = new com.tencent.gdtad.basics.motivevideo.report.b();
    }

    private void A() {
        E(this.F, false);
        E(this.G, false);
        E(this.H, false);
        E(this.f109084m, true);
    }

    private void E(View view, boolean z16) {
        if (view == null) {
            return;
        }
        if (z16) {
            this.P.add(Integer.valueOf(view.getId()));
            M(view, true);
            this.f109083i.g(view);
        } else {
            this.P.remove(Integer.valueOf(view.getId()));
            M(view, false);
            this.f109083i.i(view);
        }
    }

    private void G() {
        if (this.K) {
            if (this.L == 4) {
                H();
                return;
            } else {
                I();
                return;
            }
        }
        J();
    }

    private void H() {
        if (this.C == null || this.G == null || ViewUtils.getScreenHeight() == 0) {
            return;
        }
        int dpToPx = ViewUtils.dpToPx(334.0f);
        int dpToPx2 = ViewUtils.dpToPx(372.0f) - dpToPx;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new C1158b(layoutParams, dpToPx, dpToPx2));
        ofFloat.start();
        this.Q.add(ofFloat);
    }

    private void I() {
        int screenHeight;
        if (this.C == null || (screenHeight = ViewUtils.getScreenHeight()) == 0) {
            return;
        }
        int bigBottomAdCardHeight = this.G.getBigBottomAdCardHeight();
        int screenWidth = ViewUtils.getScreenWidth();
        int i3 = screenWidth - ((int) (((screenHeight - bigBottomAdCardHeight) * 9.0f) / 16.0f));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(400L);
        ofFloat.addUpdateListener(new c(layoutParams, bigBottomAdCardHeight, screenWidth, i3));
        ofFloat.start();
        this.Q.add(ofFloat);
    }

    private void J() {
        GdtMvBigBottomAdCardView gdtMvBigBottomAdCardView;
        if (this.C != null && (gdtMvBigBottomAdCardView = this.G) != null) {
            int bigBottomAdCardWidth = gdtMvBigBottomAdCardView.getBigBottomAdCardWidth();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addUpdateListener(new d(layoutParams, bigBottomAdCardWidth));
            ofFloat.start();
            this.Q.add(ofFloat);
        }
    }

    private void K() {
        if (this.F != null && this.G != null) {
            int m3 = m(false);
            E(this.F.getAdBtn(), true);
            E(this.G.getAdBtn(), true);
            E(this.f109084m, false);
            if (m3 != 2) {
                if (m3 != 3) {
                    if (m3 == 4) {
                        A();
                        return;
                    }
                    return;
                } else {
                    E(this.F.getAdLogoView(), true);
                    E(this.F.getAdTitle(), true);
                    E(this.F.getAdContent(), true);
                    E(this.G.getAdLogoView(), true);
                    E(this.G.getAdTitle(), true);
                    E(this.G.getAdContent(), true);
                    return;
                }
            }
            E(this.F, true);
            E(this.G, true);
            E(this.F.getAdTitle(), true);
        }
    }

    private void L() {
        if (this.H == null) {
            return;
        }
        E(this.f109084m, false);
        int m3 = m(true);
        if (m3 != 2) {
            if (m3 != 3) {
                if (m3 != 4) {
                    E(this.H.getAdBtn(), true);
                    return;
                } else {
                    A();
                    return;
                }
            }
            E(this.H.getAdLogoView(), true);
            E(this.H.getAdTitle(), true);
            E(this.H.getAdContent(), true);
            E(this.H.getAdBtn(), true);
            return;
        }
        E(this.H, true);
    }

    private void M(View view, boolean z16) {
        if (view == null) {
            QLog.i("GdtMvPictureElementController", 1, "view is null, can't updateViewClickable");
        } else if (z16) {
            view.setOnClickListener(this);
        } else {
            view.setClickable(false);
        }
    }

    private void c(GdtMotiveVideoModel gdtMotiveVideoModel) {
        if (gdtMotiveVideoModel == null) {
            return;
        }
        FrameLayout frameLayout = this.I;
        if (frameLayout != null) {
            if (!this.K) {
                ((RelativeLayout.LayoutParams) frameLayout.getLayoutParams()).leftMargin = ViewUtils.dpToPx(16.0f) + this.N;
                this.I.requestLayout();
            }
            this.I.setVisibility(0);
            this.I.removeAllViews();
        }
        FrameLayout frameLayout2 = this.J;
        if (frameLayout2 != null) {
            if (!this.K) {
                ((RelativeLayout.LayoutParams) frameLayout2.getLayoutParams()).leftMargin = ViewUtils.dpToPx(16.0f) + this.N;
                this.J.requestLayout();
            }
            this.J.setVisibility(0);
            this.J.removeAllViews();
        }
        qq_common.FloatingTip floatingTips = gdtMotiveVideoModel.getGdtAd().getFloatingTips(1);
        qq_common.FloatingTip floatingTips2 = gdtMotiveVideoModel.getGdtAd().getFloatingTips(2);
        if (floatingTips == null && floatingTips2 == null) {
            FrameLayout frameLayout3 = this.I;
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(8);
            }
            FrameLayout frameLayout4 = this.J;
            if (frameLayout4 != null) {
                frameLayout4.setVisibility(8);
                return;
            }
            return;
        }
        AdFloatTipsViewContainer adFloatTipsViewContainer = new AdFloatTipsViewContainer(this.f109079d, j(floatingTips, true), j(floatingTips2, true));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout5 = this.I;
        if (frameLayout5 != null) {
            frameLayout5.addView(adFloatTipsViewContainer, layoutParams);
        }
        if (floatingTips2 == null) {
            FrameLayout frameLayout6 = this.J;
            if (frameLayout6 != null) {
                frameLayout6.setVisibility(8);
                return;
            }
            return;
        }
        AdFloatTipsViewContainer adFloatTipsViewContainer2 = new AdFloatTipsViewContainer(this.f109079d, j(floatingTips, false), j(floatingTips2, false));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout7 = this.J;
        if (frameLayout7 != null) {
            frameLayout7.addView(adFloatTipsViewContainer2, layoutParams2);
        }
    }

    private void g() {
        GdtMvAdCardData z16 = z(this.f109080e);
        this.F.bindData(z16);
        this.G.setIsTipContainerExist(v());
        this.G.bindData(z16);
        this.H.setIsVertical(this.K);
        this.H.bindData(z16, false);
        if (z16 != null && TextUtils.isEmpty(z16.adIconUrl) && TextUtils.isEmpty(z16.adTitle)) {
            if (this.K) {
                ((RelativeLayout.LayoutParams) this.G.getLayoutParams()).height = ViewUtils.dpToPx(350.0f);
                this.G.requestLayout();
            }
            ((RelativeLayout.LayoutParams) this.H.getLayoutParams()).height = ViewUtils.dpToPx(220.0f);
            this.H.requestLayout();
        }
    }

    private static AdFloatTipsViewContainer.Params j(qq_common.FloatingTip floatingTip, boolean z16) {
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
        params.textSize = ViewUtils.spToPx(8.0f);
        params.iconSize = ViewUtils.dpToPx(10.0f);
        if (floatingTip != null && z16) {
            str = floatingTip.get().icon_url.get();
        } else {
            str = null;
        }
        params.iconUrl = str;
        return params;
    }

    private void k() {
        for (ValueAnimator valueAnimator : this.Q) {
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
        this.Q.clear();
    }

    private static Context l(Context context) {
        if (context != null && !(context instanceof Activity) && (context instanceof ContextThemeWrapper)) {
            return l(((ContextThemeWrapper) context).getBaseContext());
        }
        return context;
    }

    private int m(boolean z16) {
        int motiveVideoBottomCardClickModel;
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f109080e;
        if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.getGdtAd() != null) {
            boolean u16 = u();
            if (z16) {
                com.tencent.mobileqq.ad.debug.a aVar = com.tencent.mobileqq.ad.debug.a.f186830a;
                if (aVar.d()) {
                    int e16 = aVar.e();
                    if (u16 && e16 != 4) {
                        return 2;
                    }
                    return e16;
                }
            }
            if (!z16) {
                com.tencent.mobileqq.ad.debug.a aVar2 = com.tencent.mobileqq.ad.debug.a.f186830a;
                if (aVar2.b()) {
                    int c16 = aVar2.c();
                    if (u16 && c16 != 4) {
                        return 2;
                    }
                    return c16;
                }
            }
            if (z16) {
                motiveVideoBottomCardClickModel = this.f109080e.getGdtAd().getMotiveVideoEndCardClickModel();
            } else {
                motiveVideoBottomCardClickModel = this.f109080e.getGdtAd().getMotiveVideoBottomCardClickModel();
            }
            if (u16 && motiveVideoBottomCardClickModel != 4) {
                return 2;
            }
            return motiveVideoBottomCardClickModel;
        }
        return 1;
    }

    private GdtHandler.Params n(qq_ad_get.QQAdGetRsp.AdInfo adInfo, GdtMotiveVideoPageData gdtMotiveVideoPageData, Activity activity, boolean z16) {
        GdtHandler.Params params = new GdtHandler.Params();
        params.processId = gdtMotiveVideoPageData.processId;
        params.activity = new WeakReference<>(activity);
        params.f108486ad = new GdtAd(adInfo);
        params.reportForClick = true;
        params.appAutoDownload = z16;
        params.extra = new Bundle();
        String stringExtra = activity.getIntent().getStringExtra(LaunchParam.KEY_REF_ID);
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.i("GdtMvPictureElementController", 1, "getClickParam refId is empty");
            stringExtra = activity.getIntent().getStringExtra("big_brother_source_key");
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            params.extra.putString(LaunchParam.KEY_REF_ID, stringExtra);
        }
        return params;
    }

    private void p() {
        int dpToPx;
        GdtMvBottomAdCardView gdtMvBottomAdCardView = this.F;
        if (gdtMvBottomAdCardView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gdtMvBottomAdCardView.getLayoutParams();
        float f16 = 16.0f;
        float f17 = 12.0f;
        if (this.K) {
            dpToPx = ViewUtils.dpToPx(12.0f);
        } else {
            dpToPx = ViewUtils.dpToPx(16.0f) + this.N;
        }
        layoutParams.leftMargin = dpToPx;
        if (this.K) {
            f16 = 12.0f;
        }
        layoutParams.rightMargin = ViewUtils.dpToPx(f16);
        if (v()) {
            layoutParams.bottomMargin = ViewUtils.dpToPx(19.0f);
            return;
        }
        if (!this.K) {
            f17 = 10.0f;
        }
        layoutParams.bottomMargin = ViewUtils.dpToPx(f17);
    }

    private void q() {
        K();
    }

    private void r() {
        int i3;
        try {
            LiuHaiUtils.initLiuHaiProperty((Activity) this.f109079d);
            if (LiuHaiUtils.isLiuHaiUseValid()) {
                i3 = LiuHaiUtils.getNotchInScreenHeight((Activity) this.f109079d);
            } else {
                i3 = 0;
            }
            this.N = i3;
        } catch (Throwable th5) {
            QLog.e("GdtMvPictureElementController", 1, "getNotchInScreenHeight error:", th5);
        }
    }

    private void s() {
        View view = this.f109084m;
        if (view == null) {
            QLog.e("GdtMvPictureElementController", 1, "initViews fail: rootView is null");
            return;
        }
        this.C = (RelativeLayout) view.findViewById(R.id.vmj);
        this.D = (ImageView) this.f109084m.findViewById(R.id.vmk);
        this.E = this.f109084m.findViewById(R.id.sbi);
        this.I = (FrameLayout) this.f109084m.findViewById(R.id.sat);
        this.J = (FrameLayout) this.f109084m.findViewById(R.id.sbs);
        this.F = (GdtMvBottomAdCardView) this.f109084m.findViewById(R.id.sb9);
        this.G = (GdtMvBigBottomAdCardView) this.f109084m.findViewById(R.id.sb_);
        this.H = (GdtMvEndAdCardView) this.f109084m.findViewById(R.id.sbg);
        this.F.setAutoPlayAnimation(false);
        boolean u16 = u();
        this.F.initView(this.M, this.K, false, u16);
        this.G.initView(this.K, u16);
        this.H.initView(this.M, u16);
        r();
        c(this.f109080e);
        p();
        g();
    }

    private boolean u() {
        com.tencent.mobileqq.ad.debug.a aVar = com.tencent.mobileqq.ad.debug.a.f186830a;
        if (aVar.f()) {
            return aVar.h();
        }
        GdtMotiveVideoModel gdtMotiveVideoModel = this.f109080e;
        if (gdtMotiveVideoModel != null && gdtMotiveVideoModel.getGdtAd() != null && this.f109080e.getGdtAd().isSupportNoneButtonStyle()) {
            return true;
        }
        return false;
    }

    private boolean v() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2 = this.I;
        if ((frameLayout2 != null && frameLayout2.getVisibility() == 0) || ((frameLayout = this.J) != null && frameLayout.getVisibility() == 0)) {
            return true;
        }
        return false;
    }

    private GdtMvAdCardData z(GdtMotiveVideoModel gdtMotiveVideoModel) {
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

    public void B(int i3) {
        this.L = i3;
    }

    public void C(boolean z16) {
        this.K = z16;
        com.tencent.gdtad.basics.motivevideo.report.b bVar = this.f109083i;
        if (bVar != null) {
            bVar.j(z16);
        }
    }

    public void D(com.tencent.gdtad.basics.motivevideo.report.d dVar) {
        this.f109082h = dVar;
    }

    public void F() {
        L();
        View view = this.E;
        if (view != null) {
            view.setVisibility(8);
        }
        GdtMvEndAdCardView gdtMvEndAdCardView = this.H;
        if (gdtMvEndAdCardView != null) {
            gdtMvEndAdCardView.startAlphaAnimation();
            this.H.setVisibility(0);
            this.H.clearNoneButtonColor();
        }
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        ImageView imageView = this.D;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        GdtMvBottomAdCardView gdtMvBottomAdCardView = this.F;
        if (gdtMvBottomAdCardView != null) {
            gdtMvBottomAdCardView.setVisibility(8);
        }
        GdtMvBigBottomAdCardView gdtMvBigBottomAdCardView = this.G;
        if (gdtMvBigBottomAdCardView != null) {
            gdtMvBigBottomAdCardView.setVisibility(8);
        }
    }

    public synchronized void d() {
        if (this.G != null && this.C != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setAnimationListener(new a());
            this.G.startAnimation(alphaAnimation);
            this.C.startAnimation(alphaAnimation);
        }
    }

    public synchronized void e() {
        if (this.G == null) {
            return;
        }
        View view = this.E;
        if (view != null) {
            view.setVisibility(8);
        }
        o();
        this.G.setVisibility(0);
        this.G.onShow();
        G();
    }

    public synchronized void f() {
        GdtMvBigBottomAdCardView gdtMvBigBottomAdCardView = this.G;
        if (gdtMvBigBottomAdCardView != null) {
            gdtMvBigBottomAdCardView.startSweepLightAnimation();
        }
    }

    public synchronized void h() {
        GdtMvBottomAdCardView gdtMvBottomAdCardView = this.F;
        if (gdtMvBottomAdCardView != null) {
            gdtMvBottomAdCardView.onDisappear();
        }
    }

    public synchronized void i() {
        GdtMvBottomAdCardView gdtMvBottomAdCardView = this.F;
        if (gdtMvBottomAdCardView != null) {
            gdtMvBottomAdCardView.updateMvAdCardStyleWithAnimation();
        }
    }

    public void o() {
        FrameLayout frameLayout = this.I;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        FrameLayout frameLayout2 = this.J;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        w(this.f109080e, view.getId(), null);
        EventCollector.getInstance().onViewClicked(view);
    }

    public void t() {
        boolean z16 = true;
        if (this.f109080e.getGdtMotiveVideoPageData().screenOrientation != 1) {
            z16 = false;
        }
        this.K = z16;
        s();
        q();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(GdtMotiveVideoModel gdtMotiveVideoModel, int i3, String str) {
        String str2;
        if (gdtMotiveVideoModel == null) {
            return;
        }
        GdtMotiveVideoPageData gdtMotiveVideoPageData = gdtMotiveVideoModel.getGdtMotiveVideoPageData();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtMotiveVideoModel.getAdInfo();
        long A = this.f109081f.A();
        this.f109081f.B().setFinishType(2);
        if (this.P.contains(Integer.valueOf(i3))) {
            GdtLog.d("GdtMvPictureElementController", "[click ad btn] " + adInfo);
            com.tencent.gdtad.basics.motivevideo.b.f108898a.e(this.f109079d, gdtMotiveVideoModel, 0);
            Activity activity = this.f109081f.z().getActivity();
            if (adInfo != null && activity != null) {
                str2 = adInfo.report_info.click_url.get();
                adInfo.report_info.click_url.set(this.f109083i.f(str2, A, this.f109081f.y(), this.f109081f.N(), str));
                QLog.i("GdtMvPictureElementController", 1, "appAutoDownload:false");
                GdtHandler.Params n3 = n(adInfo, gdtMotiveVideoPageData, activity, false);
                int showCardStatus = GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus();
                if (showCardStatus == 2) {
                    n3.componentID = 48;
                } else if (showCardStatus == 1) {
                    n3.componentID = 47;
                }
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(n3);
                if (!TextUtils.isEmpty(str2) && adInfo != null) {
                    adInfo.report_info.click_url.set(str2);
                }
                if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() != 2) {
                    GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020015);
                } else if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() == 1) {
                    GdtADFlyingStreamingReportHelper.getInstance().reportADEvent(GdtADFlyingStreamingReportHelper.EVENT_CODE_1020014);
                }
                this.f109081f.d0(5);
            }
        }
        str2 = "";
        if (!TextUtils.isEmpty(str2)) {
            adInfo.report_info.click_url.set(str2);
        }
        if (GdtADFlyingStreamingReportHelper.getInstance().getShowCardStatus() != 2) {
        }
        this.f109081f.d0(5);
    }

    public void x() {
        k();
        com.tencent.gdtad.basics.motivevideo.report.b bVar = this.f109083i;
        if (bVar != null) {
            bVar.h();
        }
        GdtMvBigBottomAdCardView gdtMvBigBottomAdCardView = this.G;
        if (gdtMvBigBottomAdCardView != null) {
            gdtMvBigBottomAdCardView.clearAnimation();
            this.G.onDestroy();
        }
        GdtMvBottomAdCardView gdtMvBottomAdCardView = this.F;
        if (gdtMvBottomAdCardView != null) {
            gdtMvBottomAdCardView.clearAnimation();
            this.F.onDestroy();
        }
    }

    public void y() {
        com.tencent.gdtad.basics.motivevideo.report.b bVar = this.f109083i;
        if (bVar != null) {
            bVar.l(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (b.this.G != null) {
                b.this.G.setVisibility(8);
            }
            if (b.this.C != null) {
                b.this.C.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
