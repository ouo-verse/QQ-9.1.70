package com.tencent.mapsdk.internal;

import android.content.SharedPreferences;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class mv {

    /* renamed from: b, reason: collision with root package name */
    private static final String f149345b = "%s-%s-%s,%s-%s-%s,%s-%s-%s";

    /* renamed from: a, reason: collision with root package name */
    protected SharedPreferences f149346a = null;

    private long d(String str) {
        SharedPreferences sharedPreferences = this.f149346a;
        if (sharedPreferences == null) {
            return -1L;
        }
        return sharedPreferences.getLong(str, -1L);
    }

    public final boolean a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f149346a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.edit().putString(str, str2).commit();
    }

    public final String b(String str, String str2) {
        SharedPreferences sharedPreferences = this.f149346a;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(str, str2);
    }

    public final boolean c(String str) {
        SharedPreferences sharedPreferences = this.f149346a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean(str, false);
    }

    public final String a(String str) {
        return b(str, (String) null);
    }

    public final int b(String str) {
        SharedPreferences sharedPreferences = this.f149346a;
        if (sharedPreferences == null) {
            return -1;
        }
        return sharedPreferences.getInt(str, -1);
    }

    public final boolean a(String str, int i3) {
        SharedPreferences sharedPreferences = this.f149346a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.edit().putInt(str, i3).commit();
    }

    public final int b(String str, int i3) {
        SharedPreferences sharedPreferences = this.f149346a;
        return sharedPreferences == null ? i3 : sharedPreferences.getInt(str, i3);
    }

    public final boolean a(String str, long j3) {
        SharedPreferences sharedPreferences = this.f149346a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.edit().putLong(str, j3).commit();
    }

    private String b() {
        return String.format(f149345b, er.f148280i, Integer.valueOf(b(et.f148298a)), b(et.f148317t, (String) null), er.f148283l, Integer.valueOf(b("indoormap_style_version")), b("indoormap_style_md5", (String) null), er.f148284m, Integer.valueOf(b("indoormap_style_night_version")), b("indoormap_style_night_md5", (String) null));
    }

    public final boolean a(String str, boolean z16) {
        SharedPreferences sharedPreferences = this.f149346a;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.edit().putBoolean(str, z16).commit();
    }

    public final boolean a(String[] strArr) {
        SharedPreferences sharedPreferences = this.f149346a;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : strArr) {
            edit.remove(str);
        }
        return edit.commit();
    }

    public final boolean a() {
        return a(new String[]{et.f148298a, et.f148300c, et.f148301d, et.f148314q, et.f148315r, et.f148316s, et.f148317t, et.f148318u, et.f148319v, et.f148320w, et.f148321x, et.f148322y});
    }
}
