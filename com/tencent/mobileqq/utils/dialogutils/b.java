package com.tencent.mobileqq.utils.dialogutils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    String f307671a;

    /* renamed from: b, reason: collision with root package name */
    int f307672b;

    /* renamed from: c, reason: collision with root package name */
    int f307673c;

    /* renamed from: d, reason: collision with root package name */
    int f307674d;

    /* renamed from: e, reason: collision with root package name */
    boolean f307675e = false;

    public b(int i3, String str) {
        this.f307671a = str;
        this.f307672b = i3;
        this.f307674d = QQCustomMenuItemPriorityHelper.c(str);
    }

    public int a() {
        return this.f307673c;
    }

    public int b() {
        return this.f307672b;
    }

    public String c() {
        return this.f307671a;
    }

    public void d(int i3) {
        this.f307673c = i3;
    }

    public String toString() {
        return "QQCustomMenuItem{title='" + this.f307671a + "', special=" + this.f307675e + ", priority=" + this.f307674d + '}';
    }
}
