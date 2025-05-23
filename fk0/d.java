package fk0;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static volatile d f399707c;

    /* renamed from: a, reason: collision with root package name */
    private dk0.d f399708a;

    /* renamed from: b, reason: collision with root package name */
    private dk0.c f399709b;

    d() {
    }

    public static d c() {
        if (f399707c == null) {
            synchronized (d.class) {
                if (f399707c == null) {
                    f399707c = new d();
                }
            }
        }
        return f399707c;
    }

    public dk0.d a() {
        return this.f399708a;
    }

    public dk0.c b() {
        return this.f399709b;
    }

    public void d(Runnable runnable) {
        dk0.d dVar = this.f399708a;
        if (dVar != null) {
            dVar.c(runnable);
        }
    }

    public void e(Runnable runnable) {
        dk0.d dVar = this.f399708a;
        if (dVar != null) {
            dVar.runOnUiThread(runnable);
        }
    }

    public void f(dk0.d dVar) {
        this.f399708a = dVar;
    }
}
