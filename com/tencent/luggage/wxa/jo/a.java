package com.tencent.luggage.wxa.jo;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static b f131218a = new C6347a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.jo.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6347a implements b {
        @Override // com.tencent.luggage.wxa.jo.a.b
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
            f131218a = bVar;
        }
    }

    public static void a() {
        f131218a.loadLibrary("mmtcp");
    }
}
