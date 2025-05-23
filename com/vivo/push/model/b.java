package com.vivo.push.model;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private String f387745a;

    /* renamed from: d, reason: collision with root package name */
    private String f387748d;

    /* renamed from: b, reason: collision with root package name */
    private long f387746b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f387747c = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f387749e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f387750f = false;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f387745a = str;
            return;
        }
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final String a() {
        return this.f387745a;
    }

    public final long b() {
        return this.f387746b;
    }

    public final boolean c() {
        return this.f387749e;
    }

    public final boolean d() {
        return this.f387750f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.f387745a + ", mPushVersion=" + this.f387746b + ", mPackageVersion=" + this.f387747c + ", mInBlackList=" + this.f387749e + ", mPushEnable=" + this.f387750f + "}";
    }

    public final void a(long j3) {
        this.f387746b = j3;
    }

    public final void b(boolean z16) {
        this.f387750f = z16;
    }

    public final void a(boolean z16) {
        this.f387749e = z16;
    }

    public final void a(int i3) {
        this.f387747c = i3;
    }

    public final void a(String str) {
        this.f387748d = str;
    }
}
