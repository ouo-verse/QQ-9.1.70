package com.tencent.luggage.wxa.g4;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.z3.o;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends RelativeLayout implements b {

    /* renamed from: l, reason: collision with root package name */
    public static final C6228a f126400l = new C6228a(null);

    /* renamed from: a, reason: collision with root package name */
    public TextView f126401a;

    /* renamed from: b, reason: collision with root package name */
    public View f126402b;

    /* renamed from: c, reason: collision with root package name */
    public View f126403c;

    /* renamed from: d, reason: collision with root package name */
    public Rect f126404d;

    /* renamed from: e, reason: collision with root package name */
    public Rect f126405e;

    /* renamed from: f, reason: collision with root package name */
    public o f126406f;

    /* renamed from: g, reason: collision with root package name */
    public int f126407g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f126408h;

    /* renamed from: i, reason: collision with root package name */
    public int f126409i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f126410j;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.b4.e f126411k;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g4.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6228a {
        public C6228a() {
        }

        public /* synthetic */ C6228a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        a();
    }

    public void a(View view) {
    }

    public abstract void a(Object obj, e eVar);

    public final boolean b() {
        return this.f126410j;
    }

    public boolean c() {
        return false;
    }

    public void f() {
        w.d("Luggage.BaseScanMaskView", "alvinluo onViewReady hashCode: %d", Integer.valueOf(hashCode()));
        this.f126410j = false;
    }

    public final boolean getCurrentNetworkAvailable() {
        return this.f126408h;
    }

    @Nullable
    public final View getFlashSwitcher() {
        return this.f126402b;
    }

    @Nullable
    public final com.tencent.luggage.wxa.b4.e getFrameData() {
        return this.f126411k;
    }

    public final int getMBottomExtraHeight() {
        return this.f126409i;
    }

    @Nullable
    public final View getMGalleryButton() {
        return this.f126403c;
    }

    @Nullable
    public final Rect getMPreviewRect() {
        return this.f126404d;
    }

    @Nullable
    public final Rect getMScanRect() {
        return this.f126405e;
    }

    public final int getMScanSource() {
        return this.f126407g;
    }

    @Nullable
    public final o getScanCamera() {
        return this.f126406f;
    }

    @Nullable
    public final TextView getScanTips() {
        return this.f126401a;
    }

    @Nullable
    public View getTargetSuccessMarkView() {
        return null;
    }

    public void setBottomExtraHeight(int i3) {
        this.f126409i = i3;
    }

    public final void setCurrentNetworkAvailable(boolean z16) {
        this.f126408h = z16;
    }

    public void setDecodeSuccessFrameData(@Nullable com.tencent.luggage.wxa.b4.e eVar) {
        this.f126411k = eVar;
    }

    public final void setFlashSwitcher(@Nullable View view) {
        this.f126402b = view;
    }

    public final void setFrameData(@Nullable com.tencent.luggage.wxa.b4.e eVar) {
        this.f126411k = eVar;
    }

    public final void setMBottomExtraHeight(int i3) {
        this.f126409i = i3;
    }

    public final void setMGalleryButton(@Nullable View view) {
        this.f126403c = view;
    }

    public final void setMPreviewRect(@Nullable Rect rect) {
        this.f126404d = rect;
    }

    public final void setMScanRect(@Nullable Rect rect) {
        this.f126405e = rect;
    }

    public final void setMScanSource(int i3) {
        this.f126407g = i3;
    }

    public final void setPreviewRect(@Nullable Rect rect) {
        this.f126404d = rect;
        postInvalidate();
    }

    public final void setScanCamera(@Nullable o oVar) {
        this.f126406f = oVar;
    }

    public final void setScanRect(@Nullable Rect rect) {
        this.f126405e = rect;
    }

    public void setScanSource(int i3) {
        this.f126407g = i3;
    }

    public final void setScanTips(@Nullable TextView textView) {
        this.f126401a = textView;
    }

    public final void setViewDestroy(boolean z16) {
        this.f126410j = z16;
    }

    public final void a() {
        w.d("Luggage.BaseScanMaskView", "alvinluo init networkAvailable: %b", Boolean.valueOf(this.f126408h));
    }

    public void b(View flashSwitcher) {
        Intrinsics.checkNotNullParameter(flashSwitcher, "flashSwitcher");
        w.e("Luggage.BaseScanMaskView", "alvinluo attachFlashSwitcherView");
        this.f126402b = flashSwitcher;
    }

    public void c(View galleryButton) {
        Intrinsics.checkNotNullParameter(galleryButton, "galleryButton");
        this.f126403c = galleryButton;
        if (galleryButton == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = galleryButton.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = null;
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.luggage.wxa.kn.a.a(getContext(), 32) + this.f126409i;
        }
        galleryButton.setLayoutParams(layoutParams);
    }

    public void a(TextView tipsView) {
        Intrinsics.checkNotNullParameter(tipsView, "tipsView");
        this.f126401a = tipsView;
        if (tipsView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = tipsView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = null;
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.luggage.wxa.kn.a.a(getContext(), 120) + this.f126409i;
        }
        tipsView.setLayoutParams(layoutParams);
    }

    public void b(boolean z16) {
        w.d("Luggage.BaseScanMaskView", "alvinluo onPreviewReady hashCode: %d, isSwitchTab: %b", Integer.valueOf(hashCode()), Boolean.valueOf(z16));
    }

    public void a(o oVar) {
        this.f126406f = oVar;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        w.a("Luggage.BaseScanMaskView", "alvinluo onViewDestroy hashCode: %d", Integer.valueOf(hashCode()));
        this.f126410j = true;
    }

    public final void a(View view, float f16, float f17, Animator.AnimatorListener animatorListener) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator updateListener;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator listener2;
        ViewPropertyAnimator updateListener2;
        w.g("Luggage.BaseScanMaskView", "alvinluo animateAlpha from: %f, to: %f, hashCode: %d", Float.valueOf(f16), Float.valueOf(f17), Integer.valueOf(hashCode()));
        if (view != null && (animate2 = view.animate()) != null && (listener2 = animate2.setListener(null)) != null && (updateListener2 = listener2.setUpdateListener(null)) != null) {
            updateListener2.cancel();
        }
        if (view != null) {
            view.setAlpha(f16);
        }
        if (view == null || (animate = view.animate()) == null || (alpha = animate.alpha(f17)) == null || (duration = alpha.setDuration(200L)) == null || (interpolator = duration.setInterpolator(new LinearInterpolator())) == null || (updateListener = interpolator.setUpdateListener(null)) == null || (listener = updateListener.setListener(animatorListener)) == null) {
            return;
        }
        listener.start();
    }

    public void a(boolean z16) {
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

    public void d() {
    }

    public void e() {
    }

    public void release() {
    }
}
