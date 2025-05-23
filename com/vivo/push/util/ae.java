package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ae implements e {

    /* renamed from: a, reason: collision with root package name */
    private static String f387871a = "SpCache";

    /* renamed from: b, reason: collision with root package name */
    private static String f387872b = "com.vivo.push.cache";

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f387873c;

    @Override // com.vivo.push.util.e
    public final boolean a(Context context) {
        if (this.f387873c != null) {
            return true;
        }
        this.f387873c = context.getSharedPreferences(f387872b, 0);
        return true;
    }

    @Override // com.vivo.push.util.e
    public final void b(String str, String str2) {
        SharedPreferences.Editor edit = this.f387873c.edit();
        if (edit != null) {
            edit.putString(str, str2);
            c.a(edit);
            u.d(f387871a, "putString by ".concat(String.valueOf(str)));
            return;
        }
        u.b(f387871a, "putString error by ".concat(String.valueOf(str)));
    }

    @Override // com.vivo.push.util.e
    public final String a(String str, String str2) {
        String string = this.f387873c.getString(str, str2);
        u.d(f387871a, "getString " + str + " is " + string);
        return string;
    }

    public final void a() {
        SharedPreferences.Editor edit = this.f387873c.edit();
        if (edit != null) {
            edit.clear();
            c.a(edit);
        }
        u.d(f387871a, "system cache is cleared");
    }
}
