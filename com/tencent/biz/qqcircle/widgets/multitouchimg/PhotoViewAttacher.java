package com.tencent.biz.qqcircle.widgets.multitouchimg;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes5.dex */
public class PhotoViewAttacher implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* renamed from: f0, reason: collision with root package name */
    private static float f93613f0 = 3.5f;

    /* renamed from: g0, reason: collision with root package name */
    private static float f93614g0 = 1.75f;

    /* renamed from: h0, reason: collision with root package name */
    private static float f93615h0 = 1.0f;

    /* renamed from: i0, reason: collision with root package name */
    private static float f93616i0 = 0.6f;

    /* renamed from: j0, reason: collision with root package name */
    private static int f93617j0 = 200;
    private ImageView D;
    private GestureDetector E;
    private com.tencent.biz.qqcircle.widgets.multitouchimg.b F;
    private o L;
    private com.tencent.biz.qqcircle.widgets.multitouchimg.d M;
    private View.OnLongClickListener N;
    private j P;
    private l Q;
    private k R;
    private e S;
    private FlingRunnable T;
    private float W;
    private float X;
    private float Y;

    /* renamed from: b0, reason: collision with root package name */
    private MotionEvent f93619b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.biz.qqcircle.widgets.multitouchimg.c f93620c0;

    /* renamed from: d, reason: collision with root package name */
    private Interpolator f93621d = new AccelerateDecelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    private int f93623e = f93617j0;

    /* renamed from: f, reason: collision with root package name */
    private float f93625f = f93615h0;

    /* renamed from: h, reason: collision with root package name */
    private float f93626h = f93614g0;

    /* renamed from: i, reason: collision with root package name */
    private float f93627i = f93613f0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f93628m = true;
    private boolean C = false;
    private final Matrix G = new Matrix();
    private final Matrix H = new Matrix();
    private final Matrix I = new Matrix();
    private final RectF J = new RectF();
    private final float[] K = new float[9];
    private int U = 2;
    private int V = 2;
    private boolean Z = true;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView.ScaleType f93618a0 = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: d0, reason: collision with root package name */
    private float f93622d0 = 0.0f;

    /* renamed from: e0, reason: collision with root package name */
    private f f93624e0 = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class AnimatedZoomRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final float f93629d;

        /* renamed from: e, reason: collision with root package name */
        private final float f93630e;

        /* renamed from: f, reason: collision with root package name */
        private final long f93631f = System.currentTimeMillis();

        /* renamed from: h, reason: collision with root package name */
        private final float f93632h;

        /* renamed from: i, reason: collision with root package name */
        private final float f93633i;

        public AnimatedZoomRunnable(float f16, float f17, float f18, float f19) {
            this.f93629d = f18;
            this.f93630e = f19;
            this.f93632h = f16;
            this.f93633i = f17;
        }

        private float e() {
            return PhotoViewAttacher.this.f93621d.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f93631f)) * 1.0f) / PhotoViewAttacher.this.f93623e));
        }

        @Override // java.lang.Runnable
        public void run() {
            float e16 = e();
            float f16 = this.f93632h;
            PhotoViewAttacher.this.f93624e0.onScale((f16 + ((this.f93633i - f16) * e16)) / PhotoViewAttacher.this.H(), this.f93629d, this.f93630e);
            if (e16 < 1.0f) {
                com.tencent.biz.qqcircle.widgets.multitouchimg.a.a(PhotoViewAttacher.this.D, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final OverScroller f93634d;

        /* renamed from: e, reason: collision with root package name */
        private int f93635e;

        /* renamed from: f, reason: collision with root package name */
        private int f93636f;

        public FlingRunnable(Context context) {
            this.f93634d = new OverScroller(context);
        }

        public void e() {
            this.f93634d.forceFinished(true);
        }

        public void f(int i3, int i16, int i17, int i18) {
            int i19;
            int i26;
            int i27;
            int i28;
            RectF z16 = PhotoViewAttacher.this.z();
            if (z16 == null) {
                return;
            }
            int round = Math.round(-z16.left);
            float f16 = i3;
            if (f16 < z16.width()) {
                i26 = Math.round(z16.width() - f16);
                i19 = 0;
            } else {
                i19 = round;
                i26 = i19;
            }
            int round2 = Math.round(-z16.top);
            float f17 = i16;
            if (f17 < z16.height()) {
                i28 = Math.round(z16.height() - f17);
                i27 = 0;
            } else {
                i27 = round2;
                i28 = i27;
            }
            this.f93635e = round;
            this.f93636f = round2;
            if (round != i26 || round2 != i28) {
                this.f93634d.fling(round, round2, i17, i18, i19, i26, i27, i28, 0, 0);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f93634d.isFinished() && this.f93634d.computeScrollOffset()) {
                int currX = this.f93634d.getCurrX();
                int currY = this.f93634d.getCurrY();
                PhotoViewAttacher.this.I.postTranslate(this.f93635e - currX, this.f93636f - currY);
                PhotoViewAttacher.this.w();
                this.f93635e = currX;
                this.f93636f = currY;
                com.tencent.biz.qqcircle.widgets.multitouchimg.a.a(PhotoViewAttacher.this.D, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    class a implements f {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.f
        public void onDrag(float f16, float f17) {
            if (PhotoViewAttacher.this.F.g()) {
                return;
            }
            PhotoViewAttacher.h(PhotoViewAttacher.this);
            PhotoViewAttacher.this.I.postTranslate(f16, f17);
            PhotoViewAttacher.this.w();
            ViewParent parent = PhotoViewAttacher.this.D.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(PhotoViewAttacher.this.K(f16, f17));
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.f
        public void onFling(float f16, float f17, float f18, float f19) {
            if (PhotoViewAttacher.this.H() == 1.0f) {
                return;
            }
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            photoViewAttacher.T = new FlingRunnable(photoViewAttacher.D.getContext());
            FlingRunnable flingRunnable = PhotoViewAttacher.this.T;
            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
            int F = photoViewAttacher2.F(photoViewAttacher2.D);
            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
            flingRunnable.f(F, photoViewAttacher3.E(photoViewAttacher3.D), (int) f18, (int) f19);
            PhotoViewAttacher.this.D.post(PhotoViewAttacher.this.T);
        }

        @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.f
        public void onScale(float f16, float f17, float f18) {
            float H = PhotoViewAttacher.this.H();
            PhotoViewAttacher.this.X = f17;
            PhotoViewAttacher.this.Y = f18;
            if (H <= PhotoViewAttacher.this.f93627i * 2.0f || f16 <= 1.0f) {
                if (H < PhotoViewAttacher.f93616i0 && f16 < 1.0f) {
                    return;
                }
                if (PhotoViewAttacher.this.R != null) {
                    PhotoViewAttacher.this.R.a(f16, f17, f18, H);
                }
                PhotoViewAttacher.this.I.postScale(f16, f16, f17, f18);
                PhotoViewAttacher.this.w();
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            PhotoViewAttacher.j(PhotoViewAttacher.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PhotoViewAttacher.this.N != null) {
                PhotoViewAttacher.this.N.onLongClick(PhotoViewAttacher.this.D);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            float f18 = 0.0f - f16;
            float f19 = 0.0f - f17;
            if (PhotoViewAttacher.this.f93624e0 != null) {
                PhotoViewAttacher.this.f93624e0.onDrag(f18, f19);
            }
            return PhotoViewAttacher.this.K(f18, f19);
        }
    }

    /* loaded from: classes5.dex */
    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (PhotoViewAttacher.this.M != null) {
                PhotoViewAttacher.this.M.onDoubleTap(motionEvent);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            PhotoViewAttacher.this.z();
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (PhotoViewAttacher.this.L != null) {
                PhotoViewAttacher.this.L.onViewTap(PhotoViewAttacher.this.D, x16, y16);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f93640a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f93640a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f93640a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f93640a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f93640a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public PhotoViewAttacher(ImageView imageView) {
        this.D = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.W = 0.0f;
        this.F = new com.tencent.biz.qqcircle.widgets.multitouchimg.b(imageView.getContext(), this.f93624e0);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.E = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    private RectF A(Matrix matrix) {
        if (this.D.getDrawable() != null) {
            this.J.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            matrix.mapRect(this.J);
            return this.J;
        }
        return null;
    }

    private Matrix B() {
        this.H.set(this.G);
        this.H.postConcat(this.I);
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int E(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float J(Matrix matrix, int i3) {
        matrix.getValues(this.K);
        return this.K[i3];
    }

    private boolean L(float f16, float f17, float f18, float f19, boolean z16) {
        if (z16 && f19 * Math.abs(f16) > Math.abs(f17)) {
            int i3 = this.U;
            if (i3 == 2 || ((i3 == 0 && f16 >= f18) || (i3 == 1 && f16 <= 0.0f - f18))) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean M(float f16, float f17, float f18, float f19, boolean z16) {
        if (z16 && f19 * Math.abs(f17) > Math.abs(f16)) {
            int i3 = this.V;
            if (i3 == 2 || ((i3 == 0 && f17 >= f18) || (i3 == 1 && f17 <= 0.0f - f18))) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean N(float f16, float f17, float f18) {
        if (this.V == 1 && this.U == 0 && f17 <= 0.0f - f18 && f16 >= f18) {
            return true;
        }
        return false;
    }

    private boolean O(float f16, float f17, float f18) {
        if (this.V == 0 && this.U == 0 && f17 >= f18 && f16 >= f18) {
            return true;
        }
        return false;
    }

    private void Q() {
        this.I.reset();
        m0(this.W);
        U(B());
        x();
    }

    private boolean R(float f16, float f17, float f18) {
        if (this.V == 1 && this.U == 1) {
            float f19 = 0.0f - f18;
            if (f17 <= f19 && f16 <= f19) {
                return true;
            }
        }
        return false;
    }

    private boolean S(float f16, float f17, float f18) {
        if (this.V == 0 && this.U == 1 && f17 >= f18 && f16 <= 0.0f - f18) {
            return true;
        }
        return false;
    }

    private void U(Matrix matrix) {
        this.D.setImageMatrix(matrix);
    }

    static /* bridge */ /* synthetic */ n h(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ m j(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    private void v() {
        FlingRunnable flingRunnable = this.T;
        if (flingRunnable != null) {
            flingRunnable.e();
            this.T = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (x()) {
            U(B());
        }
    }

    private boolean x() {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        RectF A = A(B());
        if (A == null) {
            return false;
        }
        float height = A.height();
        float width = A.width();
        float E = E(this.D);
        float f27 = 0.0f;
        if (height <= E) {
            int i3 = d.f93640a[this.f93618a0.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f19 = (E - height) / 2.0f;
                    f26 = A.top;
                } else {
                    f19 = E - height;
                    f26 = A.top;
                }
                f16 = f19 - f26;
            } else {
                f16 = -A.top;
            }
            this.V = 2;
        } else {
            float f28 = A.top;
            if (f28 > 0.0f) {
                this.V = 0;
                f16 = -f28;
            } else {
                float f29 = A.bottom;
                if (f29 < E) {
                    this.V = 1;
                    f16 = E - f29;
                } else {
                    this.V = -1;
                    f16 = 0.0f;
                }
            }
        }
        float F = F(this.D);
        if (width <= F) {
            int i16 = d.f93640a[this.f93618a0.ordinal()];
            if (i16 != 2) {
                if (i16 != 3) {
                    f17 = (F - width) / 2.0f;
                    f18 = A.left;
                } else {
                    f17 = F - width;
                    f18 = A.left;
                }
                f27 = f17 - f18;
            } else {
                f27 = -A.left;
            }
            this.U = 2;
        } else {
            float f36 = A.left;
            if (f36 > 0.0f) {
                this.U = 0;
                f27 = -f36;
            } else {
                float f37 = A.right;
                if (f37 < F) {
                    f27 = F - f37;
                    this.U = 1;
                } else {
                    this.U = -1;
                }
            }
        }
        this.I.postTranslate(f27, f16);
        return true;
    }

    private void x0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float F = F(this.D);
        float E = E(this.D);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.G.reset();
        float f16 = intrinsicWidth;
        float f17 = F / f16;
        float f18 = intrinsicHeight;
        float f19 = E / f18;
        ImageView.ScaleType scaleType = this.f93618a0;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.G.postTranslate((F - f16) / 2.0f, (E - f18) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f17, f19);
            this.G.postScale(max, max);
            this.G.postTranslate((F - (f16 * max)) / 2.0f, (E - (f18 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f17, f19));
            this.G.postScale(min, min);
            this.G.postTranslate((F - (f16 * min)) / 2.0f, (E - (f18 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f16, f18);
            RectF rectF2 = new RectF(0.0f, 0.0f, F, E);
            if (((int) this.W) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f18, f16);
            }
            int i3 = d.f93640a[this.f93618a0.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.G.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        }
                    } else {
                        this.G.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                    }
                } else {
                    this.G.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                }
            } else {
                com.tencent.biz.qqcircle.widgets.multitouchimg.c cVar = this.f93620c0;
                if (cVar != null) {
                    float f26 = cVar.f93682c;
                    float f27 = cVar.f93683d;
                    float f28 = cVar.f93680a;
                    float f29 = f28 + f26;
                    float f36 = cVar.f93681b;
                    float f37 = f36 + f27;
                    float min2 = Math.min(F / f28, E / f36);
                    this.f93622d0 = 0.0f;
                    if (min2 < 1.0f) {
                        this.f93622d0 = 1.0f - min2;
                    }
                    QLog.i("PhotoViewAttacher", 4, "updateBaseMatrix scale=" + min2 + " extScale=" + this.f93622d0);
                    rectF2.set(f26, f27, f29, f37);
                }
                this.G.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        Q();
    }

    private boolean y() {
        if (this.f93628m && !this.F.g() && !this.C) {
            return true;
        }
        return false;
    }

    public GestureDetector C() {
        return this.E;
    }

    public Matrix D() {
        return this.H;
    }

    public MotionEvent G() {
        return this.f93619b0;
    }

    public float H() {
        float sqrt = (float) Math.sqrt(((float) Math.pow(J(this.I, 0), 2.0d)) + ((float) Math.pow(J(this.I, 3), 2.0d)));
        if (this.f93620c0 != null) {
            float f16 = this.f93622d0;
            if (f16 > 0.0f) {
                return sqrt + f16;
            }
            return sqrt;
        }
        return sqrt;
    }

    public ImageView.ScaleType I() {
        return this.f93618a0;
    }

    public boolean K(float f16, float f17) {
        boolean z16;
        boolean z17;
        if (!y()) {
            return true;
        }
        if (Math.abs(f17) > 8.0f && Math.abs(f17) > Math.abs(f16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (Math.abs(f16) > 8.0f && Math.abs(f16) > Math.abs(f17)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!M(f16, f17, 8.0f, 0.6f, z16) && !L(f16, f17, 8.0f, 0.6f, z17) && !O(f16, f17, 8.0f) && !S(f16, f17, 8.0f) && !N(f16, f17, 8.0f) && !R(f16, f17, 8.0f)) {
            return true;
        }
        return false;
    }

    public void P() {
        Q();
    }

    public void T(boolean z16) {
        this.f93628m = z16;
    }

    public void V(float f16) {
        p.a(this.f93625f, this.f93626h, f16);
        this.f93627i = f16;
    }

    public void W(float f16) {
        p.a(this.f93625f, f16, this.f93627i);
        this.f93626h = f16;
    }

    public void X(float f16) {
        p.a(f16, this.f93626h, this.f93627i);
        this.f93625f = f16;
    }

    public void Z(com.tencent.biz.qqcircle.widgets.multitouchimg.d dVar) {
        this.M = dVar;
    }

    public void a0(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.E.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void b0(e eVar) {
        this.S = eVar;
    }

    public void c0(View.OnLongClickListener onLongClickListener) {
        this.N = onLongClickListener;
    }

    public void g0(j jVar) {
        this.P = jVar;
        com.tencent.biz.qqcircle.widgets.multitouchimg.b bVar = this.F;
        if (bVar != null) {
            bVar.j(jVar);
        }
    }

    public void h0(k kVar) {
        this.R = kVar;
    }

    public void i0(l lVar) {
        this.Q = lVar;
        com.tencent.biz.qqcircle.widgets.multitouchimg.b bVar = this.F;
        if (bVar != null) {
            bVar.k(lVar);
        }
    }

    public void l0(o oVar) {
        this.L = oVar;
    }

    public void m0(float f16) {
        this.I.postRotate(f16 % 360.0f);
        w();
    }

    public void n0(float f16) {
        this.I.setRotate(f16 % 360.0f);
        w();
    }

    public void o0(float f16) {
        q0(f16, false);
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i3 != i19 || i16 != i26 || i17 != i27 || i18 != i28) {
            x0(this.D.getDrawable());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d4  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z16;
        com.tencent.biz.qqcircle.widgets.multitouchimg.b bVar;
        boolean z17;
        GestureDetector gestureDetector;
        boolean z18;
        boolean z19;
        float f16;
        this.f93619b0 = motionEvent;
        boolean z26 = false;
        if (!this.Z || !p.c((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (H() >= this.f93625f && this.S == null) {
                    if (H() > this.f93627i) {
                        float H = H();
                        float f17 = this.f93627i;
                        if (H > f17 * 2.0f) {
                            H = f17 * 2.0f;
                        }
                        view.post(new AnimatedZoomRunnable(H, f17, this.X, this.Y));
                        z16 = true;
                    }
                    z16 = false;
                } else {
                    float H2 = H();
                    float f18 = f93616i0;
                    if (H2 < f18) {
                        f16 = f18;
                    } else {
                        f16 = H2;
                    }
                    RectF z27 = z();
                    if (z27 != null) {
                        view.post(new AnimatedZoomRunnable(f16, this.f93625f, z27.centerX(), z27.centerY()));
                        z16 = true;
                    }
                    z16 = false;
                }
                e eVar = this.S;
                if (eVar != null) {
                    eVar.onDragEnd();
                }
                bVar = this.F;
                if (bVar == null) {
                    boolean g16 = bVar.g();
                    boolean f19 = this.F.f();
                    boolean h16 = this.F.h(motionEvent);
                    if (!g16 && !this.F.g()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!f19 && !this.F.f()) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    int pointerCount = motionEvent.getPointerCount();
                    if ((z18 && z19) || pointerCount > 1) {
                        z26 = true;
                    }
                    this.C = z26;
                    z17 = h16;
                } else {
                    z17 = z16;
                }
                gestureDetector = this.E;
                if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                    return true;
                }
            }
        } else {
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            v();
        }
        z16 = false;
        bVar = this.F;
        if (bVar == null) {
        }
        gestureDetector = this.E;
        return gestureDetector == null ? z17 : z17;
    }

    public void p0(float f16, float f17, float f18, boolean z16) {
        if (f16 >= this.f93625f && f16 <= this.f93627i) {
            if (z16) {
                this.D.post(new AnimatedZoomRunnable(H(), f16, f17, f18));
                return;
            } else {
                this.I.setScale(f16, f16, f17, f18);
                w();
                return;
            }
        }
        throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
    }

    public void q0(float f16, boolean z16) {
        p0(f16, this.D.getRight() / 2, this.D.getBottom() / 2, z16);
    }

    public void r0(float f16, float f17, float f18) {
        p.a(f16, f17, f18);
        this.f93625f = f16;
        this.f93626h = f17;
        this.f93627i = f18;
    }

    public void s0(ImageView.ScaleType scaleType) {
        if (p.d(scaleType) && scaleType != this.f93618a0) {
            this.f93618a0 = scaleType;
            w0();
        }
    }

    public void u0(int i3) {
        this.f93623e = i3;
    }

    public void v0(boolean z16) {
        this.Z = z16;
        w0();
    }

    public void w0() {
        if (this.Z) {
            x0(this.D.getDrawable());
        } else {
            Q();
        }
    }

    public RectF z() {
        x();
        return A(B());
    }

    public void Y(View.OnClickListener onClickListener) {
    }

    public void d0(g gVar) {
    }

    public void e0(h hVar) {
    }

    public void f0(i iVar) {
    }

    public void j0(m mVar) {
    }

    public void k0(n nVar) {
    }
}
