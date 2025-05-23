package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ap {

    /* renamed from: b, reason: collision with root package name */
    private static volatile ap f388201b;

    /* renamed from: a, reason: collision with root package name */
    private Context f388202a;

    ap(Context context) {
        this.f388202a = context;
    }

    public static ap b(Context context) {
        if (f388201b == null) {
            synchronized (ap.class) {
                if (f388201b == null) {
                    f388201b = new ap(context);
                }
            }
        }
        return f388201b;
    }

    public synchronized long a(String str, String str2, long j3) {
        try {
        } catch (Throwable unused) {
            return j3;
        }
        return this.f388202a.getSharedPreferences(str, 4).getLong(str2, j3);
    }

    public synchronized String c(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f388202a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized void d(String str, String str2, long j3) {
        SharedPreferences.Editor edit = this.f388202a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j3);
        edit.commit();
    }

    public synchronized void e(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f388202a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }
}
