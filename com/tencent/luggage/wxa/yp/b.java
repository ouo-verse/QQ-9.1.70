package com.tencent.luggage.wxa.yp;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile InterfaceC6963b f146060a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile long f146061b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements InterfaceC6963b {
        @Override // com.tencent.luggage.wxa.yp.b.InterfaceC6963b
        public boolean a(String str, int i3) {
            return true;
        }

        @Override // com.tencent.luggage.wxa.yp.b.InterfaceC6963b
        public void println(int i3, String str, String str2) {
            System.out.println("[" + str + "] " + str2);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.yp.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC6963b {
        boolean a(String str, int i3);

        void println(int i3, String str, String str2);
    }

    static {
        InterfaceC6963b aVar;
        long j3;
        try {
            Class.forName("android.util.Log");
            aVar = new com.tencent.luggage.wxa.yp.a();
            j3 = 2;
        } catch (ClassNotFoundException unused) {
            aVar = new a();
            j3 = 1;
        }
        f146060a = aVar;
        f146061b = j3;
    }

    public static void a(InterfaceC6963b interfaceC6963b) {
        f146060a = interfaceC6963b;
        f146061b = interfaceC6963b == null ? 0L : 3L;
    }

    public static void b(String str, String str2) {
        a(6, str, str2);
    }

    public static void c(String str, String str2) {
        a(4, str, str2);
    }

    public static void d(String str, String str2, Object... objArr) {
        a(5, str, str2, objArr);
    }

    public static void e(String str, String str2) {
        a(5, str, str2);
    }

    public static void b(String str, String str2, Object... objArr) {
        a(6, str, str2, objArr);
    }

    public static void c(String str, String str2, Object... objArr) {
        a(4, str, str2, objArr);
    }

    public static void d(String str, String str2) {
        a(2, str, str2);
    }

    public static void a(int i3, String str, String str2) {
        InterfaceC6963b interfaceC6963b = f146060a;
        if (interfaceC6963b == null) {
            return;
        }
        interfaceC6963b.println(i3, str, str2);
    }

    public static void b(String str, Throwable th5, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            a(5, str, str2);
        }
        if (th5 != null) {
            a(5, str, th5);
        }
    }

    public static void a(int i3, String str, Throwable th5) {
        InterfaceC6963b interfaceC6963b = f146060a;
        if (interfaceC6963b == null || !interfaceC6963b.a(str, i3)) {
            return;
        }
        StringWriter stringWriter = new StringWriter(512);
        th5.printStackTrace(new PrintWriter(stringWriter));
        StringTokenizer stringTokenizer = new StringTokenizer(stringWriter.toString(), "\n");
        while (stringTokenizer.hasMoreTokens()) {
            interfaceC6963b.println(i3, str, stringTokenizer.nextToken());
        }
    }

    public static void a(int i3, String str, String str2, Object... objArr) {
        InterfaceC6963b interfaceC6963b = f146060a;
        if (interfaceC6963b == null || !interfaceC6963b.a(str, i3)) {
            return;
        }
        interfaceC6963b.println(i3, str, String.format(str2, objArr));
    }

    public static void a(String str, Throwable th5, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            a(6, str, str2);
        }
        if (th5 != null) {
            a(6, str, th5);
        }
    }

    public static void a(String str, Throwable th5, String str2, Object... objArr) {
        a(6, str, str2, objArr);
        if (th5 != null) {
            a(6, str, th5);
        }
    }

    public static void a(String str, String str2) {
        a(3, str, str2);
    }

    public static void a(String str, String str2, Object... objArr) {
        a(3, str, str2, objArr);
    }
}
