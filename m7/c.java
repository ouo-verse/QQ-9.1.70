package m7;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class c<E> {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f416360a;

    /* renamed from: b, reason: collision with root package name */
    private int f416361b;

    /* renamed from: c, reason: collision with root package name */
    private final int f416362c;

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f416363d;

    public c(int i3, int i16) {
        this.f416362c = i3;
        this.f416360a = new Object[i3];
        for (int i17 = 0; i17 < i3; i17++) {
            this.f416360a[i17] = a();
        }
        this.f416361b = 0;
        this.f416363d = new Object[i16];
    }

    protected abstract E a();

    public final E b() {
        Object[] objArr = this.f416360a;
        int i3 = this.f416361b;
        this.f416361b = i3 + 1;
        return (E) objArr[i3];
    }

    public final void c(int i3) {
        this.f416361b -= i3;
    }
}
