package com.tencent.biz.pubaccount.weishi.verticalvideo.gdt;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.card.GdtAdWSCardView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f82051a = ViewCompat.generateViewId();

    /* renamed from: b, reason: collision with root package name */
    public static final int f82052b = ViewCompat.generateViewId();

    public static void g(ViewGroup viewGroup) {
        GdtAdWSCountDownLayout gdtAdWSCountDownLayout;
        GdtLog.i("GdtAdWSUIUtil", "[resetComponentsInCardContainerWithAnimation]");
        if (viewGroup == null || (gdtAdWSCountDownLayout = (GdtAdWSCountDownLayout) viewGroup.findViewById(f82051a)) == null) {
            return;
        }
        gdtAdWSCountDownLayout.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f82058d;

        c(WeakReference weakReference) {
            this.f82058d = weakReference;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            View view = (View) this.f82058d.get();
            if (view == null) {
                return;
            }
            Drawable background = view.getBackground();
            if (background instanceof GradientDrawable) {
                ((GradientDrawable) background).setColor(intValue);
            } else {
                view.setBackgroundColor(intValue);
            }
        }
    }

    public static boolean c(GdtAd gdtAd) {
        return gdtAd != null && gdtAd.getCountdownTimeSecs() > 0;
    }

    public static boolean d(GdtAd gdtAd) {
        return (gdtAd == null || ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).getIndustryLabels(gdtAd.info) == null) ? false : true;
    }

    public static boolean e(GdtAd gdtAd) {
        return (gdtAd == null || TextUtils.isEmpty(gdtAd.getMarketPendantImageUrl())) ? false : true;
    }

    public static void h(WeakReference<View> weakReference, float f16, float f17, int i3) {
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            return;
        }
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(f16, f17);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setAnimationListener(new AnimationAnimationListenerC0834b(weakReference, i3));
        view.startAnimation(alphaAnimation);
    }

    public static void i(WeakReference<ViewGroup> weakReference, float f16, boolean z16) {
        ViewGroup viewGroup = weakReference != null ? weakReference.get() : null;
        if (viewGroup == null || f16 < 0.0f) {
            return;
        }
        viewGroup.clearAnimation();
        TranslateAnimation translateAnimation = new TranslateAnimation(z16 ? 0.0f : -f16, z16 ? -f16 : 0.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(300L);
        translateAnimation.setAnimationListener(new a(weakReference, z16));
        viewGroup.startAnimation(translateAnimation);
    }

    public static void j(WeakReference<View> weakReference, int i3, int i16) {
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            return;
        }
        view.clearAnimation();
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i3), Integer.valueOf(i16));
        ofObject.addUpdateListener(new c(weakReference));
        ofObject.setDuration(300L);
        ofObject.start();
    }

    private static void a(LinearLayout linearLayout, GdtAd gdtAd, WeakReference<View.OnClickListener> weakReference) {
        Context context;
        int countdownTimeSecs;
        if (linearLayout == null || (context = linearLayout.getContext()) == null || (countdownTimeSecs = gdtAd.getCountdownTimeSecs()) <= 0) {
            return;
        }
        GdtAdWSCountDownLayout gdtAdWSCountDownLayout = new GdtAdWSCountDownLayout(context);
        gdtAdWSCountDownLayout.n(countdownTimeSecs);
        gdtAdWSCountDownLayout.setId(f82051a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = AdUIUtils.dp2px(20.0f, context.getResources());
        gdtAdWSCountDownLayout.setLayoutParams(layoutParams);
        if (weakReference != null) {
            gdtAdWSCountDownLayout.setOnClickListener(weakReference.get());
        }
        linearLayout.addView(gdtAdWSCountDownLayout);
    }

    private static void b(LinearLayout linearLayout, GdtAd gdtAd, WeakReference<View.OnClickListener> weakReference) {
        Context context;
        if (linearLayout == null || (context = linearLayout.getContext()) == null) {
            return;
        }
        String marketPendantImageUrl = gdtAd.getMarketPendantImageUrl();
        if (TextUtils.isEmpty(marketPendantImageUrl)) {
            return;
        }
        URLImageView uRLImageView = new URLImageView(context);
        uRLImageView.setImageDrawable(URLDrawable.getDrawable(marketPendantImageUrl, URLDrawable.URLDrawableOptions.obtain()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(AdUIUtils.dp2px(120.0f, context.getResources()), AdUIUtils.dp2px(90.0f, context.getResources()));
        layoutParams.bottomMargin = AdUIUtils.dp2px(20.0f, context.getResources());
        uRLImageView.setLayoutParams(layoutParams);
        uRLImageView.setId(f82052b);
        if (weakReference != null) {
            uRLImageView.setOnClickListener(weakReference.get());
        }
        linearLayout.addView(uRLImageView);
    }

    public static ViewGroup f(Context context, GdtAd gdtAd, String str, w10.a aVar, WeakReference<View.OnClickListener> weakReference) {
        if (context == null || gdtAd == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        if (c(gdtAd)) {
            a(linearLayout, gdtAd, weakReference);
        } else if (e(gdtAd)) {
            b(linearLayout, gdtAd, weakReference);
        }
        GdtAdWSCardView.b bVar = new GdtAdWSCardView.b();
        bVar.f82066a = gdtAd.getAdvertiser_corporate_logo();
        bVar.f82069d = str;
        bVar.f82070e = aVar != null;
        bVar.f82071f = aVar != null ? aVar.getShakeIconUrl() : null;
        bVar.f82068c = gdtAd.getText();
        bVar.f82072g = ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).getIndustryLabels(gdtAd.info);
        bVar.f82067b = gdtAd.getAdvertiser_corporate_image_name();
        bVar.f82073h = weakReference;
        linearLayout.addView(new GdtAdWSCardView(context, bVar));
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f82053d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f82054e;

        a(WeakReference weakReference, boolean z16) {
            this.f82053d = weakReference;
            this.f82054e = z16;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ViewGroup viewGroup = (ViewGroup) this.f82053d.get();
            if (viewGroup == null) {
                return;
            }
            viewGroup.setVisibility(this.f82054e ? 8 : 0);
            if (this.f82054e) {
                b.g(viewGroup);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            ViewGroup viewGroup = (ViewGroup) this.f82053d.get();
            if (viewGroup == null) {
                return;
            }
            viewGroup.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class AnimationAnimationListenerC0834b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        boolean f82055d = false;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeakReference f82056e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f82057f;

        AnimationAnimationListenerC0834b(WeakReference weakReference, int i3) {
            this.f82056e = weakReference;
            this.f82057f = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = (View) this.f82056e.get();
            if (view == null) {
                return;
            }
            view.setVisibility(this.f82057f);
            this.f82055d = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            View view = (View) this.f82056e.get();
            if (view == null || this.f82055d) {
                return;
            }
            view.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }
}
