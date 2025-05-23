package com.tencent.mobileqq.guild.media.widget.zoom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes14.dex */
public class ZoomLayout extends FrameLayout {
    private final Matrix C;
    private final Matrix D;
    private final float[] E;
    private float F;
    private float G;
    private float[] H;
    private boolean I;
    RectF J;
    RectF K;
    private FlingRunnable L;
    private AnimatedZoomRunnable M;
    private Interpolator N;
    private int P;
    boolean Q;
    boolean R;
    private float S;
    private float T;
    private boolean U;
    private final k V;
    private final h W;

    /* renamed from: a0, reason: collision with root package name */
    private List<g> f230038a0;

    /* renamed from: b0, reason: collision with root package name */
    private List<d> f230039b0;

    /* renamed from: c0, reason: collision with root package name */
    private List<f> f230040c0;

    /* renamed from: d, reason: collision with root package name */
    private ScaleGestureDetector f230041d;

    /* renamed from: d0, reason: collision with root package name */
    private List<e> f230042d0;

    /* renamed from: e, reason: collision with root package name */
    private GestureDetector f230043e;

    /* renamed from: e0, reason: collision with root package name */
    private List<b> f230044e0;

    /* renamed from: f, reason: collision with root package name */
    private a f230045f;

    /* renamed from: f0, reason: collision with root package name */
    private List<c> f230046f0;

    /* renamed from: h, reason: collision with root package name */
    private i f230047h;

    /* renamed from: i, reason: collision with root package name */
    private final Matrix f230048i;

    /* renamed from: m, reason: collision with root package name */
    private final Matrix f230049m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class AnimatedZoomRunnable implements Runnable {
        private float C;
        private float D;
        private float E;
        private float F;
        private float G;

        /* renamed from: d, reason: collision with root package name */
        boolean f230050d = false;

        /* renamed from: e, reason: collision with root package name */
        boolean f230051e = false;

        /* renamed from: f, reason: collision with root package name */
        private long f230052f = System.currentTimeMillis();

        /* renamed from: h, reason: collision with root package name */
        private float f230053h;

        /* renamed from: i, reason: collision with root package name */
        private float f230054i;

        /* renamed from: m, reason: collision with root package name */
        private float f230055m;

        AnimatedZoomRunnable() {
        }

        private void g() {
            if (!this.f230051e) {
                if (e()) {
                    ZoomLayout.this.V.c(ZoomLayout.this.O());
                }
                if (f()) {
                    ZoomLayout.this.W.c();
                }
            }
            this.f230051e = true;
        }

        private float h() {
            return ZoomLayout.this.N.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f230052f)) * 1.0f) / ZoomLayout.this.P));
        }

        void cancel() {
            this.f230050d = true;
            g();
        }

        boolean e() {
            return !com.tencent.mobileqq.guild.media.widget.zoom.b.b(this.f230053h, this.f230054i);
        }

        boolean f() {
            if (com.tencent.mobileqq.guild.media.widget.zoom.b.b(this.D, this.F) && com.tencent.mobileqq.guild.media.widget.zoom.b.b(this.E, this.G)) {
                return false;
            }
            return true;
        }

        boolean i() {
            float O = ZoomLayout.this.O();
            j(O, com.tencent.mobileqq.guild.media.widget.zoom.b.a(ZoomLayout.this.S, O, ZoomLayout.this.T), ZoomLayout.this.G, ZoomLayout.this.F, true);
            if (!ZoomLayout.this.M.e() && !ZoomLayout.this.M.f()) {
                return false;
            }
            ZoomLayout zoomLayout = ZoomLayout.this;
            ViewCompat.postOnAnimation(zoomLayout, zoomLayout.M);
            return true;
        }

        AnimatedZoomRunnable j(float f16, float f17, float f18, float f19, boolean z16) {
            this.f230055m = f18;
            this.C = f19;
            this.f230053h = f16;
            this.f230054i = f17;
            if (e()) {
                ZoomLayout.this.V.b(ZoomLayout.this.O());
            }
            if (z16) {
                this.D = ZoomLayout.this.M();
                this.E = ZoomLayout.this.N();
                boolean e16 = e();
                if (e16) {
                    Matrix matrix = ZoomLayout.this.f230048i;
                    float f26 = this.f230054i;
                    matrix.setScale(f26, f26, this.f230055m, this.C);
                    ZoomLayout.this.V();
                }
                PointF K = ZoomLayout.this.K();
                this.F = K.x;
                this.G = K.y;
                if (e16) {
                    Matrix matrix2 = ZoomLayout.this.f230048i;
                    float f27 = this.f230053h;
                    matrix2.setScale(f27, f27, ZoomLayout.this.G, ZoomLayout.this.F);
                    ZoomLayout.this.V();
                }
                if (f()) {
                    ZoomLayout.this.W.b();
                }
            }
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f230050d) {
                if (e() || f()) {
                    float h16 = h();
                    if (e()) {
                        float f16 = this.f230053h;
                        float f17 = f16 + ((this.f230054i - f16) * h16);
                        ZoomLayout.this.T(f17, this.f230055m, this.C);
                        ZoomLayout.this.V.a(f17);
                    }
                    if (f()) {
                        float f18 = this.D;
                        float f19 = f18 + ((this.F - f18) * h16);
                        float f26 = this.E;
                        ZoomLayout.this.R(f19, f26 + ((this.G - f26) * h16), false);
                        ZoomLayout.this.W.a();
                    }
                    if (h16 < 1.0f) {
                        ViewCompat.postOnAnimation(ZoomLayout.this, this);
                    } else {
                        g();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final com.tencent.mobileqq.guild.media.widget.zoom.a f230056d;

        /* renamed from: e, reason: collision with root package name */
        private int f230057e;

        /* renamed from: f, reason: collision with root package name */
        private int f230058f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f230059h = false;

        FlingRunnable(Context context) {
            this.f230056d = com.tencent.mobileqq.guild.media.widget.zoom.a.f(context);
        }

        private void f() {
            if (!this.f230059h) {
                ZoomLayout.this.W.c();
            }
            this.f230059h = true;
        }

        void e() {
            this.f230056d.c(true);
            f();
        }

        void g(int i3, int i16) {
            int i17;
            int i18;
            int i19;
            int i26;
            int round = Math.round(ZoomLayout.this.K.left);
            if (ZoomLayout.this.K.width() < ZoomLayout.this.J.width()) {
                i17 = Math.round(ZoomLayout.this.J.left);
                i18 = Math.round(ZoomLayout.this.J.width() - ZoomLayout.this.K.width());
            } else {
                i17 = round;
                i18 = i17;
            }
            int round2 = Math.round(ZoomLayout.this.K.top);
            if (ZoomLayout.this.K.height() < ZoomLayout.this.J.height()) {
                int round3 = Math.round(ZoomLayout.this.J.top);
                ZoomLayout zoomLayout = ZoomLayout.this;
                i19 = round3;
                i26 = Math.round(zoomLayout.J.bottom - zoomLayout.K.bottom);
            } else {
                i19 = round2;
                i26 = i19;
            }
            this.f230057e = round;
            this.f230058f = round2;
            if (round == i18 && round2 == i26) {
                this.f230059h = true;
            } else {
                this.f230056d.b(round, round2, i3, i16, i17, i18, i19, i26, 0, 0);
                ZoomLayout.this.W.b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f230056d.g() && this.f230056d.a()) {
                int d16 = this.f230056d.d();
                int e16 = this.f230056d.e();
                if (ZoomLayout.this.S(this.f230057e - d16, this.f230058f - e16, true)) {
                    ZoomLayout.this.W.a();
                }
                this.f230057e = d16;
                this.f230058f = e16;
                ViewCompat.postOnAnimation(ZoomLayout.this, this);
                return;
            }
            f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface b {
        boolean a(ZoomLayout zoomLayout, j jVar);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface c {
        void a(ZoomLayout zoomLayout, j jVar);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface d {
        void a(ZoomLayout zoomLayout);

        void b(ZoomLayout zoomLayout);

        void c(ZoomLayout zoomLayout);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface e {
        boolean a(ZoomLayout zoomLayout, j jVar);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface f {
        boolean a(ZoomLayout zoomLayout, int i3, j jVar);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface g {
        void a(ZoomLayout zoomLayout, float f16);

        void b(ZoomLayout zoomLayout, float f16);

        void c(ZoomLayout zoomLayout, float f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class h {

        /* renamed from: a, reason: collision with root package name */
        int f230063a = 0;

        h() {
        }

        void a() {
            if (ZoomLayout.this.f230039b0 != null) {
                int size = ZoomLayout.this.f230039b0.size();
                for (int i3 = 0; i3 < size; i3++) {
                    d dVar = (d) ZoomLayout.this.f230039b0.get(i3);
                    if (dVar != null) {
                        dVar.a(ZoomLayout.this);
                    }
                }
            }
        }

        void b() {
            int i3 = this.f230063a;
            this.f230063a = i3 + 1;
            if (i3 == 0 && ZoomLayout.this.f230039b0 != null) {
                int size = ZoomLayout.this.f230039b0.size();
                for (int i16 = 0; i16 < size; i16++) {
                    d dVar = (d) ZoomLayout.this.f230039b0.get(i16);
                    if (dVar != null) {
                        dVar.b(ZoomLayout.this);
                    }
                }
            }
        }

        void c() {
            int i3 = this.f230063a - 1;
            this.f230063a = i3;
            if (i3 == 0 && ZoomLayout.this.f230039b0 != null) {
                int size = ZoomLayout.this.f230039b0.size();
                for (int i16 = 0; i16 < size; i16++) {
                    d dVar = (d) ZoomLayout.this.f230039b0.get(i16);
                    if (dVar != null) {
                        dVar.c(ZoomLayout.this);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class i implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        private int f230065d;

        /* renamed from: e, reason: collision with root package name */
        private int f230066e;

        /* renamed from: f, reason: collision with root package name */
        private int f230067f;

        /* renamed from: h, reason: collision with root package name */
        private int f230068h;

        i() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z16;
            int i3 = this.f230065d;
            int i16 = this.f230066e;
            int i17 = this.f230067f;
            int i18 = this.f230068h;
            this.f230065d = ZoomLayout.this.getLeft();
            this.f230066e = ZoomLayout.this.getTop();
            this.f230067f = ZoomLayout.this.getRight();
            int bottom = ZoomLayout.this.getBottom();
            this.f230068h = bottom;
            if (i3 == this.f230065d && i16 == this.f230066e && i17 == this.f230067f && i18 == bottom) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                ZoomLayout.this.V();
                PointF K = ZoomLayout.this.K();
                ZoomLayout.this.R(K.x, K.y, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        View f230070a;

        /* renamed from: b, reason: collision with root package name */
        float f230071b;

        /* renamed from: c, reason: collision with root package name */
        float f230072c;

        /* renamed from: d, reason: collision with root package name */
        float f230073d;

        /* renamed from: e, reason: collision with root package name */
        float f230074e;

        /* renamed from: f, reason: collision with root package name */
        float f230075f;

        /* renamed from: g, reason: collision with root package name */
        float f230076g;

        /* renamed from: h, reason: collision with root package name */
        boolean f230077h;

        j(ZoomLayout zoomLayout, MotionEvent motionEvent) {
            this.f230070a = zoomLayout;
            this.f230071b = motionEvent.getX();
            this.f230072c = motionEvent.getY();
            zoomLayout.H[0] = this.f230071b;
            zoomLayout.H[1] = this.f230072c;
            zoomLayout.a0(zoomLayout.H);
            View childAt = zoomLayout.getChildAt(0);
            this.f230073d = zoomLayout.H[0] - childAt.getLeft();
            this.f230074e = zoomLayout.H[1] - childAt.getTop();
            this.f230075f = this.f230073d / childAt.getWidth();
            this.f230076g = this.f230074e / childAt.getHeight();
            this.f230077h = zoomLayout.J.contains(this.f230071b, this.f230072c);
        }

        public String toString() {
            return String.format(Locale.US, "TapInfo[ absX:%.0f, absY:%.0f, relX:%.0f, relY:%.0f, percentX:%.2f, percentY:%.2f, contentClicked:%s ]", Float.valueOf(this.f230071b), Float.valueOf(this.f230072c), Float.valueOf(this.f230073d), Float.valueOf(this.f230074e), Float.valueOf(this.f230075f), Float.valueOf(this.f230076g), Boolean.valueOf(this.f230077h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class k {

        /* renamed from: a, reason: collision with root package name */
        int f230078a = 0;

        k() {
        }

        void a(float f16) {
            if (ZoomLayout.this.f230038a0 != null) {
                int size = ZoomLayout.this.f230038a0.size();
                for (int i3 = 0; i3 < size; i3++) {
                    g gVar = (g) ZoomLayout.this.f230038a0.get(i3);
                    if (gVar != null) {
                        gVar.b(ZoomLayout.this, f16);
                    }
                }
            }
        }

        void b(float f16) {
            int i3 = this.f230078a;
            this.f230078a = i3 + 1;
            if (i3 == 0 && ZoomLayout.this.f230038a0 != null) {
                int size = ZoomLayout.this.f230038a0.size();
                for (int i16 = 0; i16 < size; i16++) {
                    g gVar = (g) ZoomLayout.this.f230038a0.get(i16);
                    if (gVar != null) {
                        gVar.c(ZoomLayout.this, f16);
                    }
                }
            }
        }

        void c(float f16) {
            int i3 = this.f230078a - 1;
            this.f230078a = i3;
            if (i3 == 0 && ZoomLayout.this.f230038a0 != null) {
                int size = ZoomLayout.this.f230038a0.size();
                for (int i16 = 0; i16 < size; i16++) {
                    g gVar = (g) ZoomLayout.this.f230038a0.get(i16);
                    if (gVar != null) {
                        gVar.a(ZoomLayout.this, f16);
                    }
                }
            }
        }
    }

    public ZoomLayout(Context context) {
        super(context);
        this.f230048i = new Matrix();
        this.f230049m = new Matrix();
        this.C = new Matrix();
        this.D = new Matrix();
        this.E = new float[9];
        this.H = new float[6];
        this.I = true;
        this.J = new RectF();
        this.K = new RectF();
        this.N = new DecelerateInterpolator();
        this.P = 250;
        this.Q = true;
        this.R = false;
        this.S = 1.0f;
        this.T = 3.0f;
        this.U = true;
        this.V = new k();
        this.W = new h();
        Q(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        FlingRunnable flingRunnable = this.L;
        if (flingRunnable != null) {
            flingRunnable.e();
            this.L = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        AnimatedZoomRunnable animatedZoomRunnable = this.M;
        if (animatedZoomRunnable != null) {
            animatedZoomRunnable.cancel();
            this.M = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(MotionEvent motionEvent) {
        List<b> list = this.f230044e0;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.f230044e0.get(i3);
                if (bVar != null) {
                    bVar.a(this, new j(this, motionEvent));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(MotionEvent motionEvent) {
        List<c> list = this.f230046f0;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = this.f230046f0.get(i3);
                if (cVar != null) {
                    cVar.a(this, new j(this, motionEvent));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(MotionEvent motionEvent) {
        List<e> list = this.f230042d0;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = this.f230042d0.get(i3);
                if (eVar != null) {
                    eVar.a(this, new j(this, motionEvent));
                }
            }
        }
    }

    private void I(int i3, MotionEvent motionEvent) {
        List<f> list = this.f230040c0;
        if (list != null) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                f fVar = this.f230040c0.get(i16);
                if (fVar != null) {
                    fVar.a(this, i3, new j(this, motionEvent));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(float f16, float f17) {
        float[] fArr = this.H;
        fArr[0] = f16;
        fArr[1] = f17;
        a0(fArr);
        float L = L(this.f230048i, 2);
        float L2 = L(this.f230048i, 5);
        float O = O();
        float[] fArr2 = this.H;
        T(O, fArr2[0], fArr2[1]);
        R((L(this.f230048i, 2) - L) + M(), (L(this.f230048i, 5) - L2) + N(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF K() {
        PointF pointF = new PointF(M(), N());
        if (this.J.width() < this.K.width()) {
            pointF.x += this.J.centerX() - this.K.centerX();
        } else {
            RectF rectF = this.J;
            float f16 = rectF.right;
            RectF rectF2 = this.K;
            float f17 = rectF2.right;
            if (f16 < f17) {
                pointF.x += f16 - f17;
            } else {
                float f18 = rectF.left;
                float f19 = rectF2.left;
                if (f18 > f19) {
                    pointF.x += f18 - f19;
                }
            }
        }
        if (this.J.height() < this.K.height()) {
            pointF.y += this.J.centerY() - this.K.centerY();
        } else {
            RectF rectF3 = this.J;
            float f26 = rectF3.bottom;
            RectF rectF4 = this.K;
            float f27 = rectF4.bottom;
            if (f26 < f27) {
                pointF.y += f26 - f27;
            } else {
                float f28 = rectF3.top;
                float f29 = rectF4.top;
                if (f28 > f29) {
                    pointF.y += f28 - f29;
                }
            }
        }
        return pointF;
    }

    private float L(Matrix matrix, int i3) {
        matrix.getValues(this.E);
        return this.E[i3];
    }

    private RectF P() {
        RectF rectF = new RectF();
        float width = this.J.width() - this.K.width();
        if (width < 0.0f) {
            float round = Math.round((this.K.width() - this.J.width()) / 2.0f);
            RectF rectF2 = this.J;
            float f16 = rectF2.left;
            if (round > f16) {
                rectF.left = 0.0f;
                rectF.right = round - rectF2.left;
            } else {
                rectF.left = round - f16;
                rectF.right = 0.0f;
            }
        } else {
            float f17 = this.J.left - this.K.left;
            rectF.left = f17;
            rectF.right = f17 + width;
        }
        float height = this.J.height() - this.K.height();
        if (height < 0.0f) {
            float round2 = Math.round((this.K.height() - this.J.height()) / 2.0f);
            float f18 = this.J.top;
            if (round2 > f18) {
                rectF.top = f18 - round2;
                rectF.bottom = 0.0f;
            } else {
                rectF.top = round2 - f18;
                rectF.bottom = 0.0f;
            }
        } else {
            float f19 = this.J.top - this.K.top;
            rectF.top = f19;
            rectF.bottom = f19 + height;
        }
        return rectF;
    }

    private void Q(Context context, AttributeSet attributeSet) {
        this.f230045f = new a();
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(context, this.f230045f);
        this.f230041d = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
        this.f230043e = new GestureDetector(context, this.f230045f);
        this.f230047h = new i();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f230047h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R(float f16, float f17, boolean z16) {
        return S(f16 - M(), f17 - N(), z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean S(float f16, float f17, boolean z16) {
        if (z16) {
            RectF P = P();
            f16 = com.tencent.mobileqq.guild.media.widget.zoom.b.a(P.left, f16, P.right);
            f17 = com.tencent.mobileqq.guild.media.widget.zoom.b.a(P.top, f17, P.bottom);
        }
        float M = f16 + M();
        float N = f17 + N();
        if (com.tencent.mobileqq.guild.media.widget.zoom.b.b(M, M()) && com.tencent.mobileqq.guild.media.widget.zoom.b.b(N, N())) {
            return false;
        }
        this.C.setTranslate(-M, -N);
        V();
        invalidate();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(float f16, float f17, float f18) {
        this.G = f17;
        this.F = f18;
        this.f230048i.setScale(f16, f16, f17, f18);
        V();
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.f230048i.invert(this.f230049m);
        this.C.invert(this.D);
        com.tencent.mobileqq.guild.media.widget.zoom.c.e(this.K, 0.0f, 0.0f, getWidth(), getHeight());
        if (getChildAt(0) != null) {
            com.tencent.mobileqq.guild.media.widget.zoom.c.e(this.J, r0.getLeft(), r0.getTop(), r0.getRight(), r0.getBottom());
            Y(this.J);
        } else {
            float centerX = this.K.centerX();
            float centerY = this.K.centerY();
            this.J.set(centerX, centerY, centerX, centerY);
        }
    }

    public static void W(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    private void X(Rect rect) {
        com.tencent.mobileqq.guild.media.widget.zoom.c.a(this.H, rect);
        float[] Z = Z(this.H);
        this.H = Z;
        com.tencent.mobileqq.guild.media.widget.zoom.c.d(rect, Z);
    }

    private void Y(RectF rectF) {
        com.tencent.mobileqq.guild.media.widget.zoom.c.b(this.H, rectF);
        float[] Z = Z(this.H);
        this.H = Z;
        com.tencent.mobileqq.guild.media.widget.zoom.c.f(rectF, Z);
    }

    private float[] Z(float[] fArr) {
        this.f230048i.mapPoints(fArr);
        this.C.mapPoints(fArr);
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] a0(float[] fArr) {
        this.D.mapPoints(fArr);
        this.f230049m.mapPoints(fArr);
        return fArr;
    }

    public float M() {
        return -L(this.C, 2);
    }

    public float N() {
        return -L(this.C, 5);
    }

    public float O() {
        return L(this.f230048i, 0);
    }

    public boolean U() {
        return !com.tencent.mobileqq.guild.media.widget.zoom.b.c(O(), 1.0f, 0.05f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(-M(), -N());
        float O = O();
        canvas.scale(O, O, this.G, this.F);
        try {
            super.dispatchDraw(canvas);
        } catch (Exception unused) {
        }
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.H[0] = motionEvent.getX();
        this.H[1] = motionEvent.getY();
        a0(this.H);
        float[] fArr = this.H;
        motionEvent.setLocation(fArr[0], fArr[1]);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        X(rect);
        float O = O();
        iArr[0] = (int) (iArr[0] * O);
        iArr[1] = (int) (iArr[1] * O);
        return super.invalidateChildInParent(iArr, rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        W(this, this.f230047h);
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.U;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17 = false;
        this.H[0] = motionEvent.getX();
        this.H[1] = motionEvent.getY();
        Z(this.H);
        float[] fArr = this.H;
        motionEvent.setLocation(fArr[0], fArr[1]);
        if (!this.U) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        I(action, motionEvent);
        boolean onTouchEvent = this.f230041d.onTouchEvent(motionEvent);
        if (!this.f230043e.onTouchEvent(motionEvent) && !onTouchEvent) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (action == 1) {
            if (this.f230045f.a(motionEvent) || z16) {
                z17 = true;
            }
            return z17;
        }
        return z16;
    }

    public void setAllowOverScale(boolean z16) {
        this.I = z16;
    }

    public void setAllowParentInterceptOnEdge(boolean z16) {
        this.Q = z16;
    }

    public void setAllowParentInterceptOnScaled(boolean z16) {
        this.R = z16;
    }

    public void setAllowZoom(boolean z16) {
        this.U = z16;
    }

    public void setMaxScale(float f16) {
        this.T = f16;
        if (f16 < this.S) {
            setMinScale(f16);
        }
    }

    public void setMinScale(float f16) {
        this.S = f16;
        if (f16 > this.T) {
            setMaxScale(f16);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new IllegalStateException("Cannot set OnClickListener, please use OnTapListener.");
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        throw new IllegalStateException("Cannot set OnLongClickListener, please use OnLongTabListener.");
    }

    public void setScale(float f16) {
        setScale(f16, true);
    }

    public void setZoomDuration(int i3) {
        if (i3 < 0) {
            i3 = 250;
        }
        this.P = i3;
    }

    public void setZoomInterpolator(Interpolator interpolator) {
        this.N = interpolator;
    }

    public void setScale(float f16, boolean z16) {
        getChildAt(0);
        setScale(f16, getRight() / 2.0f, getBottom() / 2.0f, z16);
    }

    public void setScale(float f16, float f17, float f18, boolean z16) {
        if (this.U) {
            J(f17, f18);
            if (!this.I) {
                f16 = com.tencent.mobileqq.guild.media.widget.zoom.b.a(this.S, f16, this.T);
            }
            float f19 = f16;
            if (z16) {
                AnimatedZoomRunnable animatedZoomRunnable = new AnimatedZoomRunnable();
                this.M = animatedZoomRunnable;
                animatedZoomRunnable.j(O(), f19, this.G, this.F, true);
                ViewCompat.postOnAnimation(this, this.M);
                return;
            }
            this.V.b(O());
            T(f19, this.G, this.F);
            this.V.a(f19);
            this.V.c(f19);
        }
    }

    public ZoomLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f230048i = new Matrix();
        this.f230049m = new Matrix();
        this.C = new Matrix();
        this.D = new Matrix();
        this.E = new float[9];
        this.H = new float[6];
        this.I = true;
        this.J = new RectF();
        this.K = new RectF();
        this.N = new DecelerateInterpolator();
        this.P = 250;
        this.Q = true;
        this.R = false;
        this.S = 1.0f;
        this.T = 3.0f;
        this.U = true;
        this.V = new k();
        this.W = new h();
        Q(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements ScaleGestureDetector.OnScaleGestureListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

        /* renamed from: d, reason: collision with root package name */
        private float f230060d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f230061e = false;

        a() {
        }

        boolean a(MotionEvent motionEvent) {
            boolean z16;
            boolean z17 = true;
            if (this.f230061e) {
                ZoomLayout.this.W.c();
                this.f230061e = false;
                z16 = true;
            } else {
                z16 = false;
            }
            if (ZoomLayout.this.M == null || ZoomLayout.this.M.f230051e) {
                ZoomLayout zoomLayout = ZoomLayout.this;
                zoomLayout.M = new AnimatedZoomRunnable();
                if (!ZoomLayout.this.M.i() && !z16) {
                    z17 = false;
                }
                return z17;
            }
            return z16;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if ((motionEvent.getAction() & 255) == 1) {
                ZoomLayout.this.F(motionEvent);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.f230060d = ZoomLayout.this.O();
            ZoomLayout.this.requestDisallowInterceptTouchEvent(true);
            ZoomLayout.this.D();
            ZoomLayout.this.E();
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            float O = ZoomLayout.this.O();
            if (com.tencent.mobileqq.guild.media.widget.zoom.b.b(com.tencent.mobileqq.guild.media.widget.zoom.b.a(ZoomLayout.this.S, O, ZoomLayout.this.T), O)) {
                ZoomLayout zoomLayout = ZoomLayout.this;
                zoomLayout.L = new FlingRunnable(zoomLayout.getContext());
                ZoomLayout.this.L.g((int) f16, (int) f17);
                ZoomLayout zoomLayout2 = ZoomLayout.this;
                ViewCompat.postOnAnimation(zoomLayout2, zoomLayout2.L);
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (!ZoomLayout.this.f230041d.isInProgress()) {
                ZoomLayout.this.G(motionEvent);
            }
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float O = ZoomLayout.this.O() * scaleGestureDetector.getScaleFactor();
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (!Float.isNaN(scaleFactor) && !Float.isInfinite(scaleFactor)) {
                ZoomLayout zoomLayout = ZoomLayout.this;
                zoomLayout.T(O, zoomLayout.G, ZoomLayout.this.F);
                ZoomLayout.this.V.a(O);
                return true;
            }
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            ZoomLayout.this.V.b(ZoomLayout.this.O());
            ZoomLayout.this.J(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            ZoomLayout zoomLayout = ZoomLayout.this;
            zoomLayout.M = new AnimatedZoomRunnable();
            ZoomLayout.this.M.i();
            ZoomLayout.this.V.c(ZoomLayout.this.O());
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            if (motionEvent2.getPointerCount() != 1 || ZoomLayout.this.f230041d.isInProgress()) {
                return false;
            }
            if (!this.f230061e) {
                ZoomLayout.this.W.b();
                this.f230061e = true;
            }
            boolean S = ZoomLayout.this.S(f16, f17, true);
            if (S) {
                ZoomLayout.this.W.a();
            }
            ZoomLayout zoomLayout = ZoomLayout.this;
            if (zoomLayout.Q && !S && (!zoomLayout.U() || ZoomLayout.this.R)) {
                ZoomLayout.this.requestDisallowInterceptTouchEvent(false);
            }
            return S;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            ZoomLayout.this.H(motionEvent);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }
    }

    public ZoomLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f230048i = new Matrix();
        this.f230049m = new Matrix();
        this.C = new Matrix();
        this.D = new Matrix();
        this.E = new float[9];
        this.H = new float[6];
        this.I = true;
        this.J = new RectF();
        this.K = new RectF();
        this.N = new DecelerateInterpolator();
        this.P = 250;
        this.Q = true;
        this.R = false;
        this.S = 1.0f;
        this.T = 3.0f;
        this.U = true;
        this.V = new k();
        this.W = new h();
        Q(context, attributeSet);
    }
}
