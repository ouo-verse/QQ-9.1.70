package dy0;

import android.graphics.Canvas;
import android.view.MotionEvent;
import dy0.c;

/* compiled from: P */
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private a f395198a;

    /* renamed from: b, reason: collision with root package name */
    private c f395199b;

    public d(a aVar, c cVar) {
        this.f395198a = aVar;
        this.f395199b = cVar;
    }

    public void a(Canvas canvas) {
        canvas.saveLayer(this.f395199b.f395195k, null, 31);
        this.f395198a.e(canvas);
        this.f395199b.d(canvas);
        canvas.restore();
    }

    public boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 && !this.f395199b.f395194j.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        if (action != 0 && action != 1) {
            if (action == 3) {
                this.f395198a.getView().setPressed(false);
                this.f395198a.getView().refreshDrawableState();
            }
        } else {
            this.f395198a.getView().refreshDrawableState();
        }
        return this.f395198a.superDispatchTouchEvent(motionEvent);
    }

    public void c(Canvas canvas) {
        if (this.f395199b.f395193i) {
            canvas.save();
            canvas.clipPath(this.f395199b.f395186b);
            this.f395198a.b(canvas);
            canvas.restore();
            return;
        }
        this.f395198a.b(canvas);
    }

    public void d() {
        this.f395198a.c();
        this.f395199b.b(this.f395198a.getView());
    }

    public void e() {
        c cVar = this.f395199b;
        if (cVar != null) {
            cVar.f(this.f395198a.getView());
        }
        this.f395198a.d();
    }

    public boolean f() {
        return this.f395199b.f395197m;
    }

    public void g(Canvas canvas) {
        canvas.saveLayer(this.f395199b.f395195k, null, 31);
        this.f395198a.superOnDraw(canvas);
        this.f395199b.d(canvas);
        canvas.restore();
    }

    public void h(int i3, int i16, int i17, int i18) {
        this.f395198a.a(i3, i16, i17, i18);
        this.f395199b.e(this.f395198a.getView(), i3, i16);
    }

    public void i(int i3) {
        float[] fArr = this.f395199b.f395185a;
        float f16 = i3;
        fArr[6] = f16;
        fArr[7] = f16;
        e();
    }

    public void j(int i3) {
        float[] fArr = this.f395199b.f395185a;
        float f16 = i3;
        fArr[4] = f16;
        fArr[5] = f16;
        e();
    }

    public void k(boolean z16) {
        c cVar = this.f395199b;
        if (cVar.f395197m != z16) {
            cVar.f395197m = z16;
            this.f395198a.getView().refreshDrawableState();
            this.f395199b.getClass();
        }
    }

    public void l(boolean z16) {
        this.f395199b.f395193i = z16;
        e();
    }

    public void m(c.a aVar) {
        this.f395199b.getClass();
    }

    public void n(int i3) {
        int i16 = 0;
        while (true) {
            float[] fArr = this.f395199b.f395185a;
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
        this.f395199b.f395188d = z16;
        e();
    }

    public void p(int i3) {
        this.f395199b.f395190f = i3;
        e();
    }

    public void q(int i3) {
        this.f395199b.f395192h = i3;
        e();
    }

    public void r(int i3) {
        float[] fArr = this.f395199b.f395185a;
        float f16 = i3;
        fArr[0] = f16;
        fArr[1] = f16;
        e();
    }

    public void s(int i3) {
        float[] fArr = this.f395199b.f395185a;
        float f16 = i3;
        fArr[2] = f16;
        fArr[3] = f16;
        e();
    }

    public void t() {
        k(!this.f395199b.f395197m);
    }
}
