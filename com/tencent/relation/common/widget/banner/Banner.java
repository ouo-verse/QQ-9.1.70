package com.tencent.relation.common.widget.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.relation.common.widget.banner.adapter.d;
import com.tencent.relation.common.widget.banner.indicator.IndicatorConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Banner<T, BA extends d<T, ? extends RecyclerView.ViewHolder>> extends FrameLayout implements pz3.a {
    static IPatchRedirector $redirector_;
    private Banner<T, BA>.b C;
    private boolean D;
    private boolean E;
    private long F;
    private int G;
    private int H;
    private float I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private int N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f364791a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f364792b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f364793c0;

    /* renamed from: d, reason: collision with root package name */
    private ViewPager2 f364794d;

    /* renamed from: d0, reason: collision with root package name */
    private int f364795d0;

    /* renamed from: e, reason: collision with root package name */
    private AutoLoopTask f364796e;

    /* renamed from: e0, reason: collision with root package name */
    private int f364797e0;

    /* renamed from: f, reason: collision with root package name */
    private qz3.b f364798f;

    /* renamed from: f0, reason: collision with root package name */
    private int f364799f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f364800g0;

    /* renamed from: h, reason: collision with root package name */
    private BA f364801h;

    /* renamed from: h0, reason: collision with root package name */
    private float f364802h0;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.relation.common.widget.banner.indicator.a f364803i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f364804i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f364805j0;

    /* renamed from: k0, reason: collision with root package name */
    private Paint f364806k0;

    /* renamed from: l0, reason: collision with root package name */
    private Paint f364807l0;

    /* renamed from: m, reason: collision with root package name */
    private CompositePageTransformer f364808m;

    /* renamed from: m0, reason: collision with root package name */
    private final RecyclerView.AdapterDataObserver f364809m0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class AutoLoopTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<Banner> f364810d;

        AutoLoopTask(Banner banner) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) banner);
            } else {
                this.f364810d = new WeakReference<>(banner);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int p16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Banner banner = this.f364810d.get();
            if (banner == null || !banner.E || (p16 = banner.p()) == 0) {
                return;
            }
            banner.C((banner.m() + 1) % p16);
            banner.postDelayed(banner.f364796e, banner.F);
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes25.dex */
    public @interface Orientation {
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends RecyclerView.AdapterDataObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Banner.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (Banner.this.p() <= 1) {
                Banner.this.V();
            } else {
                Banner.this.U();
            }
            Banner.this.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class b extends ViewPager2.OnPageChangeCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        private int f364812b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f364813c;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Banner.this);
            } else {
                this.f364812b = -1;
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            if (i3 != 1 && i3 != 2) {
                if (i3 == 0) {
                    this.f364813c = false;
                    if (this.f364812b != -1 && Banner.this.D) {
                        int i16 = this.f364812b;
                        if (i16 == 0) {
                            Banner banner = Banner.this;
                            banner.D(banner.q(), false);
                        } else if (i16 == Banner.this.p() - 1) {
                            Banner.this.D(1, false);
                        }
                    }
                }
            } else {
                this.f364813c = true;
            }
            if (Banner.this.f364798f != null) {
                Banner.this.f364798f.onPageScrollStateChanged(i3);
            }
            if (Banner.this.n() != null) {
                Banner.this.n().onPageScrollStateChanged(i3);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i3, float f16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
                return;
            }
            int a16 = com.tencent.relation.common.widget.banner.util.a.a(Banner.this.y(), i3, Banner.this.q());
            if (Banner.this.f364798f != null && a16 == Banner.this.m() - 1) {
                Banner.this.f364798f.onPageScrolled(a16, f16, i16);
            }
            if (Banner.this.n() != null && a16 == Banner.this.m() - 1) {
                Banner.this.n().onPageScrolled(a16, f16, i16);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (this.f364813c) {
                this.f364812b = i3;
                int a16 = com.tencent.relation.common.widget.banner.util.a.a(Banner.this.y(), i3, Banner.this.q());
                if (Banner.this.f364798f != null) {
                    Banner.this.f364798f.onPageSelected(a16);
                }
                if (Banner.this.n() != null) {
                    Banner.this.n().onPageSelected(a16);
                }
            }
        }
    }

    public Banner(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void Q() {
        int i3 = 0;
        if (!y()) {
            x(false);
        }
        if (y()) {
            i3 = this.H;
        }
        T(i3);
    }

    private void h(Canvas canvas) {
        int height = getHeight();
        Path path = new Path();
        float f16 = height;
        path.moveTo(0.0f, f16 - this.I);
        path.lineTo(0.0f, f16);
        path.lineTo(this.I, f16);
        float f17 = this.I;
        path.arcTo(new RectF(0.0f, f16 - (f17 * 2.0f), f17 * 2.0f, f16), 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f364806k0);
    }

    private void i(Canvas canvas) {
        int height = getHeight();
        int width = getWidth();
        Path path = new Path();
        float f16 = width;
        float f17 = height;
        path.moveTo(f16 - this.I, f17);
        path.lineTo(f16, f17);
        path.lineTo(f16, f17 - this.I);
        float f18 = this.I;
        path.arcTo(new RectF(f16 - (f18 * 2.0f), f17 - (f18 * 2.0f), f16, f17), 0.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.f364806k0);
    }

    private void j(Canvas canvas) {
        Path path = new Path();
        path.moveTo(0.0f, this.I);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.I, 0.0f);
        float f16 = this.I;
        path.arcTo(new RectF(0.0f, 0.0f, f16 * 2.0f, f16 * 2.0f), -90.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.f364806k0);
    }

    private void k(Canvas canvas) {
        int width = getWidth();
        Path path = new Path();
        float f16 = width;
        path.moveTo(f16 - this.I, 0.0f);
        path.lineTo(f16, 0.0f);
        path.lineTo(f16, this.I);
        float f17 = this.I;
        path.arcTo(new RectF(f16 - (f17 * 2.0f), 0.0f, f16, f17 * 2.0f), 0.0f, -90.0f);
        path.close();
        canvas.drawPath(path, this.f364806k0);
    }

    private void t(Context context) {
        this.f364799f0 = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.f364808m = new CompositePageTransformer();
        this.C = new b();
        this.f364796e = new AutoLoopTask(this);
        ViewPager2 viewPager2 = new ViewPager2(context);
        this.f364794d = viewPager2;
        viewPager2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f364794d.setOffscreenPageLimit(2);
        this.f364794d.registerOnPageChangeCallback(this.C);
        this.f364794d.setPageTransformer(this.f364808m);
        com.tencent.relation.common.widget.banner.util.b.r(this);
        addView(this.f364794d);
        Paint paint = new Paint();
        this.f364806k0 = paint;
        paint.setColor(-1);
        this.f364806k0.setAntiAlias(true);
        this.f364806k0.setStyle(Paint.Style.FILL);
        this.f364806k0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f364807l0 = paint2;
        paint2.setXfermode(null);
    }

    private void u() {
        if (n() != null && l() != null) {
            if (n().c().j()) {
                z();
                addView(n().b());
            }
            v();
            L();
        }
    }

    private void v() {
        int i3 = this.U;
        if (i3 != 0) {
            I(new IndicatorConfig.a(i3));
        } else {
            int i16 = this.V;
            if (i16 != 0 || this.W != 0 || this.f364791a0 != 0 || this.f364792b0 != 0) {
                I(new IndicatorConfig.a(i16, this.W, this.f364791a0, this.f364792b0));
            }
        }
        int i17 = this.T;
        if (i17 > 0) {
            P(i17);
        }
        int i18 = this.S;
        if (i18 != 1) {
            G(i18);
        }
        int i19 = this.N;
        if (i19 > 0) {
            K(i19);
        }
        int i26 = this.P;
        if (i26 > 0) {
            O(i26);
        }
        int i27 = this.f364793c0;
        if (i27 > 0) {
            H(i27);
        }
        int i28 = this.f364795d0;
        if (i28 > 0) {
            M(i28);
        }
        J(this.Q);
        N(this.R);
    }

    private void w(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, oz3.b.A);
            this.I = obtainStyledAttributes.getDimensionPixelSize(oz3.b.S, 0);
            this.F = obtainStyledAttributes.getInt(oz3.b.Q, 3000);
            this.E = obtainStyledAttributes.getBoolean(oz3.b.B, true);
            this.D = obtainStyledAttributes.getBoolean(oz3.b.P, true);
            this.N = obtainStyledAttributes.getDimensionPixelSize(oz3.b.K, com.tencent.relation.common.widget.banner.config.a.f364823a);
            this.P = obtainStyledAttributes.getDimensionPixelSize(oz3.b.N, com.tencent.relation.common.widget.banner.config.a.f364824b);
            this.Q = obtainStyledAttributes.getColor(oz3.b.J, -1996488705);
            this.R = obtainStyledAttributes.getColor(oz3.b.M, -2013265920);
            this.S = obtainStyledAttributes.getInt(oz3.b.C, 1);
            this.T = obtainStyledAttributes.getDimensionPixelSize(oz3.b.O, 0);
            this.U = obtainStyledAttributes.getDimensionPixelSize(oz3.b.E, 0);
            this.V = obtainStyledAttributes.getDimensionPixelSize(oz3.b.G, 0);
            this.W = obtainStyledAttributes.getDimensionPixelSize(oz3.b.I, 0);
            this.f364791a0 = obtainStyledAttributes.getDimensionPixelSize(oz3.b.H, 0);
            this.f364792b0 = obtainStyledAttributes.getDimensionPixelSize(oz3.b.F, 0);
            this.f364793c0 = obtainStyledAttributes.getDimensionPixelSize(oz3.b.D, com.tencent.relation.common.widget.banner.config.a.f364827e);
            this.f364795d0 = obtainStyledAttributes.getDimensionPixelSize(oz3.b.L, com.tencent.relation.common.widget.banner.config.a.f364828f);
            this.f364797e0 = obtainStyledAttributes.getInt(oz3.b.R, 0);
            this.J = obtainStyledAttributes.getBoolean(oz3.b.V, false);
            this.K = obtainStyledAttributes.getBoolean(oz3.b.W, false);
            this.L = obtainStyledAttributes.getBoolean(oz3.b.T, false);
            this.M = obtainStyledAttributes.getBoolean(oz3.b.U, false);
            obtainStyledAttributes.recycle();
        }
        S(this.f364797e0);
        Q();
    }

    public Banner A(BA ba5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (Banner) iPatchRedirector.redirect((short) 37, (Object) this, (Object) ba5);
        }
        if (ba5 != null) {
            this.f364801h = ba5;
            if (!y()) {
                l().r0(0);
            }
            l().registerAdapterDataObserver(this.f364809m0);
            this.f364794d.setAdapter(ba5);
            D(this.H, false);
            u();
            return this;
        }
        throw new NullPointerException(getContext().getString(R.string.zdb));
    }

    public Banner B(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (Banner) iPatchRedirector.redirect((short) 44, this, Float.valueOf(f16));
        }
        this.I = f16;
        return this;
    }

    public Banner C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Banner) iPatchRedirector.redirect((short) 19, (Object) this, i3);
        }
        return D(i3, true);
    }

    public Banner D(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (Banner) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
        s().setCurrentItem(i3, z16);
        return this;
    }

    public Banner E(com.tencent.relation.common.widget.banner.indicator.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (Banner) iPatchRedirector.redirect((short) 50, (Object) this, (Object) aVar);
        }
        return F(aVar, true);
    }

    public Banner F(com.tencent.relation.common.widget.banner.indicator.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (Banner) iPatchRedirector.redirect((short) 51, this, aVar, Boolean.valueOf(z16));
        }
        z();
        aVar.c().k(z16);
        this.f364803i = aVar;
        u();
        return this;
    }

    public Banner G(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (Banner) iPatchRedirector.redirect((short) 56, (Object) this, i3);
        }
        if (o() != null && o().j()) {
            o().m(i3);
            n().b().postInvalidate();
        }
        return this;
    }

    public Banner H(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (Banner) iPatchRedirector.redirect((short) 63, (Object) this, i3);
        }
        if (o() != null) {
            o().n(i3);
        }
        return this;
    }

    public Banner I(IndicatorConfig.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (Banner) iPatchRedirector.redirect((short) 58, (Object) this, (Object) aVar);
        }
        if (o() != null && o().j()) {
            o().q(aVar);
            n().b().requestLayout();
        }
        return this;
    }

    public Banner J(@ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return (Banner) iPatchRedirector.redirect((short) 54, (Object) this, i3);
        }
        if (o() != null) {
            o().r(i3);
        }
        return this;
    }

    public Banner K(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (Banner) iPatchRedirector.redirect((short) 60, (Object) this, i3);
        }
        if (o() != null) {
            o().s(i3);
        }
        return this;
    }

    public Banner L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Banner) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        if (n() != null) {
            n().a(q(), com.tencent.relation.common.widget.banner.util.a.a(y(), m(), q()));
        }
        return this;
    }

    public Banner M(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (Banner) iPatchRedirector.redirect((short) 62, (Object) this, i3);
        }
        if (o() != null) {
            o().t(i3);
        }
        return this;
    }

    public Banner N(@ColorInt int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (Banner) iPatchRedirector.redirect((short) 52, (Object) this, i3);
        }
        if (o() != null) {
            o().u(i3);
        }
        return this;
    }

    public Banner O(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (Banner) iPatchRedirector.redirect((short) 61, (Object) this, i3);
        }
        if (o() != null) {
            o().v(i3);
        }
        return this;
    }

    public Banner P(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (Banner) iPatchRedirector.redirect((short) 57, (Object) this, i3);
        }
        if (o() != null) {
            o().p(i3);
        }
        return this;
    }

    public Banner R(qz3.a<T> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (Banner) iPatchRedirector.redirect((short) 42, (Object) this, (Object) aVar);
        }
        if (l() != null) {
            l().s0(aVar);
        }
        return this;
    }

    public Banner S(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (Banner) iPatchRedirector.redirect((short) 40, (Object) this, i3);
        }
        s().setOrientation(i3);
        return this;
    }

    public Banner T(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Banner) iPatchRedirector.redirect((short) 23, (Object) this, i3);
        }
        this.H = i3;
        return this;
    }

    public Banner U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (Banner) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        if (this.E) {
            V();
            postDelayed(this.f364796e, this.F);
        }
        return this;
    }

    public Banner V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (Banner) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        if (this.E) {
            removeCallbacks(this.f364796e);
        }
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        if (this.I > 0.0f) {
            canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.f364807l0, 31);
            super.dispatchDraw(canvas);
            if (!this.K && !this.J && !this.M && !this.L) {
                j(canvas);
                k(canvas);
                h(canvas);
                i(canvas);
                canvas.restore();
                return;
            }
            if (this.J) {
                j(canvas);
            }
            if (this.K) {
                k(canvas);
            }
            if (this.L) {
                h(canvas);
            }
            if (this.M) {
                i(canvas);
            }
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!s().isUserInputEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3 && actionMasked != 4) {
            if (actionMasked == 0) {
                V();
            }
        } else {
            U();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Banner f(qz3.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (Banner) iPatchRedirector.redirect((short) 43, (Object) this, (Object) bVar);
        }
        this.f364798f = bVar;
        return this;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this);
            return;
        }
        if (s() != null && this.C != null) {
            s().unregisterOnPageChangeCallback(this.C);
            this.C = null;
        }
        V();
    }

    public d l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (d) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f364801h;
    }

    public int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return s().getCurrentItem();
    }

    public com.tencent.relation.common.widget.banner.indicator.a n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.relation.common.widget.banner.indicator.a) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f364803i;
    }

    public IndicatorConfig o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (IndicatorConfig) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        if (n() != null) {
            return n().c();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onAttachedToWindow();
            U();
        }
    }

    @Override // pz3.a
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this, (Object) lifecycleOwner);
        } else {
            g();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDetachedFromWindow();
            V();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        if (r0 != 3) goto L41;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (s().isUserInputEnabled() && this.f364805j0) {
            int action = motionEvent.getAction();
            boolean z16 = true;
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float x16 = motionEvent.getX();
                        float y16 = motionEvent.getY();
                        float abs = Math.abs(x16 - this.f364800g0);
                        float abs2 = Math.abs(y16 - this.f364802h0);
                        if (s().getOrientation() == 0) {
                            if (abs <= this.f364799f0 || abs < abs2) {
                                z16 = false;
                            }
                            this.f364804i0 = z16;
                        } else {
                            if (abs2 <= this.f364799f0 || abs2 < abs) {
                                z16 = false;
                            }
                            this.f364804i0 = z16;
                        }
                        getParent().requestDisallowInterceptTouchEvent(this.f364804i0);
                    }
                }
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                this.f364800g0 = motionEvent.getX();
                this.f364802h0 = motionEvent.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // pz3.a
    public void onStart(LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this, (Object) lifecycleOwner);
        } else {
            U();
        }
    }

    @Override // pz3.a
    public void onStop(LifecycleOwner lifecycleOwner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this, (Object) lifecycleOwner);
        } else {
            V();
        }
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (l() != null) {
            return l().getItemCount();
        }
        return 0;
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        if (l() != null) {
            return l().l0();
        }
        return 0;
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.G;
    }

    public ViewPager2 s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ViewPager2) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.f364794d;
    }

    public Banner x(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (Banner) iPatchRedirector.redirect((short) 31, (Object) this, z16);
        }
        this.E = z16;
        return this;
    }

    public boolean y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.D;
    }

    public Banner z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Banner) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        if (n() != null) {
            removeView(n().b());
        }
        return this;
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public Banner(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.D = true;
        this.E = true;
        this.F = 3000L;
        this.G = 600;
        this.H = 1;
        this.I = 0.0f;
        this.N = com.tencent.relation.common.widget.banner.config.a.f364823a;
        this.P = com.tencent.relation.common.widget.banner.config.a.f364824b;
        this.Q = -1996488705;
        this.R = -2013265920;
        this.S = 1;
        this.f364793c0 = com.tencent.relation.common.widget.banner.config.a.f364827e;
        this.f364795d0 = com.tencent.relation.common.widget.banner.config.a.f364828f;
        this.f364797e0 = 0;
        this.f364805j0 = true;
        this.f364809m0 = new a();
        t(context);
        w(context, attributeSet);
    }
}
