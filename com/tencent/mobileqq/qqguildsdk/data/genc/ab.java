package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ab {

    /* renamed from: a, reason: collision with root package name */
    protected int f266102a;

    /* renamed from: c, reason: collision with root package name */
    protected long f266104c;

    /* renamed from: b, reason: collision with root package name */
    protected ArrayList<String> f266103b = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<String> f266105d = new ArrayList<>();

    public long a() {
        return this.f266104c;
    }

    public ArrayList<String> b() {
        return this.f266103b;
    }

    public ArrayList<String> c() {
        return this.f266105d;
    }

    public int d() {
        return this.f266102a;
    }

    public void e(ArrayList<String> arrayList) {
        this.f266103b = arrayList;
    }

    public void f(int i3) {
        this.f266102a = i3;
    }

    public String toString() {
        return "GWGProConvertThirdIdReq{mType=" + this.f266102a + "mIds=" + this.f266103b + "mAppId=" + this.f266104c + "mStringIds=" + this.f266105d + "}";
    }
}
