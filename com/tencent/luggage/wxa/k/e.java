package com.tencent.luggage.wxa.k;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static e f131294c;

    /* renamed from: a, reason: collision with root package name */
    public Context f131295a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences f131296b;

    public e(Context context) {
        this.f131295a = context;
        this.f131296b = context.getSharedPreferences("camera", 0);
    }

    public static void a(Context context) {
        if (f131294c == null) {
            f131294c = new e(context);
        }
    }

    public static e b() {
        return f131294c;
    }

    public void c() {
        SharedPreferences sharedPreferences = this.f131296b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("key_use_camera1", true).apply();
        }
    }

    public boolean d() {
        SharedPreferences sharedPreferences = this.f131296b;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean("key_use_camera1", false);
    }

    public Context a() {
        return this.f131295a;
    }
}
