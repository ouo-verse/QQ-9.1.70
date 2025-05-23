package com.tencent.luggage.wxa.il;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ag.b;
import com.tencent.luggage.wxa.il.f;
import com.tencent.luggage.wxa.ok.p;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.mobileqq.R;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends FrameLayout {
    public static final int T = com.tencent.luggage.wxa.kn.a.a(z.c(), 196);
    public static final int U = com.tencent.luggage.wxa.kn.a.a(z.c(), 119);
    public static final int V = com.tencent.luggage.wxa.kn.a.a(z.c(), 176);
    public static final int W = com.tencent.luggage.wxa.kn.a.a(z.c(), 99);

    /* renamed from: a0, reason: collision with root package name */
    public static final int f130654a0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 119);

    /* renamed from: b0, reason: collision with root package name */
    public static final int f130655b0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 196);

    /* renamed from: c0, reason: collision with root package name */
    public static final int f130656c0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 99);

    /* renamed from: d0, reason: collision with root package name */
    public static final int f130657d0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 176);

    /* renamed from: e0, reason: collision with root package name */
    public static final int f130658e0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 32);

    /* renamed from: f0, reason: collision with root package name */
    public static final int f130659f0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 56);

    /* renamed from: g0, reason: collision with root package name */
    public static final int f130660g0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 52);

    /* renamed from: h0, reason: collision with root package name */
    public static final int f130661h0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 6);

    /* renamed from: i0, reason: collision with root package name */
    public static final int f130662i0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 80);

    /* renamed from: j0, reason: collision with root package name */
    public static final int f130663j0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 52);

    /* renamed from: k0, reason: collision with root package name */
    public static final int f130664k0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 8);

    /* renamed from: l0, reason: collision with root package name */
    public static final int f130665l0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 10);

    /* renamed from: m0, reason: collision with root package name */
    public static final int f130666m0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 12);

    /* renamed from: n0, reason: collision with root package name */
    public static final int f130667n0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 1);

    /* renamed from: o0, reason: collision with root package name */
    public static final int f130668o0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 10);

    /* renamed from: p0, reason: collision with root package name */
    public static final int f130669p0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 2);

    /* renamed from: q0, reason: collision with root package name */
    public static final int f130670q0 = com.tencent.luggage.wxa.kn.a.a(z.c(), 1);

    /* renamed from: r0, reason: collision with root package name */
    public static final Point f130671r0 = new Point();
    public Runnable C;
    public Set D;
    public int E;
    public Float F;
    public ViewOutlineProvider G;
    public ValueAnimator H;
    public ViewGroup I;
    public View J;
    public View K;
    public ViewGroup L;
    public View M;
    public View N;
    public View O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public p S;

    /* renamed from: a, reason: collision with root package name */
    public Integer f130672a;

    /* renamed from: b, reason: collision with root package name */
    public int f130673b;

    /* renamed from: c, reason: collision with root package name */
    public int f130674c;

    /* renamed from: d, reason: collision with root package name */
    public Point f130675d;

    /* renamed from: e, reason: collision with root package name */
    public Point f130676e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f130677f;

    /* renamed from: g, reason: collision with root package name */
    public PointF f130678g;

    /* renamed from: h, reason: collision with root package name */
    public PointF f130679h;

    /* renamed from: i, reason: collision with root package name */
    public float f130680i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f130681j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f130682k;

    /* renamed from: l, reason: collision with root package name */
    public int f130683l;

    /* renamed from: m, reason: collision with root package name */
    public int f130684m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(new Rect(0, 0, view.getWidth(), view.getHeight()), f.f130670q0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f130686a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f130687b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130688c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f130689d;

        public b(int i3, int i16, int i17, int i18) {
            this.f130686a = i3;
            this.f130687b = i16;
            this.f130688c = i17;
            this.f130689d = i18;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i3 = this.f130686a;
            int i16 = this.f130688c;
            f.this.a(i3 + ((int) (((this.f130687b * 1.0f) - i3) * floatValue)), i16 + ((int) (((this.f130689d * 1.0f) - i16) * floatValue)), false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f130691a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f130692b;

        public c(int i3, int i16) {
            this.f130691a = i3;
            this.f130692b = i16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            f fVar = f.this;
            fVar.a(fVar.getY(), true);
            f.this.f130683l = this.f130691a;
            f.this.f130684m = this.f130692b;
            w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "startStickyAnimation, mStablePosX: " + f.this.f130683l + ", mStablePosY: " + f.this.f130684m);
            f fVar2 = f.this;
            fVar2.b(fVar2.f130683l, f.this.f130684m);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a(int i3, int i16);
    }

    public f(Context context) {
        this(context, null);
    }

    private int getMarginBottom() {
        if (1 == this.f130674c) {
            return f130663j0;
        }
        return f130660g0;
    }

    private int getMarginHorizontal() {
        if (1 == this.f130674c) {
            return f130661h0;
        }
        return f130658e0;
    }

    private int getMarginTopDefault() {
        if (1 == this.f130674c) {
            return f130662i0;
        }
        return f130659f0;
    }

    private int getMinX() {
        return getMarginHorizontal();
    }

    private int getMinY() {
        Integer num = this.f130672a;
        if (num != null) {
            return num.intValue();
        }
        return getMarginTopDefault();
    }

    private int getTargetPositionXWhenOrientationChanged() {
        int minX = getMinX();
        if (!this.f130681j) {
            return a(getWidth());
        }
        return minX;
    }

    public void c() {
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "disableTouch");
        this.J.setVisibility(4);
        this.P = false;
    }

    public void d() {
        this.L.setVisibility(4);
        this.M.setVisibility(4);
        this.F = null;
    }

    public void e() {
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "showOnLoadEnd");
        this.K.setVisibility(4);
    }

    public void f() {
        if (this.Q) {
            w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "showOnLoading");
            this.K.setVisibility(0);
        }
    }

    public void g(int i3, int i16) {
        this.f130684m = d(i3, i16);
    }

    public int getStablePosX() {
        w.a("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosX, mStablePosX: " + this.f130683l);
        return this.f130683l;
    }

    public int getStablePosY() {
        w.a("MicroMsg.AppBrand.AppBrandPipContainerView", "getStablePosY, mStablePosY: " + this.f130684m);
        return this.f130684m;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        View view = (View) getParent();
        if (view == null) {
            w.f("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, null == parentView");
            return;
        }
        if (f130671r0 == this.f130675d) {
            this.f130675d = new Point(view.getWidth(), view.getHeight());
            w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "onLayout, mParentViewSize: " + this.f130675d);
            if (this.C != null) {
                w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "mPendingInitPos run");
                this.C.run();
                this.C = null;
                return;
            }
            a(getY(), true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L32;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.P) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (!this.f130677f && a(motionEvent)) {
                        this.f130677f = true;
                    }
                    if (this.f130677f) {
                        a(b(motionEvent), c(motionEvent), false);
                    }
                }
            }
            if (this.f130677f || a(motionEvent)) {
                if (this.f130677f) {
                    this.f130677f = false;
                }
                int b16 = b(motionEvent);
                int width = getWidth();
                int c16 = c(motionEvent);
                int height = getHeight();
                w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "onTouchEvent, startPositionX: " + b16 + ", width: " + width + ", startPositionY: " + c16 + ", height: " + height);
                a(b16, c16, c(b16, width), d(c16, height));
                return true;
            }
        } else {
            this.f130677f = false;
            d(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: setInitPositionIfNeed, reason: merged with bridge method [inline-methods] */
    public void a(final b.a aVar) {
        int a16;
        int b16;
        if (this.f130682k) {
            w.a("MicroMsg.AppBrand.AppBrandPipContainerView", "setInitPositionIfNeed, already set");
            return;
        }
        if (aVar != null && this.f130675d == f130671r0) {
            w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setInitPositionIfNeed customInitPos but mParentViewSize empty, pending");
            this.C = new Runnable() { // from class: v21.a
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.a(aVar);
                }
            };
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (aVar != null) {
            w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setInitPositionIfNeed isAlignmentRight:%b y:%s", Boolean.valueOf(aVar.f121391a), Double.valueOf(aVar.f121392b));
            if (aVar.f121391a) {
                a16 = a(width);
            } else {
                a16 = getMinX();
            }
            b16 = (int) (((b(height) - getMinY()) * aVar.f121392b) + getMinY());
        } else {
            a16 = a(width);
            b16 = b(height);
        }
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setInitPositionIfNeed, x: " + a16 + ", y: " + b16);
        setX((float) a16);
        setY((float) b16);
        a(getY(), true);
        f(a16, width);
        g(b16, height);
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "setPosition, mStablePosX: " + this.f130683l + ", mStablePosY: " + this.f130684m);
        b(this.f130683l, this.f130684m);
        this.f130682k = true;
    }

    public void setOnCloseButtonClickListener(@Nullable View.OnClickListener onClickListener) {
        this.J.setOnClickListener(onClickListener);
    }

    public void setStablePos(Point point) {
        w.a("MicroMsg.AppBrand.AppBrandPipContainerView", "setStablePos, stablePos: " + point);
        this.f130683l = point.x;
        this.f130684m = point.y;
        this.f130682k = true;
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f130672a = null;
        Point point = f130671r0;
        this.f130675d = point;
        this.f130676e = point;
        this.f130677f = false;
        this.f130678g = new PointF();
        this.f130679h = new PointF();
        this.f130680i = -1.0f;
        this.f130681j = false;
        this.f130682k = false;
        this.C = null;
        this.D = null;
        this.E = V;
        this.F = null;
        this.G = new a();
        this.P = true;
        this.Q = true;
        this.R = false;
        this.S = null;
        b(context);
    }

    public final void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dy_, this);
        setBackgroundColor(0);
        this.N = inflate.findViewById(R.id.srx);
        View findViewById = inflate.findViewById(R.id.srw);
        this.O = findViewById;
        findViewById.setOutlineProvider(this.G);
        this.O.setClipToOutline(true);
        this.I = (ViewGroup) inflate.findViewById(R.id.sry);
        View findViewById2 = inflate.findViewById(R.id.srv);
        this.J = findViewById2;
        com.tencent.luggage.wxa.jl.c.a(findViewById2, Button.class, Integer.valueOf(R.string.z0v), false, null, null, null, null, null, null, null, null, null);
        View findViewById3 = inflate.findViewById(R.id.f164364ss1);
        this.K = findViewById3;
        findViewById3.setVisibility(4);
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.f164365ss2);
        this.L = viewGroup;
        viewGroup.setVisibility(4);
        View findViewById4 = inflate.findViewById(R.id.f164366ss3);
        this.M = findViewById4;
        findViewById4.setVisibility(4);
        a(this.E, f130665l0, f130664k0, f130666m0, f130667n0, f130668o0, f130669p0);
        this.f130673b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f130674c = context.getResources().getConfiguration().orientation;
        this.f130676e = a(context);
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "init, mScreenSize: " + this.f130676e);
    }

    public final boolean e(int i3, int i16) {
        int i17 = this.f130675d.x;
        if (i17 <= 0) {
            i17 = this.f130676e.x;
            w.f("MicroMsg.AppBrand.AppBrandPipContainerView", "isPositionLeft, mParentViewSize: " + this.f130675d + ", mScreenSize: " + this.f130676e);
        }
        boolean z16 = i3 + (i16 / 2) <= i17 / 2;
        this.f130681j = z16;
        return z16;
    }

    public final int c(MotionEvent motionEvent) {
        int i3 = this.f130675d.y;
        if (i3 <= 0) {
            i3 = this.f130676e.y;
            w.f("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionY, mParentViewSize: " + this.f130675d + ", mScreenSize: " + this.f130676e);
        }
        return (int) Math.max(Math.min((this.f130679h.y + motionEvent.getRawY()) - this.f130678g.y, i3 - getHeight()), 0.0f);
    }

    public final void d(MotionEvent motionEvent) {
        this.f130678g.x = motionEvent.getRawX();
        this.f130678g.y = motionEvent.getRawY();
        this.f130679h.x = (int) getX();
        this.f130679h.y = (int) getY();
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "recordPositionWhenActionDown, fingerPosOnDown: " + this.f130678g + ", viewPosOnDown: " + this.f130679h);
    }

    public void f(int i3, int i16) {
        this.f130683l = c(i3, i16);
    }

    public final int c(int i3, int i16) {
        return !e(i3, i16) ? a(i16) : getMinX();
    }

    public void a(int i3, int i16) {
        f(this.f130683l, i3);
        g(this.f130684m, i16);
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustStablePos, mStablePosX: " + this.f130683l + ", mStablePosY: " + this.f130684m);
        b(this.f130683l, this.f130684m);
    }

    public final int d(int i3, int i16) {
        int minY = getMinY();
        if (i3 < minY) {
            return minY;
        }
        int b16 = b(i16);
        return i3 > b16 ? b16 : i3;
    }

    public void a(int i3, Configuration configuration) {
        this.f130672a = Integer.valueOf(i3 - f130664k0);
        if (configuration != null) {
            a(configuration);
        }
    }

    public void a(View view) {
        this.I.addView(view);
        view.setOutlineProvider(this.G);
        view.setClipToOutline(true);
        e();
    }

    public void a(boolean z16) {
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, isEnabled: " + z16);
        this.R = z16;
        if (z16) {
            if (this.S != null) {
                w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "enableShadow, setShadowDrawable");
                p.a(this.N, this.S);
                return;
            }
            return;
        }
        p.a(this.N, null);
    }

    public void b(View view) {
        this.I.removeView(view);
    }

    public void a(float f16) {
        if (this.Q) {
            this.L.setVisibility(0);
            this.M.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.M.getLayoutParams();
            layoutParams.width = (int) ((this.E * f16) / 100.0f);
            this.M.setLayoutParams(layoutParams);
            this.F = Float.valueOf(f16);
        }
    }

    public void b(boolean z16) {
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "enableTouch");
        this.J.setVisibility(z16 ? 0 : 4);
        this.P = true;
    }

    public void b() {
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "disableInfoCovers");
        e();
        d();
        this.Q = false;
    }

    public void a(int i3, int i16, int i17, int i18, int i19, int i26, int i27) {
        this.E = i3;
        Float f16 = this.F;
        if (f16 != null) {
            a(f16.floatValue());
        }
        this.N.setPadding(i16, i17, i16, i18);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.O.getLayoutParams();
        layoutParams.leftMargin = i16;
        layoutParams.rightMargin = i16;
        layoutParams.topMargin = i17;
        layoutParams.bottomMargin = i18;
        this.O.setLayoutParams(layoutParams);
        p a16 = new p.b().e(i19).c(Color.parseColor("#4C000000")).d(i26).a(0).b(i27).a();
        if (this.R) {
            p.a(this.N, a16);
        } else {
            this.S = a16;
        }
    }

    public void b(d dVar) {
        Set set = this.D;
        if (set == null) {
            return;
        }
        set.remove(dVar);
        if (this.D.isEmpty()) {
            this.D = null;
        }
    }

    public final void b(int i3, int i16) {
        Set set = this.D;
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(i3, i16);
        }
    }

    public final int b(MotionEvent motionEvent) {
        int i3 = this.f130675d.x;
        if (i3 <= 0) {
            i3 = this.f130676e.x;
            w.f("MicroMsg.AppBrand.AppBrandPipContainerView", "getMotionEventNewPositionX, mParentViewSize: " + this.f130675d + ", mScreenSize: " + this.f130676e);
        }
        return (int) Math.max(Math.min((this.f130679h.x + motionEvent.getRawX()) - this.f130678g.x, i3 - getWidth()), 0.0f);
    }

    public final int b(int i3) {
        int i16 = this.f130675d.y;
        int marginBottom = getMarginBottom();
        int i17 = (i16 - i3) - marginBottom;
        if (i17 >= 0) {
            return i17;
        }
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "getMaxY mParentViewSize.y:%d, mScreenSize.y:%d", Integer.valueOf(this.f130675d.y), Integer.valueOf(this.f130676e.y));
        return (this.f130676e.y - i3) - marginBottom;
    }

    public void a(d dVar) {
        if (this.D == null) {
            this.D = new HashSet();
        }
        this.D.add(dVar);
    }

    public final void a(Configuration configuration) {
        View view = (View) getParent();
        if (view == null) {
            w.a("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustOnConfigurationChanged, null == parentView");
            return;
        }
        this.f130675d = new Point(view.getWidth(), view.getHeight());
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustOnConfigurationChanged, mParentViewSize: " + this.f130675d);
        this.f130676e = a(getContext());
        w.d("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustOnConfigurationChanged, mScreenSize: " + this.f130676e);
        if (this.f130674c == configuration.orientation || getVisibility() != 0) {
            return;
        }
        this.f130674c = configuration.orientation;
        int minX = getMinX();
        int a16 = a(getWidth());
        int minY = getMinY();
        int b16 = b(getHeight());
        float x16 = getX();
        float f16 = minY;
        float f17 = (this.f130680i * (b16 - minY)) + f16;
        int max = (int) Math.max(Math.min(x16, a16), minX);
        int max2 = (int) Math.max(Math.min(f17, b16), f16);
        int targetPositionXWhenOrientationChanged = getTargetPositionXWhenOrientationChanged();
        int d16 = d(max2, getHeight());
        w.a("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustOnConfigurationChanged, x: %f, y: %f, startPositionX: %d, startPositionY: %d, targetPositionX: %d, targetPositionY: %d", Float.valueOf(x16), Float.valueOf(f17), Integer.valueOf(max), Integer.valueOf(max2), Integer.valueOf(targetPositionXWhenOrientationChanged), Integer.valueOf(d16));
        a(max, max2, targetPositionXWhenOrientationChanged, d16);
    }

    public final boolean a(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getRawX() - this.f130678g.x) > ((float) this.f130673b) || Math.abs(motionEvent.getRawY() - this.f130678g.y) > ((float) this.f130673b);
    }

    public final void a(float f16, float f17, boolean z16) {
        float x16 = getX();
        float x17 = getX();
        if (x16 == f16 && x17 == f17) {
            return;
        }
        setX(f16);
        setY(f17);
        a(f17, z16);
    }

    public final void a(int i3, int i16, int i17, int i18) {
        ValueAnimator valueAnimator = this.H;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.H.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.H = ofFloat;
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        this.H.setDuration(100L);
        this.H.addUpdateListener(new b(i3, i17, i16, i18));
        this.H.addListener(new c(i17, i18));
        this.H.start();
    }

    public final int a(int i3) {
        int i16 = this.f130675d.x;
        int marginHorizontal = getMarginHorizontal();
        int i17 = (i16 - i3) - marginHorizontal;
        return i17 < 0 ? (this.f130676e.x - i3) - marginHorizontal : i17;
    }

    public final void a(float f16, boolean z16) {
        if (z16) {
            int minY = getMinY();
            float f17 = minY;
            this.f130680i = (Math.min(Math.max(f16, f17), b(getHeight())) - f17) / (r0 - minY);
        }
    }

    public static Point a(Context context) {
        Point point = new Point();
        if (context == null) {
            return point;
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point;
    }
}
