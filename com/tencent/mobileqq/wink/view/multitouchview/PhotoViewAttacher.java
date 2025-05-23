package com.tencent.mobileqq.wink.view.multitouchview;

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

    /* renamed from: b0, reason: collision with root package name */
    private static float f327024b0 = 7.0f;

    /* renamed from: c0, reason: collision with root package name */
    private static float f327025c0 = 3.5f;

    /* renamed from: d0, reason: collision with root package name */
    private static float f327026d0 = 1.75f;

    /* renamed from: e0, reason: collision with root package name */
    private static float f327027e0 = 1.0f;

    /* renamed from: f0, reason: collision with root package name */
    private static float f327028f0 = 0.6f;

    /* renamed from: g0, reason: collision with root package name */
    private static int f327029g0 = 200;
    private boolean C;
    private final View D;
    private Drawable E;
    private GestureDetector F;
    private com.tencent.mobileqq.wink.view.multitouchview.b G;
    private final Matrix H;
    private final Matrix I;
    private final Matrix J;
    private final RectF K;
    private final float[] L;
    private e M;
    private com.tencent.mobileqq.wink.view.multitouchview.d N;
    private View.OnClickListener P;
    private View.OnLongClickListener Q;
    private FlingRunnable R;
    private int S;
    private int T;
    private float U;
    private float V;
    private float W;
    private boolean X;
    private boolean Y;
    private ImageView.ScaleType Z;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.mobileqq.wink.view.multitouchview.c f327030a0;

    /* renamed from: d, reason: collision with root package name */
    private Interpolator f327031d;

    /* renamed from: e, reason: collision with root package name */
    private int f327032e;

    /* renamed from: f, reason: collision with root package name */
    private float f327033f;

    /* renamed from: h, reason: collision with root package name */
    private float f327034h;

    /* renamed from: i, reason: collision with root package name */
    private float f327035i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f327036m;

    /* loaded from: classes21.dex */
    private class AnimatedZoomRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final float f327037d;

        /* renamed from: e, reason: collision with root package name */
        private final float f327038e;

        /* renamed from: f, reason: collision with root package name */
        private final long f327039f = System.currentTimeMillis();

        /* renamed from: h, reason: collision with root package name */
        private final float f327040h;

        /* renamed from: i, reason: collision with root package name */
        private final float f327041i;

        public AnimatedZoomRunnable(float f16, float f17, float f18, float f19) {
            this.f327037d = f18;
            this.f327038e = f19;
            this.f327040h = f16;
            this.f327041i = f17;
        }

        private float e() {
            return PhotoViewAttacher.this.f327031d.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f327039f)) * 1.0f) / PhotoViewAttacher.this.f327032e));
        }

        @Override // java.lang.Runnable
        public void run() {
            float e16 = e();
            float f16 = this.f327040h;
            float D = (f16 + ((this.f327041i - f16) * e16)) / PhotoViewAttacher.this.D();
            PhotoViewAttacher.this.f327030a0.onScale(D, this.f327037d, this.f327038e);
            if (e16 < 1.0f) {
                com.tencent.mobileqq.wink.view.multitouchview.a.a(PhotoViewAttacher.this.D, this);
                QLog.d("PhotoViewAttacher", 4, "AnimatedZoomRunnable postOnAnimation t:" + e16 + " deltaScale:" + D + " mFocalX:" + this.f327037d + " mFocalY:" + this.f327038e);
            }
            QLog.d("PhotoViewAttacher", 4, "AnimatedZoomRunnable t:" + e16 + " deltaScale:" + D + " mFocalX:" + this.f327037d + " mFocalY:" + this.f327038e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final OverScroller f327042d;

        /* renamed from: e, reason: collision with root package name */
        private int f327043e;

        /* renamed from: f, reason: collision with root package name */
        private int f327044f;

        public FlingRunnable(Context context) {
            this.f327042d = new OverScroller(context);
        }

        public void e() {
            this.f327042d.forceFinished(true);
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
            this.f327043e = round;
            this.f327044f = round2;
            if (round != i26 || round2 != i28) {
                this.f327042d.fling(round, round2, i17, i18, i19, i26, i27, i28, 0, 0);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f327042d.isFinished() && this.f327042d.computeScrollOffset()) {
                int currX = this.f327042d.getCurrX();
                int currY = this.f327042d.getCurrY();
                PhotoViewAttacher.this.J.postTranslate(this.f327043e - currX, this.f327044f - currY);
                PhotoViewAttacher.this.x();
                this.f327043e = currX;
                this.f327044f = currY;
                com.tencent.mobileqq.wink.view.multitouchview.a.a(PhotoViewAttacher.this.D, this);
            }
        }
    }

    /* loaded from: classes21.dex */
    class a implements com.tencent.mobileqq.wink.view.multitouchview.c {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.view.multitouchview.c
        public void onDrag(float f16, float f17) {
            if (PhotoViewAttacher.this.G.e()) {
                return;
            }
            PhotoViewAttacher.this.J.postTranslate(f16, f17);
            PhotoViewAttacher.this.x();
            QLog.d("PhotoViewAttacher", 4, "onDrag dx:" + f16 + " dy:" + f17 + " mAllowParentInterceptOnEdge:" + PhotoViewAttacher.this.f327036m + " mBlockParentIntercept:" + PhotoViewAttacher.this.C + " mHorizontalScrollEdge:" + PhotoViewAttacher.this.S + " mVerticalScrollEdge:" + PhotoViewAttacher.this.T + " imageviewHashCode:" + PhotoViewAttacher.this.D.hashCode());
            ViewParent parent = PhotoViewAttacher.this.D.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(PhotoViewAttacher.this.L(f16, f17));
            }
        }

        @Override // com.tencent.mobileqq.wink.view.multitouchview.c
        public void onFling(float f16, float f17, float f18, float f19) {
            QLog.d("PhotoViewAttacher", 2, "onFling startX:" + f16 + " startY:" + f17 + " getScale:" + PhotoViewAttacher.this.D() + " velocityX:" + f18 + " velocityY:" + f19);
            if (PhotoViewAttacher.this.D() == 1.0f) {
                return;
            }
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            photoViewAttacher.R = new FlingRunnable(photoViewAttacher.D.getContext());
            FlingRunnable flingRunnable = PhotoViewAttacher.this.R;
            PhotoViewAttacher photoViewAttacher2 = PhotoViewAttacher.this;
            int H = photoViewAttacher2.H(photoViewAttacher2.D);
            PhotoViewAttacher photoViewAttacher3 = PhotoViewAttacher.this;
            flingRunnable.f(H, photoViewAttacher3.G(photoViewAttacher3.D), (int) f18, (int) f19);
            PhotoViewAttacher.this.D.post(PhotoViewAttacher.this.R);
        }

        @Override // com.tencent.mobileqq.wink.view.multitouchview.c
        public void onScale(float f16, float f17, float f18) {
            if (!PhotoViewAttacher.this.Y) {
                return;
            }
            QLog.d("PhotoViewAttacher", 4, "onScale scalefactor:" + f16 + " curScale:" + PhotoViewAttacher.this.D() + " focusX:" + f17 + " focusY:" + f18);
            float D = PhotoViewAttacher.this.D();
            PhotoViewAttacher.this.V = f17;
            PhotoViewAttacher.this.W = f18;
            if (D <= PhotoViewAttacher.f327024b0 || f16 <= 1.0f) {
                if (D < PhotoViewAttacher.f327028f0 && f16 < 1.0f) {
                    return;
                }
                PhotoViewAttacher.this.J.postScale(f16, f16, f17, f18);
                PhotoViewAttacher.this.x();
            }
        }
    }

    /* loaded from: classes21.dex */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PhotoViewAttacher.this.Q != null) {
                PhotoViewAttacher.this.Q.onLongClick(PhotoViewAttacher.this.D);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            QLog.d("PhotoViewAttacher", 4, "onScroll distanceX:" + f16 + " distanceY:" + f17);
            float f18 = 0.0f - f16;
            float f19 = 0.0f - f17;
            if (PhotoViewAttacher.this.f327030a0 != null) {
                PhotoViewAttacher.this.f327030a0.onDrag(f18, f19);
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
            if (PhotoViewAttacher.this.N != null) {
                PhotoViewAttacher.this.N.onViewTap(PhotoViewAttacher.this.D, x16, y16);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f327048a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f327048a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f327048a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f327048a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f327048a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes21.dex */
    public interface e {
        void a(Matrix matrix);
    }

    public PhotoViewAttacher(View view, Drawable drawable) {
        this(view);
        this.E = drawable;
    }

    private RectF A(Matrix matrix) {
        Drawable drawable = this.E;
        if (drawable == null) {
            drawable = ((ImageView) this.D).getDrawable();
        }
        if (drawable != null) {
            this.K.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(this.K);
            return this.K;
        }
        return null;
    }

    private Matrix B() {
        this.I.set(this.H);
        this.I.postConcat(this.J);
        return this.I;
    }

    private float F(Matrix matrix, int i3) {
        matrix.getValues(this.L);
        return this.L[i3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G(View view) {
        return (view.getHeight() - view.getPaddingTop()) - view.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int H(View view) {
        return (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
    }

    private boolean I(float f16, float f17, float f18) {
        if (Math.abs(f16) > f18 && Math.abs(f16) > Math.abs(f17)) {
            return true;
        }
        return false;
    }

    private boolean J(float f16, float f17, float f18, float f19, boolean z16) {
        if (z16 && f19 * Math.abs(f16) > Math.abs(f17)) {
            int i3 = this.S;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 0 && f16 >= f18) {
                return true;
            }
            if (i3 == 1 && f16 <= 0.0f - f18) {
                return true;
            }
        }
        return false;
    }

    private boolean K(float f16, float f17, float f18, float f19, boolean z16) {
        if (z16 && f19 * Math.abs(f17) > Math.abs(f16)) {
            int i3 = this.T;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 0 && f17 >= f18) {
                return true;
            }
            if (i3 == 1 && f17 <= 0.0f - f18) {
                return true;
            }
        }
        return false;
    }

    private boolean M(float f16, float f17, float f18) {
        int i3 = this.T;
        if (i3 == 0 && this.S == 0 && f17 >= f18 && f16 >= f18) {
            return true;
        }
        if (i3 == 0 && this.S == 1 && f17 >= f18 && f16 <= 0.0f - f18) {
            return true;
        }
        if (i3 == 1 && this.S == 0 && f17 <= 0.0f - f18 && f16 >= f18) {
            return true;
        }
        if (i3 == 1 && this.S == 1) {
            float f19 = 0.0f - f18;
            if (f17 <= f19 && f16 <= f19) {
                return true;
            }
        }
        return false;
    }

    private boolean N(float f16, float f17, float f18) {
        if (Math.abs(f17) > f18 && Math.abs(f17) > Math.abs(f16)) {
            return true;
        }
        return false;
    }

    private void O() {
        this.J.reset();
        U(this.U);
        P(B());
        y();
    }

    private void P(Matrix matrix) {
        View view = this.D;
        if (!(view instanceof ImageView)) {
            e eVar = this.M;
            if (eVar != null) {
                eVar.a(matrix);
                return;
            }
            return;
        }
        ((ImageView) view).setImageMatrix(matrix);
    }

    private void Y() {
        Drawable drawable = this.E;
        if (drawable == null) {
            drawable = ((ImageView) this.D).getDrawable();
        }
        if (drawable == null) {
            return;
        }
        float H = H(this.D);
        float G = G(this.D);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        QLog.d("PhotoViewAttacher", 4, "updateBaseMatrix viewWidth:" + H + " viewHeight:" + G + " drawableWidth:" + intrinsicWidth + " drawableHeight:" + intrinsicHeight + " drawableHash:" + drawable.hashCode());
        this.H.reset();
        float f16 = (float) intrinsicWidth;
        float f17 = H / f16;
        float f18 = (float) intrinsicHeight;
        float f19 = G / f18;
        ImageView.ScaleType scaleType = this.Z;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.H.postTranslate((H - f16) / 2.0f, (G - f18) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f17, f19);
            this.H.postScale(max, max);
            this.H.postTranslate((H - (f16 * max)) / 2.0f, (G - (f18 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f17, f19));
            this.H.postScale(min, min);
            this.H.postTranslate((H - (f16 * min)) / 2.0f, (G - (f18 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f16, f18);
            RectF rectF2 = new RectF(0.0f, 0.0f, H, G);
            if (((int) this.U) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f18, f16);
            }
            int i3 = d.f327048a[this.Z.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            this.H.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                        }
                    } else {
                        this.H.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                    }
                } else {
                    this.H.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                }
            } else {
                this.H.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            }
        }
        O();
    }

    private void w() {
        FlingRunnable flingRunnable = this.R;
        if (flingRunnable != null) {
            flingRunnable.e();
            this.R = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (y()) {
            P(B());
        }
    }

    private boolean y() {
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
        float G = G(this.D);
        float f27 = 0.0f;
        if (height <= G) {
            int i3 = d.f327048a[this.Z.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f19 = (G - height) / 2.0f;
                    f26 = A.top;
                } else {
                    f19 = G - height;
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
                if (f29 < G) {
                    this.T = 1;
                    f16 = G - f29;
                } else {
                    this.T = -1;
                    f16 = 0.0f;
                }
            }
        }
        float H = H(this.D);
        if (width <= H) {
            int i16 = d.f327048a[this.Z.ordinal()];
            if (i16 != 2) {
                if (i16 != 3) {
                    f17 = (H - width) / 2.0f;
                    f18 = A.left;
                } else {
                    f17 = H - width;
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
                if (f37 < H) {
                    f27 = H - f37;
                    this.S = 1;
                } else {
                    this.S = -1;
                }
            }
        }
        this.J.postTranslate(f27, f16);
        return true;
    }

    public Matrix C() {
        return this.I;
    }

    public float D() {
        return (float) Math.sqrt(((float) Math.pow(F(this.J, 0), 2.0d)) + ((float) Math.pow(F(this.J, 3), 2.0d)));
    }

    public ImageView.ScaleType E() {
        return this.Z;
    }

    public boolean L(float f16, float f17) {
        if (this.f327036m && !this.G.e() && !this.C) {
            boolean N = N(f16, f17, 8.0f);
            boolean I = I(f16, f17, 8.0f);
            if (K(f16, f17, 8.0f, 0.6f, N)) {
                QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent vertical solp false mAllowParentInterceptOnEdge:" + this.f327036m + " isScaling:" + this.G.e() + " mBlockParentIntercept:" + this.C + " getScale:" + D() + " mHorizontalScrollEdge:" + this.S + " mVerticalScrollEdge:" + this.T + " dx:" + f16 + " dy:" + f17);
                return false;
            }
            if (J(f16, f17, 8.0f, 0.6f, I)) {
                QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent horizontal solp false mAllowParentInterceptOnEdge:" + this.f327036m + " isScaling:" + this.G.e() + " mBlockParentIntercept:" + this.C + " getScale:" + D() + " mHorizontalScrollEdge:" + this.S + " mVerticalScrollEdge:" + this.T + " dx:" + f16 + " dy:" + f17);
                return false;
            }
            if (M(f16, f17, 8.0f)) {
                QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent corner slop false mAllowParentInterceptOnEdge:" + this.f327036m + " isScaling:" + this.G.e() + " mBlockParentIntercept:" + this.C + " getScale:" + D() + " mHorizontalScrollEdge:" + this.S + " mVerticalScrollEdge:" + this.T + " dx:" + f16 + " dy:" + f17);
                return false;
            }
            QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent default:true mAllowParentInterceptOnEdge:" + this.f327036m + " isScaling:" + this.G.e() + " mBlockParentIntercept:" + this.C + " getScale:" + D() + " mHorizontalScrollEdge:" + this.S + " mVerticalScrollEdge:" + this.T + " dx:" + f16 + " dy:" + f17);
            return true;
        }
        QLog.d("PhotoViewAttacher", 4, "isNeedToDisAllowInterceptEvent true mAllowParentInterceptOnEdge:" + this.f327036m + " isScaling:" + this.G.e() + " mBlockParentIntercept:" + this.C + " getScale:" + D() + " mHorizontalScrollEdge:" + this.S + " mVerticalScrollEdge:" + this.T + " dx:" + f16 + " dy:" + f17);
        return true;
    }

    public void Q(View.OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public void R(View.OnLongClickListener onLongClickListener) {
        this.Q = onLongClickListener;
    }

    public void S(e eVar) {
        this.M = eVar;
    }

    public void T(com.tencent.mobileqq.wink.view.multitouchview.d dVar) {
        this.N = dVar;
    }

    public void U(float f16) {
        this.J.postRotate(f16 % 360.0f);
        x();
    }

    public void V(ImageView.ScaleType scaleType) {
        if (com.tencent.mobileqq.wink.view.multitouchview.e.c(scaleType) && scaleType != this.Z) {
            this.Z = scaleType;
            X();
        }
    }

    public void W(boolean z16) {
        this.Y = z16;
    }

    public void X() {
        if (this.X) {
            Y();
        } else {
            O();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        if (i3 != i19 || i16 != i26 || i17 != i27 || i18 != i28) {
            Y();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0138  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        com.tencent.mobileqq.wink.view.multitouchview.b bVar;
        GestureDetector gestureDetector;
        boolean z18;
        boolean z19;
        boolean z26 = view instanceof ImageView;
        boolean z27 = false;
        if ((z26 && com.tencent.mobileqq.wink.view.multitouchview.e.b((ImageView) view)) || (!z26 && this.E != null)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!this.X || !z16) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (D() < this.f327033f) {
                    float D = D();
                    float f16 = f327028f0;
                    if (D >= f16) {
                        f16 = D;
                    }
                    RectF z28 = z();
                    if (z28 != null) {
                        QLog.d("PhotoViewAttacher", 4, "postAnimationZoom minscale event:" + motionEvent.getAction() + " scale:" + D() + " startScale:" + f16 + " mMinScale:" + this.f327033f + " rect:" + z28.toString());
                        view.post(new AnimatedZoomRunnable(f16, this.f327033f, z28.centerX(), z28.centerY()));
                        z17 = true;
                    }
                } else if (D() > this.f327035i) {
                    float D2 = D();
                    float f17 = f327024b0;
                    if (D2 <= f17) {
                        f17 = D2;
                    }
                    QLog.d("PhotoViewAttacher", 4, "postAnimationZoom maxscale event:" + motionEvent.getAction() + " scale:" + D() + " startScale:" + f17 + " mMaxScale:" + this.f327035i + " scaleX:" + this.V + " scaleY:" + this.W);
                    view.post(new AnimatedZoomRunnable(f17, this.f327035i, this.V, this.W));
                    z17 = true;
                }
                bVar = this.G;
                if (bVar != null) {
                    boolean e16 = bVar.e();
                    boolean d16 = this.G.d();
                    boolean f18 = this.G.f(motionEvent);
                    if (!e16 && !this.G.e()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!d16 && !this.G.d()) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    int pointerCount = motionEvent.getPointerCount();
                    if ((z18 && z19) || pointerCount > 1) {
                        z27 = true;
                    }
                    this.C = z27;
                    QLog.d("PhotoViewAttacher", 4, "onTouch scaleDragDetector wasScaling:" + e16 + " wasDragging:" + d16 + " didntScale:" + z18 + " didntDrag:" + z19 + " mBlockParentIntercept:" + this.C);
                    z17 = f18;
                }
                gestureDetector = this.F;
                if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                    return true;
                }
                return z17;
            }
        } else {
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            w();
        }
        z17 = false;
        bVar = this.G;
        if (bVar != null) {
        }
        gestureDetector = this.F;
        if (gestureDetector == null) {
        }
        return z17;
    }

    public RectF z() {
        y();
        return A(B());
    }

    public PhotoViewAttacher(View view) {
        this.f327031d = new AccelerateDecelerateInterpolator();
        this.f327032e = f327029g0;
        this.f327033f = f327027e0;
        this.f327034h = f327026d0;
        this.f327035i = f327025c0;
        this.f327036m = true;
        this.C = false;
        this.H = new Matrix();
        this.I = new Matrix();
        this.J = new Matrix();
        this.K = new RectF();
        this.L = new float[9];
        this.S = 2;
        this.T = 2;
        this.X = true;
        this.Y = true;
        this.Z = ImageView.ScaleType.FIT_CENTER;
        this.f327030a0 = new a();
        this.D = view;
        view.setOnTouchListener(this);
        view.addOnLayoutChangeListener(this);
        if (view.isInEditMode()) {
            return;
        }
        this.U = 0.0f;
        this.G = new com.tencent.mobileqq.wink.view.multitouchview.b(view.getContext(), this.f327030a0);
        GestureDetector gestureDetector = new GestureDetector(view.getContext(), new b());
        this.F = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }
}
