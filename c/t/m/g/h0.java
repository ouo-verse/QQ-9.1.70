package c.t.m.g;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class h0 {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f29718a = false;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f29719b = new byte[0];

    public abstract String a();

    public boolean b() {
        boolean z16;
        synchronized (this.f29719b) {
            z16 = this.f29718a;
        }
        return z16;
    }

    public void c() {
        synchronized (this.f29719b) {
            if (!this.f29718a) {
                return;
            }
            if (c1.a()) {
                c1.a(a(), "shutdown()");
            }
            d();
            this.f29718a = false;
        }
    }

    public abstract void d();
}
