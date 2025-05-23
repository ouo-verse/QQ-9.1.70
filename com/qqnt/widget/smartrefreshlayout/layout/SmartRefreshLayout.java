package com.qqnt.widget.smartrefreshlayout.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import com.qqnt.widget.smartrefreshlayout.layout.wrapper.RefreshFooterWrapper;
import com.qqnt.widget.smartrefreshlayout.layout.wrapper.RefreshHeaderWrapper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import r3.g;
import r3.h;
import r3.j;

/* compiled from: P */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes3.dex */
public class SmartRefreshLayout extends ViewGroup implements q3.f, NestedScrollingParent {

    /* renamed from: l1, reason: collision with root package name */
    protected static ViewGroup.MarginLayoutParams f41145l1 = new ViewGroup.MarginLayoutParams(-1, -1);
    protected g A0;
    protected j B0;
    protected int C;
    protected int C0;
    protected float D;
    protected boolean D0;
    protected float E;
    protected int[] E0;
    protected float F;
    protected NestedScrollingChildHelper F0;
    protected float G;
    protected NestedScrollingParentHelper G0;
    protected float H;
    protected int H0;
    protected char I;
    protected com.qqnt.widget.smartrefreshlayout.layout.constant.a I0;
    protected boolean J;
    protected int J0;
    protected boolean K;
    protected com.qqnt.widget.smartrefreshlayout.layout.constant.a K0;
    protected boolean L;
    protected int L0;
    protected int M;
    protected int M0;
    protected int N;
    protected float N0;
    protected float O0;
    protected int P;
    protected float P0;
    protected int Q;
    protected float Q0;
    protected int R;
    protected float R0;
    protected int S;
    protected q3.a S0;
    protected int T;
    protected q3.a T0;
    protected Scroller U;
    protected q3.b U0;
    protected VelocityTracker V;
    protected Paint V0;
    protected Interpolator W;
    protected Handler W0;
    protected q3.e X0;
    protected RefreshState Y0;
    protected RefreshState Z0;

    /* renamed from: a0, reason: collision with root package name */
    protected int[] f41146a0;

    /* renamed from: a1, reason: collision with root package name */
    protected long f41147a1;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f41148b0;

    /* renamed from: b1, reason: collision with root package name */
    protected int f41149b1;

    /* renamed from: c0, reason: collision with root package name */
    protected boolean f41150c0;

    /* renamed from: c1, reason: collision with root package name */
    protected int f41151c1;

    /* renamed from: d, reason: collision with root package name */
    protected int f41152d;

    /* renamed from: d0, reason: collision with root package name */
    protected boolean f41153d0;

    /* renamed from: d1, reason: collision with root package name */
    protected boolean f41154d1;

    /* renamed from: e, reason: collision with root package name */
    protected int f41155e;

    /* renamed from: e0, reason: collision with root package name */
    protected boolean f41156e0;

    /* renamed from: e1, reason: collision with root package name */
    protected boolean f41157e1;

    /* renamed from: f, reason: collision with root package name */
    protected int f41158f;

    /* renamed from: f0, reason: collision with root package name */
    protected boolean f41159f0;

    /* renamed from: f1, reason: collision with root package name */
    protected boolean f41160f1;

    /* renamed from: g0, reason: collision with root package name */
    protected boolean f41161g0;

    /* renamed from: g1, reason: collision with root package name */
    protected boolean f41162g1;

    /* renamed from: h, reason: collision with root package name */
    protected int f41163h;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f41164h0;

    /* renamed from: h1, reason: collision with root package name */
    protected boolean f41165h1;

    /* renamed from: i, reason: collision with root package name */
    protected int f41166i;

    /* renamed from: i0, reason: collision with root package name */
    protected boolean f41167i0;

    /* renamed from: i1, reason: collision with root package name */
    protected MotionEvent f41168i1;

    /* renamed from: j0, reason: collision with root package name */
    protected boolean f41169j0;

    /* renamed from: j1, reason: collision with root package name */
    protected Runnable f41170j1;

    /* renamed from: k0, reason: collision with root package name */
    protected boolean f41171k0;

    /* renamed from: k1, reason: collision with root package name */
    protected ValueAnimator f41172k1;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f41173l0;

    /* renamed from: m, reason: collision with root package name */
    protected int f41174m;

    /* renamed from: m0, reason: collision with root package name */
    protected boolean f41175m0;

    /* renamed from: n0, reason: collision with root package name */
    protected boolean f41176n0;

    /* renamed from: o0, reason: collision with root package name */
    protected boolean f41177o0;

    /* renamed from: p0, reason: collision with root package name */
    protected boolean f41178p0;

    /* renamed from: q0, reason: collision with root package name */
    protected boolean f41179q0;

    /* renamed from: r0, reason: collision with root package name */
    protected boolean f41180r0;

    /* renamed from: s0, reason: collision with root package name */
    protected boolean f41181s0;

    /* renamed from: t0, reason: collision with root package name */
    protected boolean f41182t0;

    /* renamed from: u0, reason: collision with root package name */
    protected boolean f41183u0;

    /* renamed from: v0, reason: collision with root package name */
    protected boolean f41184v0;

    /* renamed from: w0, reason: collision with root package name */
    protected boolean f41185w0;

    /* renamed from: x0, reason: collision with root package name */
    protected boolean f41186x0;

    /* renamed from: y0, reason: collision with root package name */
    protected h f41187y0;

    /* renamed from: z0, reason: collision with root package name */
    protected r3.e f41188z0;

    /* compiled from: P */
    /* renamed from: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout$10, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass10 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f41189d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f41190e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f41191f;
        final /* synthetic */ SmartRefreshLayout this$0;

        /* compiled from: P */
        /* renamed from: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout$10$a */
        /* loaded from: classes3.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout smartRefreshLayout = AnonymousClass10.this.this$0;
                if (smartRefreshLayout.f41172k1 != null && smartRefreshLayout.T0 != null) {
                    smartRefreshLayout.X0.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout$10$b */
        /* loaded from: classes3.dex */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator != null && animator.getDuration() == 0) {
                    return;
                }
                SmartRefreshLayout smartRefreshLayout = AnonymousClass10.this.this$0;
                smartRefreshLayout.f41172k1 = null;
                if (smartRefreshLayout.T0 != null) {
                    RefreshState refreshState = smartRefreshLayout.Y0;
                    RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                    if (refreshState != refreshState2) {
                        smartRefreshLayout.X0.b(refreshState2);
                    }
                    AnonymousClass10.this.this$0.b0(!r5.f41191f);
                    return;
                }
                smartRefreshLayout.X0.b(RefreshState.None);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            float f16;
            SmartRefreshLayout smartRefreshLayout = this.this$0;
            if (smartRefreshLayout.Z0 != RefreshState.Loading) {
                return;
            }
            ValueAnimator valueAnimator = smartRefreshLayout.f41172k1;
            if (valueAnimator != null) {
                valueAnimator.setDuration(0L);
                this.this$0.f41172k1.cancel();
                this.this$0.f41172k1 = null;
            }
            this.this$0.F = r0.getMeasuredWidth() / 2.0f;
            this.this$0.X0.b(RefreshState.PullUpToLoad);
            SmartRefreshLayout smartRefreshLayout2 = this.this$0;
            int i3 = smartRefreshLayout2.J0;
            if (i3 == 0) {
                f16 = smartRefreshLayout2.Q0;
            } else {
                f16 = i3;
            }
            float f17 = this.f41189d;
            if (f17 < 10.0f) {
                f17 *= f16;
            }
            smartRefreshLayout2.f41172k1 = ValueAnimator.ofInt(smartRefreshLayout2.f41155e, -((int) f17));
            this.this$0.f41172k1.setDuration(this.f41190e);
            this.this$0.f41172k1.setInterpolator(new t3.d(t3.d.f435348b));
            this.this$0.f41172k1.addUpdateListener(new a());
            this.this$0.f41172k1.addListener(new b());
            this.this$0.f41172k1.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout$8, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass8 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        int f41199d = 0;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f41200e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f41201f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f41202h;

        AnonymousClass8(int i3, boolean z16, boolean z17) {
            this.f41200e = i3;
            this.f41201f = z16;
            this.f41202h = z17;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x00b0, code lost:
        
            if (r6.U0.canLoadMore() != false) goto L49;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i3;
            int i16;
            int i17 = this.f41199d;
            long j3 = 0;
            boolean z16 = true;
            if (i17 == 0) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout.Y0;
                RefreshState refreshState2 = RefreshState.None;
                if (refreshState == refreshState2 && smartRefreshLayout.Z0 == RefreshState.Loading) {
                    smartRefreshLayout.Z0 = refreshState2;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.f41172k1;
                    if (valueAnimator != null && ((refreshState.isDragging || refreshState == RefreshState.LoadReleased) && refreshState.isFooter)) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.f41172k1.cancel();
                        SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                        smartRefreshLayout2.f41172k1 = null;
                        if (smartRefreshLayout2.X0.animSpinner(0) == null) {
                            SmartRefreshLayout.this.M(refreshState2);
                        } else {
                            SmartRefreshLayout.this.M(RefreshState.PullUpCanceled);
                        }
                    } else if (refreshState == RefreshState.Loading && smartRefreshLayout.T0 != null && smartRefreshLayout.U0 != null) {
                        this.f41199d = i17 + 1;
                        smartRefreshLayout.W0.postDelayed(this, this.f41200e);
                        SmartRefreshLayout.this.M(RefreshState.LoadFinish);
                        return;
                    }
                }
                if (this.f41201f) {
                    SmartRefreshLayout.this.V(true);
                    return;
                }
                return;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int b16 = smartRefreshLayout3.T0.b(smartRefreshLayout3, this.f41202h);
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            g gVar = smartRefreshLayout4.A0;
            if (gVar != null) {
                q3.a aVar = smartRefreshLayout4.T0;
                if (aVar instanceof q3.c) {
                    gVar.cd((q3.c) aVar, this.f41202h);
                }
            }
            if (b16 < Integer.MAX_VALUE) {
                if (this.f41201f) {
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.f41164h0) {
                        if (smartRefreshLayout5.f41155e < 0) {
                        }
                    }
                }
                z16 = false;
                SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                int i18 = smartRefreshLayout6.f41155e;
                if (z16) {
                    i3 = Math.max(i18, -smartRefreshLayout6.J0);
                } else {
                    i3 = 0;
                }
                final int i19 = i18 - i3;
                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                if (smartRefreshLayout7.J || smartRefreshLayout7.D0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (smartRefreshLayout8.J) {
                        float f16 = smartRefreshLayout8.G;
                        smartRefreshLayout8.E = f16;
                        smartRefreshLayout8.f41163h = smartRefreshLayout8.f41155e - i19;
                        smartRefreshLayout8.J = false;
                        if (smartRefreshLayout8.f41161g0) {
                            i16 = i19;
                        } else {
                            i16 = 0;
                        }
                        float f17 = i16;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout8.F, f16 + f17 + (smartRefreshLayout8.f41152d * 2), 0));
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout9.F, smartRefreshLayout9.G + f17, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    if (smartRefreshLayout10.D0) {
                        smartRefreshLayout10.C0 = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout10.F, smartRefreshLayout10.G, 0));
                        SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                        smartRefreshLayout11.D0 = false;
                        smartRefreshLayout11.f41163h = 0;
                    }
                }
                Handler handler = SmartRefreshLayout.this.W0;
                Runnable runnable = new Runnable() { // from class: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout.8.1

                    /* compiled from: P */
                    /* renamed from: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout$8$1$a */
                    /* loaded from: classes3.dex */
                    class a extends AnimatorListenerAdapter {
                        a() {
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (animator != null && animator.getDuration() == 0) {
                                return;
                            }
                            AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                            smartRefreshLayout.f41162g1 = false;
                            if (anonymousClass8.f41201f) {
                                smartRefreshLayout.V(true);
                            }
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            if (smartRefreshLayout2.Y0 == RefreshState.LoadFinish) {
                                smartRefreshLayout2.M(RefreshState.None);
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
                        ValueAnimator valueAnimator2;
                        SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                        if (smartRefreshLayout12.f41176n0 && i19 < 0) {
                            animatorUpdateListener = smartRefreshLayout12.U0.scrollContentWhenFinished(smartRefreshLayout12.f41155e);
                            if (animatorUpdateListener != null) {
                                animatorUpdateListener.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                            }
                        } else {
                            animatorUpdateListener = null;
                        }
                        a aVar2 = new a();
                        AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                        SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                        int i26 = smartRefreshLayout13.f41155e;
                        if (i26 > 0) {
                            valueAnimator2 = smartRefreshLayout13.X0.animSpinner(0);
                        } else {
                            if (animatorUpdateListener == null && i26 != 0) {
                                if (anonymousClass8.f41201f && smartRefreshLayout13.f41164h0) {
                                    int i27 = smartRefreshLayout13.J0;
                                    if (i26 >= (-i27)) {
                                        smartRefreshLayout13.M(RefreshState.None);
                                    } else {
                                        valueAnimator2 = smartRefreshLayout13.X0.animSpinner(-i27);
                                    }
                                } else {
                                    valueAnimator2 = smartRefreshLayout13.X0.animSpinner(0);
                                }
                            } else {
                                ValueAnimator valueAnimator3 = smartRefreshLayout13.f41172k1;
                                if (valueAnimator3 != null) {
                                    valueAnimator3.setDuration(0L);
                                    SmartRefreshLayout.this.f41172k1.cancel();
                                    SmartRefreshLayout.this.f41172k1 = null;
                                }
                                SmartRefreshLayout.this.X0.moveSpinner(0, false);
                                SmartRefreshLayout.this.X0.b(RefreshState.None);
                            }
                            valueAnimator2 = null;
                        }
                        if (valueAnimator2 != null) {
                            valueAnimator2.addListener(aVar2);
                        } else {
                            aVar2.onAnimationEnd(null);
                        }
                    }
                };
                if (SmartRefreshLayout.this.f41155e < 0) {
                    j3 = b16;
                }
                handler.postDelayed(runnable, j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class BounceRunnable implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        int f41213f;

        /* renamed from: m, reason: collision with root package name */
        float f41216m;

        /* renamed from: d, reason: collision with root package name */
        int f41211d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f41212e = 10;

        /* renamed from: i, reason: collision with root package name */
        float f41215i = 0.0f;

        /* renamed from: h, reason: collision with root package name */
        long f41214h = AnimationUtils.currentAnimationTimeMillis();

        BounceRunnable(float f16, int i3) {
            this.f41216m = f16;
            this.f41213f = i3;
            SmartRefreshLayout.this.W0.postDelayed(this, this.f41212e);
            if (f16 > 0.0f) {
                SmartRefreshLayout.this.X0.b(RefreshState.None);
            } else {
                SmartRefreshLayout.this.X0.b(RefreshState.None);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f41170j1 == this && !smartRefreshLayout.Y0.isFinishing) {
                if (Math.abs(smartRefreshLayout.f41155e) >= Math.abs(this.f41213f)) {
                    if (this.f41213f != 0) {
                        double d16 = this.f41216m;
                        this.f41211d = this.f41211d + 1;
                        this.f41216m = (float) (d16 * Math.pow(0.44999998807907104d, r2 * 2));
                    } else {
                        double d17 = this.f41216m;
                        this.f41211d = this.f41211d + 1;
                        this.f41216m = (float) (d17 * Math.pow(0.8500000238418579d, r2 * 2));
                    }
                } else {
                    double d18 = this.f41216m;
                    this.f41211d = this.f41211d + 1;
                    this.f41216m = (float) (d18 * Math.pow(0.949999988079071d, r2 * 2));
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float f16 = this.f41216m * ((((float) (currentAnimationTimeMillis - this.f41214h)) * 1.0f) / 1000.0f);
                if (Math.abs(f16) >= 1.0f) {
                    this.f41214h = currentAnimationTimeMillis;
                    float f17 = this.f41215i + f16;
                    this.f41215i = f17;
                    SmartRefreshLayout.this.L(f17, false);
                    SmartRefreshLayout.this.W0.postDelayed(this, this.f41212e);
                    return;
                }
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                RefreshState refreshState = smartRefreshLayout2.Z0;
                boolean z16 = refreshState.isDragging;
                if (z16 && refreshState.isHeader) {
                    smartRefreshLayout2.X0.b(RefreshState.PullDownCanceled);
                } else if (z16 && refreshState.isFooter) {
                    smartRefreshLayout2.X0.b(RefreshState.PullUpCanceled);
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                smartRefreshLayout3.f41170j1 = null;
                if (Math.abs(smartRefreshLayout3.f41155e) >= Math.abs(this.f41213f)) {
                    int min = Math.min(Math.max((int) t3.d.i(Math.abs(SmartRefreshLayout.this.f41155e - this.f41213f)), 30), 100) * 10;
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    smartRefreshLayout4.t(this.f41213f, 0, smartRefreshLayout4.W, min);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        int f41217d;

        /* renamed from: h, reason: collision with root package name */
        float f41220h;

        /* renamed from: e, reason: collision with root package name */
        int f41218e = 0;

        /* renamed from: f, reason: collision with root package name */
        int f41219f = 10;

        /* renamed from: i, reason: collision with root package name */
        float f41221i = 0.98f;

        /* renamed from: m, reason: collision with root package name */
        long f41222m = 0;
        long C = AnimationUtils.currentAnimationTimeMillis();

        FlingRunnable(float f16) {
            this.f41220h = f16;
            this.f41217d = SmartRefreshLayout.this.f41155e;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x0057, code lost:
        
            if (r0.f41155e > r0.H0) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0049, code lost:
        
            if (r0.f41155e >= (-r0.J0)) goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Runnable e() {
            RefreshState refreshState;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            RefreshState refreshState2 = smartRefreshLayout.Y0;
            if (refreshState2.isFinishing) {
                return null;
            }
            if (smartRefreshLayout.f41155e != 0) {
                if (refreshState2.isOpening || (smartRefreshLayout.f41182t0 && smartRefreshLayout.f41164h0 && smartRefreshLayout.f41183u0 && smartRefreshLayout.H(smartRefreshLayout.f41150c0))) {
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.Y0 == RefreshState.Loading || (smartRefreshLayout2.f41182t0 && smartRefreshLayout2.f41164h0 && smartRefreshLayout2.f41183u0 && smartRefreshLayout2.H(smartRefreshLayout2.f41150c0))) {
                        SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    }
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    if (smartRefreshLayout4.Y0 == RefreshState.Refreshing) {
                    }
                }
                int i3 = SmartRefreshLayout.this.f41155e;
                float f16 = this.f41220h;
                int i16 = 0;
                int i17 = i3;
                while (true) {
                    if (i3 * i17 <= 0) {
                        break;
                    }
                    i16++;
                    f16 = (float) (f16 * Math.pow(this.f41221i, (this.f41219f * i16) / 10.0f));
                    float f17 = ((this.f41219f * 1.0f) / 1000.0f) * f16;
                    if (Math.abs(f17) < 1.0f) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        RefreshState refreshState3 = smartRefreshLayout5.Y0;
                        if (!refreshState3.isOpening || ((refreshState3 == (refreshState = RefreshState.Refreshing) && i17 > smartRefreshLayout5.H0) || (refreshState3 != refreshState && i17 < (-smartRefreshLayout5.J0)))) {
                            return null;
                        }
                    } else {
                        i17 = (int) (i17 + f17);
                    }
                }
            }
            this.f41222m = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.W0.postDelayed(this, this.f41219f);
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f41170j1 == this && !smartRefreshLayout.Y0.isFinishing) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long j3 = currentAnimationTimeMillis - this.C;
                float pow = (float) (this.f41220h * Math.pow(this.f41221i, ((float) (currentAnimationTimeMillis - this.f41222m)) / (1000.0f / this.f41219f)));
                this.f41220h = pow;
                float f16 = pow * ((((float) j3) * 1.0f) / 1000.0f);
                if (Math.abs(f16) > 1.0f) {
                    this.C = currentAnimationTimeMillis;
                    int i3 = (int) (this.f41217d + f16);
                    this.f41217d = i3;
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.f41155e * i3 > 0) {
                        smartRefreshLayout2.X0.moveSpinner(i3, false);
                        SmartRefreshLayout.this.W0.postDelayed(this, this.f41219f);
                        return;
                    }
                    smartRefreshLayout2.f41170j1 = null;
                    smartRefreshLayout2.X0.moveSpinner(0, false);
                    t3.d.d(SmartRefreshLayout.this.U0.getScrollableView(), (int) (-this.f41220h));
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.f41162g1 && f16 > 0.0f) {
                        smartRefreshLayout3.f41162g1 = false;
                        return;
                    }
                    return;
                }
                SmartRefreshLayout.this.f41170j1 = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f41225a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f41225a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41225a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41225a[RefreshState.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41225a[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41225a[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41225a[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41225a[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41225a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41225a[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41225a[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41225a[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41225a[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f41226d;

        b(boolean z16) {
            this.f41226d = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator != null && animator.getDuration() == 0) {
                return;
            }
            SmartRefreshLayout.this.a0(this.f41226d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f41228d;

        c(boolean z16) {
            this.f41228d = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (animator != null && animator.getDuration() == 0) {
                return;
            }
            SmartRefreshLayout.this.f41147a1 = System.currentTimeMillis();
            SmartRefreshLayout.this.M(RefreshState.Refreshing);
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            h hVar = smartRefreshLayout.f41187y0;
            if (hVar != null) {
                if (this.f41228d) {
                    hVar.e(smartRefreshLayout);
                }
            } else if (smartRefreshLayout.A0 == null) {
                smartRefreshLayout.C(3000);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            q3.a aVar = smartRefreshLayout2.S0;
            if (aVar != null) {
                float f16 = smartRefreshLayout2.N0;
                if (f16 < 10.0f) {
                    f16 *= smartRefreshLayout2.H0;
                }
                aVar.f(smartRefreshLayout2, smartRefreshLayout2.H0, (int) f16);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            g gVar = smartRefreshLayout3.A0;
            if (gVar != null && (smartRefreshLayout3.S0 instanceof q3.d)) {
                if (this.f41228d) {
                    gVar.e(smartRefreshLayout3);
                }
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                float f17 = smartRefreshLayout4.N0;
                if (f17 < 10.0f) {
                    f17 *= smartRefreshLayout4.H0;
                }
                smartRefreshLayout4.A0.vf((q3.d) smartRefreshLayout4.S0, smartRefreshLayout4.H0, (int) f17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RefreshState refreshState;
            RefreshState refreshState2;
            if (animator != null && animator.getDuration() == 0) {
                return;
            }
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.f41172k1 = null;
            if (smartRefreshLayout.f41155e == 0 && (refreshState = smartRefreshLayout.Y0) != (refreshState2 = RefreshState.None) && !refreshState.isOpening && !refreshState.isDragging) {
                smartRefreshLayout.M(refreshState2);
                return;
            }
            RefreshState refreshState3 = smartRefreshLayout.Y0;
            if (refreshState3 != smartRefreshLayout.Z0) {
                smartRefreshLayout.d0(refreshState3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f41231d;

        e(boolean z16) {
            this.f41231d = z16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.X0.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), this.f41231d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class f implements q3.e {

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator != null && animator.getDuration() == 0) {
                    return;
                }
                SmartRefreshLayout.this.X0.b(RefreshState.TwoLevel);
            }
        }

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class b extends AnimatorListenerAdapter {
            b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator != null && animator.getDuration() == 0) {
                    return;
                }
                SmartRefreshLayout.this.X0.b(RefreshState.TwoLevel);
            }
        }

        public f() {
        }

        @Override // q3.e
        public q3.e a(@NonNull q3.a aVar, int i3) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.V0 == null && i3 != 0) {
                smartRefreshLayout.V0 = new Paint();
            }
            if (aVar.equals(SmartRefreshLayout.this.S0)) {
                SmartRefreshLayout.this.f41149b1 = i3;
            } else if (aVar.equals(SmartRefreshLayout.this.T0)) {
                SmartRefreshLayout.this.f41151c1 = i3;
            }
            return this;
        }

        @Override // q3.e
        public ValueAnimator animSpinner(int i3) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.t(i3, 0, smartRefreshLayout.W, smartRefreshLayout.f41174m);
        }

        @Override // q3.e
        public q3.e b(@NonNull RefreshState refreshState) {
            switch (a.f41225a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState2 = smartRefreshLayout.Y0;
                    RefreshState refreshState3 = RefreshState.None;
                    if (refreshState2 != refreshState3 && smartRefreshLayout.f41155e == 0) {
                        smartRefreshLayout.M(refreshState3);
                        return null;
                    }
                    if (smartRefreshLayout.f41155e != 0) {
                        animSpinner(0);
                        return null;
                    }
                    return null;
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.Y0.isOpening && smartRefreshLayout2.H(smartRefreshLayout2.f41148b0)) {
                        SmartRefreshLayout.this.M(RefreshState.PullDownToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.d0(RefreshState.PullDownToRefresh);
                    return null;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.H(smartRefreshLayout3.f41150c0)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        RefreshState refreshState4 = smartRefreshLayout4.Y0;
                        if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout4.f41182t0 || !smartRefreshLayout4.f41164h0 || !smartRefreshLayout4.f41183u0)) {
                            smartRefreshLayout4.M(RefreshState.PullUpToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.d0(RefreshState.PullUpToLoad);
                    return null;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout5.Y0.isOpening && smartRefreshLayout5.H(smartRefreshLayout5.f41148b0)) {
                        SmartRefreshLayout.this.M(RefreshState.PullDownCanceled);
                        b(RefreshState.None);
                        return null;
                    }
                    SmartRefreshLayout.this.d0(RefreshState.PullDownCanceled);
                    return null;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.H(smartRefreshLayout6.f41150c0)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.Y0.isOpening && (!smartRefreshLayout7.f41182t0 || !smartRefreshLayout7.f41164h0 || !smartRefreshLayout7.f41183u0)) {
                            smartRefreshLayout7.M(RefreshState.PullUpCanceled);
                            b(RefreshState.None);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.d0(RefreshState.PullUpCanceled);
                    return null;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout8.Y0.isOpening && smartRefreshLayout8.H(smartRefreshLayout8.f41148b0)) {
                        SmartRefreshLayout.this.M(RefreshState.ReleaseToRefresh);
                        return null;
                    }
                    SmartRefreshLayout.this.d0(RefreshState.ReleaseToRefresh);
                    return null;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.H(smartRefreshLayout9.f41150c0)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        RefreshState refreshState5 = smartRefreshLayout10.Y0;
                        if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout10.f41182t0 || !smartRefreshLayout10.f41164h0 || !smartRefreshLayout10.f41183u0)) {
                            smartRefreshLayout10.M(RefreshState.ReleaseToLoad);
                            return null;
                        }
                    }
                    SmartRefreshLayout.this.d0(RefreshState.ReleaseToLoad);
                    return null;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.Y0.isOpening && smartRefreshLayout11.H(smartRefreshLayout11.f41148b0)) {
                        SmartRefreshLayout.this.M(RefreshState.ReleaseToTwoLevel);
                        return null;
                    }
                    SmartRefreshLayout.this.d0(RefreshState.ReleaseToTwoLevel);
                    return null;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.Y0.isOpening && smartRefreshLayout12.H(smartRefreshLayout12.f41148b0)) {
                        SmartRefreshLayout.this.M(RefreshState.RefreshReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.d0(RefreshState.RefreshReleased);
                    return null;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout13.Y0.isOpening && smartRefreshLayout13.H(smartRefreshLayout13.f41150c0)) {
                        SmartRefreshLayout.this.M(RefreshState.LoadReleased);
                        return null;
                    }
                    SmartRefreshLayout.this.d0(RefreshState.LoadReleased);
                    return null;
                case 11:
                    SmartRefreshLayout.this.c0(true);
                    return null;
                case 12:
                    SmartRefreshLayout.this.b0(true);
                    return null;
                default:
                    SmartRefreshLayout.this.M(refreshState);
                    return null;
            }
        }

        @Override // q3.e
        public q3.e c(int i3) {
            SmartRefreshLayout.this.f41166i = i3;
            return this;
        }

        @Override // q3.e
        public q3.e d(boolean z16) {
            if (z16) {
                a aVar = new a();
                ValueAnimator animSpinner = animSpinner(SmartRefreshLayout.this.getMeasuredHeight());
                if (animSpinner != null) {
                    if (animSpinner == SmartRefreshLayout.this.f41172k1) {
                        animSpinner.setDuration(r1.f41166i);
                        animSpinner.addListener(aVar);
                    }
                }
                aVar.onAnimationEnd(null);
            } else if (animSpinner(0) == null) {
                SmartRefreshLayout.this.M(RefreshState.None);
            }
            return this;
        }

        @Override // q3.e
        public q3.e e(@NonNull q3.a aVar, boolean z16) {
            if (aVar.equals(SmartRefreshLayout.this.S0)) {
                SmartRefreshLayout.this.f41154d1 = z16;
            } else if (aVar.equals(SmartRefreshLayout.this.T0)) {
                SmartRefreshLayout.this.f41157e1 = z16;
            }
            return this;
        }

        @Override // q3.e
        public q3.e f(boolean z16, Animator.AnimatorListener animatorListener) {
            b bVar = new b();
            ValueAnimator h16 = h(SmartRefreshLayout.this.getMeasuredHeight(), true, 1000, animatorListener);
            if (h16 != null && h16 == SmartRefreshLayout.this.f41172k1) {
                h16.setDuration(800L);
                h16.addListener(bVar);
            } else {
                bVar.onAnimationEnd(null);
                animatorListener.onAnimationEnd(null);
            }
            return this;
        }

        @Override // q3.e
        public q3.e finishTwoLevel() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.Y0 == RefreshState.TwoLevel) {
                smartRefreshLayout.X0.b(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.f41155e == 0) {
                    moveSpinner(0, false);
                    SmartRefreshLayout.this.M(RefreshState.None);
                } else {
                    ValueAnimator animSpinner = animSpinner(0);
                    if (animSpinner != null) {
                        animSpinner.setDuration(SmartRefreshLayout.this.f41166i);
                    }
                }
            }
            return this;
        }

        @Override // q3.e
        public q3.e g(float f16) {
            SmartRefreshLayout.this.R0 = f16;
            return this;
        }

        @Override // q3.e
        @NonNull
        public q3.f getRefreshLayout() {
            return SmartRefreshLayout.this;
        }

        public ValueAnimator h(int i3, boolean z16, int i16, Animator.AnimatorListener animatorListener) {
            return SmartRefreshLayout.this.u(i3, 0, new LinearInterpolator(), i16, z16, animatorListener);
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00b8  */
        @Override // q3.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public q3.e moveSpinner(int i3, boolean z16) {
            int i16;
            int i17;
            g gVar;
            g gVar2;
            int i18;
            boolean z17;
            q3.a aVar;
            q3.a aVar2;
            q3.a aVar3;
            q3.a aVar4;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.f41155e == i3 && (((aVar3 = smartRefreshLayout.S0) == null || !aVar3.isSupportHorizontalDrag()) && ((aVar4 = SmartRefreshLayout.this.T0) == null || !aVar4.isSupportHorizontalDrag()))) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int i19 = smartRefreshLayout2.f41155e;
            smartRefreshLayout2.f41155e = i3;
            if (z16) {
                RefreshState refreshState = smartRefreshLayout2.Z0;
                if (refreshState.isDragging || refreshState.isOpening) {
                    float f16 = i3;
                    float f17 = smartRefreshLayout2.P0;
                    if (f17 < 10.0f) {
                        f17 *= smartRefreshLayout2.H0;
                    }
                    if (f16 > f17) {
                        if (smartRefreshLayout2.Y0 != RefreshState.ReleaseToTwoLevel) {
                            smartRefreshLayout2.X0.b(RefreshState.ReleaseToRefresh);
                        }
                    } else {
                        float f18 = -i3;
                        float f19 = smartRefreshLayout2.Q0;
                        if (f19 < 10.0f) {
                            f19 *= smartRefreshLayout2.J0;
                        }
                        if (f18 > f19 && !smartRefreshLayout2.f41182t0) {
                            smartRefreshLayout2.X0.b(RefreshState.ReleaseToLoad);
                        } else if (i3 < 0 && !smartRefreshLayout2.f41182t0) {
                            smartRefreshLayout2.X0.b(RefreshState.PullUpToLoad);
                        } else if (i3 > 0) {
                            smartRefreshLayout2.X0.b(RefreshState.PullDownToRefresh);
                        }
                    }
                }
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (smartRefreshLayout3.U0 != null) {
                if (i3 >= 0) {
                    if (smartRefreshLayout3.I(smartRefreshLayout3.f41159f0, smartRefreshLayout3.S0)) {
                        i18 = i3;
                    } else if (i19 < 0) {
                        i18 = 0;
                    }
                    z17 = true;
                    if (i3 <= 0) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        if (smartRefreshLayout4.I(smartRefreshLayout4.f41161g0, smartRefreshLayout4.T0)) {
                            i18 = i3;
                        } else if (i19 > 0) {
                            i18 = 0;
                        }
                        z17 = true;
                    }
                    if (z17) {
                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                        smartRefreshLayout5.U0.moveSpinner(i18, smartRefreshLayout5.P, smartRefreshLayout5.Q);
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (smartRefreshLayout6.f41182t0 && smartRefreshLayout6.f41183u0 && smartRefreshLayout6.f41164h0) {
                            q3.a aVar5 = smartRefreshLayout6.T0;
                            if ((aVar5 instanceof q3.c) && aVar5.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41251d) {
                                SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                                if (smartRefreshLayout7.H(smartRefreshLayout7.f41150c0)) {
                                    SmartRefreshLayout.this.T0.getView().setTranslationY(Math.max(0, i18));
                                }
                            }
                        }
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        boolean z18 = (smartRefreshLayout8.f41153d0 && (aVar2 = smartRefreshLayout8.S0) != null && aVar2.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41253f) || SmartRefreshLayout.this.f41149b1 != 0;
                        SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                        boolean z19 = (smartRefreshLayout9.f41156e0 && (aVar = smartRefreshLayout9.T0) != null && aVar.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41253f) || SmartRefreshLayout.this.f41151c1 != 0;
                        if ((z18 && (i18 >= 0 || i19 > 0)) || (z19 && (i18 <= 0 || i19 < 0))) {
                            smartRefreshLayout2.invalidate();
                        }
                    }
                }
                i18 = 0;
                z17 = false;
                if (i3 <= 0) {
                }
                if (z17) {
                }
            }
            if ((i3 >= 0 || i19 > 0) && SmartRefreshLayout.this.S0 != null) {
                int max = Math.max(i3, 0);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i26 = smartRefreshLayout10.H0;
                float f26 = smartRefreshLayout10.N0;
                if (f26 < 10.0f) {
                    f26 *= i26;
                }
                int i27 = (int) f26;
                float f27 = max * 1.0f;
                float f28 = smartRefreshLayout10.P0;
                if (f28 < 10.0f) {
                    f28 *= i26;
                }
                float f29 = f27 / f28;
                if (smartRefreshLayout10.H(smartRefreshLayout10.f41148b0) || (SmartRefreshLayout.this.Y0 == RefreshState.RefreshFinish && !z16)) {
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (i19 != smartRefreshLayout11.f41155e) {
                        if (smartRefreshLayout11.S0.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41251d) {
                            SmartRefreshLayout.this.S0.getView().setTranslationY(SmartRefreshLayout.this.f41155e);
                            SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                            if (smartRefreshLayout12.f41149b1 != 0 && smartRefreshLayout12.V0 != null && !smartRefreshLayout12.I(smartRefreshLayout12.f41159f0, smartRefreshLayout12.S0)) {
                                smartRefreshLayout2.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.S0.getSpinnerStyle().f41259c) {
                            View view = SmartRefreshLayout.this.S0.getView();
                            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : SmartRefreshLayout.f41145l1;
                            view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((SmartRefreshLayout.this.f41155e - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                            int i28 = marginLayoutParams.leftMargin;
                            int i29 = marginLayoutParams.topMargin + SmartRefreshLayout.this.L0;
                            view.layout(i28, i29, view.getMeasuredWidth() + i28, view.getMeasuredHeight() + i29);
                        }
                        i16 = i27;
                        i17 = i26;
                        SmartRefreshLayout.this.S0.onMoving(z16, f29, max, i26, i16);
                    } else {
                        i16 = i27;
                        i17 = i26;
                    }
                    if (z16 && SmartRefreshLayout.this.S0.isSupportHorizontalDrag()) {
                        int i36 = (int) SmartRefreshLayout.this.F;
                        int width = smartRefreshLayout2.getWidth();
                        SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                        smartRefreshLayout13.S0.onHorizontalDrag(smartRefreshLayout13.F / (width == 0 ? 1 : width), i36, width);
                    }
                } else {
                    i16 = i27;
                    i17 = i26;
                }
                SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                if (i19 != smartRefreshLayout14.f41155e && (gVar = smartRefreshLayout14.A0) != null) {
                    q3.a aVar6 = smartRefreshLayout14.S0;
                    if (aVar6 instanceof q3.d) {
                        gVar.B9((q3.d) aVar6, z16, f29, max, i17, i16);
                    }
                }
            }
            if ((i3 <= 0 || i19 < 0) && SmartRefreshLayout.this.T0 != null) {
                int i37 = -Math.min(i3, 0);
                SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                int i38 = smartRefreshLayout15.J0;
                float f36 = smartRefreshLayout15.O0;
                if (f36 < 10.0f) {
                    f36 *= i38;
                }
                int i39 = (int) f36;
                float f37 = i37 * 1.0f;
                float f38 = smartRefreshLayout15.Q0;
                if (f38 < 10.0f) {
                    f38 *= i38;
                }
                float f39 = f37 / f38;
                if (smartRefreshLayout15.H(smartRefreshLayout15.f41150c0) || (SmartRefreshLayout.this.Y0 == RefreshState.LoadFinish && !z16)) {
                    SmartRefreshLayout smartRefreshLayout16 = SmartRefreshLayout.this;
                    if (i19 != smartRefreshLayout16.f41155e) {
                        if (smartRefreshLayout16.T0.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41251d) {
                            SmartRefreshLayout.this.T0.getView().setTranslationY(SmartRefreshLayout.this.f41155e);
                            SmartRefreshLayout smartRefreshLayout17 = SmartRefreshLayout.this;
                            if (smartRefreshLayout17.f41151c1 != 0 && smartRefreshLayout17.V0 != null && !smartRefreshLayout17.I(smartRefreshLayout17.f41161g0, smartRefreshLayout17.T0)) {
                                smartRefreshLayout2.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.T0.getSpinnerStyle().f41259c) {
                            View view2 = SmartRefreshLayout.this.T0.getView();
                            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : SmartRefreshLayout.f41145l1;
                            view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-SmartRefreshLayout.this.f41155e) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0), 1073741824));
                            int i46 = marginLayoutParams2.leftMargin;
                            int measuredHeight = (marginLayoutParams2.topMargin + smartRefreshLayout2.getMeasuredHeight()) - SmartRefreshLayout.this.M0;
                            view2.layout(i46, measuredHeight - view2.getMeasuredHeight(), view2.getMeasuredWidth() + i46, measuredHeight);
                        }
                        SmartRefreshLayout.this.T0.onMoving(z16, f39, i37, i38, i39);
                    }
                    if (z16 && SmartRefreshLayout.this.T0.isSupportHorizontalDrag()) {
                        int i47 = (int) SmartRefreshLayout.this.F;
                        int width2 = smartRefreshLayout2.getWidth();
                        SmartRefreshLayout smartRefreshLayout18 = SmartRefreshLayout.this;
                        smartRefreshLayout18.T0.onHorizontalDrag(smartRefreshLayout18.F / (width2 == 0 ? 1 : width2), i47, width2);
                    }
                }
                SmartRefreshLayout smartRefreshLayout19 = SmartRefreshLayout.this;
                if (i19 != smartRefreshLayout19.f41155e && (gVar2 = smartRefreshLayout19.A0) != null) {
                    q3.a aVar7 = smartRefreshLayout19.T0;
                    if (aVar7 instanceof q3.c) {
                        gVar2.kb((q3.c) aVar7, z16, f39, i37, i38, i39);
                    }
                }
            }
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    private void e0(final ValueAnimator valueAnimator) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            QLog.w("SmartRefreshLayout", 1, "callAnimStartAt Sub thread", new Throwable());
            if (!t3.a.a().isDebugVersion()) {
                if (t3.a.a().a()) {
                    this.W0.post(new Runnable() { // from class: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout.5
                        @Override // java.lang.Runnable
                        public void run() {
                            valueAnimator.start();
                        }
                    });
                    return;
                } else {
                    valueAnimator.start();
                    return;
                }
            }
            throw new IllegalAccessError("startAnim at subThread");
        }
        valueAnimator.start();
    }

    public q3.f A(boolean z16) {
        int i3;
        long currentTimeMillis = System.currentTimeMillis() - this.f41147a1;
        if (z16) {
            i3 = Math.min(Math.max(0, 300 - ((int) currentTimeMillis)), 300) << 16;
        } else {
            i3 = 0;
        }
        return z(i3, z16, false);
    }

    public q3.f B() {
        return z(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f41147a1))), 300) << 16, true, true);
    }

    public q3.f C(int i3) {
        return D(i3, true, Boolean.FALSE);
    }

    public q3.f D(int i3, final boolean z16, final Boolean bool) {
        final int i16 = i3 >> 16;
        int i17 = (i3 << 16) >> 16;
        Runnable runnable = new Runnable() { // from class: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout.7

            /* renamed from: d, reason: collision with root package name */
            int f41195d = 0;

            @Override // java.lang.Runnable
            public void run() {
                int i18 = this.f41195d;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
                if (i18 == 0) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState = smartRefreshLayout.Y0;
                    RefreshState refreshState2 = RefreshState.None;
                    if (refreshState == refreshState2 && smartRefreshLayout.Z0 == RefreshState.Refreshing) {
                        smartRefreshLayout.Z0 = refreshState2;
                    } else {
                        ValueAnimator valueAnimator = smartRefreshLayout.f41172k1;
                        if (valueAnimator != null && refreshState.isHeader && (refreshState.isDragging || refreshState == RefreshState.RefreshReleased)) {
                            valueAnimator.setDuration(0L);
                            SmartRefreshLayout.this.f41172k1.cancel();
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            smartRefreshLayout2.f41172k1 = null;
                            if (smartRefreshLayout2.X0.animSpinner(0) == null) {
                                SmartRefreshLayout.this.M(refreshState2);
                            } else {
                                SmartRefreshLayout.this.M(RefreshState.PullDownCanceled);
                            }
                        } else if (refreshState == RefreshState.Refreshing && smartRefreshLayout.S0 != null && smartRefreshLayout.U0 != null) {
                            this.f41195d = i18 + 1;
                            smartRefreshLayout.W0.postDelayed(this, i16);
                            SmartRefreshLayout.this.M(RefreshState.RefreshFinish);
                            if (bool == Boolean.FALSE) {
                                SmartRefreshLayout.this.V(false);
                            }
                        }
                    }
                    if (bool == Boolean.TRUE) {
                        SmartRefreshLayout.this.V(true);
                        return;
                    }
                    return;
                }
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                int b16 = smartRefreshLayout3.S0.b(smartRefreshLayout3, z16);
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                g gVar = smartRefreshLayout4.A0;
                if (gVar != null) {
                    q3.a aVar = smartRefreshLayout4.S0;
                    if (aVar instanceof q3.d) {
                        gVar.Tf((q3.d) aVar, z16);
                    }
                }
                if (b16 < Integer.MAX_VALUE) {
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.J || smartRefreshLayout5.D0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        if (smartRefreshLayout6.J) {
                            float f16 = smartRefreshLayout6.G;
                            smartRefreshLayout6.E = f16;
                            smartRefreshLayout6.f41163h = 0;
                            smartRefreshLayout6.J = false;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 0, smartRefreshLayout6.F, (f16 + smartRefreshLayout6.f41155e) - (smartRefreshLayout6.f41152d * 2), 0));
                            SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 2, smartRefreshLayout7.F, smartRefreshLayout7.G + smartRefreshLayout7.f41155e, 0));
                        }
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        if (smartRefreshLayout8.D0) {
                            smartRefreshLayout8.C0 = 0;
                            SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout8.F, smartRefreshLayout8.G, 0));
                            SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                            smartRefreshLayout9.D0 = false;
                            smartRefreshLayout9.f41163h = 0;
                        }
                    }
                    SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                    int i19 = smartRefreshLayout10.f41155e;
                    if (i19 > 0) {
                        ValueAnimator t16 = smartRefreshLayout10.t(0, b16, smartRefreshLayout10.W, smartRefreshLayout10.f41174m);
                        SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                        if (smartRefreshLayout11.f41177o0) {
                            animatorUpdateListener = smartRefreshLayout11.U0.scrollContentWhenFinished(smartRefreshLayout11.f41155e);
                        }
                        if (t16 != null && animatorUpdateListener != null) {
                            t16.addUpdateListener(animatorUpdateListener);
                            return;
                        }
                        return;
                    }
                    if (i19 < 0) {
                        smartRefreshLayout10.t(0, b16, smartRefreshLayout10.W, smartRefreshLayout10.f41174m);
                    } else {
                        smartRefreshLayout10.X0.moveSpinner(0, false);
                        SmartRefreshLayout.this.X0.b(RefreshState.None);
                    }
                }
            }
        };
        if (i17 > 0) {
            this.W0.postDelayed(runnable, i17);
        } else {
            runnable.run();
        }
        return this;
    }

    public q3.f E(boolean z16) {
        if (z16) {
            return D(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f41147a1))), 300) << 16, true, Boolean.FALSE);
        }
        return D(0, false, null);
    }

    public q3.f F() {
        return D(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f41147a1))), 300) << 16, true, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean G(int i3) {
        if (i3 == 0) {
            if (this.f41172k1 != null) {
                RefreshState refreshState = this.Y0;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased || refreshState == RefreshState.RefreshReleased || refreshState == RefreshState.LoadReleased) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.X0.b(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.X0.b(RefreshState.PullUpToLoad);
                }
                this.f41172k1.setDuration(0L);
                this.f41172k1.cancel();
                this.f41172k1 = null;
            }
            this.f41170j1 = null;
        }
        if (this.f41172k1 != null) {
            return true;
        }
        return false;
    }

    protected boolean H(boolean z16) {
        if (z16 && !this.f41175m0) {
            return true;
        }
        return false;
    }

    protected boolean I(boolean z16, @Nullable q3.a aVar) {
        if (!z16 && !this.f41175m0 && aVar != null && aVar.getSpinnerStyle() != com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41253f) {
            return false;
        }
        return true;
    }

    public boolean J() {
        if (this.Y0 == RefreshState.Loading) {
            return true;
        }
        return false;
    }

    public boolean K() {
        if (this.Y0 == RefreshState.Refreshing) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(float f16, boolean z16) {
        float f17;
        double d16;
        double d17;
        double d18;
        RefreshState refreshState;
        if (this.D0 && !this.f41178p0 && f16 < 0.0f && !this.U0.canLoadMore()) {
            f17 = 0.0f;
        } else {
            f17 = f16;
        }
        RefreshState refreshState2 = this.Y0;
        if (refreshState2 == RefreshState.TwoLevel && f17 > 0.0f) {
            this.X0.moveSpinner(Math.min((int) f17, getMeasuredHeight()), true);
        } else if (refreshState2 == RefreshState.Refreshing && f17 >= 0.0f) {
            int i3 = this.H0;
            if (f17 < i3) {
                this.X0.moveSpinner((int) f17, z16);
            } else {
                float f18 = this.N0;
                if (f18 < 10.0f) {
                    f18 *= i3;
                }
                double d19 = f18 - i3;
                int max = Math.max((this.C * 4) / 3, getHeight());
                int i16 = this.H0;
                double d26 = max - i16;
                double max2 = Math.max(0.0f, (f17 - i16) * this.H);
                double d27 = -max2;
                if (d26 == 0.0d) {
                    d26 = 1.0d;
                }
                this.X0.moveSpinner(((int) Math.min(d19 * (1.0d - Math.pow(100.0d, d27 / d26)), max2)) + this.H0, z16);
            }
        } else if (f17 < 0.0f && (refreshState2 == RefreshState.Loading || ((this.f41164h0 && this.f41182t0 && this.f41183u0 && H(this.f41150c0)) || (this.f41173l0 && !this.f41182t0 && H(this.f41150c0))))) {
            int i17 = this.J0;
            if (f17 > (-i17)) {
                this.X0.moveSpinner((int) f17, z16);
            } else {
                float f19 = this.O0;
                if (f19 < 10.0f) {
                    f19 *= i17;
                }
                double d28 = f19 - i17;
                int max3 = Math.max((this.C * 4) / 3, getHeight());
                int i18 = this.J0;
                double d29 = max3 - i18;
                double d36 = -Math.min(0.0f, (i18 + f17) * this.H);
                double d37 = -d36;
                if (d29 == 0.0d) {
                    d29 = 1.0d;
                }
                this.X0.moveSpinner(((int) (-Math.min(d28 * (1.0d - Math.pow(100.0d, d37 / d29)), d36))) - this.J0, z16);
            }
        } else if (f17 >= 0.0f) {
            float f26 = this.N0;
            if (f26 < 10.0f) {
                d18 = this.H0 * f26;
            } else {
                d18 = f26;
            }
            double max4 = Math.max(this.C / 2, getHeight());
            double max5 = Math.max(0.0f, this.H * f17);
            double d38 = -max5;
            if (max4 == 0.0d) {
                max4 = 1.0d;
            }
            this.X0.moveSpinner((int) Math.min(d18 * (1.0d - Math.pow(100.0d, d38 / max4)), max5), z16);
        } else {
            float f27 = this.O0;
            if (f27 < 10.0f) {
                d16 = this.J0 * f27;
            } else {
                d16 = f27;
            }
            double max6 = Math.max(this.C / 2, getHeight());
            double d39 = -Math.min(0.0f, this.H * f17);
            double d46 = -d39;
            if (max6 == 0.0d) {
                d17 = 1.0d;
            } else {
                d17 = max6;
            }
            this.X0.moveSpinner((int) (-Math.min(d16 * (1.0d - Math.pow(100.0d, d46 / d17)), d39)), z16);
        }
        if (this.f41173l0 && !this.f41182t0 && H(this.f41150c0) && f17 < 0.0f && (refreshState = this.Y0) != RefreshState.Refreshing && refreshState != RefreshState.Loading && refreshState != RefreshState.LoadFinish) {
            if (this.f41181s0) {
                this.f41170j1 = null;
                this.X0.animSpinner(-this.J0);
            }
            a0(false);
            this.W0.postDelayed(new Runnable() { // from class: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout.6
                @Override // java.lang.Runnable
                public void run() {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    r3.e eVar = smartRefreshLayout.f41188z0;
                    if (eVar != null) {
                        eVar.E6(smartRefreshLayout);
                    } else if (smartRefreshLayout.A0 == null) {
                        smartRefreshLayout.y(2000);
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    g gVar = smartRefreshLayout2.A0;
                    if (gVar != null) {
                        gVar.E6(smartRefreshLayout2);
                    }
                }
            }, this.f41174m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(RefreshState refreshState) {
        RefreshState refreshState2 = this.Y0;
        if (refreshState2 != refreshState) {
            this.Y0 = refreshState;
            this.Z0 = refreshState;
            q3.a aVar = this.S0;
            q3.a aVar2 = this.T0;
            g gVar = this.A0;
            if (aVar != null) {
                aVar.d(this, refreshState2, refreshState);
            }
            if (aVar2 != null) {
                aVar2.d(this, refreshState2, refreshState);
            }
            if (gVar != null) {
                gVar.d(this, refreshState2, refreshState);
            }
            if (refreshState == RefreshState.LoadFinish) {
                this.f41162g1 = false;
                return;
            }
            return;
        }
        if (this.Z0 != refreshState2) {
            this.Z0 = refreshState2;
        }
    }

    protected void N() {
        RefreshState refreshState = this.Y0;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.T > -1000 && this.f41155e > getHeight() / 2) {
                ValueAnimator animSpinner = this.X0.animSpinner(getHeight());
                if (animSpinner != null) {
                    animSpinner.setDuration(this.f41166i);
                    return;
                }
                return;
            }
            if (this.J) {
                this.X0.finishTwoLevel();
                return;
            }
            return;
        }
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2 && (!this.f41164h0 || !this.f41182t0 || !this.f41183u0 || this.f41155e >= 0 || !H(this.f41150c0))) {
            RefreshState refreshState3 = this.Y0;
            RefreshState refreshState4 = RefreshState.Refreshing;
            if (refreshState3 == refreshState4) {
                int i3 = this.f41155e;
                int i16 = this.H0;
                if (i3 > i16) {
                    this.X0.animSpinner(i16);
                    return;
                } else {
                    this.X0.animSpinner(0);
                    return;
                }
            }
            if (refreshState3 == RefreshState.PullDownToRefresh) {
                this.X0.b(RefreshState.PullDownCanceled);
                return;
            }
            if (refreshState3 == RefreshState.PullUpToLoad) {
                this.X0.b(RefreshState.PullUpCanceled);
                return;
            }
            if (refreshState3 == RefreshState.ReleaseToRefresh) {
                this.X0.b(refreshState4);
                return;
            }
            if (refreshState3 == RefreshState.ReleaseToLoad) {
                this.X0.b(refreshState2);
                return;
            }
            if (refreshState3 == RefreshState.ReleaseToTwoLevel) {
                this.X0.b(RefreshState.TwoLevelReleased);
                return;
            }
            if (refreshState3 == RefreshState.RefreshReleased) {
                if (this.f41172k1 == null) {
                    this.X0.animSpinner(this.H0);
                    return;
                }
                return;
            } else if (refreshState3 == RefreshState.LoadReleased) {
                if (this.f41172k1 == null) {
                    this.X0.animSpinner(-this.J0);
                    return;
                }
                return;
            } else {
                if (refreshState3 != RefreshState.LoadFinish && this.f41155e != 0) {
                    this.X0.animSpinner(0);
                    return;
                }
                return;
            }
        }
        int i17 = this.f41155e;
        int i18 = this.J0;
        if (i17 < (-i18)) {
            this.X0.animSpinner(-i18);
        } else if (i17 > 0) {
            this.X0.animSpinner(0);
        }
    }

    public q3.f O(r3.f fVar) {
        this.A0.i(fVar);
        return this;
    }

    public q3.f P(boolean z16) {
        this.f41181s0 = z16;
        return this;
    }

    public q3.f Q(boolean z16) {
        this.f41173l0 = z16;
        return this;
    }

    public q3.f R(boolean z16) {
        this.f41164h0 = z16;
        return this;
    }

    public q3.f S(boolean z16) {
        this.f41178p0 = z16;
        q3.b bVar = this.U0;
        if (bVar != null) {
            bVar.setEnableLoadMoreWhenContentNotFull(z16);
        }
        return this;
    }

    public q3.f T(boolean z16) {
        this.f41169j0 = z16;
        return this;
    }

    public q3.f U(int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (i3 == this.H0) {
            return this;
        }
        com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar = this.I0;
        com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar2 = com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41245l;
        if (aVar.a(aVar2)) {
            this.H0 = i3;
            q3.a aVar3 = this.S0;
            if (aVar3 != null && this.f41160f1 && this.I0.f41250b) {
                com.qqnt.widget.smartrefreshlayout.layout.constant.b spinnerStyle = aVar3.getSpinnerStyle();
                if (spinnerStyle != com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41255h && !spinnerStyle.f41259c) {
                    View view = this.S0.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams = f41145l1;
                    }
                    int i16 = 0;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((this.H0 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                    int i17 = marginLayoutParams.leftMargin;
                    int i18 = marginLayoutParams.topMargin + this.L0;
                    if (spinnerStyle == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41251d) {
                        i16 = this.H0;
                    }
                    int i19 = i18 - i16;
                    view.layout(i17, i19, view.getMeasuredWidth() + i17, view.getMeasuredHeight() + i19);
                }
                float f16 = this.N0;
                if (f16 < 10.0f) {
                    f16 *= this.H0;
                }
                this.I0 = aVar2;
                this.S0.a(this.X0, this.H0, (int) f16);
            } else {
                this.I0 = com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41244k;
            }
        }
        return this;
    }

    public q3.f V(boolean z16) {
        RefreshState refreshState = this.Y0;
        if (refreshState == RefreshState.Refreshing && z16) {
            F();
        } else if (refreshState == RefreshState.Loading && z16) {
            B();
        } else if (this.f41182t0 != z16) {
            this.f41182t0 = z16;
            q3.a aVar = this.T0;
            if (aVar instanceof q3.c) {
                if (((q3.c) aVar).setNoMoreData(z16)) {
                    this.f41183u0 = true;
                    if (this.f41182t0 && this.f41164h0 && this.f41155e > 0 && this.T0.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41251d && H(this.f41150c0) && I(this.f41148b0, this.S0)) {
                        this.T0.getView().setTranslationY(this.f41155e);
                    }
                } else {
                    this.f41183u0 = false;
                    new RuntimeException("Footer:" + this.T0 + " NoMoreData is not supported.(\u4e0d\u652f\u6301NoMoreData\uff0c\u8bf7\u4f7f\u7528[ClassicsFooter]\u6216\u8005[\u81ea\u5b9a\u4e49Footer\u5e76\u5b9e\u73b0setNoMoreData\u65b9\u6cd5\u4e14\u8fd4\u56detrue])").printStackTrace();
                }
            }
        }
        return this;
    }

    public q3.f W(r3.e eVar) {
        boolean z16;
        this.f41188z0 = eVar;
        if (!this.f41150c0 && (this.f41184v0 || eVar == null)) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f41150c0 = z16;
        return this;
    }

    public q3.f X(@NonNull q3.c cVar) {
        return Y(cVar, 0, 0);
    }

    public q3.f Y(@NonNull q3.c cVar, int i3, int i16) {
        boolean z16;
        q3.a aVar;
        q3.a aVar2 = this.T0;
        if (aVar2 != null) {
            super.removeView(aVar2.getView());
        }
        this.T0 = cVar;
        this.f41162g1 = false;
        this.f41151c1 = 0;
        this.f41183u0 = false;
        this.f41157e1 = false;
        this.K0 = com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41236c;
        if (this.f41184v0 && !this.f41150c0) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f41150c0 = z16;
        if (i3 == 0) {
            i3 = -1;
        }
        if (i16 == 0) {
            i16 = -2;
        }
        LayoutParams layoutParams = new LayoutParams(i3, i16);
        ViewGroup.LayoutParams layoutParams2 = cVar.getView().getLayoutParams();
        if (layoutParams2 instanceof LayoutParams) {
            layoutParams = (LayoutParams) layoutParams2;
        }
        q3.a aVar3 = this.T0;
        if (aVar3 != null && aVar3.getSpinnerStyle().f41258b) {
            super.addView(this.T0.getView(), getChildCount(), layoutParams);
        } else {
            q3.a aVar4 = this.T0;
            if (aVar4 != null) {
                super.addView(aVar4.getView(), 0, layoutParams);
            }
        }
        int[] iArr = this.f41146a0;
        if (iArr != null && (aVar = this.T0) != null) {
            aVar.setPrimaryColors(iArr);
        }
        return this;
    }

    public q3.f Z(@NonNull q3.d dVar, int i3, int i16) {
        q3.a aVar;
        q3.a aVar2 = this.S0;
        if (aVar2 != null) {
            super.removeView(aVar2.getView());
        }
        this.S0 = dVar;
        this.f41149b1 = 0;
        this.f41154d1 = false;
        this.I0 = com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41236c;
        if (i3 == 0) {
            i3 = -1;
        }
        if (i16 == 0) {
            i16 = -2;
        }
        LayoutParams layoutParams = new LayoutParams(i3, i16);
        ViewGroup.LayoutParams layoutParams2 = dVar.getView().getLayoutParams();
        if (layoutParams2 instanceof LayoutParams) {
            layoutParams = (LayoutParams) layoutParams2;
        }
        q3.a aVar3 = this.S0;
        if (aVar3 != null && aVar3.getSpinnerStyle().f41258b) {
            super.addView(this.S0.getView(), getChildCount(), layoutParams);
        } else {
            q3.a aVar4 = this.S0;
            if (aVar4 != null) {
                super.addView(aVar4.getView(), 0, layoutParams);
            }
        }
        int[] iArr = this.f41146a0;
        if (iArr != null && (aVar = this.S0) != null) {
            aVar.setPrimaryColors(iArr);
        }
        return this;
    }

    @Override // q3.f
    public q3.f a(boolean z16) {
        this.f41148b0 = z16;
        return this;
    }

    protected void a0(boolean z16) {
        RefreshState refreshState = this.Y0;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.f41147a1 = System.currentTimeMillis();
            this.f41162g1 = true;
            M(refreshState2);
            r3.e eVar = this.f41188z0;
            if (eVar != null) {
                if (z16) {
                    eVar.E6(this);
                }
            } else if (this.A0 == null) {
                y(2000);
            }
            q3.a aVar = this.T0;
            if (aVar != null) {
                float f16 = this.O0;
                if (f16 < 10.0f) {
                    f16 *= this.J0;
                }
                aVar.f(this, this.J0, (int) f16);
            }
            g gVar = this.A0;
            if (gVar != null && (this.T0 instanceof q3.c)) {
                if (z16) {
                    gVar.E6(this);
                }
                float f17 = this.O0;
                if (f17 < 10.0f) {
                    f17 *= this.J0;
                }
                this.A0.k6((q3.c) this.T0, this.J0, (int) f17);
            }
        }
    }

    @Override // q3.f
    public q3.f b(@NonNull q3.d dVar) {
        return Z(dVar, 0, 0);
    }

    protected void b0(boolean z16) {
        b bVar = new b(z16);
        M(RefreshState.LoadReleased);
        ValueAnimator animSpinner = this.X0.animSpinner(-this.J0);
        if (animSpinner != null) {
            animSpinner.addListener(bVar);
        }
        q3.a aVar = this.T0;
        if (aVar != null) {
            float f16 = this.O0;
            if (f16 < 10.0f) {
                f16 *= this.J0;
            }
            aVar.c(this, this.J0, (int) f16);
        }
        g gVar = this.A0;
        if (gVar != null) {
            q3.a aVar2 = this.T0;
            if (aVar2 instanceof q3.c) {
                float f17 = this.O0;
                if (f17 < 10.0f) {
                    f17 *= this.J0;
                }
                gVar.Z7((q3.c) aVar2, this.J0, (int) f17);
            }
        }
        if (animSpinner == null) {
            bVar.onAnimationEnd(null);
        }
    }

    @Override // q3.f
    public q3.f c(r3.f fVar) {
        this.A0.g(fVar);
        return this;
    }

    protected void c0(boolean z16) {
        c cVar = new c(z16);
        M(RefreshState.RefreshReleased);
        ValueAnimator animSpinner = this.X0.animSpinner(this.H0);
        if (animSpinner != null) {
            animSpinner.addListener(cVar);
        }
        q3.a aVar = this.S0;
        if (aVar != null) {
            float f16 = this.N0;
            if (f16 < 10.0f) {
                f16 *= this.H0;
            }
            aVar.c(this, this.H0, (int) f16);
        }
        g gVar = this.A0;
        if (gVar != null) {
            q3.a aVar2 = this.S0;
            if (aVar2 instanceof q3.d) {
                float f17 = this.N0;
                if (f17 < 10.0f) {
                    f17 *= this.H0;
                }
                gVar.Pe((q3.d) aVar2, this.H0, (int) f17);
            }
        }
        if (animSpinner == null) {
            cVar.onAnimationEnd(null);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        float currVelocity;
        this.U.getCurrY();
        if (this.U.computeScrollOffset()) {
            int finalY = this.U.getFinalY();
            if ((finalY < 0 && ((this.f41148b0 || this.f41171k0) && this.U0.canRefresh())) || (finalY > 0 && ((this.f41150c0 || this.f41171k0) && this.U0.canLoadMore()))) {
                if (this.f41165h1) {
                    if (finalY > 0) {
                        currVelocity = -this.U.getCurrVelocity();
                    } else {
                        currVelocity = this.U.getCurrVelocity();
                    }
                    v(currVelocity);
                }
                this.U.forceFinished(true);
                return;
            }
            this.f41165h1 = true;
            invalidate();
        }
    }

    @Override // q3.f
    public q3.f d(float f16) {
        this.P0 = f16;
        return this;
    }

    protected void d0(RefreshState refreshState) {
        RefreshState refreshState2 = this.Y0;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            M(RefreshState.None);
        }
        if (this.Z0 != refreshState) {
            this.Z0 = refreshState;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c6, code lost:
    
        if (r2.isFinishing == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ca, code lost:
    
        if (r2.isHeader == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00d8, code lost:
    
        if (r2.isFinishing == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00dc, code lost:
    
        if (r2.isFooter == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0104, code lost:
    
        if (r6 != 3) goto L235;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        int i3;
        RefreshState refreshState;
        RefreshState refreshState2;
        char c16;
        RefreshState refreshState3;
        q3.a aVar;
        q3.a aVar2;
        int actionMasked = motionEvent.getActionMasked();
        int i16 = 0;
        int i17 = 1;
        if (actionMasked == 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = motionEvent.getActionIndex();
        } else {
            i3 = -1;
        }
        int pointerCount = motionEvent.getPointerCount();
        float f16 = 0.0f;
        float f17 = 0.0f;
        for (int i18 = 0; i18 < pointerCount; i18++) {
            if (i3 != i18) {
                f16 += motionEvent.getX(i18);
                f17 += motionEvent.getY(i18);
            }
        }
        if (z16) {
            pointerCount--;
        }
        float f18 = pointerCount;
        float f19 = f16 / f18;
        float f26 = f17 / f18;
        if ((actionMasked == 6 || actionMasked == 5) && this.J) {
            this.E += f26 - this.G;
        }
        this.F = f19;
        this.G = f26;
        if (this.D0) {
            int i19 = this.C0;
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (actionMasked == 2 && i19 == this.C0) {
                int i26 = (int) this.F;
                int width = getWidth();
                float f27 = this.F;
                if (width != 0) {
                    i17 = width;
                }
                float f28 = f27 / i17;
                if (H(this.f41148b0) && this.f41155e > 0 && (aVar2 = this.S0) != null && aVar2.isSupportHorizontalDrag()) {
                    this.S0.onHorizontalDrag(f28, i26, width);
                } else if (H(this.f41150c0) && this.f41155e < 0 && (aVar = this.T0) != null && aVar.isSupportHorizontalDrag()) {
                    this.T0.onHorizontalDrag(f28, i26, width);
                }
            }
            return dispatchTouchEvent;
        }
        if (isEnabled() && (this.f41148b0 || this.f41150c0 || this.f41171k0)) {
            if (this.f41154d1) {
                RefreshState refreshState4 = this.Y0;
                if (!refreshState4.isOpening) {
                }
            }
            if (this.f41157e1) {
                RefreshState refreshState5 = this.Y0;
                if (!refreshState5.isOpening) {
                }
            }
            if (G(actionMasked) || (((refreshState = this.Y0) == (refreshState2 = RefreshState.Loading) && this.f41181s0) || (refreshState == RefreshState.Refreshing && this.f41180r0))) {
                return false;
            }
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        float f29 = f19 - this.D;
                        float f36 = f26 - this.E;
                        this.V.addMovement(motionEvent);
                        if (!this.J && !this.L && (c16 = this.I) != 'h' && this.U0 != null) {
                            if (c16 != 'v' && (Math.abs(f36) < this.f41152d || Math.abs(f29) >= Math.abs(f36))) {
                                if (Math.abs(f29) >= this.f41152d && Math.abs(f29) > Math.abs(f36) && this.I != 'v') {
                                    this.I = 'h';
                                }
                            } else {
                                this.I = 'v';
                                if (f36 > 0.0f && (this.f41155e < 0 || ((this.f41171k0 || this.f41148b0) && this.U0.canRefresh()))) {
                                    this.J = true;
                                    this.E = f26 - this.f41152d;
                                } else if (f36 < 0.0f && (this.f41155e > 0 || ((this.f41171k0 || this.f41150c0) && ((this.Y0 == refreshState2 && this.f41162g1) || this.U0.canLoadMore())))) {
                                    this.J = true;
                                    this.E = this.f41152d + f26;
                                }
                                if (this.J) {
                                    f36 = f26 - this.E;
                                    if (this.K) {
                                        motionEvent.setAction(3);
                                        super.dispatchTouchEvent(motionEvent);
                                    }
                                    q3.e eVar = this.X0;
                                    int i27 = this.f41155e;
                                    if (i27 <= 0 && (i27 != 0 || f36 <= 0.0f)) {
                                        refreshState3 = RefreshState.PullUpToLoad;
                                    } else {
                                        refreshState3 = RefreshState.PullDownToRefresh;
                                    }
                                    eVar.b(refreshState3);
                                    ViewParent parent = getParent();
                                    if (parent instanceof ViewGroup) {
                                        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                    }
                                }
                            }
                        }
                        if (this.J) {
                            int i28 = ((int) f36) + this.f41163h;
                            RefreshState refreshState6 = this.Z0;
                            if ((refreshState6.isHeader && (i28 < 0 || this.f41158f < 0)) || (refreshState6.isFooter && (i28 > 0 || this.f41158f > 0))) {
                                this.f41158f = i28;
                                long eventTime = motionEvent.getEventTime();
                                if (this.f41168i1 == null) {
                                    MotionEvent obtain = MotionEvent.obtain(eventTime, eventTime, 0, this.D + f29, this.E, 0);
                                    this.f41168i1 = obtain;
                                    super.dispatchTouchEvent(obtain);
                                }
                                MotionEvent obtain2 = MotionEvent.obtain(eventTime, eventTime, 2, this.D + f29, this.E + i28, 0);
                                super.dispatchTouchEvent(obtain2);
                                if (this.f41162g1 && f36 > this.f41152d && this.f41155e < 0) {
                                    this.f41162g1 = false;
                                }
                                q3.b bVar = this.U0;
                                if (bVar != null && i28 > 0 && ((this.f41171k0 || this.f41148b0) && bVar.canRefresh())) {
                                    this.G = f26;
                                    this.E = f26;
                                    this.f41163h = 0;
                                    this.X0.b(RefreshState.PullDownToRefresh);
                                } else {
                                    q3.b bVar2 = this.U0;
                                    if (bVar2 != null && i28 < 0 && ((this.f41171k0 || this.f41150c0) && bVar2.canLoadMore())) {
                                        this.G = f26;
                                        this.E = f26;
                                        this.f41163h = 0;
                                        this.X0.b(RefreshState.PullUpToLoad);
                                    } else {
                                        i16 = i28;
                                    }
                                }
                                RefreshState refreshState7 = this.Z0;
                                if ((refreshState7.isHeader && i16 < 0) || (refreshState7.isFooter && i16 > 0)) {
                                    if (this.f41155e != 0) {
                                        L(0.0f, true);
                                    }
                                    return true;
                                }
                                if (this.f41168i1 != null) {
                                    this.f41168i1 = null;
                                    obtain2.setAction(3);
                                    super.dispatchTouchEvent(obtain2);
                                }
                                obtain2.recycle();
                                i28 = i16;
                            }
                            L(i28, true);
                            return true;
                        }
                        if (this.f41162g1 && f36 > this.f41152d && this.f41155e < 0) {
                            this.f41162g1 = false;
                        }
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
                this.V.addMovement(motionEvent);
                this.V.computeCurrentVelocity(1000, this.S);
                this.T = (int) this.V.getYVelocity();
                f0(0.0f);
                this.V.clear();
                this.I = 'n';
                MotionEvent motionEvent2 = this.f41168i1;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                    this.f41168i1 = null;
                    long eventTime2 = motionEvent.getEventTime();
                    MotionEvent obtain3 = MotionEvent.obtain(eventTime2, eventTime2, actionMasked, this.D, f26, 0);
                    super.dispatchTouchEvent(obtain3);
                    obtain3.recycle();
                }
                N();
                if (this.J) {
                    this.J = false;
                    return true;
                }
                return super.dispatchTouchEvent(motionEvent);
            }
            this.T = 0;
            this.V.addMovement(motionEvent);
            this.U.forceFinished(true);
            this.D = f19;
            this.E = f26;
            this.f41158f = 0;
            this.f41163h = this.f41155e;
            this.J = false;
            this.L = false;
            this.K = super.dispatchTouchEvent(motionEvent);
            if (this.Y0 == RefreshState.TwoLevel && this.E < getMeasuredHeight() * (1.0f - this.R0)) {
                this.I = 'h';
                return this.K;
            }
            q3.b bVar3 = this.U0;
            if (bVar3 != null) {
                bVar3.onActionDown(motionEvent);
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j3) {
        View view2;
        Paint paint;
        Paint paint2;
        q3.b bVar = this.U0;
        if (bVar != null) {
            view2 = bVar.getView();
        } else {
            view2 = null;
        }
        q3.a aVar = this.S0;
        if (aVar != null && aVar.getView() == view) {
            if (!H(this.f41148b0) || (!this.f41167i0 && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int max = Math.max(view2.getTop() + view2.getPaddingTop() + this.f41155e, view.getTop());
                int i3 = this.f41149b1;
                if (i3 != 0 && (paint2 = this.V0) != null) {
                    paint2.setColor(i3);
                    if (this.S0.getSpinnerStyle().f41259c) {
                        max = view.getBottom();
                    } else if (this.S0.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41251d) {
                        max = view.getBottom() + this.f41155e;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), max, this.V0);
                }
                if ((this.f41153d0 && this.S0.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41253f) || this.S0.getSpinnerStyle().f41259c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j3);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        q3.a aVar2 = this.T0;
        if (aVar2 != null && aVar2.getView() == view) {
            if (!H(this.f41150c0) || (!this.f41167i0 && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int min = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.f41155e, view.getBottom());
                int i16 = this.f41151c1;
                if (i16 != 0 && (paint = this.V0) != null) {
                    paint.setColor(i16);
                    if (this.T0.getSpinnerStyle().f41259c) {
                        min = view.getTop();
                    } else if (this.T0.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41251d) {
                        min = view.getTop() + this.f41155e;
                    }
                    canvas.drawRect(0.0f, min, getWidth(), view.getBottom(), this.V0);
                }
                if ((this.f41156e0 && this.T0.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41253f) || this.T0.getSpinnerStyle().f41259c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j3);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j3);
    }

    @Override // q3.f
    @Nullable
    public q3.d e() {
        q3.a aVar = this.S0;
        if (aVar instanceof q3.d) {
            return (q3.d) aVar;
        }
        return null;
    }

    @Override // q3.f
    public q3.f f(@NonNull Interpolator interpolator) {
        this.W = interpolator;
        return this;
    }

    protected boolean f0(float f16) {
        if (f16 == 0.0f) {
            f16 = this.T;
        }
        if (Math.abs(f16) > this.R) {
            int i3 = this.f41155e;
            if (i3 * f16 < 0.0f) {
                RefreshState refreshState = this.Y0;
                if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.Loading && (i3 >= 0 || !this.f41182t0)) {
                    if (refreshState.isReleaseToOpening) {
                        return true;
                    }
                } else {
                    this.f41170j1 = new FlingRunnable(f16).e();
                    return true;
                }
            }
            if ((f16 < 0.0f && ((this.f41169j0 && (this.f41150c0 || this.f41171k0)) || ((this.Y0 == RefreshState.Loading && i3 >= 0) || (this.f41173l0 && H(this.f41150c0))))) || (f16 > 0.0f && ((this.f41169j0 && this.f41148b0) || this.f41171k0 || (this.Y0 == RefreshState.Refreshing && this.f41155e <= 0)))) {
                this.f41165h1 = false;
                this.U.fling(0, 0, 0, (int) (-f16), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.U.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    @Override // q3.f
    public q3.f finishRefresh() {
        return E(true);
    }

    @Override // q3.f
    public q3.f g(float f16) {
        this.H = f16;
        return this;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.G0.getNestedScrollAxes();
    }

    @Override // q3.f
    @NonNull
    public RefreshState getState() {
        return this.Y0;
    }

    @Override // q3.f
    public boolean h(int i3, final int i16, final float f16, final boolean z16) {
        if (this.Y0 == RefreshState.None && H(this.f41148b0)) {
            Runnable runnable = new Runnable() { // from class: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout.9

                /* compiled from: P */
                /* renamed from: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout$9$a */
                /* loaded from: classes3.dex */
                class a implements ValueAnimator.AnimatorUpdateListener {
                    a() {
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.f41172k1 != null && smartRefreshLayout.S0 != null) {
                            smartRefreshLayout.X0.moveSpinner(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                        }
                    }
                }

                /* compiled from: P */
                /* renamed from: com.qqnt.widget.smartrefreshlayout.layout.SmartRefreshLayout$9$b */
                /* loaded from: classes3.dex */
                class b extends AnimatorListenerAdapter {
                    b() {
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (animator != null && animator.getDuration() == 0) {
                            return;
                        }
                        SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                        smartRefreshLayout.f41172k1 = null;
                        if (smartRefreshLayout.S0 != null) {
                            RefreshState refreshState = smartRefreshLayout.Y0;
                            RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                            if (refreshState != refreshState2) {
                                smartRefreshLayout.X0.b(refreshState2);
                            }
                            SmartRefreshLayout.this.c0(!z16);
                            return;
                        }
                        smartRefreshLayout.X0.b(RefreshState.None);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    float f17;
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (smartRefreshLayout.Z0 != RefreshState.Refreshing) {
                        return;
                    }
                    ValueAnimator valueAnimator = smartRefreshLayout.f41172k1;
                    if (valueAnimator != null) {
                        valueAnimator.setDuration(0L);
                        SmartRefreshLayout.this.f41172k1.cancel();
                        SmartRefreshLayout.this.f41172k1 = null;
                    }
                    SmartRefreshLayout.this.F = r0.getMeasuredWidth() / 2.0f;
                    SmartRefreshLayout.this.X0.b(RefreshState.PullDownToRefresh);
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    int i17 = smartRefreshLayout2.H0;
                    if (i17 == 0) {
                        f17 = smartRefreshLayout2.P0;
                    } else {
                        f17 = i17;
                    }
                    float f18 = f16;
                    if (f18 < 10.0f) {
                        f18 *= f17;
                    }
                    smartRefreshLayout2.f41172k1 = ValueAnimator.ofInt(smartRefreshLayout2.f41155e, (int) f18);
                    SmartRefreshLayout.this.f41172k1.setDuration(i16);
                    SmartRefreshLayout.this.f41172k1.setInterpolator(new t3.d(t3.d.f435348b));
                    SmartRefreshLayout.this.f41172k1.addUpdateListener(new a());
                    SmartRefreshLayout.this.f41172k1.addListener(new b());
                    SmartRefreshLayout.this.f41172k1.start();
                }
            };
            d0(RefreshState.Refreshing);
            if (i3 > 0) {
                this.W0.postDelayed(runnable, i3);
                return true;
            }
            runnable.run();
            return true;
        }
        return false;
    }

    @Override // q3.f
    public q3.f i(boolean z16) {
        setNestedScrollingEnabled(z16);
        return this;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        if (this.f41179q0 && (this.f41171k0 || this.f41148b0 || this.f41150c0)) {
            return true;
        }
        return false;
    }

    @Override // q3.f
    public q3.f j(float f16) {
        this.N0 = f16;
        q3.a aVar = this.S0;
        if (aVar != null && this.f41160f1) {
            if (f16 < 10.0f) {
                f16 *= this.H0;
            }
            aVar.a(this.X0, this.H0, (int) f16);
        } else {
            this.I0 = this.I0.c();
        }
        return this;
    }

    @Override // q3.f
    public q3.f k() {
        RefreshState refreshState;
        RefreshState refreshState2 = this.Y0;
        RefreshState refreshState3 = RefreshState.None;
        if (refreshState2 == refreshState3 && ((refreshState = this.Z0) == RefreshState.Refreshing || refreshState == RefreshState.Loading)) {
            this.Z0 = refreshState3;
        }
        if (refreshState2 == RefreshState.Refreshing) {
            finishRefresh();
        } else if (refreshState2 == RefreshState.Loading) {
            x();
        } else if (this.X0.animSpinner(0) == null) {
            M(refreshState3);
        } else if (this.Y0.isHeader) {
            M(RefreshState.PullDownCanceled);
        } else {
            M(RefreshState.PullUpCanceled);
        }
        return this;
    }

    @Override // q3.f
    public q3.f l(h hVar) {
        this.f41187y0 = hVar;
        return this;
    }

    @Override // q3.f
    public q3.f m(float f16) {
        return U(t3.d.c(f16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        q3.a aVar;
        super.onAttachedToWindow();
        boolean z16 = true;
        this.f41160f1 = true;
        if (!isInEditMode()) {
            q3.a aVar2 = this.S0;
            if (this.T0 != null) {
                if (!this.f41150c0 && this.f41184v0) {
                    z16 = false;
                }
                this.f41150c0 = z16;
            }
            if (this.U0 == null) {
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    q3.a aVar3 = this.S0;
                    if ((aVar3 == null || childAt != aVar3.getView()) && ((aVar = this.T0) == null || childAt != aVar.getView())) {
                        this.U0 = new u3.a(childAt);
                    }
                }
            }
            if (this.U0 == null) {
                int c16 = t3.d.c(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.f228206t4);
                super.addView(textView, 0, new LayoutParams(-1, -1));
                u3.a aVar4 = new u3.a(textView);
                this.U0 = aVar4;
                aVar4.getView().setPadding(c16, c16, c16, c16);
            }
            View findViewById = findViewById(this.M);
            View findViewById2 = findViewById(this.N);
            this.U0.b(this.B0);
            this.U0.setEnableLoadMoreWhenContentNotFull(this.f41178p0);
            this.U0.a(this.X0, findViewById, findViewById2);
            if (this.f41155e != 0) {
                M(RefreshState.None);
                q3.b bVar = this.U0;
                this.f41155e = 0;
                bVar.moveSpinner(0, this.P, this.Q);
            }
        }
        int[] iArr = this.f41146a0;
        if (iArr != null) {
            q3.a aVar5 = this.S0;
            if (aVar5 != null) {
                aVar5.setPrimaryColors(iArr);
            }
            q3.a aVar6 = this.T0;
            if (aVar6 != null) {
                aVar6.setPrimaryColors(this.f41146a0);
            }
        }
        q3.b bVar2 = this.U0;
        if (bVar2 != null) {
            super.bringChildToFront(bVar2.getView());
        }
        q3.a aVar7 = this.S0;
        if (aVar7 != null && aVar7.getSpinnerStyle().f41258b) {
            super.bringChildToFront(this.S0.getView());
        }
        q3.a aVar8 = this.T0;
        if (aVar8 != null && aVar8.getSpinnerStyle().f41258b) {
            super.bringChildToFront(this.T0.getView());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f41160f1 = false;
        this.f41184v0 = true;
        this.f41170j1 = null;
        ValueAnimator valueAnimator = this.f41172k1;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f41172k1.removeAllUpdateListeners();
            this.f41172k1.setDuration(0L);
            this.f41172k1.cancel();
            this.f41172k1 = null;
        }
        q3.a aVar = this.S0;
        if (aVar != null && this.Y0 == RefreshState.Refreshing) {
            aVar.b(this, false);
        }
        q3.a aVar2 = this.T0;
        if (aVar2 != null && this.Y0 == RefreshState.Loading) {
            aVar2.b(this, false);
        }
        if (this.f41155e != 0) {
            this.X0.moveSpinner(0, true);
        }
        RefreshState refreshState = this.Y0;
        RefreshState refreshState2 = RefreshState.None;
        if (refreshState != refreshState2) {
            M(refreshState2);
        }
        Handler handler = this.W0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f41162g1 = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0052  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onFinishInflate() {
        int i3;
        int i16;
        int i17;
        q3.d refreshHeaderWrapper;
        boolean z16;
        q3.c refreshFooterWrapper;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount <= 3) {
            int i18 = -1;
            int i19 = 0;
            char c16 = 0;
            while (true) {
                i3 = 2;
                if (i19 >= childCount) {
                    break;
                }
                View childAt = super.getChildAt(i19);
                if (t3.d.e(childAt) && (c16 < 2 || i19 == 1)) {
                    i18 = i19;
                    c16 = 2;
                } else if (!(childAt instanceof q3.a) && c16 < 1) {
                    if (i19 > 0) {
                        c16 = 1;
                    } else {
                        c16 = 0;
                    }
                    i18 = i19;
                }
                i19++;
            }
            if (i18 >= 0) {
                this.U0 = new u3.a(super.getChildAt(i18));
                if (i18 == 1) {
                    if (childCount != 3) {
                        i3 = -1;
                    }
                    i16 = 0;
                } else if (childCount == 2) {
                    i16 = -1;
                    i3 = 1;
                }
                for (i17 = 0; i17 < childCount; i17++) {
                    View childAt2 = super.getChildAt(i17);
                    if (i17 != i16 && (i17 == i3 || i16 != -1 || this.S0 != null || !(childAt2 instanceof q3.d))) {
                        if (i17 == i3 || (i3 == -1 && (childAt2 instanceof q3.c))) {
                            if (!this.f41150c0 && this.f41184v0) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            this.f41150c0 = z16;
                            if (childAt2 instanceof q3.c) {
                                refreshFooterWrapper = (q3.c) childAt2;
                            } else {
                                refreshFooterWrapper = new RefreshFooterWrapper(childAt2);
                            }
                            this.T0 = refreshFooterWrapper;
                        }
                    } else {
                        if (childAt2 instanceof q3.d) {
                            refreshHeaderWrapper = (q3.d) childAt2;
                        } else {
                            refreshHeaderWrapper = new RefreshHeaderWrapper(childAt2);
                        }
                        this.S0 = refreshHeaderWrapper;
                    }
                }
                return;
            }
            i16 = -1;
            i3 = -1;
            while (i17 < childCount) {
            }
            return;
        }
        throw new RuntimeException("\u6700\u591a\u53ea\u652f\u63013\u4e2a\u5b50View\uff0cMost only support three sub view");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i19;
        int i26;
        int i27;
        boolean z17;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        boolean z18;
        ViewGroup.MarginLayoutParams marginLayoutParams3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt = super.getChildAt(i28);
            if (childAt.getVisibility() != 8 && !ParseCommon.GONE.equals(childAt.getTag(R.id.f87754v8))) {
                q3.b bVar = this.U0;
                boolean z19 = true;
                if (bVar != null && bVar.getView() == childAt) {
                    if (isInEditMode() && this.f41167i0 && H(this.f41148b0) && this.S0 != null) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    View view = this.U0.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams3 = f41145l1;
                    }
                    int i29 = marginLayoutParams3.leftMargin + paddingLeft;
                    int i36 = marginLayoutParams3.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i29;
                    int measuredHeight = view.getMeasuredHeight() + i36;
                    if (z18 && I(this.f41159f0, this.S0)) {
                        int i37 = this.H0;
                        i36 += i37;
                        measuredHeight += i37;
                    }
                    view.layout(i29, i36, measuredWidth, measuredHeight);
                }
                q3.a aVar = this.S0;
                if (aVar != null && aVar.getView() == childAt) {
                    if (isInEditMode() && this.f41167i0 && H(this.f41148b0)) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    View view2 = this.S0.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    } else {
                        marginLayoutParams2 = f41145l1;
                    }
                    int i38 = marginLayoutParams2.leftMargin;
                    int i39 = marginLayoutParams2.topMargin + this.L0;
                    int measuredWidth2 = view2.getMeasuredWidth() + i38;
                    int measuredHeight2 = view2.getMeasuredHeight() + i39;
                    if (!z17 && this.S0.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41251d) {
                        int i46 = this.H0;
                        i39 -= i46;
                        measuredHeight2 -= i46;
                    }
                    view2.layout(i38, i39, measuredWidth2, measuredHeight2);
                }
                q3.a aVar2 = this.T0;
                if (aVar2 != null && aVar2.getView() == childAt) {
                    if (!isInEditMode() || !this.f41167i0 || !H(this.f41150c0)) {
                        z19 = false;
                    }
                    View view3 = this.T0.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                    } else {
                        marginLayoutParams = f41145l1;
                    }
                    com.qqnt.widget.smartrefreshlayout.layout.constant.b spinnerStyle = this.T0.getSpinnerStyle();
                    int i47 = marginLayoutParams.leftMargin;
                    int measuredHeight3 = (marginLayoutParams.topMargin + getMeasuredHeight()) - this.M0;
                    if (this.f41182t0 && this.f41183u0 && this.f41164h0 && this.U0 != null && this.T0.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41251d && H(this.f41150c0)) {
                        View view4 = this.U0.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                            i27 = ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin;
                        } else {
                            i27 = 0;
                        }
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + i27;
                    }
                    if (spinnerStyle == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41255h) {
                        measuredHeight3 = marginLayoutParams.topMargin - this.M0;
                    } else {
                        if (!z19 && spinnerStyle != com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41254g && spinnerStyle != com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41253f) {
                            if (spinnerStyle.f41259c && this.f41155e < 0) {
                                if (H(this.f41150c0)) {
                                    i26 = -this.f41155e;
                                } else {
                                    i26 = 0;
                                }
                                i19 = Math.max(i26, 0);
                            }
                        } else {
                            i19 = this.J0;
                        }
                        measuredHeight3 -= i19;
                    }
                    view3.layout(i47, measuredHeight3, view3.getMeasuredWidth() + i47, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:138:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x025e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar;
        int i26;
        int i27;
        boolean z16 = isInEditMode() && this.f41167i0;
        int childCount = super.getChildCount();
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        while (i28 < childCount) {
            View childAt = super.getChildAt(i28);
            if (childAt.getVisibility() == 8 || ParseCommon.GONE.equals(childAt.getTag(R.id.f87754v8))) {
                i17 = childCount;
            } else {
                q3.a aVar2 = this.S0;
                if (aVar2 == null || aVar2.getView() != childAt) {
                    i17 = childCount;
                } else {
                    View view = this.S0.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f41145l1;
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, layoutParams.width);
                    int i37 = this.H0;
                    com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar3 = this.I0;
                    i17 = childCount;
                    if (aVar3.f41249a < com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41242i.f41249a) {
                        int i38 = layoutParams.height;
                        if (i38 > 0) {
                            int i39 = i38 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                            com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar4 = com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41240g;
                            if (aVar3.a(aVar4)) {
                                this.H0 = layoutParams.height + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                this.I0 = aVar4;
                            }
                            i37 = i39;
                        } else if (i38 == -2 && (this.S0.getSpinnerStyle() != com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41255h || !this.I0.f41250b)) {
                            int max = Math.max((View.MeasureSpec.getSize(i16) - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0);
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE));
                            int measuredHeight = view.getMeasuredHeight();
                            if (measuredHeight > 0) {
                                if (measuredHeight != max) {
                                    com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar5 = this.I0;
                                    com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar6 = com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41238e;
                                    if (aVar5.a(aVar6)) {
                                        this.H0 = measuredHeight + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                        this.I0 = aVar6;
                                    }
                                }
                                i37 = -1;
                            }
                        }
                    }
                    if (this.S0.getSpinnerStyle() == com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41255h) {
                        i37 = View.MeasureSpec.getSize(i16);
                        i27 = -1;
                        i26 = 0;
                    } else {
                        if (!this.S0.getSpinnerStyle().f41259c || z16) {
                            i26 = 0;
                        } else {
                            i26 = 0;
                            i37 = Math.max(0, H(this.f41148b0) ? this.f41155e : 0);
                        }
                        i27 = -1;
                    }
                    if (i37 != i27) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((i37 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, i26), 1073741824));
                    }
                    com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar7 = this.I0;
                    if (!aVar7.f41250b) {
                        float f16 = this.N0;
                        if (f16 < 10.0f) {
                            f16 *= this.H0;
                        }
                        this.I0 = aVar7.b();
                        this.S0.a(this.X0, this.H0, (int) f16);
                    }
                    if (z16 && H(this.f41148b0)) {
                        i29 += view.getMeasuredWidth();
                        i36 += view.getMeasuredHeight();
                    }
                }
                q3.a aVar8 = this.T0;
                if (aVar8 == null || aVar8.getView() != childAt) {
                    i18 = 0;
                } else {
                    View view2 = this.T0.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : f41145l1;
                    int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, layoutParams2.width);
                    int i46 = this.J0;
                    com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar9 = this.K0;
                    if (aVar9.f41249a < com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41242i.f41249a) {
                        int i47 = layoutParams2.height;
                        if (i47 > 0) {
                            i46 = marginLayoutParams2.bottomMargin + i47 + marginLayoutParams2.topMargin;
                            com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar10 = com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41240g;
                            if (aVar9.a(aVar10)) {
                                this.J0 = layoutParams2.height + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                this.K0 = aVar10;
                            }
                        } else if (i47 == -2 && (this.T0.getSpinnerStyle() != com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41255h || !this.K0.f41250b)) {
                            int max2 = Math.max((View.MeasureSpec.getSize(i16) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0);
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(max2, Integer.MIN_VALUE));
                            int measuredHeight2 = view2.getMeasuredHeight();
                            if (measuredHeight2 > 0) {
                                if (measuredHeight2 != max2) {
                                    com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar11 = this.K0;
                                    com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar12 = com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41238e;
                                    if (aVar11.a(aVar12)) {
                                        this.J0 = measuredHeight2 + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                        this.K0 = aVar12;
                                    }
                                }
                                i19 = -1;
                                if (this.T0.getSpinnerStyle() != com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41255h) {
                                    i19 = View.MeasureSpec.getSize(i16);
                                } else if (this.T0.getSpinnerStyle().f41259c && !z16) {
                                    i18 = 0;
                                    i19 = Math.max(0, H(this.f41150c0) ? -this.f41155e : 0);
                                    if (i19 != -1) {
                                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((i19 - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i18), 1073741824));
                                    }
                                    aVar = this.K0;
                                    if (!aVar.f41250b) {
                                        float f17 = this.O0;
                                        if (f17 < 10.0f) {
                                            f17 *= this.J0;
                                        }
                                        this.K0 = aVar.b();
                                        this.T0.a(this.X0, this.J0, (int) f17);
                                    }
                                    if (z16 && H(this.f41150c0)) {
                                        i29 += view2.getMeasuredWidth();
                                        i36 += view2.getMeasuredHeight();
                                    }
                                }
                                i18 = 0;
                                if (i19 != -1) {
                                }
                                aVar = this.K0;
                                if (!aVar.f41250b) {
                                }
                                if (z16) {
                                    i29 += view2.getMeasuredWidth();
                                    i36 += view2.getMeasuredHeight();
                                }
                            }
                        }
                    }
                    i19 = i46;
                    if (this.T0.getSpinnerStyle() != com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41255h) {
                    }
                    i18 = 0;
                    if (i19 != -1) {
                    }
                    aVar = this.K0;
                    if (!aVar.f41250b) {
                    }
                    if (z16) {
                    }
                }
                q3.b bVar = this.U0;
                if (bVar != null && bVar.getView() == childAt) {
                    View view3 = this.U0.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : f41145l1;
                    view3.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i16, getPaddingTop() + getPaddingBottom() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin + ((!z16 || ((this.S0 == null || !H(this.f41148b0) || !I(this.f41159f0, this.S0)) ? i18 : 1) == 0) ? i18 : this.H0) + ((!z16 || ((this.T0 == null || !H(this.f41150c0) || !I(this.f41161g0, this.T0)) ? i18 : 1) == 0) ? i18 : this.J0), layoutParams3.height));
                    i29 += view3.getMeasuredWidth() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin;
                    i36 += view3.getMeasuredHeight() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin;
                }
            }
            i28++;
            childCount = i17;
        }
        super.setMeasuredDimension(View.resolveSize(Math.max(i29 + getPaddingLeft() + getPaddingRight(), super.getSuggestedMinimumWidth()), i3), View.resolveSize(Math.max(i36 + getPaddingTop() + getPaddingBottom(), super.getSuggestedMinimumHeight()), i16));
        this.F = getMeasuredWidth() / 2.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f16, float f17, boolean z16) {
        return this.F0.dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f16, float f17) {
        if ((!this.f41162g1 || f17 <= 0.0f) && !f0(-f17) && !this.F0.dispatchNestedPreFling(f16, f17)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr) {
        int i17 = this.C0;
        int i18 = 0;
        if (i16 * i17 > 0) {
            if (Math.abs(i16) > Math.abs(this.C0)) {
                int i19 = this.C0;
                this.C0 = 0;
                i18 = i19;
            } else {
                this.C0 -= i16;
                i18 = i16;
            }
            L(this.C0, true);
        } else if (i16 > 0 && this.f41162g1) {
            int i26 = i17 - i16;
            this.C0 = i26;
            L(i26, true);
            i18 = i16;
        }
        this.F0.dispatchNestedPreScroll(i3, i16 - i18, iArr, null);
        iArr[1] = iArr[1] + i18;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18) {
        j jVar;
        RefreshState refreshState;
        ViewParent parent;
        j jVar2;
        boolean dispatchNestedScroll = this.F0.dispatchNestedScroll(i3, i16, i17, i18, this.E0);
        int i19 = i18 + this.E0[1];
        if ((i19 < 0 && ((this.f41148b0 || this.f41171k0) && (this.C0 != 0 || (jVar2 = this.B0) == null || jVar2.canRefresh(this.U0.getView())))) || (i19 > 0 && ((this.f41150c0 || this.f41171k0) && (this.C0 != 0 || (jVar = this.B0) == null || jVar.canLoadMore(this.U0.getView()))))) {
            RefreshState refreshState2 = this.Z0;
            if (refreshState2 == RefreshState.None || refreshState2.isOpening) {
                q3.e eVar = this.X0;
                if (i19 > 0) {
                    refreshState = RefreshState.PullUpToLoad;
                } else {
                    refreshState = RefreshState.PullDownToRefresh;
                }
                eVar.b(refreshState);
                if (!dispatchNestedScroll && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i26 = this.C0 - i19;
            this.C0 = i26;
            L(i26, true);
        }
        if (this.f41162g1 && i16 < 0) {
            this.f41162g1 = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3) {
        this.G0.onNestedScrollAccepted(view, view2, i3);
        this.F0.startNestedScroll(i3 & 2);
        this.C0 = this.f41155e;
        this.D0 = true;
        G(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3) {
        boolean z16;
        if (isEnabled() && isNestedScrollingEnabled() && (i3 & 2) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (this.f41171k0 || this.f41148b0 || this.f41150c0)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.G0.onStopNestedScroll(view);
        this.D0 = false;
        this.C0 = 0;
        N();
        this.F0.stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z16) {
        if (ViewCompat.isNestedScrollingEnabled(this.U0.getScrollableView())) {
            this.L = z16;
            super.requestDisallowInterceptTouchEvent(z16);
        }
    }

    @Override // q3.f
    public q3.f setEnableLoadMore(boolean z16) {
        this.f41184v0 = true;
        this.f41150c0 = z16;
        return this;
    }

    @Override // q3.f
    public q3.f setEnableOverScrollDrag(boolean z16) {
        this.f41171k0 = z16;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z16) {
        this.f41179q0 = z16;
        this.F0.setNestedScrollingEnabled(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ValueAnimator t(int i3, int i16, Interpolator interpolator, int i17) {
        return u(i3, i16, interpolator, i17, false, null);
    }

    protected ValueAnimator u(int i3, int i16, Interpolator interpolator, int i17, boolean z16, Animator.AnimatorListener animatorListener) {
        if (this.f41155e == i3) {
            return null;
        }
        ValueAnimator valueAnimator = this.f41172k1;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.f41172k1.cancel();
            this.f41172k1 = null;
        }
        this.f41170j1 = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f41155e, i3);
        this.f41172k1 = ofInt;
        ofInt.setDuration(i17);
        this.f41172k1.setInterpolator(interpolator);
        this.f41172k1.addListener(new d());
        this.f41172k1.addUpdateListener(new e(z16));
        if (animatorListener != null) {
            this.f41172k1.addListener(animatorListener);
        }
        this.f41172k1.setStartDelay(i16);
        e0(this.f41172k1);
        return this.f41172k1;
    }

    protected void v(float f16) {
        RefreshState refreshState;
        if (this.f41172k1 == null) {
            if (f16 > 0.0f && ((refreshState = this.Y0) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
                this.f41170j1 = new BounceRunnable(f16, this.H0);
                return;
            }
            if (f16 < 0.0f && (this.Y0 == RefreshState.Loading || ((this.f41164h0 && this.f41182t0 && this.f41183u0 && H(this.f41150c0)) || (this.f41173l0 && !this.f41182t0 && H(this.f41150c0) && this.Y0 != RefreshState.Refreshing)))) {
                this.f41170j1 = new BounceRunnable(f16, -this.J0);
            } else if (this.f41155e == 0 && this.f41169j0) {
                this.f41170j1 = new BounceRunnable(f16, 0);
            }
        }
    }

    public boolean w() {
        return this.f41150c0;
    }

    public q3.f x() {
        return A(true);
    }

    public q3.f y(int i3) {
        return z(i3, true, false);
    }

    public q3.f z(int i3, boolean z16, boolean z17) {
        int i16 = i3 >> 16;
        int i17 = (i3 << 16) >> 16;
        AnonymousClass8 anonymousClass8 = new AnonymousClass8(i16, z17, z16);
        if (i17 > 0) {
            this.W0.postDelayed(anonymousClass8, i17);
        } else {
            anonymousClass8.run();
        }
        return this;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41166i = 300;
        this.f41174m = 300;
        this.H = 0.5f;
        this.I = 'n';
        this.M = -1;
        this.N = -1;
        this.P = -1;
        this.Q = -1;
        this.f41148b0 = true;
        this.f41150c0 = false;
        this.f41153d0 = true;
        this.f41156e0 = true;
        this.f41159f0 = true;
        this.f41161g0 = true;
        this.f41164h0 = false;
        this.f41167i0 = true;
        this.f41169j0 = true;
        this.f41171k0 = false;
        this.f41173l0 = true;
        this.f41175m0 = false;
        this.f41176n0 = true;
        this.f41177o0 = true;
        this.f41178p0 = true;
        this.f41179q0 = true;
        this.f41180r0 = false;
        this.f41181s0 = false;
        this.f41182t0 = false;
        this.f41183u0 = false;
        this.f41184v0 = false;
        this.f41185w0 = false;
        this.f41186x0 = false;
        this.A0 = new g();
        this.E0 = new int[2];
        this.F0 = new NestedScrollingChildHelper(this);
        this.G0 = new NestedScrollingParentHelper(this);
        com.qqnt.widget.smartrefreshlayout.layout.constant.a aVar = com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41236c;
        this.I0 = aVar;
        this.K0 = aVar;
        this.N0 = 2.5f;
        this.O0 = 2.5f;
        this.P0 = 1.0f;
        this.Q0 = 1.0f;
        this.R0 = 0.16666667f;
        this.X0 = new f();
        RefreshState refreshState = RefreshState.None;
        this.Y0 = refreshState;
        this.Z0 = refreshState;
        this.f41147a1 = 0L;
        this.f41149b1 = 0;
        this.f41151c1 = 0;
        this.f41162g1 = false;
        this.f41165h1 = false;
        this.f41168i1 = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.W0 = new Handler(Looper.getMainLooper());
        this.U = new Scroller(context);
        this.V = VelocityTracker.obtain();
        this.C = context.getResources().getDisplayMetrics().heightPixels;
        this.W = new t3.d(t3.d.f435348b);
        this.f41152d = viewConfiguration.getScaledTouchSlop();
        this.R = viewConfiguration.getScaledMinimumFlingVelocity();
        this.S = viewConfiguration.getScaledMaximumFlingVelocity();
        this.J0 = t3.d.c(60.0f);
        this.H0 = t3.d.c(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p3.a.f425010c1);
        if (!obtainStyledAttributes.hasValue(p3.a.f425018e1)) {
            super.setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(p3.a.f425014d1)) {
            super.setClipChildren(false);
        }
        this.H = obtainStyledAttributes.getFloat(p3.a.f425034i1, this.H);
        this.N0 = obtainStyledAttributes.getFloat(p3.a.J1, this.N0);
        this.O0 = obtainStyledAttributes.getFloat(p3.a.E1, this.O0);
        this.P0 = obtainStyledAttributes.getFloat(p3.a.L1, this.P0);
        this.Q0 = obtainStyledAttributes.getFloat(p3.a.G1, this.Q0);
        this.f41148b0 = obtainStyledAttributes.getBoolean(p3.a.f425087x1, this.f41148b0);
        this.f41174m = obtainStyledAttributes.getInt(p3.a.N1, this.f41174m);
        int i3 = p3.a.f425066q1;
        this.f41150c0 = obtainStyledAttributes.getBoolean(i3, this.f41150c0);
        int i16 = p3.a.H1;
        this.H0 = obtainStyledAttributes.getDimensionPixelOffset(i16, this.H0);
        int i17 = p3.a.C1;
        this.J0 = obtainStyledAttributes.getDimensionPixelOffset(i17, this.J0);
        this.L0 = obtainStyledAttributes.getDimensionPixelOffset(p3.a.I1, this.L0);
        this.M0 = obtainStyledAttributes.getDimensionPixelOffset(p3.a.D1, this.M0);
        this.f41180r0 = obtainStyledAttributes.getBoolean(p3.a.f425030h1, this.f41180r0);
        this.f41181s0 = obtainStyledAttributes.getBoolean(p3.a.f425026g1, this.f41181s0);
        int i18 = p3.a.f425062p1;
        this.f41159f0 = obtainStyledAttributes.getBoolean(i18, this.f41159f0);
        int i19 = p3.a.f425058o1;
        this.f41161g0 = obtainStyledAttributes.getBoolean(i19, this.f41161g0);
        this.f41167i0 = obtainStyledAttributes.getBoolean(p3.a.f425081v1, this.f41167i0);
        this.f41173l0 = obtainStyledAttributes.getBoolean(p3.a.f425038j1, this.f41173l0);
        this.f41169j0 = obtainStyledAttributes.getBoolean(p3.a.f425075t1, this.f41169j0);
        this.f41175m0 = obtainStyledAttributes.getBoolean(p3.a.f425084w1, this.f41175m0);
        this.f41176n0 = obtainStyledAttributes.getBoolean(p3.a.f425090y1, this.f41176n0);
        this.f41177o0 = obtainStyledAttributes.getBoolean(p3.a.f425093z1, this.f41177o0);
        this.f41178p0 = obtainStyledAttributes.getBoolean(p3.a.f425069r1, this.f41178p0);
        boolean z16 = obtainStyledAttributes.getBoolean(p3.a.f425050m1, this.f41164h0);
        this.f41164h0 = z16;
        this.f41164h0 = obtainStyledAttributes.getBoolean(p3.a.f425054n1, z16);
        this.f41153d0 = obtainStyledAttributes.getBoolean(p3.a.f425046l1, this.f41153d0);
        this.f41156e0 = obtainStyledAttributes.getBoolean(p3.a.f425042k1, this.f41156e0);
        this.f41171k0 = obtainStyledAttributes.getBoolean(p3.a.f425078u1, this.f41171k0);
        this.M = obtainStyledAttributes.getResourceId(p3.a.B1, this.M);
        this.N = obtainStyledAttributes.getResourceId(p3.a.A1, this.N);
        this.P = obtainStyledAttributes.getResourceId(p3.a.K1, this.P);
        this.Q = obtainStyledAttributes.getResourceId(p3.a.F1, this.Q);
        boolean z17 = obtainStyledAttributes.getBoolean(p3.a.f425072s1, this.f41179q0);
        this.f41179q0 = z17;
        this.F0.setNestedScrollingEnabled(z17);
        this.f41184v0 = this.f41184v0 || obtainStyledAttributes.hasValue(i3);
        this.f41185w0 = this.f41185w0 || obtainStyledAttributes.hasValue(i18);
        this.f41186x0 = this.f41186x0 || obtainStyledAttributes.hasValue(i19);
        this.I0 = obtainStyledAttributes.hasValue(i16) ? com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41242i : this.I0;
        this.K0 = obtainStyledAttributes.hasValue(i17) ? com.qqnt.widget.smartrefreshlayout.layout.constant.a.f41242i : this.K0;
        int color = obtainStyledAttributes.getColor(p3.a.f425022f1, 0);
        int color2 = obtainStyledAttributes.getColor(p3.a.M1, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.f41146a0 = new int[]{color2, color};
            } else {
                this.f41146a0 = new int[]{color2};
            }
        } else if (color != 0) {
            this.f41146a0 = new int[]{0, color};
        }
        if (this.f41175m0 && !this.f41184v0 && !this.f41150c0) {
            this.f41150c0 = true;
        }
        obtainStyledAttributes.recycle();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f41223a;

        /* renamed from: b, reason: collision with root package name */
        public com.qqnt.widget.smartrefreshlayout.layout.constant.b f41224b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f41223a = 0;
            this.f41224b = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p3.a.O1);
            this.f41223a = obtainStyledAttributes.getColor(p3.a.P1, this.f41223a);
            int i3 = p3.a.Q1;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.f41224b = com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41256i[obtainStyledAttributes.getInt(i3, com.qqnt.widget.smartrefreshlayout.layout.constant.b.f41251d.f41257a)];
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.f41223a = 0;
            this.f41224b = null;
        }
    }

    @Override // q3.f
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    public static void setDefaultRefreshFooterCreator(@NonNull r3.b bVar) {
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull r3.c cVar) {
    }

    public static void setDefaultRefreshInitializer(@NonNull r3.d dVar) {
    }
}
