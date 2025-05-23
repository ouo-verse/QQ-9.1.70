package com.tencent.luggage.wxa.cr;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static a f123844a = a.f123845a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f123845a = new C6122a();

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.cr.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C6122a implements a {
            @Override // com.tencent.luggage.wxa.cr.b.a
            public void loadLibrary(String str) {
                System.loadLibrary(str);
            }
        }

        void loadLibrary(String str);
    }

    public static void a(a aVar) {
        if (aVar == null) {
            f123844a = a.f123845a;
        } else {
            f123844a = aVar;
        }
    }

    public static void a(String str) {
        f123844a.loadLibrary(str);
    }
}
