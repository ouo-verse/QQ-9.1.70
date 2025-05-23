package com.tencent.luggage.wxa.el;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public int f124921a;

    public b(int i3) {
        this.f124921a = i3;
    }

    public int a() {
        return this.f124921a;
    }

    public b(int i3, String str) {
        super(str);
        this.f124921a = i3;
    }

    public b(int i3, Throwable th5) {
        super(th5);
        this.f124921a = i3;
    }
}
