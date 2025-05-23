package nv;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final Context f421362a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f421363b;

    /* renamed from: c, reason: collision with root package name */
    protected MotionEvent f421364c;

    /* renamed from: d, reason: collision with root package name */
    protected MotionEvent f421365d;

    /* renamed from: e, reason: collision with root package name */
    protected float f421366e;

    /* renamed from: f, reason: collision with root package name */
    protected float f421367f;

    /* renamed from: g, reason: collision with root package name */
    protected long f421368g;

    public a(Context context) {
        this.f421362a = context;
    }

    protected abstract void a(int i3, MotionEvent motionEvent);

    protected abstract void b(int i3, MotionEvent motionEvent);

    public boolean c() {
        return this.f421363b;
    }

    public boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (!this.f421363b) {
            b(action, motionEvent);
            return true;
        }
        a(action, motionEvent);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        MotionEvent motionEvent = this.f421364c;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f421364c = null;
        }
        MotionEvent motionEvent2 = this.f421365d;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f421365d = null;
        }
        this.f421363b = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f421364c;
        if (motionEvent != null && motionEvent2 != null) {
            MotionEvent motionEvent3 = this.f421365d;
            if (motionEvent3 != null) {
                motionEvent3.recycle();
                this.f421365d = null;
            }
            this.f421365d = MotionEvent.obtain(motionEvent);
            this.f421368g = motionEvent.getEventTime() - motionEvent2.getEventTime();
            this.f421366e = motionEvent.getPressure(motionEvent.getActionIndex());
            this.f421367f = motionEvent2.getPressure(motionEvent2.getActionIndex());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("BaseGestureDetector", 2, "updateStateByEvent-->Curr Or Prev is null");
        }
    }
}
