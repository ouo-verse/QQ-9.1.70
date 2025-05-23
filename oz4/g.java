package oz4;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class g extends f {

    /* renamed from: g, reason: collision with root package name */
    public static volatile g f424754g;

    public static g h() {
        if (f424754g == null) {
            synchronized (g.class) {
                if (f424754g == null) {
                    f424754g = new g();
                }
            }
        }
        return f424754g;
    }
}
