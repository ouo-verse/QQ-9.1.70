package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import xr.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CropNewView extends View implements Runnable, ScaleGestureDetector.OnScaleGestureListener, ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    private boolean C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private yr.a f68133d;

    /* renamed from: e, reason: collision with root package name */
    private GestureDetector f68134e;

    /* renamed from: f, reason: collision with root package name */
    private ScaleGestureDetector f68135f;

    /* renamed from: h, reason: collision with root package name */
    private c f68136h;

    /* renamed from: i, reason: collision with root package name */
    private int f68137i;

    /* renamed from: m, reason: collision with root package name */
    private a f68138m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void T();

        void c(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return CropNewView.this.m(f16, f17);
        }
    }

    public CropNewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void g(Context context) {
        this.f68134e = new GestureDetector(context, new b());
        this.f68135f = new ScaleGestureDetector(context, this);
    }

    private void i(Canvas canvas, boolean z16) {
        canvas.save();
        RectF b16 = this.f68133d.b();
        canvas.rotate(this.f68133d.d(), b16.centerX(), b16.centerY());
        this.f68133d.j(canvas);
        this.f68133d.k(canvas);
        canvas.restore();
        if (z16) {
            canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            this.f68133d.i(canvas, getScrollX(), getScrollY());
            canvas.restore();
        }
    }

    private void j() {
        invalidate();
        u();
        xr.b f16 = this.f68133d.f(getScrollX(), getScrollY());
        xr.b c16 = this.f68133d.c(getScrollX(), getScrollY());
        if (this.C) {
            setResetHome(false);
            c16.f448421a = 0.0f;
            c16.f448422b = 0.0f;
        }
        t(f16, c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(float f16, float f17) {
        xr.b v3 = this.f68133d.v(getScrollX(), getScrollY(), -f16, -f17);
        if (v3 != null) {
            a aVar = this.f68138m;
            if (aVar != null && !this.D) {
                aVar.T();
                setCrop(true);
            }
            v(v3);
            return true;
        }
        return n(getScrollX() + Math.round(f16), getScrollY() + Math.round(f17));
    }

    private boolean n(int i3, int i16) {
        if (getScrollX() == i3 && getScrollY() == i16) {
            return false;
        }
        scrollTo(i3, i16);
        return true;
    }

    private boolean q(MotionEvent motionEvent) {
        return this.f68134e.onTouchEvent(motionEvent);
    }

    private void t(xr.b bVar, xr.b bVar2) {
        if (this.f68136h == null) {
            c cVar = new c();
            this.f68136h = cVar;
            cVar.addUpdateListener(this);
            this.f68136h.addListener(this);
        }
        this.f68136h.b(bVar, bVar2);
        this.f68136h.start();
    }

    private void u() {
        c cVar = this.f68136h;
        if (cVar != null) {
            cVar.cancel();
        }
    }

    private void v(xr.b bVar) {
        this.f68133d.H(bVar.f448423c);
        this.f68133d.G(bVar.f448424d);
        if (n(Math.round(bVar.f448421a), Math.round(bVar.f448422b))) {
            return;
        }
        invalidate();
    }

    public boolean e() {
        this.f68133d.a(getScrollX(), getScrollY());
        this.f68133d.F(true);
        setResetHome(true);
        j();
        return true;
    }

    public void f() {
        if (h()) {
            return;
        }
        this.f68133d.B(-90);
        j();
    }

    boolean h() {
        c cVar = this.f68136h;
        return cVar != null && cVar.isRunning();
    }

    public void k() {
        this.f68133d.E();
        j();
    }

    public void l(int i3) {
        a aVar = this.f68138m;
        if (aVar != null) {
            aVar.c(i3);
        }
    }

    boolean o() {
        if (QLog.isColorLevel()) {
            QLog.i("CropNewView", 2, "onSteady: isHoming=" + h());
        }
        if (h()) {
            return false;
        }
        this.f68133d.w(getScrollX(), getScrollY());
        j();
        a aVar = this.f68138m;
        if (aVar == null) {
            return true;
        }
        aVar.T();
        return true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        if (QLog.isColorLevel()) {
            QLog.i("CropNewView", 2, "onAnimationCancel!");
        }
        this.f68133d.m(this.f68136h.a());
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z16) {
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z16) {
        onAnimationStart(animator);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f68133d.l(valueAnimator.getAnimatedFraction());
        v((xr.b) valueAnimator.getAnimatedValue());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16) {
            this.f68133d.z(i17 - i3, i18 - i16);
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        if (this.f68137i <= 1) {
            return false;
        }
        this.f68133d.s(scaleGestureDetector.getScaleFactor(), getScrollX() + scaleGestureDetector.getFocusX(), getScrollY() + scaleGestureDetector.getFocusY());
        invalidate();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        if (this.f68137i <= 1) {
            return false;
        }
        this.f68133d.t();
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f68133d.u();
        id0.b.f("0X800A9AB");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            removeCallbacks(this);
        } else if (actionMasked == 1 || actionMasked == 3) {
            postDelayed(this, 1000L);
        }
        return p(motionEvent);
    }

    boolean p(MotionEvent motionEvent) {
        if (h()) {
            return false;
        }
        this.f68137i = motionEvent.getPointerCount();
        boolean onTouchEvent = this.f68135f.onTouchEvent(motionEvent) | q(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f68133d.x(motionEvent.getX(), motionEvent.getY());
            l(1);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f68133d.y(getScrollX(), getScrollY());
            l(2);
            j();
        }
        return onTouchEvent;
    }

    public void r() {
        this.f68133d.A();
        j();
        setCrop(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (o()) {
            return;
        }
        postDelayed(this, 400L);
    }

    public Bitmap s() {
        float e16 = 1.0f / this.f68133d.e();
        RectF rectF = new RectF(this.f68133d.b());
        Matrix matrix = new Matrix();
        matrix.setRotate(this.f68133d.d(), rectF.centerX(), rectF.centerY());
        matrix.mapRect(rectF);
        matrix.setScale(e16, e16, rectF.left, rectF.top);
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        if (round <= 0 || round2 <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate(-rectF.left, -rectF.top);
        canvas.scale(e16, e16, rectF.left, rectF.top);
        i(canvas, false);
        return createBitmap;
    }

    public void setCrop(boolean z16) {
        this.D = z16;
    }

    public void setCropListener(a aVar) {
        this.f68138m = aVar;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f68133d.D(this);
        this.f68133d.C(bitmap);
        setResetHome(false);
        setCrop(false);
        invalidate();
    }

    public void setResetHome(boolean z16) {
        this.C = z16;
    }

    public void w() {
        this.f68133d.K();
        this.f68133d.F(true);
        setResetHome(true);
        j();
    }

    public CropNewView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f68133d = new yr.a();
        this.f68137i = 0;
        this.C = false;
        this.D = false;
        g(context);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (QLog.isColorLevel()) {
            QLog.i("CropNewView", 2, "onAnimationEnd!");
        }
        if (this.f68133d.n(getScrollX(), getScrollY(), this.f68136h.a())) {
            v(this.f68133d.a(getScrollX(), getScrollY()));
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (QLog.isColorLevel()) {
            QLog.i("CropNewView", 2, "onAnimationStart!");
        }
        this.f68133d.o(this.f68136h.a());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        i(canvas, true);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
