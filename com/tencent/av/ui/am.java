package com.tencent.av.ui;

import com.tencent.av.gaudio.AVPhoneUserInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class am {

    /* renamed from: a, reason: collision with root package name */
    public int f75349a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f75350b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f75351c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f75352d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f75353e = false;

    /* renamed from: f, reason: collision with root package name */
    public AVPhoneUserInfo f75354f = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean f75355g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f75356h = false;

    /* renamed from: i, reason: collision with root package name */
    public long f75357i = 4;

    /* renamed from: j, reason: collision with root package name */
    public boolean f75358j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f75359k = false;

    /* renamed from: l, reason: collision with root package name */
    public int f75360l = 0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f75361m = false;

    public long a() {
        return this.f75350b;
    }

    public int b() {
        return this.f75360l;
    }

    public boolean c() {
        return this.f75352d;
    }

    public boolean d() {
        return this.f75355g;
    }

    public boolean e() {
        if (this.f75360l == 2) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (this.f75353e && !this.f75355g) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return this.f75358j;
    }

    public String toString() {
        return "uin:=" + this.f75350b + ",videoSrc:=" + this.f75360l + ",isVideoIn:=" + this.f75358j + ",isAttened:=" + this.f75352d + ",isSpeaking:=" + this.f75353e + ',';
    }
}
