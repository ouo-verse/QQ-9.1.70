package com.tencent.luggage.wxa.ko;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static b f132676a = new C6402a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ko.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6402a implements b {
        @Override // com.tencent.luggage.wxa.ko.a.b
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
            f132676a = bVar;
        }
    }

    public static void a() {
        f132676a.loadLibrary("mmudp");
    }
}
