package com.tencent.luggage.wxa.gp;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static b f126803a = new C6248a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.gp.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6248a implements b {
        @Override // com.tencent.luggage.wxa.gp.a.b
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
            f126803a = bVar;
        }
    }

    public static void a() {
        f126803a.loadLibrary("mmwcwss");
    }
}
