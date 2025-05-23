package com.tencent.mobileqq.wink.publish.widget.multitouchimg;

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

/* loaded from: classes21.dex */
public class PhotoViewAttacher implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static float X = 7.0f;
    private static float Y = 3.5f;
    private static float Z = 1.75f;

    /* renamed from: a0, reason: collision with root package name */
    private static float f326098a0 = 1.0f;

    /* renamed from: b0, reason: collision with root package name */
    private static float f326099b0 = 0.6f;

    /* renamed from: c0, reason: collision with root package name */
    private static int f326100c0 = 200;
    private ImageView D;
    private GestureDetector E;
    private com.tencent.mobileqq.wink.publish.widget.multitouchimg.b F;
    private View.OnLongClickListener L;
    private j M;
    private FlingRunnable N;
    private float R;
    private float S;
    private float T;

    /* renamed from: d, reason: collision with root package name */
    private Interpolator f326101d = new AccelerateDecelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    private int f326102e = f326100c0;

    /* renamed from: f, reason: collision with root package name */
    private float f326103f = f326098a0;

    /* renamed from: h, reason: collision with root package name */
    private float f326104h = Z;

    /* renamed from: i, reason: collision with root package name */
    private float f326105i = Y;

    /* renamed from: m, reason: collision with root package name */
    private boolean f326106m = true;
    private boolean C = false;
    private final Matrix G = new Matrix();
    private final Matrix H = new Matrix();
    private final Matrix I = new Matrix();
    private final RectF J = new RectF();
    private final float[] K = new float[9];
    private int P = 2;
    private int Q = 2;
    private boolean U = true;
    private ImageView.ScaleType V = ImageView.ScaleType.FIT_CENTER;
    private com.tencent.mobileqq.wink.publish.widget.multitouchimg.d W = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class AnimatedZoomRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final float f326107d;

        /* renamed from: e, reason: collision with root package name */
        private final float f326108e;

        /* renamed from: f, reason: collision with root package name */
        private final long f326109f = System.currentTimeMillis();

        /* renamed from: h, reason: collision with root package name */
        private final float f326110h;

        /* renamed from: i, reason: collision with root package name */
        private final float f326111i;

        public AnimatedZoomRunnable(float f16, float f17, float f18, float f19) {
            this.f326107d = f18;
            this.f326108e = f19;
            this.f326110h = f16;
            this.f326111i = f17;
        }

        private float e() {
            return PhotoViewAttacher.this.f326101d.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f326109f)) * 1.0f) / PhotoViewAttacher.this.f326102e));
        }

        @Override // java.lang.Runnable
        public void run() {
            float e16 = e();
            float f16 = this.f326110h;
            float I = (f16 + ((this.f326111i - f16) * e16)) / PhotoViewAttacher.this.I();
            PhotoViewAttacher.this.W.onScale(I, this.f326107d, this.f326108e);
            if (e16 < 1.0f) {
                com.tencent.mobileqq.wink.publish.widget.multitouchimg.a.a(PhotoViewAttacher.this.D, this);
                QLog.d("PhotoViewAttacher", 4, "AnimatedZoomRunnable postOnAnimation t:" + e16 + " deltaScale:" + I + " mFocalX:" + this.f326107d + " mFocalY:" + this.f326108e);
            }
            QLog.d("PhotoViewAttacher", 4, "AnimatedZoomRunnable t:" + e16 + " deltaScale:" + I + " mFocalX:" + this.f326107d + " mFocalY:" + this.f326108e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final OverScroller f326112d;

        /* renamed from: e, reason: collision with root package name */
        private int f326113e;

        /* renamed from: f, reason: collision with root package name */
        private int f326114f;

        public FlingRunnable(Context context) {
            this.f326112d = new OverScroller(context);
        }

        public void e() {
            this.f326112d.forceFinished(true);
        }

        public void f(int i3, int i16, int i17, int i18) {
            int i19;
            int i26;
            int i27;
            int i28;
            RectF C = PhotoViewAttacher.this.C();
            if (C == null) {
                return;
            }
            int round = Math.round(-C.left);
            float f16 = i3;
            if (f16 < C.width()) {
                i26 = Math.round(C.width() - f16);
                i19 = 0;
            } else {
                i19 = round;
                i26 = i19;
            }
            int round2 = Math.round(-C.top);
            float f17 = i16;
            if (f17 < C.height()) {
                i28 = Math.round(C.height() - f17);
                i27 = 0;
            } else {
                i27 = round2;
                i28 = i27;
            }
            this.f326113e = round;
            this.f326114f = round2;
            if (round != i26 || round2 != i28) {
                this.f326112d.fling(round, round2, i17, i18, i19, i26, i27, i28, 0, 0);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f326112d.isFinished() && this.f326112d.computeScrollOffset()) {
                int currX = this.f326112d.getCurrX();
                int currY = this.f326112d.getCurrY();
                PhotoViewAttacher.this.I.postTranslate(this.f326113e - currX, this.f326114f - currY);
                PhotoViewAttacher.this.A();
                this.f326113e = currX;
                this.f326114f = currY;
                com.tencent.mobileqq.wink.publish.widget.multitouchimg.a.a(PhotoViewAttacher.this.D, this);
            }
        }
    }

    /* loaded from: classes21.dex */
    class a implements com.tencent.mobileqq.wink.publish.widget.multitouchimg.d {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.publish.widget.multitouchimg.d
        public void onDrag(float f16, float f17) {
            if (PhotoViewAttacher.this.F.g()) {
                return;
            }
            PhotoViewAttacher.j(PhotoViewAttacher.this);
            PhotoViewAttacher.this.I.postTranslate(f16, f17);
            PhotoViewAttacher.this.A();
            QLog.d("PhotoViewAttacher", 4, "onDrag dx:" + f16 + " dy:" + f17 + " mAllowParentInterceptOnEdge:" + PhotoViewAttacher.this.f326106m + " mBlockParentIntercept:" + PhotoViewAttacher.this.C + " mHorizontalScrollEdge:" + PhotoViewAttacher.this.P + " mVerticalScrollEdge:" + PhotoViewAttacher.this.Q + " imageviewHashCode:" + PhotoViewAttacher.this.D.hashCode());
            ViewParent parent = PhotoViewAttacher.this.D.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(PhotoViewAttacher.this.L(f16, f17));
            }
        }

        @Override // com.tencent.mobileqq.wink.publish.widget.multitouchimg.d
        public void onFling(float f16, float f17, float f18, float f19) {
            QLog.d("PhotoViewAttacher", 2, "onFling startX:" + f16 + " startY:" + f17 + " getScale:" + PhotoViewAttacher.this.I() + " velocityX:" + f18 + " velocityY:" + f19);
            if (PhotoViewAttacher.this.I() == 1.0f) {
                return;
            }
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            photoViewAttacher.N = new FlingRunnable(photoViewAttacher.D.getContext());
            FlingRunnable flingRunnable = PhotoViewAttacher.this.N;
            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
            int H = photoViewAttacher2.H(photoViewAttacher2.D);
            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
            flingRunnable.f(H, photoViewAttacher3.G(photoViewAttacher3.D), (int) f18, (int) f19);
            PhotoViewAttacher.this.D.post(PhotoViewAttacher.this.N);
        }

        @Override // com.tencent.mobileqq.wink.publish.widget.multitouchimg.d
        public void onScale(float f16, float f17, float f18) {
            QLog.d("PhotoViewAttacher", 4, "onScale scalefactor:" + f16 + " curScale:" + PhotoViewAttacher.this.I() + " focusX:" + f17 + " focusY:" + f18);
            float I = PhotoViewAttacher.this.I();
            PhotoViewAttacher.this.S = f17;
            PhotoViewAttacher.this.T = f18;
            if (I <= PhotoViewAttacher.X || f16 <= 1.0f) {
                if (I < PhotoViewAttacher.f326099b0 && f16 < 1.0f) {
                    return;
                }
                PhotoViewAttacher.i(PhotoViewAttacher.this);
                PhotoViewAttacher.this.I.postScale(f16, f16, f17, f18);
                PhotoViewAttacher.this.A();
            }
        }
    }

    /* loaded from: classes21.dex */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            PhotoViewAttacher.l(PhotoViewAttacher.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PhotoViewAttacher.this.L != null) {
                PhotoViewAttacher.this.L.onLongClick(PhotoViewAttacher.this.D);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            QLog.d("PhotoViewAttacher", 4, "onScroll distanceX:" + f16 + " distanceY:" + f17);
            float f18 = 0.0f - f16;
            float f19 = 0.0f - f17;
            if (PhotoViewAttacher.this.W != null) {
                PhotoViewAttacher.this.W.onDrag(f18, f19);
            }
            return PhotoViewAttacher.this.L(f18, f19);
        }
    }

    /* loaded from: classes21.dex */
    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            PhotoViewAttacher.h(PhotoViewAttacher.this);
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            PhotoViewAttacher.this.C();
            motionEvent.getX();
            motionEvent.getY();
            PhotoViewAttacher.o(PhotoViewAttacher.this);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f326118a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f326118a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f326118a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f326118a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f326118a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
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
        this.R = 0.0f;
        this.F = new com.tencent.mobileqq.wink.publish.widget.multitouchimg.b(imageView.getContext(), this.W);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.E = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (B()) {
            O(E());
        }
    }

    private boolean B() {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        RectF D = D(E());
        if (D == null) {
            return false;
        }
        float height = D.height();
        float width = D.width();
        float G = G(this.D);
        float f27 = 0.0f;
        if (height <= G) {
            int i3 = d.f326118a[this.V.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f19 = (G - height) / 2.0f;
                    f26 = D.top;
                } else {
                    f19 = G - height;
                    f26 = D.top;
                }
                f16 = f19 - f26;
            } else {
                f16 = -D.top;
            }
            this.Q = 2;
        } else {
            float f28 = D.top;
            if (f28 > 0.0f) {
                this.Q = 0;
                f16 = -f28;
            } else {
                float f29 = D.bottom;
                if (f29 < G) {
                    this.Q = 1;
                    f16 = G - f29;
                } else {
                    this.Q = -1;
                    f16 = 0.0f;
                }
            }
        }
        float H = H(this.D);
        if (width <= H) {
            int i16 = d.f326118a[this.V.ordinal()];
            if (i16 != 2) {
                if (i16 != 3) {
                    f17 = (H - width) / 2.0f;
                    f18 = D.left;
                } else {
                    f17 = H - width;
                    f18 = D.left;
                }
                f27 = f17 - f18;
            } else {
                f27 = -D.left;
            }
            this.P = 2;
        } else {
            float f36 = D.left;
            if (f36 > 0.0f) {
                this.P = 0;
                f27 = -f36;
            } else {
                float f37 = D.right;
                if (f37 < H) {
                    f27 = H - f37;
                    this.P = 1;
                } else {
                    this.P = -1;
                }
            }
        }
        this.I.postTranslate(f27, f16);
        return true;
    }

    private RectF D(Matrix matrix) {
        if (this.D.getDrawable() != null) {
            this.J.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            matrix.mapRect(this.J);
            return this.J;
        }
        return null;
    }

    private Matrix E() {
        this.H.set(this.G);
        this.H.postConcat(this.I);
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float K(Matrix matrix, int i3) {
        matrix.getValues(this.K);
        return this.K[i3];
    }

    private void M() {
        this.I.reset();
        f0(this.R);
        O(E());
        B();
    }

    private void O(Matrix matrix) {
        this.D.setImageMatrix(matrix);
    }

    static /* bridge */ /* synthetic */ com.tencent.mobileqq.wink.publish.widget.multitouchimg.c h(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ i i(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ l j(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ k l(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ m o(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.getClass();
        return null;
    }

    private void p0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float H = H(this.D);
        float G = G(this.D);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        QLog.d("PhotoViewAttacher", 4, "updateBaseMatrix viewWidth:" + H + " viewHeight:" + G + " drawableWidth:" + intrinsicWidth + " drawableHeight:" + intrinsicHeight + " drawableHash:" + drawable.hashCode());
        this.G.reset();
        float f16 = (float) intrinsicWidth;
        float f17 = H / f16;
        float f18 = (float) intrinsicHeight;
        float f19 = G / f18;
        ImageView.ScaleType scaleType = this.V;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.G.postTranslate((H - f16) / 2.0f, (G - f18) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f17, f19);
            this.G.postScale(max, max);
            this.G.postTranslate((H - (f16 * max)) / 2.0f, (G - (f18 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f17, f19));
            this.G.postScale(min, min);
            this.G.postTranslate((H - (f16 * min)) / 2.0f, (G - (f18 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f16, f18);
            RectF rectF2 = new RectF(0.0f, 0.0f, H, G);
            if (((int) this.R) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f18, f16);
            }
            int i3 = d.f326118a[this.V.ordinal()];
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
                this.G.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        M();
    }

    private void z() {
        FlingRunnable flingRunnable = this.N;
        if (flingRunnable != null) {
            flingRunnable.e();
            this.N = null;
        }
    }

    public RectF C() {
        B();
        return D(E());
    }

    public Matrix F() {
        return this.H;
    }

    public float I() {
        return (float) Math.sqrt(((float) Math.pow(K(this.I, 0), 2.0d)) + ((float) Math.pow(K(this.I, 3), 2.0d)));
    }

    public ImageView.ScaleType J() {
        return this.V;
    }

    public boolean L(float f16, float f17) {
        boolean z16;
        boolean z17;
        int i3;
        int i16;
        if (this.f326106m && !this.F.g() && !this.C) {
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
            if (z16 && Math.abs(f17) * 0.6f > Math.abs(f16) && ((i16 = this.Q) == 2 || ((i16 == 0 && f17 >= 8.0f) || (i16 == 1 && f17 <= -8.0f)))) {
                QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent vertical solp false mAllowParentInterceptOnEdge:" + this.f326106m + " isScaling:" + this.F.g() + " mBlockParentIntercept:" + this.C + " getScale:" + I() + " mHorizontalScrollEdge:" + this.P + " mVerticalScrollEdge:" + this.Q + " dx:" + f16 + " dy:" + f17);
                return false;
            }
            if (z17 && 0.6f * Math.abs(f16) > Math.abs(f17) && ((i3 = this.P) == 2 || ((i3 == 0 && f16 >= 8.0f) || (i3 == 1 && f16 <= -8.0f)))) {
                QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent horizontal solp false mAllowParentInterceptOnEdge:" + this.f326106m + " isScaling:" + this.F.g() + " mBlockParentIntercept:" + this.C + " getScale:" + I() + " mHorizontalScrollEdge:" + this.P + " mVerticalScrollEdge:" + this.Q + " dx:" + f16 + " dy:" + f17);
                return false;
            }
            int i17 = this.Q;
            if ((i17 == 0 && this.P == 0 && f17 >= 8.0f && f16 >= 8.0f) || ((i17 == 0 && this.P == 1 && f17 >= 8.0f && f16 <= -8.0f) || ((i17 == 1 && this.P == 0 && f17 <= -8.0f && f16 >= 8.0f) || (i17 == 1 && this.P == 1 && f17 <= -8.0f && f16 <= -8.0f)))) {
                QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent corner slop false mAllowParentInterceptOnEdge:" + this.f326106m + " isScaling:" + this.F.g() + " mBlockParentIntercept:" + this.C + " getScale:" + I() + " mHorizontalScrollEdge:" + this.P + " mVerticalScrollEdge:" + this.Q + " dx:" + f16 + " dy:" + f17);
                return false;
            }
            QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent default:true mAllowParentInterceptOnEdge:" + this.f326106m + " isScaling:" + this.F.g() + " mBlockParentIntercept:" + this.C + " getScale:" + I() + " mHorizontalScrollEdge:" + this.P + " mVerticalScrollEdge:" + this.Q + " dx:" + f16 + " dy:" + f17);
            return true;
        }
        QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent true mAllowParentInterceptOnEdge:" + this.f326106m + " isScaling:" + this.F.g() + " mBlockParentIntercept:" + this.C + " getScale:" + I() + " mHorizontalScrollEdge:" + this.P + " mVerticalScrollEdge:" + this.Q + " dx:" + f16 + " dy:" + f17);
        return true;
    }

    public void N(boolean z16) {
        this.f326106m = z16;
    }

    public void P(float f16) {
        n.a(this.f326103f, this.f326104h, f16);
        this.f326105i = f16;
    }

    public void Q(float f16) {
        n.a(this.f326103f, f16, this.f326105i);
        this.f326104h = f16;
    }

    public void R(float f16) {
        n.a(f16, this.f326104h, this.f326105i);
        this.f326103f = f16;
    }

    public void U(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.E.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void V(View.OnLongClickListener onLongClickListener) {
        this.L = onLongClickListener;
    }

    public void Z(h hVar) {
        com.tencent.mobileqq.wink.publish.widget.multitouchimg.b bVar = this.F;
        if (bVar != null) {
            bVar.j(hVar);
        }
    }

    public void b0(j jVar) {
        this.M = jVar;
        com.tencent.mobileqq.wink.publish.widget.multitouchimg.b bVar = this.F;
        if (bVar != null) {
            bVar.k(jVar);
        }
    }

    public void f0(float f16) {
        this.I.postRotate(f16 % 360.0f);
        A();
    }

    public void g0(float f16) {
        this.I.setRotate(f16 % 360.0f);
        A();
    }

    public void h0(float f16) {
        j0(f16, false);
    }

    public void i0(float f16, float f17, float f18, boolean z16) {
        if (f16 >= this.f326103f && f16 <= this.f326105i) {
            if (z16) {
                this.D.post(new AnimatedZoomRunnable(I(), f16, f17, f18));
                return;
            } else {
                this.I.setScale(f16, f16, f17, f18);
                A();
                return;
            }
        }
        throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
    }

    public void j0(float f16, boolean z16) {
        i0(f16, this.D.getRight() / 2, this.D.getBottom() / 2, z16);
    }

    public void k0(float f16, float f17, float f18) {
        n.a(f16, f17, f18);
        this.f326103f = f16;
        this.f326104h = f17;
        this.f326105i = f18;
    }

    public void l0(ImageView.ScaleType scaleType) {
        if (n.d(scaleType) && scaleType != this.V) {
            this.V = scaleType;
            o0();
        }
    }

    public void m0(int i3) {
        this.f326102e = i3;
    }

    public void n0(boolean z16) {
        this.U = z16;
        o0();
    }

    public void o0() {
        if (this.U) {
            p0(this.D.getDrawable());
        } else {
            M();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i3 != i19 || i16 != i26 || i17 != i27 || i18 != i28) {
            p0(this.D.getDrawable());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x019d  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z16;
        com.tencent.mobileqq.wink.publish.widget.multitouchimg.b bVar;
        boolean z17;
        GestureDetector gestureDetector;
        boolean z18;
        boolean z19;
        boolean z26 = false;
        if (!this.U || !n.c((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (I() < this.f326103f) {
                    float I = I();
                    float f16 = f326099b0;
                    if (I >= f16) {
                        f16 = I;
                    }
                    RectF C = C();
                    if (C != null) {
                        QLog.d("PhotoViewAttacher", 4, "postAnimationZoom minscale event:" + motionEvent.getAction() + " scale:" + I() + " startScale:" + f16 + " mMinScale:" + this.f326103f + " rect:" + C.toString());
                        view.post(new AnimatedZoomRunnable(f16, this.f326103f, C.centerX(), C.centerY()));
                        z16 = true;
                    }
                } else if (I() > this.f326105i) {
                    float I2 = I();
                    float f17 = X;
                    if (I2 <= f17) {
                        f17 = I2;
                    }
                    QLog.d("PhotoViewAttacher", 4, "postAnimationZoom maxscale event:" + motionEvent.getAction() + " scale:" + I() + " startScale:" + f17 + " mMaxScale:" + this.f326105i + " scaleX:" + this.S + " scaleY:" + this.T);
                    view.post(new AnimatedZoomRunnable(f17, this.f326105i, this.S, this.T));
                    z16 = true;
                }
                bVar = this.F;
                if (bVar == null) {
                    boolean g16 = bVar.g();
                    boolean f18 = this.F.f();
                    boolean h16 = this.F.h(motionEvent);
                    if (!g16 && !this.F.g()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!f18 && !this.F.f()) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    int pointerCount = motionEvent.getPointerCount();
                    if ((z18 && z19) || pointerCount > 1) {
                        z26 = true;
                    }
                    this.C = z26;
                    QLog.d("PhotoViewAttacher", 4, "onTouch scaleDragDetector wasScaling:" + g16 + " wasDragging:" + f18 + " didntScale:" + z18 + " didntDrag:" + z19 + " mBlockParentIntercept:" + this.C);
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
            z();
        }
        z16 = false;
        bVar = this.F;
        if (bVar == null) {
        }
        gestureDetector = this.E;
        return gestureDetector == null ? z17 : z17;
    }

    public void S(View.OnClickListener onClickListener) {
    }

    public void T(com.tencent.mobileqq.wink.publish.widget.multitouchimg.c cVar) {
    }

    public void W(e eVar) {
    }

    public void X(f fVar) {
    }

    public void Y(g gVar) {
    }

    public void a0(i iVar) {
    }

    public void c0(k kVar) {
    }

    public void d0(l lVar) {
    }

    public void e0(m mVar) {
    }
}
