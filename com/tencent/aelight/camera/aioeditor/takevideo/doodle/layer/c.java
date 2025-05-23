package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleTextureView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScaleGestureDetector;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c extends tr.a {
    public int K;
    public final com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.d L;
    private boolean M;
    private Matrix N;
    private float[] P;
    private ScaleGestureDetector Q;
    private int R;
    private int S;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(byte[] bArr, int i3, int i16);

        void b(Bitmap bitmap, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    private class b extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        b() {
        }

        @Override // com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener, com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            EditPicRawImage f06 = ((tr.a) c.this).f437143e.K.f0();
            if (f06 != null) {
                f06.t0(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            }
            return f06 != null;
        }

        @Override // com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener, com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            EditPicRawImage f06 = ((tr.a) c.this).f437143e.K.f0();
            if (f06 != null) {
                f06.u0(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            }
            return f06 != null;
        }

        @Override // com.tencent.widget.ScaleGestureDetector.SimpleOnScaleGestureListener, com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            EditPicRawImage f06 = ((tr.a) c.this).f437143e.K.f0();
            if (f06 != null) {
                f06.v0();
            }
        }
    }

    public c(DoodleView doodleView) {
        super(doodleView);
        this.K = 1;
        this.M = false;
        this.N = new Matrix();
        this.P = new float[2];
        this.R = -1;
        this.S = 1;
        this.L = new com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.d(this.f437142d);
        this.Q = new ScaleGestureDetector(this.f437142d, new b());
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
        boolean R = R(obtain);
        obtain.recycle();
        return R;
    }

    private boolean G(MotionEvent motionEvent) {
        return this.Q.onTouchEvent(motionEvent);
    }

    private boolean R(MotionEvent motionEvent) {
        int i3 = this.K;
        if (i3 == 5) {
            return this.L.x(102, motionEvent);
        }
        if (i3 == 1) {
            return this.L.x(101, motionEvent);
        }
        if (i3 == 3) {
            return this.L.x(103, motionEvent);
        }
        if (i3 == 4) {
            return this.L.x(104, motionEvent);
        }
        if (i3 == 6) {
            return this.L.x(105, motionEvent);
        }
        if (i3 == 2) {
            return this.L.x(111, motionEvent);
        }
        return false;
    }

    private void S() {
        int i3 = this.K;
        if (i3 == 1) {
            this.L.G(101);
        } else if (i3 == 2) {
            this.L.i().e();
        } else if (i3 == 4) {
            this.L.G(104);
        }
    }

    @Override // tr.a
    public void A(int i3, int i16) {
        super.A(i3, i16);
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) this.L.l(103);
        if (hVar != null) {
            hVar.s(i3, i16);
        }
    }

    public int H() {
        int[] k3 = this.L.k();
        return k3[0] + k3[1];
    }

    public com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.e I(int i3) {
        return this.L.l(i3);
    }

    public Bitmap J() {
        return ((com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) this.L.l(103)).f68375w;
    }

    public byte[] K() {
        return ((com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) this.L.l(103)).f68353a;
    }

    public void L() {
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) this.L.l(103);
        if (hVar != null) {
            hVar.h(this.f437143e.K);
        }
    }

    public void M(DoodleTextureView doodleTextureView) {
        if (doodleTextureView.getVisibility() == 0) {
            doodleTextureView.setOpController(this.L);
        }
    }

    public boolean N() {
        int i3 = this.K;
        return i3 == 3 || i3 == 4 || i3 == 6;
    }

    public boolean O() {
        return this.K == 1;
    }

    public boolean P() {
        return this.M;
    }

    public boolean Q() {
        return false;
    }

    public void T(Canvas canvas) {
        this.L.H(canvas, this.H);
    }

    public void U(boolean z16) {
        ms.a.f("LineLayer", "setIsPassiveActivation: " + z16);
        this.M = z16;
    }

    public void V(a aVar) {
        Bitmap g06 = this.f437143e.K.g0();
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) this.L.l(103);
        if (hVar != null) {
            hVar.g(aVar, this.H, g06, this.f437145h);
        }
    }

    public void X(AppInterface appInterface, int i3, int i16) {
        hd0.c.a("LineLayer", "switchImageMode.");
        this.K = 5;
        this.L.f(appInterface, i16);
    }

    public void Y() {
        hd0.c.a("LineLayer", "switchMosaicMode.");
        if (this.f437143e.f68239m.r()) {
            W(4);
        } else {
            W(6);
        }
    }

    public void Z() {
        hd0.c.a("LineLayer", "switchNormalMode.");
        W(1);
    }

    @Override // tr.d
    public boolean a(MotionEvent motionEvent) {
        return false;
    }

    public void a0() {
        ((com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) this.L.l(103)).l();
    }

    @Override // tr.d
    public void b(Canvas canvas) {
        v(canvas, this.H);
    }

    public void b0() {
        if (this.L.y()) {
            super.n();
        }
    }

    @Override // tr.d
    public void clear() {
        this.L.r();
        hd0.c.a("LineLayer", "clear over.");
    }

    @Override // tr.a
    public String h() {
        return "LineLayer";
    }

    @Override // tr.a
    public int i() {
        return -100;
    }

    @Override // tr.d
    public boolean isEmpty() {
        return this.L.q();
    }

    @Override // tr.a
    public boolean m(long j3) {
        return true;
    }

    @Override // tr.a
    public void o() {
        super.o();
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.d dVar = this.L;
        if (dVar != null) {
            dVar.t();
        }
    }

    @Override // tr.a
    protected void p(Canvas canvas) {
        canvas.save();
        canvas.concat(this.J);
        canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        this.L.u(canvas, this.H);
        canvas.restore();
        canvas.restore();
        S();
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
                    ms.a.f("LineLayer", "recognize this gesture as SCALE");
                    this.S = 3;
                    F(obtain);
                } else if (!z17) {
                    ms.a.f("LineLayer", "recognize this gesture as DRAW");
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
    public void v(Canvas canvas, float f16) {
        this.L.v(canvas, f16);
        if (this.L.p()) {
            Bitmap bitmap = this.L.f68327g;
            if (bitmap != null) {
                PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
                Paint paint = new Paint(1);
                paint.setXfermode(porterDuffXfermode);
                canvas.save();
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                canvas.restore();
                this.L.E();
            } else if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "imgDoodle is null");
            }
            this.L.g();
        }
    }

    @Override // tr.a
    public void x(Matrix matrix) {
        super.x(matrix);
        this.J.invert(this.N);
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.d dVar = this.L;
        if (dVar != null) {
            dVar.L(this.J);
        }
    }

    public void W(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            this.K = i3;
            return;
        }
        if (i3 == 4) {
            this.K = 4;
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) this.L.l(103);
            if (hVar != null) {
                hVar.p(104);
                hVar.i();
                return;
            }
            return;
        }
        if (i3 != 6) {
            ms.a.c("LineLayer", "setMode---invalid mode: " + i3);
            return;
        }
        this.K = 6;
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h hVar2 = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.h) this.L.l(103);
        if (hVar2 != null) {
            hVar2.p(105);
            DoodleView doodleView = this.f437143e;
            hVar2.j(doodleView.f68236f, doodleView.f68237h);
        }
    }
}
