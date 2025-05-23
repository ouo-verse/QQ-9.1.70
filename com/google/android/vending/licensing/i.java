package com.google.android.vending.licensing;

import android.content.SharedPreferences;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f34644a;

    /* renamed from: b, reason: collision with root package name */
    private final g f34645b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences.Editor f34646c = null;

    public i(SharedPreferences sharedPreferences, g gVar) {
        this.f34644a = sharedPreferences;
        this.f34645b = gVar;
    }

    public void a() {
        SharedPreferences.Editor editor = this.f34646c;
        if (editor != null) {
            editor.commit();
            this.f34646c = null;
        }
    }

    public String b(String str, String str2) {
        String string = this.f34644a.getString(str, null);
        if (string != null) {
            try {
                return this.f34645b.a(string, str);
            } catch (ValidationException unused) {
                Log.w("PreferenceObfuscator", "Validation error while reading preference: " + str);
                return str2;
            }
        }
        return str2;
    }

    public void c(String str, String str2) {
        if (this.f34646c == null) {
            this.f34646c = this.f34644a.edit();
        }
        this.f34646c.putString(str, this.f34645b.b(str2, str));
    }
}
