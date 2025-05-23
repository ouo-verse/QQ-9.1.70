package com.tencent.luggage.wxa.e4;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.scanner.scanner.ui.widget.ScannerFlashSwitcher;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.R;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends RelativeLayout {

    /* renamed from: l, reason: collision with root package name */
    public static final a f124518l = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public TextView f124519a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f124520b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f124521c;

    /* renamed from: d, reason: collision with root package name */
    public ScannerFlashSwitcher f124522d;

    /* renamed from: e, reason: collision with root package name */
    public View f124523e;

    /* renamed from: f, reason: collision with root package name */
    public View.OnClickListener f124524f;

    /* renamed from: g, reason: collision with root package name */
    public View.OnClickListener f124525g;

    /* renamed from: h, reason: collision with root package name */
    public Timer f124526h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f124527i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f124528j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f124529k;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.e4.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6155b implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f124531b;

        public C6155b(boolean z16) {
            this.f124531b = z16;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            b.this.f(this.f124531b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            b.this.f(this.f124531b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            View.OnClickListener onClickListener = b.this.f124524f;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            View.OnClickListener onClickListener = b.this.f124525g;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends TimerTask {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f124535a;

            public a(b bVar) {
                this.f124535a = bVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (!this.f124535a.f124527i) {
                    this.f124535a.g(false);
                }
            }
        }

        public e() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b bVar = b.this;
            bVar.post(new a(bVar));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f124536a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f124537b;

        public f(boolean z16, b bVar) {
            this.f124536a = z16;
            this.f124537b = bVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            w.g("Luggage.ScanSharedMaskView", "alvinluo startTitleAnimation onAnimationCancel show: %b", Boolean.valueOf(this.f124536a));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            int i3 = 0;
            w.g("Luggage.ScanSharedMaskView", "alvinluo startTitleAnimation onAnimationEnd show: %b, isFlashShow: %b", Boolean.valueOf(this.f124536a), Boolean.valueOf(this.f124537b.f124528j));
            TextView textView = this.f124537b.f124519a;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
                textView = null;
            }
            if (!this.f124536a) {
                i3 = 8;
            }
            textView.setVisibility(i3);
            if (this.f124536a) {
                TextView textView3 = this.f124537b.f124519a;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
                } else {
                    textView2 = textView3;
                }
                textView2.invalidate();
                this.f124537b.c();
                return;
            }
            if (!this.f124537b.f124528j) {
                this.f124537b.b(true);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void g(boolean z16) {
        float f16;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        w.d("Luggage.ScanSharedMaskView", "alvinluo startTitleAnimation show: %b", Boolean.valueOf(z16));
        TextView textView = this.f124519a;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
            textView = null;
        }
        float f17 = 1.0f;
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        textView.setAlpha(f16);
        TextView textView3 = this.f124519a;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
            textView3 = null;
        }
        textView3.setVisibility(0);
        if (!z16) {
            f17 = 0.0f;
        }
        TextView textView4 = this.f124519a;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
            textView4 = null;
        }
        textView4.setShadowLayer(10.0f, 0.0f, 0.0f, getResources().getColor(R.color.ai5));
        TextView textView5 = this.f124519a;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
        } else {
            textView2 = textView5;
        }
        ViewPropertyAnimator animate = textView2.animate();
        if (animate != null && (alpha = animate.alpha(f17)) != null && (duration = alpha.setDuration(200L)) != null) {
            duration.setListener(new f(z16, this));
        }
    }

    @NotNull
    public ScannerFlashSwitcher getFlashSwitcherView() {
        ScannerFlashSwitcher scannerFlashSwitcher = this.f124522d;
        if (scannerFlashSwitcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flashSwitcher");
            return null;
        }
        return scannerFlashSwitcher;
    }

    @NotNull
    public View getGalleryButton() {
        View view = this.f124523e;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
            return null;
        }
        return view;
    }

    @NotNull
    public TextView getScanTipsView() {
        TextView textView = this.f124520b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTips");
            return null;
        }
        return textView;
    }

    @NotNull
    public TextView getScanTitleView() {
        TextView textView = this.f124519a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
            return null;
        }
        return textView;
    }

    public void setFlashStatus(boolean z16) {
        w.a("Luggage.ScanSharedMaskView", "alvinluo setFlashStatus show: %b", Boolean.valueOf(z16));
        this.f124528j = z16;
    }

    public void setOnFlashSwitcherClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.f124525g = onClickListener;
    }

    public void setOnGalleryClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.f124524f = onClickListener;
        View view = this.f124523e;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
            view = null;
        }
        view.setOnClickListener(this.f124524f);
    }

    public void setScanTips(@Nullable String str) {
        TextView textView = this.f124520b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTips");
            textView = null;
        }
        textView.setText(str);
    }

    public void setScanTitle(@Nullable String str) {
        TextView textView = this.f124519a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
            textView = null;
        }
        textView.setText(str);
    }

    public final void setShowTitle(boolean z16) {
        this.f124529k = z16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void d(boolean z16) {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator updateListener;
        ViewPropertyAnimator duration;
        if (z16) {
            return;
        }
        View view = this.f124523e;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
            view = null;
        }
        if (view.getVisibility() == 0) {
            View view2 = this.f124523e;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
                view2 = null;
            }
            ViewPropertyAnimator animate = view2.animate();
            if (animate == null || (alpha = animate.alpha(1.0f)) == null || (listener = alpha.setListener(null)) == null || (interpolator = listener.setInterpolator(new LinearInterpolator())) == null || (updateListener = interpolator.setUpdateListener(null)) == null || (duration = updateListener.setDuration(200L)) == null) {
                return;
            }
            duration.start();
        }
    }

    public void e() {
        w.d("Luggage.ScanSharedMaskView", "alvinluo onViewReady hashCode: %d", Integer.valueOf(hashCode()));
        TextView textView = null;
        if (!this.f124529k) {
            f(!this.f124528j);
            TextView textView2 = this.f124519a;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
        } else {
            f(false);
            TextView textView3 = this.f124519a;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
                textView3 = null;
            }
            if (textView3.getVisibility() != 0) {
                TextView textView4 = this.f124519a;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
                    textView4 = null;
                }
                textView4.setVisibility(8);
                TextView textView5 = this.f124519a;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
                } else {
                    textView = textView5;
                }
                textView.setAlpha(1.0f);
                a();
                g(true);
            } else {
                TextView textView6 = this.f124519a;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
                } else {
                    textView = textView6;
                }
                textView.setAlpha(1.0f);
                a();
                c();
            }
        }
        f(true);
        e(true);
    }

    public final void f(boolean z16) {
        TextView textView = this.f124520b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTips");
            textView = null;
        }
        textView.setVisibility(z16 ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f124529k = true;
        a(context);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.ffl, this);
        View findViewById = inflate.findViewById(R.id.f79644_b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.scan_title)");
        this.f124519a = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f79634_a);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.scan_tip_tv)");
        this.f124520b = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.udj);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.dark_corner_mask)");
        this.f124521c = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f79654_c);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.scanner_flash_switcher)");
        this.f124522d = (ScannerFlashSwitcher) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f82154g4);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.select_from_gallery)");
        this.f124523e = findViewById5;
        ScannerFlashSwitcher scannerFlashSwitcher = null;
        if (findViewById5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
            findViewById5 = null;
        }
        findViewById5.setOnClickListener(new c());
        ScannerFlashSwitcher scannerFlashSwitcher2 = this.f124522d;
        if (scannerFlashSwitcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flashSwitcher");
        } else {
            scannerFlashSwitcher = scannerFlashSwitcher2;
        }
        scannerFlashSwitcher.setOnClickListener(new d());
    }

    public final void b() {
        this.f124527i = true;
        Timer timer = this.f124526h;
        if (timer != null) {
            timer.cancel();
        }
    }

    public final void c() {
        w.e("Luggage.ScanSharedMaskView", "alvinluo initTitleTimer");
        b();
        BaseTimer baseTimer = new BaseTimer();
        this.f124526h = baseTimer;
        baseTimer.schedule(new e(), 2000L);
        this.f124527i = false;
    }

    public void f() {
        w.a("Luggage.ScanSharedMaskView", "alvinluo release hashCode: %d", Integer.valueOf(hashCode()));
        b();
    }

    public final void b(boolean z16) {
        ViewPropertyAnimator duration;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator listener2;
        w.a("Luggage.ScanSharedMaskView", "alvinluo animateScanTips show: %b", Boolean.valueOf(z16));
        if (z16) {
            return;
        }
        TextView textView = this.f124520b;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTips");
            textView = null;
        }
        if (textView.getVisibility() == 0 && z16) {
            return;
        }
        TextView textView3 = this.f124520b;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTips");
            textView3 = null;
        }
        if (textView3.getVisibility() == 0 || z16) {
            TextView textView4 = this.f124520b;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanTips");
                textView4 = null;
            }
            ViewPropertyAnimator animate = textView4.animate();
            if (animate != null && (listener2 = animate.setListener(null)) != null) {
                listener2.cancel();
            }
            TextView textView5 = this.f124520b;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanTips");
                textView5 = null;
            }
            textView5.setAlpha(z16 ? 0.0f : 1.0f);
            f(true);
            TextView textView6 = this.f124520b;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanTips");
            } else {
                textView2 = textView6;
            }
            ViewPropertyAnimator animate2 = textView2.animate();
            if (animate2 != null) {
                ViewPropertyAnimator alpha = animate2.alpha(z16 ? 1.0f : 0.0f);
                if (alpha == null || (duration = alpha.setDuration(200L)) == null || (listener = duration.setListener(new C6155b(z16))) == null) {
                    return;
                }
                listener.start();
            }
        }
    }

    public void d() {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator updateListener;
        ViewPropertyAnimator duration;
        w.e("Luggage.ScanSharedMaskView", "alvinluo onScanSuccess");
        View view = this.f124523e;
        ScannerFlashSwitcher scannerFlashSwitcher = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
            view = null;
        }
        ViewPropertyAnimator animate = view.animate();
        if (animate != null && (alpha = animate.alpha(0.0f)) != null && (listener = alpha.setListener(null)) != null && (interpolator = listener.setInterpolator(new LinearInterpolator())) != null && (updateListener = interpolator.setUpdateListener(null)) != null && (duration = updateListener.setDuration(200L)) != null) {
            duration.start();
        }
        a();
        TextView textView = this.f124519a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
            textView = null;
        }
        textView.setVisibility(8);
        this.f124528j = false;
        ScannerFlashSwitcher scannerFlashSwitcher2 = this.f124522d;
        if (scannerFlashSwitcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flashSwitcher");
        } else {
            scannerFlashSwitcher = scannerFlashSwitcher2;
        }
        scannerFlashSwitcher.setVisibility(8);
    }

    public void c(boolean z16) {
        w.d("Luggage.ScanSharedMaskView", "alvinluo onFlashStatusChanged show: %b", Boolean.valueOf(z16));
        if (this.f124528j != z16) {
            this.f124528j = z16;
            b(!z16);
        }
    }

    public final void a() {
        ViewPropertyAnimator listener;
        w.d("Luggage.ScanSharedMaskView", "alvinluo cancelTitleAnimation");
        TextView textView = this.f124519a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanTitle");
            textView = null;
        }
        ViewPropertyAnimator animate = textView.animate();
        if (animate != null && (listener = animate.setListener(null)) != null) {
            listener.cancel();
        }
        b();
    }

    public void a(boolean z16) {
        w.g("Luggage.ScanSharedMaskView", "alvinluo animateShow show: %b, alpha: %f", Boolean.valueOf(z16), Float.valueOf(getAlpha()));
        if (z16) {
            if (getAlpha() == 0.0f) {
                a(this, 0.0f, 1.0f, null);
            }
        } else {
            if (getAlpha() == 1.0f) {
                a(this, 1.0f, 0.0f, null);
            }
        }
    }

    public final void e(boolean z16) {
        View view = this.f124523e;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("galleryButton");
            view = null;
        }
        view.setVisibility(z16 ? 0 : 8);
    }

    public final void a(View view, float f16, float f17, Animator.AnimatorListener animatorListener) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator listener2;
        if (view != null && (animate2 = view.animate()) != null && (listener2 = animate2.setListener(null)) != null) {
            listener2.cancel();
        }
        if (view != null) {
            view.setAlpha(f16);
        }
        if (view == null || (animate = view.animate()) == null || (alpha = animate.alpha(f17)) == null || (duration = alpha.setDuration(200L)) == null || (interpolator = duration.setInterpolator(new LinearInterpolator())) == null || (listener = interpolator.setListener(animatorListener)) == null) {
            return;
        }
        listener.start();
    }
}
