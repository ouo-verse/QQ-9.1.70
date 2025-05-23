package com.qq.e.comm.plugin.h;

import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f39419a;

    /* renamed from: b, reason: collision with root package name */
    private final int f39420b;

    /* renamed from: c, reason: collision with root package name */
    private final String f39421c;

    /* renamed from: d, reason: collision with root package name */
    private final String f39422d;

    /* renamed from: e, reason: collision with root package name */
    private final String f39423e;

    /* renamed from: f, reason: collision with root package name */
    private final WeakReference<c> f39424f;

    /* renamed from: g, reason: collision with root package name */
    private final long f39425g;

    /* renamed from: h, reason: collision with root package name */
    private final long f39426h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f39427i;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f39428a;

        /* renamed from: b, reason: collision with root package name */
        private int f39429b;

        /* renamed from: c, reason: collision with root package name */
        private String f39430c;

        /* renamed from: d, reason: collision with root package name */
        private String f39431d;

        /* renamed from: e, reason: collision with root package name */
        private String f39432e;

        /* renamed from: f, reason: collision with root package name */
        private WeakReference<c> f39433f;

        /* renamed from: g, reason: collision with root package name */
        private long f39434g;

        /* renamed from: h, reason: collision with root package name */
        private long f39435h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f39436i;

        public a a(String str) {
            this.f39428a = str;
            return this;
        }

        public a b(String str) {
            this.f39430c = str;
            return this;
        }

        public a c(String str) {
            this.f39431d = str;
            return this;
        }

        public a d(String str) {
            this.f39432e = str;
            return this;
        }

        public a a(int i3) {
            this.f39429b = i3;
            return this;
        }

        public a b(long j3) {
            this.f39435h = j3;
            return this;
        }

        public a a(WeakReference<c> weakReference) {
            this.f39433f = weakReference;
            return this;
        }

        public a a(long j3) {
            this.f39434g = j3;
            return this;
        }

        public a a(boolean z16) {
            this.f39436i = z16;
            return this;
        }

        public b a() {
            return new b(this.f39428a, this.f39429b, this.f39430c, this.f39431d, this.f39432e, this.f39433f, this.f39434g, this.f39435h, this.f39436i);
        }
    }

    public String a() {
        return this.f39419a;
    }

    public String b() {
        return this.f39421c;
    }

    public String c() {
        return this.f39422d;
    }

    public WeakReference<c> d() {
        return this.f39424f;
    }

    public long e() {
        return this.f39425g;
    }

    public long f() {
        return this.f39426h;
    }

    public boolean g() {
        return this.f39427i;
    }

    public boolean h() {
        WeakReference<c> weakReference;
        if (!TextUtils.isEmpty(this.f39419a) && !TextUtils.isEmpty(this.f39421c) && !TextUtils.isEmpty(this.f39423e) && (weakReference = this.f39424f) != null && weakReference.get() != null) {
            return true;
        }
        return false;
    }

    b(String str, int i3, String str2, String str3, String str4, WeakReference<c> weakReference, long j3, long j16, boolean z16) {
        this.f39419a = str;
        this.f39420b = i3;
        this.f39421c = str2;
        this.f39422d = str3;
        this.f39423e = str4;
        this.f39424f = weakReference;
        this.f39425g = j3;
        this.f39426h = j16;
        this.f39427i = z16;
    }
}
