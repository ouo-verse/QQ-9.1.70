package com.tencent.luggage.wxa.cb;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static b f123462a = new C6104a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.cb.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6104a implements b {
        @Override // com.tencent.luggage.wxa.cb.a.b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void loadLibrary(String str);
    }

    public static void a(b bVar) {
        if (bVar != null) {
            f123462a = bVar;
        }
    }

    public static void a() {
        f123462a.loadLibrary("mmmedia");
        f123462a.loadLibrary("wxaudio");
    }
}
