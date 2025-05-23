package m7;

/* compiled from: P */
/* loaded from: classes38.dex */
public abstract class b<E> implements k7.a<E> {

    /* renamed from: a, reason: collision with root package name */
    private E[] f416357a = null;

    /* renamed from: b, reason: collision with root package name */
    private int f416358b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f416359c;

    public b(int i3) {
        a(i3);
    }

    private void a(int i3) {
        E[] b16 = b(i3);
        E[] eArr = this.f416357a;
        if (eArr != null) {
            System.arraycopy(eArr, 0, b16, 0, this.f416359c);
        }
        for (int i16 = 0; i16 < b16.length; i16++) {
            b16[i16] = c();
        }
        this.f416357a = b16;
        this.f416359c = b16.length;
    }

    protected abstract E[] b(int i3);

    protected abstract E c();

    @Override // k7.a
    public final E pop() {
        int i3 = this.f416358b;
        int i16 = this.f416359c;
        if (i3 >= i16) {
            a(i16 * 2);
        }
        E[] eArr = this.f416357a;
        int i17 = this.f416358b;
        this.f416358b = i17 + 1;
        return eArr[i17];
    }

    @Override // k7.a
    public final void push(E e16) {
        E[] eArr = this.f416357a;
        int i3 = this.f416358b - 1;
        this.f416358b = i3;
        eArr[i3] = e16;
    }
}
