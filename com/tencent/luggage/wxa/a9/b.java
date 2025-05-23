package com.tencent.luggage.wxa.a9;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static InterfaceC5992b f120974a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements InterfaceC5992b {
        @Override // com.tencent.luggage.wxa.a9.b.InterfaceC5992b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a9.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC5992b {
        void loadLibrary(String str);
    }

    public static void a(InterfaceC5992b interfaceC5992b) {
        if (interfaceC5992b != null) {
            f120974a = interfaceC5992b;
        }
    }

    public static void a(String str) {
        f120974a.loadLibrary(str);
    }
}
