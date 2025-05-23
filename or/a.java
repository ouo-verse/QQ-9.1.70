package or;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f423401a;

    /* renamed from: b, reason: collision with root package name */
    public int f423402b;

    /* renamed from: c, reason: collision with root package name */
    public int f423403c;

    /* renamed from: d, reason: collision with root package name */
    private b f423404d;

    /* renamed from: e, reason: collision with root package name */
    private c f423405e;

    public a(int i3, int i16, int i17) {
        this.f423401a = i3;
        this.f423402b = i16;
        this.f423403c = i17;
    }

    public int a() {
        return this.f423403c;
    }

    public int b() {
        return this.f423402b;
    }

    public b c() {
        return this.f423404d;
    }

    public c d() {
        return this.f423405e;
    }

    public void e(b bVar) {
        this.f423404d = bVar;
        if (bVar.e() != null) {
            this.f423402b = this.f423404d.b();
        }
    }

    public void f(c cVar) {
        this.f423405e = cVar;
    }
}
