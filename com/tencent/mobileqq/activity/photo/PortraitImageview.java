package com.tencent.mobileqq.activity.photo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public class PortraitImageview extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: i0, reason: collision with root package name */
    private static int f184036i0;
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
    int f184037a0;

    /* renamed from: b0, reason: collision with root package name */
    int f184038b0;

    /* renamed from: c0, reason: collision with root package name */
    float f184039c0;

    /* renamed from: d, reason: collision with root package name */
    private Matrix f184040d;

    /* renamed from: d0, reason: collision with root package name */
    private float f184041d0;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f184042e;

    /* renamed from: e0, reason: collision with root package name */
    private float f184043e0;

    /* renamed from: f, reason: collision with root package name */
    private Matrix f184044f;

    /* renamed from: f0, reason: collision with root package name */
    private float f184045f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f184046g0;

    /* renamed from: h, reason: collision with root package name */
    private Matrix f184047h;

    /* renamed from: h0, reason: collision with root package name */
    private int f184048h0;

    /* renamed from: i, reason: collision with root package name */
    private Matrix f184049i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f184050m;

    /* renamed from: com.tencent.mobileqq.activity.photo.PortraitImageview$4, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        float f184058d;

        /* renamed from: e, reason: collision with root package name */
        float f184059e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float f184060f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f184061h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f184062i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ float f184063m;
        final /* synthetic */ PortraitImageview this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            float min = Math.min(this.f184060f, (float) (System.currentTimeMillis() - this.f184061h));
            float a16 = this.this$0.a(min, 0.0f, this.f184062i, this.f184060f);
            float a17 = this.this$0.a(min, 0.0f, this.f184063m, this.f184060f);
            this.this$0.n(a16 - this.f184058d, a17 - this.f184059e);
            PortraitImageview portraitImageview = this.this$0;
            portraitImageview.setImageMatrix(portraitImageview.e());
            this.f184058d = a16;
            this.f184059e = a17;
            if (min < this.f184060f) {
                this.this$0.post(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PortraitImageview.this);
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
            }
            if (PortraitImageview.this.h() > PortraitImageview.this.q()) {
                PortraitImageview portraitImageview = PortraitImageview.this;
                portraitImageview.r(portraitImageview.q());
                return true;
            }
            PortraitImageview portraitImageview2 = PortraitImageview.this;
            portraitImageview2.t(portraitImageview2.q() * 3.0f, motionEvent.getX(), motionEvent.getY(), 350.0f);
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            ScaleGestureDetector scaleGestureDetector;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, motionEvent, motionEvent2, Float.valueOf(f16), Float.valueOf(f17))).booleanValue();
            }
            if ((motionEvent != null && motionEvent.getPointerCount() > 1) || ((motionEvent2 != null && motionEvent2.getPointerCount() > 1) || ((scaleGestureDetector = PortraitImageview.this.L) != null && scaleGestureDetector.isInProgress()))) {
                return false;
            }
            PortraitImageview portraitImageview = PortraitImageview.this;
            portraitImageview.removeCallbacks(portraitImageview.J);
            PortraitImageview.this.n(-f16, -f17);
            PortraitImageview portraitImageview2 = PortraitImageview.this;
            portraitImageview2.setImageMatrix(portraitImageview2.e());
            return true;
        }

        @Override // com.tencent.mobileqq.activity.photo.PortraitImageview.d, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            PortraitImageview.this.getClass();
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c extends e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PortraitImageview.this);
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
                    PortraitImageview.this.s(Math.min(PortraitImageview.this.l(), Math.max(PortraitImageview.this.h() * scaleGestureDetector.getScaleFactor(), 0.1f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    PortraitImageview.this.invalidate();
                    return true;
                } catch (IllegalArgumentException e16) {
                    e16.printStackTrace();
                    return false;
                }
            }
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
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

    /* loaded from: classes10.dex */
    public static class e implements ScaleGestureDetector.OnScaleGestureListener {
        static IPatchRedirector $redirector_;

        public e() {
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45902);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
        } else {
            f184036i0 = 20;
        }
    }

    public PortraitImageview(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f184040d = new Matrix();
        this.f184042e = new Matrix();
        this.f184044f = new Matrix();
        this.f184047h = new Matrix();
        this.f184049i = new Matrix();
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
        this.f184048h0 = -1;
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
        this.f184050m = paint;
        paint.setDither(true);
        this.f184050m.setFilterBitmap(true);
        this.f184050m.setAntiAlias(true);
        this.I = new Runnable() { // from class: com.tencent.mobileqq.activity.photo.PortraitImageview.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PortraitImageview.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    PortraitImageview.this.postInvalidate();
                }
            }
        };
        this.L = new ScaleGestureDetector(context, new c());
        this.U = new GestureDetector(context, new a());
        setLayerType(2, null);
    }

    private void p(Bitmap bitmap, Matrix matrix) {
        float width = getWidth();
        float height = getHeight();
        matrix.reset();
        float width2 = this.V / bitmap.getWidth();
        float height2 = this.W / bitmap.getHeight();
        if (width2 < 1.0f && height2 < 1.0f) {
            float width3 = width / bitmap.getWidth();
            float height3 = height / bitmap.getHeight();
            float min = Math.min(width3, width3);
            this.f184039c0 = min;
            if (min >= 1.0f) {
                this.f184039c0 = 1.0f;
            } else if (min < width2 || min < height2) {
                this.f184039c0 = Math.max(width3, height3);
            }
        } else {
            this.f184039c0 = Math.max(width2, height2);
        }
        float f16 = this.f184039c0;
        matrix.setScale(f16, f16);
        matrix.postTranslate((width - (bitmap.getWidth() * this.f184039c0)) / 2.0f, (height - (bitmap.getHeight() * this.f184039c0)) / 2.0f);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.W;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.V;
    }

    public Bitmap d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.D;
    }

    public Matrix e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Matrix) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        this.f184044f.set(this.f184040d);
        this.f184044f.postConcat(this.f184042e);
        return this.f184044f;
    }

    public RectF g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (RectF) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.M;
    }

    public float h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Float) iPatchRedirector.redirect((short) 18, (Object) this)).floatValue();
        }
        return i(this.f184042e);
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

    protected void m(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        RectF rectF = this.M;
        float f19 = rectF.bottom;
        if (f18 > f19) {
            f18 = f19;
        }
        float f26 = rectF.top;
        if (f18 < f26) {
            f18 = f26;
        }
        float f27 = rectF.right;
        if (f17 > f27) {
            f17 = f27;
        }
        float f28 = rectF.left;
        if (f17 < f28) {
            f17 = f28;
        }
        this.f184049i.set(this.f184042e);
        this.f184049i.postScale(f16, f16, f17, f18);
        this.f184049i.mapRect(this.R, this.Q);
        if (f(this.R, this.M) == 0) {
            this.f184042e.set(this.f184049i);
            return;
        }
        if (this.R.width() / this.M.width() >= 1.0f && this.R.height() / this.M.height() >= 1.0f) {
            this.f184042e.mapRect(this.R, this.Q);
            float width = this.M.width() / this.R.width();
            float height = this.M.height() / this.R.height();
            if (width < height) {
                width = height;
            }
            float f29 = 1.0f - width;
            this.f184042e.postScale(f16, f16, (this.M.centerX() - (this.R.centerX() * width)) / f29, (this.M.centerY() - (this.R.centerY() * width)) / f29);
        }
    }

    protected void n(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f184049i.set(this.f184042e);
        this.f184049i.postTranslate(f16, f17);
        this.f184049i.mapRect(this.R, this.Q);
        int f18 = f(this.R, this.M);
        if ((f18 & 1) == 0 && (f18 & 2) == 0) {
            this.f184042e.postTranslate(f16, 0.0f);
        }
        if ((f18 & 4) == 0 && (f18 & 8) == 0) {
            this.f184042e.postTranslate(0.0f, f17);
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.f184042e.reset();
            setImageMatrix(e());
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
                canvas.drawBitmap(this.D, this.f184047h, null);
            } else if (System.currentTimeMillis() - this.K > 250.0d) {
                canvas.drawBitmap(this.D, this.f184047h, this.f184050m);
                this.K = System.currentTimeMillis();
            } else {
                canvas.drawBitmap(this.D, this.f184047h, null);
                removeCallbacks(this.I);
                postDelayed(this.I, 250L);
            }
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
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
            p(bitmap, this.f184040d);
            setImageMatrix(e());
        }
        this.N = getWidth() / 2;
        this.P = getHeight() / 2;
        setRestrict(this.f184037a0, this.f184038b0);
        RectF rectF = this.M;
        int i19 = this.N;
        int i26 = this.V;
        rectF.left = i19 - (i26 / 2);
        rectF.right = i19 + (i26 / 2);
        int i27 = this.P;
        int i28 = this.W;
        rectF.top = i27 - (i28 / 2);
        rectF.bottom = i27 + (i28 / 2);
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
                                if (motionEvent.getPointerId(action2) == this.f184048h0) {
                                    if (action2 == 0) {
                                        i3 = 1;
                                    }
                                    this.f184045f0 = motionEvent.getX(i3);
                                    this.f184046g0 = motionEvent.getY(i3);
                                    this.f184048h0 = motionEvent.getPointerId(i3);
                                }
                            }
                        } else {
                            this.f184048h0 = -1;
                        }
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.f184048h0);
                        if (findPointerIndex != -1 && findPointerIndex < motionEvent.getPointerCount()) {
                            float x16 = motionEvent.getX(findPointerIndex);
                            float y16 = motionEvent.getY(findPointerIndex);
                            if (!this.L.isInProgress()) {
                                float f16 = x16 - this.f184045f0;
                                float f17 = y16 - this.f184046g0;
                                if (this.M != null) {
                                    this.f184041d0 += f16;
                                    this.f184043e0 += f17;
                                } else {
                                    this.f184041d0 += f16;
                                    this.f184043e0 += f17;
                                }
                                invalidate();
                            }
                            this.f184045f0 = x16;
                            this.f184046g0 = y16;
                        }
                    }
                } else {
                    this.f184048h0 = -1;
                }
            } else {
                float x17 = motionEvent.getX();
                float y17 = motionEvent.getY();
                this.f184045f0 = x17;
                this.f184046g0 = y17;
                this.f184048h0 = MotionEventCompat.getPointerId(motionEvent, 0);
            }
        }
        return true;
    }

    public float q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Float) iPatchRedirector.redirect((short) 25, (Object) this)).floatValue();
        }
        if (this.D == null) {
            return 1.0f;
        }
        return Math.max(Math.min(this.E / r0.getWidth(), this.F / this.D.getHeight()), 1.0f);
    }

    public void r(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Float.valueOf(f16));
        } else {
            s(f16, getWidth() / 2.0f, getHeight() / 2.0f);
        }
    }

    public void s(float f16, float f17, float f18) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bitmap);
            return;
        }
        if (bitmap == null) {
            return;
        }
        if (getWidth() <= 0) {
            this.H = new Runnable(bitmap) { // from class: com.tencent.mobileqq.activity.photo.PortraitImageview.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f184051d;

                {
                    this.f184051d = bitmap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PortraitImageview.this, (Object) bitmap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PortraitImageview.this.setImageBitmap(this.f184051d);
                    }
                }
            };
            return;
        }
        p(bitmap, this.f184040d);
        this.D = bitmap;
        this.f184042e.reset();
        setImageMatrix(e());
        this.G = l();
    }

    public void setImageMatrix(Matrix matrix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) matrix);
            return;
        }
        if (matrix != null && matrix.isIdentity()) {
            matrix = null;
        }
        if ((matrix == null && !this.f184047h.isIdentity()) || (matrix != null && !this.f184047h.equals(matrix))) {
            this.f184047h.set(matrix);
            invalidate();
        }
    }

    public void setOnImageTouchedListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
        }
    }

    public void setRegionView(RegionView regionView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) regionView);
        } else {
            this.T = regionView;
        }
    }

    public void setRestrict(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f184037a0 = i3;
        this.f184038b0 = i16;
        int i17 = this.E;
        if (i17 > 0 && (i3 > i17 || i16 > this.F)) {
            int i18 = f184036i0;
            float f16 = this.S;
            float f17 = (i17 - (i18 * f16)) / i3;
            float f18 = (this.F - (i18 * f16)) / i16;
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

    public void t(float f16, float f17, float f18, float f19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19));
        } else {
            post(new Runnable(f19, System.currentTimeMillis(), h(), (f16 - h()) / f19, f17, f18) { // from class: com.tencent.mobileqq.activity.photo.PortraitImageview.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f184052d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f184053e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ float f184054f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ float f184055h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ float f184056i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ float f184057m;

                {
                    this.f184052d = f19;
                    this.f184053e = r7;
                    this.f184054f = r9;
                    this.f184055h = r10;
                    this.f184056i = f17;
                    this.f184057m = f18;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, PortraitImageview.this, Float.valueOf(f19), Long.valueOf(r7), Float.valueOf(r9), Float.valueOf(r10), Float.valueOf(f17), Float.valueOf(f18));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    float min = Math.min(this.f184052d, (float) (System.currentTimeMillis() - this.f184053e));
                    PortraitImageview.this.s(this.f184054f + (this.f184055h * min), this.f184056i, this.f184057m);
                    if (min < this.f184052d) {
                        PortraitImageview.this.post(this);
                    }
                }
            });
        }
    }

    public PortraitImageview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
    }

    public PortraitImageview(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.S = context.getResources().getDisplayMetrics().density;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
    }
}
