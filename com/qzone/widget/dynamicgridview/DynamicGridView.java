package com.qzone.widget.dynamicgridview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ListAdapter;
import com.qzone.util.ar;
import com.qzone.widget.ExtendGridView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class DynamicGridView extends ExtendGridView {
    private static final double A0 = Math.tan(Math.toRadians(20.0d));
    private static final int B0 = ViewConfiguration.getLongPressTimeout();
    private BitmapDrawable D;
    private Rect E;
    private Rect F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private List<Long> N;
    private long P;
    private boolean Q;
    private int R;
    private boolean S;
    private int T;
    private boolean U;
    private int V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f60765a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f60766b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f60767c0;

    /* renamed from: d0, reason: collision with root package name */
    private AbsListView.OnScrollListener f60768d0;

    /* renamed from: e0, reason: collision with root package name */
    private s f60769e0;

    /* renamed from: f0, reason: collision with root package name */
    private t f60770f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f60771g0;

    /* renamed from: h0, reason: collision with root package name */
    private AdapterView.OnItemClickListener f60772h0;

    /* renamed from: i0, reason: collision with root package name */
    private AdapterView.OnItemClickListener f60773i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f60774j0;

    /* renamed from: k0, reason: collision with root package name */
    private p f60775k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f60776l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f60777m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f60778n0;

    /* renamed from: o0, reason: collision with root package name */
    private Paint f60779o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f60780p0;

    /* renamed from: q0, reason: collision with root package name */
    private float f60781q0;

    /* renamed from: r0, reason: collision with root package name */
    private Rect f60782r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f60783s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f60784t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f60785u0;

    /* renamed from: v0, reason: collision with root package name */
    private int f60786v0;

    /* renamed from: w0, reason: collision with root package name */
    boolean f60787w0;

    /* renamed from: x0, reason: collision with root package name */
    boolean f60788x0;

    /* renamed from: y0, reason: collision with root package name */
    long f60789y0;

    /* renamed from: z0, reason: collision with root package name */
    private AbsListView.OnScrollListener f60790z0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class PreHoneycombCellAnimator implements u {

        /* renamed from: a, reason: collision with root package name */
        private int f60793a;

        /* renamed from: b, reason: collision with root package name */
        private int f60794b;

        public PreHoneycombCellAnimator(int i3, int i16) {
            this.f60794b = i3;
            this.f60793a = i16;
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.u
        public void a(int i3, int i16) {
            DynamicGridView.this.G += this.f60793a;
            DynamicGridView.this.H += this.f60794b;
            if (DynamicGridView.this.f60774j0 != null) {
                DynamicGridView.this.f60774j0.setVisibility(0);
            }
            DynamicGridView.this.postDelayed(new Runnable() { // from class: com.qzone.widget.dynamicgridview.DynamicGridView.PreHoneycombCellAnimator.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DynamicGridView.this.P == -1) {
                        return;
                    }
                    DynamicGridView dynamicGridView = DynamicGridView.this;
                    View a16 = dynamicGridView.a1(dynamicGridView.P);
                    if (a16 != null) {
                        a16.setVisibility(4);
                    }
                    DynamicGridView dynamicGridView2 = DynamicGridView.this;
                    dynamicGridView2.y1(dynamicGridView2.P);
                }
            }, 300L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f60797d;

        a(View view) {
            this.f60797d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DynamicGridView.this.f60765a0 = false;
            DynamicGridView.this.w1();
            DynamicGridView.this.f60781q0 = -1.0f;
            DynamicGridView.this.p1(this.f60797d);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DynamicGridView.this.f60765a0 = true;
            DynamicGridView.this.w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DynamicGridView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f60802d;

        d(View view) {
            this.f60802d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DynamicGridView.this.f60765a0 = false;
            DynamicGridView.this.w1();
            DynamicGridView.this.G0(this.f60802d);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DynamicGridView.this.f60765a0 = true;
            DynamicGridView.this.w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DynamicGridView.this.f60766b0 = false;
            DynamicGridView.this.w1();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DynamicGridView.this.f60766b0 = true;
            DynamicGridView.this.w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DynamicGridView.this.f60766b0 = false;
            DynamicGridView.this.w1();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DynamicGridView.this.f60766b0 = true;
            DynamicGridView.this.w1();
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class h implements AbsListView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        private int f60810d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f60811e = -1;

        /* renamed from: f, reason: collision with root package name */
        private int f60812f;

        /* renamed from: h, reason: collision with root package name */
        private int f60813h;

        /* renamed from: i, reason: collision with root package name */
        private int f60814i;

        h() {
        }

        private void c() {
            if (this.f60813h <= 0 || this.f60814i != 0) {
                return;
            }
            if (!DynamicGridView.this.Q || !DynamicGridView.this.S) {
                if (DynamicGridView.this.U) {
                    DynamicGridView.this.v1();
                    return;
                }
                return;
            }
            DynamicGridView.this.e1();
        }

        public void a() {
            if (this.f60812f == this.f60810d || !DynamicGridView.this.Q || DynamicGridView.this.P == -1) {
                return;
            }
            DynamicGridView dynamicGridView = DynamicGridView.this;
            dynamicGridView.y1(dynamicGridView.P);
            DynamicGridView.this.d1();
        }

        public void b() {
            if (this.f60812f + this.f60813h == this.f60810d + this.f60811e || !DynamicGridView.this.Q || DynamicGridView.this.P == -1) {
                return;
            }
            DynamicGridView dynamicGridView = DynamicGridView.this;
            dynamicGridView.y1(dynamicGridView.P);
            DynamicGridView.this.d1();
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            this.f60812f = i3;
            this.f60813h = i16;
            int i18 = this.f60810d;
            if (i18 == -1) {
                i18 = i3;
            }
            this.f60810d = i18;
            int i19 = this.f60811e;
            if (i19 == -1) {
                i19 = i16;
            }
            this.f60811e = i19;
            a();
            b();
            this.f60810d = this.f60812f;
            this.f60811e = this.f60813h;
            if (DynamicGridView.this.f60768d0 != null) {
                DynamicGridView.this.f60768d0.onScroll(absListView, i3, i16, i17);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            this.f60814i = i3;
            DynamicGridView.this.V = i3;
            c();
            if (DynamicGridView.this.f60768d0 != null) {
                DynamicGridView.this.f60768d0.onScrollStateChanged(absListView, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            DynamicGridView.k1(String.format("OnItemClickListener:isEditMode=%s,isEnable=%s", Boolean.valueOf(DynamicGridView.this.g1()), Boolean.valueOf(DynamicGridView.this.isEnabled())));
            if (DynamicGridView.this.g1() || !DynamicGridView.this.isEnabled() || DynamicGridView.this.f60772h0 == null) {
                return;
            }
            DynamicGridView.this.f60772h0.onItemClick(adapterView, view, i3, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class k extends AccelerateDecelerateInterpolator {
        k() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float interpolation = super.getInterpolation(f16);
            DynamicGridView.this.f60780p0 = (int) ((77.0f * interpolation) + 0.5d);
            return interpolation;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class l implements ValueAnimator.AnimatorUpdateListener {
        l() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DynamicGridView.this.f60781q0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DynamicGridView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class m extends AnimatorListenerAdapter {
        m() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (DynamicGridView.this.f60785u0) {
                DynamicGridView.this.x1(true);
                DynamicGridView.this.f60785u0 = false;
            }
            DynamicGridView.this.f60765a0 = false;
            DynamicGridView.this.w1();
            DynamicGridView.this.f60781q0 = -1.0f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DynamicGridView.this.f60765a0 = true;
            DynamicGridView.this.w1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class n extends AccelerateDecelerateInterpolator {
        n() {
        }

        @Override // android.view.animation.AccelerateDecelerateInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float interpolation = super.getInterpolation(f16);
            DynamicGridView.this.f60780p0 = (int) (((1.0f - interpolation) * 77.0f) + 0.5d);
            return interpolation;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class o implements ValueAnimator.AnimatorUpdateListener {
        o() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DynamicGridView.this.f60781q0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DynamicGridView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class p extends Handler {
        p() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                removeMessages(1);
                DynamicGridView.this.P0(message.arg1);
            } else {
                throw new RuntimeException("Unknown message " + message);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private class q {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes37.dex */
        public class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: d, reason: collision with root package name */
            private final View f60825d;

            /* renamed from: e, reason: collision with root package name */
            private final int f60826e;

            a(View view, int i3) {
                this.f60825d = view;
                this.f60826e = i3;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                View view = this.f60825d;
                if (view != null) {
                    view.setVisibility(0);
                    com.tencent.mobileqq.businessCard.helpers.b.a(this.f60825d, 1.0f);
                }
                DynamicGridView.this.E0(this.f60826e);
                return true;
            }
        }

        public q() {
        }

        public void a(View view, int i3) {
            DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(view, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class r implements u {

        /* renamed from: a, reason: collision with root package name */
        private int f60828a;

        /* renamed from: b, reason: collision with root package name */
        private int f60829b;

        /* compiled from: P */
        /* loaded from: classes37.dex */
        private class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: d, reason: collision with root package name */
            private final View f60831d;

            /* renamed from: e, reason: collision with root package name */
            private final int f60832e;

            /* renamed from: f, reason: collision with root package name */
            private final int f60833f;

            a(View view, int i3, int i16) {
                this.f60831d = view;
                this.f60832e = i3;
                this.f60833f = i16;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                DynamicGridView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                DynamicGridView.this.G += r.this.f60828a;
                DynamicGridView.this.H += r.this.f60829b;
                View view = this.f60831d;
                if (view != null) {
                    view.setVisibility(0);
                }
                DynamicGridView dynamicGridView = DynamicGridView.this;
                dynamicGridView.f60774j0 = dynamicGridView.a1(dynamicGridView.P);
                if (DynamicGridView.this.f60774j0 != null) {
                    DynamicGridView.this.f60774j0.setVisibility(4);
                }
                try {
                    DynamicGridView.this.F0(this.f60832e, this.f60833f);
                    return true;
                } catch (Throwable th5) {
                    com.qzone.proxy.feedcomponent.util.j.d(AdapterView.TAG, "error: ", th5);
                    return true;
                }
            }
        }

        public r(int i3, int i16) {
            this.f60829b = i3;
            this.f60828a = i16;
        }

        @Override // com.qzone.widget.dynamicgridview.DynamicGridView.u
        public void a(int i3, int i16) {
            DynamicGridView.this.getViewTreeObserver().addOnPreDrawListener(new a(DynamicGridView.this.f60774j0, i3, i16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface s {
        void a(int i3, int i16);

        void b(int i3, int i16);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface t {
        void onEditModeChanged(boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface u {
        void a(int i3, int i16);
    }

    public DynamicGridView(Context context) {
        super(context);
        this.G = 0;
        this.H = 0;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.N = new ArrayList();
        this.P = -1L;
        this.Q = false;
        this.R = -1;
        this.T = 0;
        this.U = false;
        this.V = 0;
        this.W = false;
        this.f60767c0 = false;
        this.f60771g0 = false;
        this.f60773i0 = new i();
        this.f60780p0 = 77;
        this.f60781q0 = -1.0f;
        this.f60782r0 = new Rect();
        this.f60783s0 = -1;
        this.f60784t0 = false;
        this.f60785u0 = false;
        this.f60786v0 = -1;
        this.f60787w0 = true;
        this.f60788x0 = false;
        this.f60789y0 = 0L;
        this.f60790z0 = new h();
        init(context);
    }

    private boolean A0(Point point, Point point2) {
        return point.y < point2.y && point.x < point2.x;
    }

    private boolean B0(Point point, Point point2) {
        return point.y < point2.y && point.x > point2.x;
    }

    private void D0(View view) {
        b bVar = new b(view);
        Rect X0 = X0(view);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.D, "bounds", bVar, X0);
        ofObject.setDuration(W0(X0));
        ofObject.addUpdateListener(new c());
        ofObject.addListener(new d(view));
        ofObject.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i3) {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        if (i3 <= lastVisiblePosition && i3 >= firstVisiblePosition) {
            LinkedList linkedList = new LinkedList();
            int V0 = V0();
            while (lastVisiblePosition >= i3) {
                View a16 = a1(R0(lastVisiblePosition));
                if (a16 != null) {
                    if ((lastVisiblePosition + 1) % V0 == 0) {
                        linkedList.add(N0(a16, (-a16.getWidth()) * (V0 - 1), 0.0f, a16.getHeight(), 0.0f));
                    } else {
                        linkedList.add(N0(a16, a16.getWidth(), 0.0f, 0.0f, 0.0f));
                    }
                }
                lastVisiblePosition--;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(linkedList);
            animatorSet.setDuration(300L);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.addListener(new f());
            animatorSet.start();
            return;
        }
        RFWLog.e(AdapterView.TAG, RFWLog.USR, "[animateDelete] pos:" + i3 + ", start pos:" + firstVisiblePosition + ", end pos:" + lastVisiblePosition);
    }

    private boolean I0(Point point, Point point2) {
        return point.y > point2.y && point.x == point2.x;
    }

    private boolean J0(Point point, Point point2) {
        return point.y > point2.y && point.x < point2.x;
    }

    private boolean K0(Point point, Point point2) {
        return point.y > point2.y && point.x > point2.x;
    }

    private Bitmap M0(int i3, int i16, Bitmap.Config config) {
        try {
            return Bitmap.createBitmap(i3, i16, config);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            if (config == Bitmap.Config.ARGB_8888) {
                return M0(i3, i16, Bitmap.Config.ARGB_4444);
            }
            return null;
        }
    }

    private int O0(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private com.qzone.widget.dynamicgridview.d Q0() {
        if (getAdapter() instanceof com.qzone.widget.dynamicgridview.d) {
            return (com.qzone.widget.dynamicgridview.d) getAdapter();
        }
        return new j();
    }

    private long R0(int i3) {
        if (getAdapter() instanceof com.qzone.widget.dynamicgridview.b) {
            return ((com.qzone.widget.dynamicgridview.b) getAdapter()).h(i3);
        }
        return getAdapter().getItemId(i3);
    }

    private Bitmap T0(View view, float f16, int i3) {
        int width = ((int) (view.getWidth() * f16)) + i3;
        int height = ((int) (view.getHeight() * f16)) + i3;
        Bitmap M0 = M0(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        if (M0 == null) {
            return null;
        }
        view.draw(new Canvas(M0));
        Bitmap M02 = M0(width, height, Bitmap.Config.ARGB_8888);
        if (M02 == null) {
            return null;
        }
        Canvas canvas = new Canvas(M02);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(M0, (Rect) null, new Rect(i3, i3, M02.getWidth() - i3, M02.getHeight() - i3), paint);
        return M02;
    }

    private Point U0(View view) {
        int positionForView = getPositionForView(view);
        int V0 = V0();
        return new Point(positionForView % V0, positionForView / V0);
    }

    private int V0() {
        return getNumColumns();
    }

    private long W0(Rect rect) {
        Rect bounds = this.D.getBounds();
        double centerX = bounds.centerX() - rect.centerX();
        double centerY = bounds.centerY() - rect.centerY();
        double sqrt = Math.sqrt((centerX * centerX) + (centerY * centerY));
        double width = bounds.width();
        if (sqrt >= width) {
            return 200L;
        }
        return Math.round((sqrt * 200.0d) / width);
    }

    private Rect X0(View view) {
        int width = (((int) (view.getWidth() * 1.1f)) + 0) / 2;
        int height = (((int) (view.getHeight() * 1.1f)) + 0) / 2;
        int right = (view.getRight() + view.getLeft()) / 2;
        int bottom = (view.getBottom() + view.getTop()) / 2;
        return new Rect(right - width, bottom - height, right + width, bottom + height);
    }

    private int Z0() {
        if (T() || !this.f60787w0) {
            return 1;
        }
        if (this.f60788x0 && this.f60789y0 != 0) {
            int currentTimeMillis = ((int) ((System.currentTimeMillis() - this.f60789y0) / 1000)) * 2;
            if (currentTimeMillis > 4) {
                currentTimeMillis = 4;
            }
            if (currentTimeMillis < 1) {
                return 1;
            }
            return currentTimeMillis;
        }
        this.f60789y0 = System.currentTimeMillis();
        return 1;
    }

    private float b1(View view) {
        return Math.abs((view.getRight() - view.getLeft()) / 2);
    }

    private float c1(View view) {
        return Math.abs((view.getBottom() - view.getTop()) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        u preHoneycombCellAnimator;
        int i3 = this.K - this.J;
        int i16 = this.L - this.I;
        int centerY = this.F.centerY() + this.G + i3;
        int centerX = this.F.centerX() + this.H + i16;
        View a16 = a1(this.P);
        this.f60774j0 = a16;
        if (a16 == null) {
            return;
        }
        Point U0 = U0(a16);
        Iterator<Long> it = this.N.iterator();
        float f16 = 0.0f;
        View view = null;
        float f17 = 0.0f;
        while (it.hasNext()) {
            View a17 = a1(it.next().longValue());
            if (a17 != null) {
                Point U02 = U0(a17);
                if ((B0(U02, U0) && centerY < a17.getBottom() && centerX > a17.getLeft()) || ((A0(U02, U0) && centerY < a17.getBottom() && centerX < a17.getRight()) || ((K0(U02, U0) && centerY > a17.getTop() && centerX > a17.getLeft()) || ((J0(U02, U0) && centerY > a17.getTop() && centerX < a17.getRight()) || ((z0(U02, U0) && centerY < a17.getBottom() - this.M) || ((I0(U02, U0) && centerY > a17.getTop() + this.M) || ((q1(U02, U0) && centerX > a17.getLeft() + this.M) || (j1(U02, U0) && centerX < a17.getRight() - this.M)))))))) {
                    float abs = Math.abs(b1(a17) - b1(this.f60774j0));
                    float abs2 = Math.abs(c1(a17) - c1(this.f60774j0));
                    if (abs >= f16 && abs2 >= f17) {
                        view = a17;
                        f16 = abs;
                        f17 = abs2;
                    }
                }
            }
        }
        if (view != null) {
            int positionForView = getPositionForView(this.f60774j0);
            int positionForView2 = getPositionForView(view);
            com.qzone.widget.dynamicgridview.d Q0 = Q0();
            if (positionForView2 != -1 && Q0.c(positionForView) && Q0.c(positionForView2)) {
                this.f60774j0 = a1(this.P);
                if ((Q0 instanceof e9.a) && ((e9.a) Q0).m()) {
                    k1("handleCellSwitch - reorderElements(originalPosition - 1, targetPosition - 1)");
                    o1(positionForView - 1, positionForView2 - 1);
                } else {
                    k1("handleCellSwitch - reorderElements(originalPosition, targetPosition)");
                    o1(positionForView, positionForView2);
                }
                k1(String.format(">>>handleCellSwitch:mLastEventY=%s,mDownY=%s", Integer.valueOf(this.K), Integer.valueOf(this.J)));
                this.J = this.K;
                this.I = this.L;
                if (i1()) {
                    preHoneycombCellAnimator = new r(i16, i3);
                } else {
                    preHoneycombCellAnimator = new PreHoneycombCellAnimator(i16, i3);
                }
                y1(this.P);
                preHoneycombCellAnimator.a(positionForView, positionForView2);
                return;
            }
            y1(this.P);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        this.S = f1(this.E);
        k1("handleMobileCellScroll:mKeepAccelerating=" + this.f60788x0 + "-mulriple=" + Z0() + "-scrolling=" + this.S);
        if (this.S) {
            this.f60788x0 = true;
        } else {
            this.f60788x0 = false;
            this.f60789y0 = System.currentTimeMillis();
        }
    }

    private boolean i1() {
        return true;
    }

    private boolean j1(Point point, Point point2) {
        return point.y == point2.y && point.x < point2.x;
    }

    public static void k1(String str) {
        Log.i("DynamicGridView", str);
    }

    public static void m1(String str) {
        Log.e("DynamicGridView", str);
    }

    private void o1(int i3, int i16) {
        s sVar = this.f60769e0;
        if (sVar != null) {
            sVar.a(i3, i16);
        }
        Q0().a(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(View view) {
        this.N.clear();
        this.P = -1L;
        if (view != null) {
            view.setVisibility(0);
        }
        this.D = null;
        for (int i3 = 0; i3 < getLastVisiblePosition() - getFirstVisiblePosition(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                childAt.setVisibility(0);
            }
        }
        invalidate();
    }

    private boolean q1(Point point, Point point2) {
        return point.y == point2.y && point.x > point2.x;
    }

    private void r1(int i3, int i16) {
        if (L0(i3)) {
            this.G = 0;
            this.H = 0;
            long R0 = R0(i3);
            View a16 = a1(R0);
            if (a16 != null) {
                this.P = R0;
                this.D = S0(a16);
                a16.setVisibility(4);
                k1(String.format("previouus position:%s,mobileId=%s, startDragAtPosition", Integer.valueOf(getPositionForView(a16)), Long.valueOf(this.P)));
                y1(this.P);
                this.Q = true;
                s sVar = this.f60769e0;
                if (sVar != null) {
                    sVar.b(i3, i16);
                }
                if (i1()) {
                    H0();
                }
                invalidate();
            }
        }
    }

    private void t1() {
        if (this.W) {
            this.W = false;
            requestDisallowInterceptTouchEvent(false);
            t tVar = this.f60770f0;
            if (tVar != null) {
                tVar.onEditModeChanged(false);
            }
            invalidate();
        }
    }

    private void u1() {
        View a16 = a1(this.P);
        if (this.Q) {
            p1(a16);
        }
        this.Q = false;
        this.S = false;
        this.R = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1() {
        final View a16 = a1(this.P);
        if (a16 != null && (this.Q || this.U)) {
            this.Q = false;
            this.U = false;
            this.S = false;
            this.R = -1;
            final int i3 = this.V;
            if (i3 != 0) {
                this.U = true;
                postDelayed(new Runnable() { // from class: com.qzone.widget.dynamicgridview.DynamicGridView.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DynamicGridView.this.U && DynamicGridView.this.V == i3) {
                            DynamicGridView.this.V = 0;
                            DynamicGridView.this.v1();
                        }
                    }
                }, 100L);
                return;
            } else {
                if (i1()) {
                    D0(a16);
                    return;
                }
                this.f60765a0 = true;
                w1();
                postDelayed(new Runnable() { // from class: com.qzone.widget.dynamicgridview.DynamicGridView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicGridView.this.f60765a0 = false;
                        DynamicGridView.this.w1();
                        DynamicGridView.this.p1(a16);
                    }
                }, 100L);
                return;
            }
        }
        u1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        setEnabled((this.f60765a0 || this.f60766b0) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(long j3) {
        int abs;
        this.N.clear();
        int Y0 = Y0(j3);
        int V0 = V0();
        for (int firstVisiblePosition = getFirstVisiblePosition(); firstVisiblePosition <= getLastVisiblePosition(); firstVisiblePosition++) {
            if (Y0 != firstVisiblePosition && Q0().c(firstVisiblePosition) && ((abs = Math.abs(Y0 - firstVisiblePosition)) == 1 || abs == V0 || abs == V0 - 1 || abs == V0 + 1)) {
                this.N.add(Long.valueOf(R0(firstVisiblePosition)));
            }
        }
    }

    private boolean z0(Point point, Point point2) {
        return point.y < point2.y && point.x == point2.x;
    }

    public int Y0(long j3) {
        View a16 = a1(j3);
        if (a16 == null) {
            return -1;
        }
        return getPositionForView(a16);
    }

    public View a1(long j3) {
        int firstVisiblePosition = getFirstVisiblePosition();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (R0(firstVisiblePosition + i3) == j3) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        BitmapDrawable bitmapDrawable = this.D;
        if (bitmapDrawable != null) {
            Rect bounds = bitmapDrawable.getBounds();
            float f16 = this.f60781q0;
            float f17 = 1.1f;
            if (f16 > 0.0f) {
                f17 = 1.1f * f16;
                float f18 = (bounds.left + bounds.right) / 2;
                float f19 = (bounds.top + bounds.bottom) / 2;
                canvas.save();
                float f26 = this.f60781q0;
                canvas.scale(f26, f26, f18, f19);
            }
            int i3 = 1;
            while (true) {
                int i16 = this.f60778n0;
                if (i3 > i16 || i16 <= 1) {
                    break;
                }
                int i17 = this.f60780p0;
                int i18 = i3 - 1;
                int i19 = i17 - ((i17 * i18) / (i16 - 1));
                int i26 = i18 * 255;
                this.f60779o0.setColor(Color.argb(i19, (i26 / (i16 - 1)) + 0, (i26 / (i16 - 1)) + 0, (i26 / (i16 - 1)) + 0));
                canvas.drawRect((bounds.left + Math.round((this.f60782r0.left * f17) + 0.5f)) - i3, (bounds.top + Math.round((this.f60782r0.top * f17) + 0.5f)) - i3, (bounds.right - Math.round((this.f60782r0.right * f17) + 0.5f)) + i3, (bounds.bottom - Math.round((this.f60782r0.bottom * f17) + 0.5f)) + i3, this.f60779o0);
                i3++;
            }
            this.D.draw(canvas);
            if (this.f60781q0 > 0.0f) {
                canvas.restore();
            }
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ListAdapter adapter;
        k1("dispatchTouchEvent->type=" + C0(motionEvent.getAction()) + "--scrollState:" + this.V);
        l1(String.format(">>>dispatchTouchEvent:currentY=%s,mLastEventY=%s,mDownY=%s", Float.valueOf(motionEvent.getY()), Integer.valueOf(this.K), Integer.valueOf(this.J)));
        if (motionEvent.getAction() == 0) {
            this.f60786v0 = (int) motionEvent.getY();
        }
        int abs = Math.abs(((int) motionEvent.getY()) - this.f60786v0);
        if (motionEvent.getAction() == 2 && abs > this.f60776l0 && (adapter = getAdapter()) != null && (adapter instanceof e9.a)) {
            e9.a aVar = (e9.a) adapter;
            if (aVar.d0(0) && !aVar.m()) {
                motionEvent.setAction(3);
                super.dispatchTouchEvent(motionEvent);
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean f1(Rect rect) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeVerticalScrollRange = computeVerticalScrollRange();
        int i3 = rect.top;
        int height2 = rect.height();
        int k3 = ar.k();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        if (i3 <= 0 && computeVerticalScrollOffset > 0) {
            smoothScrollBy((-this.T) * Z0(), 0);
            k1("handleMobileCellScroll:scrollUp");
            return true;
        }
        if ((i3 + height2 < height && iArr[1] + i3 + height2 < k3) || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            return false;
        }
        smoothScrollBy(this.T * Z0(), 0);
        k1("handleMobileCellScroll:scrollDown");
        return true;
    }

    public boolean g1() {
        return this.W;
    }

    public boolean h1() {
        return this.f60767c0;
    }

    public void init(Context context) {
        super.setOnScrollListener(this.f60790z0);
        this.T = (int) ((context.getResources().getDisplayMetrics().density * 8.0f) + 0.5f);
        this.M = O0(getContext(), 16.0f);
        this.f60775k0 = new p();
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f60776l0 = scaledTouchSlop;
        this.f60777m0 = scaledTouchSlop * scaledTouchSlop;
        this.f60778n0 = O0(getContext(), 2.0f);
        Paint paint = new Paint();
        this.f60779o0 = paint;
        paint.setColor(Color.argb(77, 0, 0, 0));
        this.f60779o0.setStyle(Paint.Style.STROKE);
        this.f60779o0.setStrokeWidth(1.0f);
    }

    public void n1(int i3, Runnable runnable) {
        View a16;
        if (getAdapter() instanceof com.qzone.widget.dynamicgridview.b) {
            if (!i1()) {
                ((com.qzone.widget.dynamicgridview.b) getAdapter()).o(i3);
                return;
            }
            if ((getAdapter() instanceof e9.a) && ((e9.a) getAdapter()).m()) {
                a16 = a1(R0(i3 + 1));
            } else {
                a16 = a1(R0(i3));
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a16, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
            ofFloat.setDuration(50L);
            ofFloat.addListener(new e(i3, runnable, a16));
            ofFloat.start();
        }
    }

    @Override // com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        k1("onInterceptTouchEvent->type=" + C0(motionEvent.getAction()) + "--scrollState:" + this.V);
        l1(String.format(">>>onInterceptTouchEvent:currentY=%s,mLastEventY=%s,mDownY=%s", Float.valueOf(motionEvent.getY()), Integer.valueOf(this.K), Integer.valueOf(this.J)));
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.qzone.widget.ExtendGridView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        k1("onTouchEvent->type=" + C0(motionEvent.getAction()) + "--scrollState:" + this.V);
        l1(String.format(">>>onTouchEvent:currentY=%s,mLastEventY=%s,mDownY=%s", Float.valueOf(motionEvent.getY()), Integer.valueOf(this.K), Integer.valueOf(this.J)));
        if (!this.f60767c0) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.I = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            this.J = y16;
            this.f60783s0 = pointToPosition(this.I, y16);
            if (this.W) {
                k1(String.format(">>>down:mDownY=%s", Integer.valueOf(this.J)));
                this.f60789y0 = System.currentTimeMillis();
                this.R = motionEvent.getPointerId(0);
                if (!isEnabled()) {
                    return false;
                }
            } else {
                k1(String.format(">>>onTouchEvent-down:mDownY=%s", Integer.valueOf(this.J)));
                if (L0(this.f60783s0)) {
                    this.f60775k0.removeMessages(1);
                    Message obtainMessage = this.f60775k0.obtainMessage(1);
                    obtainMessage.arg1 = this.f60783s0;
                    obtainMessage.what = 1;
                    this.f60775k0.sendMessageAtTime(obtainMessage, motionEvent.getDownTime() + B0);
                    this.f60789y0 = System.currentTimeMillis();
                    this.R = motionEvent.getPointerId(0);
                }
            }
        } else if (actionMasked != 1) {
            if (actionMasked == 2) {
                this.K = (int) motionEvent.getY();
                int x16 = (int) motionEvent.getX();
                this.L = x16;
                int i3 = this.K - this.J;
                int i16 = x16 - this.I;
                if (this.W) {
                    if (this.R != -1) {
                        if (Math.abs(i3) > 100) {
                            m1(String.format(">>>move:deltaY=%s,mLastEventY=%s,mDownY=%s", Integer.valueOf(i3), Integer.valueOf(this.K), Integer.valueOf(this.J)));
                        } else {
                            k1(String.format(">>>move:deltaY=%s,mLastEventY=%s,mDownY=%s", Integer.valueOf(i3), Integer.valueOf(this.K), Integer.valueOf(this.J)));
                        }
                        if (!this.Q) {
                            return true;
                        }
                        k1(">>>mHoverCellCurrentBounds->before:" + this.E.toString());
                        Rect rect = this.E;
                        Rect rect2 = this.F;
                        rect.offsetTo(rect2.left + i16 + this.H, rect2.top + i3 + this.G);
                        k1(">>>mHoverCellCurrentBounds->after:" + this.E.toString());
                        BitmapDrawable bitmapDrawable = this.D;
                        if (bitmapDrawable != null) {
                            bitmapDrawable.setBounds(this.E);
                        }
                        invalidate();
                        d1();
                        this.S = false;
                        e1();
                        return false;
                    }
                } else {
                    if ((i16 * i16) + (i3 * i3) > this.f60777m0) {
                        this.f60775k0.removeMessages(1);
                    }
                    int pointToPosition = pointToPosition(this.L, this.K);
                    if (this.f60784t0 && !this.f60765a0 && pointToPosition == this.f60783s0) {
                        int abs = Math.abs(i16);
                        double abs2 = Math.abs(i3) / abs;
                        if ((abs * 2 > this.f60776l0) && abs2 < A0) {
                            this.f60775k0.removeMessages(1);
                            s1(pointToPosition, 1);
                            k1("dispatchLongPress=>position:" + pointToPosition);
                            return false;
                        }
                    }
                    this.J = this.K;
                    this.I = this.L;
                }
            } else if (actionMasked != 3) {
                if (actionMasked != 6) {
                    k1("touchEvent=" + actionMasked);
                } else {
                    this.f60788x0 = false;
                    this.f60789y0 = 0L;
                    if (motionEvent.getPointerId((motionEvent.getAction() & 65280) >> 8) == this.R) {
                        v1();
                    }
                }
            } else if (this.W) {
                this.f60788x0 = false;
                this.f60789y0 = 0L;
                u1();
                t1();
            } else {
                this.f60775k0.removeMessages(1);
            }
        } else if (this.W) {
            this.f60788x0 = false;
            this.f60789y0 = 0L;
            v1();
            t1();
        } else {
            this.f60775k0.removeMessages(1);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void s1(int i3, int i16) {
        if (this.f60767c0) {
            if (this.W) {
                k1("startEditMode->already in edit mode");
                return;
            }
            if (L0(i3)) {
                requestDisallowInterceptTouchEvent(true);
                this.W = true;
                if (i3 != -1) {
                    r1(i3, i16);
                }
                t tVar = this.f60770f0;
                if (tVar != null) {
                    tVar.onEditModeChanged(true);
                }
            }
        }
    }

    public void setAllowHorizontalMoveStartDrag(boolean z16) {
        this.f60784t0 = z16;
    }

    public void setEditModeEnabled(boolean z16) {
        this.f60767c0 = z16;
    }

    public void setEnableScrollAccelerate(boolean z16) {
        this.f60787w0 = z16;
    }

    public void setHoverCellPadding(int i3, int i16, int i17, int i18) {
        this.f60782r0.set(i3, i16, i17, i18);
    }

    public void setLetParentInterceptTouchEventAt23(boolean z16) {
        this.f60771g0 = z16;
    }

    public void setNeedUpdateHoverCellAfterZoomOut(boolean z16) {
        this.f60785u0 = z16;
    }

    public void setOnDragListener(s sVar) {
        this.f60769e0 = sVar;
    }

    public void setOnEditModeChangeListener(t tVar) {
        this.f60770f0 = tVar;
    }

    @Override // com.tencent.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f60772h0 = onItemClickListener;
        super.setOnItemClickListener(this.f60773i0);
    }

    @Override // com.tencent.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.f60768d0 = onScrollListener;
    }

    public void x1(boolean z16) {
        if (this.D != null) {
            long j3 = this.P;
            if (j3 != -1) {
                BitmapDrawable S0 = S0(a1(j3));
                this.D = S0;
                if (z16) {
                    invalidate();
                } else {
                    invalidateDrawable(S0);
                }
            }
        }
    }

    private AnimatorSet N0(View view, float f16, float f17, float f18, float f19) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f16, f17);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", f18, f19);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(int i3) {
        s1(i3, 0);
        k1("dispatchLongPress=>position:" + i3);
    }

    @Override // com.tencent.widget.GridView, com.tencent.widget.AbsListView, com.tencent.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(View view) {
        this.f60781q0 = 1.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.9090909f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new n());
        ofFloat.addUpdateListener(new o());
        ofFloat.addListener(new a(view));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(int i3, int i16) {
        if (i3 == i16) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        com.qzone.widget.dynamicgridview.d Q0 = Q0();
        if (i3 < i16) {
            for (int i17 = i3 + 1; i17 <= i16 && i3 <= i16; i17++) {
                if (Q0.c(i17)) {
                    hashMap.put(Integer.valueOf(i17), Integer.valueOf(i3));
                    do {
                        i3++;
                    } while (!Q0.c(i3));
                }
            }
        } else {
            for (int i18 = i3 - 1; i18 >= i16 && i3 >= i16; i18--) {
                if (Q0.c(i18)) {
                    hashMap.put(Integer.valueOf(i18), Integer.valueOf(i3));
                    do {
                        i3--;
                    } while (!Q0.c(i3));
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            View a16 = a1(R0(intValue));
            View a17 = a1(R0(intValue2));
            linkedList.add(N0(a17, a16.getX() - a17.getX(), 0.0f, a16.getY() - a17.getY(), 0.0f));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(linkedList);
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new g());
        animatorSet.start();
    }

    private void H0() {
        this.f60781q0 = 0.9090909f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.9090909f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new k());
        ofFloat.addUpdateListener(new l());
        ofFloat.addListener(new m());
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements TypeEvaluator<Rect> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f60799a;

        b(View view) {
            this.f60799a = view;
        }

        public int b(int i3, int i16, float f16) {
            return (int) (i3 + (f16 * (i16 - i3)));
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect evaluate(float f16, Rect rect, Rect rect2) {
            if (rect != null && rect2 != null) {
                return new Rect(b(rect.left, rect2.left, f16), b(rect.top, rect2.top, f16), b(rect.right, rect2.right, f16), b(rect.bottom, rect2.bottom, f16));
            }
            if (this.f60799a != null) {
                return new Rect(this.f60799a.getLeft(), this.f60799a.getTop(), this.f60799a.getRight(), this.f60799a.getBottom());
            }
            return new Rect(0, 0, 0, 0);
        }
    }

    private BitmapDrawable S0(View view) {
        if (view == null) {
            return null;
        }
        int width = (((int) (view.getWidth() * 1.1f)) + 0) / 2;
        int height = (((int) (view.getHeight() * 1.1f)) + 0) / 2;
        int right = (view.getRight() + view.getLeft()) / 2;
        int bottom = (view.getBottom() + view.getTop()) / 2;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), T0(view, 1.1f, 0));
        this.F = new Rect(right - width, bottom - height, right + width, bottom + height);
        Rect rect = new Rect(this.F);
        this.E = rect;
        bitmapDrawable.setBounds(rect);
        return bitmapDrawable;
    }

    @Override // com.tencent.widget.AdapterView
    public int getPositionForView(View view) {
        if (view != null) {
            try {
            } catch (Throwable unused) {
                return -1;
            }
        }
        return super.getPositionForView(view);
    }

    public boolean L0(int i3) {
        com.qzone.widget.dynamicgridview.d Q0;
        if (i3 == -1 || (Q0 = Q0()) == null) {
            return false;
        }
        return Q0.c(i3);
    }

    public static String C0(int i3) {
        switch (i3) {
            case 0:
                return "ACTION_DOWN";
            case 1:
                return "ACTION_UP";
            case 2:
                return "ACTION_MOVE";
            case 3:
                return "ACTION_CANCEL";
            case 4:
                return "ACTION_OUTSIDE";
            case 5:
            case 6:
            default:
                int i16 = (65280 & i3) >> 8;
                int i17 = i3 & 255;
                if (i17 == 5) {
                    return "ACTION_POINTER_DOWN(" + i16 + ")";
                }
                if (i17 != 6) {
                    return Integer.toString(i3);
                }
                return "ACTION_POINTER_UP(" + i16 + ")";
            case 7:
                return "ACTION_HOVER_MOVE";
            case 8:
                return "ACTION_SCROLL";
            case 9:
                return "ACTION_HOVER_ENTER";
            case 10:
                return "ACTION_HOVER_EXIT";
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class e extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f60804d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Runnable f60805e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f60806f;

        e(int i3, Runnable runnable, View view) {
            this.f60804d = i3;
            this.f60805e = runnable;
            this.f60806f = view;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DynamicGridView.this.f60766b0 = false;
            DynamicGridView.this.w1();
            ((com.qzone.widget.dynamicgridview.b) DynamicGridView.this.getAdapter()).o(this.f60804d);
            Runnable runnable = this.f60805e;
            if (runnable != null) {
                DynamicGridView.this.post(runnable);
            }
            if ((DynamicGridView.this.getAdapter() instanceof e9.a) && ((e9.a) DynamicGridView.this.getAdapter()).m()) {
                new q().a(this.f60806f, this.f60804d + 1);
            } else {
                new q().a(this.f60806f, this.f60804d);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DynamicGridView.this.f60766b0 = true;
            DynamicGridView.this.w1();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    public static void l1(String str) {
    }

    public DynamicGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = 0;
        this.H = 0;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.N = new ArrayList();
        this.P = -1L;
        this.Q = false;
        this.R = -1;
        this.T = 0;
        this.U = false;
        this.V = 0;
        this.W = false;
        this.f60767c0 = false;
        this.f60771g0 = false;
        this.f60773i0 = new i();
        this.f60780p0 = 77;
        this.f60781q0 = -1.0f;
        this.f60782r0 = new Rect();
        this.f60783s0 = -1;
        this.f60784t0 = false;
        this.f60785u0 = false;
        this.f60786v0 = -1;
        this.f60787w0 = true;
        this.f60788x0 = false;
        this.f60789y0 = 0L;
        this.f60790z0 = new h();
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class j implements com.qzone.widget.dynamicgridview.d {
        j() {
        }

        @Override // com.qzone.widget.dynamicgridview.d
        public boolean c(int i3) {
            return false;
        }

        @Override // com.qzone.widget.dynamicgridview.d
        public void a(int i3, int i16) {
        }
    }

    public DynamicGridView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = 0;
        this.H = 0;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.L = -1;
        this.N = new ArrayList();
        this.P = -1L;
        this.Q = false;
        this.R = -1;
        this.T = 0;
        this.U = false;
        this.V = 0;
        this.W = false;
        this.f60767c0 = false;
        this.f60771g0 = false;
        this.f60773i0 = new i();
        this.f60780p0 = 77;
        this.f60781q0 = -1.0f;
        this.f60782r0 = new Rect();
        this.f60783s0 = -1;
        this.f60784t0 = false;
        this.f60785u0 = false;
        this.f60786v0 = -1;
        this.f60787w0 = true;
        this.f60788x0 = false;
        this.f60789y0 = 0L;
        this.f60790z0 = new h();
        init(context);
    }
}
