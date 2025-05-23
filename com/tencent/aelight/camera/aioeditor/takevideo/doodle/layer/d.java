package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.ShapeOperator;
import com.tencent.widget.ScaleGestureDetector;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends tr.a {
    public int K;
    protected ShapeOperator L;
    private boolean M;
    private Matrix N;
    private float[] P;
    protected ScaleGestureDetector Q;
    private int R;
    private int S;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
        }

        @Override // com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener, com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            EditPicRawImage f06 = ((tr.a) d.this).f437143e.K.f0();
            if (f06 != null) {
                f06.t0(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            }
            return f06 != null;
        }

        @Override // com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener, com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            EditPicRawImage f06 = ((tr.a) d.this).f437143e.K.f0();
            if (f06 != null) {
                f06.u0(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            }
            return f06 != null;
        }

        @Override // com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener, com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            EditPicRawImage f06 = ((tr.a) d.this).f437143e.K.f0();
            if (f06 != null) {
                f06.v0();
            }
        }
    }

    public d(DoodleView doodleView) {
        super(doodleView);
        this.K = 9;
        this.M = false;
        this.N = new Matrix();
        this.P = new float[2];
        this.R = -1;
        this.S = 1;
        l();
    }

    private boolean F(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.R = motionEvent.getPointerId(0);
        }
        if (this.R != motionEvent.getPointerId(motionEvent.getActionIndex())) {
            return false;
        }
        if (actionMasked == 0) {
            id0.b.i("0X80076BE");
            id0.b.f("0X80075CB");
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.P[0] = motionEvent.getX();
        this.P[1] = motionEvent.getY();
        this.N.mapPoints(this.P);
        float[] fArr = this.P;
        obtain.setLocation(fArr[0], fArr[1]);
        if (actionMasked == 6 && this.R == motionEvent.getPointerId(motionEvent.getActionIndex())) {
            obtain.setAction(1);
        }
        boolean onTouchEvent = this.L.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent;
    }

    private boolean G(MotionEvent motionEvent) {
        return this.Q.onTouchEvent(motionEvent);
    }

    @Override // tr.a
    public void A(int i3, int i16) {
        super.A(i3, i16);
        this.L.D(i3, i16);
    }

    public int H() {
        return this.L.t();
    }

    public ShapeOperator I() {
        return this.L;
    }

    public boolean J() {
        return this.M;
    }

    public boolean K() {
        return this.L.s() != null;
    }

    public void L(boolean z16) {
        ms.a.f("ShapeLayer", "setIsPassiveActivation: " + z16);
        this.M = z16;
    }

    @Override // tr.d
    public boolean a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.P[0] = motionEvent.getX();
        this.P[1] = motionEvent.getY();
        this.N.mapPoints(this.P);
        float[] fArr = this.P;
        obtain.setLocation(fArr[0], fArr[1]);
        boolean F = this.L.F(obtain);
        obtain.recycle();
        ms.a.f("ShapeLayer", "accept touch event: " + F);
        return F;
    }

    @Override // tr.d
    public void b(Canvas canvas) {
        v(canvas, this.H);
    }

    @Override // tr.d
    public void clear() {
        this.L.h();
        hd0.c.a("ShapeLayer", "clear over.");
    }

    @Override // tr.a
    public String h() {
        return "ShapeLayer";
    }

    @Override // tr.d
    public boolean isEmpty() {
        return this.L.v();
    }

    protected void l() {
        this.L = new ShapeOperator(this.f437142d);
        this.Q = new ScaleGestureDetector(this.f437142d, new a());
    }

    @Override // tr.a
    public boolean m(long j3) {
        return true;
    }

    @Override // tr.a
    protected void p(Canvas canvas) {
        canvas.save();
        canvas.concat(this.J);
        this.L.m(canvas);
        canvas.restore();
    }

    @Override // tr.a
    public boolean q(MotionEvent motionEvent) {
        DoodleView doodleView = this.f437143e;
        if (doodleView != null && doodleView.K.W0()) {
            int actionMasked = motionEvent.getActionMasked();
            boolean z16 = false;
            if (actionMasked == 0) {
                this.S = 1;
                return F(motionEvent) || G(motionEvent);
            }
            if (this.S == 1) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                boolean z17 = motionEvent.getEventTime() - motionEvent.getDownTime() <= 100;
                if (actionMasked == 5 && z17) {
                    ms.a.f("ShapeLayer", "recognize this gesture as SCALE");
                    this.S = 3;
                    F(obtain);
                } else if (!z17) {
                    ms.a.f("ShapeLayer", "recognize this gesture as DRAW");
                    this.S = 2;
                    G(obtain);
                }
                obtain.recycle();
            }
            int i3 = this.S;
            if (i3 == 3) {
                z16 = G(motionEvent);
            } else if (i3 == 2) {
                z16 = F(motionEvent);
            } else if (i3 == 1) {
                boolean F = F(motionEvent);
                boolean G = G(motionEvent);
                if (F || G) {
                    z16 = true;
                }
            }
            if (actionMasked == 1) {
                this.S = 1;
            }
            return z16;
        }
        return F(motionEvent);
    }

    @Override // tr.a
    public void r() {
        super.r();
        if (J() || !this.L.i()) {
            return;
        }
        this.f437143e.invalidate();
    }

    @Override // tr.a
    public void v(Canvas canvas, float f16) {
        canvas.save();
        canvas.scale(f16, f16);
        this.L.w(canvas);
        canvas.restore();
    }

    @Override // tr.a
    public void x(Matrix matrix) {
        super.x(matrix);
        this.J.invert(this.N);
    }

    public void M(int i3) {
        switch (i3) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                this.K = i3;
                return;
            default:
                ms.a.c("ShapeLayer", "setMode---invalid mode: " + i3);
                return;
        }
    }
}
