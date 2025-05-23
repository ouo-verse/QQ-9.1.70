package or;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f423428a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f423429b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f423430c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f423431d;

    /* renamed from: e, reason: collision with root package name */
    private int f423432e;

    /* renamed from: f, reason: collision with root package name */
    private int f423433f;

    /* renamed from: g, reason: collision with root package name */
    public int f423434g;

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f423435a = true;

        /* renamed from: b, reason: collision with root package name */
        private boolean f423436b = true;

        /* renamed from: c, reason: collision with root package name */
        private int f423437c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f423438d = 1;

        /* renamed from: e, reason: collision with root package name */
        private boolean f423439e = false;

        /* renamed from: f, reason: collision with root package name */
        public boolean f423440f = true;

        /* renamed from: g, reason: collision with root package name */
        public int f423441g = 0;

        public c f() {
            return new c(this);
        }

        public a g(boolean z16) {
            this.f423435a = z16;
            return this;
        }

        public a h(boolean z16) {
            this.f423436b = z16;
            return this;
        }

        public a i(boolean z16) {
            this.f423439e = z16;
            return this;
        }

        public a j(int i3) {
            this.f423441g = i3;
            return this;
        }

        public a k(int i3) {
            this.f423438d = i3;
            return this;
        }

        public a l(int i3) {
            this.f423437c = i3;
            return this;
        }
    }

    c(a aVar) {
        this.f423428a = aVar.f423435a;
        this.f423429b = aVar.f423436b;
        this.f423432e = aVar.f423437c;
        this.f423433f = aVar.f423438d;
        this.f423430c = aVar.f423439e;
        this.f423431d = aVar.f423440f;
        this.f423434g = aVar.f423441g;
    }

    public int a() {
        return this.f423433f;
    }

    public int b() {
        return this.f423432e;
    }

    public boolean c() {
        return this.f423428a;
    }

    public boolean d() {
        return this.f423429b;
    }
}
