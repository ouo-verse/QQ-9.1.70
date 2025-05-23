package com.tencent.richmediabrowser.view.recyclerview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.listener.IBrowserFlingControlListener;
import com.tencent.richmediabrowser.listener.IBrowserScaleControlListener;
import com.tencent.richmediabrowser.listener.IBrowserScaleEventListener;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.SPlayerVideoView;
import e04.c;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BrowserScaleVideoView extends BaseVideoView implements ScaleGestureDetector.OnScaleGestureListener, IBrowserScaleControlListener, IBrowserScaleEventListener, View.OnTouchListener, IBrowserFlingControlListener {
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private volatile boolean H;
    private int I;
    private float J;
    private float K;
    private int L;
    private int M;
    private int N;
    private int P;
    private c Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private boolean W;

    /* renamed from: d, reason: collision with root package name */
    private MainBrowserPresenter f365141d;

    /* renamed from: e, reason: collision with root package name */
    private ScaleGestureDetector f365142e;

    /* renamed from: f, reason: collision with root package name */
    private GestureDetector f365143f;

    /* renamed from: h, reason: collision with root package name */
    private VelocityTracker f365144h;

    /* renamed from: i, reason: collision with root package name */
    private BrowserFlingAnimator f365145i;

    /* renamed from: m, reason: collision with root package name */
    private Matrix f365146m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!BrowserScaleVideoView.this.V) {
                return false;
            }
            if (BrowserScaleVideoView.this.H) {
                return true;
            }
            float x16 = motionEvent.getX() - BrowserScaleVideoView.this.S;
            float y16 = motionEvent.getY() - BrowserScaleVideoView.this.T;
            if (BrowserScaleVideoView.this.p() < BrowserScaleVideoView.this.E) {
                BrowserScaleVideoView browserScaleVideoView = BrowserScaleVideoView.this;
                browserScaleVideoView.C(browserScaleVideoView.E, x16, y16);
            } else {
                BrowserScaleVideoView browserScaleVideoView2 = BrowserScaleVideoView.this;
                browserScaleVideoView2.C(browserScaleVideoView2.C, x16, y16);
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (BrowserScaleVideoView.this.Q != null) {
                BrowserScaleVideoView.this.Q.onLongClickEvent();
            }
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (BrowserScaleVideoView.this.Q != null) {
                BrowserScaleVideoView.this.Q.onClickEvent();
                return true;
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    public BrowserScaleVideoView(Context context) {
        this(context, null);
    }

    private void B(int i3, int i16, int i17, int i18) {
        if (this.f365145i == null) {
            BrowserFlingAnimator browserFlingAnimator = new BrowserFlingAnimator(getContext());
            this.f365145i = browserFlingAnimator;
            browserFlingAnimator.setBrowserFlingControlListener(this);
        }
        this.f365145i.startFling(i3, i16, i17, i18, l(), m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(float f16, float f17, float f18) {
        BrowserScaleAnimator browserScaleAnimator = new BrowserScaleAnimator(f16, f17, f18);
        browserScaleAnimator.setBrowserScaleControlListener(this);
        browserScaleAnimator.setBrowserScaleEventListener(this);
        browserScaleAnimator.initAnimator();
        browserScaleAnimator.start();
    }

    private void j() {
        float f16;
        RectF n3 = n();
        float width = n3.width();
        int i3 = this.L;
        float f17 = 0.0f;
        if (width >= i3) {
            float f18 = n3.left;
            if (f18 > 0.0f) {
                f16 = -f18;
            } else {
                f16 = 0.0f;
            }
            float f19 = n3.right;
            if (f19 < i3) {
                f16 = i3 - f19;
            }
        } else {
            f16 = 0.0f;
        }
        float height = n3.height();
        int i16 = this.M;
        if (height >= i16) {
            float f26 = n3.top;
            if (f26 > 0.0f) {
                f17 = -f26;
            }
            float f27 = n3.bottom;
            if (f27 < i16) {
                f17 = i16 - f27;
            }
        }
        float width2 = n3.width();
        int i17 = this.L;
        if (width2 < i17) {
            f16 = ((i17 / 2.0f) - n3.right) + (n3.width() / 2.0f);
        }
        float height2 = n3.height();
        int i18 = this.M;
        if (height2 < i18) {
            f17 = ((i18 / 2.0f) - n3.bottom) + (n3.height() / 2.0f);
        }
        this.f365146m.postTranslate(f16, f17);
    }

    private void k() {
        if (!this.H) {
            float p16 = p();
            float f16 = this.C;
            if (p16 < f16) {
                C(f16, this.N / 2, this.P / 2);
            }
            float p17 = p();
            float f17 = this.D;
            if (p17 > f17) {
                C(f17, this.N / 2, this.P / 2);
            }
        }
    }

    private boolean l() {
        MainBrowserPresenter mainBrowserPresenter = this.f365141d;
        if (mainBrowserPresenter != null && mainBrowserPresenter.enableScrollLeft()) {
            return true;
        }
        return false;
    }

    private boolean m() {
        MainBrowserPresenter mainBrowserPresenter = this.f365141d;
        if (mainBrowserPresenter != null && mainBrowserPresenter.enableScrollRight()) {
            return true;
        }
        return false;
    }

    private RectF n() {
        Matrix matrix = this.f365146m;
        RectF rectF = new RectF();
        if (matrix != null) {
            rectF.set(0.0f, 0.0f, this.N, this.P);
            matrix.mapRect(rectF);
        }
        float f16 = rectF.left;
        int i3 = this.S;
        rectF.left = f16 + i3;
        float f17 = rectF.top;
        int i16 = this.T;
        rectF.top = f17 + i16;
        rectF.right += i3;
        rectF.bottom += i16;
        return rectF;
    }

    private View o() {
        KeyEvent.Callback videoView = this.mVPProxy.getVideoView();
        if (videoView instanceof SPlayerVideoView) {
            ((SPlayerVideoView) videoView).setClipChildren(false);
            return ((ISPlayerVideoView) videoView).getRenderView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        float[] fArr = new float[9];
        Matrix matrix = this.f365146m;
        if (matrix != null) {
            matrix.getValues(fArr);
            return Math.abs(fArr[0]);
        }
        return this.C;
    }

    private void q(MotionEvent motionEvent) {
        this.I = 0;
        k();
        if (x() && p() == this.C) {
            A();
        } else {
            VelocityTracker velocityTracker = this.f365144h;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                this.f365144h.computeCurrentVelocity(1000);
                B(this.L, this.M, (int) (-this.f365144h.getXVelocity()), (int) (-this.f365144h.getYVelocity()));
            }
        }
        VelocityTracker velocityTracker2 = this.f365144h;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.f365144h = null;
        }
    }

    private void r(MotionEvent motionEvent, RectF rectF) {
        VelocityTracker obtain = VelocityTracker.obtain();
        this.f365144h = obtain;
        if (obtain != null) {
            obtain.addMovement(motionEvent);
        }
        BrowserFlingAnimator browserFlingAnimator = this.f365145i;
        if (browserFlingAnimator != null) {
            browserFlingAnimator.cancelFling();
            this.f365145i = null;
        }
        if (rectF.width() > this.L || rectF.height() > this.M) {
            z(true);
        }
    }

    private boolean s(RectF rectF, float f16) {
        if (p() == this.C) {
            if ((f16 > 0.0f && l()) || (f16 < 0.0f && m())) {
                z(false);
                return true;
            }
        } else if (rectF.width() > this.L || rectF.height() > this.M) {
            z(true);
        }
        return false;
    }

    private float t(RectF rectF, float f16) {
        if (rectF.left > 0.0f) {
            if (l()) {
                if (Math.abs(rectF.left) > this.R) {
                    z(false);
                    y(true);
                } else {
                    return f16;
                }
            } else {
                z(true);
                if (Math.abs(rectF.left) <= this.L / 4.0f) {
                    return f16;
                }
            }
            return 0.0f;
        }
        return f16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0076, code lost:
    
        if (java.lang.Math.abs(r8.L - r13.right) > (r8.L / 4.0f)) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean u(MotionEvent motionEvent, float f16, float f17, int i3, RectF rectF) {
        float f18 = f16 - this.J;
        float f19 = f17 - this.K;
        if (s(rectF, f18)) {
            return true;
        }
        VelocityTracker velocityTracker = this.f365144h;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        float f26 = 0.0f;
        if (rectF.width() < this.L && rectF.height() < this.M) {
            f18 = 0.0f;
            f19 = 0.0f;
        }
        if (f18 > 0.0f) {
            f18 = t(rectF, f18);
        } else if (rectF.right < this.L) {
            if (m()) {
                if (Math.abs(this.L - rectF.right) > this.R) {
                    z(false);
                    y(true);
                    f18 = 0.0f;
                }
            } else {
                z(true);
            }
        }
        if (p() != this.C) {
            if (f19 > 0.0f) {
                float f27 = rectF.top;
                if (f27 > 0.0f && Math.abs(f27) > this.L / 4.0f) {
                    y(true);
                }
                f26 = f19;
            } else {
                float f28 = rectF.bottom;
                int i16 = this.M;
                if (f28 < i16 && Math.abs(i16 - f28) > this.L / 4.0f) {
                    y(true);
                }
                f26 = f19;
            }
        }
        if (v(i3, rectF, f18, f26)) {
            return true;
        }
        this.J = f16;
        this.K = f17;
        return false;
    }

    private boolean v(int i3, RectF rectF, float f16, float f17) {
        Matrix matrix = this.f365146m;
        if (matrix != null) {
            matrix.postTranslate(f16, f17);
            setVideoViewRenderMatrix(this.f365146m);
            return false;
        }
        return false;
    }

    private void w() {
        this.R = ScreenUtils.dip2px(getContext(), 80.0f);
        this.f365142e = new ScaleGestureDetector(getContext(), this);
        this.f365146m = new Matrix();
        setOnTouchListener(this);
        ImageView coverImage = getCoverImage();
        if (coverImage != null) {
            coverImage.setOnTouchListener(this);
        }
        this.f365143f = new GestureDetector(getContext(), new a());
    }

    private boolean x() {
        RectF n3 = n();
        float f16 = n3.left;
        int i3 = this.S;
        if (f16 <= i3 && n3.right + i3 >= this.L) {
            float f17 = n3.top;
            int i16 = this.T;
            if (f17 <= i16 && n3.bottom + i16 >= this.M) {
                return false;
            }
        }
        return true;
    }

    private void y(boolean z16) {
        MainBrowserPresenter mainBrowserPresenter = this.f365141d;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.requestDisallowInterceptDragEvent(z16);
        }
    }

    private void z(boolean z16) {
        MainBrowserPresenter mainBrowserPresenter = this.f365141d;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.requestDisallowInterceptTouchEvent(z16);
        }
    }

    public void A() {
        Matrix matrix = new Matrix();
        this.f365146m = matrix;
        setVideoViewRenderMatrix(matrix);
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserFlingControlListener
    public RectF getCurrentMatrixRectF() {
        return n();
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleControlListener
    public float getCurrentScale() {
        return p();
    }

    @Override // com.tencent.mobileqq.videoplatform.view.BaseVideoView, com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback
    public void onFirstFrameRendered(long j3) {
        super.onFirstFrameRendered(j3);
        this.U = true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (!this.V) {
            return false;
        }
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float p16 = p();
        if ((scaleFactor > 1.0f && p16 * scaleFactor < this.G) || (scaleFactor < 1.0f && p16 * scaleFactor > this.F)) {
            float f16 = p16 * scaleFactor;
            float f17 = this.G;
            if (f16 > f17) {
                scaleFactor = f17 / p16;
            }
            float f18 = p16 * scaleFactor;
            float f19 = this.F;
            if (f18 < f19) {
                scaleFactor = f19 / p16;
            }
            this.f365146m.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX() - this.S, scaleGestureDetector.getFocusY() - this.T);
            j();
            setVideoViewRenderMatrix(this.f365146m);
            return true;
        }
        return true;
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleEventListener
    public void onScaleAnimationCancel() {
        this.H = false;
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleEventListener
    public void onScaleAnimationEnd() {
        this.H = false;
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleEventListener
    public void onScaleAnimationStart() {
        this.H = true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        MainBrowserPresenter mainBrowserPresenter = this.f365141d;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onScaleBegin();
            return true;
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        MainBrowserPresenter mainBrowserPresenter = this.f365141d;
        if (mainBrowserPresenter != null) {
            mainBrowserPresenter.onScaleEnd();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
    
        if (r10 != 3) goto L37;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.V || !this.U) {
            return false;
        }
        if (this.L <= 0 || this.M <= 0) {
            this.L = getMeasuredWidth();
            this.M = getMeasuredHeight();
        }
        View o16 = o();
        if (o16 != null) {
            this.N = o16.getMeasuredWidth();
            this.P = o16.getMeasuredHeight();
        }
        this.S = (this.L - this.N) / 2;
        this.T = (this.M - this.P) / 2;
        if (this.f365143f.onTouchEvent(motionEvent)) {
            return true;
        }
        this.f365142e.onTouchEvent(motionEvent);
        int pointerCount = motionEvent.getPointerCount();
        float f16 = 0.0f;
        float f17 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            f16 += motionEvent.getX(i3);
            f17 += motionEvent.getY(i3);
        }
        float f18 = pointerCount;
        float f19 = f16 / f18;
        float f26 = f17 / f18;
        if (this.I != pointerCount) {
            this.J = f19;
            this.K = f26;
        }
        this.I = pointerCount;
        RectF n3 = n();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (u(motionEvent, f19, f26, pointerCount, n3)) {
                        return false;
                    }
                }
            }
            q(motionEvent);
        } else {
            r(motionEvent, n3);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.videoplatform.view.BaseVideoView, com.tencent.mobileqq.videoplatform.api.IBaseVideoView
    public void releasePlayer(boolean z16) {
        this.U = false;
        setCoverVisible();
        super.releasePlayer(z16);
    }

    @Override // com.tencent.mobileqq.videoplatform.view.BaseVideoView
    public void setCoverVisible() {
        View o16;
        if (this.V && this.U) {
            if (!isPlaying() && (o16 = o()) != null) {
                o16.invalidate();
                return;
            }
            return;
        }
        super.setCoverVisible();
    }

    public void setMainBrowserPresenter(MainBrowserPresenter mainBrowserPresenter) {
        this.f365141d = mainBrowserPresenter;
    }

    public void setOnItemEventListener(c cVar) {
        this.Q = cVar;
    }

    public void setVideoGestureScaleEnable(boolean z16) {
        this.V = z16;
        if (z16 && !this.W) {
            this.W = true;
            w();
        }
    }

    public void setVideoViewRenderMatrix(Matrix matrix) {
        View o16 = o();
        if (o16 instanceof TextureView) {
            ((TextureView) o16).setTransform(matrix);
            if (!isPlaying()) {
                o16.invalidate();
                return;
            }
            return;
        }
        QLog.e("BrowserScaleVideoView", 1, "setVideoViewRenderMatrix failed, renderView is not TextureView!");
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserFlingControlListener
    public void startFling(float f16, float f17) {
        this.f365146m.postTranslate(f16, f17);
        setVideoViewRenderMatrix(this.f365146m);
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleControlListener
    public void startScale(float f16, float f17, float f18, float f19) {
        Matrix matrix = this.f365146m;
        if (matrix != null) {
            matrix.postScale(f16, f17, f18, f19);
            j();
            setVideoViewRenderMatrix(this.f365146m);
        }
    }

    public BrowserScaleVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = 1.0f;
        this.D = 4.0f;
        this.E = 2.0f;
        this.F = 0.6f;
        this.G = 5.0f;
        this.V = false;
    }

    @Override // com.tencent.richmediabrowser.listener.IBrowserScaleEventListener
    public void onScaleAnimationRepeat() {
    }
}
