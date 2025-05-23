package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class s implements t {

    /* renamed from: a, reason: collision with root package name */
    private static final String f387929a = "(" + Process.myPid() + ")";

    @Override // com.vivo.push.util.t
    public final int a(String str, String str2) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f387929a + str2);
    }

    @Override // com.vivo.push.util.t
    public final int b(String str, String str2) {
        return Log.w("VivoPush.Client.".concat(String.valueOf(str)), f387929a + str2);
    }

    @Override // com.vivo.push.util.t
    public final int c(String str, String str2) {
        return Log.d("VivoPush.Client.".concat(String.valueOf(str)), f387929a + str2);
    }

    @Override // com.vivo.push.util.t
    public final int d(String str, String str2) {
        if (u.a()) {
            return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f387929a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.t
    public final int e(String str, String str2) {
        if (u.a()) {
            return Log.v("VivoPush.Client.".concat(String.valueOf(str)), f387929a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.t
    public final int a(String str, Throwable th5) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), Log.getStackTraceString(th5));
    }

    @Override // com.vivo.push.util.t
    public final int b(String str, String str2, Throwable th5) {
        if (!u.a()) {
            return -1;
        }
        return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f387929a + str2, th5);
    }

    @Override // com.vivo.push.util.t
    public final void c(Context context, String str) {
        if (a()) {
            a(context, str, 2);
        }
    }

    @Override // com.vivo.push.util.t
    public final void b(Context context, String str) {
        if (a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.t
    public final int a(String str, String str2, Throwable th5) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f387929a + str2, th5);
    }

    @Override // com.vivo.push.util.t
    public final String a(Throwable th5) {
        return Log.getStackTraceString(th5);
    }

    @Override // com.vivo.push.util.t
    public final void a(Context context, String str) {
        if (a()) {
            a(context, str, 0);
        }
    }

    private void a(Context context, String str, int i3) {
        com.vivo.push.b.n nVar = new com.vivo.push.b.n();
        nVar.b(str);
        nVar.a(i3);
        if (i3 > 0) {
            d("LogController", str);
        }
        nVar.g();
        com.vivo.push.a.a.a(context, nVar, context.getPackageName());
    }

    private static boolean a() {
        u.a();
        return com.vivo.push.g.a.a().b();
    }
}
