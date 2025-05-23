package com.tencent.luggage.wxa.np;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f135898a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f135899a = false;

        @Override // com.tencent.luggage.wxa.np.j.b
        public void a() {
            e.b("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
            this.f135899a = true;
        }

        @Override // com.tencent.luggage.wxa.np.j.b
        public boolean b() {
            return this.f135899a;
        }

        @Override // com.tencent.luggage.wxa.np.j.b
        public void reset() {
            this.f135899a = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a();

        boolean b();

        void reset();
    }

    public static void a(b bVar) {
        f135898a = bVar;
    }

    public static void b() {
        f135898a.a();
    }

    public static void c() {
        f135898a.reset();
    }

    public static boolean a() {
        return f135898a.b();
    }
}
