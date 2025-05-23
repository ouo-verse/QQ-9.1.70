package f73;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class c<T, P> {

    /* renamed from: a, reason: collision with root package name */
    private volatile T f397978a;

    protected abstract T a(P p16);

    public final T b(P p16) {
        if (this.f397978a == null) {
            synchronized (this) {
                if (this.f397978a == null) {
                    this.f397978a = a(p16);
                }
            }
        }
        return this.f397978a;
    }
}
