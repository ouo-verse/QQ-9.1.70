package com.tencent.mobileqq.guild.component.multitouchimg;

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

/* loaded from: classes12.dex */
public class PhotoViewAttacher implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* renamed from: c0, reason: collision with root package name */
    private static float f215949c0 = 3.5f;

    /* renamed from: d0, reason: collision with root package name */
    private static float f215950d0 = 1.75f;

    /* renamed from: e0, reason: collision with root package name */
    private static float f215951e0 = 1.0f;

    /* renamed from: f0, reason: collision with root package name */
    private static float f215952f0 = 0.6f;

    /* renamed from: g0, reason: collision with root package name */
    private static int f215953g0 = 200;
    private ImageView D;
    private GestureDetector E;
    private com.tencent.mobileqq.guild.component.multitouchimg.b F;
    private p L;
    private com.tencent.mobileqq.guild.component.multitouchimg.d M;
    private View.OnLongClickListener N;
    private k P;
    private m Q;
    private FlingRunnable R;
    private float U;
    private float V;
    private float W;
    private com.tencent.mobileqq.guild.component.multitouchimg.c Z;

    /* renamed from: d, reason: collision with root package name */
    private Interpolator f215956d = new AccelerateDecelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    private int f215957e = f215953g0;

    /* renamed from: f, reason: collision with root package name */
    private float f215958f = f215951e0;

    /* renamed from: h, reason: collision with root package name */
    private float f215959h = f215950d0;

    /* renamed from: i, reason: collision with root package name */
    private float f215960i = f215949c0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f215961m = true;
    private boolean C = false;
    private final Matrix G = new Matrix();
    private final Matrix H = new Matrix();
    private final Matrix I = new Matrix();
    private final RectF J = new RectF();
    private final float[] K = new float[9];
    private int S = 2;
    private int T = 2;
    private boolean X = true;
    private ImageView.ScaleType Y = ImageView.ScaleType.FIT_CENTER;

    /* renamed from: a0, reason: collision with root package name */
    private float f215954a0 = 0.0f;

    /* renamed from: b0, reason: collision with root package name */
    private f f215955b0 = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class AnimatedZoomRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final float f215962d;

        /* renamed from: e, reason: collision with root package name */
        private final float f215963e;

        /* renamed from: f, reason: collision with root package name */
        private final long f215964f = System.currentTimeMillis();

        /* renamed from: h, reason: collision with root package name */
        private final float f215965h;

        /* renamed from: i, reason: collision with root package name */
        private final float f215966i;

        public AnimatedZoomRunnable(float f16, float f17, float f18, float f19) {
            this.f215962d = f18;
            this.f215963e = f19;
            this.f215965h = f16;
            this.f215966i = f17;
        }

        private float e() {
            return PhotoViewAttacher.this.f215956d.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f215964f)) * 1.0f) / PhotoViewAttacher.this.f215957e));
        }

        @Override // java.lang.Runnable
        public void run() {
            float e16 = e();
            float f16 = this.f215965h;
            PhotoViewAttacher.this.f215955b0.onScale((f16 + ((this.f215966i - f16) * e16)) / PhotoViewAttacher.this.I(), this.f215962d, this.f215963e);
            if (e16 < 1.0f) {
                com.tencent.mobileqq.guild.component.multitouchimg.a.a(PhotoViewAttacher.this.D, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final OverScroller f215967d;

        /* renamed from: e, reason: collision with root package name */
        private int f215968e;

        /* renamed from: f, reason: collision with root package name */
        private int f215969f;

        public FlingRunnable(Context context) {
            this.f215967d = new OverScroller(context);
        }

        public void e() {
            this.f215967d.forceFinished(true);
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
            this.f215968e = round;
            this.f215969f = round2;
            if (round != i26 || round2 != i28) {
                this.f215967d.fling(round, round2, i17, i18, i19, i26, i27, i28, 0, 0);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f215967d.isFinished() && this.f215967d.computeScrollOffset()) {
                int currX = this.f215967d.getCurrX();
                int currY = this.f215967d.getCurrY();
                PhotoViewAttacher.this.I.postTranslate(this.f215968e - currX, this.f215969f - currY);
                PhotoViewAttacher.this.w();
                this.f215968e = currX;
                this.f215969f = currY;
                com.tencent.mobileqq.guild.component.multitouchimg.a.a(PhotoViewAttacher.this.D, this);
            }
        }
    }

    /* loaded from: classes12.dex */
    class a implements f {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.component.multitouchimg.f
        public void onDrag(float f16, float f17) {
            if (PhotoViewAttacher.this.F.g()) {
                return;
            }
            PhotoViewAttacher.h(PhotoViewAttacher.this);
            PhotoViewAttacher.this.I.postTranslate(f16, f17);
            PhotoViewAttacher.this.w();
            ViewParent parent = PhotoViewAttacher.this.D.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(PhotoViewAttacher.this.L(f16, f17));
            }
        }

        @Override // com.tencent.mobileqq.guild.component.multitouchimg.f
        public void onFling(float f16, float f17, float f18, float f19) {
            if (PhotoViewAttacher.this.I() == 1.0f) {
                return;
            }
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            photoViewAttacher.R = new FlingRunnable(photoViewAttacher.D.getContext());
            FlingRunnable flingRunnable = PhotoViewAttacher.this.R;
            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
            int E = photoViewAttacher2.E(photoViewAttacher2.D);
            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
            flingRunnable.f(E, photoViewAttacher3.D(photoViewAttacher3.D), (int) f18, (int) f19);
            PhotoViewAttacher.this.D.post(PhotoViewAttacher.this.R);
        }

        @Override // com.tencent.mobileqq.guild.component.multitouchimg.f
        public void onScale(float f16, float f17, float f18) {
            float I = PhotoViewAttacher.this.I();
            PhotoViewAttacher.this.V = f17;
            PhotoViewAttacher.this.W = f18;
            if (I <= PhotoViewAttacher.this.f215960i * 2.0f || f16 <= 1.0f) {
                if (I < PhotoViewAttacher.f215952f0 && f16 < 1.0f) {
                    return;
                }
                if (PhotoViewAttacher.this.P != null) {
                    PhotoViewAttacher.this.P.a(f16, f17, f18, I);
                }
                PhotoViewAttacher.this.I.postScale(f16, f16, f17, f18);
                PhotoViewAttacher.this.w();
            }
        }
    }

    /* loaded from: classes12.dex */
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
            if (PhotoViewAttacher.this.f215955b0 != null) {
                PhotoViewAttacher.this.f215955b0.onDrag(f18, f19);
            }
            return PhotoViewAttacher.this.L(f18, f19);
        }
    }

    /* loaded from: classes12.dex */
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
    /* loaded from: classes12.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f215973a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f215973a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f215973a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f215973a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f215973a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
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
        this.U = 0.0f;
        this.F = new com.tencent.mobileqq.guild.component.multitouchimg.b(imageView.getContext(), this.f215955b0);
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
    public int D(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int E(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float K(Matrix matrix, int i3) {
        matrix.getValues(this.K);
        return this.K[i3];
    }

    private boolean M(float f16, float f17, float f18, float f19, boolean z16) {
        if (z16 && f19 * Math.abs(f16) > Math.abs(f17)) {
            int i3 = this.S;
            if (i3 == 2 || ((i3 == 0 && f16 >= f18) || (i3 == 1 && f16 <= 0.0f - f18))) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean N(float f16, float f17, float f18, float f19, boolean z16) {
        if (z16 && f19 * Math.abs(f17) > Math.abs(f16)) {
            int i3 = this.T;
            if (i3 == 2 || ((i3 == 0 && f17 >= f18) || (i3 == 1 && f17 <= 0.0f - f18))) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean O(float f16, float f17, float f18) {
        if (this.T == 1 && this.S == 0 && f17 <= 0.0f - f18 && f16 >= f18) {
            return true;
        }
        return false;
    }

    private boolean P(float f16, float f17, float f18) {
        if (this.T == 0 && this.S == 0 && f17 >= f18 && f16 >= f18) {
            return true;
        }
        return false;
    }

    private void Q() {
        this.I.reset();
        n0(this.U);
        V(B());
        x();
    }

    private boolean R(float f16, float f17, float f18) {
        if (this.T == 1 && this.S == 1) {
            float f19 = 0.0f - f18;
            if (f17 <= f19 && f16 <= f19) {
                return true;
            }
        }
        return false;
    }

    private boolean S(float f16, float f17, float f18) {
        if (this.T == 0 && this.S == 1 && f17 >= f18 && f16 <= 0.0f - f18) {
            return true;
        }
        return false;
    }

    private void V(Matrix matrix) {
        this.D.setImageMatrix(matrix);
    }

    static /* bridge */ /* synthetic */ o h(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ n j(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    private void v() {
        FlingRunnable flingRunnable = this.R;
        if (flingRunnable != null) {
            flingRunnable.e();
            this.R = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (x()) {
            V(B());
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
        float D = D(this.D);
        float f27 = 0.0f;
        if (height <= D) {
            int i3 = d.f215973a[this.Y.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f19 = (D - height) / 2.0f;
                    f26 = A.top;
                } else {
                    f19 = D - height;
                    f26 = A.top;
                }
                f16 = f19 - f26;
            } else {
                f16 = -A.top;
            }
            this.T = 2;
        } else {
            float f28 = A.top;
            if (f28 > 0.0f) {
                this.T = 0;
                f16 = -f28;
            } else {
                float f29 = A.bottom;
                if (f29 < D) {
                    this.T = 1;
                    f16 = D - f29;
                } else {
                    this.T = -1;
                    f16 = 0.0f;
                }
            }
        }
        float E = E(this.D);
        if (width <= E) {
            int i16 = d.f215973a[this.Y.ordinal()];
            if (i16 != 2) {
                if (i16 != 3) {
                    f17 = (E - width) / 2.0f;
                    f18 = A.left;
                } else {
                    f17 = E - width;
                    f18 = A.left;
                }
                f27 = f17 - f18;
            } else {
                f27 = -A.left;
            }
            this.S = 2;
        } else {
            float f36 = A.left;
            if (f36 > 0.0f) {
                this.S = 0;
                f27 = -f36;
            } else {
                float f37 = A.right;
                if (f37 < E) {
                    f27 = E - f37;
                    this.S = 1;
                } else {
                    this.S = -1;
                }
            }
        }
        this.I.postTranslate(f27, f16);
        return true;
    }

    private boolean y() {
        if (this.f215961m && !this.F.g() && !this.C) {
            return true;
        }
        return false;
    }

    private void y0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float E = E(this.D);
        float D = D(this.D);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.G.reset();
        float f16 = intrinsicWidth;
        float f17 = E / f16;
        float f18 = intrinsicHeight;
        float f19 = D / f18;
        ImageView.ScaleType scaleType = this.Y;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.G.postTranslate((E - f16) / 2.0f, (D - f18) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f17, f19);
            this.G.postScale(max, max);
            this.G.postTranslate((E - (f16 * max)) / 2.0f, (D - (f18 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f17, f19));
            this.G.postScale(min, min);
            this.G.postTranslate((E - (f16 * min)) / 2.0f, (D - (f18 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f16, f18);
            RectF rectF2 = new RectF(0.0f, 0.0f, E, D);
            if (((int) this.U) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f18, f16);
            }
            int i3 = d.f215973a[this.Y.ordinal()];
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
                com.tencent.mobileqq.guild.component.multitouchimg.c cVar = this.Z;
                if (cVar != null) {
                    float f26 = cVar.f216011c;
                    float f27 = cVar.f216012d;
                    float f28 = cVar.f216009a;
                    float f29 = f28 + f26;
                    float f36 = cVar.f216010b;
                    float f37 = f36 + f27;
                    float min2 = Math.min(E / f28, D / f36);
                    this.f215954a0 = 0.0f;
                    if (min2 < 1.0f) {
                        this.f215954a0 = 1.0f - min2;
                    }
                    QLog.i("PhotoViewAttacher", 4, "updateBaseMatrix scale=" + min2 + " extScale=" + this.f215954a0);
                    rectF2.set(f26, f27, f29, f37);
                }
                this.G.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        Q();
    }

    public Matrix C() {
        return this.H;
    }

    public float F() {
        return this.f215960i;
    }

    public float G() {
        return this.f215959h;
    }

    public float H() {
        return this.f215958f;
    }

    public float I() {
        float sqrt = (float) Math.sqrt(((float) Math.pow(K(this.I, 0), 2.0d)) + ((float) Math.pow(K(this.I, 3), 2.0d)));
        if (this.Z != null) {
            float f16 = this.f215954a0;
            if (f16 > 0.0f) {
                return sqrt + f16;
            }
            return sqrt;
        }
        return sqrt;
    }

    public ImageView.ScaleType J() {
        return this.Y;
    }

    public boolean L(float f16, float f17) {
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
        if (!N(f16, f17, 8.0f, 0.6f, z16) && !M(f16, f17, 8.0f, 0.6f, z17) && !P(f16, f17, 8.0f) && !S(f16, f17, 8.0f) && !O(f16, f17, 8.0f) && !R(f16, f17, 8.0f)) {
            return true;
        }
        return false;
    }

    public void T(boolean z16) {
        this.f215961m = z16;
    }

    public void U(com.tencent.mobileqq.guild.component.multitouchimg.c cVar) {
        this.Z = cVar;
    }

    public void W(float f16) {
        q.a(this.f215958f, this.f215959h, f16);
        this.f215960i = f16;
    }

    public void X(float f16) {
        q.a(this.f215958f, f16, this.f215960i);
        this.f215959h = f16;
    }

    public void Y(float f16) {
        q.a(f16, this.f215959h, this.f215960i);
        this.f215958f = f16;
    }

    public void a0(com.tencent.mobileqq.guild.component.multitouchimg.d dVar) {
        this.M = dVar;
    }

    public void b0(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.E.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void c0(m mVar) {
        this.Q = mVar;
    }

    public void d0(View.OnLongClickListener onLongClickListener) {
        this.N = onLongClickListener;
    }

    public void h0(j jVar) {
        com.tencent.mobileqq.guild.component.multitouchimg.b bVar = this.F;
        if (bVar != null) {
            bVar.j(jVar);
        }
    }

    public void i0(k kVar) {
        this.P = kVar;
    }

    public void j0(l lVar) {
        com.tencent.mobileqq.guild.component.multitouchimg.b bVar = this.F;
        if (bVar != null) {
            bVar.k(lVar);
        }
    }

    public void m0(p pVar) {
        this.L = pVar;
    }

    public void n0(float f16) {
        this.I.postRotate(f16 % 360.0f);
        w();
    }

    public void o0(float f16) {
        this.I.setRotate(f16 % 360.0f);
        w();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i3 != i19 || i16 != i26 || i17 != i27 || i18 != i28) {
            y0(this.D.getDrawable());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z16;
        com.tencent.mobileqq.guild.component.multitouchimg.b bVar;
        boolean z17;
        GestureDetector gestureDetector;
        boolean z18;
        boolean z19;
        float f16;
        boolean z26 = false;
        if (!this.X || !q.c((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (I() >= this.f215958f) {
                    if (I() > this.f215960i) {
                        float I = I();
                        float f17 = this.f215960i;
                        if (I > f17 * 2.0f) {
                            I = f17 * 2.0f;
                        }
                        view.post(new AnimatedZoomRunnable(I, f17, this.V, this.W));
                        z16 = true;
                    }
                    z16 = false;
                } else {
                    float I2 = I();
                    float f18 = f215952f0;
                    if (I2 < f18) {
                        f16 = f18;
                    } else {
                        f16 = I2;
                    }
                    RectF z27 = z();
                    if (z27 != null) {
                        view.post(new AnimatedZoomRunnable(f16, this.f215958f, z27.centerX(), z27.centerY()));
                        z16 = true;
                    }
                    z16 = false;
                }
                m mVar = this.Q;
                if (mVar != null) {
                    mVar.a(I());
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
            m mVar2 = this.Q;
            if (mVar2 != null) {
                mVar2.b();
            }
        }
        z16 = false;
        bVar = this.F;
        if (bVar == null) {
        }
        gestureDetector = this.E;
        return gestureDetector == null ? z17 : z17;
    }

    public void p0(float f16) {
        r0(f16, false);
    }

    public void q0(float f16, float f17, float f18, boolean z16) {
        if (f16 >= this.f215958f && f16 <= this.f215960i) {
            if (z16) {
                this.D.post(new AnimatedZoomRunnable(I(), f16, f17, f18));
                return;
            } else {
                this.I.setScale(f16, f16, f17, f18);
                w();
                return;
            }
        }
        throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
    }

    public void r0(float f16, boolean z16) {
        q0(f16, this.D.getRight() / 2, this.D.getBottom() / 2, z16);
    }

    public void s0(float f16, float f17, float f18) {
        q.a(f16, f17, f18);
        this.f215958f = f16;
        this.f215959h = f17;
        this.f215960i = f18;
    }

    public void u0(ImageView.ScaleType scaleType) {
        if (q.d(scaleType) && scaleType != this.Y) {
            this.Y = scaleType;
            x0();
        }
    }

    public void v0(int i3) {
        this.f215957e = i3;
    }

    public void w0(boolean z16) {
        this.X = z16;
        x0();
    }

    public void x0() {
        if (this.X) {
            y0(this.D.getDrawable());
        } else {
            Q();
        }
    }

    public RectF z() {
        x();
        return A(B());
    }

    public void Z(View.OnClickListener onClickListener) {
    }

    public void e0(g gVar) {
    }

    public void f0(h hVar) {
    }

    public void g0(i iVar) {
    }

    public void k0(n nVar) {
    }

    public void l0(o oVar) {
    }
}
