package com.tencent.biz.qqcircle.widgets.multitouchimg;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes5.dex */
public class PhotoViewScaleDetector implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* renamed from: a0, reason: collision with root package name */
    private static float f93641a0 = 3.5f;

    /* renamed from: b0, reason: collision with root package name */
    private static float f93642b0 = 1.0f;

    /* renamed from: c0, reason: collision with root package name */
    private static float f93643c0 = 0.6f;

    /* renamed from: d0, reason: collision with root package name */
    private static int f93644d0 = 200;

    /* renamed from: e0, reason: collision with root package name */
    private static int f93645e0 = 150;
    private ImageView C;
    private GestureDetector D;
    private com.tencent.biz.qqcircle.widgets.multitouchimg.b E;
    private View.OnLongClickListener K;
    private k L;
    private e M;
    private o N;
    private FlingRunnable P;
    private float S;
    private float T;
    private float U;
    private com.tencent.biz.qqcircle.widgets.multitouchimg.c X;

    /* renamed from: d, reason: collision with root package name */
    private Interpolator f93646d = new LinearInterpolator();

    /* renamed from: e, reason: collision with root package name */
    private int f93647e = f93644d0;

    /* renamed from: f, reason: collision with root package name */
    private float f93648f = f93642b0;

    /* renamed from: h, reason: collision with root package name */
    private float f93649h = f93641a0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f93650i = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f93651m = false;
    private final Matrix F = new Matrix();
    private final Matrix G = new Matrix();
    private final Matrix H = new Matrix();
    private final RectF I = new RectF();
    private final float[] J = new float[9];
    private int Q = 2;
    private int R = 2;
    private boolean V = true;
    private ImageView.ScaleType W = ImageView.ScaleType.FIT_CENTER;
    public RectF Y = new RectF();
    private f Z = new a();

    /* loaded from: classes5.dex */
    private class AnimatedTranslateRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private float f93652d;

        /* renamed from: e, reason: collision with root package name */
        private long f93653e;

        /* renamed from: f, reason: collision with root package name */
        float f93654f;
        final /* synthetic */ PhotoViewScaleDetector this$0;

        private float e() {
            return this.this$0.f93646d.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f93653e)) * 1.0f) / PhotoViewScaleDetector.f93645e0));
        }

        @Override // java.lang.Runnable
        public void run() {
            float e16 = e();
            this.this$0.H.postTranslate(0.0f, (e16 - this.f93654f) * this.f93652d);
            PhotoViewScaleDetector photoViewScaleDetector = this.this$0;
            photoViewScaleDetector.S(photoViewScaleDetector.B());
            this.f93654f = e16;
            if (e16 < 1.0f) {
                com.tencent.biz.qqcircle.widgets.multitouchimg.a.a(this.this$0.C, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    private class AnimatedZoomRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final float f93655d;

        /* renamed from: e, reason: collision with root package name */
        private final float f93656e;

        /* renamed from: f, reason: collision with root package name */
        private final long f93657f = System.currentTimeMillis();

        /* renamed from: h, reason: collision with root package name */
        private final float f93658h;

        /* renamed from: i, reason: collision with root package name */
        private final float f93659i;

        public AnimatedZoomRunnable(float f16, float f17, float f18, float f19) {
            this.f93655d = f18;
            this.f93656e = f19;
            this.f93658h = f16;
            this.f93659i = f17;
        }

        private float e() {
            return PhotoViewScaleDetector.this.f93646d.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f93657f)) * 1.0f) / PhotoViewScaleDetector.this.f93647e));
        }

        @Override // java.lang.Runnable
        public void run() {
            float e16 = e();
            float f16 = this.f93658h;
            PhotoViewScaleDetector.this.Z.onScale((f16 + ((this.f93659i - f16) * e16)) / PhotoViewScaleDetector.this.F(), this.f93655d, this.f93656e);
            if (e16 < 1.0f) {
                com.tencent.biz.qqcircle.widgets.multitouchimg.a.a(PhotoViewScaleDetector.this.C, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final OverScroller f93660d;

        /* renamed from: e, reason: collision with root package name */
        private int f93661e;

        /* renamed from: f, reason: collision with root package name */
        private int f93662f;

        public FlingRunnable(Context context) {
            this.f93660d = new OverScroller(context);
        }

        public void e() {
            this.f93660d.forceFinished(true);
        }

        public void f(int i3, int i16, int i17, int i18) {
            int i19;
            int i26;
            int i27;
            int i28;
            RectF z16 = PhotoViewScaleDetector.this.z();
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
            this.f93661e = round;
            this.f93662f = round2;
            if (round != i26 || round2 != i28) {
                this.f93660d.fling(round, round2, i17, i18, i19, i26, i27, i28, 0, 0);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f93660d.isFinished() && this.f93660d.computeScrollOffset()) {
                int currX = this.f93660d.getCurrX();
                int currY = this.f93660d.getCurrY();
                PhotoViewScaleDetector.this.H.postTranslate(this.f93661e - currX, this.f93662f - currY);
                PhotoViewScaleDetector.this.v();
                this.f93661e = currX;
                this.f93662f = currY;
                com.tencent.biz.qqcircle.widgets.multitouchimg.a.a(PhotoViewScaleDetector.this.C, this);
            }
        }
    }

    /* loaded from: classes5.dex */
    class a implements f {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.f
        public void onDrag(float f16, float f17) {
            if (PhotoViewScaleDetector.this.E.g()) {
                return;
            }
            Log.d("PhotoViewScaleDetector", "onDrag--mSuppMatrix dx=" + f16 + " dy=" + f17);
            PhotoViewScaleDetector.this.H.postTranslate(f16, f17);
            PhotoViewScaleDetector.this.v();
            ViewParent parent = PhotoViewScaleDetector.this.C.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(PhotoViewScaleDetector.this.I(f16, f17));
            }
        }

        @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.f
        public void onFling(float f16, float f17, float f18, float f19) {
            if (PhotoViewScaleDetector.this.F() == 1.0f) {
                return;
            }
            PhotoViewScaleDetector photoViewScaleDetector = PhotoViewScaleDetector.this;
            photoViewScaleDetector.P = new FlingRunnable(photoViewScaleDetector.C.getContext());
            FlingRunnable flingRunnable = PhotoViewScaleDetector.this.P;
            PhotoViewScaleDetector photoViewScaleDetector2 = PhotoViewScaleDetector.this;
            int E = photoViewScaleDetector2.E(photoViewScaleDetector2.C);
            PhotoViewScaleDetector photoViewScaleDetector3 = PhotoViewScaleDetector.this;
            flingRunnable.f(E, photoViewScaleDetector3.D(photoViewScaleDetector3.C), (int) f18, (int) f19);
            PhotoViewScaleDetector.this.C.post(PhotoViewScaleDetector.this.P);
        }

        @Override // com.tencent.biz.qqcircle.widgets.multitouchimg.f
        public void onScale(float f16, float f17, float f18) {
            float F = PhotoViewScaleDetector.this.F();
            PhotoViewScaleDetector.this.T = f17;
            PhotoViewScaleDetector.this.U = f18;
            if (F <= PhotoViewScaleDetector.this.f93649h * 2.0f || f16 <= 1.0f) {
                if (F < PhotoViewScaleDetector.f93643c0 && f16 < 1.0f) {
                    return;
                }
                if (PhotoViewScaleDetector.this.L != null) {
                    PhotoViewScaleDetector.this.L.a(f16, f17, f18, F);
                }
                Log.d("PhotoViewScaleDetector", "onScale-mSuppMatrix scaleFactor=" + f16 + " focusX=" + f17 + " focusY=" + f18);
                PhotoViewScaleDetector.this.H.postScale(f16, f16, f17, f18);
                PhotoViewScaleDetector.this.v();
            }
        }
    }

    /* loaded from: classes5.dex */
    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PhotoViewScaleDetector.this.K != null) {
                PhotoViewScaleDetector.this.K.onLongClick(PhotoViewScaleDetector.this.C);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            float f18 = 0.0f - f16;
            float f19 = 0.0f - f17;
            if (PhotoViewScaleDetector.this.Z != null) {
                PhotoViewScaleDetector.this.Z.onDrag(f18, f19);
            }
            return PhotoViewScaleDetector.this.I(f18, f19);
        }
    }

    /* loaded from: classes5.dex */
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
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            if (PhotoViewScaleDetector.this.N != null) {
                PhotoViewScaleDetector.this.N.onViewTap(PhotoViewScaleDetector.this.C, x16, y16);
                return false;
            }
            return false;
        }
    }

    public PhotoViewScaleDetector(ImageView imageView) {
        this.C = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.S = 0.0f;
        this.E = new com.tencent.biz.qqcircle.widgets.multitouchimg.b(imageView.getContext(), this.Z);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b(), new Handler(Looper.getMainLooper()));
        this.D = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int E(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float H(Matrix matrix, int i3) {
        matrix.getValues(this.J);
        return this.J[i3];
    }

    private boolean J(float f16, float f17, float f18, float f19, boolean z16) {
        if (z16 && f19 * Math.abs(f16) > Math.abs(f17)) {
            int i3 = this.Q;
            if (i3 == 2 || ((i3 == 0 && f16 >= f18) || (i3 == 1 && f16 <= 0.0f - f18))) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean K(float f16, float f17, float f18, float f19, boolean z16) {
        if (z16 && f19 * Math.abs(f17) > Math.abs(f16)) {
            int i3 = this.R;
            if (i3 == 2 || ((i3 == 0 && f17 >= f18) || (i3 == 1 && f17 <= 0.0f - f18))) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean L(float f16, float f17, float f18) {
        if (this.R == 1 && this.Q == 0 && f17 <= 0.0f - f18 && f16 >= f18) {
            return true;
        }
        return false;
    }

    private boolean M(float f16, float f17, float f18) {
        if (this.R == 0 && this.Q == 0 && f17 >= f18 && f16 >= f18) {
            return true;
        }
        return false;
    }

    private boolean O(float f16, float f17, float f18) {
        if (this.R == 1 && this.Q == 1) {
            float f19 = 0.0f - f18;
            if (f17 <= f19 && f16 <= f19) {
                return true;
            }
        }
        return false;
    }

    private boolean P(float f16, float f17, float f18) {
        if (this.R == 0 && this.Q == 1 && f17 >= f18 && f16 <= 0.0f - f18) {
            return true;
        }
        return false;
    }

    private void R(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float E = E(this.C);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.F.reset();
        if (this.X != null) {
            QLog.d("PhotoViewScaleDetector", 1, "updateBaseMatrix  mBaseMatrix.reset()----------");
            QLog.d("PhotoViewScaleDetector", 1, "updateBaseMatrix  mBaseMatrix scaleWith=" + this.X.f93680a + " scaleHeight=" + this.X.f93681b + " drawableInitialParams.posX=" + this.X.f93682c + " drawableInitialParams.posY=" + this.X.f93683d);
            Matrix matrix = this.F;
            com.tencent.biz.qqcircle.widgets.multitouchimg.c cVar = this.X;
            matrix.postScale(cVar.f93680a, cVar.f93681b);
            Matrix matrix2 = this.F;
            com.tencent.biz.qqcircle.widgets.multitouchimg.c cVar2 = this.X;
            matrix2.postTranslate((float) cVar2.f93682c, (float) cVar2.f93683d);
        } else {
            this.F.postScale(1.0f, 1.0f);
            this.F.postTranslate((E - intrinsicWidth) / 2.0f, 0.0f);
        }
        S(B());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(Matrix matrix) {
        this.C.setImageMatrix(matrix);
    }

    private void u() {
        FlingRunnable flingRunnable = this.P;
        if (flingRunnable != null) {
            flingRunnable.e();
            this.P = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (w()) {
            S(B());
        }
    }

    private boolean w() {
        return x();
    }

    private boolean x() {
        float f16;
        RectF A = A(B());
        if (A == null) {
            return false;
        }
        float width = A.width();
        int D = D(this.C);
        int E = E(this.C);
        if (D <= 0 || E <= 0) {
            return false;
        }
        Log.d("PhotoViewScaleDetector", "checkMatrixBoundsInAfterCenter-mSuppMatrix nextDisplayWidth=" + width + " viewWidth=" + E);
        float f17 = (float) E;
        if (width <= f17) {
            f16 = ((f17 - width) / 2.0f) - A.left;
            this.Q = 2;
        } else {
            float f18 = A.left;
            if (f18 > 0.0f) {
                this.Q = 0;
                f16 = -f18;
            } else {
                float f19 = A.right;
                if (f19 < f17) {
                    f16 = f17 - f19;
                    this.Q = 1;
                } else {
                    this.Q = -1;
                    f16 = 0.0f;
                }
            }
        }
        Log.d("PhotoViewScaleDetector", "checkMatrixBoundsInAfterCenter-mSuppMatrix deltaX=" + f16 + " deltaY=0.0 mHorizontalScrollEdge=" + this.Q);
        this.H.postTranslate(f16, 0.0f);
        return true;
    }

    private boolean y() {
        if (this.f93650i && !this.E.g() && !this.f93651m) {
            return true;
        }
        return false;
    }

    public RectF A(Matrix matrix) {
        if (this.C.getDrawable() != null) {
            this.I.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            matrix.mapRect(this.I);
            return this.I;
        }
        return null;
    }

    public Matrix B() {
        this.G.set(this.F);
        this.G.postConcat(this.H);
        return this.G;
    }

    public Matrix C() {
        return this.G;
    }

    public float F() {
        return (float) Math.sqrt(((float) Math.pow(H(this.H, 0), 2.0d)) + ((float) Math.pow(H(this.H, 3), 2.0d)));
    }

    public ImageView.ScaleType G() {
        return this.W;
    }

    public boolean I(float f16, float f17) {
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
        if (!K(f16, f17, 8.0f, 0.6f, z16) && !J(f16, f17, 8.0f, 0.6f, z17) && !M(f16, f17, 8.0f) && !P(f16, f17, 8.0f) && !L(f16, f17, 8.0f) && !O(f16, f17, 8.0f)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N() {
        this.H.reset();
        this.H.postRotate(this.S % 360.0f);
        if (w()) {
            S(B());
        }
    }

    public void Q(com.tencent.biz.qqcircle.widgets.multitouchimg.c cVar) {
        this.X = cVar;
    }

    public void T(e eVar) {
        this.M = eVar;
    }

    public void U(View.OnLongClickListener onLongClickListener) {
        this.K = onLongClickListener;
    }

    public void W(ImageView.ScaleType scaleType) {
        if (scaleType != this.W) {
            this.W = scaleType;
            X();
        }
    }

    public void X() {
        Log.d("PhotoViewScaleDetector", "update mZoomEnabled=" + this.V);
        if (this.V) {
            R(this.C.getDrawable());
        } else {
            N();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Log.d("PhotoViewScaleDetector", "onLayoutChange left=" + i3 + " top=" + i16 + " right=" + i17 + " bottom=" + i18);
        if (i3 != i19 || i16 != i26 || i17 != i27 || i18 != i28) {
            R(this.C.getDrawable());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
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
        boolean z26 = false;
        if (!this.V || !p.c((ImageView) view)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                if (F() < this.f93648f) {
                    float F = F();
                    float f17 = f93643c0;
                    if (F < f17) {
                        f16 = f17;
                    } else {
                        f16 = F;
                    }
                    RectF z27 = z();
                    if (z27 != null) {
                        view.post(new AnimatedZoomRunnable(f16, this.f93648f, z27.centerX(), z27.centerY()));
                        z16 = true;
                    }
                    z16 = false;
                } else {
                    if (F() > this.f93649h) {
                        float F2 = F();
                        float f18 = this.f93649h;
                        if (F2 > f18 * 2.0f) {
                            F2 = f18 * 2.0f;
                        }
                        view.post(new AnimatedZoomRunnable(F2, f18, this.T, this.U));
                        z16 = true;
                    }
                    z16 = false;
                }
                e eVar = this.M;
                if (eVar != null) {
                    eVar.onDragEnd();
                }
                bVar = this.E;
                if (bVar == null) {
                    boolean g16 = bVar.g();
                    boolean f19 = this.E.f();
                    boolean h16 = this.E.h(motionEvent);
                    if (!g16 && !this.E.g()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!f19 && !this.E.f()) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    int pointerCount = motionEvent.getPointerCount();
                    if ((z18 && z19) || pointerCount > 1) {
                        z26 = true;
                    }
                    this.f93651m = z26;
                    z17 = h16;
                } else {
                    z17 = z16;
                }
                gestureDetector = this.D;
                if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                    return true;
                }
            }
        } else {
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            u();
        }
        z16 = false;
        bVar = this.E;
        if (bVar == null) {
        }
        gestureDetector = this.D;
        return gestureDetector == null ? z17 : z17;
    }

    public RectF z() {
        w();
        return A(B());
    }

    public void V(g gVar) {
    }
}
