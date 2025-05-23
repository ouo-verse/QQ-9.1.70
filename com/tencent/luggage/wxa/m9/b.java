package com.tencent.luggage.wxa.m9;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static InterfaceC6462b f134214a;

    /* renamed from: b, reason: collision with root package name */
    public static InterfaceC6462b f134215b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements InterfaceC6462b {

        /* renamed from: a, reason: collision with root package name */
        public Handler f134216a = new Handler(Looper.getMainLooper());
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.m9.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6462b {
    }

    static {
        a aVar = new a();
        f134214a = aVar;
        f134215b = aVar;
    }

    public static void a(InterfaceC6462b interfaceC6462b) {
        f134215b = interfaceC6462b;
    }

    public static void b(String str, String str2) {
        b(str, str2, null);
    }

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    public static void b(String str, String str2, Object... objArr) {
        w.d(str, str2, objArr);
    }

    public static void a(String str, String str2, Object... objArr) {
        w.b(str, str2, objArr);
    }

    public static void a(String str, Throwable th5, String str2, Object... objArr) {
        w.a(str, th5, str2, objArr);
    }
}
