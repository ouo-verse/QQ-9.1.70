package com.tencent.mobileqq.richmedia.conn;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements Cloneable {
    public int C;

    /* renamed from: d, reason: collision with root package name */
    public String f281490d;

    /* renamed from: e, reason: collision with root package name */
    public int f281491e;

    /* renamed from: f, reason: collision with root package name */
    public int f281492f = 0;

    /* renamed from: h, reason: collision with root package name */
    public long f281493h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f281494i = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f281495m = 0;

    public a(String str, int i3) {
        this.f281490d = str;
        this.f281491e = i3;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() throws CloneNotSupportedException {
        return (a) super.clone();
    }

    public String toString() {
        return this.f281490d + ":" + this.f281491e + " failCount:" + this.f281494i;
    }
}
