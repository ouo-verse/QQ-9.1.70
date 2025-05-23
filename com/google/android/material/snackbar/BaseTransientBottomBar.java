package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ViewGroup f34173a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f34174b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    protected final SnackbarBaseLayout f34175c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.snackbar.a f34176d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34177e;

    /* renamed from: f, reason: collision with root package name */
    @RequiresApi(29)
    private final Runnable f34178f;

    /* renamed from: g, reason: collision with root package name */
    private int f34179g;

    /* renamed from: h, reason: collision with root package name */
    private int f34180h;

    /* renamed from: i, reason: collision with root package name */
    private int f34181i;

    /* renamed from: j, reason: collision with root package name */
    private int f34182j;

    /* renamed from: k, reason: collision with root package name */
    private int f34183k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f34184l;

    /* renamed from: m, reason: collision with root package name */
    private List<BaseCallback<B>> f34185m;

    /* renamed from: n, reason: collision with root package name */
    private Behavior f34186n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private final AccessibilityManager f34187o;

    /* renamed from: p, reason: collision with root package name */
    @NonNull
    b.InterfaceC0238b f34188p;

    /* renamed from: r, reason: collision with root package name */
    private static final boolean f34170r = false;

    /* renamed from: s, reason: collision with root package name */
    private static final int[] f34171s = {R.attr.f156232ba3};

    /* renamed from: t, reason: collision with root package name */
    private static final String f34172t = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: q, reason: collision with root package name */
    @NonNull
    static final Handler f34169q = new Handler(Looper.getMainLooper(), new h());

    /* compiled from: P */
    /* renamed from: com.google.android.material.snackbar.BaseTransientBottomBar$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ BaseTransientBottomBar this$0;

        @Override // java.lang.Runnable
        public void run() {
            int s16;
            BaseTransientBottomBar baseTransientBottomBar = this.this$0;
            if (baseTransientBottomBar.f34175c == null || baseTransientBottomBar.f34174b == null || (s16 = (this.this$0.s() - this.this$0.u()) + ((int) this.this$0.f34175c.getTranslationY())) >= this.this$0.f34182j) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.this$0.f34175c.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.f34172t, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += this.this$0.f34182j - s16;
            this.this$0.f34175c.requestLayout();
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface AnimationMode {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: q, reason: collision with root package name */
        @NonNull
        private final k f34189q = new k(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void m(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f34189q.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean b(View view) {
            return this.f34189q.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.f34189q.b(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    /* compiled from: P */
    @IntRange(from = -2)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface Duration {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public static class SnackbarBaseLayout extends FrameLayout {
        private static final View.OnTouchListener G = new a();
        private ColorStateList C;
        private PorterDuff.Mode D;

        @Nullable
        private Rect E;
        private boolean F;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private BaseTransientBottomBar<?> f34190d;

        /* renamed from: e, reason: collision with root package name */
        private int f34191e;

        /* renamed from: f, reason: collision with root package name */
        private final float f34192f;

        /* renamed from: h, reason: collision with root package name */
        private final float f34193h;

        /* renamed from: i, reason: collision with root package name */
        private final int f34194i;

        /* renamed from: m, reason: collision with root package name */
        private final int f34195m;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public SnackbarBaseLayout(@NonNull Context context) {
            this(context, null);
        }

        @NonNull
        private Drawable c() {
            float dimension = getResources().getDimension(R.dimen.cvs);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(z0.a.i(this, R.attr.a8g, R.attr.f155473a82, e()));
            if (this.C != null) {
                Drawable wrap = DrawableCompat.wrap(gradientDrawable);
                DrawableCompat.setTintList(wrap, this.C);
                return wrap;
            }
            return DrawableCompat.wrap(gradientDrawable);
        }

        private void f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.E = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }

        void b(ViewGroup viewGroup) {
            this.F = true;
            viewGroup.addView(this);
            this.F = false;
        }

        int d() {
            return this.f34191e;
        }

        float e() {
            return this.f34192f;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f34190d;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.y();
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f34190d;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.z();
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
            super.onLayout(z16, i3, i16, i17, i18);
            BaseTransientBottomBar<?> baseTransientBottomBar = this.f34190d;
            if (baseTransientBottomBar != null) {
                baseTransientBottomBar.A();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i3, int i16) {
            super.onMeasure(i3, i16);
            if (this.f34194i > 0) {
                int measuredWidth = getMeasuredWidth();
                int i17 = this.f34194i;
                if (measuredWidth > i17) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), i16);
                }
            }
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.C != null) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.C);
                DrawableCompat.setTintMode(drawable, this.D);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.C = colorStateList;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(wrap, colorStateList);
                DrawableCompat.setTintMode(wrap, this.D);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.D = mode;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(wrap, mode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        @Override // android.view.View
        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
            if (!this.F && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                f((ViewGroup.MarginLayoutParams) layoutParams);
                BaseTransientBottomBar<?> baseTransientBottomBar = this.f34190d;
                if (baseTransientBottomBar != null) {
                    baseTransientBottomBar.N();
                }
            }
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            View.OnTouchListener onTouchListener;
            if (onClickListener != null) {
                onTouchListener = null;
            } else {
                onTouchListener = G;
            }
            setOnTouchListener(onTouchListener);
            super.setOnClickListener(onClickListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public SnackbarBaseLayout(@NonNull Context context, AttributeSet attributeSet) {
            super(k1.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, w0.a.f443841c8);
            if (obtainStyledAttributes.hasValue(w0.a.f443923j8)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(r1, 0));
            }
            this.f34191e = obtainStyledAttributes.getInt(w0.a.f443877f8, 0);
            this.f34192f = obtainStyledAttributes.getFloat(w0.a.f443889g8, 1.0f);
            setBackgroundTintList(g1.c.a(context2, obtainStyledAttributes, w0.a.f443901h8));
            setBackgroundTintMode(ViewUtils.j(obtainStyledAttributes.getInt(w0.a.f443912i8, -1), PorterDuff.Mode.SRC_IN));
            this.f34193h = obtainStyledAttributes.getFloat(w0.a.f443865e8, 1.0f);
            this.f34194i = obtainStyledAttributes.getDimensionPixelSize(w0.a.f443853d8, -1);
            this.f34195m = obtainStyledAttributes.getDimensionPixelSize(w0.a.f443934k8, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(G);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f34196d;

        a(int i3) {
            this.f34196d = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.B(this.f34196d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f34175c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f34175c.setScaleX(floatValue);
            BaseTransientBottomBar.this.f34175c.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.C();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f34176d.b(70, 180);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private int f34201d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f34202e;

        e(int i3) {
            this.f34202e = i3;
            this.f34201d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f34170r) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f34175c, intValue - this.f34201d);
            } else {
                BaseTransientBottomBar.this.f34175c.setTranslationY(intValue);
            }
            this.f34201d = intValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f34204d;

        f(int i3) {
            this.f34204d = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.B(this.f34204d);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f34176d.a(0, 180);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private int f34206d = 0;

        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f34170r) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.f34175c, intValue - this.f34206d);
            } else {
                BaseTransientBottomBar.this.f34175c.setTranslationY(intValue);
            }
            this.f34206d = intValue;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class h implements Handler.Callback {
        h() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    return false;
                }
                ((BaseTransientBottomBar) message.obj).v(message.arg1);
                return true;
            }
            ((BaseTransientBottomBar) message.obj).H();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class i implements SwipeDismissBehavior.c {
        i() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(int i3) {
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2) {
                    com.google.android.material.snackbar.b.c().j(BaseTransientBottomBar.this.f34188p);
                    return;
                }
                return;
            }
            com.google.android.material.snackbar.b.c().k(BaseTransientBottomBar.this.f34188p);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(@NonNull View view) {
            if (view.getParent() != null) {
                view.setVisibility(8);
            }
            BaseTransientBottomBar.this.n(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.C();
        }
    }

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        private b.InterfaceC0238b f34210a;

        public k(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.i(0.1f);
            swipeDismissBehavior.g(0.6f);
            swipeDismissBehavior.j(0);
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }

        public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    com.google.android.material.snackbar.b.c().k(this.f34210a);
                    return;
                }
                return;
            }
            if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                com.google.android.material.snackbar.b.c().j(this.f34210a);
            }
        }

        public void c(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f34210a = baseTransientBottomBar.f34188p;
        }
    }

    private void D() {
        this.f34183k = m();
        N();
    }

    private void E(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.f34186n;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = q();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).m(this);
        }
        swipeDismissBehavior.h(new i());
        layoutParams.setBehavior(swipeDismissBehavior);
        if (p() == null) {
            layoutParams.insetEdge = 80;
        }
    }

    private boolean G() {
        if (this.f34182j > 0 && !this.f34177e && x()) {
            return true;
        }
        return false;
    }

    private void I() {
        if (F()) {
            k();
            return;
        }
        if (this.f34175c.getParent() != null) {
            this.f34175c.setVisibility(0);
        }
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        ValueAnimator o16 = o(0.0f, 1.0f);
        ValueAnimator r16 = r(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(o16, r16);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new j());
        animatorSet.start();
    }

    private void K(int i3) {
        ValueAnimator o16 = o(1.0f, 0.0f);
        o16.setDuration(75L);
        o16.addListener(new a(i3));
        o16.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        int t16 = t();
        if (f34170r) {
            ViewCompat.offsetTopAndBottom(this.f34175c, t16);
        } else {
            this.f34175c.setTranslationY(t16);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(t16, 0);
        valueAnimator.setInterpolator(x0.a.f446811b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new d());
        valueAnimator.addUpdateListener(new e(t16));
        valueAnimator.start();
    }

    private void M(int i3) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, t());
        valueAnimator.setInterpolator(x0.a.f446811b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new f(i3));
        valueAnimator.addUpdateListener(new g());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        int i3;
        ViewGroup.LayoutParams layoutParams = this.f34175c.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && this.f34175c.E != null) {
            if (this.f34175c.getParent() == null) {
                return;
            }
            if (p() != null) {
                i3 = this.f34183k;
            } else {
                i3 = this.f34179g;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = this.f34175c.E.bottom + i3;
            marginLayoutParams.leftMargin = this.f34175c.E.left + this.f34180h;
            marginLayoutParams.rightMargin = this.f34175c.E.right + this.f34181i;
            marginLayoutParams.topMargin = this.f34175c.E.top;
            this.f34175c.requestLayout();
            if (Build.VERSION.SDK_INT >= 29 && G()) {
                this.f34175c.removeCallbacks(this.f34178f);
                this.f34175c.post(this.f34178f);
                return;
            }
            return;
        }
        Log.w(f34172t, "Unable to update margins because layout params are not MarginLayoutParams");
    }

    private void l(int i3) {
        if (this.f34175c.d() == 1) {
            K(i3);
        } else {
            M(i3);
        }
    }

    private int m() {
        if (p() == null) {
            return 0;
        }
        int[] iArr = new int[2];
        p().getLocationOnScreen(iArr);
        int i3 = iArr[1];
        int[] iArr2 = new int[2];
        this.f34173a.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f34173a.getHeight()) - i3;
    }

    private ValueAnimator o(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(x0.a.f446810a);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    private ValueAnimator r(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(x0.a.f446813d);
        ofFloat.addUpdateListener(new c());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(17)
    public int s() {
        WindowManager windowManager = (WindowManager) this.f34174b.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int t() {
        int height = this.f34175c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f34175c.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        }
        return height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u() {
        int[] iArr = new int[2];
        this.f34175c.getLocationOnScreen(iArr);
        return iArr[1] + this.f34175c.getHeight();
    }

    private boolean x() {
        ViewGroup.LayoutParams layoutParams = this.f34175c.getLayoutParams();
        if ((layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior)) {
            return true;
        }
        return false;
    }

    void A() {
        if (this.f34184l) {
            I();
            this.f34184l = false;
        }
    }

    void B(int i3) {
        com.google.android.material.snackbar.b.c().h(this.f34188p);
        List<BaseCallback<B>> list = this.f34185m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f34185m.get(size).a(this, i3);
            }
        }
        ViewParent parent = this.f34175c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f34175c);
        }
    }

    void C() {
        com.google.android.material.snackbar.b.c().i(this.f34188p);
        List<BaseCallback<B>> list = this.f34185m;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f34185m.get(size).b(this);
            }
        }
    }

    boolean F() {
        AccessibilityManager accessibilityManager = this.f34187o;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        if (enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty()) {
            return true;
        }
        return false;
    }

    final void H() {
        if (this.f34175c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f34175c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                E((CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.f34175c.b(this.f34173a);
            D();
            this.f34175c.setVisibility(4);
        }
        if (ViewCompat.isLaidOut(this.f34175c)) {
            I();
        } else {
            this.f34184l = true;
        }
    }

    void k() {
        this.f34175c.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.8
            @Override // java.lang.Runnable
            public void run() {
                SnackbarBaseLayout snackbarBaseLayout = BaseTransientBottomBar.this.f34175c;
                if (snackbarBaseLayout == null) {
                    return;
                }
                if (snackbarBaseLayout.getParent() != null) {
                    BaseTransientBottomBar.this.f34175c.setVisibility(0);
                }
                if (BaseTransientBottomBar.this.f34175c.d() == 1) {
                    BaseTransientBottomBar.this.J();
                } else {
                    BaseTransientBottomBar.this.L();
                }
            }
        });
    }

    protected void n(int i3) {
        com.google.android.material.snackbar.b.c().b(this.f34188p, i3);
    }

    @Nullable
    public View p() {
        return null;
    }

    @NonNull
    protected SwipeDismissBehavior<? extends View> q() {
        return new Behavior();
    }

    final void v(int i3) {
        if (F() && this.f34175c.getVisibility() == 0) {
            l(i3);
        } else {
            B(i3);
        }
    }

    public boolean w() {
        return com.google.android.material.snackbar.b.c().e(this.f34188p);
    }

    void y() {
        WindowInsets rootWindowInsets;
        Insets mandatorySystemGestureInsets;
        int i3;
        if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = this.f34175c.getRootWindowInsets()) != null) {
            mandatorySystemGestureInsets = rootWindowInsets.getMandatorySystemGestureInsets();
            i3 = mandatorySystemGestureInsets.bottom;
            this.f34182j = i3;
            N();
        }
    }

    void z() {
        if (w()) {
            f34169q.post(new Runnable() { // from class: com.google.android.material.snackbar.BaseTransientBottomBar.6
                @Override // java.lang.Runnable
                public void run() {
                    BaseTransientBottomBar.this.B(3);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class BaseCallback<B> {

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes2.dex */
        public @interface DismissEvent {
        }

        public void b(B b16) {
        }

        public void a(B b16, int i3) {
        }
    }
}
