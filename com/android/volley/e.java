package com.android.volley;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f31329a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31330b;

    public e(String str, String str2) {
        this.f31329a = str;
        this.f31330b = str2;
    }

    public final String a() {
        return this.f31329a;
    }

    public final String b() {
        return this.f31330b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (TextUtils.equals(this.f31329a, eVar.f31329a) && TextUtils.equals(this.f31330b, eVar.f31330b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f31329a.hashCode() * 31) + this.f31330b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f31329a + ",value=" + this.f31330b + "]";
    }
}
