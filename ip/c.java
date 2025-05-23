package ip;

import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected b f408130a;

    /* renamed from: b, reason: collision with root package name */
    protected int f408131b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f408132c = false;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface a {
    }

    public c(b bVar) {
        this.f408130a = bVar;
    }

    public abstract int a(MotionEvent motionEvent);

    public boolean b(MotionEvent motionEvent) {
        if (this.f408132c) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            this.f408132c = false;
        }
        int a16 = a(motionEvent);
        if (a16 == 0) {
            return false;
        }
        if (a16 == 1) {
            this.f408132c = true;
            return false;
        }
        if (a16 == 2) {
            return this.f408130a.c(this.f408131b, motionEvent.getX(), motionEvent.getY());
        }
        if (a16 == 3) {
            return true;
        }
        if (a16 == 4) {
            return false;
        }
        if (a16 == 5) {
            return true;
        }
        this.f408132c = true;
        return false;
    }

    public void c() {
        this.f408132c = true;
    }

    public void d(a aVar) {
    }
}
