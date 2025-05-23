package com.tencent.luggage.wxa.wo;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static InterfaceC6891a f144334a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.wo.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6891a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void a(InterfaceC6891a interfaceC6891a) {
        f144334a = interfaceC6891a;
    }

    public static void b(String str, String str2, Object... objArr) {
        InterfaceC6891a interfaceC6891a = f144334a;
        if (interfaceC6891a != null) {
            interfaceC6891a.e(str, str2, objArr);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        InterfaceC6891a interfaceC6891a = f144334a;
        if (interfaceC6891a != null) {
            interfaceC6891a.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        InterfaceC6891a interfaceC6891a = f144334a;
        if (interfaceC6891a != null) {
            interfaceC6891a.w(str, str2, objArr);
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        InterfaceC6891a interfaceC6891a = f144334a;
        if (interfaceC6891a != null) {
            interfaceC6891a.d(str, str2, objArr);
        }
    }
}
