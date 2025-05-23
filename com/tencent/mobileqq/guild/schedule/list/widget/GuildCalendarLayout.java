package com.tencent.mobileqq.guild.schedule.list.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.schedule.list.helper.GuildScheduleCalendarHelper;
import com.tencent.mobileqq.guild.schedule.list.widget.GuildCalendarLayout;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildCalendarLayout extends FrameLayout {
    private int C;
    private int D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private int J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean P;
    private boolean Q;
    private int R;
    private int S;
    private VelocityTracker T;
    private ViewFlinger U;
    private GuildScheduleCalendarHelper V;
    private BroadcastReceiver W;

    /* renamed from: a0, reason: collision with root package name */
    private c f233312a0;

    /* renamed from: d, reason: collision with root package name */
    private View f233313d;

    /* renamed from: e, reason: collision with root package name */
    private View f233314e;

    /* renamed from: f, reason: collision with root package name */
    private View f233315f;

    /* renamed from: h, reason: collision with root package name */
    private View f233316h;

    /* renamed from: i, reason: collision with root package name */
    private View f233317i;

    /* renamed from: m, reason: collision with root package name */
    private View f233318m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class ViewFlinger implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f233319d;

        /* renamed from: e, reason: collision with root package name */
        private int f233320e;

        /* renamed from: f, reason: collision with root package name */
        private final OverScroller f233321f;

        ViewFlinger() {
            this.f233321f = new OverScroller(GuildCalendarLayout.this.getContext(), new Interpolator() { // from class: com.tencent.mobileqq.guild.schedule.list.widget.c
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f16) {
                    float f17;
                    f17 = GuildCalendarLayout.ViewFlinger.f(f16);
                    return f17;
                }
            });
        }

        private void d(int i3) {
            if (GuildCalendarLayout.this.f233316h instanceof RecyclerView) {
                ((RecyclerView) GuildCalendarLayout.this.f233316h).fling(0, i3);
            } else if (GuildCalendarLayout.this.f233316h instanceof ScrollView) {
                ((ScrollView) GuildCalendarLayout.this.f233316h).fling(i3);
            } else if (GuildCalendarLayout.this.f233316h instanceof NestedScrollView) {
                ((NestedScrollView) GuildCalendarLayout.this.f233316h).fling(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e(int i3) {
            float f16;
            this.f233319d = i3;
            this.f233320e = 0;
            this.f233321f.fling(0, 0, 0, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            float translationY = GuildCalendarLayout.this.f233316h.getTranslationY();
            int abs = Math.abs(this.f233321f.getFinalY());
            if (this.f233319d > 0) {
                f16 = 0.0f - translationY;
            } else {
                f16 = translationY + GuildCalendarLayout.this.D;
            }
            if (Math.abs(this.f233319d) > GuildCalendarLayout.this.R && f16 > 0.0f && abs > f16) {
                ViewCompat.postOnAnimation(GuildCalendarLayout.this, this);
                GuildCalendarLayout.this.K = true;
                return true;
            }
            this.f233321f.forceFinished(true);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ float f(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17) + 1.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            OverScroller overScroller = this.f233321f;
            if (overScroller != null) {
                overScroller.forceFinished(true);
            }
            GuildCalendarLayout.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            float translationY = GuildCalendarLayout.this.f233316h.getTranslationY();
            boolean z17 = false;
            if (this.f233321f.computeScrollOffset()) {
                float f16 = translationY + (r1 - this.f233320e);
                this.f233320e = this.f233321f.getCurrY();
                GuildCalendarLayout.this.A(f16);
                int i3 = this.f233319d;
                if ((i3 > 0 && f16 >= 0.0f) || (i3 < 0 && f16 <= (-GuildCalendarLayout.this.D))) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (!this.f233321f.isFinished()) {
                        int currVelocity = (int) this.f233321f.getCurrVelocity();
                        if (this.f233319d > 0) {
                            currVelocity *= -1;
                        }
                        d(currVelocity);
                    }
                    this.f233321f.forceFinished(true);
                    GuildCalendarLayout guildCalendarLayout = GuildCalendarLayout.this;
                    if (this.f233319d > 0) {
                        z17 = true;
                    }
                    guildCalendarLayout.r(z17);
                    return;
                }
                ViewCompat.postOnAnimation(GuildCalendarLayout.this, this);
                return;
            }
            GuildCalendarLayout guildCalendarLayout2 = GuildCalendarLayout.this;
            if (this.f233319d > 0) {
                z17 = true;
            }
            guildCalendarLayout2.r(z17);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (GuildCalendarLayout.this.V != null) {
                GuildCalendarLayout.this.V.t();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f233323d;

        b(boolean z16) {
            this.f233323d = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            GuildCalendarLayout.this.r(this.f233323d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface c {
        void a(boolean z16);
    }

    public GuildCalendarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(float f16) {
        B(f16, false);
    }

    private void B(float f16, boolean z16) {
        if (!z16) {
            int i3 = -this.D;
            float f17 = 0;
            if (f16 > f17) {
                f16 = f17;
            }
            float f18 = i3;
            if (f16 < f18) {
                f16 = f18;
            }
        }
        this.f233316h.setTranslationY(f16);
        this.f233313d.setTranslationY(this.E * (f16 / this.D));
        View view = this.f233317i;
        if (view != null) {
            view.setTranslationY(f16);
        }
        if (this.L && this.f233313d.getVisibility() != 0) {
            x(this.f233313d, 0);
            x(this.f233314e, 4);
        }
        View view2 = this.f233318m;
        if (view2 != null) {
            view2.setTranslationY(f16);
        }
        if (this.V.f233258a) {
            requestLayout();
        }
    }

    private void D() {
        if (this.W == null) {
            return;
        }
        getContext().unregisterReceiver(this.W);
        this.W = null;
    }

    private int j() {
        VelocityTracker velocityTracker = this.T;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000, this.S);
            return (int) this.T.getYVelocity();
        }
        return 0;
    }

    private void l() {
        VelocityTracker velocityTracker = this.T;
        if (velocityTracker == null) {
            this.T = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void m(Context context, AttributeSet attributeSet) {
        this.V = new GuildScheduleCalendarHelper(context, attributeSet);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.F = viewConfiguration.getScaledTouchSlop();
        this.R = viewConfiguration.getScaledMinimumFlingVelocity();
        this.S = viewConfiguration.getScaledMaximumFlingVelocity();
        this.U = new ViewFlinger();
        E();
    }

    private boolean n() {
        return !this.f233316h.canScrollVertically(-1);
    }

    private boolean o() {
        if (this.f233316h.getTranslationY() <= (-this.D)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float p(float f16) {
        float f17 = f16 - 1.0f;
        return (f17 * f17 * f17) + 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(ValueAnimator valueAnimator) {
        A(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z16) {
        int i3;
        int i16 = 0;
        this.K = false;
        View view = this.f233314e;
        if (z16) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        x(view, i3);
        View view2 = this.f233313d;
        if (!z16) {
            i16 = 4;
        }
        x(view2, i16);
        c cVar = this.f233312a0;
        if (cVar != null) {
            cVar.a(z16);
        }
    }

    private void t(MotionEvent motionEvent) {
        boolean z16;
        int findPointerIndex = motionEvent.findPointerIndex(this.J);
        if (findPointerIndex < 0) {
            return;
        }
        float y16 = motionEvent.getY(findPointerIndex);
        float translationY = this.f233316h.getTranslationY();
        boolean z17 = true;
        if (y16 > 0.0f && y16 < this.f233315f.getMeasuredHeight() + this.V.f233275r + translationY) {
            z16 = true;
        } else {
            z16 = false;
        }
        int j3 = j() / 2;
        if (z16 || !this.U.e(j3)) {
            if (this.I <= 0.0f) {
                z17 = false;
            }
            C(z17);
        }
        v();
    }

    private void u() {
        if (this.W != null) {
            return;
        }
        this.W = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        getContext().registerReceiver(this.W, intentFilter);
    }

    private void v() {
        this.L = false;
        this.M = false;
        this.N = false;
        this.I = 0.0f;
        this.J = -1;
        requestDisallowInterceptTouchEvent(false);
    }

    private void w(View view, int i3) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin = i3;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    private void x(View view, int i3) {
        if (view == null) {
            return;
        }
        if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
        if (view.getVisibility() == 0) {
            view.setAlpha(1.0f);
        } else {
            view.setAlpha(0.0f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void y(float f16, float f17) {
        boolean z16;
        boolean z17;
        int i3;
        if (this.L) {
            return;
        }
        float f18 = f17 - this.H;
        float abs = Math.abs(f16 - this.G);
        float abs2 = Math.abs(f18);
        if (abs2 < this.F) {
            return;
        }
        if (this.f233314e.getVisibility() == 0) {
            GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.V;
            int i16 = guildScheduleCalendarHelper.f233274q;
            int i17 = guildScheduleCalendarHelper.f233276s;
            if (f17 >= i16 - i17 && f17 <= i16 + i17 + guildScheduleCalendarHelper.f233277t) {
                z16 = true;
                if (!z16 && 3.0f * abs > abs2) {
                    return;
                }
                float translationY = this.f233316h.getTranslationY();
                if (f17 <= 0.0f && f17 < this.f233315f.getMeasuredHeight() + this.V.f233275r + translationY) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 && abs * 1.5d > abs2) {
                    return;
                }
                if (z17 && (f18 >= 0.0f || o())) {
                    this.N = true;
                    return;
                }
                this.G = f16;
                float f19 = this.H;
                if (f18 <= 0.0f) {
                    i3 = this.F;
                } else {
                    i3 = -this.F;
                }
                this.H = f19 + i3;
                this.L = true;
                this.M = true;
                this.N = false;
                requestDisallowInterceptTouchEvent(true);
            }
        }
        z16 = false;
        if (!z16) {
        }
        float translationY2 = this.f233316h.getTranslationY();
        if (f17 <= 0.0f) {
        }
        z17 = false;
        if (!z17) {
        }
        if (z17) {
        }
        this.G = f16;
        float f192 = this.H;
        if (f18 <= 0.0f) {
        }
        this.H = f192 + i3;
        this.L = true;
        this.M = true;
        this.N = false;
        requestDisallowInterceptTouchEvent(true);
    }

    private void z() {
        this.U.stop();
    }

    public void C(boolean z16) {
        View view;
        float f16;
        if (!this.K && (view = this.f233316h) != null) {
            float translationY = view.getTranslationY();
            if (z16) {
                f16 = 0.0f;
            } else {
                f16 = -this.D;
            }
            long min = Math.min(250L, Math.max(50L, (Math.abs(f16 - translationY) * 250.0f) / 300.0f));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(translationY, f16);
            ofFloat.setInterpolator(new TimeInterpolator() { // from class: com.tencent.mobileqq.guild.schedule.list.widget.a
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f17) {
                    float p16;
                    p16 = GuildCalendarLayout.p(f17);
                    return p16;
                }
            });
            ofFloat.setDuration(min);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.schedule.list.widget.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GuildCalendarLayout.this.q(valueAnimator);
                }
            });
            ofFloat.addListener(new b(z16));
            this.K = true;
            ofFloat.start();
        }
    }

    public void E() {
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.V;
        py1.a aVar = guildScheduleCalendarHelper.f233279v;
        int i3 = guildScheduleCalendarHelper.f233276s + guildScheduleCalendarHelper.f233277t;
        int n3 = guildScheduleCalendarHelper.n(aVar.f428062a, aVar.f428063b) * i3;
        this.C = n3;
        this.D = n3 - i3;
        this.E = this.V.o(aVar.f428062a, aVar.f428063b, aVar.f428064c) * i3;
    }

    public void F() {
        this.V.u();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if (r0 != 3) goto L54;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i3;
        if (!this.K && this.f233315f != null && this.f233316h != null) {
            int actionMasked = motionEvent.getActionMasked();
            boolean z16 = false;
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if (this.P && (i3 = this.J) != -1) {
                            int findPointerIndex = motionEvent.findPointerIndex(i3);
                            if (findPointerIndex < 0) {
                                return super.dispatchTouchEvent(motionEvent);
                            }
                            motionEvent.getX(findPointerIndex);
                            float y16 = motionEvent.getY(findPointerIndex) - this.H;
                            if (this.L && y16 != 0.0f) {
                                this.I = y16;
                            }
                            if (y16 > 0.0f && o() && n()) {
                                requestDisallowInterceptTouchEvent(false);
                            }
                        }
                    }
                }
                if (this.P && this.M) {
                    t(motionEvent);
                    return true;
                }
                v();
            } else {
                if (this.Q || (motionEvent.getY() > 0.0f && motionEvent.getY() < this.f233315f.getMeasuredHeight() + this.V.f233275r + this.f233316h.getTranslationY())) {
                    z16 = true;
                }
                this.P = z16;
                if (z16) {
                    l();
                }
            }
            VelocityTracker velocityTracker = this.T;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public GuildScheduleCalendarHelper k() {
        return this.V;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        D();
        z();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f233313d = findViewById(this.V.f233264g);
        this.f233314e = findViewById(this.V.f233265h);
        this.f233315f = findViewById(this.V.f233260c);
        this.f233316h = findViewById(this.V.f233261d);
        this.f233317i = findViewById(this.V.f233262e);
        this.f233318m = findViewById(this.V.f233263f);
        F();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        if (!isEnabled()) {
            return false;
        }
        if (this.K) {
            return true;
        }
        if (this.P && this.f233315f != null && this.f233316h != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 2) {
                    int i3 = this.J;
                    if (i3 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i3)) < 0) {
                        return false;
                    }
                    y(motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex));
                }
            } else {
                this.L = false;
                int pointerId = motionEvent.getPointerId(0);
                this.J = pointerId;
                int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                this.G = motionEvent.getX(findPointerIndex2);
                this.H = motionEvent.getY(findPointerIndex2);
            }
            return this.L;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        super.onMeasure(i3, i16);
        int measuredHeight = getMeasuredHeight();
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.V;
        if (guildScheduleCalendarHelper.f233258a) {
            i17 = measuredHeight - ((ViewGroup.MarginLayoutParams) this.f233316h.getLayoutParams()).topMargin;
            i18 = (int) this.f233316h.getTranslationY();
        } else {
            i17 = ((measuredHeight - guildScheduleCalendarHelper.f233274q) - guildScheduleCalendarHelper.f233275r) - guildScheduleCalendarHelper.f233276s;
            i18 = guildScheduleCalendarHelper.f233277t;
        }
        this.f233316h.measure(i3, View.MeasureSpec.makeMeasureSpec(Math.max(i17 - i18, 0), 1073741824));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i3 = 0;
        if (!isEnabled()) {
            return false;
        }
        if (this.K) {
            return true;
        }
        if (this.P && this.f233315f != null && this.f233316h != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 2) {
                    if (actionMasked != 5) {
                        if (actionMasked == 6) {
                            int actionIndex = motionEvent.getActionIndex();
                            if (motionEvent.getPointerId(actionIndex) == this.J) {
                                if (actionIndex == 0) {
                                    i3 = 1;
                                }
                                this.J = motionEvent.getPointerId(i3);
                                this.G = motionEvent.getX(i3);
                                this.H = motionEvent.getY(i3);
                            }
                        }
                    } else {
                        int actionIndex2 = motionEvent.getActionIndex();
                        if (actionIndex2 < 0) {
                            return false;
                        }
                        this.J = motionEvent.getPointerId(actionIndex2);
                        this.G = motionEvent.getX(actionIndex2);
                        this.H = motionEvent.getY(actionIndex2);
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.J);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    float x16 = motionEvent.getX(findPointerIndex);
                    float y16 = motionEvent.getY(findPointerIndex);
                    y(x16, y16);
                    if (this.L) {
                        float f16 = y16 - this.H;
                        this.G = x16;
                        this.H = y16;
                        if (f16 < 0.0f && o()) {
                            this.N = true;
                            motionEvent.setAction(0);
                            dispatchTouchEvent(motionEvent);
                        } else {
                            A(this.f233316h.getTranslationY() + f16);
                        }
                    }
                }
            } else {
                this.J = motionEvent.getPointerId(0);
                this.L = false;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void s(int i3) {
        GuildScheduleCalendarHelper guildScheduleCalendarHelper = this.V;
        int i16 = guildScheduleCalendarHelper.f233274q + i3;
        int i17 = guildScheduleCalendarHelper.f233275r + i16;
        w(this.f233317i, i16);
        w(this.f233316h, i17);
        w(this.f233318m, i17);
        if (this.f233313d.getVisibility() == 4) {
            B((-this.D) + (this.C - i3), true);
        } else if (this.V.f233258a) {
            requestLayout();
        }
    }

    public void setHasContent(boolean z16) {
        this.Q = z16;
    }

    public void setOnToggleListener(c cVar) {
        this.f233312a0 = cVar;
    }
}
