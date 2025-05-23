package com.qq.e.comm.plugin.i;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f39506a;

    /* renamed from: b, reason: collision with root package name */
    private int f39507b;

    /* renamed from: c, reason: collision with root package name */
    private int f39508c;

    /* renamed from: d, reason: collision with root package name */
    private int f39509d;

    /* renamed from: e, reason: collision with root package name */
    private b f39510e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f39511a;

        /* renamed from: b, reason: collision with root package name */
        private int f39512b;

        /* renamed from: c, reason: collision with root package name */
        private int f39513c = 10000;

        /* renamed from: d, reason: collision with root package name */
        private int f39514d = 10000;

        /* renamed from: e, reason: collision with root package name */
        private b f39515e;

        public a a(int i3) {
            this.f39511a = i3;
            return this;
        }

        public a b(int i3) {
            this.f39512b = i3;
            return this;
        }

        public a a(b bVar) {
            this.f39515e = bVar;
            return this;
        }

        public c a() {
            c cVar = new c(this.f39511a, this.f39512b, this.f39513c, this.f39514d);
            cVar.a(this.f39515e);
            return cVar;
        }
    }

    public c(int i3, int i16, int i17, int i18) {
        this.f39506a = i3;
        this.f39507b = i16;
        this.f39508c = i17;
        this.f39509d = i18;
    }

    public int b() {
        return this.f39506a;
    }

    public int c() {
        return this.f39508c;
    }

    public int d() {
        return this.f39509d;
    }

    public b e() {
        return this.f39510e;
    }

    public int a() {
        return this.f39507b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        this.f39510e = bVar;
    }
}
