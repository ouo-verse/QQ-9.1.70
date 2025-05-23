package com.tencent.mobileqq.qqlive.room.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

@SuppressLint({"NewApi"})
/* loaded from: classes17.dex */
public class PortraitImageView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: l0, reason: collision with root package name */
    private static int f272111l0;
    private float[] C;
    private Bitmap D;
    private int E;
    private int F;
    private float G;
    private Runnable H;
    private Runnable I;
    Runnable J;
    private double K;
    ScaleGestureDetector L;
    RectF M;
    int N;
    int P;
    RectF Q;
    RectF R;
    float S;
    RegionView T;
    private GestureDetector U;
    int V;
    int W;

    /* renamed from: a0, reason: collision with root package name */
    int f272112a0;

    /* renamed from: b0, reason: collision with root package name */
    int f272113b0;

    /* renamed from: c0, reason: collision with root package name */
    int f272114c0;

    /* renamed from: d, reason: collision with root package name */
    private Matrix f272115d;

    /* renamed from: d0, reason: collision with root package name */
    int f272116d0;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f272117e;

    /* renamed from: e0, reason: collision with root package name */
    float f272118e0;

    /* renamed from: f, reason: collision with root package name */
    private Matrix f272119f;

    /* renamed from: f0, reason: collision with root package name */
    private float f272120f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f272121g0;

    /* renamed from: h, reason: collision with root package name */
    private Matrix f272122h;

    /* renamed from: h0, reason: collision with root package name */
    private float f272123h0;

    /* renamed from: i, reason: collision with root package name */
    private Matrix f272124i;

    /* renamed from: i0, reason: collision with root package name */
    private float f272125i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f272126j0;

    /* renamed from: k0, reason: collision with root package name */
    boolean f272127k0;

    /* renamed from: m, reason: collision with root package name */
    private Paint f272128m;

    /* renamed from: com.tencent.mobileqq.qqlive.room.widget.PortraitImageView$3, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f272130d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f272131e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f272132f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f272133h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f272134i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ float f272135m;
        final /* synthetic */ PortraitImageView this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            float min = Math.min(this.f272130d, (float) (System.currentTimeMillis() - this.f272131e));
            this.this$0.p(this.f272132f + (this.f272133h * min), this.f272134i, this.f272135m);
            if (min < this.f272130d) {
                this.this$0.post(this);
            }
        }
    }

    /* renamed from: com.tencent.mobileqq.qqlive.room.widget.PortraitImageView$4, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        float f272136d;

        /* renamed from: e, reason: collision with root package name */
        float f272137e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f272138f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f272139h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f272140i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ float f272141m;
        final /* synthetic */ PortraitImageView this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            float min = Math.min(this.f272138f, (float) (System.currentTimeMillis() - this.f272139h));
            float a16 = this.this$0.a(min, 0.0f, this.f272140i, this.f272138f);
            float a17 = this.this$0.a(min, 0.0f, this.f272141m, this.f272138f);
            this.this$0.n(a16 - this.f272136d, a17 - this.f272137e);
            PortraitImageView portraitImageView = this.this$0;
            portraitImageView.setImageMatrix(portraitImageView.e());
            this.f272136d = a16;
            this.f272137e = a17;
            if (min < this.f272138f) {
                this.this$0.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public class a extends e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PortraitImageView.this);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            ScaleGestureDetector scaleGestureDetector;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if ((motionEvent != null && motionEvent.getPointerCount() > 1) || ((motionEvent2 != null && motionEvent2.getPointerCount() > 1) || ((scaleGestureDetector = PortraitImageView.this.L) != null && scaleGestureDetector.isInProgress()))) {
                return false;
            }
            PortraitImageView portraitImageView = PortraitImageView.this;
            portraitImageView.removeCallbacks(portraitImageView.J);
            PortraitImageView.this.n(-f16, -f17);
            PortraitImageView portraitImageView2 = PortraitImageView.this;
            portraitImageView2.setImageMatrix(portraitImageView2.e());
            PortraitImageView.this.getClass();
            return true;
        }

        @Override // com.tencent.mobileqq.qqlive.room.widget.PortraitImageView.e, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            PortraitImageView.this.getClass();
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* loaded from: classes17.dex */
    public interface b {
    }

    /* loaded from: classes17.dex */
    public interface c {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class d extends f {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PortraitImageView.this);
            }
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) scaleGestureDetector)).booleanValue();
            }
            if (scaleGestureDetector != null && scaleGestureDetector.isInProgress()) {
                try {
                    PortraitImageView.this.p(Math.min(PortraitImageView.this.l(), Math.max(PortraitImageView.this.h() * scaleGestureDetector.getScaleFactor(), 0.1f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    PortraitImageView.this.invalidate();
                    return true;
                } catch (IllegalArgumentException e16) {
                    e16.printStackTrace();
                    return false;
                }
            }
            return false;
        }
    }

    /* loaded from: classes17.dex */
    public static class e implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
        static IPatchRedirector $redirector_;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return false;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent);
            }
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            return false;
        }
    }

    /* loaded from: classes17.dex */
    public static class f implements ScaleGestureDetector.OnScaleGestureListener {
        static IPatchRedirector $redirector_;

        public f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) scaleGestureDetector)).booleanValue();
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) scaleGestureDetector);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58443);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
        } else {
            f272111l0 = 20;
        }
    }

    public PortraitImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f272115d = new Matrix();
        this.f272117e = new Matrix();
        this.f272119f = new Matrix();
        this.f272122h = new Matrix();
        this.f272124i = new Matrix();
        this.C = new float[9];
        this.E = -1;
        this.F = -1;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = 0.0d;
        this.M = new RectF();
        this.Q = new RectF();
        this.R = new RectF();
        this.f272114c0 = 0;
        this.f272126j0 = -1;
        this.f272127k0 = false;
        k(context);
    }

    private int f(RectF rectF, RectF rectF2) {
        int i3;
        if (rectF.left > rectF2.left) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (rectF.right < rectF2.right) {
            i3 |= 2;
        }
        if (rectF.top > rectF2.top) {
            i3 |= 4;
        }
        if (rectF.bottom < rectF2.bottom) {
            return i3 | 8;
        }
        return i3;
    }

    private void k(Context context) {
        Paint paint = new Paint();
        this.f272128m = paint;
        paint.setDither(true);
        this.f272128m.setFilterBitmap(true);
        this.f272128m.setAntiAlias(true);
        this.I = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.widget.PortraitImageView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PortraitImageView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    PortraitImageView.this.postInvalidate();
                }
            }
        };
        this.L = new ScaleGestureDetector(context, new d());
        this.U = new GestureDetector(context, new a());
        setLayerType(2, null);
    }

    private void o(Bitmap bitmap, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        matrix.reset();
        float width2 = this.V / bitmap.getWidth();
        float height2 = this.W / bitmap.getHeight();
        if (width2 < 1.0f && height2 < 1.0f) {
            float width3 = width / bitmap.getWidth();
            float height3 = height / bitmap.getHeight();
            float min = Math.min(width3, width3);
            this.f272118e0 = min;
            if (min < 1.0f && (min < width2 || min < height2)) {
                this.f272118e0 = Math.max(width3, height3);
            }
        } else {
            this.f272118e0 = Math.max(width2, height2);
        }
        float f16 = this.f272118e0;
        matrix.setScale(f16, f16);
        matrix.postTranslate((width - (bitmap.getWidth() * this.f272118e0)) / 2.0f, (height - (bitmap.getHeight() * this.f272118e0)) / 2.0f);
        RectF rectF = this.Q;
        rectF.left = 0.0f;
        rectF.right = bitmap.getWidth() + 0.0f;
        RectF rectF2 = this.Q;
        rectF2.top = 0.0f;
        rectF2.bottom = 0.0f + bitmap.getHeight();
        matrix.mapRect(this.Q);
    }

    float a(float f16, float f17, float f18, float f19) {
        float f26 = (f16 / f19) - 1.0f;
        return (f18 * ((f26 * f26 * f26) + 1.0f)) + f17;
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.W;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.V;
    }

    public Bitmap d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.D;
    }

    public Matrix e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Matrix) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        this.f272119f.set(this.f272115d);
        this.f272119f.postConcat(this.f272117e);
        return this.f272119f;
    }

    public RectF g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (RectF) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.M;
    }

    public float h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Float) iPatchRedirector.redirect((short) 18, (Object) this)).floatValue();
        }
        return i(this.f272117e);
    }

    protected float i(Matrix matrix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Float) iPatchRedirector.redirect((short) 17, (Object) this, (Object) matrix)).floatValue();
        }
        if (this.D != null) {
            return j(matrix, 0);
        }
        return 1.0f;
    }

    protected float j(Matrix matrix, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Float) iPatchRedirector.redirect((short) 16, (Object) this, (Object) matrix, i3)).floatValue();
        }
        matrix.getValues(this.C);
        return this.C[i3];
    }

    protected float l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Float) iPatchRedirector.redirect((short) 24, (Object) this)).floatValue();
        }
        if (this.D == null) {
            return 1.0f;
        }
        return Math.max(r0.getWidth() / this.E, this.D.getHeight() / this.F) * 16.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void m(float f16, float f17, float f18) {
        float f19;
        float f26;
        float f27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        this.f272124i.set(this.f272117e);
        this.f272124i.postScale(f16, f16, f17, f18);
        this.f272124i.mapRect(this.R, this.Q);
        if (f(this.R, this.M) == 0) {
            this.f272117e.set(this.f272124i);
            return;
        }
        if (this.R.width() / this.M.width() >= 1.0f && this.R.height() / this.M.height() >= 1.0f) {
            this.f272117e.set(this.f272124i);
            RectF rectF = this.R;
            float f28 = rectF.left;
            RectF rectF2 = this.M;
            float f29 = rectF2.left;
            float f36 = 0.0f;
            if (f28 <= f29) {
                f28 = rectF.right;
                f29 = rectF2.right;
                if (f28 >= f29) {
                    f19 = 0.0f;
                    f26 = rectF.top;
                    f27 = rectF2.top;
                    if (f26 <= f27) {
                        f36 = f27 - f26;
                    } else {
                        float f37 = rectF.bottom;
                        float f38 = rectF2.bottom;
                        if (f37 < f38) {
                            f36 = f38 - f37;
                        }
                    }
                    n(f19, f36);
                }
            }
            f19 = f29 - f28;
            f26 = rectF.top;
            f27 = rectF2.top;
            if (f26 <= f27) {
            }
            n(f19, f36);
        }
    }

    protected void n(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f272124i.set(this.f272117e);
        this.f272124i.postTranslate(f16, f17);
        this.f272124i.mapRect(this.R, this.Q);
        int f18 = f(this.R, this.M);
        int i3 = f18 & 1;
        if (i3 == 0 && (f18 & 2) == 0) {
            this.f272117e.postTranslate(f16, 0.0f);
        } else if (i3 != 0 && f16 < 0.0f && this.R.right > this.M.right) {
            this.f272117e.postTranslate(f16, 0.0f);
        } else if ((f18 & 2) != 0 && f16 > 0.0f && this.R.left < this.M.left) {
            this.f272117e.postTranslate(f16, 0.0f);
        }
        int i16 = f18 & 4;
        if (i16 == 0 && (f18 & 8) == 0) {
            this.f272117e.postTranslate(0.0f, f17);
            return;
        }
        if (i16 != 0 && f17 < 0.0f && this.R.bottom > this.M.bottom) {
            this.f272117e.postTranslate(0.0f, f17);
        } else if ((f18 & 8) != 0 && f17 > 0.0f && this.R.top < this.M.top) {
            this.f272117e.postTranslate(0.0f, f17);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) canvas);
            return;
        }
        int save = canvas.save();
        Bitmap bitmap = this.D;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (getLayerType() == 2) {
                canvas.drawBitmap(this.D, this.f272122h, null);
            } else if (System.currentTimeMillis() - this.K > 250.0d) {
                canvas.drawBitmap(this.D, this.f272122h, this.f272128m);
                this.K = System.currentTimeMillis();
            } else {
                canvas.drawBitmap(this.D, this.f272122h, null);
                removeCallbacks(this.I);
                postDelayed(this.I, 250L);
            }
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        this.E = i17 - i3;
        this.F = i18 - i16;
        Runnable runnable = this.H;
        if (runnable != null) {
            this.H = null;
            runnable.run();
        }
        Bitmap bitmap = this.D;
        if (bitmap != null) {
            o(bitmap, this.f272115d);
            setImageMatrix(e());
        }
        this.N = getWidth() / 2;
        this.P = getHeight() / 2;
        setRestrict(this.f272112a0, this.f272113b0, this.f272114c0, this.f272116d0);
        int i19 = this.f272114c0;
        if (i19 == 0) {
            RectF rectF = this.M;
            int i26 = this.N;
            int i27 = this.V;
            rectF.left = i26 - (i27 / 2);
            rectF.right = i26 + (i27 / 2);
        } else {
            RectF rectF2 = this.M;
            rectF2.left = i19;
            rectF2.right = i19 + this.V;
        }
        int i28 = this.f272116d0;
        if (i28 == 0) {
            RectF rectF3 = this.M;
            int i29 = this.P;
            int i36 = this.W;
            rectF3.top = i29 - (i36 / 2);
            rectF3.bottom = i29 + (i36 / 2);
            return;
        }
        RectF rectF4 = this.M;
        rectF4.top = i28;
        rectF4.bottom = i28 + this.W;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.D != null) {
            this.L.onTouchEvent(motionEvent);
            if (!this.L.isInProgress()) {
                this.U.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction() & 255;
            int i3 = 0;
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            if (action == 6) {
                                int action2 = (motionEvent.getAction() & 65280) >> 8;
                                if (motionEvent.getPointerId(action2) == this.f272126j0) {
                                    if (action2 == 0) {
                                        i3 = 1;
                                    }
                                    this.f272123h0 = motionEvent.getX(i3);
                                    this.f272125i0 = motionEvent.getY(i3);
                                    this.f272126j0 = motionEvent.getPointerId(i3);
                                }
                            }
                        } else {
                            this.f272126j0 = -1;
                        }
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f272126j0);
                        if (findPointerIndex != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                            float x16 = motionEvent.getX(findPointerIndex);
                            float y16 = motionEvent.getY(findPointerIndex);
                            if (!this.L.isInProgress()) {
                                float f16 = x16 - this.f272123h0;
                                float f17 = y16 - this.f272125i0;
                                this.f272120f0 += f16;
                                this.f272121g0 += f17;
                                invalidate();
                            }
                            this.f272123h0 = x16;
                            this.f272125i0 = y16;
                        }
                    }
                } else {
                    this.f272126j0 = -1;
                }
            } else {
                float x17 = motionEvent.getX();
                float y17 = motionEvent.getY();
                this.f272123h0 = x17;
                this.f272125i0 = y17;
                this.f272126j0 = motionEvent.getPointerId(0);
            }
        }
        return true;
    }

    public void p(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        float f19 = this.G;
        if (f16 > f19) {
            f16 = f19;
        }
        m(f16 / h(), f17, f18);
        setImageMatrix(e());
    }

    public void setImageBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) bitmap);
            return;
        }
        if (bitmap == null) {
            return;
        }
        if (getWidth() <= 0) {
            this.H = new Runnable(bitmap) { // from class: com.tencent.mobileqq.qqlive.room.widget.PortraitImageView.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f272129d;

                {
                    this.f272129d = bitmap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PortraitImageView.this, (Object) bitmap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PortraitImageView.this.setImageBitmap(this.f272129d);
                    }
                }
            };
            return;
        }
        o(bitmap, this.f272115d);
        this.D = bitmap;
        this.f272117e.reset();
        setImageMatrix(e());
        this.G = l();
    }

    public void setImageMatrix(Matrix matrix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) matrix);
            return;
        }
        if (matrix != null && matrix.isIdentity()) {
            matrix = null;
        }
        if ((matrix == null && !this.f272122h.isIdentity()) || (matrix != null && !this.f272122h.equals(matrix))) {
            this.f272122h.set(matrix);
            invalidate();
        }
    }

    public void setOnDragOccurListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        }
    }

    public void setOnImageTouchedListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        }
    }

    public void setRegionView(RegionView regionView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) regionView);
        } else {
            this.T = regionView;
        }
    }

    public void setRestrict(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.f272112a0 = i3;
        this.f272113b0 = i16;
        this.f272114c0 = i17;
        this.f272116d0 = i18;
        int i19 = this.E;
        if (i19 > 0 && (i3 > i19 || i16 > this.F)) {
            int i26 = f272111l0;
            float f16 = this.S;
            float f17 = (i19 - (i26 * f16)) / i3;
            float f18 = (this.F - (i26 * f16)) / i16;
            if (f17 <= f18) {
                this.V = (int) (i3 * f17);
                this.W = (int) (i16 * f17);
                return;
            } else {
                this.V = (int) (i3 * f18);
                this.W = (int) (i16 * f18);
                return;
            }
        }
        this.V = i3;
        this.W = i16;
    }

    public PortraitImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
    }

    public PortraitImageView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            this.S = context.getResources().getDisplayMetrics().density;
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
    }
}
