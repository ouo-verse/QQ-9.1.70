package com.qzone.album.env.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f43883a;

    public static void A(a aVar) {
        f43883a = aVar;
    }

    public static a m() {
        if (f43883a == null) {
            b.a();
        }
        return f43883a;
    }

    public abstract boolean B();

    public abstract boolean C();

    public abstract boolean D();

    public abstract int E(String str);

    public abstract boolean F(String str);

    public abstract void G(Activity activity, long j3);

    public abstract void H(Runnable runnable);

    public abstract void I(Runnable runnable, long j3);

    public abstract void J(Runnable runnable);

    public abstract void K(Runnable runnable);

    public abstract void L();

    public abstract void M(String str, boolean z16);

    public abstract void N(String str, long j3);

    public abstract void O(Runnable runnable);

    public abstract void P(int i3, int i16, String str, boolean z16, String... strArr);

    public abstract void Q(int i3, String str, int... iArr);

    public abstract void R(String str, String str2, String str3);

    public abstract void S(String str, HashMap<String, String> hashMap);

    public abstract void T(int i3);

    public abstract void U(int i3);

    public abstract void V(String str);

    public abstract void W(String str, int i3);

    public abstract void X(String str);

    public abstract void Y(String str, boolean z16);

    public abstract void a();

    public abstract void b(String str, Object... objArr);

    public abstract void c(String str, Object... objArr);

    public abstract void d(String str, Object... objArr);

    public abstract void e(String str, String str2);

    public abstract void f(String str, String str2, Throwable th5);

    public abstract void g(String str, Throwable th5);

    public abstract void h(String str, Object... objArr);

    public abstract void i(String str, Object... objArr);

    public abstract boolean j();

    public abstract void k();

    public abstract void l(String str);

    public abstract Context n(Activity activity);

    public abstract Handler o();

    public abstract boolean p(String str, boolean z16);

    public abstract float q();

    public abstract ArrayList<s4.b> r(Intent intent);

    public abstract long s();

    public abstract int t(String str, String str2, int i3);

    public abstract Handler u();

    public abstract int v();

    public abstract int w(long j3);

    public abstract String x(long j3);

    public abstract void y(Activity activity, int i3, int i16, int i17, int i18, ArrayList<String> arrayList, boolean z16);

    public abstract void z(Activity activity, int i3, int i16);
}
