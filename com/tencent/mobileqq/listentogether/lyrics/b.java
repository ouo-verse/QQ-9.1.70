package com.tencent.mobileqq.listentogether.lyrics;

import android.graphics.Paint;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    public String f241055g;

    /* renamed from: n, reason: collision with root package name */
    public int f241062n;

    /* renamed from: o, reason: collision with root package name */
    public String f241063o;

    /* renamed from: p, reason: collision with root package name */
    public int f241064p;

    /* renamed from: q, reason: collision with root package name */
    public String f241065q;

    /* renamed from: s, reason: collision with root package name */
    public int f241067s;

    /* renamed from: t, reason: collision with root package name */
    public int f241068t;

    /* renamed from: u, reason: collision with root package name */
    public Paint.Align f241069u;

    /* renamed from: a, reason: collision with root package name */
    public int f241049a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f241050b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f241051c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f241052d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f241053e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f241054f = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f241056h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f241057i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f241058j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f241059k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f241060l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f241061m = false;

    /* renamed from: r, reason: collision with root package name */
    public int f241066r = 0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f241070v = false;

    public boolean a(int i3, String str) {
        return i3 == this.f241062n && TextUtils.equals(str, this.f241063o) && i3 != 0 && str != null;
    }

    public boolean b(int i3, String str) {
        return i3 == this.f241064p && TextUtils.equals(str, this.f241065q) && i3 != 0 && str != null;
    }

    public boolean c() {
        return this.f241062n == this.f241064p && TextUtils.equals(this.f241063o, this.f241065q) && this.f241062n != 0 && this.f241063o != null;
    }

    public void d(int i3, String str) {
        this.f241062n = i3;
        this.f241063o = str;
    }

    public void e(int i3, String str) {
        this.f241064p = i3;
        this.f241065q = str;
    }

    public String toString() {
        return "FloatParams[\niconCenterX:" + this.f241049a + "\niconCenterY:" + this.f241050b + "\nalignRight:" + this.f241053e + "\nuserClosed:" + this.f241054f + "\nalbumUrl:" + this.f241055g + "\nshowIcon:" + this.f241056h + "\nisForeground:" + this.f241059k + "\ntmpGoneForSomePage:" + this.f241060l + "\ncurrentListenType:" + this.f241062n + "\ncurrentListenUin:" + this.f241063o + "\ncurrentAIOType:" + this.f241064p + "\ncurrentAIOUin:" + this.f241065q + "\ntextNeedCenter:" + this.f241058j + "\nshowIconValueChanged:" + this.f241057i + "\n]";
    }
}
