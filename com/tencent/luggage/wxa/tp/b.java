package com.tencent.luggage.wxa.tp;

import android.content.SharedPreferences;
import android.util.SparseArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    public static volatile b f141784f;

    /* renamed from: a, reason: collision with root package name */
    public boolean f141785a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f141786b = false;

    /* renamed from: c, reason: collision with root package name */
    public int f141787c = 0;

    /* renamed from: d, reason: collision with root package name */
    public SparseArray f141788d = new SparseArray(10);

    /* renamed from: e, reason: collision with root package name */
    public SharedPreferences f141789e = null;

    public static b c() {
        b bVar;
        if (f141784f == null) {
            synchronized (b.class) {
                if (f141784f == null) {
                    f141784f = new b();
                }
                bVar = f141784f;
            }
            return bVar;
        }
        return f141784f;
    }

    public void a(boolean z16) {
        synchronized (b.class) {
            this.f141785a = z16;
        }
    }

    public void b(boolean z16) {
        synchronized (b.class) {
            this.f141786b = z16;
        }
    }

    public SharedPreferences d() {
        SharedPreferences sharedPreferences;
        synchronized (b.class) {
            sharedPreferences = this.f141789e;
        }
        return sharedPreferences;
    }

    public boolean e() {
        boolean z16;
        synchronized (b.class) {
            z16 = this.f141785a;
        }
        return z16;
    }

    public boolean f() {
        boolean z16;
        synchronized (b.class) {
            z16 = this.f141786b;
        }
        return z16;
    }

    public void a(SharedPreferences sharedPreferences) {
        synchronized (b.class) {
            this.f141789e = sharedPreferences;
        }
    }

    public SparseArray b() {
        SparseArray sparseArray;
        synchronized (b.class) {
            sparseArray = this.f141788d;
        }
        return sparseArray;
    }

    public void a() {
        synchronized (b.class) {
            this.f141785a = false;
            this.f141786b = false;
            this.f141788d = new SparseArray(10);
            this.f141789e = null;
        }
    }
}
