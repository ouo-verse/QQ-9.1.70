package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ax {

    /* renamed from: e, reason: collision with root package name */
    private static ax f389675e;

    /* renamed from: a, reason: collision with root package name */
    private Context f389676a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f389677b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f389678c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final List<String> f389679d = new ArrayList();

    ax(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f389676a = applicationContext;
        if (applicationContext == null) {
            this.f389676a = context;
        }
        SharedPreferences sharedPreferences = this.f389676a.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(",")) {
            if (TextUtils.isEmpty(str)) {
                this.f389677b.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(",")) {
            if (!TextUtils.isEmpty(str2)) {
                this.f389678c.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(",")) {
            if (!TextUtils.isEmpty(str3)) {
                this.f389679d.add(str3);
            }
        }
    }

    public static ax a(Context context) {
        if (f389675e == null) {
            f389675e = new ax(context);
        }
        return f389675e;
    }

    public void b(String str) {
        synchronized (this.f389677b) {
            if (!this.f389677b.contains(str)) {
                this.f389677b.add(str);
                this.f389676a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.ag.d(this.f389677b, ",")).commit();
            }
        }
    }

    public boolean c(String str) {
        boolean contains;
        synchronized (this.f389677b) {
            contains = this.f389677b.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f389678c) {
            if (!this.f389678c.contains(str)) {
                this.f389678c.add(str);
                this.f389676a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.ag.d(this.f389678c, ",")).commit();
            }
        }
    }

    public boolean e(String str) {
        boolean contains;
        synchronized (this.f389678c) {
            contains = this.f389678c.contains(str);
        }
        return contains;
    }

    public void f(String str) {
        synchronized (this.f389679d) {
            if (!this.f389679d.contains(str)) {
                this.f389679d.add(str);
                this.f389676a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.ag.d(this.f389679d, ",")).commit();
            }
        }
    }

    public boolean g(String str) {
        boolean contains;
        synchronized (this.f389679d) {
            contains = this.f389679d.contains(str);
        }
        return contains;
    }

    public void h(String str) {
        synchronized (this.f389677b) {
            if (this.f389677b.contains(str)) {
                this.f389677b.remove(str);
                this.f389676a.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.ag.d(this.f389677b, ",")).commit();
            }
        }
    }

    public void i(String str) {
        synchronized (this.f389678c) {
            if (this.f389678c.contains(str)) {
                this.f389678c.remove(str);
                this.f389676a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.ag.d(this.f389678c, ",")).commit();
            }
        }
    }

    public void j(String str) {
        synchronized (this.f389679d) {
            if (this.f389679d.contains(str)) {
                this.f389679d.remove(str);
                this.f389676a.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.ag.d(this.f389679d, ",")).commit();
            }
        }
    }
}
