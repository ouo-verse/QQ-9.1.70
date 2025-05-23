package c.t.m.g;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class g0 extends h0 {
    public int a(Looper looper) {
        synchronized (this.f29719b) {
            if (this.f29718a) {
                return -1;
            }
            this.f29718a = true;
            if (c1.a()) {
                c1.a(a(), "startup()");
            }
            return b(looper);
        }
    }

    public abstract int b(Looper looper);
}
