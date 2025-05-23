package c45;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface d extends e {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a<T extends d> {
        c45.b a(int i3);

        T b(f fVar);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {

        /* compiled from: P */
        /* loaded from: classes39.dex */
        public interface a<T extends b> {
            T a(int i3);
        }

        int getValue();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class c implements b {

        /* renamed from: b, reason: collision with root package name */
        public static final a f30317b = new a();

        /* renamed from: a, reason: collision with root package name */
        public final int f30318a;

        /* compiled from: P */
        /* loaded from: classes39.dex */
        public static final class a implements b.a<c> {
            @Override // c45.d.b.a
            public final c a(int i3) {
                return new c(i3);
            }

            public final c b() {
                return new c(0);
            }
        }

        public c(int i3) {
            this.f30318a = i3;
        }

        @Override // c45.d.b
        public final int getValue() {
            return this.f30318a;
        }
    }

    void writeMessage(g gVar);
}
