package nv;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends nv.a {

    /* renamed from: m, reason: collision with root package name */
    private static final PointF f421369m = new PointF();

    /* renamed from: h, reason: collision with root package name */
    private final a f421370h;

    /* renamed from: i, reason: collision with root package name */
    private PointF f421371i;

    /* renamed from: j, reason: collision with root package name */
    private PointF f421372j;

    /* renamed from: k, reason: collision with root package name */
    private PointF f421373k;

    /* renamed from: l, reason: collision with root package name */
    private PointF f421374l;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(b bVar);

        boolean b(b bVar);

        boolean c(b bVar);
    }

    public b(Context context, a aVar) {
        super(context);
        this.f421373k = new PointF();
        this.f421374l = new PointF();
        this.f421370h = aVar;
    }

    private PointF g(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float f16 = 0.0f;
        float f17 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            f16 += motionEvent.getX(i3);
            f17 += motionEvent.getY(i3);
        }
        float f18 = pointerCount;
        return new PointF(f16 / f18, f17 / f18);
    }

    @Override // nv.a
    protected void a(int i3, MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
            } else {
                f(motionEvent);
                if (this.f421366e / this.f421367f > 0.67f && this.f421370h.b(this) && (motionEvent2 = this.f421364c) != null) {
                    motionEvent2.recycle();
                    this.f421364c = MotionEvent.obtain(motionEvent);
                    return;
                }
                return;
            }
        }
        this.f421370h.a(this);
        e();
    }

    @Override // nv.a
    protected void b(int i3, MotionEvent motionEvent) {
        if (i3 != 0) {
            if (i3 == 2) {
                this.f421363b = this.f421370h.c(this);
            }
        } else {
            e();
            this.f421364c = MotionEvent.obtain(motionEvent);
            this.f421368g = 0L;
            f(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // nv.a
    public void f(MotionEvent motionEvent) {
        boolean z16;
        PointF pointF;
        super.f(motionEvent);
        MotionEvent motionEvent2 = this.f421364c;
        if (motionEvent != null && motionEvent2 != null) {
            this.f421371i = g(motionEvent);
            this.f421372j = g(motionEvent2);
            if (motionEvent2.getPointerCount() != motionEvent.getPointerCount()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                pointF = f421369m;
            } else {
                PointF pointF2 = this.f421371i;
                float f16 = pointF2.x;
                PointF pointF3 = this.f421372j;
                pointF = new PointF(f16 - pointF3.x, pointF2.y - pointF3.y);
            }
            this.f421374l = pointF;
            PointF pointF4 = this.f421373k;
            pointF4.x += pointF.x;
            pointF4.y += pointF.y;
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseGestureDetector", 2, "updateStateByEvent-->Curr Or Prev is null");
        }
    }

    public PointF h() {
        return this.f421374l;
    }

    public float i() {
        return this.f421373k.x;
    }

    public float j() {
        return this.f421373k.y;
    }
}
