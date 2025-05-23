package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class df {

    /* renamed from: b, reason: collision with root package name */
    private static volatile df f388586b;

    /* renamed from: a, reason: collision with root package name */
    private Context f388587a;

    df(Context context) {
        this.f388587a = context;
    }

    public static df a(Context context) {
        if (f388586b == null) {
            synchronized (df.class) {
                if (f388586b == null) {
                    f388586b = new df(context);
                }
            }
        }
        return f388586b;
    }

    private void h(kz4.d dVar) {
        if (dVar instanceof kz4.c) {
            com.xiaomi.clientreport.manager.b.c(this.f388587a, (kz4.c) dVar);
        } else if (dVar instanceof kz4.b) {
            com.xiaomi.clientreport.manager.b.b(this.f388587a, (kz4.b) dVar);
        }
    }

    public void b(String str, int i3, long j3, long j16) {
        if (i3 >= 0 && j16 >= 0 && j3 > 0) {
            kz4.c j17 = de.j(this.f388587a, i3, j3, j16);
            j17.a(str);
            j17.b("5_9_9-C");
            h(j17);
        }
    }

    public void c(String str, Intent intent, int i3, String str2) {
        if (intent == null) {
            return;
        }
        e(str, de.e(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i3, System.currentTimeMillis(), str2);
    }

    public void d(String str, Intent intent, String str2) {
        if (intent == null) {
            return;
        }
        e(str, de.e(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), str2);
    }

    public void e(String str, String str2, String str3, int i3, long j3, String str4) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            kz4.b g16 = de.g(this.f388587a, str2, str3, i3, j3, str4);
            g16.a(str);
            g16.b("5_9_9-C");
            h(g16);
        }
    }

    public void f(String str, String str2, String str3, int i3, String str4) {
        e(str, str2, str3, i3, System.currentTimeMillis(), str4);
    }

    public void g(String str, String str2, String str3, String str4) {
        e(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    public void i(String str, String str2, String str3, String str4) {
        e(str, str2, str3, 5001, System.currentTimeMillis(), str4);
    }

    public void j(String str, String str2, String str3, String str4) {
        e(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }
}
