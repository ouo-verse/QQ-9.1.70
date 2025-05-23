package com.tencent.luggage.wxa.h;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static b f126827a = new C6249a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6249a implements b {
        @Override // com.tencent.luggage.wxa.h.a.b
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
        f126827a = bVar;
    }

    public static void a(String str) {
        f126827a.loadLibrary(str);
    }
}
