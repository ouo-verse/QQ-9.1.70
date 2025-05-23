package ip;

import android.view.MotionEvent;
import com.qzone.proxy.feedcomponent.text.TouchBehaviorListener;
import ip.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static int f408127c = 400;

    /* renamed from: a, reason: collision with root package name */
    private TouchBehaviorListener[] f408128a = new TouchBehaviorListener[8];

    /* renamed from: b, reason: collision with root package name */
    private c[] f408129b = new c[8];

    public boolean b(MotionEvent motionEvent) {
        boolean z16 = false;
        for (c cVar : this.f408129b) {
            if (cVar != null && cVar.b(motionEvent)) {
                z16 = true;
            }
        }
        return z16;
    }

    public boolean d(int i3, float f16, float f17, int i16) {
        TouchBehaviorListener touchBehaviorListener = this.f408128a[i3];
        if (touchBehaviorListener != null) {
            return touchBehaviorListener.onInvoke(i3, f16, f17, i16);
        }
        return false;
    }

    public void e(int i3) {
        c cVar = this.f408129b[i3];
        if (cVar != null) {
            cVar.c();
        }
    }

    public void g(int i3, TouchBehaviorListener touchBehaviorListener, c.a aVar) {
        this.f408128a[i3] = touchBehaviorListener;
        if (touchBehaviorListener == null) {
            this.f408129b[i3] = null;
        } else {
            c[] cVarArr = this.f408129b;
            if (cVarArr[i3] == null) {
                cVarArr[i3] = a(i3);
            }
        }
        c cVar = this.f408129b[i3];
        if (cVar == null || aVar == null) {
            return;
        }
        cVar.d(aVar);
    }

    public boolean c(int i3, float f16, float f17) {
        return d(i3, f16, f17, -1);
    }

    public void f(int i3, TouchBehaviorListener touchBehaviorListener) {
        g(i3, touchBehaviorListener, null);
    }

    private c a(int i3) {
        if (i3 != 0) {
            return null;
        }
        return new a(this);
    }
}
