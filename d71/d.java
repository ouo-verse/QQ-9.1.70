package d71;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    AtomicInteger f393140a = new AtomicInteger(0);

    public boolean a() {
        if (this.f393140a.get() == 2) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f393140a.get() == 4) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f393140a.get() > 4) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f393140a.get() == 1) {
            return true;
        }
        return false;
    }

    public boolean e() {
        if (this.f393140a.get() == 5) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f393140a.get() > 1) {
            return true;
        }
        return false;
    }

    public void g(int i3) {
        this.f393140a.set(i3);
    }
}
