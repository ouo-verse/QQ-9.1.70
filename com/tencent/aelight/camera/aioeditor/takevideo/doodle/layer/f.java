package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.StoryGuideLineView;
import com.tencent.qphone.base.util.QLog;
import tr.a;
import zr.c;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f extends tr.a implements Drawable.Callback {
    public static final String Q = "f";
    public c.a K;
    public zr.c L;
    public int M;
    public boolean N;
    public a P;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26);

        void c(c.a aVar);

        void d(c.a aVar, int i3, int i16, float f16, float f17);

        void e(c.a aVar);

        void f(c.a aVar, int i3, int i16);
    }

    public f(DoodleView doodleView) {
        super(doodleView);
        zr.c cVar = new zr.c();
        this.L = cVar;
        cVar.A(true);
        this.L.y(6.0f);
        this.L.z(0.2f);
    }

    private void C() {
        this.f437143e.F(false, 0.0f, 0.0f, 0.0f, null, false, 1);
    }

    private boolean E(float f16, float f17) {
        return this.L.s(this.K, f16, f17, true);
    }

    private void N(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (this.L.u(this.K, x16, y16)) {
            this.K.f453059o = 0;
        } else if (this.L.v(this.K, x16, y16)) {
            this.K.f453059o = 1;
        } else if (this.L.t(this.K, x16, y16)) {
            this.K.f453059o = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean D(MotionEvent motionEvent) {
        a.InterfaceC11305a interfaceC11305a = this.I;
        if (interfaceC11305a != null) {
            interfaceC11305a.a(this, motionEvent);
        }
        int y16 = (int) motionEvent.getY();
        int abs = Math.abs(y16 - this.M);
        int action = motionEvent.getAction() & 255;
        boolean z16 = false;
        if (action == 0) {
            this.M = y16;
            this.N = false;
            E(motionEvent.getX(0), motionEvent.getY(0));
            c.a aVar = this.K;
            if (aVar != null) {
                this.L.x(aVar);
            }
            if (this.K != null) {
                N(motionEvent);
            }
        } else {
            if (action == 1) {
                if (!this.N) {
                    H(motionEvent);
                }
                c.a aVar2 = this.K;
                if (aVar2 != null) {
                    aVar2.f453059o = -1;
                }
                this.L.w();
                this.L.e(motionEvent, true);
                if (z16) {
                    C();
                } else {
                    c.a aVar3 = this.K;
                    if ((aVar3 instanceof FaceLayer.b) || (aVar3 instanceof g.c)) {
                        I(aVar3);
                    }
                }
                return true;
            }
            if (action == 2 && abs > 10) {
                this.N = true;
            }
        }
        z16 = true;
        this.L.e(motionEvent, true);
        if (z16) {
        }
        return true;
    }

    public c.a F() {
        return this.K;
    }

    public boolean G() {
        return this.K != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(MotionEvent motionEvent) {
        c.a aVar;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (this.L.u(this.K, x16, y16)) {
            a aVar2 = this.P;
            if (aVar2 != null) {
                c.a aVar3 = this.K;
                if (aVar3 instanceof g.c) {
                    DynamicTextItem dynamicTextItem = ((g.c) aVar3).f68001z;
                    if (dynamicTextItem != null) {
                        aVar2.f(aVar3, dynamicTextItem.h(), 2);
                        return;
                    }
                    return;
                }
                aVar2.f(aVar3, 0, 0);
                return;
            }
            return;
        }
        if (this.L.v(this.K, x16, y16)) {
            a aVar4 = this.P;
            if (aVar4 != null) {
                aVar4.c(this.K);
                return;
            }
            return;
        }
        if (this.L.t(this.K, x16, y16)) {
            a aVar5 = this.P;
            if (aVar5 != null) {
                aVar5.e(this.K);
                return;
            }
            return;
        }
        if (!this.L.s(this.K, x16, y16, true) || this.P == null || (aVar = this.K) == null) {
            return;
        }
        if (aVar instanceof g.c) {
            DynamicTextItem dynamicTextItem2 = ((g.c) aVar).f68001z;
            if (dynamicTextItem2 != null) {
                if (dynamicTextItem2.F() && dynamicTextItem2.A()) {
                    int u16 = dynamicTextItem2.u(motionEvent, j(), f(), (g.c) this.K, this.L);
                    dynamicTextItem2.c(u16);
                    this.P.d(this.K, u16, 3, x16, y16);
                    return;
                }
                this.P.d(this.K, dynamicTextItem2.h(), 0, x16, y16);
                return;
            }
            return;
        }
        hd0.c.a(Q, "click the item:" + this.K);
        this.P.d(this.K, 0, 0, x16, y16);
    }

    public void L(c.a aVar) {
        this.K = aVar;
        if (aVar == null) {
            return;
        }
        g.L(true);
        c.a aVar2 = this.K;
        if (aVar2 instanceof g.c) {
            this.L.y(6.0f);
            this.L.z(0.2f);
        } else if ((aVar2 instanceof FaceLayer.b) || (aVar2 instanceof FaceLayer.a)) {
            this.L.y(18.0f);
            this.L.z(0.2f);
        }
    }

    public void M(a aVar) {
        this.P = aVar;
    }

    @Override // tr.d
    public boolean a(MotionEvent motionEvent) {
        if (this.L.s(this.K, motionEvent.getX(), motionEvent.getY(), true)) {
            if (QLog.isColorLevel()) {
                QLog.d(Q, 2, "accept inside x:" + motionEvent.getX() + " y:" + motionEvent.getY());
            }
            return true;
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.d(Q, 2, "accept outside x:" + motionEvent.getX() + " y:" + motionEvent.getY());
        return false;
    }

    @Override // tr.d
    public void b(Canvas canvas) {
        throw new IllegalStateException("TextFaceEditLayer should not save");
    }

    @Override // tr.a
    public String h() {
        return Q;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        n();
    }

    @Override // tr.d
    public boolean isEmpty() {
        return false;
    }

    @Override // tr.a
    public boolean m(long j3) {
        return true;
    }

    @Override // tr.a
    protected void p(Canvas canvas) {
        if (this.K == null) {
            return;
        }
        canvas.save();
        this.K.a(canvas);
        canvas.restore();
    }

    @Override // tr.a
    protected boolean q(MotionEvent motionEvent) {
        return false;
    }

    @Override // tr.a
    public void v(Canvas canvas, float f16) {
        throw new IllegalStateException("TextFaceEditLayer should not save");
    }

    public void J() {
        this.K = null;
        g.L(false);
        n();
    }

    @Override // tr.d
    public void clear() {
        this.K = null;
        this.L.w();
    }

    public void K(c.a aVar) {
        FaceLayer.b bVar;
        int i3;
        if (aVar == null) {
            return;
        }
        aVar.f453057m = true;
        c.a aVar2 = this.K;
        if (aVar2 != null) {
            aVar.f453065u.lockData(aVar2.f453065u.isDataLocked());
        }
        if ((aVar instanceof FaceLayer.b) && ((i3 = (bVar = (FaceLayer.b) aVar).K) == 1 || i3 == 3)) {
            bVar.f67963x.setCallback(this);
        }
        this.K = aVar;
    }

    private void I(c.a aVar) {
        if (aVar == null) {
            hd0.c.g(Q, "refreshLimitRegion currItem invalid");
            return;
        }
        boolean q16 = this.L.q(aVar, StoryGuideLineView.E, true);
        boolean q17 = this.L.q(aVar, StoryGuideLineView.F, false);
        boolean r16 = this.L.r(aVar, StoryGuideLineView.H, false);
        a aVar2 = this.P;
        if (aVar2 != null) {
            aVar2.a(q16, q17, false, r16, aVar.f453063s);
        }
        if (aVar.f453057m) {
            this.f437143e.F(aVar.f453063s, aVar.f453047c, aVar.f453048d, aVar.f453049e, aVar.f453045a, aVar.f453064t, 2);
        } else {
            this.f437143e.F(aVar.f453063s, aVar.f453047c, aVar.f453048d, aVar.f453049e, aVar.f453045a, aVar.f453064t, 1);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
    }
}
