package ao4;

import android.graphics.Canvas;
import android.view.MotionEvent;
import ao4.c;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private a f26612a;

    /* renamed from: b, reason: collision with root package name */
    private c f26613b;

    public d(a aVar, c cVar) {
        this.f26612a = aVar;
        this.f26613b = cVar;
    }

    public void a(Canvas canvas) {
        canvas.saveLayer(this.f26613b.f26609k, null, 31);
        this.f26612a.e(canvas);
        this.f26613b.d(canvas);
        canvas.restore();
    }

    public boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 && !this.f26613b.f26608j.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        if (action != 0 && action != 1) {
            if (action == 3) {
                this.f26612a.getView().setPressed(false);
                this.f26612a.getView().refreshDrawableState();
            }
        } else {
            this.f26612a.getView().refreshDrawableState();
        }
        return this.f26612a.superDispatchTouchEvent(motionEvent);
    }

    public void c(Canvas canvas) {
        if (this.f26613b.f26607i) {
            canvas.save();
            canvas.clipPath(this.f26613b.f26600b);
            this.f26612a.b(canvas);
            canvas.restore();
            return;
        }
        this.f26612a.b(canvas);
    }

    public void d() {
        this.f26612a.c();
        this.f26613b.b(this.f26612a.getView());
    }

    public void e() {
        c cVar = this.f26613b;
        if (cVar != null) {
            cVar.f(this.f26612a.getView());
        }
        this.f26612a.d();
    }

    public boolean f() {
        return this.f26613b.f26611m;
    }

    public void g(Canvas canvas) {
        canvas.saveLayer(this.f26613b.f26609k, null, 31);
        this.f26612a.superOnDraw(canvas);
        this.f26613b.d(canvas);
        canvas.restore();
    }

    public void h(int i3, int i16, int i17, int i18) {
        this.f26612a.a(i3, i16, i17, i18);
        this.f26613b.e(this.f26612a.getView(), i3, i16);
    }

    public void i(int i3) {
        float[] fArr = this.f26613b.f26599a;
        float f16 = i3;
        fArr[6] = f16;
        fArr[7] = f16;
        e();
    }

    public void j(int i3) {
        float[] fArr = this.f26613b.f26599a;
        float f16 = i3;
        fArr[4] = f16;
        fArr[5] = f16;
        e();
    }

    public void k(boolean z16) {
        c cVar = this.f26613b;
        if (cVar.f26611m != z16) {
            cVar.f26611m = z16;
            this.f26612a.getView().refreshDrawableState();
            this.f26613b.getClass();
        }
    }

    public void l(boolean z16) {
        this.f26613b.f26607i = z16;
        e();
    }

    public void m(c.a aVar) {
        this.f26613b.getClass();
    }

    public void n(int i3) {
        int i16 = 0;
        while (true) {
            float[] fArr = this.f26613b.f26599a;
            if (i16 < fArr.length) {
                fArr[i16] = i3;
                i16++;
            } else {
                e();
                return;
            }
        }
    }

    public void o(boolean z16) {
        this.f26613b.f26602d = z16;
        e();
    }

    public void p(int i3) {
        this.f26613b.f26604f = i3;
        e();
    }

    public void q(int i3) {
        this.f26613b.f26606h = i3;
        e();
    }

    public void r(int i3) {
        float[] fArr = this.f26613b.f26599a;
        float f16 = i3;
        fArr[0] = f16;
        fArr[1] = f16;
        e();
    }

    public void s(int i3) {
        float[] fArr = this.f26613b.f26599a;
        float f16 = i3;
        fArr[2] = f16;
        fArr[3] = f16;
        e();
    }

    public void t() {
        k(!this.f26613b.f26611m);
    }
}
