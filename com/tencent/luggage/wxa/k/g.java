package com.tencent.luggage.wxa.k;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements n {

    /* renamed from: c, reason: collision with root package name */
    public static final g f131298c = new g();

    /* renamed from: a, reason: collision with root package name */
    public String f131299a = "camera";

    /* renamed from: b, reason: collision with root package name */
    public int f131300b = 4;

    public static g a() {
        return f131298c;
    }

    @Override // com.tencent.luggage.wxa.k.n
    public void d(String str, String str2) {
        a(3, str, str2);
    }

    @Override // com.tencent.luggage.wxa.k.n
    public void e(String str, String str2) {
        a(6, str, str2);
    }

    @Override // com.tencent.luggage.wxa.k.n
    public void i(String str, String str2) {
        a(4, str, str2);
    }

    @Override // com.tencent.luggage.wxa.k.n
    public void w(String str, String str2) {
        a(5, str, str2);
    }

    public static String a(String str, Throwable th5) {
        return str + '\n' + a(th5);
    }

    @Override // com.tencent.luggage.wxa.k.n
    public void e(String str, String str2, Throwable th5) {
        a(6, str, str2, th5);
    }

    @Override // com.tencent.luggage.wxa.k.n
    public void i(String str, String str2, Throwable th5) {
        a(4, str, str2, th5);
    }

    public static String a(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // com.tencent.luggage.wxa.k.n
    public boolean a(int i3) {
        return this.f131300b <= i3;
    }

    @Override // com.tencent.luggage.wxa.k.n
    public void a(String str, String str2, Throwable th5) {
        a(5, str, str2, th5);
    }

    public final void a(int i3, String str, String str2) {
        Log.println(i3, a(str), str2);
    }

    public final void a(int i3, String str, String str2, Throwable th5) {
        Log.println(i3, a(str), a(str2, th5));
    }

    public final String a(String str) {
        if (this.f131299a == null) {
            return str;
        }
        return this.f131299a + ":" + str;
    }
}
