package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class al {

    /* renamed from: a, reason: collision with root package name */
    protected String f266143a = "";

    /* renamed from: b, reason: collision with root package name */
    protected String f266144b = "";

    /* renamed from: c, reason: collision with root package name */
    protected String f266145c = "";

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList<ak> f266146d = new ArrayList<>();

    public ArrayList<ak> a() {
        return this.f266146d;
    }

    public String b() {
        return this.f266145c;
    }

    public String c() {
        return this.f266144b;
    }

    public String d() {
        return this.f266143a;
    }

    public void e(ArrayList<ak> arrayList) {
        this.f266146d = arrayList;
    }

    public void f(String str) {
        this.f266145c = str;
    }

    public String toString() {
        return "GWGProExposeRecommedsReq{mUser=" + this.f266143a + "mTraceId=" + this.f266144b + "mStage=" + this.f266145c + "mExposeItems=" + this.f266146d + "}";
    }
}
